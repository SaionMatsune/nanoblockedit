/**
 * HexagonFrame.java
 * TECHSCORE Javaユーザインタフェース12章 実習課題1
 *
 * Copyright (c) 2004 Four-Dimensional Data, Inc.
 */
 
//package com.techscore.ui.chapter12.exercise1;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class HexagonFrame extends JFrame {
 
    public HexagonFrame() {
        super("HexagonFrame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        HexagonPanel panel = new HexagonPanel();
        panel.setPreferredSize(new Dimension(300, 300));
        getContentPane().add(panel, BorderLayout.CENTER);
 
        pack();
    }
 
    public static void main(String args[]) {
        new HexagonFrame().setVisible(true);
    }
 
    private class HexagonPanel extends JPanel {
 
        public void paint(Graphics g) {
            Dimension dim = getSize();
            Polygon hex = new Polygon();
 
            // 正六角形の大きさをpanelいっぱいに決定
            double radius = 150;
 
            // 正六角形の座標
            for (int i = 0; i < 6; i++) {
                hex.addPoint(
                    (int) (Math.sin(Math.PI / 3 * i) * radius + radius),
                    (int) (Math.cos(Math.PI / 3 * i) * radius + radius));
            }
 
            // 正六角形を描画
            g.setColor(Color.BLUE);
            g.fillPolygon(hex);
        }
    }
 
}