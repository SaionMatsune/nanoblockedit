// SymmetricalShape.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 左右対称の形の図形
// 塗りつぶすことも可能
public abstract class SymmetricalShape extends Shape {
  int width = 0;           // 幅
  int height = 0;          // 高さ
  boolean filled = false;  // 塗りつぶすかどうか

  // コンストラクタ
  // 引数：Ｘ座標、Ｙ座標、幅、高さ、色、塗りつぶすかどうか
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
