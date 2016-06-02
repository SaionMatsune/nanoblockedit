// PaintTool.java

import java.awt.Color;
import java.awt.Graphics;  // クラスGraphicsを利用する
// クラスColorを利用する

// 図形のクラス
public class PaintTool extends PaintPrototype {

   public void mouseReleased (int xx, int yy, Graphics gra) {
      super.mouseReleased(xx, yy, gra);
 	 int x = 0;  // x座標の位置
     int y = 0;  // y座標の位置
     int width = 0;  // 横の長さ
     int height = 0; // 縦の長さ
      if (numOfShape < shape.length) {
		////////////////////////////////////////////////////////////////
		// パーツをボードのポッチとぴったりに描画するために位置を計算 //
		// xもyも、マウスが押された場所の1/10の値が偶数なら、         //
		// 奇数にしてから10倍にし、奇数ならそのまま10倍する           //
		////////////////////////////////////////////////////////////////
 		 x = (xPressed/10)%2 == 0 ? (xPressed / 10 - 1) * 10 : xPressed / 10 * 10;
 		 y = (yPressed/10)%2 == 0 ? (yPressed / 10 - 1) * 10 : yPressed / 10 * 10;
         if(shapeId == 0) {  // 1/2Eが選択されたときの処理
             width = 20;
             height = 20;
			 partscre(x, y, width, height, gra);
         } else if(shapeId == 1) {  // 1/2Cが選択されたときの処理
			//縦長か横長かによって長さを変える
             width = direction ? 20 : 40;
             height = direction ? 40 : 20;
			 partscre(x, y, width, height, gra);
         } else if(shapeId == 2) {  // 1/2Bが選択されたときの処理
             width = 40;
             height = 40;
			 partscre(x, y, width, height, gra);
         } else if(shapeId == 3) {  // 1/2Aが選択されたときの処理
			//縦長か横長かによって長さを変える
             width = direction ? 40 : 80;
             height = direction ? 80 : 40;
			 partscre(x, y, width, height, gra);
         }
      }
   }

   /////////////////////////////////
   // パーツを描画する関数        //
   /////////////////////////////////
   public void partscre (int x, int y, int w, int h, Graphics gra) {
	   // パーツの色ここから
	   PaintPrototype.shape[PaintPrototype.numOfShape] = new Rectangle(x, y, w, h, PaintPrototype.color, true);
	   PaintPrototype.shape[PaintPrototype.numOfShape].draw(gra);
       PaintPrototype.numOfShape++;  // 作成した図形の数を1つ追加
	   // パーツの色ここまで

       if (PaintPrototype.color == Color.black) {  // 黒パーツの場合の処理、枠とポッチを黒くして表示させる
			// 枠ここから
			PaintPrototype.shape[PaintPrototype.numOfShape] = new Rectangle(x, y, w, h, Color.white, false);
	        PaintPrototype.shape[PaintPrototype.numOfShape].draw(gra);
	        PaintPrototype.numOfShape++;  // 作成した図形の数を1つ追加
			// 枠ここまで
	        // ポッチここから
	        int yo = y;
	       	for(int b=0;b<(h/20);b++){
				int xo = x;
	       		for(int a=0;a<(w/20);a++){
	       			PaintPrototype.shape[PaintPrototype.numOfShape] = new Oval(xo + 3, yo + 3, 14, 14, Color.white, false);
	       			PaintPrototype.shape[PaintPrototype.numOfShape].draw(gra);
	       			PaintPrototype.numOfShape++;  // 作成した図形の数を1つ追加
	       			xo += 20;
	       		}
	       		yo += 20;
	       	}
	       	 // ポッチここまで
	    } else {  // 黒パーツでない場合の処理、枠とポッチを黒くして表示させる
			// 枠ここから
			PaintPrototype.shape[PaintPrototype.numOfShape] = new Rectangle(x, y, w, h, Color.black, false);
	        PaintPrototype.shape[PaintPrototype.numOfShape].draw(gra);
	        PaintPrototype.numOfShape++;  // 作成した図形の数を1つ追加
			// 枠ここまで
	        // ポッチここから
	        int yo = y;
	       	for(int b=0;b<(h/20);b++){
	       		int xo = x;
	       		for(int a=0;a<(w/20);a++){
	       			PaintPrototype.shape[PaintPrototype.numOfShape] = new Oval(xo + 3, yo + 3, 14, 14, Color.black, false);
	       			PaintPrototype.shape[PaintPrototype.numOfShape].draw(gra);
	       			PaintPrototype.numOfShape++;  // 作成した図形の数を1つ追加
	       			 xo += 20;
	       		}
	       		yo += 20;
	       	}
	       	// ポッチここまで
	    }
   }

}

//1/2E…細かい部分の穴埋め
//1/2C…細かい表現
//1/2B…あらゆる場面で
//1/2A…基本部品
//http://ja.wikipedia.org/wiki/%E3%83%8A%E3%83%8E%E3%83%96%E3%83%AD%E3%83%83%E3%82%AF
//http://www.diablock.co.jp/nanoblock/
//http://www.diablock.co.jp/nanoblock/catalog/standard_color_set.php