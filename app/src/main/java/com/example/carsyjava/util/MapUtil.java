package com.example.carsyjava.util;

import java.util.Map;
import java.util.Objects;

public final class MapUtil {
    private MapUtil() {
    }

    public static int getKeyByValue(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (Objects.equals("Odległość", entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
