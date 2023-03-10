package com.booleanuk.helpers;

import java.util.HashMap;

public class ExerciseBase {
    public String getValue(String key) {
        return key;
    }

    public boolean hasKey(HashMap<String, String> map, String theKey) {
        return false;
    }

    public int getValueOrDefault(HashMap<String,Integer> map, String theKey) {
        return -2;
    }

}
