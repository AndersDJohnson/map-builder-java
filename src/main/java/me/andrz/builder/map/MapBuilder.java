package me.andrz.builder.map;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * http://docs.guava-libraries.googlecode.com/git/javadoc/src-html/com/google/common/collect/ImmutableMap.Builder.html#line.217
 */
public class MapBuilder<K,V> {

    private Map<K, V> map;

    public MapBuilder() {
        this.map = new HashMap<>();
    }

    public MapBuilder(Map<K,V> m) {
        this.map = m;
    }

    public MapBuilder<K,V> p(K k, V v) {
        return put(k, v);
    }

    public MapBuilder<K,V> put(K k, V v) {
        map.put(k, v);
        return this;
    }

    public MapBuilder<K,V> p(Map.Entry<? extends K, ? extends V> e) {
        return put(e);
    }

    public MapBuilder<K,V> put(Map.Entry<? extends K, ? extends V>e) {
        map.put(e.getKey(), e.getValue());
        return this;
    }

    public MapBuilder<K,V> pa(Map<? extends K, ? extends V> m) {
        return putAll(m);
    }

    public MapBuilder<K,V> putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
        return this;
    }

    public Map<K,V> build() {
        return map;
    }
}
