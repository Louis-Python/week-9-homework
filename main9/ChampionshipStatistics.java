package main9;

import java.util.*;
import java.util.stream.Collectors;

class ChampionshipStatistics {
    public static double averagePointsPerDriver(List<Driver> drivers) {
        return drivers.stream()
                .mapToInt(Driver::getTotalPoints)
                .average()
                .orElse(0.0);
    }

    public static String mostSuccessfulCountry(List<Driver> drivers) {
        return drivers.stream()
                .collect(Collectors.groupingBy(
                        Driver::getCountry,
                        Collectors.summingInt(Driver::getTotalPoints)
                ))
                .entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Unknown");
    }
}