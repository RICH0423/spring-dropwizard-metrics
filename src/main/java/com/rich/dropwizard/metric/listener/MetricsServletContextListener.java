package com.rich.dropwizard.metric.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;
import com.codahale.metrics.servlets.HealthCheckServlet;
import com.codahale.metrics.servlets.MetricsServlet;

/**
 * Register HealthCheckServlet and MetricsServlet when web application initialized.
 * 
 * @author rich
 *
 */
public class MetricsServletContextListener implements ServletContextListener {

    private MetricRegistry metricRegistry;
    private HealthCheckRegistry healthCheckRegistry;

    public MetricsServletContextListener(MetricRegistry metricRegistry, HealthCheckRegistry healthCheckRegistry) {
        this.metricRegistry = metricRegistry;
        this.healthCheckRegistry = healthCheckRegistry;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute(HealthCheckServlet.HEALTH_CHECK_REGISTRY,
                healthCheckRegistry);
        servletContextEvent.getServletContext().setAttribute(MetricsServlet.METRICS_REGISTRY, metricRegistry);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
