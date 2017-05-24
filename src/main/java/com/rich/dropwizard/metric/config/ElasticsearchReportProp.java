package com.rich.dropwizard.metric.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 
 * @author rich
 *
 */
@Component
@ConfigurationProperties(prefix="elasticsearch.reporter")
public class ElasticsearchReportProp {
    
    private String[] hosts;
    private String index;
    private String indexDateFormat;
    private String frequency;
    
    
    public String[] getHosts() {
        return hosts;
    }
    public void setHosts(String[] hosts) {
        this.hosts = hosts;
    }
    public String getIndex() {
        return index;
    }
    public void setIndex(String index) {
        this.index = index;
    }
    public String getIndexDateFormat() {
        return indexDateFormat;
    }
    public void setIndexDateFormat(String indexDateFormat) {
        this.indexDateFormat = indexDateFormat;
    }
    public String getFrequency() {
        return frequency;
    }
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    
    @Override
    public String toString() {
        return "ElasticsearchReportProp [hosts=" + hosts + ", index=" + index + ", indexDateFormat=" + indexDateFormat
                + ", frequency=" + frequency + "]";
    }
    
}
