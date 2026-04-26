//package watkost;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//import watklassen.*;

public class kostendialog
    extends Dialog {
  //Variablen definieren
  boolean gelesen = true; //einlesen() Exception
  boolean isStandalone = false;
  GridLayout gridLayout1 = new GridLayout();
  JPanel panel1 = new JPanel();
  JLabel label1 = new JLabel();
  JLabel label2 = new JLabel();
  JLabel label3 = new JLabel();
  JLabel label9 = new JLabel();
  JLabel label11 = new JLabel();
  JLabel labelDosK = new JLabel();
  JLabel label13 = new JLabel();
  JLabel labelDosH = new JLabel();
  JLabel label16 = new JLabel();
  JLabel label17 = new JLabel();
  JLabel label19 = new JLabel();
  JLabel label20 = new JLabel();
  JLabel labelAuslastung = new JLabel();
  JLabel label22 = new JLabel();
  JLabel label24 = new JLabel();
  JLabel label25 = new JLabel();
  JLabel label30 = new JLabel();
  JLabel label32 = new JLabel();
  JTextField textFieldStadtWasser = new JTextField();
  JTextField textFieldKuehlleistung = new JTextField();
  JTextField textFieldWaescherleistung = new JTextField();
  JTextField textFieldEnergie = new JTextField();
  JTextField textFieldAuslastung = new JTextField();
  JTextField textFieldSchwefelsaeure = new JTextField();
  JTextField textFieldROK = new JTextField();
  JTextField textFieldDosH = new JTextField();
  JTextField textFieldAbWasser = new JTextField();
  JTextField textFieldSalzTab = new JTextField();
  JTextField textFieldDosK = new JTextField();
  JTextField textFieldSalzSaeure = new JTextField();
  JTextField textFieldAbWasser2 = new JTextField();
  GridLayout gridLayout2 = new GridLayout();
  JLabel label4 = new JLabel();
  JTextField textFieldROM = new JTextField();
  JButton buttonOK = new JButton();
  JLabel label5 = new JLabel();
  JLabel label6 = new JLabel();
  JLabel label31 = new JLabel();
  JTextField textFieldDosName = new JTextField();

  //Construct the applet
  public kostendialog(Frame AufrufVonFenster, String text, boolean modal) {
    super(AufrufVonFenster, startframe.Texte.elementAt(161).toString().replace("€/Kg", "€/kg"), true);
    this.addWindowListener(new fensterZu());
    this.setLayout(gridLayout1);
    panel1.setBackground(new Color(72, 157, 255));
    panel1.setLayout(gridLayout2);
    label1.setFont(new java.awt.Font("Dialog", 1, 10));
    label1.setForeground(Color.red);
    label1.setText(startframe.Texte.elementAt(94).toString().replace("€/Kg", "€/kg"));
    label9.setForeground(Color.black);
    label9.setText(startframe.Texte.elementAt(132).toString().replace("€/Kg", "€/kg"));
    label11.setForeground(Color.black);
    label11.setText(startframe.Texte.elementAt(106).toString().replace("€/Kg", "€/kg"));
    labelDosK.setForeground(Color.black);
    labelDosK.setText(startframe.Texte.elementAt(187).toString().replace("€/Kg", "€/kg"));
    labelDosH.setForeground(Color.black);
    labelDosH.setText(startframe.Texte.elementAt(182).toString().replace("€/Kg", "€/kg"));
    label16.setForeground(Color.black);
    label16.setText(startframe.Texte.elementAt(92).toString().replace("€/Kg", "€/kg"));
    label17.setForeground(Color.black);
    label17.setText(startframe.Texte.elementAt(185).toString().replace("€/Kg", "€/kg"));
    label19.setForeground(Color.black);
    label19.setText(startframe.Texte.elementAt(188).toString().replace("€/Kg", "€/kg"));
    label20.setForeground(Color.black);
    label20.setText(startframe.Texte.elementAt(107).toString().replace("€/Kg", "€/kg"));
    labelAuslastung.setForeground(Color.black);
    labelAuslastung.setText(startframe.Texte.elementAt(134).toString().replace("€/Kg", "€/kg"));
    label22.setForeground(Color.black);
    label22.setText(startframe.Texte.elementAt(180).toString().replace("€/Kg", "€/kg"));
    label25.setForeground(Color.black);
    label25.setText(startframe.Texte.elementAt(186).toString().replace("€/Kg", "€/kg"));
    label30.setForeground(Color.black);
    label30.setText(startframe.Texte.elementAt(133).toString().replace("€/Kg", "€/kg"));
    label32.setForeground(Color.black);
    label32.setText(startframe.Texte.elementAt(181).toString().replace("€/Kg", "€/kg"));
    textFieldStadtWasser.setText("textField1");
    textFieldKuehlleistung.setText("textField2");
    textFieldWaescherleistung.setText("");
    textFieldEnergie.setText("textField3");
    textFieldAuslastung.setText("textField4");
    textFieldSchwefelsaeure.setText("textField5");
    textFieldROK.setText("textField6");
    textFieldDosH.setText("textField7");
    textFieldAbWasser.setText("textField9");
    textFieldSalzTab.setText("textField10");
    textFieldDosK.setText("textField11");
    textFieldSalzSaeure.setText("textField12");
    gridLayout2.setColumns(4);
    gridLayout2.setHgap(4);
    gridLayout2.setRows(9);
    gridLayout2.setVgap(4);
    label4.setForeground(Color.black);
    label4.setText(startframe.Texte.elementAt(182).toString().replace("€/Kg", "€/kg"));
    textFieldROM.setText("textField8");
    textFieldDosName.setText(startframe.Texte.elementAt(183).toString().replace("€/Kg", "€/kg"));
    label31.setForeground(Color.black);
    label31.setText(startframe.Texte.elementAt(223).toString().replace("€/Kg", "€/kg"));
    //buttonOK.setBackground(Color.lightGray);
    buttonOK.setText("ok");
    this.add(panel1, null);
    panel1.add(label1, null);
    //panel1.add(label2,null);
    panel1.add(label3, null);
    panel1.add(label13, null);
    panel1.add(label24, null);
    panel1.add(label22, null);
    panel1.add(textFieldStadtWasser, null);
    textFieldStadtWasser.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldStadtWasser.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldStadtWasser.selectAll();
      }
    });
    panel1.add(label17, null);
    panel1.add(textFieldAbWasser, null);
    textFieldAbWasser.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldAbWasser.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldAbWasser.selectAll();
      }
    });
    panel1.add(label32, null);
    panel1.add(textFieldAbWasser2, null);
    textFieldAbWasser2.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldAbWasser2.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldAbWasser2.selectAll();
      }
    });
    panel1.add(label16, null);
    panel1.add(textFieldEnergie, null);
    textFieldEnergie.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldEnergie.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldEnergie.selectAll();
      }
    });
    panel1.add(labelDosK, null);
   panel1.add(textFieldDosK, null);
   textFieldDosK.addKeyListener(new java.awt.event.KeyAdapter() {
     public void keyPressed(KeyEvent event) {
       punktStattKomma(event);
     }
   });
   textFieldDosK.addFocusListener(new java.awt.event.FocusAdapter() {
     public void focusGained(FocusEvent f) {
       textFieldDosK.selectAll();
     }
   });
   panel1.add(label20, null);
       panel1.add(textFieldSalzTab, null);
       textFieldSalzTab.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(KeyEvent event) {
           punktStattKomma(event);
         }
       });
       textFieldSalzTab.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(FocusEvent f) {
           textFieldSalzTab.selectAll();
         }
       });
       panel1.add(label25, null);
       panel1.add(textFieldSalzSaeure, null);
       textFieldSalzSaeure.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(KeyEvent event) {
           punktStattKomma(event);
         }
       });
       textFieldSalzSaeure.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(FocusEvent f) {
           textFieldSalzSaeure.selectAll();
         }
       });
       panel1.add(label19, null);
       panel1.add(textFieldSchwefelsaeure, null);
       textFieldSchwefelsaeure.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(KeyEvent event) {
           punktStattKomma(event);
         }
       });
       textFieldSchwefelsaeure.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(FocusEvent f) {
           textFieldSchwefelsaeure.selectAll();
         }
       });
       panel1.add(label11, null);
       panel1.add(textFieldROK, null);
       textFieldROK.addKeyListener(new java.awt.event.KeyAdapter() {
         public void keyPressed(KeyEvent event) {
           punktStattKomma(event);
         }
       });
       textFieldROK.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(FocusEvent f) {
           textFieldROK.selectAll();
         }
    });

    panel1.add(label31, null);
  panel1.add(textFieldDosName, null);
  textFieldDosName.addKeyListener(new java.awt.event.KeyAdapter() {
    public void keyPressed(KeyEvent event) {
      punktStattKomma(event);
    }
  });
  textFieldDosName.addFocusListener(new java.awt.event.FocusAdapter() {
    public void focusGained(FocusEvent f) {
      textFieldDosName.selectAll();
    }
  });

    panel1.add(label9, null);
    panel1.add(textFieldKuehlleistung, null);
    textFieldKuehlleistung.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldKuehlleistung.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldKuehlleistung.selectAll();
      }
    });
    panel1.add(label30, null);
    panel1.add(textFieldWaescherleistung, null);
    textFieldWaescherleistung.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldWaescherleistung.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldWaescherleistung.selectAll();
      }
    });
    panel1.add(labelAuslastung, null);
    panel1.add(textFieldAuslastung, null);
    textFieldAuslastung.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldAuslastung.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldAuslastung.selectAll();
      }
    });

    panel1.add(labelDosH, null);
    panel1.add(textFieldDosH, null);
    textFieldDosH.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldDosH.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldDosH.selectAll();
      }
    });

    panel1.add(label4, null);
    panel1.add(textFieldROM, null);
    textFieldROM.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldROM.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldROM.selectAll();
      }
    });

    panel1.add(buttonOK, null);
    //panel1.add(label5, null);
    //panel1.add(label6, null);
    buttonOK.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        buttonOK_mouseClicked(e);
      }
    });
  }

  void buttonOK_mouseClicked(MouseEvent e) {
    kosten fehlerTest = new kosten();
    fehlerTest = einlesen(); //Testweises einlesen in temporaeres Object
    if (gelesen == false) {
      gelesen = true;
      dialogframe meinDialog = new dialogframe();
      warndialog keineZahl = new warndialog(meinDialog, startframe.Texte.elementAt(158).toString().replace("€/Kg", "€/kg"), true);
      keineZahl.setSize(300, 150);
      keineZahl.setLocation(positionX(300), positionY(150));
      keineZahl.meldung(startframe.Texte.elementAt(159).toString().replace("€/Kg", "€/kg"));
      keineZahl.setVisible(true);
      return;
    }
    else {
      dispose();
    }
  }

  public kosten einlesen() {
    kosten rohKosten = new kosten();
    try {
      rohKosten.stadtWasser = ptd(textFieldStadtWasser.getText());
    }
    catch (NumberFormatException e) {
      textFieldStadtWasser.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.abWasser = ptd(textFieldAbWasser.getText());
    }
    catch (NumberFormatException e) {
      textFieldAbWasser.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.regenWasser = ptd(textFieldAbWasser2.getText());
    }
    catch (NumberFormatException e) {
      textFieldAbWasser2.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.energie = ptd(textFieldEnergie.getText());
    }
    catch (NumberFormatException e) {
      textFieldEnergie.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.leistung = ptd(textFieldKuehlleistung.getText());
    }
    catch (NumberFormatException e) {
      textFieldKuehlleistung.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.leistung2 = ptd(textFieldWaescherleistung.
                                               getText());
    }
    catch (NumberFormatException e) {
      textFieldWaescherleistung.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.auslastung = ptd(textFieldAuslastung.getText());
    }
    catch (NumberFormatException e) {
      textFieldAuslastung.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.dosierMittel = ptd(textFieldDosK.getText());
    }
    catch (NumberFormatException e) {
      textFieldDosK.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.dosierMenge = ptd(textFieldDosH.getText());
    }
    catch (NumberFormatException e) {
      textFieldDosH.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.salzTabletten = ptd(textFieldSalzTab.getText());
    }
    catch (NumberFormatException e) {
      textFieldSalzTab.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.salzSaeure = ptd(textFieldSalzSaeure.getText());
    }
    catch (NumberFormatException e) {
      textFieldSalzSaeure.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.schwefelSaeure = ptd(textFieldSchwefelsaeure.
          getText());
    }
    catch (NumberFormatException e) {
      textFieldSchwefelsaeure.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.ro = ptd(textFieldROK.getText());
    }
    catch (NumberFormatException e) {
      textFieldROK.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }

    try {
      rohKosten.roMenge = ptd(textFieldROM.getText());
    }
    catch (NumberFormatException e) {
      textFieldROM.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
      gelesen = false;
    }
    try {
     rohKosten.dosierMittelName = textFieldDosName.getText();
   }
   catch (NumberFormatException e) {
     textFieldROM.setText(startframe.Texte.elementAt(174).toString().replace("€/Kg", "€/kg"));
     gelesen = false;
   }

    return rohKosten;
  }

  public void auslesen(kosten kostenAus) {
    //aus dem array ins Fenster
    textFieldStadtWasser.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.stadtWasser));
    textFieldAbWasser.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.abWasser));
    textFieldAbWasser2.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.regenWasser));
    textFieldEnergie.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.energie));
    textFieldKuehlleistung.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.leistung));
    textFieldWaescherleistung.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.leistung2));
    textFieldAuslastung.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.auslastung));
    textFieldDosK.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.dosierMittel));
    textFieldDosH.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.dosierMenge));
    textFieldSalzTab.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.salzTabletten));
    textFieldSalzSaeure.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.salzSaeure));
    textFieldSchwefelsaeure.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.schwefelSaeure));
    textFieldROK.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.ro));
    textFieldROM.setText(String.format(java.util.Locale.GERMAN, "%.2f", kostenAus.roMenge));
    textFieldDosName.setText(kostenAus.dosierMittelName);
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
  private static String dts(double v) {
    return Double.toString(v).replace('.', ',');
  }
  private static double ptd(String s) {
    return Double.parseDouble(s.replace(',', '.'));
  }
}