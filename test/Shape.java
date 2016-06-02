// Shape.java

import java.awt.Graphics;  // クラスGraphicsを利用する
import java.awt.Color;     // クラスColorを利用する

// 図形のクラス
public abstract class Shape {
  int x = 0;                    // Ｘ座標
  int y = 0;                    // Ｙ座標
  Color color = Color.black;    // 図形の色（初期値は黒）

  // コンストラクタ
  // 引数：Ｘ座標、Ｙ座標、色
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

  // 図形を描画するメソッド
  public abstract void draw(Graphics gra);

}
