
import java.util.Scanner;

public class Run {

    private static int numberOfOperation = 0;

    public static void main(String[] args) {
        recursion("slot_a", "slot_b", "slot_c", getUserInput());
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of plates:");
        int userInput = scanner.nextInt();
        while (userInput > 8 || userInput == 0) {
            System.out.println("Value must be between 1 an 8! Enter again:");
            userInput = scanner.nextInt();
        }
        return userInput;
    }

    /**
     * Шанхайские пиармиды на произвольное количество плит
     *
     * @param slot_a имя слота
     * @param slot_b имя промежуточного места хранения
     * @param slot_c имя второго слота
     * @param numberOfPlates количество плит для перекладывания
     */
    public static void recursion(String slot_a, String slot_b, String slot_c, int numberOfPlates) {
        if (numberOfPlates == 1) {
            numberOfOperation++;
            System.out.println(numberOfOperation + " #" + numberOfPlates + " " + slot_a + " -> " + slot_c);
        } else {
            recursion(slot_a, slot_c, slot_b, numberOfPlates - 1);
            numberOfOperation++;
            System.out.println(numberOfOperation + " #" + numberOfPlates + " " + slot_a + " -> " + slot_c);
            recursion(slot_b, slot_a, slot_c, numberOfPlates - 1);
        }
    }
}
