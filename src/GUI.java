import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 500;
    static JFrame frame = new JFrame("SlimeMoldSimulation");
    public GUI() {

        this.setBackground(Color.BLACK);

        System.out.println("repaint");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(this);
        frame.setVisible(true);
    }

    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;

        g.setBackground(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //g.clearRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);

        for (entity entity : Main.entities) {
            drawEntity(entity, g);
        }

        entity.move();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        repaint();
    }

    private void drawEntity(entity entity, Graphics2D g) {

        g.fillRect((int) entity.x, (int) entity.y, 10, 10);
    }
}
