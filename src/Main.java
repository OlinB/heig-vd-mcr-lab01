import chrono.Chrono;
import ui.DialManager;
/**
 * @author Olin Bourquin
 * @author Jonas Troeltsch
 * @version 1.0
 * @since 2024-02-22
 */
public class Main {
    public static void main(String[] args) {
        int nbChronos = 0;

        if (args.length != 1) {
            System.out.println("Usage: java Main <nbChronos>");
            System.exit(1);
        }

        try {
            nbChronos = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Usage: java Main <nbChronos>");
            System.exit(1);
        }
        if (nbChronos < 1 || nbChronos > 9) {
            System.out.println("Le nombre de chronos doit être compris entre 1 et 9");
            System.exit(1);
        }
        new DialManager(nbChronos);
    }
}