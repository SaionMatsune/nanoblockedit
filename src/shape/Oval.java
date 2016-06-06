package shape;

import java.awt.Graphics;  // Use "Graphics"Class
import java.awt.Color;     // Use "Color"Class

// Oval's Class
public class Oval extends SymmetricalShape {

    // Constructor
    // Argument:X Coordinate, Y Coordinate, Color, Width, Height, Fill or Not
    public Oval(int x, int y, int w, int h, Color c, boolean f) {
        super(x, y, w, h, c, f);
    }

    // Method of Drawing Oval
    public void draw(Graphics gra) {
        gra.setColor(color);    // Setiing Coler
        if (filled) {
            gra.fillOval(x, y, width, height);  // Drawing Filled Oval
        } else {
            gra.drawOval(x, y, width, height);  // Drawing NotFilled Oval
        }
    }

}
