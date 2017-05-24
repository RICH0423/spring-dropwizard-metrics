## spring-dropwizard-metrics

[Project Web site](https://rich0423.github.io/spring-dropwizard-metrics/)

The project is base on Spring Boot, that show how to measure your application and report metrics data into elasticsearch.

spring-dropwizard-metrics integrates Dropwizard Metrics library with metrics-spring module, and Metrics Elasticsearch Reporter.

---

### Dependency library
spring-dropwizard-metrics integrates Dropwizard Metrics library with metrics-spring module, and Metrics Elasticsearch Reporter.

* [Dropwizard Metrics](http://metrics.dropwizard.io/)
* [metrics-spring](http://metrics.ryantenney.com/)
* [Metrics Elasticsearch Reporter](https://github.com/elastic/elasticsearch-metrics-reporter-java)

### Elasticsearch Configuration
You can config your Elasticsearch host and index information from `application.yml`.

```yaml
elasticsearch.reporter:
  hosts: 
    - localhost:9200
  index: dropwizard
  indexDateFormat: yyyy.MM.dd
  frequency: 60s
```

### Build and run 
You must start the [Elasticsearch](https://www.elastic.co/) before executing the program

Build the project and execute JAR
```bash
./gradlew clean build && java -jar build/libs/spring-dropwizard-metirc-0.0.1.jar
```
