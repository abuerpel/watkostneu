/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */
import java.awt.Color;
import java.awt.Frame;

public class warndialog2
    extends warndialog {

  public warndialog2(Frame AufrufVonFenster, String text, boolean modal) {
    super(AufrufVonFenster, text, true);
    super.label3.setFont(new java.awt.Font("Dialog", 1, 10));
    super.label3.setForeground(Color.red);
  }

  public void meldung2(String Meldung) {
    super.label3.setText(Meldung);
  }
}