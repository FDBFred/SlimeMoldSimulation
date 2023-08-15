
import javax.swing.*;
import java.util.ArrayList;


public class Main {
    public static final int entityCount = 100;

    static ArrayList<entity> entities = new ArrayList<>();
    public static void main(String[] args) {

        for (int i = 0; i < entityCount; i++) {
            entities.add(new entity());
        }

        for (entity entity : entities) {
            entity.createEntity();
        }

        new GUI();

    }

}

