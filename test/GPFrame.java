// GPFrame.java

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// ペイントツール用フレーム（ウィンドウ）
public class GPFrame extends JFrame
             implements ActionListener, MouseListener, MouseMotionListener{
  static  String[] labelStr = {"Parts", "Color", "Direction"};
                                              // パーツ描画用ラベルの文字列
  static  String[] str1 = {"1/2E", "1/2C", "1/2B", "1/2A"};
                                              // パーツメニュー用の文字列、
  static  String[] str2 = {"Black", "Red", "Green", "Blue", "Yellow", "White"};
                                              // 色メニュー用の文字列
  static  String[] str3 = {"Side", "Length"};      // 向きメニュー用の文字列
  static  String[] str4 = {"Clear", "Exit"};  // 消去・終了ボタン用の文字列

  JComboBox cb1, cb2, cb3;     // メニューやボタン用のコンボボックス

  JButton[] bt = new JButton[str4.length];  // 消去・終了ボタン

  Graphics gra;          // Graphicsオブジェクト

  int xPressed = 50;     // マウスキーを押したＸ座標
  int yPressed = 50;     // マウスキーを押したＹ座標
  int xReleased = 100;   // マウスキーを離したＸ座標
  int yReleased = 100;   // マウスキーを離したＹ座標
  int xDragged = 60;     // マウスをドラッグしたＸ座標
  int yDragged = 60;     // マウスをドラッグしたＹ座標

  PaintPrototype ge;              // ペイントツール

  // コンストラクタ、第1引数：タイトル、第2引数：ペイントツールの参照
  public GPFrame(String title, PaintPrototype gp) {
    super(title);                    // スーパクラスのコンストラクタ呼び出し
    setSize(900, 600);               // フレームのサイズを横900,縦600とする
    setBackground(Color.white);      // 背景色を白とする
    Container cp = getContentPane();                // コンテナ設定
    cp.setBackground(getBackground());              // コンテナの背景設定
    cp.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左側から並べるレイアウト

    // パーツの種類のメニュー
    JPanel pn1 = new JPanel();                       // パネル生成
    pn1.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左から並べるレイアウト

    JLabel lb1 = new JLabel(labelStr[0]);  // "Parts"ラベルの生成
    lb1.setForeground(Color.black);        // ラベルの文字色を黒とする
    pn1.add(lb1);                          // パネルにラベルを付加

    cb1 = new JComboBox();                // コンボボックス生成
    cb1.setEditable(false);               // コンボボックスの編集は不可とする
    for (int i=0; i<str1.length; i++) {   // 図形メニュー項目数分繰り返し
      cb1.addItem(str1[i]);               // 図形メニュー項目追加
    }
    cb1.addActionListener(this);  // コンボボックスにリスナ(アクション監視)付加
    pn1.add(cb1);                 // パネルにコンボボックスを付加
    cp.add(pn1);                  // コンテナにパネル追加

    // パーツの色のメニュー
    JPanel pn2 = new JPanel();                       // パネル生成
    pn2.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左から並べるレイアウト

    JLabel lb2 = new JLabel(labelStr[1]);  // "Color"ラベルの生成
    lb2.setForeground(Color.black);        // ラベルの文字色を黒とする
    pn2.add(lb2);                          // パネルにラベルを付加

    cb2 = new JComboBox();                // コンボボックス生成
    cb2.setEditable(false);               // コンボボックスの編集は不可とする
    for (int i=0; i<str2.length; i++) {   // 色メニュー項目数分繰り返し
      cb2.addItem(str2[i]);               // 色メニュー項目追加
    }

    cb2.addActionListener(this);  // コンボボックスにリスナ(アクション監視)付加
    pn2.add(cb2);                 // パネルにコンボボックスを付加
    cp.add(pn2);                  // コンテナにパネル追加

    // 向きのメニュー
    JPanel pn3 = new JPanel();                       // パネル生成
    pn3.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左から並べるレイアウト

    JLabel lb3 = new JLabel(labelStr[2]);  // "Direction"ラベルの生成
    lb3.setForeground(Color.black);        // ラベルの文字色を黒とする
    pn3.add(lb3);                          // パネルにラベルを付加

    cb3 = new JComboBox();                // コンボボックス生成
    cb3.setEditable(false);               // コンボボックスの編集は不可とする
    for (int i=0; i<str3.length; i++) {   // 塗りつぶしメニュー項目数分繰り返し
      cb3.addItem(str3[i]);               // 塗りつぶしメニュー項目追加
    }

    cb3.addActionListener(this);  // コンボボックスにリスナ(アクション監視)付加
    pn3.add(cb3);                 // パネルにコンボボックスを付加
    cp.add(pn3);                  // コンテナにパネル追加

    // 消去・終了ボタン
    JPanel pn4 = new JPanel();                       // パネル生成
    pn4.setLayout(new FlowLayout(FlowLayout.LEFT));  // 左から並べるレイアウト
    for (int i=0; i<str4.length; i++) {  // ボタン数分繰り返し
      bt[i] = new JButton(str4[i]);      // ボタン生成
      bt[i].addActionListener(this);     // ボタンにリスナ（アクション監視)付加
      pn4.add(bt[i]);                    // パネルにボタン追加
    }
    cp.add(pn4);                         // コンテナにパネル追加

    addMouseListener(this);        // マウスリスナー（アクション監視）付加
    addMouseMotionListener(this);  // マウス動作リスナー（移動監視）付加
    setVisible(true);        // 見えるようにする
    gra = getGraphics();     // Graphicsオブジェクト記憶

    ge = gp;                 // ペイントツールの参照記憶
    ge.init(gra);            // ペイントツールの初期化
  }

  // アクションが発生した（メニューが選択された、ボタンが押された）場合の処理
  public void actionPerformed(ActionEvent evt) {

    String selStr;  // 選択された文字列記憶用変数

    if (evt.getSource() == cb1) {   // パーツの種類のメニューが選択された場合は
      repaint();  // 再描画（プルダウンメニューで図形が消えることがあるので)
      selStr = (String)cb1.getSelectedItem();  // 選択された項目の文字列を得る

      if (selStr == str1[0]) {  // 選択された文字列が"1/2E"であれば
        ge.ichi(gra);  // ペイントツールのメソッド ichi() 呼び出し
      } else if (selStr == str1[1]) {  // 選択された文字列が"1/2C"であれば
        ge.ni(gra);  // ペイントツールのメソッド ni() 呼び出し
      } else if (selStr == str1[2]) {  // 選択された文字列が"1/2B"であれば
        ge.yon(gra);  // ペイントツールのメソッド yon() 呼び出し
      } else if (selStr == str1[3]) {  // 選択された文字列が"1/2A"であれば
        ge.hachi(gra);  // ペイントツールのメソッド hachi() 呼び出し
      }
	}

    if (evt.getSource() == cb2) {   // パーツの色のメニューが選択された場合は
      repaint();  // 再描画（プルダウンメニューで図形が消えることがあるので)
      selStr = (String)cb2.getSelectedItem();  // 選択された項目の文字列を得る
      if (selStr == str2[0]) {  // 選択された文字列が"Black"であれば
        ge.black(gra);  // ペイントツールのメソッド black() 呼び出し
      } else if (selStr == str2[1]) {  // 選択された文字列が"Red"であれば
        ge.red(gra);  // ペイントツールのメソッド red() 呼び出し
      } else if (selStr == str2[2]) {  // 選択された文字列が"Green"であれば
        ge.green(gra);  // ペイントツールのメソッド green() 呼び出し
      } else if (selStr == str2[3]) {  // 選択された文字列が"Blue"であれば
        ge.blue(gra);  // ペイントツールのメソッド blue() 呼び出し
      } else if (selStr == str2[4]) {  // 選択された文字列が"Yellow"であれば
        ge.yellow(gra);  // ペイントツールのメソッド yellow() 呼び出し
      } else if (selStr == str2[5] ){  // 選択された文字列が"White"であれば
        ge.white(gra);  // ペイントツールのメソッド white() 呼び出し
      }
    }

    if (evt.getSource() == cb3) {   // 向きのメニューが選択された場合は
      repaint();  // 再描画（プルダウンメニューで図形が消えることがあるので)
      selStr = (String)cb3.getSelectedItem();  // 選択された項目の文字列を得る
      if (selStr == str3[0]) {  // 選択された文字列が"Side"であれば
        ge.side(gra);  // ペイントツールのメソッド side() 呼び出し
      } else if (selStr == str3[1]) {  // 選択された文字列が"Length"であれば
        ge.length(gra);  // ペイントツールのメソッド length() 呼び出し
      }

    }

    if (evt.getSource() == bt[0]) {   // 全図形消去ボタンが押された場合は
      ge.clear(gra);  // ペイントツールのメソッド clear() 呼び出し
      repaint();      // 画面をクリアして再描画
    }

    if (evt.getSource() == bt[1]) {   // 終了ボタンが押された場合は
      ge.terminate(gra);  // ペイントツールのメソッド terminate() 呼び出し
      dispose();       // フレームを消す
      System.exit(0);  // 終了
    }

  }

  // マウスキーが押された場合の処理
  public void mousePressed(MouseEvent evt) {
    xPressed = evt.getX();  // イベントが発生したところのＸ座標を記憶
    yPressed = evt.getY();  // イベントが発生したところのＹ座標を記憶
    ge.mousePressed(xPressed, yPressed, gra);
                    // ペイントツールのメソッド mousePressed() 呼び出し
  }

  // マウスキーが離された場合の処理
  public void mouseReleased(MouseEvent evt) {
    xReleased = evt.getX();  // イベントが発生したところのＸ座標を記憶
    yReleased = evt.getY();  // イベントが発生したところのＹ座標を記憶
    ge.mouseReleased(xReleased, yReleased, gra);
                     // ペイントツールのメソッド mouseReleased() 呼び出し
  }


  // マウスキーがクリックされた場合の処理
  public void mouseClicked(MouseEvent evt) {
  }

  // マウスが領域内に入った場合の処理
  public void mouseEntered(MouseEvent evt) {
  }

  // マウスが領域外に出た場合の処理
  public void mouseExited(MouseEvent evt) {
  }

  // マウスがドラッグ（キーを押して移動)された場合の処理
  public void mouseDragged(MouseEvent evt) {
    xDragged = evt.getX();  // イベントが発生したところのＸ座標を記憶
    yDragged = evt.getY();  // イベントが発生したところのＹ座標を記憶
    ge.mouseDragged(xDragged, yDragged, gra, getBackground());
      // ペイントツールのメソッド mouseDragged() 呼び出し（最後の引数は背景色）
  }

  // マウスが移動した場合の処理
  public void mouseMoved(MouseEvent evt) {
  }

  // フレームを復元（再描画）する処理
  public void paint(Graphics g) {
    super.paint(g);    // スーパークラス（JFrame）の paint() 呼び出し
    if (ge != null) {  // ペイントツールがあれば
      ge.redrawAll(g);  // ペイントツールのメソッド redrawAll() 呼び出し
    }
  }

  // メインプログラム
  public static void main(String[] args) {
    PaintPrototype gp = new PaintTool();  // ペイントツールのインスタンス生成
    new GPFrame("nanoblock Tool", gp);  // ペイントツール用フレームのインスタンス生成
  }

}
