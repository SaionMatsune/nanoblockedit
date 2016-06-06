package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

// Editor's Frame
public class NBFrame extends JFrame {
    private static JComboBox pcb, ccb, dcb;     // Menu's ComboBox
    private static JLabel pl, cl, dl;   //"Parts", "Color", "Direction" Label
    private static JButton cb, eb;  // "Clear" and "Exit"
    
    Graphics gra;   // Graphics Object
    PaintPrototype ge;
    
    public NBFrame(PaintPrototype gp) {
        // Equalize Exterior of GUI to Exterior of OS
	try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException | InstantiationException
                	| IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
	}
        
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        // Definition
        getLabel();
        getComboBox();
        getButton();
        
        p.add(pl);
        p.add(pcb);
        p.add(cl);
        p.add(ccb);
        p.add(dl);
        p.add(dcb);
        p.add(cb);
        p.add(eb);
        
        getContentPane().add(p, BorderLayout.PAGE_START);
        
        // Setting Frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	setResizable(false);
        setTitle("nanoblockTool");
        setBounds((int) (getDisplaySize()/20), (int) (getDisplaySize()/20), (int) (getDisplaySize()/2), (int) (getDisplaySize()/3));
        System.out.println((int) (getDisplaySize()/20) + "," + (int) (getDisplaySize()/20) + "," + (int) (getDisplaySize()/2) + "," + (int) (getDisplaySize()/3));
        setVisible(true);
        
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                ge.terminate(gra);  // Call terminate(), Method of PaintTool
                dispose();       // Hide Frame
                System.exit(0);  // End
            }
        });
        
        gra = getGraphics();
        ge = gp;
        
        ge.init(gra);
        gra.dispose();
        
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                ge.mousePressed(point.x, point.y, gra);
                repaint();      // Clear Block and Repaint
            }
        });
        
    }

    public static NBFrame getInstance() {
        PaintPrototype gp = new PaintTool();  // Generate Instance of PaintTool
        NBFrame frame = new NBFrame(gp);
        
        return frame;
    }

    // Create Label
    private static void getLabel() {
        pl = new JLabel("Parts");
        cl = new JLabel("Color");
        dl = new JLabel("Direction");
    }
    
    // Create ComboBox
    private void getComboBox() {
        //pcb, ccb, dcb
        String[] plabel = {"1/2E", "1/2C", "1/2B", "1/2A"};     // Parts Menu
        pcb = new JComboBox(plabel);
        pcb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String selStr;  // Variable Recording Selected String
                repaint();
                selStr = (String)pcb.getSelectedItem();
                
                if (selStr == "1/2E") {  // Select "1/2E"
                    ge.ichi(gra);  // Call ichi(), Method of PaintTool
                } else if (selStr == "1/2C") {  // Select "1/2C"
                    ge.ni(gra);  // Call ni(), Method of PaintTool
                } else if (selStr == "1/2B") {  // Select "1/2B"
                    ge.yon(gra);  // Call yon(), Method of PaintTool
                } else if (selStr == "1/2A") {  // Select "1/2A"
                    ge.hachi(gra);  // Call hachi(), Method of PaintTool
                }
                //1/2E…1x1
                //1/2C…1x2 or 2x1
                //1/2B…2x2
                //1/2A…2x4 or 4x2
            }
        });
    
        String[] clabel = {"Black", "Red", "Green", "Blue", "Yellow", "White"}; // Color Menu
        ccb = new JComboBox(clabel);
        ccb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String selStr;  // Variable Recording Selected String
                repaint();
                selStr = (String)ccb.getSelectedItem();
                
                if (selStr == "Black") {  // Select "Black"
                    ge.black(gra);  // Call black(), Method of PaintTool
                } else if (selStr == "Red") {  // Select "Red"
                    ge.red(gra);  // Call red(), Method of PaintTool
                } else if (selStr == "Green") {  // Select "Green"
                    ge.green(gra);  // Call green(), Method of PaintTool
                } else if (selStr == "Blue") {  // Select "Blue"
                    ge.blue(gra);  // Call blue(), Method of PaintTool
                } else if (selStr == "Yellow") {  // Select "Yellow"
                    ge.yellow(gra);  // Call yellow(), Method of PaintTool
                } else if (selStr == "White"){  // Select "White"
                    ge.white(gra);  // Call white(), Method of PaintTool
                }
            }
        });
    
        String[] dlabel = {"Side", "Length"};   // Direction Menu
        dcb = new JComboBox(dlabel);
        dcb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String selStr;  // Variable Recording Selected String
                repaint();
                selStr = (String)dcb.getSelectedItem();
                
                if (selStr == "Side") {  // Select "Side"
                    ge.side(gra);  // Call sede(), Method of PaintTool
                } else if (selStr == "Length") {  // Select "Length"
                    ge.length(gra);  // Call length(), Method of PaintTool
                }
            }
        });
        
    }
    
    // Create Button
    private void getButton() {
        cb = new JButton("Clear");
        cb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ge.clear(gra);  // Call clear(), Method of PaintTool
                repaint();      // Clear Block and Repaint
            }
        });
        
        eb = new JButton("Exit");
        eb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ge.terminate(gra);  // Call terminate(), Method of PaintTool
                dispose();       // Hide Frame
                System.exit(0);  // End
            }
        });
        
        eb.setPreferredSize(cb.getPreferredSize()); // Setting Button's Size Large
    }
    
    // Get DisplaySize
    private static int getDisplaySize() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle desktopBounds = env.getMaximumWindowBounds();

        return (int) desktopBounds.getWidth();
    }
    
    public void paint(Graphics g) {
        super.paint(g); // Call paint() of Super Class(JFrame)
        if (ge != null) {
            ge.redrawAll(g);    // Call redrawAll(), Method of PaintTool
        }
    }
}