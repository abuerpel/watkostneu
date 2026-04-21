/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;

public class pwdDialog
    extends warndialog {
  String pwdEingabe;
  TextField text1 = new TextField();
  public pwdDialog(Frame AufrufVonFenster, String text, boolean modal) {
    super(AufrufVonFenster, text, true);
    super.gridLayout1.removeLayoutComponent(super.label3);
    super.gridLayout1.removeLayoutComponent(super.button1);
    super.gridLayout1.layoutContainer(super.getParent());
    super.gridLayout1.setRows(4);
    labeltext.setFont(new java.awt.Font("Dialog", 1, 10));
    labeltext.setForeground(Color.red);
    text1.setFont(new java.awt.Font("Dialog", 4, 20));
    text1.setBackground(Color.lightGray);
    text1.setForeground(Color.black);
    this.getContentPane().add(text1, null);
    //super.removeFocusListener(focusGained e);
    //this.removeFocusListener(focusGained e);
    //this.add(super.button1, null);
    text1.transferFocus();
  }

  public String getPwd() {
    pwdEingabe = this.text1.getText();
    return pwdEingabe;
  }

}
