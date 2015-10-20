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
                .put(new AbstractMap.SimpleEntry<String,Integer>("c", 3))
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
        Map<String,Animal> m = new MapBuilder<String,Animal>(new HashMap<String, Animal>())
                .put("a", new Animal())
                .p("b", d)
                .putAll(new HashMap<String, Dog>())
                .put(new AbstractMap.SimpleEntry<String,Animal>("c", new Animal()))
                .p(new AbstractMap.SimpleEntry<String,Animal>("d", new Dog()))
                // ...
                .build();

        assertThat(m, Matchers.hasKey("a"));
        assertThat(m, Matchers.hasKey("b"));
        assertThat(m, Matchers.hasKey("c"));
        assertThat(m, Matchers.hasKey("d"));

        assertThat(m, Matchers.hasValue(d));

        System.out.println(m);
    }

    @Test
    public void testMapBuilderClass() throws InstantiationException, IllegalAccessException {
        Animal d = new Dog();
        Map<String,Animal> m = new MapBuilder<String, Animal>(HashMap.class)
                .put("a", new Animal())
                .p("b", d)
                .putAll(new HashMap<String, Dog>())
                .put(new AbstractMap.SimpleEntry<String,Animal>("c", new Animal()))
                .p(new AbstractMap.SimpleEntry<String,Animal>("d", new Dog()))
                        // ...
                .build();

        assertThat(m, Matchers.hasKey("a"));
        assertThat(m, Matchers.hasKey("b"));
        assertThat(m, Matchers.hasKey("c"));
        assertThat(m, Matchers.hasKey("d"));

        assertThat(m, Matchers.hasValue(d));

        System.out.println(m);
    }

    @Test
    public void testMapBuilderRemove() throws InstantiationException, IllegalAccessException {
        Map<String,Integer> em = new HashMap<String,Integer>();
        em.put("a", 1);
        Map<String,Integer> m = new MapBuilder<String,Integer>(em)
                .remove("a", 1)
                .build();

        assertThat(m.keySet(), Matchers.empty());
        assertThat(m.values(), Matchers.empty());

        System.out.println(m);
    }

}
