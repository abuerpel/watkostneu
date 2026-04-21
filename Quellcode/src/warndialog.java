import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JDialog;
import java.lang.System;

public class warndialog
    extends JDialog {
  JLabel labeltext = new JLabel();
  GridLayout gridLayout1 = new GridLayout();
  //BorderLayout borderLayout1 = new BorderLayout();
  JLabel label3 = new JLabel();
  JButton button1 = new JButton();


  public warndialog(Frame AufrufVonFenster, String text, boolean modal) {
    //
    super(AufrufVonFenster, startframe.Texte.elementAt(158).toString(), modal);
    this.addWindowListener(new fensterZu());
    getContentPane().setLayout(gridLayout1);
    this.setBackground(new Color(55, 71, 100));
    //this.setComponentOrientation(1);
    gridLayout1.setHgap(4);
    gridLayout1.setRows(3);
    gridLayout1.setVgap(4);
    labeltext.setFont(new java.awt.Font("Dialog", 1, 10));
    labeltext.setForeground(Color.red);
    label3.setBackground(new Color(55, 71, 100));

    //button1.setBackground(Color.lightGray);
    //button1.setForeground(new Color(55, 71, 100));
    button1.setText("ok");
    button1.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mouseClicked(MouseEvent e) {
        button1_mouseClicked(e);
      }
    });
    this.addFocusListener(new java.awt.event.FocusAdapter() {

        public void focusGained(FocusEvent e) {
            long ct = java.lang.System.currentTimeMillis();
     long ctl = ct+2000;
     while (ct < ctl)
     {
         ct = java.lang.System.currentTimeMillis();

     };
     dispose();
        }
    });




    this.getContentPane().add(labeltext, null);
    this.getContentPane().add(label3, null);
    this.getContentPane().add(button1, null);
  }

  void button1_mouseClicked(MouseEvent e) {
    dispose();
  }

  public void meldung(String Meldung) {
    this.labeltext.setText(Meldung);
  }
}
