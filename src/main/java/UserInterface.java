import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class UserInterface {
    private final Scanner scanner;
    private static final int OFFSET_FROM_DISPLAY = 1;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public int getMenuOption(boolean isGameBoardEmpty) {
        System.out.println("Select option by adding number:");
        System.out.println("0 - Exit");
        System.out.println("1 - Get a summary of games by total score");
        System.out.println("2 - Start a game");
        if(!isGameBoardEmpty) {
            System.out.println("3 - Finish a game");
            System.out.println("4 - Update score");
        }
        return readInt("Enter your choice: ");
    }

    public String readTeamName(String prompt) {
        while (true) {
            System.out.print(prompt);
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            }
            System.out.println("Team name cannot be empty. Please enter a valid name.");
        }
    }

    public int readScore(String prompt) {
        return readInt(prompt);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int selectGameIndex(int maxIndex) {
        while (true) {
            int index = readInt("Select game number: ")-OFFSET_FROM_DISPLAY;
            if (index >= 0 && index < maxIndex) {
                return index;
            }
            System.out.println("Invalid selection. Please select a valid game number.");
        }
    }

    public void displayGamesList(List<Game> games) {
        IntStream.range(0, games.size())
                .forEach(i -> System.out.println(i + OFFSET_FROM_DISPLAY + ". " + games.get(i)));
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}
