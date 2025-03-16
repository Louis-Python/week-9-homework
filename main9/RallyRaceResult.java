package main9;

import java.util.*;
import java.util.stream.Collectors;

class RallyRaceResult {
    private String raceName;
    private Map<Driver, Integer> results = new HashMap<>();

    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
    }

    public void recordResult(Driver driver, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    public void displayResults() {
        System.out.println("Race: " + raceName);
        List<Map.Entry<Driver, Integer>> sortedEntries = results.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .collect(Collectors.toList());
        for (int i = 0; i < sortedEntries.size(); i++) {
            Map.Entry<Driver, Integer> entry = sortedEntries.get(i);
            System.out.println(" Position " + (i + 1) + ": " + entry.getKey().getName() + " - " + entry.getValue() + " points");
        }
    }
}




