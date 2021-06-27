package com.example.baconator;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public interface BaconInterface {
    // The LinkedHashSet ensures our data can be tracked in order
    LinkedHashSet<String> routeMap = new LinkedHashSet<>();

    // This Set helps to track nodes we have already visited
    Set<String> traversed = new HashSet<>();
}
