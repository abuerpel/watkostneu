//eine Klasse zum schließen von Dialogen
//package watkost;

import java.awt.event.*;
import java.awt.*;

class analyseFensterZu
    extends WindowAdapter {
  public void windowClosing(WindowEvent e) {
    Dialog f = (Dialog) e.getSource();
    f.setVisible(false);
    startframe.rowAna = startframe.datenBank.merken();
    analysendialog ad = (analysendialog) e.getSource();
    boolean pruefResult = ad.pruefen(ad.berechne());
    f.dispose();
  }

  public void windowDeactivated(WindowEvent e) {

  }

}
