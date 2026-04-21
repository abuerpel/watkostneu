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
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

public class navigation
    extends JPanel {
  private BasicArrowButton fw, bw;

  public navigation() {
    GridLayout dcLayout = new GridLayout();
    dcLayout.setColumns(2);
    dcLayout.setHgap(4);
    dcLayout.setRows(1);
    dcLayout.setVgap(4);
    this.setLayout(dcLayout);
    this.setBackground(new Color(72, 157, 255));

    fw = new BasicArrowButton(3);
    fw.setFont(new java.awt.Font("Dialog", 1, 10));
    fw.setText("fw");
    fw.setToolTipText("Datensatz vor");
    fw.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        fw_mouseClicked(e);
      }
    });

    bw = new BasicArrowButton(7);
    bw.setFont(new java.awt.Font("Dialog", 1, 10));
    bw.setText("bw");
    bw.setToolTipText("Datensatz zurück");
    bw.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        bw_mouseClicked(e);
      }
    });

    add(bw);
    add(fw);

  }

  //
  void fw_mouseClicked(MouseEvent e) {

  }

  //
  void bw_mouseClicked(MouseEvent e) {

  }
}