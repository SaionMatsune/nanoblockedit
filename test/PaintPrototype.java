// PaintPrototype.java

import java.awt.Color;     // クラスColorを利用する
import java.awt.Graphics;  // クラスGraphicsを利用する

// 図形作成ツール用の抽象クラス
// このクラスを継承して、ペイントツールのクラスを作成する
// ただし、画面のメニュー類の初期状態は以下とする
// 「図形」は「直線」が選択されている
// 「色」は「黒」が選択されている
// 「塗りつぶし」は「なし」が選択されている

public abstract class PaintPrototype {
  int shapeId = 0;                // 図形の種類を表す変数
                                  // 0:1/2E、1:1/2C、2:1/2B、3:1/2A
  static Color color = Color.black;      // 描画の色を表す変数
  boolean direction = false;         // 向きがどうか
                                     // 横:false 縦:true
  int xPressed = 50;              // マウスキーが押された位置のＸ座標
  int yPressed = 50;              // マウスキーが押された位置のＹ座標
  int xReleased = 100;            // マウスキーが離された位置のＸ座標
  int yReleased = 100;            // マウスキーが離された位置のＹ座標
  int xDragged = 60;              // ドラッグされた時のＸ座標
  int yDragged = 60;              // ドラッグされた時のＹ座標

  static Shape[] shape = new Shape[1024]; // 作成した図形の参照を格納する配列
  static int numOfShape = 0;             // 作成した図形の数
  static int boardnum = 0;				 // ボードのパーツ数を数える

  // 初期化メソッド
  // インスタンス生成後に呼び出される
  // 必要であれば、継承したクラスでオーバライドする
  public void init(Graphics gra) {
	 // ボードを描画する
	 int x = 250; // 始点のx座標
	 int y = 150; // 始点のy座標
	 int w = 400; //
	 int h = 400; //

     // ボード色ここから
	 shape[numOfShape] = new Rectangle(x, y, w, h, Color.green, true);
		// ボード(始点(250,150),終点(650,550),色は緑,塗りつぶし)のインスタンスの生成
	 shape[numOfShape].draw(gra);
     numOfShape++;  // 作成した図形の数を1つ追加
     // ボード色ここまで
     // 枠ここから
     shape[numOfShape] = new Rectangle(x, y, w, h, Color.black, false);
     shape[numOfShape].draw(gra);
     numOfShape++;  // 作成した図形の数を1つ追加
     // 枠ここまで
     // ポッチここから
     int yo = y;
    	for(int b=0;b<(h/20);b++){
    		int xo = x;
    		for(int a=0;a<(w/20);a++){
    			shape[numOfShape] = new Oval(xo + 3, yo + 3, 14, 14, Color.black, false);
    			shape[numOfShape].draw(gra);
    			numOfShape++;  // 作成した図形の数を1つ追加
    			 xo += 20;
    		}
    		yo += 20;
    	}
    // ポッチここまで

     boardnum = numOfShape;
  }

  // メニュー"Parts"の"1/2E"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void ichi(Graphics gra) {
    shapeId = 0;
  }

  // メニュー"Parts"の"1/2C"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void ni(Graphics gra) {
    shapeId = 1;
  }

  // メニュー"Parts"の"1/2B"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void yon(Graphics gra) {
    shapeId = 2;
  }

  // メニュー"Parts"の"1/2A"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void hachi(Graphics gra) {
    shapeId = 3;
  }

  // メニュー"Color"の"Black"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void black(Graphics gra) {
    color = Color.black;
  }

  // メニュー"Color"の"Red"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void red(Graphics gra) {
    color = Color.red;
  }

  // メニュー"Color"の"Green"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void green(Graphics gra) {
    color = Color.green;
  }

  // メニュー"Color"の"Blue"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void blue(Graphics gra) {
    color = Color.blue;
  }

  // メニュー"Color"の"Blue"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void yellow(Graphics gra) {
    color = Color.yellow;
  }

  // メニュー"Color"の"Blue"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void white(Graphics gra) {
    color = Color.white;
  }

  // メニュー"Direction"の"Length"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void length(Graphics gra) {
	  direction = true;
  }

  // メニュー"Direction"の"Side"が選択された時に呼び出されるメソッド
  // 必要であれば、継承したクラスでオーバライドする
  public void side(Graphics gra) {
	  direction = false;
  }

  // ボタン"Clear"が押された時に呼び出されるメソッド
  // このメソッドが呼ばれた後、画面が消去される
  // 必要であれば、継承したクラスでオーバライドする
  public void clear(Graphics gra) {  // 全ての図形を消去
    for (int i=boardnum; i < numOfShape; i++) {
      shape[i] = null;
    }
    numOfShape = boardnum;
  }

  // ボタン"Exit"が押された時に呼び出されるメソッド
  // このメソッドが呼ばれた後、ウィンドウを消去し、プログラムを終了する
  // 必要であれば、継承したクラスでオーバライドする
  public void terminate(Graphics gra) {
  }

  // マウスキーが押された時に呼び出されるメソッド
  // 押された時点の座標が引数で渡される
  // 必要であれば、継承したクラスでオーバライドする
  public void mousePressed(int xx, int yy, Graphics gra) {
    xPressed = xx;
    yPressed = yy;
  }

  // マウスキーが離された時に呼び出されるメソッド
  // 離された時点の座標が引数で渡される
  // 必要であれば、継承したクラスでオーバライドする
  public void mouseReleased(int xx, int yy, Graphics gra) {
    xReleased = xx;
    yReleased = yy;
  }

  // マウスがドラッグされた時に呼び出されるメソッド
  // その時点の座標が第１引数、第２引数で渡される
  // ウィンドウの背景色が最後の引数で渡される
  // 必要であれば、継承したクラスでオーバライドする
  public void mouseDragged(int xx, int yy, Graphics gra, Color c) {
    xDragged = xx;
    yDragged = yy;
  }

  // 全ての図形を再描画するメソッド
  // ウィンドウが別のウィンドウに隠されて、再び現れた時などに呼び出される
  // 必要であれば、継承したクラスでオーバライドする
  public void redrawAll(Graphics gra) {
    for (int i=0; i < numOfShape; i++) {
      shape[i].draw(gra);
    }
  }

}
