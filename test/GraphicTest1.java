import java.awt.*;    
public class GraphicTest1 extends Frame {
    public static void main(String[] args) {
      new GraphicTest1();
    }
    //コンストラクタ
    public GraphicTest1(){
    	
        this.setSize(300,250);
    	this.setLayout(null);
    	
    	Canv canvas = new Canv(); //Canvasのインスタンス
    	canvas.setBackground(Color.yellow);  //Canvasの背景色
    	canvas.setBounds(20,60,250,160);  //Canvasの位置とサイズ
    	add(canvas);   //Canvaをフレームに追加
    	
    	Label lb = new Label("このラベルはFrameに描いています");
    	lb.setBounds(10,40,200,20);	  //ラベルの位置とサイズ
    	add(lb);                      //ラべルをフレームに追加
    	
        this.setVisible(true);        //フレームを表示する
    }
}
class Canv extends Canvas{
    //paintメソッド
    public void paint(Graphics g){
       g.drawRect(10,10,150,120);   //矩形を描く
       g.drawOval(100,50,100,100);  //楕円を描く
       g.drawString("ここはCanvas領域です",15,150);  //文字列を描く
   }
}