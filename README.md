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
   "mem":368956,
   "mem.free":250590,
   "processors":8,
   "instance.uptime":5695,
   "uptime":21099,
   "systemload.average":1.6630859375,
   "heap.committed":313856,
   "heap.init":262144,
   "heap.used":63265,
   "heap":3728384,
   "nonheap.committed":56408,
   "nonheap.init":2496,
   "nonheap.used":55101,
   "nonheap":0,
   "threads.peak":33,
   "threads.daemon":5,
   "threads.totalStarted":37,
   "threads":33,
   "classes":6999,
   "classes.loaded":6999,
   "classes.unloaded":0,
   "gc.ps_scavenge.count":16,
   "gc.ps_scavenge.time":79,
   "gc.ps_marksweep.count":2,
   "gc.ps_marksweep.time":114,
   "jvm.memory.pools.Compressed-Class-Space.used":4718008,
   "com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.min":0,
   "jvm.memory.pools.PS-Survivor-Space.used":0,
   "com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.98thPercentile":0,
   "jvm.memory.pools.Compressed-Class-Space.usage":0.0043939873576164246,
   "jvm.memory.non-heap.used":56432912,
   "jvm.memory.pools.Compressed-Class-Space.max":1073741824,
   "jvm.memory.heap.init":268435456,
   "jvm.memory.pools.Metaspace.init":0,
   "jvm.thread-states.timed_waiting.count":13,
   "jvm.memory.pools.Code-Cache.used":15016832,
   "jvm.memory.non-heap.usage":-5.6429016E7,
   "com.rich.dropwizard.metric.controller.GreetingController.index.fifteenMinuteRate":0.0,
   "jvm.memory.pools.Code-Cache.committed":15204352,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.oneMinuteRate":0.0,
   "jvm.memory.pools.PS-Eden-Space.max":1404043264,
   "jvm.memory.heap.max":3817865216,
   "jvm.memory.pools.PS-Eden-Space.used":48780256,
   "com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.median":0,
   "com.rich.dropwizard.metric.controller.GreetingController.index.count":0,
   "com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.mean":0,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.median":0,
   "jvm.memory.heap.used":66846568,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.98thPercentile":0,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.min":0,
   "jvm.memory.total.init":270991360,
   "jvm.memory.pools.PS-Old-Gen.committed":153092096,
   "jvm.memory.pools.Metaspace.max":-1,
   "jvm.thread-states.terminated.count":0,
   "jvm.thread-states.daemon.count":5,
   "jvm.gc.PS-MarkSweep.count":2,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.max":0,
   "jvm.memory.pools.PS-Old-Gen.init":179306496,
   "jvm.thread-states.waiting.count":3,
   "jvm.memory.pools.Compressed-Class-Space.init":0,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.95thPercentile":0,
   "jvm.memory.pools.PS-Eden-Space.init":67108864,
   "jvm.memory.pools.PS-Survivor-Space.max":13631488,
   "jvm.memory.pools.PS-Eden-Space.committed":154664960,
   "com.rich.dropwizard.metric.controller.GreetingController.index.fiveMinuteRate":0.0,
   "com.rich.dropwizard.metric.controller.GreetingController.index.meanRate":0.0,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.stdDev":0,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.99thPercentile":0,
   "jvm.memory.pools.PS-Survivor-Space.init":11010048,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.fiveMinuteRate":0.0,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.mean":0,
   "com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.999thPercentile":0,
   "jvm.thread-states.runnable.count":17,
   "jvm.memory.heap.usage":0.017238787719424824,
   "jvm.memory.pools.PS-Old-Gen.used":18066312,
   "jvm.memory.pools.PS-Survivor-Space.committed":13631488,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.fifteenMinuteRate":0.0,
   "jvm.thread-states.count":33,
   "jvm.memory.total.committed":379150336,
   "jvm.memory.pools.Metaspace.used":36694176,
   "jvm.memory.pools.PS-Old-Gen.usage":0.006308816457920919,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.meanRate":0.0,
   "com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.95thPercentile":0,
   "jvm.memory.non-heap.init":2555904,
   "jvm.thread-states.new.count":0,
   "jvm.gc.PS-Scavenge.count":16,
   "jvm.memory.total.used":123279480,
   "com.rich.dropwizard.metric.controller.GreetingController.index.oneMinuteRate":0.0,
   "jvm.memory.non-heap.max":-1,
   "jvm.memory.pools.Code-Cache.max":251658240,
   "com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.99thPercentile":0,
   "jvm.memory.pools.Metaspace.committed":37576704,
   "jvm.memory.non-heap.committed":57761792,
   "jvm.memory.pools.Code-Cache.usage":0.05966873168945312,
   "jvm.thread-states.deadlock.count":0,
   "jvm.memory.heap.committed":321388544,
   "jvm.memory.pools.Metaspace.usage":0.9765122561042076,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.75thPercentile":0,
   "com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.75thPercentile":0,
   "com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.max":0,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.snapshot.999thPercentile":0,
   "jvm.memory.pools.Compressed-Class-Space.committed":4980736,
   "jvm.gc.PS-MarkSweep.time":114,
   "jvm.memory.pools.Code-Cache.init":2555904,
   "com.rich.dropwizard.metric.controller.GreetingController.greeting.count":0,
   "jvm.memory.pools.PS-Survivor-Space.usage":0.0,
   "jvm.memory.total.max":3817865215,
   "com.rich.dropwizard.metric.controller.GreetingController.index.snapshot.stdDev":0,
   "jvm.thread-states.blocked.count":0,
   "jvm.gc.PS-Scavenge.time":79,
   "jvm.memory.pools.PS-Old-Gen.max":2863661056,
   "jvm.memory.pools.PS-Eden-Space.usage":0.0347427014898595
}
```

