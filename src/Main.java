import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map universe = new Map();
        int size = sc.nextInt();
        //long seed = sc.nextLong();
        int gen = 10;
        char[][] myMap;
        myMap = universe.startMap(size);

        if (gen < 1) {
            System.out.println("Generation #" + gen);
            for (char[] chars : myMap) {
                for (int j = 0; j < myMap.length; j++) {
                    System.out.print(chars[j]);
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < gen; i++) {

                myMap = universe.afterMap(myMap);
                int lives = 0;

                for (char[] chars : myMap) {
                    for (int j = 0; j < myMap.length; j++) {
                        if (chars[j] == 'O') {
                            lives++;
                        }
                    }
                    System.out.println();
                }
                System.out.println("Generation #" + (i+1));
                System.out.println("Alive: " + lives);

                for (char[] chars : myMap) {
                    for (int j = 0; j < myMap.length; j++) {
                        System.out.print(chars[j]);
                    }
                    System.out.println();
                }

                try {
                    if (System.getProperty("os.name").contains("Windows")) {
                        Thread.sleep(1000);
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                    }
                    else {

                        Runtime.getRuntime().exec("clear");
                    }
                }
                catch (IOException | InterruptedException e) {}
                System.out.println();
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
