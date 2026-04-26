//package watkost;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.text.*;
import java.util.*;
import javax.swing.*;
import jxl.Sheet;
import java.io.File;
import jxl.Cell;
import jxl.Workbook;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

//import watklassen.*;


public class hauptframe
    extends JFrame implements Runnable {
  //global gültige Variable//////////
  Thread testThread;
  boolean fehler = true; //wenn berechnung durch warnfenster unterbrochen
  rohanalyse anaroh = new rohanalyse();
  String aufbereitung,aufbereitungAnzeige;
  anlagekosten anlkost = new anlagekosten();
  kosten betriebsMittelKosten = new kosten();
  umlaufanalyse anauml = new umlaufanalyse(); //umlaufAnalysenobjekt
  betriebskosten betrkost = new betriebskosten(); //betriebsKostenobjekt
  grenzwerte bedingungen = new grenzwerte();
  grenzwerte bedingungen2 = new grenzwerte();
  Font HauptSchrift = new java.awt.Font("Dialog", 1, 11);
  Color SchriftFarbe = new Color(204, 228, 255);

  //Kontrollvariablen der Checkboxen
  boolean bkosten = true;
  boolean baufbereitung = true;
  boolean bkostenberechnet = false;
  boolean banalyseberechnet = false;

  ///////////////////////////////////
  boolean isStandalone = false;
  GridLayout gridLayout1 = new GridLayout();
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel panel3 = new JPanel();
  JPanel panel4 = new JPanel();
  JPanel panel5 = new JPanel();
  GridLayout gridLayoutO1 = new GridLayout();
  JLabel labelAnalyse = new JLabel();
  JLabel label3 = new JLabel();
  JLabel label6 = new JLabel();
  JTextField textFieldAnalyse = new JTextField();
  JLabel label24 = new JLabel();
  JLabel label28 = new JLabel();
  JLabel label210 = new JLabel();
  JLabel label212 = new JLabel();
  JLabel label213 = new JLabel();
  JLabel label214 = new JLabel();
  JLabel label215 = new JLabel();
  JLabel label216 = new JLabel();
  JLabel label218 = new JLabel();
  JLabel label219 = new JLabel();
  JLabel label2111 = new JLabel();
  JLabel label2112 = new JLabel();
  ButtonGroup checkAnlage = new ButtonGroup();
  JRadioButton checkboxAnlage2 = new JRadioButton();
  JRadioButton checkboxAnlage1 = new JRadioButton();
  JCheckBox checkboxKosten = new JCheckBox();
  JCheckBox checkboxSiel = new JCheckBox();
  JButton buttonanalyse = new JButton();
  JButton buttondosierung = new JButton();
  JButton buttonumkehrosmosemit = new JButton();
  JButton buttonentcarbonosierung = new JButton();
  JButton buttonenthaertung = new JButton();
  JButton buttonthresh = new JButton();
  JButton buttonumkehrosmoseohne = new JButton();
  JLabel label1 = new JLabel();
  JLabel labelArt = new JLabel();
  JLabel labelUmlaufwasseranalyse = new JLabel();
  GridLayout gridLayout2 = new GridLayout();
  JLabel label7 = new JLabel();
  JLabel label8 = new JLabel();
  JLabel label9 = new JLabel();
  JLabel label10 = new JLabel();
  JLabel label11 = new JLabel();
  JLabel label12 = new JLabel();
  JLabel label13 = new JLabel();
  JLabel label14 = new JLabel();
  JLabel label15 = new JLabel();
  JLabel label17 = new JLabel();
  JLabel label18 = new JLabel();
  JLabel label19 = new JLabel();
  JLabel label44 = new JLabel();
  JLabel label45 = new JLabel();
  JLabel label42 = new JLabel();
  JLabel label43 = new JLabel();
  JLabel label110 = new JLabel();
  JLabel label111 = new JLabel();
  JLabel label112 = new JLabel();
  JLabel label113 = new JLabel();
  JLabel label114 = new JLabel();
  JLabel label115 = new JLabel();
  JLabel label117 = new JLabel();
  JLabel label118 = new JLabel();
  JLabel label119 = new JLabel();
  JLabel label1110 = new JLabel();
  JTextField textFieldNa = new JTextField();
  JTextField textFieldCl = new JTextField();
  JTextField textFieldNo3 = new JTextField();
  JTextField textFieldGGWKT = new JTextField();
  JTextField textFieldKS43 = new JTextField();
  JTextField textFieldCa = new JTextField();
  JTextField textFieldTW = new JTextField();
  JTextField textFieldE = new JTextField();
  JTextField textFieldMg = new JTextField();
  JTextField textFieldLF = new JTextField();
  JTextField textFieldTKT = new JTextField();
  JTextField textFieldSu = new JTextField();
  JTextField textFieldVerschnitt = new JTextField();
  JTextField textFieldSITKT = new JTextField();
  JTextField textFieldpHKT = new JTextField();
  JTextField textFieldGGWW = new JTextField();
  JLabel label16 = new JLabel();
  JLabel label5 = new JLabel();
  GridLayout gridLayout3 = new GridLayout(6, 8);
  JLabel label20 = new JLabel();
  JLabel label21 = new JLabel();
  JLabel label22 = new JLabel();
  JLabel label23 = new JLabel();
  JLabel label25 = new JLabel();
  JLabel label26 = new JLabel();
  JLabel label27 = new JLabel();
  JLabel label211 = new JLabel();
  JLabel label220 = new JLabel();
  JLabel label221 = new JLabel();
  JLabel label222 = new JLabel();
  JLabel label2110 = new JLabel();
  JLabel label2113 = new JLabel();
  JLabel label223 = new JLabel();
  JLabel label224 = new JLabel();
  JLabel label2114 = new JLabel();
  JLabel label2115 = new JLabel();
  JLabel label226 = new JLabel();
  JLabel label227 = new JLabel();
  JLabel label228 = new JLabel();
  JLabel label2116 = new JLabel();
  JLabel label2117 = new JLabel();
  JTextField textFieldDosV = new JTextField();
  JTextField textFieldEnergieV = new JTextField();
  JTextField textFieldSchwefelV = new JTextField();
  JTextField textFieldSalzSaeureV = new JTextField();
  JTextField textFieldH2CO3 = new JTextField();
  JTextField textFieldAbwasserV = new JTextField();
  JTextField textFieldAbwasserV2 = new JTextField();
  JTextField textFieldSalzTabV = new JTextField();
  JTextField textFieldSalzGehalt = new JTextField();
  JTextField textFieldZusatzV = new JTextField();
  JTextField textFieldI = new JTextField();
  JTextField textFieldSIW = new JTextField();
  JTextField textFieldHCO3 = new JTextField();
  JTextField textFieldROV = new JTextField();
  JLabel label30 = new JLabel();
  JLabel label31 = new JLabel();
  JLabel label32 = new JLabel();
  JLabel label225 = new JLabel();
  GridLayout gridLayout4 = new GridLayout();
  JLabel label33 = new JLabel();
  JLabel label1111 = new JLabel();
  JLabel label116 = new JLabel();
  JLabel label1112 = new JLabel();
  JLabel label120 = new JLabel();
  JLabel label121 = new JLabel();
  JLabel label122 = new JLabel();
  JLabel label34 = new JLabel();
  JLabel label35 = new JLabel();
  JTextField textFieldSchwefelsaeureK = new JTextField();
  JTextField textFieldEnergieK = new JTextField();
  JTextField textFieldZusatzK = new JTextField();
  JLabel label1113 = new JLabel();
  JLabel label1114 = new JLabel();
  JLabel label1115 = new JLabel();
  JLabel label1116 = new JLabel();
  JTextField textFieldAbWasserK = new JTextField();
  JTextField textFieldAbWasserK2 = new JTextField();
  JTextField textFieldSummeK = new JTextField();
  JLabel label123 = new JLabel();
  JLabel label124 = new JLabel();
  JTextField textFieldSalzSaeureK = new JTextField();
  JLabel label1117 = new JLabel();
  JLabel label125 = new JLabel();
  JTextField textFieldSalzTabK = new JTextField();
  JLabel label1118 = new JLabel();
  JLabel label126 = new JLabel();
  JTextField textFieldROK = new JTextField();
  JTextField textFieldDosK = new JTextField();
  JTextField textFieldAnlageK = new JTextField();
  JLabel label1119 = new JLabel();
  JLabel label127 = new JLabel();
  JLabel label36 = new JLabel();
  JLabel label37 = new JLabel();
  JLabel label38 = new JLabel();
  JLabel label39 = new JLabel();
  JLabel label40 = new JLabel();
  JLabel label41 = new JLabel();
  JTextField textFieldCO3 = new JTextField();
  JButton buttongrenzwert = new JButton();
  JButton buttonpreise = new JButton();
  JButton anlage = new JButton();

  //Construct the frame
  public hauptframe() {
    //Lookand Feel
    //this.setIconImage();
    String LookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
    try {
      UIManager.setLookAndFeel(LookAndFeel);
    }
    catch (Exception e) {}
    SwingUtilities.updateComponentTreeUI(this);
    this.pack();

    //Komma und Return events abfangen
    Keymap km = textFieldCO3.getKeymap();
    KeyStroke ks1 = KeyStroke.getKeyStroke( ( (char) 44));
    KeyStroke ks2 = KeyStroke.getKeyStroke( ( (char) 13));
    Action act1 = new TextAction("Ctrl-Z") {
      public void actionPerformed(ActionEvent e) {
        super.getFocusedComponent().replaceSelection("."); //replaceSelection(46);

      }
    };
    km.addActionForKeyStroke(ks1, act1);
    //km.addActionForKeyStroke(ks2, act2);
    //Return loesen
    km.removeKeyStrokeBinding(ks2);
    //Thread
    //testThread = new Thread(this);
    //testThread.start();
    //rohanalyse initialisieren
    rohanalyseinit();
    //kosten initialisieren
    kosteninit();
    //grenzwerte initialisieren
    grenzwertinit();
    //anlkost initialisieren
    anlkost.nullen();

    //Menue einfuegen
  setMenuBar(new hauptmenue(this));
  this.addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(WindowEvent e) {
      fenster_Zu(e);
      System.exit(1);
    }
  });
  this.getContentPane().setLayout(gridLayout1);
  gridLayout1.setColumns(1);
  gridLayout1.setRows(5);
  gridLayout1.setVgap(4);
  panel1.setBackground(new Color(55, 71, 100));
  panel1.setLayout(gridLayoutO1);
  panel2.setBackground(new Color(55, 71, 100));
  panel2.setLayout(gridLayout2);
  panel3.setBackground(new Color(55, 71, 100));
  panel3.setForeground(SchriftFarbe);
  panel3.setLayout(gridLayout3);
  panel5.setBackground(new Color(55, 71, 100));
  panel4.setBackground(new Color(55, 71, 100));
  panel4.setLayout(gridLayout4);
  gridLayoutO1.setColumns(6);
  gridLayoutO1.setHgap(4);
  gridLayoutO1.setRows(5);
  gridLayoutO1.setVgap(4);
  labelAnalyse.setFont(HauptSchrift);
  labelAnalyse.setForeground(Color.red);
  labelAnalyse.setText("Analysennummer:");
  textFieldAnalyse.setFont(HauptSchrift);
  textFieldAnalyse.setForeground(SchriftFarbe);
  textFieldAnalyse.setBackground(new Color(50, 71, 100));
  textFieldAnalyse.setEditable(false);
  textFieldAnalyse.setText("default"); //(startframe.homeDir);
  //checkboxKosten.setText("checkbox2");
  checkboxKosten.addItemListener(new java.awt.event.ItemListener() {

    public void itemStateChanged(ItemEvent e) {
      checkboxKosten_itemStateChanged(e);
    }
  });
  checkAnlage.add(checkboxAnlage2);
  checkboxAnlage2.setBackground(new Color(50, 71, 100));
  checkboxAnlage2.setFont(HauptSchrift);
  checkboxAnlage2.setForeground(SchriftFarbe);
  //checkboxAnlage2.setCheckboxGroup(CheckAnlage);
  checkboxAnlage2.setText("Luftwäscher");
  checkboxAnlage2.addItemListener(new java.awt.event.ItemListener() {

    public void itemStateChanged(ItemEvent e) {
      checkboxAnlage2_itemStateChanged(e);
    }
  });
  checkAnlage.add(checkboxAnlage1);
  checkboxAnlage1.setBackground(new Color(50, 71, 100));
  checkboxAnlage1.setFont(HauptSchrift);
  checkboxAnlage1.setForeground(SchriftFarbe);
  //checkboxAnlage1.setCheckboxGroup(CheckAnlage);
  checkboxAnlage1.setText("Kühlturmkreislauf");
  checkboxAnlage1.setSelected(true);
  checkboxAnlage1.addItemListener(new java.awt.event.ItemListener() {

    public void itemStateChanged(ItemEvent e) {
      checkboxAnlage1_itemStateChanged(e);
    }
  });
  checkboxKosten.setBackground(new Color(50, 71, 100));
  checkboxKosten.setFont(HauptSchrift);
  checkboxKosten.setForeground(SchriftFarbe);
  checkboxKosten.setText("mit Kostenrechnung");
  checkboxKosten.setSelected(true);
  //checkboxKosten.setVisible(false); //neue Version weggeblendet

  checkboxSiel.setBackground(new Color(50, 71, 100));
  checkboxSiel.setFont(HauptSchrift);
  checkboxSiel.setForeground(SchriftFarbe);
  checkboxSiel.setText("2. Siel");
  checkboxSiel.setSelected(false);

  label215.setText(" ");
  label6.setText(" ");
  label2111.setText(" ");
  label212.setText(" ");
  label214.setText(" ");
  label2112.setText(" ");
  label213.setFont(HauptSchrift);
  label213.setForeground(SchriftFarbe);
  label213.setText("Aufbereitungsart:");
  label216.setText("");
  label218.setText(" ");
  label210.setText(" ");
  label28.setText(" ");
  label219.setText(" ");
  label24.setText(" ");
  label3.setText(" ");
  //buttonanalyse.setBackground(Color.lightGray);
  buttonanalyse.setFont(HauptSchrift);
  //buttonanalyse.setForeground(new Color(55, 71, 100));
  buttonanalyse.setText("analyse");
  buttonanalyse.addMouseListener(new java.awt.event.MouseAdapter() {

    public void mouseReleased(MouseEvent e) {
      buttonanalyse_mouseClicked(e);
      int r = 0;
    }
  });
  //buttondosierung.setBackground(Color.lightGray);
  buttondosierung.setFont(HauptSchrift);
  //buttondosierung.setForeground(new Color(55, 71, 100));
  buttondosierung.setText("schwefelsäuredos");
  buttondosierung.addMouseListener(new java.awt.event.MouseAdapter() {

    public void mouseClicked(MouseEvent e) {
      buttondosierung_mouseClicked(e);
    }
  });
  //buttonumkehrosmosemit.setBackground(Color.lightGray);
  buttonumkehrosmosemit.setFont(HauptSchrift);
  //buttonumkehrosmosemit.setForeground(new Color(55, 71, 100));
  buttonumkehrosmosemit.setText("umkehrosmose mit e.h.");
  buttonumkehrosmosemit.addMouseListener(new java.awt.event.MouseAdapter() {

    public void mouseClicked(MouseEvent e) {
      buttonumkehrosmosemit_mouseClicked(e);
    }
  });
 // buttonentcarbonosierung.setBackground(Color.lightGray);
  buttonentcarbonosierung.setFont(HauptSchrift);
  //buttonentcarbonosierung.setForeground(new Color(55, 71, 100));
  buttonentcarbonosierung.setText("entcarbonisierung");
  buttonentcarbonosierung.addMouseListener(new java.awt.event.MouseAdapter() {

    public void mouseClicked(MouseEvent e) {
      buttonentcarbonosierung_mouseClicked(e);
    }
  });
  //buttonenthaertung.setBackground(Color.lightGray);
  buttonenthaertung.setFont(HauptSchrift);
  //buttonenthaertung.setForeground(new Color(55, 71, 100));
  buttonenthaertung.setText("enthärtung");
  buttonenthaertung.addMouseListener(new java.awt.event.MouseAdapter() {

    public void mouseClicked(MouseEvent e) {
      buttonenthaertung_mouseClicked(e);
    }
  });
  //buttonthresh.setBackground(Color.lightGray);
  buttonthresh.setFont(HauptSchrift);
  //buttonthresh.setForeground(new Color(55, 71, 100));
  buttonthresh.setText("threshold st.");
  buttonthresh.addMouseListener(new java.awt.event.MouseAdapter() {

    public void mouseClicked(MouseEvent e) {
      buttonthresh_mouseClicked(e);
    }
  });
  //buttonumkehrosmoseohne.setBackground(Color.lightGray);
  buttonumkehrosmoseohne.setFont(HauptSchrift);
  //buttonumkehrosmoseohne.setForeground(new Color(55, 71, 100));
  buttonumkehrosmoseohne.setText("umkehrosmose ");
  buttonumkehrosmoseohne.addMouseListener(new java.awt.event.MouseAdapter() {

    public void mouseClicked(MouseEvent e) {
      buttonumkehrosmoseohne_mouseClicked(e);
    }
  });
  labelArt.setFont(HauptSchrift);
  labelArt.setForeground(Color.red);
  labelArt.setText("keine gewaehlt");
  labelUmlaufwasseranalyse.setFont(HauptSchrift);
  labelUmlaufwasseranalyse.setForeground(Color.red);
  labelUmlaufwasseranalyse.setText("Umlaufwasseranalyse");
  gridLayout2.setColumns(8);
  gridLayout2.setHgap(4);
  gridLayout2.setRows(5);
  gridLayout2.setVgap(4);
  label7.setFont(HauptSchrift);
  label7.setForeground(SchriftFarbe);
  label7.setText("Na ber. mg/l:");
  label8.setText(" ");
  label9.setFont(HauptSchrift);
  label9.setForeground(SchriftFarbe);
  label9.setText("Magnesium mg/l:");
  label10.setText(" ");
  label11.setFont(HauptSchrift);
  label11.setForeground(SchriftFarbe);
  label11.setText("Nitrat mg/l:");
  label12.setFont(HauptSchrift);
  label12.setForeground(SchriftFarbe);
  label12.setText("Eindickung E:");
  label13.setFont(HauptSchrift);
  label13.setForeground(SchriftFarbe);
  label13.setText("GGW pH TKT:");
  label14.setFont(HauptSchrift);
  label14.setForeground(SchriftFarbe);
  label14.setText("LF 25 µS/cm:");
  label15.setFont(HauptSchrift);
  label15.setForeground(SchriftFarbe);
  label15.setText("Chlorid mg/l:");
  label17.setText(" ");
  label18.setFont(HauptSchrift);
  label18.setForeground(SchriftFarbe);
  label18.setText("pH KTNV:");
  label19.setText(" ");
  label110.setFont(HauptSchrift);
  label110.setForeground(SchriftFarbe);
  label110.setText("SI TKT:");
  label111.setFont(HauptSchrift);
  label111.setForeground(SchriftFarbe);
  label111.setText("Sulfat mg/l:");
  label112.setText(" ");
  label113.setFont(HauptSchrift);
  label113.setForeground(SchriftFarbe);
  label113.setText("Calcium mg/l:");
  label114.setFont(HauptSchrift);
  label114.setForeground(SchriftFarbe);
  label114.setText("TW °C:");
  label115.setFont(HauptSchrift);
  label115.setForeground(SchriftFarbe);
  label115.setText("Verschnitt RW %:");
  label117.setText(" ");
  label118.setFont(HauptSchrift);
  label118.setForeground(SchriftFarbe);
  label118.setText("KS 4,3 mmol/l:");
  label119.setFont(HauptSchrift);
  label119.setForeground(SchriftFarbe);
  label119.setText("TKT °C:");
  label1110.setText(" ");
  textFieldNa.setFont(HauptSchrift);
  textFieldNa.setForeground(Color.darkGray);
  textFieldNa.setText("");
  textFieldCl.setFont(HauptSchrift);
  textFieldCl.setForeground(Color.darkGray);
  textFieldCl.setText("");
  textFieldNo3.setFont(HauptSchrift);
  textFieldNo3.setForeground(Color.darkGray);
  textFieldNo3.setText("");
  textFieldGGWKT.setFont(HauptSchrift);
  textFieldGGWKT.setForeground(Color.darkGray);
  textFieldGGWKT.setText("");
  textFieldKS43.setFont(HauptSchrift);
  textFieldKS43.setForeground(Color.darkGray);
  textFieldCa.setFont(HauptSchrift);
  textFieldCa.setForeground(Color.darkGray);
  textFieldCa.setText("");
  textFieldTW.setFont(HauptSchrift);
  textFieldTW.setForeground(Color.darkGray);
  textFieldTW.setText("");
  textFieldE.setFont(HauptSchrift);
  textFieldE.setForeground(Color.darkGray);
  textFieldE.setText("");
  textFieldMg.setFont(HauptSchrift);
  textFieldMg.setForeground(Color.darkGray);
  textFieldMg.setText("");
  textFieldLF.setFont(HauptSchrift);
  textFieldLF.setForeground(Color.darkGray);
  textFieldTKT.setFont(HauptSchrift);
  textFieldTKT.setForeground(Color.darkGray);
  textFieldTKT.setText("");
  textFieldSu.setFont(HauptSchrift);
  textFieldSu.setForeground(Color.darkGray);
  textFieldSu.setText("");
  textFieldVerschnitt.setFont(HauptSchrift);
  textFieldVerschnitt.setForeground(Color.darkGray);
  textFieldSITKT.setFont(HauptSchrift);
  textFieldSITKT.setForeground(Color.darkGray);
  textFieldSITKT.setText("");
  textFieldpHKT.setFont(HauptSchrift);
  textFieldpHKT.setForeground(Color.darkGray);
  textFieldGGWW.setFont(HauptSchrift);
  textFieldGGWW.setForeground(Color.darkGray);
  textFieldGGWW.setText("");
  label16.setFont(HauptSchrift);
  label16.setForeground(SchriftFarbe);
  label16.setText("GGW pH W:");
  label5.setFont(HauptSchrift);
  label5.setForeground(SchriftFarbe);
  label5.setText("SI W:");
  gridLayout3.setColumns(8);
  gridLayout3.setHgap(4);
  gridLayout3.setRows(5);
  gridLayout3.setVgap(4);
  label20.setFont(HauptSchrift);
  label20.setForeground(SchriftFarbe);
  label20.setText("Salzgehalt mmol/l:");
  label22.setFont(HauptSchrift);
  label22.setForeground(SchriftFarbe);
  label22.setText("Salztablette kg/a:");
  label23.setFont(HauptSchrift);
  label23.setForeground(SchriftFarbe);
  label23.setText("Schmutzwasser m³/a:");
  label36.setFont(HauptSchrift);
  label36.setForeground(SchriftFarbe);
  label36.setText("Regenwassersiel m³/a:");
  label25.setFont(HauptSchrift);
  label25.setForeground(Color.red);
  label25.setText("Verbrauch");
  label26.setFont(HauptSchrift);
  label26.setForeground(SchriftFarbe);
  label26.setText("RO Dosiermittel kg/a:");
  label27.setFont(HauptSchrift);
  label27.setForeground(SchriftFarbe);
  label27.setText("CO2 mg/l:");
  label211.setFont(HauptSchrift);
  label211.setForeground(SchriftFarbe);
  label211.setText("Zusatzwasser m³/a:");
  label221.setFont(HauptSchrift);
  label221.setForeground(SchriftFarbe);
  label221.setText("Ionenstärke I:");
  label222.setForeground(SchriftFarbe);
  label223.setFont(HauptSchrift);
  label223.setForeground(SchriftFarbe);
  label223.setText("Salzsäure kg/a:");
  label224.setFont(HauptSchrift);
  label224.setForeground(SchriftFarbe);
  label224.setText("Dosiermittel kg/a: ");
  label2115.setFont(HauptSchrift);
  label2115.setForeground(SchriftFarbe);
  label2115.setText("HCO3 mg/l:");
  label227.setFont(HauptSchrift);
  label227.setForeground(SchriftFarbe);
  label227.setText("CO3 mg/l:");
  label228.setFont(HauptSchrift);
  label228.setForeground(SchriftFarbe);
  label228.setText("Schwefelsäure kg/a:");
  label2117.setFont(HauptSchrift);
  label2117.setForeground(SchriftFarbe);
  label2117.setText("Energie kWh/a:");
  textFieldDosV.setFont(HauptSchrift);
  textFieldDosV.setForeground(Color.darkGray);
  textFieldDosV.setText("");
  textFieldEnergieV.setFont(HauptSchrift);
  textFieldEnergieV.setForeground(Color.darkGray);
  textFieldSchwefelV.setFont(HauptSchrift);
  textFieldSchwefelV.setForeground(Color.darkGray);
  textFieldSchwefelV.setText("");
  textFieldSalzSaeureV.setFont(HauptSchrift);
  textFieldSalzSaeureV.setForeground(Color.darkGray);
  textFieldSalzSaeureV.setText("");
  textFieldH2CO3.setFont(HauptSchrift);
  textFieldH2CO3.setForeground(Color.darkGray);
  textFieldH2CO3.setText("");
  textFieldAbwasserV.setFont(HauptSchrift);
  textFieldAbwasserV.setForeground(Color.darkGray);
  textFieldAbwasserV.setText("");
  textFieldAbwasserV2.setFont(HauptSchrift);
  textFieldAbwasserV2.setForeground(Color.darkGray);
  textFieldAbwasserV2.setText("");
  textFieldSalzTabV.setFont(HauptSchrift);
  textFieldSalzTabV.setForeground(Color.darkGray);
  textFieldSalzGehalt.setFont(HauptSchrift);
  textFieldSalzGehalt.setForeground(Color.darkGray);
  textFieldSalzGehalt.setText("");
  textFieldZusatzV.setFont(HauptSchrift);
  textFieldZusatzV.setForeground(Color.darkGray);
  textFieldZusatzV.setText("");
  textFieldI.setFont(HauptSchrift);
  textFieldI.setForeground(Color.darkGray);
  textFieldI.setText("");
  textFieldSIW.setFont(HauptSchrift);
  textFieldSIW.setForeground(Color.darkGray);
  textFieldHCO3.setFont(HauptSchrift);
  textFieldHCO3.setForeground(Color.darkGray);
  textFieldROV.setFont(HauptSchrift);
  textFieldROV.setForeground(Color.darkGray);
  textFieldROV.setText("");
  label225.setText("Kosten");
  label225.setForeground(Color.red);
  label225.setFont(HauptSchrift);
  label33.setText(" ");
  label1111.setText(" ");
  label116.setText(" ");
  label1112.setText(" ");
  label120.setText(" ");
  label121.setText(" ");
  label122.setText(" ");
  label34.setText("Salzsäure EUR/a:");
  label34.setFont(HauptSchrift);
  label34.setForeground(SchriftFarbe);
  label35.setForeground(SchriftFarbe);
  textFieldSchwefelsaeureK.setText("");
  textFieldSchwefelsaeureK.setFont(HauptSchrift);
  textFieldSchwefelsaeureK.setForeground(Color.darkGray);
  textFieldEnergieK.setFont(HauptSchrift);
  textFieldEnergieK.setForeground(Color.darkGray);
  textFieldZusatzK.setText("");
  textFieldZusatzK.setFont(HauptSchrift);
  textFieldZusatzK.setForeground(Color.darkGray);
  label1113.setForeground(SchriftFarbe);
  label1114.setText("Schwefelsäure EUR/a:");
  label1114.setFont(HauptSchrift);
  label1114.setForeground(SchriftFarbe);
  label1115.setText("Anlagenkosten EUR/a:");
  label1115.setFont(HauptSchrift);
  label1115.setForeground(SchriftFarbe);
  label1116.setText("Summe EUR/a:");
  label1116.setFont(HauptSchrift);
  label1116.setForeground(Color.red);
  textFieldAbWasserK.setText("");
  textFieldAbWasserK.setFont(HauptSchrift);
  textFieldAbWasserK.setForeground(Color.darkGray);
  textFieldAbWasserK2.setText("");
  textFieldAbWasserK2.setFont(HauptSchrift);
  textFieldAbWasserK2.setForeground(Color.darkGray);
  textFieldSummeK.setFont(HauptSchrift);
  textFieldSummeK.setForeground(Color.darkGray);
  label123.setText("RO Dosiermittel EUR/a:");
  label123.setFont(HauptSchrift);
  label123.setForeground(SchriftFarbe);
  label124.setForeground(SchriftFarbe);
  gridLayout4.setColumns(8);
  gridLayout4.setHgap(4);
  gridLayout4.setRows(5);
  gridLayout4.setVgap(4);
  textFieldSalzSaeureK.setFont(HauptSchrift);
  textFieldSalzSaeureK.setForeground(Color.darkGray);
  textFieldSalzSaeureK.setText("");
  label1117.setFont(HauptSchrift);
  label1117.setForeground(SchriftFarbe);
  label1117.setText("Salztabletten EUR/a:");
  label125.setFont(HauptSchrift);
  label125.setForeground(SchriftFarbe);
  label125.setText("Zusatzwasser EUR/a:");
  textFieldSalzTabK.setFont(HauptSchrift);
  textFieldSalzTabK.setForeground(Color.darkGray);
  label1118.setFont(HauptSchrift);
  label1118.setForeground(SchriftFarbe);
  label1118.setText("Dosiermittel EUR/a:");
  label126.setFont(HauptSchrift);
  label126.setForeground(SchriftFarbe);
  label126.setText("Energie EUR/a:");
  textFieldROK.setFont(HauptSchrift);
  textFieldROK.setForeground(Color.darkGray);
  textFieldROK.setText("");
  textFieldDosK.setFont(HauptSchrift);
  textFieldDosK.setForeground(Color.darkGray);
  textFieldDosK.setText("");
  textFieldAnlageK.setFont(HauptSchrift);
  textFieldAnlageK.setForeground(Color.darkGray);
  textFieldAnlageK.setText("");
  label1119.setFont(HauptSchrift);
  label1119.setForeground(SchriftFarbe);
  label1119.setText("Schmutzwassersiel EUR/a:");
  label37.setFont(HauptSchrift);
  label37.setForeground(SchriftFarbe);
  label37.setText("Regenwassersiel EUR/a:");
  label127.setForeground(SchriftFarbe);
  textFieldCO3.setFont(HauptSchrift);
  textFieldCO3.setForeground(Color.darkGray);
  textFieldCO3.setText("");
  //buttongrenzwert.setBackground(Color.lightGray);
  buttongrenzwert.setFont(HauptSchrift);
  //buttongrenzwert.setForeground(new Color(55, 71, 100));
  buttongrenzwert.setText("grenzwerte");
  buttongrenzwert.addMouseListener(new java.awt.event.MouseAdapter() {

    public void mouseClicked(MouseEvent e) {
      buttongrenzwert_mouseClicked(e);
    }
  });
  //buttonpreise.setBackground(Color.lightGray);
  buttonpreise.setFont(HauptSchrift);
  //buttonpreise.setForeground(new Color(55, 71, 100));
  buttonpreise.setText("preise");
  buttonpreise.addMouseListener(new java.awt.event.MouseAdapter() {

    public void mouseClicked(MouseEvent e) {
      buttonpreise_mouseClicked(e);
    }
  });

  this.getContentPane().add(panel1, null);
  panel1.add(labelAnalyse, null);
  panel1.add(textFieldAnalyse, null);
  panel1.add(label214, null);
  panel1.add(label2111, null);
  panel1.add(label2112, null);
  panel1.add(label218, null);
  panel1.add(label210, null);
  panel1.add(checkboxAnlage1, null);
  panel1.add(label212, null);
  panel1.add(buttonanalyse, null);
  panel1.add(buttongrenzwert, null);
  panel1.add(buttonpreise, null);
  panel1.add(label3, null);
  panel1.add(checkboxAnlage2, null);
  panel1.add(label1, null);
  panel1.add(label213, null);
  panel1.add(labelArt, null);
  panel1.add(checkboxKosten, null);
  panel1.add(label28, null);
  panel1.add(label216, null);
  //panel1.add(label6, null);
  panel1.add(label219, null);
  panel1.add(label24, null);
  panel1.add(label215, null);
  panel1.add(checkboxSiel, null);
  panel1.add(checkboxKosten, null);
  panel1.add(buttonthresh, null);
  panel1.add(buttonenthaertung, null);
  panel1.add(buttonentcarbonosierung, null);
  panel1.add(buttonumkehrosmosemit, null);
  panel1.add(buttonumkehrosmoseohne, null);
  panel1.add(buttondosierung, null);
  this.getContentPane().add(panel2, null);
  panel2.add(labelUmlaufwasseranalyse, null);
  panel2.add(label17, null);
  panel2.add(label19, null);
  panel2.add(label112, null);
  panel2.add(label10, null);
  panel2.add(label8, null);
  panel2.add(label117, null);
  panel2.add(label1110, null);
  panel2.add(label115, null);
  panel2.add(textFieldVerschnitt, null);
  panel2.add(label12, null);
  panel2.add(textFieldE, null);
  panel2.add(label119, null);
  panel2.add(textFieldTKT, null);
  panel2.add(label114, null);
  panel2.add(textFieldTW, null);
  panel2.add(label14, null);
  panel2.add(textFieldLF, null);
  panel2.add(label113, null);
  panel2.add(textFieldCa, null);
  panel2.add(label9, null);
  panel2.add(textFieldMg, null);
  panel2.add(label7, null);
  panel2.add(textFieldNa, null);
  panel2.add(label118, null);
  panel2.add(textFieldKS43, null);
  panel2.add(label15, null);
  panel2.add(textFieldCl, null);
  panel2.add(label111, null);
  panel2.add(textFieldSu, null);
  panel2.add(label11, null);
  panel2.add(textFieldNo3, null);
  panel2.add(label18, null);
  panel2.add(textFieldpHKT, null);
  panel2.add(label13, null);
  panel2.add(textFieldGGWKT, null);
  panel2.add(label110, null);
  panel2.add(textFieldSITKT, null);
  panel2.add(label16, null);
  panel2.add(textFieldGGWW, null);
  this.getContentPane().add(panel3, null);
  panel3.add(label5, null);
  panel3.add(textFieldSIW, null);
  panel3.add(label20, null);
  panel3.add(textFieldSalzGehalt, null);
  panel3.add(label221, null);
  panel3.add(textFieldI, null);
  panel3.add(label27, null);
  panel3.add(textFieldH2CO3, null);
  panel3.add(label2115, null);
  panel3.add(textFieldHCO3, null);
  panel3.add(label227, null);
  panel3.add(textFieldCO3, null);
  panel3.add(label222, null);
  panel3.add(label31, null);
  panel3.add(label32, null);
  panel3.add(label30, null);
  panel3.add(label25, null);
  panel3.add(label226, null);
  panel3.add(label2114, null);
  panel3.add(label220, null);
  panel3.add(label2113, null);
  panel3.add(label21, null);
  panel3.add(label2116, null);
  panel3.add(label2110, null);
  panel3.add(label2117, null);
  panel3.add(textFieldEnergieV, null);
  panel3.add(label211, null);
  panel3.add(textFieldZusatzV, null);
  panel3.add(label23, null);
  panel3.add(textFieldAbwasserV, null);
  panel3.add(label36, null);
  panel3.add(textFieldAbwasserV2, null);
  panel3.add(label224, null);
  panel3.add(textFieldDosV, null);
  panel3.add(label22, null);
  panel3.add(textFieldSalzTabV, null);
  panel3.add(label223, null);
  panel3.add(textFieldSalzSaeureV, null);
  panel3.add(label228, null);
  panel3.add(textFieldSchwefelV, null);
  this.getContentPane().add(panel4, null);
  panel4.add(label26, null);
  panel4.add(textFieldROV, null);
  panel4.add(label39, null);
  panel4.add(label41, null);
  panel4.add(label45, null);
  panel4.add(label35, null);
  panel4.add(label127, null);
  panel4.add(label1113, null);
  panel4.add(label124, null);
  panel4.add(label225, null);
  panel4.add(label1111, null);
  panel4.add(label122, null);
  panel4.add(label120, null);
  panel4.add(label33, null);
  panel4.add(label116, null);
  panel4.add(label121, null);
  panel4.add(label1112, null);
  panel4.add(label126, null);
  panel4.add(textFieldEnergieK, null);
  panel4.add(label125, null);
  panel4.add(textFieldZusatzK, null);
  panel4.add(label1119, null);
  panel4.add(textFieldAbWasserK, null);
  panel4.add(label37, null);
  panel4.add(textFieldAbWasserK2, null);
  panel4.add(label1118, null);
  panel4.add(textFieldDosK, null);
  panel4.add(label1117, null);
  panel4.add(textFieldSalzTabK, null);
  panel4.add(label34, null);
  panel4.add(textFieldSalzSaeureK, null);
  panel4.add(label1114, null);
  panel4.add(textFieldSchwefelsaeureK, null);
  panel4.add(label123, null);
  panel4.add(textFieldROK, null);
  panel4.add(label1115, null);
  panel4.add(textFieldAnlageK, null);
  //panel4.add(label40, null);
  //panel4.add(label38, null);
  //anlage.setBackground(Color.lightGray);
  anlage.setFont(HauptSchrift);
  //anlage.setForeground(new Color(55, 71, 100));
  anlage.setText("Anlageninfo");
  anlage.addMouseListener(new java.awt.event.MouseAdapter() {

    public void mouseClicked(MouseEvent e) {
      anlage_mouseClicked(e);
    }
  });
  panel4.add(anlage, null);
  panel4.add(label40, null);
  panel4.add(label41, null);
  panel4.add(label42, null);
  panel5.setLayout(gridLayout3);
  this.getContentPane().add(panel5, null);
  panel5.add(label1116, null);
  panel5.add(textFieldSummeK, null);
  //panel5.add(label47,null);
  //panel5.add(label48,null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);
  panel5.add(new JLabel(), null);

  /*passwd pf = new passwd(); //passwortcheck
       pf.ablauf(); //wann läuft pw aus
       //datum verstellt ?
       uhrCheck uc = new uhrCheck();hier geändert 050405*/

    //Beschriftungen aus EXCEL Tabelle auslesen
    try{
    Workbook workbook = Workbook.getWorkbook(new File(startframe.homeDir +
         "/../bin/wtkLg.xls"));
     Sheet sheet = workbook.getSheet(0);
     int i, j, k, l;
     /*
     Vector liste = new Vector();
     l = sheet.getColumns();
     l = l - 1; //erste Spalte nicht
     liste.setSize(l + 1); //nachsehen welche Sprachen in Tabelle verfügbar
     for (j = 1; j < l + 1; j++) {
       Cell s1 = sheet.getCell(j, 0);
       liste.setElementAt(s1.getContents(), j);
     }
     sprachDialog sd = new sprachDialog(this, "Bitte Sprache wählen.", true,
                                        liste);
     sd.setAlwaysOnTop(true);
     sd.setLocation(this.positionX(100), this.positionY(200));
     sd.setSize(100, 200);
     sd.setVisible(true);
     */
     k = sheet.getRows();
     startframe.Texte.setSize(k);
     //i =  startframe.sprachIndex+1; //welche Sprache ist ausgewählt
    i=1;
     for (j = 0; j < k - 1; j++) {
       Cell a1 = sheet.getCell(i, j);
       String S = a1.getContents();
       startframe.Texte.setElementAt(S, j);
     }
     workbook.close();
    }
    catch (jxl.read.biff.BiffException IOE) {
     System.out.println("IO Fehler" + IOE);
   }

   catch (java.io.IOException IOE) {
     System.out.println("IO Fehler" + IOE);
   }
   spracheneu();


  }

  void checkboxAnlage2_itemStateChanged(ItemEvent e) { //Änderungen am GUI bei anderer AufArt
    if (!this.checkboxAnlage1.isSelected()) {
      baufbereitung = false;
      this.buttondosierung.setEnabled(false);
      this.label119.setText(startframe.Texte.elementAt(56).toString());
      this.label13.setText(startframe.Texte.elementAt(69).toString());
      this.label18.setText(startframe.Texte.elementAt(67).toString());
      label110.setText(startframe.Texte.elementAt(71).toString());
      this.label114.setVisible(false);
      this.textFieldTW.setVisible(false);
      this.label16.setVisible(false);
      this.label5.setVisible(false);
      this.textFieldGGWW.setVisible(false);
      this.textFieldSIW.setVisible(false);
    }
  }

  //
  void checkboxKosten_itemStateChanged(ItemEvent e) { //wenn Kosten geändert
    if (this.checkboxKosten.isSelected()) {
      bkosten = true;
    }
    else {
      bkosten = false;
    }
    this.anlage.setEnabled(bkosten); //Schaltfläche Anlageinfo an/aus
  }

  void checkboxAnlage1_itemStateChanged(ItemEvent e) { //Änderungen am GUI bei anderer AufArt
    if (!this.checkboxAnlage2.isSelected()) {
      baufbereitung = true;
      this.buttondosierung.setEnabled(true);
      this.label119.setText(startframe.Texte.elementAt(55).toString());
      this.label13.setText(startframe.Texte.elementAt(68).toString());
      this.label18.setText(startframe.Texte.elementAt(66).toString());
      label110.setText(startframe.Texte.elementAt(70).toString());
      this.label114.setVisible(true);
      this.textFieldTW.setVisible(true);
      this.label16.setVisible(true);
      this.label5.setVisible(true);
      this.textFieldGGWW.setVisible(true);
      this.textFieldSIW.setVisible(true);
    }
  }

  //
  void buttonthresh_mouseClicked(MouseEvent e) {
    threshhold();
  }

  void buttonenthaertung_mouseClicked(MouseEvent e) {
    enthaertung();
  }

  void buttonentcarbonosierung_mouseClicked(MouseEvent e) {
    entcarbonisierung();
  }

  void buttonumkehrosmosemit_mouseClicked(MouseEvent e) {
    umkehrosmosem();
  }

  void buttonumkehrosmoseohne_mouseClicked(MouseEvent e) {
    umkehrosmoseo();
  }

  void buttondosierung_mouseClicked(MouseEvent e) {
    schwefelsaeuredos(); }
  void buttonanalyse_mouseClicked(MouseEvent e) {
    frei(); //HauptFensterInhalt löschen
    oeffneanalysendialog();
    textFieldAnalyse.setText(anaroh.analysenNummer);
  }

  void buttongrenzwert_mouseClicked(MouseEvent e) {
    frei(); //HauptFensterInhalt löschen
    oeffnegrenzwertedialog();
  }

  void buttonpreise_mouseClicked(MouseEvent e) {
    frei(); //HauptFensterInhalt löschen
    oeffnekostendialog();
  }

  void anlage_mouseClicked(MouseEvent e) {
    if (anlage.isEnabled() == false) {
      return; //wenn keine kosten berechnet sind
    }

    anlagenframe af = new anlagenframe(this);
    af.setVisible(true);
    //anlageapplet ap = new anlageapplet();
    //ap.setVisible(true);

  }

  //Rückgabe der Position
  int positionX(int x) {
    Point posParent;
    int b, posX;
    posParent = this.getLocation();
    b = getSize().width;
    posX = (int) ( (posParent.x + b / 2) - (x / 2));
    return posX;
  }

  //Rückgabe der Position
  int positionY(int y) {
    Point posParent;
    int h, posY;
    posParent = this.getLocation();
    h = getSize().height;
    posY = (int) ( (posParent.y + h / 2) - (y / 2));
    return posY;
  }

  //Initialisierung der rohanalyse
  void rohanalyseinit() {
    anaroh.analysenNummer = "default";
    anaroh.kunde = "Musterkunde";
    anaroh.bearbeiter = "Musterbearbeiter";
    anaroh.projekt = "Musterprojekt";
    anaroh.tE = 12.0;
    anaroh.pHtE = 7.5;
    anaroh.lF = 500.0;
    anaroh.ca = 50.00;
    anaroh.mg = 10.00;
    anaroh.so4 = 30.00;
    anaroh.cl = 50.00;
    anaroh.no3 = 10.00;
    anaroh.na = 32.73;
    anaroh.pHggW = 7.74;
    anaroh.sitE = -0.024;
    anaroh.ks = 2.5;
    anaroh.lFBer = 498.111;
    anaroh.suK = 0.004697;
    anaroh.co3 = 0.21;
    anaroh.h2co3 = 8.9551111;
    anaroh.hco3 = 152.511111;
    return;
  }

  void kosteninit() {
    betriebsMittelKosten.stadtWasser = 1.50;
    betriebsMittelKosten.abWasser = 2.50;
    betriebsMittelKosten.energie = 0.15;
    betriebsMittelKosten.leistung = 1000;
    betriebsMittelKosten.leistung2 = 100000;
    betriebsMittelKosten.auslastung = 50;
    betriebsMittelKosten.dosierMittel = 6;
    betriebsMittelKosten.dosierMenge = 150;
    betriebsMittelKosten.salzTabletten = 0.3;
    betriebsMittelKosten.salzSaeure = 0.5;
    betriebsMittelKosten.schwefelSaeure = 0.3;
    betriebsMittelKosten.ro = 5;
    betriebsMittelKosten.roMenge = 30;

  }

  void grenzwertinit() {
    bedingungen.EF = 5.0;
    bedingungen.siMax = 2.3;
    bedingungen.clMax = 250;
    bedingungen.so4Max = 400;
    bedingungen.roMax = 2.0;
    bedingungen.caMax = 0.5;
    //bedingungen.dhMin = .0;
    //bedingungen.dhMax = 7.0;
    //bedingungen.alkMin = 3.0;
    bedingungen.tKT = 20;
    bedingungen.tW = 35.0;
    //bedingungen.tLW = 12.0;
    //bedingungen.lF = 1000;
    bedingungen2.siMax = 2.0;
    //bedingungen2.clMax = 250;
    //bedingungen2.so4Max = 400;
    bedingungen2.roMax = 2.0;
    bedingungen2.dhMin = 2.0;
    bedingungen2.dhMax = 7.0;
    bedingungen2.alkMin = 3.0;
    //bedingungen2.tKT = 20;
    //bedingungen2.tW = 35.0;
    bedingungen2.tLW = 12.0;
    bedingungen2.lF = 1000;

  }

  //Fenster schliessen Routine
  public void fenster_Zu(WindowEvent e) {
    this.setVisible(false);
    this.dispose();

  }

  void anzeigen() {
    //kontrolliert was berechnet wurde und schreibt es in die
    //Variablen banalysberechnet und bkostenberechnet
    rechenkontrolle();
    //analyse
    try {
      textFieldVerschnitt.setText(dts( (anauml.verSchnitt) * 100).
                                  substring(0, 3));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldVerschnitt.setText(dts( (anauml.verSchnitt) * 100));
    }

    try {
      textFieldE.setText(dts(anauml.eindickung).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldE.setText(dts(anauml.eindickung));
    }

    try {
      textFieldTKT.setText(dts(anauml.tKT).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldTKT.setText(dts(anauml.tKT));
    }

    try {
      textFieldTW.setText(dts(anauml.tW).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldTW.setText(dts(anauml.tW));
    }

    try {
      textFieldLF.setText(dts(anauml.lF).substring(0, 6));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldLF.setText(dts(anauml.lF));
    }
    try {
      textFieldCa.setText(dts(anauml.ca).substring(0, 5));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldCa.setText(dts(anauml.ca));
    }
    textFieldMg.setText(String.format(java.util.Locale.GERMAN, "%.1f", anauml.mg));

    textFieldNa.setText(String.format(java.util.Locale.GERMAN, "%.1f", anauml.na));

    textFieldKS43.setText(String.format(java.util.Locale.GERMAN, "%.2f", anauml.ks));

    textFieldCl.setText(String.format(java.util.Locale.GERMAN, "%.1f", anauml.cl));

    textFieldSu.setText(String.format(java.util.Locale.GERMAN, "%.1f", anauml.so4));

    textFieldNo3.setText(String.format(java.util.Locale.GERMAN, "%.1f", anauml.no3));

    try {
      textFieldpHKT.setText(dts(anauml.pHKTnV).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldpHKT.setText(dts(anauml.pHKTnV));
    }
    try {
      textFieldGGWKT.setText(dts(anauml.pHTKT).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldGGWKT.setText(dts(anauml.pHTKT));
    }
    try {
      textFieldSITKT.setText(dts(anauml.siTKT).substring(0, 5));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldSITKT.setText(dts(anauml.siTKT));
    }
    try {
      textFieldGGWW.setText(dts(anauml.pHggWW).substring(0, 4));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldGGWW.setText(dts(anauml.pHggWW));
    }
    try {
      textFieldSIW.setText(dts(anauml.sIW).substring(0, 5));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldSIW.setText(dts(anauml.sIW));
    }
    textFieldSalzGehalt.setText(String.format(java.util.Locale.GERMAN, "%.1f", anauml.salz));
    textFieldI.setText(String.format(java.util.Locale.GERMAN, "%.1f", anauml.ionen));
    textFieldH2CO3.setText(String.format(java.util.Locale.GERMAN, "%.2f", anauml.h2co3));
    textFieldHCO3.setText(String.format(java.util.Locale.GERMAN, "%.1f", anauml.hco3));
    textFieldCO3.setText(String.format(java.util.Locale.GERMAN, "%.1f", anauml.co3));

    //verbrauch
    try {
      textFieldEnergieV.setText(dts(betrkost.enVer).substring(0, 6));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldEnergieV.setText(dts(betrkost.enVer));
    }

    try {
      textFieldZusatzV.setText(dts(betrkost.stadtWasserVer).
                               substring(0, 6));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldZusatzV.setText(dts(betrkost.stadtWasserVer));
    }

    try {
      textFieldAbwasserV.setText(dts(betrkost.abWasserVer).
                                 substring(0, 6));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldAbwasserV.setText(dts(betrkost.abWasserVer));
    }
    //zweites Siel ja/nein
    if (this.checkboxSiel.isSelected()) {
      try {
        textFieldAbwasserV2.setText(dts(betrkost.regenSielVer).
                                    substring(0, 6));
      }
      catch (StringIndexOutOfBoundsException e) {
        textFieldAbwasserV2.setText(dts(betrkost.regenSielVer));
      }
    }
    else {
      textFieldAbwasserV2.setText("0,0");
    }
    //
    try {
      textFieldDosV.setText(dts(betrkost.dosMittelVer).substring(0,
          6));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldDosV.setText(dts(betrkost.dosMittelVer));
    }
    try {
      textFieldSalzTabV.setText(dts(betrkost.salzTabVer).substring(
          0, 6));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldSalzTabV.setText(dts(betrkost.salzTabVer));
    }
    try {
      textFieldSalzSaeureV.setText(dts(betrkost.salzSaeureVer).
                                   substring(0, 6));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldSalzSaeureV.setText(dts(betrkost.salzSaeureVer));
    }
    try {
      textFieldSchwefelV.setText(dts(betrkost.schwefelSaeureVer).
                                 substring(0, 6));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldSchwefelV.setText(dts(betrkost.schwefelSaeureVer));
    }
    try {
      textFieldROV.setText(dts(betrkost.roVer).substring(0, 6));
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldROV.setText(dts(betrkost.roVer));
    }
    //kosten
    try {
      textFieldEnergieK.setText(Integer.toString( (int) betrkost.enKost) +
                                ",00");
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldEnergieK.setText(dts(betrkost.enKost));
    }

    try {
      textFieldZusatzK.setText(Integer.toString( (int) (betrkost.
          stadtWasserKost)) + ",00");
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldZusatzK.setText(Integer.toString( (int) (betrkost.
          stadtWasserKost)) + ",00");
    }

    try {
      textFieldAbWasserK.setText(Integer.toString( (int) betrkost.abWasserKost) +
                                 ",00");
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldAbWasserK.setText(dts(betrkost.abWasserKost));
    }
    if (this.checkboxSiel.isSelected()) { //zweites Siel ja/nein
      try {
        textFieldAbWasserK2.setText(Integer.toString( (int) betrkost.
            regenSielKost) + ",00");
      }
      catch (StringIndexOutOfBoundsException e) {
        textFieldAbWasserK2.setText(dts(betrkost.regenSielKost));
      }
    }
    else {
      textFieldAbWasserK2.setText("0,00");
    }
    //
    try {
      textFieldDosK.setText(Integer.toString( (int) betrkost.dosMittelKost) +
                            ",00");
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldDosK.setText(dts(betrkost.dosMittelKost));
    }
    try {
      textFieldSalzTabK.setText(Integer.toString( (int) betrkost.salzTabKost) +
                                ",00");
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldSalzTabK.setText(dts(betrkost.salzTabKost));
    }
    try {
      textFieldSalzSaeureK.setText(Integer.toString( (int) betrkost.
          salzSaeureKost) + ",00");
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldSalzSaeureK.setText(dts(betrkost.salzSaeureKost));
    }
    try {
      textFieldSchwefelsaeureK.setText(Integer.toString( (int) betrkost.
          schwefelSaeureKost) + ",00");
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldSchwefelsaeureK.setText(dts(betrkost.
          schwefelSaeureKost));
    }
    try {
      textFieldROK.setText(Integer.toString( (int) betrkost.roKost) + ",00");
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldROK.setText(dts(betrkost.roKost));
    }
    try {
      textFieldAnlageK.setText(Integer.toString( (int) anlkost.jahresBetrag) +
                               ",00");
    }
    catch (StringIndexOutOfBoundsException e) {
      textFieldAnlageK.setText(dts(anlkost.jahresBetrag));
    }
    double summe;
    summe = betrkost.enKost + betrkost.stadtWasserKost + betrkost.abWasserKost +
        betrkost.regenSielKost +
        betrkost.dosMittelKost + betrkost.salzTabKost + betrkost.salzSaeureKost +
        betrkost.schwefelSaeureKost + betrkost.roKost + anlkost.jahresBetrag;

    textFieldSummeK.setText(Integer.toString( (int) summe) + ",00");

  }

  private static String dts(double v) {
    return Double.toString(v).replace('.', ',');
  }

  public void oeffnekostendialog() {
    //passwd pf = new passwd(); //passwortcheck
    kostendialog kosten = new kostendialog(this, "Bitte Kosten eingeben.", true);
    kosten.setSize(800, 350);
    kosten.setLocation(positionX(800), positionY(350));
    //aus dem datensatz in den Dialog
    kosten.auslesen(betriebsMittelKosten);
    kosten.setVisible(true);
    betriebsMittelKosten = kosten.einlesen();
  }

  public void oeffnegrenzwertedialog() {
    if (this.checkboxAnlage1.isSelected()) {
      passwd pf = new passwd(); //passwortcheck
      grenzwertedialog grenzWerte = new grenzwertedialog(this,
          startframe.Texte.elementAt(160).toString(), true);
      grenzWerte.setSize(900, 350);
      grenzWerte.setLocation(positionX(900), positionY(350));
      //aus dem datensatz in den Dialog
      grenzWerte.auslesen(bedingungen);
      grenzWerte.setVisible(true);
      //uebergabe der grenzwerte
      bedingungen = grenzWerte.einlesen();
    }
    else {
      grenzwertedialog2 grenzWerte2 = new grenzwertedialog2(this,
          startframe.Texte.elementAt(160).toString(), true);
      grenzWerte2.setSize(900, 350);
      grenzWerte2.setLocation(positionX(900), positionY(350));
      //aus dem datensatz in den Dialog
      grenzWerte2.auslesen(bedingungen2);
      grenzWerte2.setVisible(true);
      //uebergabe der grenzwerte
      bedingungen2 = grenzWerte2.einlesen();
    }
  }

  public void anarohtoanaumlauf() {
    anauml.analysenNummer = anaroh.analysenNummer;
    anauml.kunde = anaroh.kunde;
    anauml.bearbeiter = anaroh.bearbeiter;
    anauml.projekt = anaroh.projekt;
  }

  public void oeffneanalysendialog() {
    passwd pf = new passwd();
    boolean weiter = false;
    analysendialog analyse = new analysendialog(this, "", true);
    analyse.setSize(900, 350);
    analyse.setLocation(positionX(900), positionY(350));
    weiter = analyse.auslesen(anaroh);
    analyse.setVisible(true);
    //weiter = analyse.berechne();
    anaroh = analyse.einlesen();
    analyse.dispose();

    //String ann = anaroh.analysenNummer;
    //textFieldAnalyse.setText(ann);
  }

  //
  public void rechenkontrolle() {
    banalyseberechnet = true;
    if (bkosten) {
      bkostenberechnet = true;
    }
  }

  //
  void frei() {
    textFieldVerschnitt.setText("");
    textFieldE.setText("");
    textFieldTKT.setText("");
    textFieldTW.setText("");
    textFieldLF.setText("");
    textFieldCa.setText("");
    textFieldMg.setText("");
    textFieldNa.setText("");
    textFieldKS43.setText("");
    textFieldCl.setText("");
    textFieldSu.setText("");
    textFieldNo3.setText("");
    textFieldpHKT.setText("");
    textFieldGGWKT.setText("");
    textFieldSITKT.setText("");
    textFieldGGWW.setText("");
    textFieldSIW.setText("");
    textFieldSalzGehalt.setText("");
    textFieldI.setText("");
    textFieldH2CO3.setText("");
    textFieldHCO3.setText("");
    textFieldCO3.setText("");

    //verbrauch
    textFieldEnergieV.setText("");
    textFieldZusatzV.setText("");
    textFieldAbwasserV.setText("");
    textFieldDosV.setText("");
    textFieldSalzTabV.setText("");
    textFieldSalzSaeureV.setText("");
    textFieldSchwefelV.setText("");
    textFieldROV.setText("");

    //kosten
    textFieldEnergieK.setText("");
    textFieldZusatzK.setText("");
    textFieldAbWasserK.setText("");
    textFieldDosK.setText("");
    textFieldSalzTabK.setText("");
    textFieldSalzSaeureK.setText("");
    textFieldSchwefelsaeureK.setText("");
    textFieldROK.setText("");
    textFieldSummeK.setText("");
  }

  public void run() {}

  public void threshhold() {
    this.labelArt.setText(startframe.Texte.elementAt(32).toString());
    //Speichern in Variable für späteren Druck
    aufbereitung = "threshold Stabilisierung";
    aufbereitungAnzeige = startframe.Texte.elementAt(32).toString();
    //wenn Kuehlturm
    if (this.checkboxAnlage1.isSelected()) {
      fehler = watkostberechnung.threch(anaroh, bedingungen,aufbereitungAnzeige);
    }
    //oder wenn umlaufwasser
    if (this.checkboxAnlage2.isSelected()) {
      fehler = watkostberechnung.threchL(anaroh, bedingungen2,aufbereitungAnzeige);
    }
    if (!fehler) { //wenn prozess durch warnfenster abgebrochen
      frei();
      fehler = true;
      return;
    }
    anauml = watkostberechnung.einlesen();
    //Daten übernehmen
    anarohtoanaumlauf();
    if (this.checkboxKosten.isSelected()) { //wenn auch Kostenberechnung
      //wenn Kuehlturm
      if (this.checkboxAnlage1.isSelected()) {
        betrkost = thkostenberechnung.kostthrech(betriebsMittelKosten,
                                                 anauml.eindickung,
                                                 anauml.verSchnitt);
      }
      //oder wenn umlaufwasser
      if (this.checkboxAnlage2.isSelected()) {
        betrkost = thkostenberechnung.kostthrechL(betriebsMittelKosten,
                                                  anauml.eindickung,
                                                  anauml.verSchnitt);
      }
    }
    else {
      betrkost.nullen(); //wenn ohne kosten, alles auf null setzen
    }
    anlkost = anlageberechnung.thberechne(betrkost.stadtWasserVer,
                                          betriebsMittelKosten.auslastung,
                                          betrkost.dosMittelVer); //anlagenPreis berechnen
    anzeigen(); //in GUI einlesen

  }

  public void enthaertung() {
    this.labelArt.setText(startframe.Texte.elementAt(33).toString());
    //Speichern in Variable für späteren Druck
    aufbereitung = "Enthärtung";
    aufbereitungAnzeige = startframe.Texte.elementAt(33).toString();
    //wenn Kuehlturm
    if (this.checkboxAnlage1.isSelected()) {
      fehler = watkostberechnung.ehrech(anaroh, bedingungen,aufbereitungAnzeige);
    }
    //oder wenn umlaufwasser
    if (this.checkboxAnlage2.isSelected()) {
      fehler = watkostberechnung.ehrechL(anaroh, bedingungen2,aufbereitungAnzeige);
    }
    if (!fehler) { //wenn prozess durch warnfenster abgebrochen
      frei();
      fehler = true;
      return;
    }
    anauml = watkostberechnung.einlesen();
    //Daten übernehmen
    anarohtoanaumlauf();
    if (this.checkboxKosten.isSelected()) { //wenn auch Kostenberechnung

      //wenn Kuehlturm
      if (this.checkboxAnlage1.isSelected()) {
        betrkost = ehkostenberechnung.kostehrech(betriebsMittelKosten,
                                                 anauml.eindickung,
                                                 anauml.verSchnitt, anaroh.suK);
      }
      //oder wenn umlaufwasser
      if (this.checkboxAnlage2.isSelected()) {
        betrkost = ehkostenberechnung.kostehrechL(betriebsMittelKosten,
                                                  anauml.eindickung,
                                                  anauml.verSchnitt, anaroh.suK);
      }
    }
    else {
      betrkost.nullen(); //wenn ohne kosten, alles auf null setzen
    }
    //anlagenkosten berechnen
    anlkost = anlageberechnung.ehberechne(betrkost.stadtWasserVer, anauml.salz,
                                          betriebsMittelKosten.auslastung,
                                          betrkost.dosMittelVer);
    anzeigen(); //in GUI einlesen

  }

  public void entcarbonisierung() {
    this.labelArt.setText(startframe.Texte.elementAt(34).toString());
    //Speichern in Variable für späteren Druck
    aufbereitung = "Entcarbonisierung";
    aufbereitungAnzeige = startframe.Texte.elementAt(34).toString();

    //wenn Kuehlturm
    if (this.checkboxAnlage1.isSelected()) {
      fehler = watkostberechnung.ecrech(anaroh, bedingungen,aufbereitungAnzeige);
    }
    //oder wenn umlaufwasser
    if (this.checkboxAnlage2.isSelected()) {
      fehler = watkostberechnung.ecrechL(anaroh, bedingungen2,aufbereitungAnzeige);
    }
    if (!fehler) { //wenn prozess durch warnfenster abgebrochen
      frei();
      fehler = true;
      return;
    }
    anauml = watkostberechnung.einlesen();
    //Daten übernehmen
    anarohtoanaumlauf();
    if (this.checkboxKosten.isSelected()) { //wenn auch Kostenberechnung
      //wenn Kuehlturm
      if (this.checkboxAnlage1.isSelected()) {
        betrkost = eckostenberechnung.kostecrech(betriebsMittelKosten,
                                                 anauml.eindickung,
                                                 anauml.verSchnitt, anaroh.ks);
      }
      //oder wenn umlaufwasser
      if (this.checkboxAnlage2.isSelected()) {
        betrkost = eckostenberechnung.kostecrechL(betriebsMittelKosten,
                                                  anauml.eindickung,
                                                  anauml.verSchnitt, anaroh.ks);
      }
    }
    else {
      betrkost.nullen(); //wenn ohne kosten, alles auf null setzen
    }
    //anlagenkosten berechnen
    anlkost = anlageberechnung.ecberechne(betrkost.stadtWasserVer, anauml.ks,
                                          betriebsMittelKosten.auslastung,
                                          betrkost.dosMittelVer);

    anzeigen(); //in GUI einlesen

  }

  public void umkehrosmoseo() {
    //ein Siel oder zwei
    int siel = 1;
    if (this.checkboxSiel.isSelected()) {
      siel = 2;
    }
    //
    this.labelArt.setText(startframe.Texte.elementAt(36).toString());
    //Speichern in Variable für späteren Druck
    aufbereitung = "Umkehrosmose o. v. Enthärtung";
    aufbereitungAnzeige = startframe.Texte.elementAt(36).toString();
    //wenn Kuehlturm
    if (this.checkboxAnlage1.isSelected()) {
      fehler = watkostberechnung.uorech(anaroh, bedingungen,aufbereitungAnzeige);
    }
    //oder wenn umlaufwasser
    if (this.checkboxAnlage2.isSelected()) {
      fehler = watkostberechnung.uorechL(anaroh, bedingungen2,aufbereitung);
    }

    if (!fehler) { //wenn prozess durch warnfenster abgebrochen
      frei();
      fehler = true;
      return;
    }
    anauml = watkostberechnung.einlesen();
    //Daten übernehmen
    anarohtoanaumlauf();
    if (this.checkboxKosten.isSelected()) { //wenn auch Kostenberechnung
      //wenn Kuehlturm
      if (this.checkboxAnlage1.isSelected()) {
        betrkost = uookostenberechnung.kostuorech(betriebsMittelKosten,
                                                  bedingungen, anaroh,
                                                  anauml.eindickung,
                                                  anauml.verSchnitt, siel);
      }
      //oder wenn umlaufwasser
      if (this.checkboxAnlage2.isSelected()) {
        betrkost = uookostenberechnung.kostuorechL(betriebsMittelKosten,
            bedingungen2, anaroh, anauml.eindickung, anauml.verSchnitt, siel);
      }
    }
    else {
      betrkost.nullen(); //wenn ohne kosten, alles auf null setzen
    }
    anlkost = anlageberechnung.uoberechne(betrkost.stadtWasserVer,
                                          betriebsMittelKosten.auslastung,
                                          betrkost.dosMittelVer);
    anzeigen(); //in GUI einlesen

  }

  //public void rfg(){}
  public void umkehrosmosem() {
    //ein Siel oder zwei
    int siel = 1;
    if (this.checkboxSiel.isSelected()) {
      siel = 2;
    }
    //iii
    this.labelArt.setText(startframe.Texte.elementAt(35).toString());
    //Speichern in Variable für späteren Druck
    aufbereitung = "Umkehrosmose m. v. Enthaertung";
    aufbereitungAnzeige = startframe.Texte.elementAt(35).toString();
    //wenn Kuehlturm
    if (this.checkboxAnlage1.isSelected()) {
      fehler = watkostberechnung.uorech(anaroh, bedingungen,aufbereitungAnzeige);
    }
    //oder wenn umlaufwasser
    if (this.checkboxAnlage2.isSelected()) {
      fehler = watkostberechnung.uorechL(anaroh, bedingungen2,aufbereitungAnzeige);
    }

    if (!fehler) { //wenn prozess durch warnfenster abgebrochen
      frei();
      fehler = true;
      return;
    }
    anauml = watkostberechnung.einlesen();
    //Daten übernehmen
    anarohtoanaumlauf();
    if (this.checkboxKosten.isSelected()) { //wenn auch Kostenberechnung
      //wenn Kuehlturm
      if (this.checkboxAnlage1.isSelected()) {
        betrkost = uomkostenberechnung.kostuorechmit(betriebsMittelKosten,
            anauml.eindickung, anauml.verSchnitt, anaroh.suK, siel);
      }
      //oder wenn umlaufwasser
      if (this.checkboxAnlage2.isSelected()) {
        betrkost = uomkostenberechnung.kostuorechmitL(betriebsMittelKosten,
            anauml.eindickung, anauml.verSchnitt, anaroh.suK, siel);
      }
    }
    else {
      betrkost.nullen(); //wenn ohne kosten, alles auf null setzen
    }
    anlkost = anlageberechnung.uoehberechne(betrkost.stadtWasserVer,
                                            anauml.salz,
                                            betriebsMittelKosten.auslastung,
                                            betrkost.dosMittelVer);
    anzeigen(); //in GUI einlesen

  }

  public void schwefelsaeuredos() {
    if (buttondosierung.isEnabled() == false) {
      return;
    }
    this.labelArt.setText(startframe.Texte.elementAt(37).toString());
    //Speichern in Variable für späteren Druck
    aufbereitung = "Schwefelsäuredosierung";
    aufbereitungAnzeige = startframe.Texte.elementAt(37).toString();
    //wenn Kuehlturm
    if (this.checkboxAnlage1.isSelected()) {
      fehler = watkostberechnung.sdrech(anaroh, bedingungen,aufbereitungAnzeige);
    }

    if (!fehler) { //wenn prozess durch warnfenster abgebrochen
      frei();
      fehler = true;
      return;
    }
    //oder wenn umlaufwasser
    //if(this.checkboxAnlage2.isSelected()) watkostberechnung.sdrechL(anaroh,bedingungen);
    anauml = watkostberechnung.einlesen();
    //Daten übernehmen
    anarohtoanaumlauf();
    if (this.checkboxKosten.isSelected()) { //wenn auch Kostenberechnung
      //wenn Kuehlturm
      if (this.checkboxAnlage1.isSelected()) {
        betrkost = sdkostenberechnung.kostsdrech(betriebsMittelKosten, anaroh,
                                                 anauml.eindickung,
                                                 anauml.verSchnitt, anauml.ks);
      }
    }
    else {
      betrkost.nullen(); //wenn ohne kosten, alles auf null setzen
    }
    anlkost = anlageberechnung.sdberechne(betrkost.stadtWasserVer,
                                          betriebsMittelKosten.auslastung,
                                          betrkost.dosMittelVer);
    anzeigen(); //in GUI einlesen

  }

  public void sprache() {
    passwd pf = new passwd();
      try {
      Workbook workbook = Workbook.getWorkbook(new File(startframe.homeDir +
          "/../bin/wtkLg.xls"));
      Sheet sheet = workbook.getSheet(0);
      int i, j, k, l;
      Vector liste = new Vector(); //Vector zur Aufnahme der Excel Sprachtabelle
      l = sheet.getColumns();
      l = l - 1; //erste Spalte nicht
      liste.setSize(l + 1); //nachsehen welche Sprachen in Tabelle verfügbar
      for (j = 1; j < l + 1; j++) {
        Cell s1 = sheet.getCell(j, 0);
        liste.setElementAt(s1.getContents(), j);
      }
      sprachDialog sd = new sprachDialog(this, startframe.Texte.elementAt(178).toString(), true,
                                         liste);
      //sd.setAlwaysOnTop(true);
      sd.setLocation(this.positionX(100), this.positionY(200));
      sd.setSize(200, 100);
      sd.setVisible(true);
      k = sheet.getRows();
      startframe.Texte.setSize(k);
      i = startframe.sprachIndex + 1; //welche Sprache ist ausgewählt
      for (j = 0; j < k - 1; j++) {
        Cell a1 = sheet.getCell(i, j);
        String S = a1.getContents();
        startframe.Texte.setElementAt(S, j);
      }
      workbook.close();
    }

    catch (jxl.read.biff.BiffException IOE) {
      System.out.println("IO Fehler" + IOE);
    }

    catch (java.io.IOException IOE) {
      System.out.println("IO Fehler" + IOE);
    }
    spracheneu();
    // Neue Auswahl in preferences file schreiben
    try {
      String neupwd = startframe.prefs.substring(0,19)+startframe.sprachIndex;
      FileOutputStream file = new FileOutputStream(startframe.homeDir+"/../prefs.ini");
      ObjectOutputStream in = new ObjectOutputStream(file);
      in.writeObject(neupwd);
      in.flush();
      file.close();
    }
    catch (java.io.IOException IOE) {
      System.out.println("IO Fehler" + IOE);
    }


  //

  }

  void spracheneu() {

    try {
      this.getMenuBar().getMenu(0).setLabel(startframe.Texte.elementAt(2).
                                            toString());
      int ic = this.getMenuBar().getMenu(0).getItemCount();
      int i;
      for (i = 0; i < ic; i++) {
        this.getMenuBar().getMenu(0).getItem(i).setLabel(startframe.Texte.
            elementAt(i + 3).toString());
      }
      //this.getMenuBar().getMenu(0).getItem(7).getItem(0).setLabel(startframe.Texte.elementAt(13).toString());
      Menu M1 = (Menu)this.getMenuBar().getMenu(0).getItem(7);
      M1.getItem(0).setLabel(startframe.Texte.elementAt(14).toString());
      M1.getItem(1).setLabel(startframe.Texte.elementAt(15).toString());
      M1.getItem(2).setLabel(startframe.Texte.elementAt(16).toString());
      M1.getItem(3).setLabel(startframe.Texte.elementAt(17).toString());

      this.getMenuBar().getMenu(1).setLabel(startframe.Texte.elementAt(19).
                                            toString());
      ic = this.getMenuBar().getMenu(1).getItemCount();
      for (i = 0; i < ic; i++) {
        this.getMenuBar().getMenu(1).getItem(i).setLabel(startframe.Texte.
            elementAt(i + 20).toString());
      }
      this.getMenuBar().getMenu(2).setLabel(startframe.Texte.elementAt(28).
                                            toString());
      ic = this.getMenuBar().getMenu(2).getItemCount();
      for (i = 0; i < ic; i++) {
        this.getMenuBar().getMenu(2).getItem(i).setLabel(startframe.Texte.
            elementAt(i + 28).toString());
      }

      label213.setText(startframe.Texte.elementAt(31).toString());
      buttonthresh.setText(startframe.Texte.elementAt(32).toString());
      buttonenthaertung.setText(startframe.Texte.elementAt(33).toString());
      buttonentcarbonosierung.setText(startframe.Texte.elementAt(34).toString());
      buttonumkehrosmosemit.setText(startframe.Texte.elementAt(35).toString());
      buttonumkehrosmoseohne.setText(startframe.Texte.elementAt(36).toString());
      buttondosierung.setText(startframe.Texte.elementAt(37).toString());

      buttonanalyse.setText(startframe.Texte.elementAt(40).toString());
      buttongrenzwert.setText(startframe.Texte.elementAt(41).toString());
      buttonpreise.setText(startframe.Texte.elementAt(42).toString());
      checkboxSiel.setText(startframe.Texte.elementAt(43).toString());
      checkboxKosten.setText(startframe.Texte.elementAt(44).toString());
      anlage.setText(startframe.Texte.elementAt(16).toString());
      labelAnalyse.setText(startframe.Texte.elementAt(47).toString());
      //textFieldAnalyse.setText("default");
      checkboxAnlage1.setText(startframe.Texte.elementAt(48).toString());
      checkboxAnlage2.setText(startframe.Texte.elementAt(49).toString());

      labelArt.setText(startframe.Texte.elementAt(51).toString());
      labelUmlaufwasseranalyse.setText(startframe.Texte.elementAt(52).toString());
      label115.setText(startframe.Texte.elementAt(53).toString());
      label12.setText(startframe.Texte.elementAt(54).toString());
      label119.setText(startframe.Texte.elementAt(55).toString());
      label114.setText(startframe.Texte.elementAt(57).toString());
      label14.setText(startframe.Texte.elementAt(58).toString());
      label113.setText(startframe.Texte.elementAt(59).toString());
      label9.setText(startframe.Texte.elementAt(60).toString());
      label7.setText(startframe.Texte.elementAt(61).toString().replace("Mg/l", "mg/l"));
      label8.setText(" ");
      label118.setText(startframe.Texte.elementAt(62).toString());
      label10.setText(" ");
      label15.setText(startframe.Texte.elementAt(63).toString());
      label111.setText(startframe.Texte.elementAt(64).toString());
      label11.setText(startframe.Texte.elementAt(65).toString());
      label18.setText(startframe.Texte.elementAt(66).toString());
      label13.setText(startframe.Texte.elementAt(68).toString());
      label110.setText(startframe.Texte.elementAt(70).toString());
      label16.setText(startframe.Texte.elementAt(72).toString());
      label5.setText(startframe.Texte.elementAt(73).toString());
      label17.setText(" ");
      label20.setText(startframe.Texte.elementAt(74).toString());
      label19.setText(" ");
      label221.setText(startframe.Texte.elementAt(75).toString());
      label27.setText(startframe.Texte.elementAt(81).toString());
      label2115.setText(startframe.Texte.elementAt(77).toString());
      label227.setText(startframe.Texte.elementAt(78).toString());

      if (checkboxAnlage2.isSelected()) { //Wenn Luftwäscher
        this.label119.setText(startframe.Texte.elementAt(56).toString());
        this.label13.setText(startframe.Texte.elementAt(69).toString());
        this.label18.setText(startframe.Texte.elementAt(67).toString());
        label110.setText(startframe.Texte.elementAt(71).toString());
      }

      label112.setText(" ");
      label117.setText(" ");
      label1110.setText(" ");
      label25.setText(startframe.Texte.elementAt(82).toString());
      label2117.setText(startframe.Texte.elementAt(83).toString());
      label211.setText(startframe.Texte.elementAt(84).toString());
      label23.setText(startframe.Texte.elementAt(85).toString());
      label36.setText(startframe.Texte.elementAt(86).toString());
      label224.setText(startframe.Texte.elementAt(87).toString());
      label22.setText(startframe.Texte.elementAt(88).toString());
      label223.setText(startframe.Texte.elementAt(89).toString());
      label228.setText(startframe.Texte.elementAt(90).toString());
      label26.setText(startframe.Texte.elementAt(91).toString());

      label225.setText(startframe.Texte.elementAt(94).toString());
      label126.setText(startframe.Texte.elementAt(95).toString());
      label125.setText(startframe.Texte.elementAt(96).toString());
      label1119.setText(startframe.Texte.elementAt(97).toString());
      label37.setText(startframe.Texte.elementAt(98).toString());
      label1118.setText(startframe.Texte.elementAt(99).toString());
      label1117.setText(startframe.Texte.elementAt(100).toString());
      label34.setText(startframe.Texte.elementAt(101).toString());
      label1114.setText(startframe.Texte.elementAt(102).toString());
      label123.setText(startframe.Texte.elementAt(103).toString());
      label1115.setText(startframe.Texte.elementAt(104).toString());
      label1116.setText(startframe.Texte.elementAt(105).toString());

      label33.setText(" ");
      label1111.setText(" ");
      label116.setText(" ");
      label1112.setText(" ");
      label120.setText(" ");
      label121.setText(" ");
      label122.setText(" ");

    }
    catch (java.lang.NullPointerException IOE) {
      System.out.println("IO Fehler" + IOE);

    }

  }
}
