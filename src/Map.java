import java.util.Random;

public class Map {
    private int size;
    private int seed;
    private boolean life;

    public void setMap (int size, int seed, boolean life) {
        this.size = size;
        this.seed = seed;
        this.life = life;

        Random random = new Random(seed);
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                life = random.nextBoolean();
                if (life) {
                    System.out.print('O');
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}