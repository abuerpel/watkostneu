/**
 * Title:        Watkost<p>
 * Description:  buttons FW BW
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */
import java.awt.Color;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class dataAction1
    extends JPanel {
  private JButton neu, such;
  private ImageIcon iconSuch, iconNeu;

  public dataAction1() {
    // iconNeu = new ImageIcon("icon1.gif");
    GridLayout dcLayout = new GridLayout();
    dcLayout.setColumns(2);
    dcLayout.setHgap(4);
    dcLayout.setRows(1);
    dcLayout.setVgap(4);
    this.setLayout(dcLayout);
    this.setBackground(new Color(72, 157, 255));

    such = new JButton();
    such.setFont(new java.awt.Font("Dialog", 1, 10));
    //such.setIcon(iconSuch);
    such.setText("suchen");
    such.setToolTipText("suchen nach Analysennummer");

    neu = new JButton();
    neu.setFont(new java.awt.Font("Dialog", 1, 10));
    neu.setText("neu");
    //neu.setIcon(iconNeu);
    neu.setToolTipText("neuen Datensatz eingeben");
    add(such);
    add(neu);

  }
}
