import java.awt.*;
import java.util.Random;

public class entity {

    public static final Random random = new Random();

    public static int vel = 2;
    public static final int viewDist = 90;
    public static final int viewAngle = 90;

    public double x;
    public double y;

    public double dir;


    public entity() {



        x = CreateX();
        y = CreateY();
        dir = CreateDir();
    }

    public static void updateDir() {
    }

    public void createEntity() {
        CreateX();
        CreateY();
        CreateDir();
    }

    public double CreateX() {
        x = random.nextInt(10, GUI.WIDTH - 20);
        return x;
    }

    public double CreateY() {
        y = random.nextInt(10, GUI.HEIGHT - 20);;
        return y;
    }

    public double CreateDir() {
        dir = random.nextDouble(Math.toRadians(360));

        if (dir == Math.toRadians(90) || dir == Math.toRadians(180) || dir == Math.toRadians(270) || dir == Math.toRadians(360)) {
            dir = random.nextDouble(Math.toRadians(360));
        }
        return dir;
    }

    public static void move() {
        for (entity entity : Main.entities) {
            for (int i = (int) - (entity.dir/2); i < viewAngle; i++) {
                for (int j = 0; j < viewDist; j++) {
                }
            }

            entity.x += (Math.cos(entity.dir) * vel);
            entity.y += (Math.sin(entity.dir) * vel);

            if (entity.x > GUI.WIDTH - 20 || entity.x < 10) {
                entity.dir += Math.toRadians(90);
            }

            if (entity.y > GUI.HEIGHT - 20 || entity.y < 10) {
                entity.dir += Math.toRadians(90);
            }

        }
    }


}
