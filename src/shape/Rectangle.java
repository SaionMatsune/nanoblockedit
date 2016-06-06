package shape;

import java.awt.Graphics;  // Use "Graphics"Class
import java.awt.Color;     // Use "Color"Class

// Rectangle's Class
public class Rectangle extends SymmetricalShape {

    // Constructor
    // Argument:X Coordinate, Y Coordinate, Color, Width, Height, Fill or Not
    public Rectangle(int x, int y, int w, int h, Color c, boolean f) {
        super(x, y, w, h, c, f);
    }

    // Method of Drawing Rectangle
    public void draw(Graphics gra) {
        gra.setColor(color);    // Setting Color
        if (filled) {
            gra.fillRect(x, y, width, height);  // Drawing Filled Rectangle
        } else {
            gra.drawRect(x, y, width, height);  // Drawing NotFilled Rectangle
        }
    }

}
