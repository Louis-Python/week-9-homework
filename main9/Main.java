package main9;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.FRENCH);
        ChampionshipManager manager = ChampionshipManager.getInstance();

        Driver driver1 = new Driver("Sébastien Ogier", "France");
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland");
        Driver driver3 = new Driver("Ott Tänak", "Estonia");
        Driver driver4 = new Driver("Thierry Neuville", "Belgium");

        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland (Jyväskylä)");
        race1.recordResult(driver1, 25);
        race1.recordResult(driver3, 18);
        race1.recordResult(driver2, 15);
        race1.recordResult(driver4, 12);
        manager.addRaceResult(race1);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally (Monaco)");
        race2.recordResult(driver2, 25);
        race2.recordResult(driver4, 18);
        race2.recordResult(driver1, 15);
        race2.recordResult(driver3, 12);
        manager.addRaceResult(race2);

        manager.displayStandings();

        System.out.println("===== CHAMPIONSHIP LEADER =====");
        Driver leader = manager.getChampionshipLeader();
        System.out.println(leader.getName() + " with " + leader.getTotalPoints() + " points");

        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + manager.getTotalDrivers());
        System.out.println("Total Races: " + manager.getTotalRaces());
        System.out.println("Average Points Per Driver: " + String.format("%.2f", ChampionshipStatistics.averagePointsPerDriver(manager.getDrivers())));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.mostSuccessfulCountry(manager.getDrivers()));
        System.out.println("Total Championship Points: " + manager.getTotalChampionshipPoints());
        
        manager.displayRaceResults();

        System.out.println("===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + CarPerformance.calculateGravelPerformance());
        System.out.println("Asphalt Car Performance: " + CarPerformance.calculateAsphaltPerformance());
    }
}
