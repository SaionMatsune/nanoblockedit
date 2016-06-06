package shape;

import java.awt.Graphics;  // Use "Graphics"Class
import java.awt.Color;     // Use "Color"Class

// Figure's Class
public abstract class Shape {
    int x = 0;                    // X Coordinate
    int y = 0;                    // Y Coordinate
    Color color = Color.black;    // Figure's Color(Initial Value is black)

    // Constructor
    // Argument:X Coordinate, Y Coordinate, Color
    public Shape(int xx, int yy, Color c) {
        x = xx;
        y = yy;
        color = c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Method of Drawing Figure
    public abstract void draw(Graphics gra);

}
