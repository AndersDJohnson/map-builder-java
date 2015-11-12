# map-builder-java

[ ![Download](https://api.bintray.com/packages/AndersDJohnson/maven/map-builder/images/download.svg) ][download]

[Fluent][] [builder][] for `Map`s in Java.

Easily initialize or modify [`java.util.Map`][map] instances with a [DRY][], [fluent][]-style [builder pattern][builder].
No more repeated variable names, [static or instance initializer blocks][initblocks], or [double brace initialization][2brace].

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
  .remove( k2 )
  // ...
  .build();
```

Or, choose a `Map` implementation by passing its class:

```java
Map<String, Integer> m = new MapBuilder<String, Integer>(LinkedHashMap.class)
  // ...
  .build();
```

Or, pass an existing map to be modified. This also allows choice of `Map` implementation:

```java
Map<String, Integer> m = new MapBuilder<String, Integer>(new LinkedHashMap<String, Integer>())
  // ...
  .build();
```

# Install

## Maven

```xml
<repositories>
    <repository>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
        <id>bintray-AndersDJohnson-maven</id>
        <name>bintray-AndersDJohnson-maven</name>
        <url>https://dl.bintray.com/AndersDJohnson/maven</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>me.andrz</groupId>
        <artifactId>map-builder</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

## Gradle

```gradle
repositories {
    maven {
        url  "https://dl.bintray.com/AndersDJohnson/maven"
    }
}

dependencies {
    compile 'me.andrz:map-builder:1.0.0'
}
```

## Manual

[Download JAR from BinTray][download].

## References
* [Apache Commons Collections MapUtils#putAll][maputils-putall]
* [Guava ImmutableMap.Builder][guava-builder]
* http://minborgsjavapot.blogspot.com/2014/12/java-8-initializing-maps-in-smartest-way.html
* https://docs.atlassian.com/jira/6.4.1/com/atlassian/jira/util/collect/MapBuilder.html
* http://stackoverflow.com/a/8879328/851135
* http://stackoverflow.com/a/7345751/851135
* http://stackoverflow.com/a/12228431
* Initialize with list of Objects: https://gist.github.com/shunirr/4577191
* Fluent API for Maps: https://gist.github.com/eeichinger/4442854
* https://code.google.com/p/fluentjava/wiki/GettingStarted#Maps

[maputils-putall]: https://commons.apache.org/proper/commons-collections/apidocs/org/apache/commons/collections4/MapUtils.html#putAll%28java.util.Map,%20java.lang.Object%5B%5D%29
[guava-builder]: http://docs.guava-libraries.googlecode.com/git/javadoc/com/google/common/collect/ImmutableMap.Builder.html
[fluent]: https://en.wikipedia.org/wiki/Fluent_interface
[builder]: https://en.wikipedia.org/wiki/Builder_pattern
[DRY]: https://en.wikipedia.org/wiki/Don%27t_repeat_yourself
[2brace]: http://c2.com/cgi/wiki?DoubleBraceInitialization
[initblocks]: https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
[map]: https://docs.oracle.com/javase/7/docs/api/java/util/Map.html
[download]: https://bintray.com/artifact/download/AndersDJohnson/maven/me/andrz/map-builder/1.0.0/map-builder-1.0.0.jar
