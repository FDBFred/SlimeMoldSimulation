import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
public class GUI extends JPanel {

    public static final int WIDTH = 1000;


    public static final int HEIGHT = 500;
    static JFrame frame = new JFrame("SlimeMoldSimulation");

    private final BufferedImage offScreenImage;
    public final Graphics2D offScreenGraphics;

    public GUI() {
        this.setBackground(Color.BLACK);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(this);
        frame.setVisible(true);

        offScreenImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        offScreenGraphics = (Graphics2D) offScreenImage.getGraphics();

        startSimulation();
    }

    public static Color getPixel(int i, int j, Graphics2D g) {
        return g.getColor();
    }

    private void startSimulation() {
        new Thread(() -> {
            while (true) {
                repaint();
            }
        }).start();
    }

    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;

        offScreenGraphics.setColor(new Color(0, 0, 0,   6));
        offScreenGraphics.fillRect(0, 0, WIDTH, HEIGHT);

        offScreenGraphics.setColor(Color.blue);

        for (entity entity : Main.entities) {
            drawEntity(entity, offScreenGraphics);
        }

        entity.move();

        g.drawImage(offScreenImage, 0, 0, null);
    }

    private void drawEntity(entity entity, Graphics2D g) {
        g.fillRect((int) entity.x, (int) entity.y, 2, 2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}
