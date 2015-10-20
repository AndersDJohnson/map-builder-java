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
        this.map = new HashMap<K, V>();
    }

    @SuppressWarnings("unchecked")
    public MapBuilder(Class<? extends Map> c) throws IllegalAccessException, InstantiationException {
        this.map = c.newInstance();
    }

    public MapBuilder(Map<K,V> m) {
        this.map = m;
    }

    public MapBuilder<K,V> put(K k, V v) {
        map.put(k, v);
        return this;
    }

    public MapBuilder<K,V> p(K k, V v) {
        return put(k, v);
    }

    public MapBuilder<K,V> put(Map.Entry<? extends K, ? extends V>e) {
        return put(e.getKey(), e.getValue());
    }

    public MapBuilder<K,V> p(Map.Entry<? extends K, ? extends V> e) {
        return put(e);
    }

    public MapBuilder<K,V> putAll(Map<? extends K, ? extends V> m) {
        map.putAll(m);
        return this;
    }

    public MapBuilder<K,V> pa(Map<? extends K, ? extends V> m) {
        return putAll(m);
    }

    public MapBuilder<K,V> remove(K k) {
        map.remove(k);
        return this;
    }

    public MapBuilder<K,V> r(K k) {
        return remove(k);
    }

    public MapBuilder<K,V> remove(Map.Entry<? extends K, ? extends V>e) {
        return remove(e.getKey());
    }

    public MapBuilder<K,V> r(Map.Entry<? extends K, ? extends V> e) {
        return remove(e);
    }

    public Map<K,V> build() {
        return map;
    }
}
