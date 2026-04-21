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

public class dataAction2
    extends JPanel {
  private JButton loeschen, laden;

  public dataAction2() {
    GridLayout dcLayout = new GridLayout();
    dcLayout.setColumns(2);
    dcLayout.setHgap(4);
    dcLayout.setRows(1);
    dcLayout.setVgap(4);
    this.setLayout(dcLayout);
    this.setBackground(new Color(72, 157, 255));

    loeschen = new JButton();
    loeschen.setFont(new java.awt.Font("Dialog", 1, 10));
    loeschen.setText("löschen");
    loeschen.setToolTipText("Datensatz löschen");

    laden = new JButton();
    laden.setFont(new java.awt.Font("Dialog", 1, 10));
    laden.setText("laden");
    laden.setToolTipText("Datensatz laden");
    add(loeschen);
    add(laden);

  }
}