/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexercises;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author AL
 */
public class TriangleDisplayWindow extends ShapeDisplayWindow {
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        int x[] = {50, 50, 250};
        int y[] = {50, 250, 250};
        Polygon triangle = new Polygon(x, y, 3);
        g.fillPolygon(triangle);
    }

    @Override
    public String getWindowTitle() {
        return "Triangle Display";
    }
        
}
