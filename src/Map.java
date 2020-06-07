import java.util.Random;

public class Map {

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
                    map[i][j] = 'X';
                    //System.out.print(map[i][j]);
                }
            }
            //System.out.println();
        }
        return map;
    }

    public char[][] afterMap(char[][] startMap) {
        int count = 0;
        int leftI ;
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
                            afterMap[i][j] = 'X';
                            //System.out.print(afterMap[i][j]);
                    }

                } else if (startMap[i][j] == 'X') {
                    if (count == 3) {
                            afterMap[i][j] = 'O';
                            //System.out.print(afterMap[i][j]);
                    } else {
                            afterMap[i][j] = 'X';
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