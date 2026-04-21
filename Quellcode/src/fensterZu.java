//eine Klasse zum schlieﬂen von Dialogen

import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class fensterZu
    extends WindowAdapter {
  public void windowClosing(WindowEvent e) {
    Dialog f = (Dialog) e.getSource();
    f.setVisible(false);
    f.dispose();
  }

  public void windowDeactivated(WindowEvent e) {
    // analysendialog f = (analysendialog) e.getSource();
    // boolean pruefResult = f.pruefen(f.berechne());

  }

}
