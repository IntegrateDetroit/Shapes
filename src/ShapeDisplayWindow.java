/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiexercises;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author Alonso del Arte
 */
public abstract class ShapeDisplayWindow extends JPanel implements ActionListener, MouseMotionListener {
    
    private static int windowCount = 0;
    private static Point lastWindowPosition;
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    
    protected JFrame frame;
        
    @Override
    public void mouseMoved(MouseEvent mauv) {
        // PLACEHOLDER FOR IMPLEMENTATION
    }

    @Override
    public void mouseDragged(MouseEvent mauv) {
        // PLACEHOLDER FOR IMPLEMENTATION
    }

    /**
     * Shows the About box, a simple MessageDialog from JOptionPage. If 
     * available, writes the same information to the console.
     */
    public void showAboutBox() {
        String aboutBoxTitle = "About";
        String aboutMessage = "About this program\nINFO GOES HERE";
        JOptionPane.showMessageDialog(this.frame, aboutMessage, aboutBoxTitle, JOptionPane.INFORMATION_MESSAGE);
        System.out.println(aboutMessage);
    }

    /**
     * Function to handle menu events. Unrecognized commands will be printed to 
     * the console with a message to that effect.
     * @param ae Object giving information about the menu item selected.
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();
        switch (cmd) {
            case "close":
                this.frame.dispose();
                break;
            case "quit":
                System.exit(0);
                break;
            case "about":
                showAboutBox();
                break;
            default:
                System.out.println("Command " + cmd + " not recognized.");
        }
    }
    
    public abstract String getWindowTitle();
    
    private JMenuBar setUpMenuBar() {
        boolean macOSFlag;
        int maskCtrlCommand;
        String operSysName = System.getProperty("os.name");
        macOSFlag = operSysName.equals("Mac OS X");
        if (macOSFlag) {
            maskCtrlCommand = Event.META_MASK;
        } else {
            maskCtrlCommand = Event.CTRL_MASK;
        }
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.getAccessibleContext().setAccessibleDescription("Menu for file operations");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("Close");
        menuItem.getAccessibleContext().setAccessibleDescription("Close the window");
        menuItem.setActionCommand("close");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, maskCtrlCommand));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Quit");
        menuItem.getAccessibleContext().setAccessibleDescription("Exit the program");
        menuItem.setActionCommand("quit");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, maskCtrlCommand));
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);
        menu.getAccessibleContext().setAccessibleDescription("Menu for help and information");
        menuBar.add(menu);
        menuItem = new JMenuItem("About");
        menuItem.getAccessibleContext().setAccessibleDescription("Display information about this program");
        menuItem.setActionCommand("about");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        return menuBar;
    }
    
    public void startUpDisplay() {
        this.frame = new JFrame(this.getWindowTitle());
        this.frame.setJMenuBar(this.setUpMenuBar());
        this.setPreferredSize(new Dimension(400, 400));
        this.frame.add(this, BorderLayout.CENTER);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.pack();
        if (ShapeDisplayWindow.windowCount == 0) {
            ShapeDisplayWindow.lastWindowPosition = this.frame.getLocation();
        } else {
            ShapeDisplayWindow.lastWindowPosition.translate(100, 100);
            if (ShapeDisplayWindow.lastWindowPosition.x > SCREEN_SIZE.width) {
                ShapeDisplayWindow.lastWindowPosition.translate(-SCREEN_SIZE.width + 50, 0);
            }
            if (ShapeDisplayWindow.lastWindowPosition.y > SCREEN_SIZE.height) {
                ShapeDisplayWindow.lastWindowPosition.translate(0, -SCREEN_SIZE.height + 50);
            }
            this.frame.setLocation(ShapeDisplayWindow.lastWindowPosition);
        }
        this.frame.setVisible(true);
        ShapeDisplayWindow.windowCount++;
    }
    
}
