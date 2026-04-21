/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;

public class anlagenmenue
    extends MenuBar {
  public anlagenmenue(final anlagenframe f) {
    MenuBar anlagenmenue = new MenuBar();
    Menu m1 = new Menu(startframe.Texte.elementAt(2).toString());
    MenuItem midrucken = new MenuItem(startframe.Texte.elementAt(10).toString());
    MenuItem mischliessen = new MenuItem(startframe.Texte.elementAt(12).toString());

    //Menü hinzufuegen
    m1.add(midrucken);
    m1.add(mischliessen);
    add(m1);
    midrucken.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        f.jbdruckenclicked();
      }
    });
    mischliessen.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        f.jbschliessenclicked();
      }
    });
  }
}
