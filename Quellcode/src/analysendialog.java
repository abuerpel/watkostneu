//package watkost;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

//import watkost.*;
//import watklassen.*;


public class analysendialog
    extends JDialog {
  //Datenmodul implementieren
  //data datenBank = new data();
  double dNa, dLfBer, dSuK, dSuA, dI, dCo2, dCo3, dHCo3, dNo3;
  boolean gelesen = true;
  JPanel panel1 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  GridLayout gridLayout2 = new GridLayout();
  navigation navigationPane = new navigation();
  dataAction1 dataActionPane1 = new dataAction1();
  dataAction2 dataActionPane2 = new dataAction2();
  JLabel labelDatenSatzNummer = new JLabel();
  JTextField textFieldAnalysenNummer = new JTextField();
  JTextField textFieldKunde = new JTextField();
  JTextField textFieldProjekt = new JTextField();
  JTextField textFieldTE = new JTextField();
  JTextField textFieldpH = new JTextField();
  JTextField textFieldMg = new JTextField();
  JTextField textFieldLF = new JTextField();
  JTextField textFieldBearbeiter = new JTextField();
  JTextField textFieldCa = new JTextField();
  JTextField textFieldNO3 = new JTextField();
  JTextField textFieldKS = new JTextField();
  JTextField textFieldCl = new JTextField();
  JTextField textFieldSO4 = new JTextField();
  JTextField textFieldSITE = new JTextField();
  JTextField textFieldGGWpH = new JTextField();
  JTextField textFieldCO2 = new JTextField();
  JTextField textFieldCO3 = new JTextField();
  JTextField textFieldHCO3 = new JTextField();
  JLabel label1 = new JLabel();
  JLabel label2 = new JLabel();
  JLabel label3 = new JLabel();
  JLabel label4 = new JLabel();
  JLabel label5 = new JLabel();
  JLabel label6 = new JLabel();
  JLabel label7 = new JLabel();
  JLabel label8 = new JLabel();
  JLabel label9 = new JLabel();
  JLabel label10 = new JLabel();
  JLabel label11 = new JLabel();
  JLabel labelProjekt = new JLabel();
  JLabel label13 = new JLabel();
  JLabel label14 = new JLabel();
  JLabel label15 = new JLabel();
  JLabel label16 = new JLabel();
  JLabel label17 = new JLabel();
  JLabel label18 = new JLabel();
  JLabel label19 = new JLabel();
  JLabel label20 = new JLabel();
  JLabel label21 = new JLabel();
  JLabel label22 = new JLabel();
  JLabel label23 = new JLabel();
  JLabel label24 = new JLabel();
  JLabel label25 = new JLabel();
  JLabel label26 = new JLabel();
  JButton buttonOK = new JButton("ok");
  JButton buttonFW = new JButton(startframe.Texte.elementAt(25).toString());
  //BasicArrowButton buttonFW = new BasicArrowButton(3);
  //BasicArrowButton buttonBW = new BasicArrowButton(7);
  JButton buttonBW = new JButton(startframe.Texte.elementAt(26).toString());
  JButton buttonSave = new JButton();
  JButton buttonNeu = new JButton();
  JButton buttonDel = new JButton();
  JPanel navigationPanel1 = new JPanel();
  JLabel label27 = new JLabel();
  JLabel label28 = new JLabel();
  JLabel label29 = new JLabel();
  JLabel label30 = new JLabel();
  JLabel label31 = new JLabel();

  //Component initialization
  public analysendialog(Frame AufrufVonFenster, String text, boolean modal) {
    super(AufrufVonFenster, startframe.Texte.elementAt(109).toString(), true);

    this.addWindowListener(new analyseFensterZu());
    this.setLayout(gridLayout1);
    if (startframe.rowAna > 0) {
      startframe.datenBank.setzen(startframe.rowAna);
    }
    panel1.setBackground(new Color(72, 157, 255));
    panel1.setForeground(Color.red);
    panel1.setLayout(gridLayout2);
    gridLayout2.setColumns(6);
    gridLayout2.setHgap(4);
    gridLayout2.setRows(9);
    gridLayout2.setVgap(4);
    textFieldSITE.setEditable(false);
    textFieldGGWpH.setEditable(false);
    textFieldCO2.setEditable(false);
    textFieldCO3.setEditable(false);
    textFieldHCO3.setEditable(false);
    labelDatenSatzNummer.setText("0");
    labelDatenSatzNummer.setForeground(Color.black);
    labelDatenSatzNummer.setFont(new java.awt.Font("Dialog", 1, 10));
    label1.setText(startframe.Texte.elementAt(111).toString());
    label1.setForeground(Color.black);
    label17.setForeground(Color.black);
    label2.setText(startframe.Texte.elementAt(65).toString());
    label2.setForeground(Color.black);
    label3.setText(startframe.Texte.elementAt(58).toString());
    label3.setForeground(Color.black);
    label4.setText(startframe.Texte.elementAt(63).toString());
    label4.setForeground(Color.black);
    label5.setText(startframe.Texte.elementAt(62).toString());
    label5.setForeground(Color.black);
    label6.setText(startframe.Texte.elementAt(113).toString());
    label6.setForeground(Color.black);
    label7.setForeground(Color.red);
    label7.setFont(new java.awt.Font("Dialog", 1, 10));
    label7.setText(startframe.Texte.elementAt(20).toString());
    label8.setText(startframe.Texte.elementAt(59).toString());
    label8.setForeground(Color.black);
    label11.setText(startframe.Texte.elementAt(114).toString());
    label11.setForeground(Color.black);
    labelProjekt.setText(startframe.Texte.elementAt(112).toString());
    labelProjekt.setForeground(Color.black);
    label13.setText(startframe.Texte.elementAt(60).toString());
    label13.setForeground(Color.black);
    label14.setText(startframe.Texte.elementAt(115).toString());
    label14.setForeground(Color.black);
    label15.setText(startframe.Texte.elementAt(116).toString());
    label15.setForeground(Color.black);
    label17.setText(startframe.Texte.elementAt(47).toString());
    label17.setForeground(Color.black);
    label22.setText(startframe.Texte.elementAt(64).toString());
    label22.setForeground(Color.black);
    label27.setText(startframe.Texte.elementAt(80).toString());
    label27.setForeground(Color.black);
    label28.setText(startframe.Texte.elementAt(54).toString());
    label28.setForeground(Color.black);
    label29.setText(startframe.Texte.elementAt(81).toString());
    label29.setForeground(Color.black);
    label30.setText(startframe.Texte.elementAt(78).toString());
    label30.setForeground(Color.black);
    label31.setText(startframe.Texte.elementAt(77).toString());
    label31.setForeground(Color.black);
    buttonFW.setFont(new java.awt.Font("Dialog", 1, 10));
    buttonFW.setToolTipText("Datensatz vor");
    buttonFW.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        buttonFW_mouseClicked(e);
      }
    });
    buttonBW.setFont(new java.awt.Font("Dialog", 1, 10));
    buttonBW.setToolTipText("Datensatz zurück");
    buttonBW.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        buttonBW_mouseClicked(e);
      }
    });

    buttonSave.setFont(new java.awt.Font("Dialog", 1, 10));
    buttonSave.setText(startframe.Texte.elementAt(5).toString());
    buttonSave.setToolTipText("Datensatz speichern");
    buttonSave.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        buttonSave_mouseClicked(e);
      }
    });

    buttonNeu.setFont(new java.awt.Font("Dialog", 1, 10));
    buttonNeu.setText(startframe.Texte.elementAt(3).toString());
    buttonNeu.setToolTipText("neuer Datensatz");
    buttonNeu.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        buttonNeu_mouseClicked(e);
      }
    });

    buttonDel.setFont(new java.awt.Font("Dialog", 1, 10));
    buttonDel.setText(startframe.Texte.elementAt(110).toString());
    buttonDel.setToolTipText("aktuellen Datensatz löschen");
    buttonDel.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        buttonDel_mouseClicked(e);
      }
    });
    //

    this.add(panel1, null);
    panel1.add(label7, null);
    panel1.add(label23, null);
    panel1.add(label24, null);
    panel1.add(label10, null);
    panel1.add(label26, null);
    panel1.add(label9, null);
    //panel1.add(label20, null);
    panel1.add(labelDatenSatzNummer);
    panel1.add(buttonBW, null);
    panel1.add(buttonFW, null);
    panel1.add(buttonSave, null);
    panel1.add(buttonNeu, null);
    panel1.add(buttonDel, null);
    // panel1.add(navigationPane);
    //panel1.add(dataActionPane1);
    //panel1.add(dataActionPane2);
    // panel1.add(label28, null);
    //panel1.add(label16, null);
    panel1.add(label17, null);
    panel1.add(textFieldAnalysenNummer, null);
    textFieldAnalysenNummer.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldAnalysenNummer.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldAnalysenNummer.selectAll();
      }
    });
    panel1.add(label1, null);
    panel1.add(textFieldKunde, null);
    textFieldKunde.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldKunde.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldKunde.selectAll();
      }
    });
    panel1.add(labelProjekt, null);
    panel1.add(textFieldProjekt, null);
    textFieldProjekt.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldProjekt.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldProjekt.selectAll();
      }
    });
    panel1.add(label6, null);
    panel1.add(textFieldBearbeiter, null);
    textFieldBearbeiter.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldBearbeiter.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldBearbeiter.selectAll();
      }
    });
    panel1.add(label14, null);

    //Tastenbefehle abfangen
    panel1.add(textFieldTE, null);
    textFieldTE.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldTE.selectAll();
      }
    });

    textFieldTE.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    panel1.add(label15, null);
    panel1.add(textFieldpH, null);
    textFieldpH.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldpH.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldpH.selectAll();
      }
    });
    panel1.add(label3, null);
    panel1.add(textFieldLF, null);
    textFieldLF.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldLF.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldLF.selectAll();
      }
    });
    panel1.add(label8, null);
    panel1.add(textFieldCa, null);
    textFieldCa.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldCa.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldCa.selectAll();
      }
    });
    panel1.add(label13, null);
    panel1.add(textFieldMg, null);
    textFieldMg.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldMg.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldMg.selectAll();
      }
    });
    panel1.add(label5, null);
    panel1.add(textFieldKS, null);
    textFieldKS.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldKS.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldKS.selectAll();
      }
    });
    panel1.add(label4, null);
    panel1.add(textFieldCl, null);
    textFieldCl.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldCl.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldCl.selectAll();
      }
    });
    panel1.add(label22, null);
    panel1.add(textFieldSO4, null);
    textFieldSO4.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldSO4.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldSO4.selectAll();
      }
    });
    panel1.add(label2, null);
    panel1.add(textFieldNO3, null);
    textFieldNO3.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(KeyEvent event) {
        punktStattKomma(event);
      }
    });
    textFieldNO3.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(FocusEvent f) {
        textFieldNO3.selectAll();
      }
    });
    panel1.add(label27, null);
    panel1.add(textFieldGGWpH, null);
    panel1.add(label11, null);
    panel1.add(textFieldSITE, null);
    panel1.add(label29, null);
    panel1.add(textFieldCO2,null);
    panel1.add(label30, null);
    ///
    panel1.add(textFieldCO3,null);
    panel1.add(label31, null);
    panel1.add(textFieldHCO3,null);
    panel1.add(label25, null);
    panel1.add(buttonOK, null);
    buttonOK.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        buttonOK_mouseClicked(e);
      }
    });
  }

  void buttonFW_mouseClicked(MouseEvent e) {
    rohanalyse ra = startframe.datenBank.vor();
    auslesen(ra);
    berechne();
  }

  void buttonBW_mouseClicked(MouseEvent e) {
    rohanalyse ra = startframe.datenBank.rueck();
    auslesen(ra);
    berechne();
  }

  void buttonNeu_mouseClicked(MouseEvent e) {
    textFieldAnalysenNummer.setText("");
    textFieldKunde.setText("");
    textFieldBearbeiter.setText("");
    textFieldProjekt.setText("");
    textFieldTE.setText("0.00");
    textFieldpH.setText("0.00");
    textFieldLF.setText("0.00");
    textFieldCa.setText("0.00");
    textFieldMg.setText("0.00");
    textFieldKS.setText("0.00");
    textFieldCl.setText("0.00");
    textFieldSO4.setText("0.00");
    textFieldNO3.setText("0.00");
    textFieldGGWpH.setText("0.00");
    textFieldSITE.setText("0.00");
    textFieldCO2.setText("0.00");
    textFieldCO3.setText("0.00");
    textFieldHCO3.setText("0.00");

  }

  void buttonSave_mouseClicked(MouseEvent e) {
    boolean pruefResult = pruefen(berechne());
    if (pruefResult) {
      startframe.datenBank.insert(einlesen());
    }
    auslesen(startframe.datenBank.getData());
    berechne();
    return;
  }

  void buttonDel_mouseClicked(MouseEvent e) {
    rohanalyse ra = startframe.datenBank.loeschen();
    auslesen(ra);
    berechne();
  }

  void buttonOK_mouseClicked(MouseEvent e) {
    //int fehler;
    //fehler = berechne();
    int b = berechne();
    boolean pruefResult = pruefen(b);
    if (pruefResult) {
      startframe.rowAna = startframe.datenBank.merken();
      this.dispose();
    }
    return;
  }

  public boolean auslesen(rohanalyse analyse) {
    String formatString;
    labelDatenSatzNummer.setText(startframe.Texte.elementAt(109).toString() +
                                 startframe.datenBank.datenSatzRA);
    textFieldAnalysenNummer.setText(analyse.analysenNummer);
    textFieldKunde.setText(analyse.kunde);
    textFieldBearbeiter.setText(analyse.bearbeiter);
    textFieldProjekt.setText(analyse.projekt);

    try {
      textFieldTE.setText(Double.toString(analyse.tE).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldTE.setText(Double.toString(analyse.tE));
    }

    try {
      textFieldpH.setText(Double.toString(analyse.pHtE).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldpH.setText(Double.toString(analyse.pHtE));
    }

    try {
      textFieldLF.setText(Double.toString(analyse.lF).substring(0, 6));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldLF.setText(Double.toString(analyse.lF));
    }

    try {
      textFieldCa.setText(Double.toString(analyse.ca).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldCa.setText(Double.toString(analyse.ca));
    }

    textFieldMg.setText(String.format("%.1f", analyse.mg));

    try {
      textFieldKS.setText(Double.toString(analyse.ks).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldKS.setText(Double.toString(analyse.ks));
    }
    textFieldCl.setText(String.format("%.1f", analyse.cl));
    textFieldSO4.setText(String.format("%.1f", analyse.so4));
    try {
      textFieldNO3.setText(Double.toString(analyse.no3).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldNO3.setText(Double.toString(analyse.no3));
    }

    try {
      textFieldGGWpH.setText(Double.toString(analyse.pHggW).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldGGWpH.setText(Double.toString(analyse.pHggW));
    }
    try {
      textFieldSITE.setText(Double.toString(analyse.sitE).substring(0, 5));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldSITE.setText(Double.toString(analyse.sitE));
    }
    try {
      textFieldCO2.setText(Double.toString(analyse.h2co3).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldCO2.setText(Double.toString(analyse.h2co3));
    }
    try {
      textFieldCO3.setText(Double.toString(analyse.co3).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldCO3.setText(Double.toString(analyse.co3));
    }
    try {
      textFieldHCO3.setText(Double.toString(analyse.hco3).substring(0, 6));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldHCO3.setText(Double.toString(analyse.hco3));
    }



    return true;
  }

  public int berechne() {
      ////deklarieren der Speichervariablen für Anarech
      double cT0 = 298.16;
      double cTK = 273.16; //Temperaturnullpunkt
      double dpHE, dLf; //pH-Wert, Leitfähigkeit.
      double dCa, dMg, dKs43, dCl, dSo4; //Analysenwerte
      double dCaM, dMgM, dKs43M, dClM, dNo3M, dSo4M; //molare Größen
      double dNaM, dNaNo3M, dCo2M;
      double dElfCa, dElfMg, dElfNa, dElfKs, dElfCl, dElfSo, dElfNo, dElfCo3;
      double dElfNaNo, dElfNaNo3M, dLfDiff;
      double dE; //Eindickungsfaktor
      double dLGF1, dLGKCE, dLGK1E, dLGK2E, dLGKWE;
      double dLGKCKT, dLGK1KT, dLGK2KT, dLGKWKT;
      double dLGKCW, dLGK1W, dLGK2W, dLGKWW;
      double dL2E;
      double dTK, dTKKT, dTKW, dTE, dTKT, dTW, dTKE; //Temperaturen
      double dpHGlE, dSiE;
      double dCaCo3, dCo3K;
      double dlgCo2, dlgC, dCo2KT, dpHKTNV, dlgCo3, dCo3NV, dHCo3NV;
      double dL2KT, dpHGlKT, dSiKT, dL2W, dpHGlW, dSiW;
      double dlgK4, dlgK4K, dlgK5, dlgK5K, dA, dB, dCaSo4, dCaMK, dSo4K, dLfBerk;
      //
      rohanalyse fensterDaten = new rohanalyse();
      fensterDaten = einlesen();
      if (gelesen == false) {
        return 1; //wenn nicht korrekt eingelesen wurde
      }
      dCa = fensterDaten.ca;
      dMg = fensterDaten.mg;
      dKs43 = fensterDaten.ks;
      dCl = fensterDaten.cl;
      dSo4 = fensterDaten.so4;
      dNo3 = fensterDaten.no3;
      dpHE = fensterDaten.pHtE;
      dTE = fensterDaten.tE;
      dLf = fensterDaten.lF;
      dCo2 = fensterDaten.hco3;
      dCo3 = fensterDaten.co3;
      dHCo3 = fensterDaten.hco3;


      /////////////////////////////////////////////////////
      // B E R E C H N U N G///////////////////////////////
      /////////////////////////////////////////////////////

      //Berechnung der für die weitere Berechnung benötigten Größen
      //Berechnung der molaren Größen
      dCaM = dCa / (40.08 * 1000);
      dMgM = dMg / (24.3 * 1000);
      dKs43M = dKs43 / 1000;
      dClM = dCl / (35.45 * 1000);
      dNo3M = dNo3 / (62 * 1000);
      dSo4M = dSo4 / (96 * 1000);
      dSuA = dKs43M + dClM + 2 * dSo4M + dNo3M;
      dSuK = 2 * dCaM + 2 * dMgM;
      dNaM = dSuA - dSuK;
      dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);

      //Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)
      //Korrektur nach Dbye-Hückel-Onsager
      dElfCa = 59.2 - (0.229 * 59.2 + 30.1 * 2) * Math.pow(dI, 0.5);
      dElfMg = 53.2 - (0.229 * 53.2 + 30.1 * 2) * Math.pow(dI, 0.5);
      dElfNa = 50.1 - (0.229 * 50.1 + 30.1) * Math.pow(dI, 0.5);
      dElfKs = 44.5 - (0.229 * 44.5 + 30.1) * Math.pow(dI, 0.5);
      dElfCl = 76.4 - (0.229 * 76.4 + 30.1) * Math.pow(dI, 0.5);
      dElfSo = 80.2 - (0.229 * 80.2 + 30.1 * 2) * Math.pow(dI, 0.5);
      dElfNo = 71.5 - (0.229 * 71.5 + 30.1) * Math.pow(dI, 0.5);
      dElfCo3 = 66.5 - (0.229 * 66.5 + 30.1 * 2) * Math.pow(dI, 0.5);
      dLfBer = (dCaM * dElfCa * 2 + dMgM * dElfMg * 2 + dNaM * dElfNa +
                dKs43M * dElfKs + dClM * dElfCl + dSo4M * dElfSo * 2 +
                dNo3M * dElfNo) * 1000;
      //Sulfatkorrektur
      ////
    dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));
    dlgK5 = -2.31;
    dlgK5K = dlgK5 - 8 * dLGF1;
    dA = ( -dCaM - dSo4M - Math.pow(10, dlgK5K));
    dB = dCaM * dSo4M;
    dCaSo4 = -0.5 * dA - Math.pow( (Math.pow( (0.5 * dA), 2) - dB), 0.5);
    dCaMK = dCaM - dCaSo4;
    dSo4K = dSo4M - dCaSo4;

    dLfBer = (dCaMK * dElfCa * 2 + dMgM * dElfMg * 2 + dNaM * dElfNa +
               dKs43M * dElfKs + dClM * dElfCl + dSo4K * dElfSo * 2 + dNo3M * dElfNo) * 1000;

      //wenn Nitrat nicht eingegeben wurde, wird die positive
      //Leitfähigkeitsdifferenz LF - LFber als NaNO3 berechnen
      //wenn Nitrat eingegeben wurde, erfolgt keine Korrektur
      dNaNo3M = 0;
      if (0 == dNo3) {
        dElfNaNo = 121.6 - (0.229 * 121.6 + 30.1 * 2) * Math.pow(dI, 0.5);
        dLfDiff = dLf - dLfBer;
        if (dLfDiff > 0) {
          dNaNo3M = (dLfDiff / dElfNaNo) / 1000;
        }
      }

      //wenn ein um wenigstens 15 % zu niedriger LF-Wert gemessen wurde, erfolgt
      //ein Hinweis und die Möglichkeit zum Abbruch
      if (dLf < dLfBer && (dLf / dLfBer) < 0.85) {
        return 2;
      }

      //wenn c(SO4)/(c(Ca)+c(Mg)) > 0,5 gemessen wurde, erfolgt
      //ein Hinweis und die Möglichkeit zum Abbruch

      // Korrektur Natrium- und Nitratkonzentration

      dNaM = dNaM + dNaNo3M;
      dNo3M = dNo3M + dNaNo3M;
      dNo3 = dNo3M * 62000;
      dSuA = dSuA + dNaNo3M;
      dSuK = dSuK + dNaM;
      dNa = dNaM * 23008;
      dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);
      dE = 1.000;

      dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));

      //Temperaturkorrektur in Kelvin

      dTKE = dTE + cTK;

      //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste
      //Wandtemperatur
      dLGKCE = -8.481 - 522.3 * (1 / cT0 - 1 / dTKE) -
          14.1 * (Math.log(dTKE / cT0) + (cT0 / dTKE) - 1);
      dLGK1E = -6.356 + 483.2 * (1 / cT0 - 1 / dTKE) -
          17.2 * (Math.log(dTKE / cT0) + (cT0 / dTKE) - 1);
      dLGK2E = -10.329 + 780.9 * (1 / cT0 - 1 / dTKE) -
          15.1 * (Math.log(dTKE / cT0) + (cT0 / dTKE) - 1);
      dLGKWE = -13.996 + 2954 * (1 / cT0 - 1 / dTKE) -
          10.4 * (Math.log(dTKE / cT0) + (cT0 / dTKE) - 1);

      //Berechnung SI im Speisewasser
      dL2E = dLGKCE - dLGK2E;
      dpHGlE = dL2E - 5 * dLGF1 - (meinMath.log10(dCaM * dKs43M));
      dSiE = dpHE - dpHGlE;

      //Berechnung CO2 im Speisewasser
      /*
        //Kohlensaeure im Konzentrat wie im Permeat
        dCo2KT = Math.pow(10, dlgCK);
        dpHKTNV = -dLGK1KT - dlgCK + meinMath.log10(dKs43M) + dLGF1;
        dlgCo3 = dLGK2KT + meinMath.log10(dKs43M) - 3 * dLGF1 + dpHKTNV;
        dCo3NV = Math.pow(10, dlgCo3);
        dHCo3NV = dKs43M - 2 * dCo3NV;

        //Berechnung SI nach Eindickung
        dL2KT = dLGKCKT - dLGK2KT;
        dpHGlKT = dL2KT - 5 * dLGF1 - meinMath.log10(dCaM * dKs43M);
        dSiW = dpHKTNV - dpHGlKT;

      */
      dlgCo2 = -dLGK1E - dpHE + meinMath.log10(dKs43M) + dLGF1;
      dCo2M = Math.pow(10, dlgCo2);


      dCo3 = 1;
      //Berechnung Hydrogencarbonat im Speisewasser
      //dlgCo3 = dLGK2E  + meinMath.log10(dKs43M) / 2.3026 - 3 * dLGF1 + dpHE;
      ///lgCO3=LGK2E+log10(KS43M)-3*LGF1+PHE
      //*Versuch, richtig zu rechnen
       ///CO3M=10^LGK2E*KS43M/(10^(3*LGF1)*10^(-PHE)+2*10^LGK2E)
       dCo3= Math.pow(10,dLGK2E)*dKs43M /( Math.pow(10,(3*dLGF1))*Math.pow(10,(-dpHE))+2*Math.pow(10,dLGK2E));


     // dCo3= Math.pow(10,dLGK2E)*dKs43M / Math.pow(10,(3*dLGF1))*Math.pow(10,(-dpHE))+2*Math.pow(10,dLGK2E);
      //dlgCo3 = dLGK2E+Math.log10(dKs43M)-3*dLGF1+dpHE;
      //dCo3 = (Math.pow(10, dlgCo3));
      dHCo3 = (dKs43M - 2 * dCo3)*61017 ; //* 61017
      dCo2 = dCo2M * 44010;
      dCo3 = dCo3 * 60010;



      //Einlesen in DialogFelder

      textFieldSITE.setText(Double.toString(dSiE).substring(0, 5));
      textFieldGGWpH.setText(Double.toString(dpHGlE).substring(0, 4));
      try {
        textFieldNO3.setText( (Double.toString(dNo3)).substring(0, 5));
      }
      catch (StringIndexOutOfBoundsException e) {
        textFieldNO3.setText(Double.toString(dNo3));
      }
      textFieldCO2.setText(Double.toString(dCo2).substring(0, 5));
      textFieldCO3.setText(Double.toString(dCo3).substring(0, 5));
      textFieldHCO3.setText(Double.toString(dHCo3).substring(0, 7));

      if (dSo4M / (dCaM + dMgM) > 0.5) {
        //Hinweis geben und weitermachen
        dialogframe meinDialog = new dialogframe();
        warndialogAutoClose keineZahl = new warndialogAutoClose(meinDialog, startframe.Texte.elementAt(158).toString(), false);
        keineZahl.setSize(300, 150);
        keineZahl.setLocation(positionX(300), positionY(150));
        keineZahl.meldung(startframe.Texte.elementAt(172).toString());
        keineZahl.setVisible(true);
        meinDialog.dispose();
      }

      return 0;

  }

  public rohanalyse einlesen() {
    //lesen der Werte in die Variable
    rohanalyse analyseAus = new rohanalyse();
    analyseAus.analysenNummer = textFieldAnalysenNummer.getText();
    analyseAus.kunde = textFieldKunde.getText();
    analyseAus.bearbeiter = textFieldBearbeiter.getText();
    analyseAus.projekt = textFieldProjekt.getText();
    //versuchen die Felsder zu lesen, sonst default Wert und Fehlermeldung
    try {
      analyseAus.tE = Double.parseDouble(textFieldTE.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.tE = 12.0;
      textFieldTE.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      analyseAus.pHtE = Double.parseDouble(textFieldpH.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.pHtE = 7.5;
      textFieldpH.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      analyseAus.lF = Double.parseDouble(textFieldLF.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.lF = 500;
      textFieldLF.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      analyseAus.ca = Double.parseDouble(textFieldCa.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.ca = 50.0;
      textFieldCa.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      analyseAus.mg = Double.parseDouble(textFieldMg.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.mg = 10.0;
      textFieldMg.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }
    analyseAus.na = dNa;
    analyseAus.suK = dSuK;
    analyseAus.suA = dSuA;
    analyseAus.i = dI;

    try {
     analyseAus.h2co3 = Double.parseDouble(textFieldCO2.getText());
   }
   catch (NumberFormatException e) {
     //analyseAus.cl = 50.0;
     textFieldCO2.setText(startframe.Texte.elementAt(174).toString());
     gelesen = false;
   }

    try {
     analyseAus.co3 = Double.parseDouble(textFieldCO3.getText());
   }
   catch (NumberFormatException e) {
     //analyseAus.cl = 50.0;
     textFieldCO3.setText(startframe.Texte.elementAt(174).toString());
     gelesen = false;
   }

    try {
      analyseAus.hco3 = Double.parseDouble(textFieldHCO3.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.cl = 50.0;
      textFieldHCO3.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
         analyseAus.cl = Double.parseDouble(textFieldCl.getText());
       }
       catch (NumberFormatException e) {
         //analyseAus.cl = 50.0;
         textFieldCl.setText(startframe.Texte.elementAt(174).toString());
         gelesen = false;
   }
    try {
      analyseAus.ks = Double.parseDouble(textFieldKS.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.ks = 2.5;
      textFieldKS.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      analyseAus.so4 = Double.parseDouble(textFieldSO4.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.so4 = 30;
      textFieldSO4.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }
    //analyseAus.no3 = dNo3;
    try {
      analyseAus.no3 = Double.parseDouble(textFieldNO3.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.no3 = 0.0;
      textFieldNO3.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      analyseAus.pHggW = Double.parseDouble(textFieldGGWpH.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.pHggW = 0.0;
      textFieldGGWpH.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      analyseAus.sitE = Double.parseDouble(textFieldSITE.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.sitE = 0.0;
      textFieldSITE.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }

    try {
      analyseAus.h2co3 = Double.parseDouble(textFieldCO2.getText());
    }
    catch (NumberFormatException e) {

      textFieldCO2.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }
    try {
      analyseAus.co3 = Double.parseDouble(textFieldCO3.getText());
    }
    catch (NumberFormatException e) {

      textFieldCO3.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }
    try {
      analyseAus.hco3 = Double.parseDouble(textFieldHCO3.getText());
    }
    catch (NumberFormatException e) {
      //analyseAus.sitE = 0.0;
      textFieldHCO3.setText(startframe.Texte.elementAt(174).toString());
      gelesen = false;
    }



    analyseAus.lFBer = dLfBer;
    return analyseAus;
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

  //
  void punktStattKomma(KeyEvent event) { //Kommaeingabe gegen Punkteingabe tauschen
    int taste = event.getKeyCode();
    if (taste == 44) {
      event.setKeyCode(46);
    }
    if (taste == 10) {
      event.setKeyCode(9);
    }
    int test = event.getKeyCode();
  }

  //
  boolean pruefen(int fehler) {
    if (fehler > 0) { //wenn ein Fehler aufgetreten ist
      dialogframe meinDialog = new dialogframe();
      warndialogAutoClose keineZahl = new warndialogAutoClose(meinDialog, startframe.Texte.elementAt(158).toString(), true);
      keineZahl.setSize(300, 150);
      keineZahl.setLocation(positionX(300), positionY(150));
      switch (fehler) {
        case 1:
          keineZahl.meldung(startframe.Texte.elementAt(159).toString());
          break;
        case 2:
          keineZahl.meldung(
              startframe.Texte.elementAt(175).toString());
          break;
          /*case 3:
           keineZahl.meldung("  falsche Parameter Eingabe, Calciumwert zu niedrig");
                   break;
           */
      }

      //keineZahl.setAlwaysOnTop(true);
      //keineZahl.getContentPane().setVisible(true);
      //keineZahl.label3.setVisible(true);
      //keineZahl.labeltext.setVisible(true);
      //keineZahl.setFocusable(true);
       keineZahl.setVisible(true);

      //keineZahl.dispose();
      gelesen = true; //wert wieder auf kein Fehler setzen
      meinDialog.dispose();
      return false;
    }
    else {
      return true;
    }

  }
}
