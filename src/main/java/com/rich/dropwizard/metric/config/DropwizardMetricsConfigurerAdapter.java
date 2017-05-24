package com.rich.dropwizard.metric.config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.elasticsearch.metrics.ElasticsearchReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import com.codahale.metrics.servlets.AdminServlet;
import com.rich.dropwizard.metric.listener.MetricsServletContextListener;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;

import io.dropwizard.util.Duration;

/**
 * 
 * @author rich
 *
 */
@Configuration
@EnableMetrics
public class DropwizardMetricsConfigurerAdapter extends MetricsConfigurerAdapter{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DropwizardMetricsConfigurerAdapter.class);
    
    @Autowired
    private MetricRegistry metricRegistry;
    
    @Autowired
    private HealthCheckRegistry healthCheckRegistry;
    
    @Autowired
    private ElasticsearchReportProp elasticsearchProp;
    
    @PostConstruct
    public void init() {
        configureReporters(metricRegistry);
    }
    
    @Bean
    public MetricsServletContextListener metricsServletContextListener(MetricRegistry metricRegistry, HealthCheckRegistry healthCheckRegistry) {
        return new MetricsServletContextListener(metricRegistry, healthCheckRegistry);
    }
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new AdminServlet(), "/dropwizard/*");
    }
    
    /**
     * Configure reporters.
     */
    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        metricRegistry.register("jvm.memory", new MemoryUsageGaugeSet());
        metricRegistry.register("jvm.thread-states", new ThreadStatesGaugeSet());
        metricRegistry.register("jvm.gc", new GarbageCollectorMetricSet());
        
        System.out.println(elasticsearchProp);
        registerElasticsearchExporter(metricRegistry);

        //log to console for testing purposes
        ConsoleReporter.forRegistry(metricRegistry).build().start(5, TimeUnit.SECONDS);
    }
    
    private void registerElasticsearchExporter(MetricRegistry metricRegistry) {
        try {
            ElasticsearchReporter reporter = ElasticsearchReporter.forRegistry(metricRegistry)
                    .hosts(elasticsearchProp.getHosts())
                    .index(elasticsearchProp.getIndex())
                    .indexDateFormat(elasticsearchProp.getIndexDateFormat())
                    .build();
            
            Duration duration = Duration.parse(elasticsearchProp.getFrequency());
            LOGGER.info("Elasticsearch Exporter frequency: {}", duration);
            
            reporter.start(duration.getQuantity(), duration.getUnit());
        } catch (IOException ex) {
            LOGGER.error("Register ElasticsearchExporter error!", ex);
        }
    }
}
