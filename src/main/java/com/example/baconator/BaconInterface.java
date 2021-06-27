package com.example.baconator;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public interface BaconInterface {
    LinkedHashSet<String> routeMap = new LinkedHashSet<>();
    Set<String> traversed = new HashSet<>();
}
