package frame;

import java.awt.Graphics;  // Use "Graphics"Class
import java.awt.Color;     // Use "Color"Class
import java.awt.GraphicsEnvironment;

import shape.*;

// // PaintTool's Class
public class PaintTool extends PaintPrototype {

    public void mousePressed (int xx, int yy, Graphics gra) {
        super.mousePressed(xx, yy, gra);
 	int x = 0;  // Position of X Coordinate
        int y = 0;  // Position of Y Coordinate
        int width = 0;
        int height = 0;
        if (numOfShape < shape.length) {
            //Calculate Position of Parts
            x = ((xPressed - (int) (getDisplaySize()/8)) / (int) (getDisplaySize()/80)) * (int) (getDisplaySize()/80) + (int) (getDisplaySize()/8);
            y = ((yPressed - (int) (getDisplaySize()/20)) / (int) (getDisplaySize()/80)) * (int) (getDisplaySize()/80) + (int) (getDisplaySize()/20);

            if(shapeId == 0) {  // Select "1/2E"
                width = (int) (getDisplaySize()/80);
                height = (int) (getDisplaySize()/80);
		partscre(x, y, width, height, gra);
            } else if(shapeId == 1) {  // Select "1/2C"
                // Change length Portrait Orientation or Landscape Orientation
                width = direction ? (int) (getDisplaySize()/80) : (int) (getDisplaySize()/40);
                height = direction ? (int) (getDisplaySize()/40) : (int) (getDisplaySize()/80);
		partscre(x, y, width, height, gra);
            } else if(shapeId == 2) {  // Select "1/2B"
                width = (int) (getDisplaySize()/40);
                height = (int) (getDisplaySize()/40);
		partscre(x, y, width, height, gra);
            } else if(shapeId == 3) {  // Select "1/2A"
		// Change length Portrait Orientation or Landscape Orientation
                width = direction ? (int) (getDisplaySize()/40) : (int) (getDisplaySize()/20);
                height = direction ? (int) (getDisplaySize()/20) : (int) (getDisplaySize()/40);
		partscre(x, y, width, height, gra);
            }
        }
    }

    // Method of Drawing Parts
    public void partscre (int x, int y, int w, int h, Graphics gra) {
	// Start Parts Color
	PaintPrototype.shape[PaintPrototype.numOfShape] = new Rectangle(x, y, w, h, PaintPrototype.color, true);
	PaintPrototype.shape[PaintPrototype.numOfShape].draw(gra);
        PaintPrototype.numOfShape++;  // Add Figure's Number
	// Start Parts Color

       if (PaintPrototype.color == Color.black) {   // If Black Parts, Parts Frame and Protuberance are White.
            // Start Parts Frame
            PaintPrototype.shape[PaintPrototype.numOfShape] = new Rectangle(x, y, w, h, Color.white, false);
	    PaintPrototype.shape[PaintPrototype.numOfShape].draw(gra);
	    PaintPrototype.numOfShape++;  // Add Figure's Number
            // End Parts Frame
	    // Start Protuberance
	    int yo = y;
	    for(int b=0;b<(h/(int) (getDisplaySize()/80));b++){
                int xo = x;
	       	for(int a=0;a<(w/(int) (getDisplaySize()/80));a++){
                    PaintPrototype.shape[PaintPrototype.numOfShape] = new Oval(xo + (int) (getDisplaySize()/80*0.15), yo + (int) (getDisplaySize()/80*0.15), (int) (getDisplaySize()/80*0.7), (int) (getDisplaySize()/80*0.7), Color.white, false);
                    PaintPrototype.shape[PaintPrototype.numOfShape].draw(gra);
                    PaintPrototype.numOfShape++;  // Add Figure's Number
                    xo += (int) (getDisplaySize()/80);
                }
	       	yo += (int) (getDisplaySize()/80);
	    }
	    // End Protuberance
	} else {  // If Not Black Parts, Parts Frame and Protuberance are Black.
            // Start Parts Frame
            PaintPrototype.shape[PaintPrototype.numOfShape] = new Rectangle(x, y, w, h, Color.black, false);
	    PaintPrototype.shape[PaintPrototype.numOfShape].draw(gra);
	    PaintPrototype.numOfShape++;  // Add Figure's Number
            // End Parts Frame
	    // Start Protuberance
	    int yo = y;
	    for(int b=0;b<(h/(int) (getDisplaySize()/80));b++){
	    	int xo = x;
	    	for(int a=0;a<(w/(int) (getDisplaySize()/80));a++){
                    PaintPrototype.shape[PaintPrototype.numOfShape] = new Oval(xo + (int) (getDisplaySize()/80*0.15), yo + (int) (getDisplaySize()/80*0.15), (int) (getDisplaySize()/80*0.7), (int) (getDisplaySize()/80*0.7), Color.black, false);
                    PaintPrototype.shape[PaintPrototype.numOfShape].draw(gra);
                    PaintPrototype.numOfShape++;  // Add Figure's Number
                     xo += (int) (getDisplaySize()/80);
	       	}
	       	yo += (int) (getDisplaySize()/80);
	    }
	    // End Protuberance
	}
    }

   // Get DisplaySize
    private static int getDisplaySize() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        java.awt.Rectangle desktopBounds = env.getMaximumWindowBounds();

        return (int) desktopBounds.getWidth();
    }
}