import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MontyHallParadox {

    public static void main(String[] args) {
        int totalGames = 1000;
        Map<Integer, Boolean> results = new HashMap<>();

        for (int i = 1; i <= totalGames; i++) {
            boolean result = playMontyHall();
            results.put(i, result);
        }

        displayStatistics(results);
    }

    private static boolean playMontyHall() {
        Random random = new Random();
        int prizeDoor = random.nextInt(3) + 1;
        int chosenDoor = random.nextInt(3) + 1;

        int revealedDoor = revealDoor(prizeDoor, chosenDoor);

        // Uncomment the next line to switch doors, or leave it commented to stick with the original choice
        // chosenDoor = switchDoor(chosenDoor, revealedDoor);

        return chosenDoor == prizeDoor;
    }

    private static int revealDoor(int prizeDoor, int chosenDoor) {
        Random random = new Random();
        int doorToReveal;

        do {
            doorToReveal = random.nextInt(3) + 1;
        } while (doorToReveal == prizeDoor || doorToReveal == chosenDoor);

        return doorToReveal;
    }

    private static int switchDoor(int chosenDoor, int revealedDoor) {
        for (int i = 1; i <= 3; i++) {
            if (i != chosenDoor && i != revealedDoor) {
                return i;
            }
        }
        return chosenDoor; // This should never happen
    }

    private static void displayStatistics(Map<Integer, Boolean> results) {
        int wins = 0;
        int losses = 0;

        for (boolean result : results.values()) {
            if (result) {
                wins++;
            } else {
                losses++;
            }
        }

        System.out.println("Monty Hall Paradox Results:");
        System.out.println("Total Games: " + results.size());
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
}
