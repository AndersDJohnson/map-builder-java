package me.andrz.builder.map;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;

/**
 *
 */
public class MapBuilderTest {

    private static class Animal {}
    private static class Dog extends Animal {}

    @Test
    public void testMapBuilder() {
        Map<String,Integer> m = new MapBuilder<String,Integer>()
                .put("a", 1)
                .p("b", 2)
                .putAll(new HashMap<String, Integer>())
                .put(new AbstractMap.SimpleEntry<>("c", 3))
                // ...
                .build();

        assertThat(m, Matchers.hasKey("a"));
        assertThat(m, Matchers.hasKey("b"));
        assertThat(m, Matchers.hasKey("c"));

        assertThat(m, Matchers.hasValue(1));

        System.out.println(m);
    }

    @Test
    public void testMapBuilderExtends() {
        Animal d = new Dog();
        Map<String,Animal> m = new MapBuilder<>(new HashMap<String, Animal>())
                .put("a", new Animal())
                .p("b", d)
                .putAll(new HashMap<String, Dog>())
                .put(new AbstractMap.SimpleEntry<>("c", new Animal()))
                .p(new AbstractMap.SimpleEntry<>("d", new Dog()))
                // ...
                .build();

        assertThat(m, Matchers.hasKey("a"));
        assertThat(m, Matchers.hasKey("b"));
        assertThat(m, Matchers.hasKey("c"));
        assertThat(m, Matchers.hasKey("d"));

        assertThat(m, Matchers.hasValue(d));

        System.out.println(m);
    }

}
