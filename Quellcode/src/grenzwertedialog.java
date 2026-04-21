//package watkost;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import watklassen.*;



public class grenzwertedialog
    extends Dialog {
  //Variablen
  boolean gelesen = true; //wenn bei einlesen() keine Exception
  JPanel panel1 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  JLabel label1 = new JLabel();
  GridLayout gridLayout2 = new GridLayout();
  JLabel label7 = new JLabel();
  JLabel label9 = new JLabel();
  JLabel label10 = new JLabel();
  JLabel label15 = new JLabel();
  JLabel label18 = new JLabel();
  JLabel label22 = new JLabel();
  JLabel label25 = new JLabel();
  JLabel labelCaMax = new JLabel();
  JTextField textFieldCaMax = new JTextField();
  JTextField textClMax = new JTextField();
  JTextField textFieldSo4Max = new JTextField();
  JTextField textFieldTW = new JTextField();
  JTextField textFieldTKT = new JTextField();
  JTextField textFieldROMax = new JTextField();
  JTextField textFieldSIMax1 = new JTextField();
  JTextField textFieldEF = new JTextField();
  JButton buttonOK = new JButton();
  JLabel label41 = new JLabel();
  JLabel label46 = new JLabel();
  JLabel label48 = new JLabel();
  JLabel label50 = new JLabel();
  JLabel labelEF = new JLabel();

  //Construct the applet
  public grenzwertedialog(Frame AufrufVonFenster, String text, boolean modal) {

    //
    super(AufrufVonFenster, startframe.Texte.elementAt(160).toString(), true);
    this.addWindowListener(new fensterZu());
    this.setLayout(gridLayout1);
    gridLayout1.setColumns(1);
    gridLayout1.setHgap(4);
    gridLayout1.setVgap(4);
    panel1.setBackground(new Color(72, 157, 255));
    panel1.setLayout(gridLayout2);
    label1.setFont(new java.awt.Font("Dialog", 1, 12));
    label1.setForeground(Color.red);
    gridLayout2.setColumns(4);
    gridLayout2.setHgap(4);
    gridLayout2.setRows(6);
    gridLayout2.setVgap(4);
    labelEF.setForeground(Color.black);
    labelEF.setText(startframe.Texte.elementAt(54).toString());
    label7.setForeground(Color.black);
    label7.setText(startframe.Texte.elementAt(129).toString());
    label10.setForeground(Color.black);
    label10.setText(startframe.Texte.elementAt(121).toString());
    label15.setForeground(Color.black);
    label15.setText(startframe.Texte.elementAt(120).toString());
    label22.setForeground(Color.black);
    label22.setText(startframe.Texte.elementAt(118).toString());
    label25.setForeground(Color.black);
    label25.setText(startframe.Texte.elementAt(123).toString());
    labelCaMax.setForeground(Color.black);
    labelCaMax.setText(startframe.Texte.elementAt(122).toString());
    textClMax.setForeground(Color.black);
    textClMax.setText("250");
    textFieldSo4Max.setForeground(Color.black);
    textFieldSo4Max.setText("400");
    textFieldTW.setForeground(Color.black);
    textFieldTW.setText("30");
    textFieldTKT.setForeground(Color.black);
    textFieldTKT.setText("30");
    textFieldROMax.setForeground(Color.black);
    textFieldROMax.setText("2.0");
    textFieldSIMax1.setForeground(Color.black);
    textFieldSIMax1.setText("2.3");
    textFieldCaMax.setForeground(Color.black);
    textFieldCaMax.setText("0.5");
    textFieldEF.setForeground(Color.black);
    textFieldEF.setText("5.0");

    //buttonOK.setBackground(Color.lightGray);
    //buttonOK.setForeground(Color.black);
    buttonOK.setText("ok");
    label46.setForeground(Color.black);
    label46.setText(startframe.Texte.elementAt(117).toString());
    label9.setFont(new java.awt.Font("Dialog", 1, 10));
    label9.setForeground(Color.red);
    label9.setText(startframe.Texte.elementAt(48).toString());
    this.add(panel1, null);
    panel1.add(label9, null);
    panel1.add(label1, null);
    panel1.add(label41, null);
    panel1.add(label48, null);
    panel1.add(labelEF,null);
    panel1.add(textFieldEF, null);
    textFieldEF.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    panel1.add(label25, null);
    panel1.add(textFieldSIMax1, null);
    textFieldSIMax1.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldSIMax1.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldSIMax1.selectAll();
      }
    });
    panel1.add(label46, null);
    panel1.add(textClMax, null);
    textClMax.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textClMax.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textClMax.selectAll();
      }
    });
    panel1.add(label22, null);
    panel1.add(textFieldSo4Max, null);
    textFieldSo4Max.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldSo4Max.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldSo4Max.selectAll();
      }
    });
    panel1.add(label7, null);
    panel1.add(textFieldROMax, null);
    textFieldROMax.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldROMax.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldROMax.selectAll();
      }
    });
    panel1.add(label15, null);
    panel1.add(textFieldTKT, null);
    textFieldTKT.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldTKT.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldTKT.selectAll();
      }
    });
    panel1.add(label10, null);
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
    panel1.add(labelCaMax, null);
    panel1.add(textFieldCaMax, null);
    textFieldCaMax.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldCaMax.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldTW.selectAll();
      }
    });

    panel1.add(buttonOK, null);
    buttonOK.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        buttonOK_mouseClicked(e);
      }
    });
  }

  void buttonOK_mouseClicked(MouseEvent e) {
    grenzwerte fehlerTest = new grenzwerte();
    fehlerTest = einlesen(); //Testweises einlesen in temporaeres Object
    if (gelesen == false) {
      gelesen = true;
      dialogframe meinDialog = new dialogframe();
      warndialog keineZahl = new warndialog(meinDialog, "startframe.Texte.elementAt(158).toString()", true);
      keineZahl.setSize(300, 150);
      keineZahl.setLocation(positionX(300), positionY(150));
      keineZahl.meldung(startframe.Texte.elementAt(159).toString());
      keineZahl.setVisible(true);
      return;
    }
    else {
      dispose();
    }
  }

  public grenzwerte einlesen() {
    grenzwerte bedingungenE = new grenzwerte();
    try {
      bedingungenE.EF = Double.parseDouble(textFieldEF.getText());
    }
    catch (NumberFormatException e) {
      textFieldSIMax1.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      bedingungenE.siMax = Double.parseDouble(textFieldSIMax1.getText());
    }
    catch (NumberFormatException e) {
      textFieldSIMax1.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }
    try {
      bedingungenE.clMax = Double.parseDouble(textClMax.getText());
    }
    catch (NumberFormatException e) {
      textClMax.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      bedingungenE.so4Max = Double.parseDouble(textFieldSo4Max.getText());
    }
    catch (NumberFormatException e) {
      textFieldSo4Max.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      bedingungenE.roMax = Double.parseDouble(textFieldROMax.getText());
    }
    catch (NumberFormatException e) {
      textFieldROMax.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }
    bedingungenE.dhMin = 0.0;
    bedingungenE.dhMax = 0.0;
    bedingungenE.alkMin = 0.0;
    try {
      bedingungenE.tW = Double.parseDouble(textFieldTW.getText());
    }
    catch (NumberFormatException e) {
      textFieldTW.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }
    try {
      bedingungenE.tKT = Double.parseDouble(textFieldTKT.getText());
    }
    catch (NumberFormatException e) {
      textFieldTKT.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }
    try {
      bedingungenE.caMax = Double.parseDouble(textFieldCaMax.getText());
    }
    catch (NumberFormatException e) {
      textFieldCaMax.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    bedingungenE.tLW = 0.0;
    bedingungenE.lF = 0.0;
    return bedingungenE;
  }

  public void auslesen(grenzwerte grenzAus) { //aus Variable lesen
    textFieldEF.setText(Double.toString(grenzAus.EF));
    textFieldSIMax1.setText(Double.toString(grenzAus.siMax));
    textClMax.setText(Double.toString(grenzAus.clMax));
    textFieldSo4Max.setText(Double.toString(grenzAus.so4Max));
    textFieldROMax.setText(Double.toString(grenzAus.roMax));
    textFieldTW.setText(Double.toString(grenzAus.tW));
    textFieldTKT.setText(Double.toString(grenzAus.tKT));
    textFieldCaMax.setText(Double.toString(grenzAus.caMax));
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
