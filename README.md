# map-builder-java
Builder for Maps.

Fluently initialize Maps with the builder pattern.
No more repeated variable names, static or instance initializer blocks, or double brace initialization.

## Use

Build a new map (`HashMap` by default):

```java
Map<String, Integer> m = new MapBuilder<String, Integer>()
  .put( k1, v1 )
  .p( k2, v2 )
  .putAll( otherMap )
  .pa( otherMap2 )
  .put( mapEntry )
  .p( mapEntry2 )
  // ...
  .build();
```

Or, choose a `Map` implementation by passing its class:

```java
Map<String, Integer> m = new MapBuilder<String, Integer>(LinkedHashMap.class)
  // ...
  .build();
```

Or, pass an existing map. Also allows choice of `Map` implementation:

```java
Map<String, Integer> m = new MapBuilder<>(new LinkedHashMap<String, Integer>())
  // ...
  .build();
```

## References
* [Guava ImmutableMap.Builder](guava-builder)
* http://minborgsjavapot.blogspot.com/2014/12/java-8-initializing-maps-in-smartest-way.html
* https://docs.atlassian.com/jira/6.4.1/com/atlassian/jira/util/collect/MapBuilder.html
* http://stackoverflow.com/a/8879328/851135
* http://stackoverflow.com/a/7345751/851135
* http://stackoverflow.com/a/12228431
* Initialize with list of Objects: https://gist.github.com/shunirr/4577191

[guava-builder]: http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/collect/ImmutableMap.Builder.html
