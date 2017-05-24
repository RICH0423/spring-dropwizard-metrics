## spring-dropwizard-metrics

[Project Web site](https://rich0423.github.io/spring-dropwizard-metrics/)

The project show how to measure your Spring application and report metrics data into elasticsearch.

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
./gradlew clean build && java -jar build/libs/spring-dropwizard-metrics-0.0.1.jar
```

### Request metrics endpoints
```bash
curl localhost:9001/metrics
```

Response:
```json
{
  mem: 366861,
  mem.free: 226984,
  processors: 8,
  instance.uptime: 10083,
  uptime: 25626,
  systemload.average: 1.76171875,
  heap.committed: 311296,
  heap.init: 262144,
  heap.used: 84311,
  heap: 3728384,
  nonheap.committed: 56664,
  nonheap.init: 2496,
  nonheap.used: 55566,
  nonheap: 0,
  threads.peak: 37,
  threads.daemon: 5,
  threads.totalStarted: 42,
  threads: 37,
  classes: 7129,
  classes.loaded: 7129,
  classes.unloaded: 0,
  gc.ps_scavenge.count: 16,
  gc.ps_scavenge.time: 78,
  gc.ps_marksweep.count: 2,
  gc.ps_marksweep.time: 117,
  jvm.thread-states.count: 37,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.75thPercentile: 0,
  jvm.memory.pools.Compressed-Class-Space.usage: 0.004474326968193054,
  jvm.memory.non-heap.used: 56919680,
  com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.75thPercentile: 0,
  jvm.thread-states.daemon.count: 5,
  jvm.memory.total.used: 144227176,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.meanRate: 0,
  com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.95thPercentile: 0,
  com.rich.dropwizard.metric.controller.GreetingController.index.oneMinuteRate: 0,
  jvm.memory.pools.PS-Old-Gen.usage: 0.006301097667335111,
  jvm.memory.pools.PS-Survivor-Space.init: 11010048,
  com.rich.dropwizard.metric.controller.GreetingController.index.fifteenMinuteRate: 0,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.95thPercentile: 0,
  jvm.memory.non-heap.usage: -56911936,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.oneMinuteRate: 0,
  jvm.memory.total.max: 3817865215,
  jvm.memory.non-heap.max: -1,
  jvm.thread-states.new.count: 0,
  jvm.memory.pools.PS-Old-Gen.committed: 159383552,
  counter.status.404.error: 1,
  jvm.memory.pools.Metaspace.max: -1,
  com.rich.dropwizard.metric.controller.GreetingController.index.meanRate: 0,
  jvm.memory.pools.Compressed-Class-Space.used: 4804272,
  jvm.thread-states.waiting.count: 7,
  jvm.memory.pools.Metaspace.usage: 0.9787205540475167,
  com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.98thPercentile: 0,
  jvm.memory.pools.PS-Survivor-Space.used: 0,
  jvm.memory.pools.Code-Cache.max: 251658240,
  com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.999thPercentile: 0,
  jvm.memory.total.init: 270991360,
  jvm.memory.pools.Code-Cache.committed: 14942208,
  jvm.memory.non-heap.init: 2555904,
  jvm.memory.heap.committed: 318767104,
  jvm.memory.pools.PS-Survivor-Space.committed: 13631488,
  jvm.memory.pools.PS-Old-Gen.init: 179306496,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.fifteenMinuteRate: 0,
  com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.mean: 0,
  com.rich.dropwizard.metric.controller.GreetingController.index.fiveMinuteRate: 0,
  jvm.memory.pools.Code-Cache.used: 14815168,
  jvm.memory.pools.Metaspace.used: 37292496,
  jvm.memory.pools.PS-Survivor-Space.max: 13631488,
  jvm.memory.heap.init: 268435456,
  jvm.memory.total.committed: 376791040,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.99thPercentile: 0,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.stdDev: 0,
  jvm.memory.pools.Compressed-Class-Space.init: 0,
  jvm.memory.pools.PS-Eden-Space.committed: 145752064,
  jvm.memory.pools.PS-Eden-Space.init: 67108864,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.mean: 0,
  jvm.memory.pools.PS-Eden-Space.used: 69262136,
  com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.99thPercentile: 0,
  jvm.memory.non-heap.committed: 58023936,
  jvm.memory.pools.PS-Survivor-Space.usage: 0,
  jvm.gc.PS-MarkSweep.count: 2,
  jvm.memory.pools.Code-Cache.init: 2555904,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.fiveMinuteRate: 0,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.min: 0,
  jvm.thread-states.timed_waiting.count: 13,
  jvm.memory.pools.Code-Cache.usage: 0.058870188395182294,
  jvm.memory.pools.Metaspace.committed: 38100992,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.98thPercentile: 0,
  jvm.thread-states.terminated.count: 0,
  jvm.memory.pools.Compressed-Class-Space.max: 1073741824,
  jvm.memory.pools.PS-Eden-Space.usage: 0.04933048558822757,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.999thPercentile: 0,
  jvm.memory.pools.PS-Old-Gen.used: 18044208,
  jvm.memory.pools.Metaspace.init: 0,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.median: 0,
  jvm.memory.pools.PS-Eden-Space.max: 1404043264,
  jvm.thread-states.runnable.count: 17,
  com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.median: 0,
  jvm.memory.heap.usage: 0.02261329489532194,
  jvm.thread-states.blocked.count: 0,
  gauge.response.error: 408,
  jvm.gc.PS-MarkSweep.time: 117,
  jvm.gc.PS-Scavenge.count: 16,
  jvm.memory.heap.max: 3817865216,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.max: 0,
  com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.min: 0,
  jvm.memory.heap.used: 87306344,
  jvm.thread-states.deadlock.count: 0,
  jvm.memory.pools.PS-Old-Gen.max: 2863661056,
  com.rich.dropwizard.metric.controller.GreetingController.index.count: 0,
  com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.stdDev: 0,
  com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.max: 0,
  jvm.gc.PS-Scavenge.time: 78,
  jvm.memory.pools.Compressed-Class-Space.committed: 4980736,
  com.rich.dropwizard.metric.controller.GreetingController.greeting.count: 0
}
```

