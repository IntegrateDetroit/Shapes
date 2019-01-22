/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexercises;

/**
 *
 * @author AL
 */
public class ShapesAssortment {
    
    public static void main(String[] args) {
        int assortmentSetTotal = 1;
        if (args.length > 0) {
            try {
                assortmentSetTotal = Integer.parseInt(args[0]);
            } catch (NumberFormatException nfe) {
                System.err.println(nfe.getMessage());
            }
        }
        if (assortmentSetTotal < 0) {
            assortmentSetTotal *= -1;
        }
        if (assortmentSetTotal > 0) {
            ShapeDisplayWindow[] sdwArr = new ShapeDisplayWindow[3 * assortmentSetTotal];
            int currIndex = 0;
            while (currIndex < sdwArr.length) {
                sdwArr[currIndex] = new OvalDisplayWindow();
                sdwArr[currIndex].startUpDisplay();
                currIndex++;
                sdwArr[currIndex] = new TriangleDisplayWindow();
                sdwArr[currIndex].startUpDisplay();
                currIndex++;
                sdwArr[currIndex] = new RectangleDisplayWindow();
                sdwArr[currIndex].startUpDisplay();
                currIndex++;
            }
        }
    }
    
}
