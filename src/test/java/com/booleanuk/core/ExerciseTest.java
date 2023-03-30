package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class ExerciseTest {
    Exercise exercise;

    public ExerciseTest() {
        this.exercise = new Exercise();
    }

    @Test
    public void shouldReturnMappedValues() {
        Assertions.assertEquals("Nathan", this.exercise.getValue("firstName"));
        Assertions.assertEquals("King", this.exercise.getValue("lastName"));
        Assertions.assertEquals("Software Developer", this.exercise.getValue("occupation"));
    }

    @Test
    public void shouldHaveKey() {
        HashMap<String, String> map = new HashMap<>(){{
            put("name", "Joe");
            put("vocation", "Artist");
        }};

        Assertions.assertTrue(this.exercise.hasKey(map, "vocation"));
        Assertions.assertFalse(this.exercise.hasKey(map, "wubbalubbadubdub"));
    }

    @Test
    public void shouldDefault() {
        HashMap<String, Integer> map = new HashMap<>(){{
            put("age", 32);
            put("heightFeet", 6);
        }};

        Assertions.assertEquals(32, this.exercise.getValueOrDefault(map, "age"));
        Assertions.assertEquals(6, this.exercise.getValueOrDefault(map, "heightFeet"));
        Assertions.assertEquals(-1, this.exercise.getValueOrDefault(map, "score"));
    }

    @Test
    public void shouldBuildSecret() {
        ArrayList<Integer> list1 = new ArrayList<>(){{
            add(42);
            add(6712);
            add(7);
        }};
        ArrayList<String> result1 = this.exercise.buildSecretPhrase(list1);
        Assertions.assertEquals(3, result1.size());
        Assertions.assertEquals("universe", result1.get(0));
        Assertions.assertEquals("bass", result1.get(1));
        Assertions.assertEquals("muse", result1.get(2));

        ArrayList<Integer> list2 = new ArrayList<>(){{
            add(23);
            add(19);
            add(96);
            add(23);
            add(165);
        }};
        ArrayList<String> result2 = this.exercise.buildSecretPhrase(list2);
        Assertions.assertEquals(4, result2.size());
        Assertions.assertEquals("chicken", result2.get(0));
        Assertions.assertEquals("nice", result2.get(1));
        Assertions.assertEquals("chicken", result2.get(2));
        Assertions.assertEquals("soup", result2.get(3));

        ArrayList<Integer> list3 = new ArrayList<>(){{
            add(918);
            add(71);
            add(88);
        }};
        ArrayList<String> result3 = this.exercise.buildSecretPhrase(list3);
        Assertions.assertEquals(0, result3.size());
    }
}
