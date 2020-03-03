package com.fatmanur.expenset.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Location {
    Turkey,China,Brazil;
    private static Map<String, Location> namesMap = new HashMap<String, Location>(3);

    static {
        namesMap.put("Turkey", Turkey);
        namesMap.put("China", China);
    }

    @JsonCreator
    public static Location forValue(String value) {
        return namesMap.get(value);
    }

    @JsonValue
    public String toValue() {
        for (Map.Entry<String, Location> entry : namesMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }

        return "China"; // or fail
    }
    }

