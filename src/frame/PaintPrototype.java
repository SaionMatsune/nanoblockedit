package frame;

import java.awt.Graphics;  // Use "Graphics"Class
import java.awt.Color;     // Use "Color"Class
import java.awt.GraphicsEnvironment;

import shape.*;

// Abstract Class for Figure Creating Tool
// Inherit This Class and Create PaintTool's Class
// Initial State is...
// Parts is selected "1/2E".
// Color is selected Black.
// Direction is selected side.
public abstract class PaintPrototype {
    int shapeId = 0;                // Parts Type Variable
                                    // 0:1/2E、1:1/2C、2:1/2B、3:1/2A
    static Color color = Color.black;   // Coler Variable
    boolean direction = false;  // Direction
                                // Length:true Side:false
    int xPressed = 50;  // X Coordinate of Pressed Mouse Position
    int yPressed = 50;  // Y Coordinate of Pressed Mouse Position
    
    static Shape[] shape = new Shape[1024]; // Array Storing Creating Figure
    static int numOfShape = 0;  // Number of Creating Figure
    static int boardnum = 0;    // Count Board's Parts Number

    // Initialization Method
    // Call after Creating Instance
    // Overrede at Inherited Class
    public static void init(Graphics gra) {
	// Drawing Board
	int x = (int) (getDisplaySize()/8); // X Coordinate of Start Point
	int y = (int) (getDisplaySize()/20); // Y Coordinate of Start Point
	int w = (int) (getDisplaySize()/4); // Width
	int h = (int) (getDisplaySize()/4); // Height
        
        // Start Board Color
	shape[numOfShape] = new Rectangle(x, y, w, h, Color.green, true);
        // Creating INstance of Board(Start Point(x,y), 終点(x+w,y+h), Green, Filled)
	shape[numOfShape].draw(gra);
        numOfShape++;  // Add Figure's Number
        // End Board Color
        // Start Board Frame
        shape[numOfShape] = new Rectangle(x, y, w, h, Color.black, false);
        shape[numOfShape].draw(gra);
        numOfShape++;  // Add Figure's Number
        // End Board Frame
        // Start Protuberance
        int yo = y;
    	for(int b=0;b<20;b++){
            int xo = x;
            for(int a=0;a<20;a++){
    		shape[numOfShape] = new Oval(xo + (int) (getDisplaySize()/80*0.15), yo + (int) (getDisplaySize()/80*0.15), (int) (getDisplaySize()/80*0.7), (int) (getDisplaySize()/80*0.7), Color.black, false);
    		shape[numOfShape].draw(gra);
    		numOfShape++;  // Add Figure's Number
                
                xo += (int) (getDisplaySize()/80);
            }
            yo += (int) (getDisplaySize()/80);
    	}
        // End Protuberance

        boardnum = numOfShape;
    }

    // Method Called Selected "1/2E" at "Parts" Menu
    // Overrede at Inherited Class
    public void ichi(Graphics gra) {
        shapeId = 0;
    }

    // Method Called Selected "1/2C" at "Parts" Menu
    // Overrede at Inherited Class
    public void ni(Graphics gra) {
        shapeId = 1;
    }

    // Method Called Selected "1/2B" at "Parts" Menu
    // Overrede at Inherited Class
    public void yon(Graphics gra) {
        shapeId = 2;
    }

    // Method Called Selected "1/2A" at "Parts" Menu
    // Overrede at Inherited Class
    public void hachi(Graphics gra) {
        shapeId = 3;
    }

    // Method Called Selected "Black" at "Color" Menu
    // Overrede at Inherited Class
    public void black(Graphics gra) {
        color = Color.black;
    }

    // Method Called Selected "Red" at "Color" Menu
    // Overrede at Inherited Class
    public void red(Graphics gra) {
        color = Color.red;
    }

    // Method Called Selected "Green" at "Color" Menu
    // Overrede at Inherited Class
    public void green(Graphics gra) {
        color = Color.green;
    }

    // Method Called Selected "Blue" at "Color" Menu
    // Overrede at Inherited Class
    public void blue(Graphics gra) {
        color = Color.blue;
    }

    // Method Called Selected "Yellow" at "Color" Menu
    // Overrede at Inherited Class
    public void yellow(Graphics gra) {
        color = Color.yellow;
    }

    // Method Called Selected "White" at"Color" Menu
    // Overrede at Inherited Class
    public void white(Graphics gra) {
        color = Color.white;
    }

    // Method Called Selected "Length" at "Direction" Menu
    // Overrede at Inherited Class
    public void length(Graphics gra) {
	direction = true;
    }

    // Method Called Selected "Side" at "Direction" Menu
    // Overrede at Inherited Class
    public void side(Graphics gra) {
        direction = false;
    }

    // Method Called Selected "Clear" Button
    // After Called This Method, Erase Screen
    // Overrede at Inherited Class
    public void clear(Graphics gra) {  // Erase All Figure
        for (int i=boardnum; i < numOfShape; i++) {
            shape[i] = null;
        }
        numOfShape = boardnum;
    }

    // Method Called Selected "Exit" Button
    // After Called This Method, Erase Window and End Program
    // Overrede at Inherited Class
     public void terminate(Graphics gra) {
    }

    // Method Called Pressed Mouse
    // Pressed Coordinate is Argument.
    // Overrede at Inherited Class
    public void mousePressed(int xx, int yy, Graphics gra) {
        xPressed = xx;
        yPressed = yy;
    }

    // Method of Repainting All Figure
    // Overrede at Inherited Class
    public void redrawAll(Graphics gra) {
        for (int i=0; i < numOfShape; i++) {
            shape[i].draw(gra);
        }
    }
    
    // Get DisplaySize
    private static int getDisplaySize() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        java.awt.Rectangle desktopBounds = env.getMaximumWindowBounds();

        return (int) desktopBounds.getWidth();
    }
}
