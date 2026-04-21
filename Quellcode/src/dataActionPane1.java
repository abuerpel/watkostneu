/**
 * Title:        Watkost<p>
 * Description:  buttons FW BW
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class dataActionPane1
    extends JPanel {
  private JButton fw, bw, save, neu, del, such;

  public dataActionPane1() {
    GridLayout dcLayout = new GridLayout();
    dcLayout.setColumns(2);
    dcLayout.setHgap(4);
    dcLayout.setRows(1);
    dcLayout.setVgap(4);
    this.setLayout(dcLayout);
    this.setBackground(new Color(72, 157, 255));

    fw = new JButton();
    fw.setFont(new java.awt.Font("Dialog", 1, 10));
    fw.setText("fw");

    bw = new JButton();
    bw.setFont(new java.awt.Font("Dialog", 1, 10));
    bw.setText("bw");

    add(bw);
    add(fw);

  }
}