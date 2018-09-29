import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Canvas extends JPanel {

    boolean shapeAdded = false;
    private Shape shape;

    public Canvas() {
    }

    public void addShape(Shape shape) {
        shapeAdded = true;
        this.shape = shape;
        validate();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (shapeAdded) {
            // get xPoints
            // get yPoints

            g.drawPolygon(xPoints, yPoints, shape.getNumberOfSides());
        }
        shapeAdded = false;

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();

        Canvas canvas = new Canvas();
        frame.getContentPane().add(canvas);

        //add shapes to your canvas!

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);


    }

}
