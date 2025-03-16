package main9;

import java.util.*;

class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> raceResults = new ArrayList<>();

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void addRaceResult(RallyRaceResult result) {
        raceResults.add(result);
    }

    public int getTotalDrivers() {
        return drivers.size();
    }

    public int getTotalRaces() {
        return raceResults.size();
    }

    public int getTotalChampionshipPoints() {
        return drivers.stream().mapToInt(Driver::getTotalPoints).sum();
    }

    public Driver getChampionshipLeader() {
        return drivers.stream().max(Comparator.comparingInt(Driver::getTotalPoints)).orElse(null);
    }

    public void displayStandings() {
        drivers.sort((d1, d2) -> Integer.compare(d2.getTotalPoints(), d1.getTotalPoints()));
        for (int i = 0; i < drivers.size(); i++) {
            System.out.println((i + 1) + ". " + drivers.get(i).getName() + " (" + drivers.get(i).getCountry() + "): " + drivers.get(i).getTotalPoints() + " points");
        }
    }

    public void displayRaceResults() {
        System.out.println("===== RACE RESULTS =====");
        for (RallyRaceResult race : raceResults) {
            race.displayResults();
        }
    }
}
