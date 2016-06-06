package shape;

import java.awt.Graphics;  // Use "Graphics"Class
import java.awt.Color;     // Use "Color"Class

// Symmetry Form's Figure
// Able Filling
public abstract class SymmetricalShape extends Shape {
    int width = 0;
    int height = 0;
    boolean filled = false;   // Fill or Not

    // Constructor
    // Argument:X Coordinate, Y Coordinate, Color, Width, Height, Fill or Not
    public SymmetricalShape(int x, int y, int w, int h, Color c, boolean f) {
        super(x, y, c);
        width = w;
        height = h;
        filled = f;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean filledOrNot() {
        return filled;
    }

}
