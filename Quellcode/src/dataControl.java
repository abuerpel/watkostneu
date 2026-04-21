/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class dataControl
    extends JPanel {
  private JButton fw, bw, save, neu, del, such;

  public dataControl() {
    GridLayout dcLayout = new GridLayout();
    dcLayout.setColumns(5);
    dcLayout.setHgap(4);
    dcLayout.setRows(1);
    dcLayout.setVgap(4);
    this.setLayout(dcLayout);
    this.setBackground(new Color(72, 157, 255));

    fw = new JButton(); //(("Arrow2r.bpm"));
    fw.setFont(new java.awt.Font("Dialog", 1, 10));
    fw.setText("fw");

    bw = new JButton(); //("/icons/Arrow2l");
    bw.setFont(new java.awt.Font("Dialog", 1, 10));
    bw.setText("bw");
    such = new JButton();
    such.setText("suchen");
    save = new JButton(); //("/icons/Filesave");
    save.setText("save");
    neu = new JButton(); //("/icons/Filenew");
    neu.setText("neu");
    del = new JButton(); //("/icons/Delete");
    del.setText("del");
    add(bw);
    add(fw);
    //add(such);
    //add(save);
    //add(neu);
    //add(del);
  }
}