# map-builder-java
Builder for Maps.

## Use

```java
Map<String, String> map = new HashMapBuilder<>()
  .put(k1, v1)
  .putAll(otherMap)
  .put(mapEntry)
  // ...
  .build();
```

## References
* [Guava ImmutableMap.Builder](guava-builder)
* http://stackoverflow.com/a/7345751/851135
* http://stackoverflow.com/a/12228431

[guava-builder]: http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/collect/ImmutableMap.Builder.html
