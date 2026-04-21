//package watkost;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import watklassen.*;

public class grenzwertedialog2
    extends Dialog {

  //Variable definieren
  boolean gelesen = true; //wenn einlesen() Exception
  JPanel panel1 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JLabel label4 = new JLabel();
  JTextField textFieldSIMax = new JTextField();
  JTextField textFieldLFMax = new JTextField();
  JTextField textFieldHaerteMin = new JTextField();
  JButton buttonOK = new JButton();
  JLabel labelAlkalitaetMin = new JLabel();
  JTextField textFieldSImax2 = new JTextField();
  JLabel labelROMax = new JLabel();
  JLabel label26 = new JLabel();
  JLabel labelLFMax = new JLabel();
  JLabel label20 = new JLabel();
  JTextField textFieldHaerteMax = new JTextField();
  JTextField textFieldTW = new JTextField();
  JTextField textFieldAlkalitaetMin = new JTextField();
  JLabel labelHaerteMax = new JLabel();
  JLabel labelTW = new JLabel();
  GridLayout gridLayout2 = new GridLayout();
  JLabel Label1 = new JLabel();
  JLabel Label2 = new JLabel();
  JLabel Label3 = new JLabel();
  JLabel Label4 = new JLabel();

  public grenzwertedialog2(Frame AufrufVonFenster, String text, boolean modal) {
    super(AufrufVonFenster, startframe.Texte.elementAt(160).toString(), true);
    this.addWindowListener(new fensterZu());
    this.setLayout(gridLayout1);
    label4.setFont(new java.awt.Font("Dialog", 1, 10));
    label4.setForeground(Color.red);
    label4.setText(startframe.Texte.elementAt(49).toString());
    textFieldSIMax.setForeground(Color.black);
    textFieldSIMax.setText("2.3");
    textFieldLFMax.setForeground(Color.black);
    textFieldLFMax.setText("500");
    textFieldHaerteMin.setForeground(Color.black);
    textFieldHaerteMin.setText("2");
    buttonOK.setBackground(Color.lightGray);
    buttonOK.setForeground(Color.black);
    buttonOK.setLabel("ok");
    buttonOK.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mouseClicked(MouseEvent e) {
        buttonOK_mouseClicked(e);
      }
    });
    labelAlkalitaetMin.setForeground(Color.black);
    labelAlkalitaetMin.setText(startframe.Texte.elementAt(127).toString());
    textFieldSImax2.setForeground(Color.black);
    textFieldSImax2.setText("35");
    labelROMax.setForeground(Color.black);
    labelROMax.setText(startframe.Texte.elementAt(129).toString());
    label26.setForeground(Color.black);
    label26.setText(startframe.Texte.elementAt(124).toString());
    labelLFMax.setForeground(Color.black);
    labelLFMax.setText(startframe.Texte.elementAt(126).toString());
    label20.setForeground(Color.black);
    label20.setText(startframe.Texte.elementAt(123).toString());
    textFieldHaerteMax.setForeground(Color.black);
    textFieldHaerteMax.setText("9");
    textFieldTW.setForeground(Color.black);
    textFieldTW.setText("2.0");
    textFieldAlkalitaetMin.setForeground(Color.black);
    textFieldAlkalitaetMin.setText("7.5");
    labelHaerteMax.setForeground(Color.black);
    labelHaerteMax.setText(startframe.Texte.elementAt(125).toString());
    labelTW.setForeground(Color.black);
    labelTW.setText(startframe.Texte.elementAt(128).toString());
    panel1.setBackground(new Color(72, 157, 255));
    panel1.setLayout(gridLayout2);
    gridLayout2.setColumns(4);
    gridLayout2.setHgap(4);
    gridLayout2.setRows(5);
    gridLayout2.setVgap(4);
    this.add(panel1, null);
    panel1.add(label4, null);
    panel1.add(Label1, null);
    panel1.add(Label3, null);
    panel1.add(Label2, null);
    panel1.add(label20, null);
    panel1.add(textFieldSIMax, null);
    textFieldSIMax.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldSIMax.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldSIMax.selectAll();
      }
    });
    panel1.add(label26, null);
    panel1.add(textFieldHaerteMin, null);
    textFieldHaerteMin.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldHaerteMin.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldHaerteMin.selectAll();
      }
    });
    panel1.add(labelHaerteMax, null);
    panel1.add(textFieldHaerteMax, null);
    textFieldHaerteMax.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldHaerteMax.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldHaerteMax.selectAll();
      }
    });
    panel1.add(labelLFMax, null);
    panel1.add(textFieldLFMax, null);
    textFieldLFMax.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldLFMax.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldLFMax.selectAll();
      }
    });
    panel1.add(labelAlkalitaetMin, null);
    panel1.add(textFieldAlkalitaetMin, null);
    textFieldAlkalitaetMin.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldAlkalitaetMin.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldAlkalitaetMin.selectAll();
      }
    });
    panel1.add(labelTW, null);
    panel1.add(textFieldTW, null);
    textFieldTW.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldTW.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldTW.selectAll();
      }
    });
    panel1.add(labelROMax, null);
    panel1.add(textFieldSImax2, null);
    textFieldSImax2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldSImax2.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldSImax2.selectAll();
      }
    });
    panel1.add(Label4, null);
    panel1.add(buttonOK, null);
  }

  void buttonOK_mouseClicked(MouseEvent e) {
    grenzwerte fehlerTest = new grenzwerte();
    fehlerTest = einlesen(); //Testweises einlesen in temporaeres Object
    if (gelesen == false) {
      gelesen = true;
      dialogframe meinDialog = new dialogframe();
      warndialog keineZahl = new warndialog(meinDialog, startframe.Texte.elementAt(158).toString(), true);
      keineZahl.setSize(300, 150);
      keineZahl.setLocation(positionX(300), positionY(150));
      keineZahl.meldung(startframe.Texte.elementAt(159).toString());

      return;
    }
    else {
      dispose();
    }
  }

  public grenzwerte einlesen() {
    grenzwerte bedingungenE = new grenzwerte();

    try {
      bedingungenE.siMax = Double.parseDouble(textFieldSIMax.getText());
    }
    catch (NumberFormatException e) {
      textFieldSIMax.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    bedingungenE.clMax = 0.0;
    bedingungenE.so4Max = 0.0;
    try {
      bedingungenE.roMax = Double.parseDouble(textFieldSImax2.getText());
    }
    catch (NumberFormatException e) {
      textFieldSImax2.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      bedingungenE.dhMin = Double.parseDouble(textFieldHaerteMin.getText());
    }
    catch (NumberFormatException e) {
      textFieldHaerteMin.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      bedingungenE.dhMax = Double.parseDouble(textFieldHaerteMax.getText());
    }
    catch (NumberFormatException e) {
      textFieldHaerteMax.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      bedingungenE.alkMin = Double.parseDouble(textFieldAlkalitaetMin.getText());
    }
    catch (NumberFormatException e) {
      textFieldAlkalitaetMin.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }
    bedingungenE.tW = 0.0;
    bedingungenE.tKT = 0.0;
    try {
      bedingungenE.tLW = Double.parseDouble(textFieldTW.getText());
    }
    catch (NumberFormatException e) {
      textFieldTW.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }
    try {
      bedingungenE.lF = Double.parseDouble(textFieldLFMax.getText());
    }
    catch (NumberFormatException e) {
      textFieldLFMax.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }
    return bedingungenE;
  }

  public void auslesen(grenzwerte grenzAus) {
    textFieldSIMax.setText(Double.toString(grenzAus.siMax));
    textFieldSImax2.setText(Double.toString(grenzAus.roMax));
    textFieldHaerteMin.setText(Double.toString(grenzAus.dhMin));
    textFieldHaerteMax.setText(Double.toString(grenzAus.dhMax));
    textFieldAlkalitaetMin.setText(Double.toString(grenzAus.alkMin));
    textFieldTW.setText(Double.toString(grenzAus.tLW));
    textFieldLFMax.setText(Double.toString(grenzAus.lF));

  }

  int positionX(int x) {
    Point posParent;
    int b, posX;
    posParent = this.getLocation();
    b = this.getSize().width;
    posX = (int) ( (posParent.x + b / 2) - (x / 2));
    return posX;
  }

  //Rückgabe der Position
  int positionY(int y) {
    Point posParent;
    int h, posY;
    posParent = this.getLocation();
    h = this.getSize().height;
    posY = (int) ( (posParent.y + h / 2) - (y / 2));
    return posY;
  }

  void punktStattKomma(KeyEvent event) { //Kommaeingabe gegen Punkteingabe tauschen
    int taste = event.getKeyCode();
    if (taste == 44) {
      event.setKeyCode(46);
    }
    if (taste == 10) {
      event.setKeyCode(9);
    }
  }
}
