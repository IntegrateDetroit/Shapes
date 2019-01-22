/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexercises;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author AL
 */
public class RectangleDisplayWindow extends ShapeDisplayWindow {
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(50, 50, 200, 200);
    }
    
    @Override
    public String getWindowTitle() {
        return "Rectangle Display";
    }
        
}
