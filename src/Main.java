import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;

public class Main extends JFrame {
    private static int size = 20;
    private static char[][] myMap = startMap(size);

    public static class graphics1 extends JPanel {
        graphics1() {
            setPreferredSize(new Dimension(420, 500));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < myMap.length; i++) {
                for (int j = 0; j < myMap.length; j++) {
                    if (myMap[i][j] == 'O') {
                        g.setColor(Color.BLACK);
                        g.fillRect((i * 20) + 5, (j * 20) + 3, 20, 20);
                    } else {
                        g.setColor(Color.BLACK);
                        g.drawRect((i * 20) + 5, (j * 20) + 3, 20, 20);
                    }
                }
            }

        }
    }

    public Main() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JLabel generationLabel = new JLabel("Generation #0");
        generationLabel.setName("GenerationLabel");
        JLabel aliveLabel = new JLabel("Alive: 0");
        aliveLabel.setName("AliveLabel");

        panel.add(generationLabel);
        panel.add(aliveLabel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        frame.setSize(425, 480);
        //panel.add(new graphics());

        frame.add(panel);


        frame.setTitle("Game Of Life");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);

        panel.add(new graphics1());
        //long seed = sc.nextLong();
        int gen = 20;
        for (int i = 0; i < gen; i++) {

            myMap = afterMap(myMap);
            int lives = 0;



            for (char[] chars : myMap) {
                for (int j = 0; j < myMap.length; j++) {
                    if (chars[j] == 'O') {
                        lives++;

                    }
                }
                //System.out.println();
            }
            //System.out.println("Generation #" + (i + 1));
            generationLabel.setText("Generation #" + (i + 1));

            //System.out.println("Alive: " + lives);
            aliveLabel.setText("Alive: " + lives);




            try {
                if (System.getProperty("os.name").contains("Windows")) {
                    Thread.sleep(1000);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                } else {

                    Runtime.getRuntime().exec("clear");
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("ERROR");
            }
            System.out.println();
            panel.repaint();
        }



    }

    public static void main(String[] args) {
        new Main();

    }


    public static char[][] startMap(int startSize) {
        boolean life;
        char[][] map = new char[startSize][startSize];

        Random random = new Random();
        for (int i = 0; i < startSize; i++) {
            for (int j = 0; j < startSize; j++) {
                life = random.nextBoolean();
                if (life) {
                    map[i][j] = 'O';
                    //System.out.print(map[i][j]);
                } else {
                    map[i][j] = ' ';
                    //System.out.print(map[i][j]);
                }
            }
            //System.out.println();
        }
        return map;
    }

    public static char[][] afterMap(char[][] startMap) {
        int count = 0;
        int leftI;
        int rightI;
        int leftJ;
        int rightJ;
        char[][] afterMap = new char[startMap.length][startMap.length];


        for (int i = 0; i < startMap.length; i++) {
            for (int j = 0; j < startMap.length; j++) {
                if (i == 0) {
                    leftI = startMap.length - 1;
                    rightI = i + 1;
                } else if (i == startMap.length - 1) {
                    rightI = 0;
                    leftI = i - 1;
                } else {
                    rightI = i + 1;
                    leftI = i - 1;
                }
                if (j == 0) {
                    leftJ = startMap.length - 1;
                    rightJ = j + 1;
                } else if (j == startMap.length - 1) {
                    rightJ = 0;
                    leftJ = j - 1;
                } else {
                    rightJ = j + 1;
                    leftJ = j - 1;
                }
                //1
                if (startMap[leftI][leftJ] == 'O') {
                    count++;
                }
                //2
                if (startMap[leftI][j] == 'O') {
                    count++;
                }
                //3
                if (startMap[leftI][rightJ] == 'O') {
                    count++;
                }
                //4
                if (startMap[i][leftJ] == 'O') {
                    count++;
                }
                //5
                if (startMap[i][rightJ] == 'O') {
                    count++;
                }
                //6
                if (startMap[rightI][leftJ] == 'O') {
                    count++;
                }
                //7
                if (startMap[rightI][j] == 'O') {
                    count++;
                }
                //8
                if (startMap[rightI][rightJ] == 'O') {
                    count++;
                }

                if (startMap[i][j] == 'O') {
                    if (count == 2 || count == 3) {
                        afterMap[i][j] = 'O';
                        //System.out.print(afterMap[i][j]);
                    } else {
                        afterMap[i][j] = ' ';
                        //System.out.print(afterMap[i][j]);
                    }

                } else if (startMap[i][j] == ' ') {
                    if (count == 3) {
                        afterMap[i][j] = 'O';
                        //System.out.print(afterMap[i][j]);
                    } else {
                        afterMap[i][j] = ' ';
                        //System.out.print(afterMap[i][j]);
                    }

                }
                count = 0;
            }
            //System.out.println();
        }

        return afterMap;
    }

}
