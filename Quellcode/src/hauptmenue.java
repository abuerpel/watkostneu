/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.io.File;
import java.util.Date;
import jxl.Workbook;
import jxl.write.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.util.*;

public class hauptmenue
    extends MenuBar {
  private FileDialog fd;
  File dateiObject;
  FileReader in;
  FileWriter out;
  private hauptframe f;
  private Runtime rt;
  Menu m1 = new Menu("datei");
  public hauptmenue(final hauptframe f) {
    //Dialoge
    fd = new FileDialog(f);
    //Hauptfenster
    this.f = f;
    //Menü
    MenuBar hauptmenue = new MenuBar();
    String p = new String();


    /*try
         {
      p = startframe.Texte.elementAt(1).toString();
         // m1.add(new Menu(startframe.Texte.elementAt(1).toString()));
         String STR = startframe.Texte.elementAt(1).toString();
     m1.setLabel(startframe.Texte.elementAt(1).toString());

        }
      catch (java.lang.NullPointerException IOE) {
       System.out.println("IO Fehler" + IOE);

     }
     */
    Menu m2 = new Menu("bearbeiten");
    Menu m3 = new Menu("hilfe");
    MenuItem mineu = new MenuItem("neu");
    MenuItem mioeffnen = new MenuItem("oeffnen");
    MenuItem mispeichern = new MenuItem("speichern");
    MenuItem mispeichernunter = new MenuItem("speichern unter");
    MenuItem miexport = new MenuItem("export");
    MenuItem miimport = new MenuItem("import");
    Menu mdrucken = new Menu("drucken");
    MenuItem midruckrohanalyse = new MenuItem("rohwasseranalyse");
    MenuItem miumanalyse = new MenuItem("umlaufanalyse");
    MenuItem mibetrkosten = new MenuItem("betriebskosten");
    //MenuItem miseitenformat = new MenuItem("Seitenformat");
    MenuItem mibeenden = new MenuItem("beenden");
    MenuItem mirohanalyse2 = new MenuItem("rohwasseranalyse");
    MenuItem migrenzwerte = new MenuItem("grenzwerte");
    MenuItem mikosten = new MenuItem("preise");
    MenuItem mianlageinfo = new MenuItem("anlageninfo");
    MenuItem misprache = new MenuItem("sprache");
    MenuItem mihilfe = new MenuItem("hilfe");
    MenuItem mifrage = new MenuItem("?");

    //Menü hinzufuegen
    //
    add(m1);
    add(m2);
    add(m3);
    mineu.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        neu();
      }
    });
    m1.add(mineu);
    mioeffnen.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        laden();
      }
    });
    m1.add(mioeffnen);
    mispeichern.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        speichernunter();
      }
    });
    m1.add(mispeichern);
    mispeichernunter.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        speichernunter();
      }
    });
    m1.add(mispeichernunter);

    miimport.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        iimport();

      }
    });
    m1.add(miimport);

    miexport.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        export();
      }
    });
    m1.add(miexport);

    m1.addSeparator();
    midruckrohanalyse.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        drucken1();
      }
    });
    mdrucken.add(midruckrohanalyse);
    miumanalyse.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        drucken2();
      }
    });
    mdrucken.add(miumanalyse);
    mibetrkosten.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        drucken3();
      }
    });
    mdrucken.add(mibetrkosten);

    m1.add(mdrucken);
    mianlageinfo.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        drucken4();
      }
    });
    mdrucken.add(mianlageinfo);

    m1.add(mdrucken);
    /*miseitenformat.addActionListener(new java.awt.event.ActionListener()
        {

      public void actionPerformed(ActionEvent e)
      {
        seitenformat();
      }
         });
         m1.add(miseitenformat);
     */
    mdrucken.add(mibetrkosten);
    m1.addSeparator();

    mibeenden.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        System.exit( -1);
      }
    });
    m1.add(mibeenden);
    mikosten.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        f.oeffnekostendialog();
      }
    });

    migrenzwerte.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        f.oeffnegrenzwertedialog();
      }
    });
    mirohanalyse2.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        f.oeffneanalysendialog();

      }
    });

    misprache.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        //sprachDialog sd = new sprachDialog(f, "Bitte Sprache wählen.", true,
          //                               f.liste);
        sprachwahl();

      }
    });
    m2.add(mirohanalyse2);
    m2.add(migrenzwerte);
    m2.add(mikosten);
    m2.addSeparator();
    m2.add(misprache);
    //misprache.setEnabled(false);

    mihilfe.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        hilfe();
      }
    });

    m3.add(mihilfe);
    mifrage.addActionListener(new java.awt.event.ActionListener() {

      public void actionPerformed(ActionEvent e) {
        info();
      }
    });
    m3.add(mifrage);
    //disabeln noch nicht programmierter Menüeinträge
    mineu.setEnabled(false);
    mispeichern.setEnabled(false);
    //mifrage.setEnabled(false);
    mihilfe.setEnabled(true);
  }

  void neu() {
    f.grenzwertinit();
    f.kosteninit();
    f.rohanalyseinit();
    f.textFieldAnalyse.setText("default");
    f.frei();
  }

  //
  void iimport() {
    //passwd pf = new passwd(); //passwortcheck
   passwd lpf = new passwd();
    boolean alt = false;
    f.frei(); //Fesnter Daten löschen
    //FileDialogFenster
    fd.setTitle("Datei laden");
    fd.setDirectory("");
    //fd.setFilenameFilter("*.wkp");
    fd.setFile("*.xls");
    fd.setMode(FileDialog.LOAD);
    fd.setLocation(positionX(fd.getWidth()), 200);
    fd.show();
    String dateiName = fd.getDirectory() + fd.getFile();

    try {
      org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(new File(dateiName), null, true);
      Sheet sheet = workbook.getSheetAt(0);
      DataFormatter df = new DataFormatter();
      f.anaroh.analysenNummer = df.formatCellValue(sheet.getRow(2).getCell(1));
      f.anaroh.kunde         = df.formatCellValue(sheet.getRow(3).getCell(1));
      f.anaroh.projekt       = df.formatCellValue(sheet.getRow(4).getCell(1));
      f.anaroh.bearbeiter    = df.formatCellValue(sheet.getRow(5).getCell(1));

      f.anaroh.tE     = sheet.getRow(6).getCell(1).getNumericCellValue();
      f.anaroh.pHtE   = sheet.getRow(7).getCell(1).getNumericCellValue();
      f.anaroh.lF     = sheet.getRow(8).getCell(1).getNumericCellValue();
      f.anaroh.ca     = sheet.getRow(9).getCell(1).getNumericCellValue();
      f.anaroh.mg     = sheet.getRow(10).getCell(1).getNumericCellValue();
      f.anaroh.ks     = sheet.getRow(11).getCell(1).getNumericCellValue();
      f.anaroh.cl     = sheet.getRow(12).getCell(1).getNumericCellValue();
      f.anaroh.so4    = sheet.getRow(13).getCell(1).getNumericCellValue();
      f.anaroh.pHggW  = sheet.getRow(14).getCell(1).getNumericCellValue();
      f.anaroh.no3    = sheet.getRow(15).getCell(1).getNumericCellValue();
      f.anaroh.sitE   = sheet.getRow(16).getCell(1).getNumericCellValue();
      f.anaroh.h2co3  = sheet.getRow(17).getCell(1).getNumericCellValue();
      f.anaroh.co3    = sheet.getRow(18).getCell(1).getNumericCellValue();
      f.anaroh.hco3   = sheet.getRow(19).getCell(1).getNumericCellValue();

      //GRENZWERTE AUSLESEN
      String anlage = df.formatCellValue(sheet.getRow(2).getCell(4));
      int anlageint = anlage.length();//Länge des STrings als Kriterium für die if Abfrage
      if (anlageint == 8) {
        f.checkboxAnlage1.setSelected(true);
        f.checkboxAnlage2.setSelected(false);
        f.bedingungen.EF     = sheet.getRow(3).getCell(4).getNumericCellValue();
        f.bedingungen.siMax  = sheet.getRow(4).getCell(4).getNumericCellValue();
        f.bedingungen.clMax  = sheet.getRow(5).getCell(4).getNumericCellValue();
        f.bedingungen.so4Max = sheet.getRow(6).getCell(4).getNumericCellValue();
        f.bedingungen.roMax  = sheet.getRow(7).getCell(4).getNumericCellValue();
        f.bedingungen.tKT    = sheet.getRow(8).getCell(4).getNumericCellValue();
        f.bedingungen.tW     = sheet.getRow(9).getCell(4).getNumericCellValue();
        f.bedingungen.caMax  = sheet.getRow(10).getCell(4).getNumericCellValue();
      }
      else {
        f.checkboxAnlage1.setSelected(false);
        f.checkboxAnlage2.setSelected(true);
        f.bedingungen2.siMax  = sheet.getRow(3).getCell(4).getNumericCellValue();
        f.bedingungen2.dhMin  = sheet.getRow(4).getCell(4).getNumericCellValue();
        f.bedingungen2.dhMax  = sheet.getRow(5).getCell(4).getNumericCellValue();
        f.bedingungen2.lF     = sheet.getRow(6).getCell(4).getNumericCellValue();
        f.bedingungen2.alkMin = sheet.getRow(7).getCell(4).getNumericCellValue();
        f.bedingungen2.tLW    = sheet.getRow(8).getCell(4).getNumericCellValue();
        f.bedingungen2.roMax  = sheet.getRow(9).getCell(4).getNumericCellValue();
      }

      //WIRTSCHAFTSDATEN IMPORT//
      f.betriebsMittelKosten.stadtWasser  = sheet.getRow(2).getCell(7).getNumericCellValue();
      f.betriebsMittelKosten.abWasser     = sheet.getRow(3).getCell(7).getNumericCellValue();
      f.betriebsMittelKosten.regenWasser  = sheet.getRow(4).getCell(7).getNumericCellValue();
      f.betriebsMittelKosten.energie      = sheet.getRow(5).getCell(7).getNumericCellValue();

      if (anlageint == 8) {
        f.betriebsMittelKosten.leistung  = sheet.getRow(6).getCell(7).getNumericCellValue();
      }
      else {
        f.betriebsMittelKosten.leistung2 = sheet.getRow(7).getCell(7).getNumericCellValue();
      }

      f.betriebsMittelKosten.auslastung     = sheet.getRow(8).getCell(7).getNumericCellValue();
      f.betriebsMittelKosten.dosierMittel   = sheet.getRow(9).getCell(7).getNumericCellValue();
      f.betriebsMittelKosten.dosierMenge    = sheet.getRow(10).getCell(7).getNumericCellValue();
      f.betriebsMittelKosten.salzTabletten  = sheet.getRow(11).getCell(7).getNumericCellValue();
      f.betriebsMittelKosten.salzSaeure     = sheet.getRow(12).getCell(7).getNumericCellValue();
      f.betriebsMittelKosten.schwefelSaeure = sheet.getRow(13).getCell(7).getNumericCellValue();
      f.betriebsMittelKosten.ro             = sheet.getRow(14).getCell(7).getNumericCellValue();
      f.betriebsMittelKosten.roMenge        = sheet.getRow(15).getCell(7).getNumericCellValue();

      f.betriebsMittelKosten.dosierMittelName = df.formatCellValue(sheet.getRow(16).getCell(7));

      workbook.close();
    }

    catch (java.io.IOException ioe) {
      System.out.println("IO Fehler" + ioe);
      return;
    }

    /*     Cell a1 = sheet.getCell(0,0);
           Cell b2 = sheet.getCell(1,1);
           Cell c2 = sheet.getCell(2,1);
     */


    /*String stringa1 = a1.getContents();
     String stringb2 = b2.getContents();
     String stringc2 = c2.getContents();
     */

    /*//laden
           try {
     FileInputStream file = new FileInputStream(dateiName);
     ObjectInputStream in = new ObjectInputStream(file);
     in.close();
     //in.flush();
           }
           catch (java.io.IOException IOE) {
     System.out.println("IO Fehler" + IOE);
     dialogframe meinDialog = new dialogframe(); //warndialog anzeigen
     warndialog Versionskonflikt = new warndialog(meinDialog, "Achtung", true);
     Versionskonflikt.setSize(300, 150);
     Versionskonflikt.setLocation(f.positionX(300), f.positionY(150));
     Versionskonflikt.meldung(
         "Datei kann nicht geöffnet werden. Versionskonflikt.");
     Versionskonflikt.setVisible(true);
     meinDialog.dispose();
     return;
           }
           /*try{
        in.close();
        FileInputStream fileAlt = new FileInputStream(dateiName);
        ObjectInputStream inAlt = new ObjectInputStream(fileAlt);
        dateiAlt = (projektdateiAlt) inAlt.readObject();
        in.close();
        alt = true; //alte analyse gelesen
        }
      catch(java.io.IOException IOE2)
      {
        System.out.println("IO Fehler"+IOE2);

      }
      catch(ClassNotFoundException cne2)
      {
        System.out.println("class Fehler"+cne2);
      }
           }

     */




    f.textFieldAnalyse.setText(f.anaroh.analysenNummer);

  }

  //
  void export() {
    //File Dialog
    //FileDialogFenster
    fd.setTitle("Datei speichern unter ...");
    fd.setDirectory("");
    //fd.setFilenameFilter("*.wkp");
    fd.setFile("*.xls");
    fd.setMode(FileDialog.SAVE);
    fd.setLocation(positionX(fd.getWidth()), 200);
    fd.show();
    String dateiName = fd.getDirectory() + fd.getFile();
    //Format für die Ausgabe der Werte vorgeben
    NumberFormat nf1 = new NumberFormat("#.00");
    WritableCellFormat nf1cell = new WritableCellFormat(nf1);

    try {

      WritableWorkbook workbook = Workbook.createWorkbook(new File(dateiName));
      WritableSheet sheet1 = workbook.createSheet("Eingabeparameter", 0);
      WritableSheet sheet2 = workbook.createSheet("Threshhold Stabilisierung",
                                                  1);
      WritableSheet sheet3 = workbook.createSheet("Enthärtung", 2);
      WritableSheet sheet4 = workbook.createSheet("Entcarbonisierung", 3);
      WritableSheet sheet5 = workbook.createSheet("Umkehrosmose o. Eh.", 4);
      WritableSheet sheet6 = workbook.createSheet("Umkehrosmose m. Eh.", 5);
      WritableSheet sheet7 = workbook.createSheet("Schwefelsäuredosierung", 6);

      try {
        //rohanalyse
        jxl.write.Label labelA1 = new jxl.write.Label(0, 0, "Rohwasseranalyse");
        jxl.write.Label labelA2 = new jxl.write.Label(0, 2, "Analysennummer:");
        jxl.write.Label labelA3 = new jxl.write.Label(0, 3, "Kunde");
        jxl.write.Label labelA4 = new jxl.write.Label(0, 4, "Projekt");
        jxl.write.Label labelA5 = new jxl.write.Label(0, 5, "Bearbeiter");
        jxl.write.Label labelA6 = new jxl.write.Label(0, 6, "TE°C");
        jxl.write.Label labelA7 = new jxl.write.Label(0, 7, "pH TE");
        jxl.write.Label labelA8 = new jxl.write.Label(0, 8, "LF K25");
        jxl.write.Label labelA9 = new jxl.write.Label(0, 9, "Calcium mg/l");
        jxl.write.Label labelA10 = new jxl.write.Label(0, 10, "Magnesium mg/l");
        jxl.write.Label labelA11 = new jxl.write.Label(0, 11, "KS 4,3 mmol/l");
        jxl.write.Label labelA12 = new jxl.write.Label(0, 12, "Chlorid mg/l");
        jxl.write.Label labelA13 = new jxl.write.Label(0, 13, "Sulfat mg/l");
        jxl.write.Label labelA14 = new jxl.write.Label(0, 14, "GGW pH TE");
        jxl.write.Label labelA15 = new jxl.write.Label(0, 15, "Nitrat mg/l");
        jxl.write.Label labelA16 = new jxl.write.Label(0, 16, "SI TE");
        jxl.write.Label labelA17 = new jxl.write.Label(0, 17, "Co2 mg/l");
        jxl.write.Label labelA18 = new jxl.write.Label(0, 18, "Co3 mg/l");
        jxl.write.Label labelA19 = new jxl.write.Label(0, 19, "HCo3 mg/l");
        //
        sheet1.addCell(labelA1);
        sheet1.addCell(labelA2);
        sheet1.addCell(labelA3);
        sheet1.addCell(labelA4);
        sheet1.addCell(labelA5);
        sheet1.addCell(labelA6);
        sheet1.addCell(labelA7);
        sheet1.addCell(labelA8);
        sheet1.addCell(labelA9);
        sheet1.addCell(labelA10);
        sheet1.addCell(labelA11);
        sheet1.addCell(labelA12);
        sheet1.addCell(labelA13);
        sheet1.addCell(labelA14);
        sheet1.addCell(labelA15);
        sheet1.addCell(labelA16);
        sheet1.addCell(labelA17);
        sheet1.addCell(labelA18);
        sheet1.addCell(labelA19);

        //Grenzwerte
        jxl.write.Label labelB1 = new jxl.write.Label(3, 0, "Grenzwerte");
        jxl.write.Label labelB2 = new jxl.write.Label(3, 2, "Anlage");
        jxl.write.Label labelB3 = new jxl.write.Label(3, 3, "Eindickungsfaktor");
        jxl.write.Label labelB4 = new jxl.write.Label(3, 4,
            "max. Sättigungsindex ");
        jxl.write.Label labelB5 = new jxl.write.Label(3, 5, "max. Chlorid");
        jxl.write.Label labelB6 = new jxl.write.Label(3, 6, "max. Sulfat");
        jxl.write.Label labelB7 = new jxl.write.Label(3, 7, "max. SI RO.");
        jxl.write.Label labelB8 = new jxl.write.Label(3, 8, "T KT");
        jxl.write.Label labelB9 = new jxl.write.Label(3, 9, "T Wand");
        jxl.write.Label labelB10 = new jxl.write.Label(3, 10,
            "Calciumgehalt Speisewasser");

        if (f.baufbereitung == false) { //Luftwäscher
          labelB2.setString("Anlage");
          labelB3.setString("max. Sättigungsindex");
          labelB4.setString("min. Härte");
          labelB5.setString("max. Härte");
          labelB6.setString("max. LF");
          labelB7.setString("mind. Alkalität");
          labelB8.setString("T. Wäscher");
          labelB9.setString("max. SI RO.");
          labelB10.setString("");

        }

        sheet1.addCell(labelB1);
        sheet1.addCell(labelB2);
        sheet1.addCell(labelB3);
        sheet1.addCell(labelB4);
        sheet1.addCell(labelB5);
        sheet1.addCell(labelB6);
        sheet1.addCell(labelB7);
        sheet1.addCell(labelB8);
        sheet1.addCell(labelB9);
        sheet1.addCell(labelB10);

        //Kosten
        jxl.write.Label labelC1 = new jxl.write.Label(6, 0,
            "Wirtschaftsdaten");
        jxl.write.Label labelC2 = new jxl.write.Label(6, 2,
            "Stadtwasser EUR/m³");
        jxl.write.Label labelC3 = new jxl.write.Label(6, 3,
            "Schmutzwasser EUR/m³");
        jxl.write.Label labelC4 = new jxl.write.Label(6, 4,
            "Regenwassersiel EUR/m³");
        jxl.write.Label labelC5 = new jxl.write.Label(6, 5, "Energie EUR/kWh");
        jxl.write.Label labelC6 = new jxl.write.Label(6, 6, "Kühlleistung kW");
        jxl.write.Label labelC7
            = new jxl.write.Label(6, 7,
                                  "Luftwäscherleistung kW");
        jxl.write.Label labelC8 = new jxl.write.Label(6, 8, "Auslastung %");
        jxl.write.Label labelC9 = new jxl.write.Label(6, 9,
            "Dosiermittel EUR/kg");
        jxl.write.Label labelC10 = new jxl.write.Label(6, 10, "Dosierhöhe g/m³");
        jxl.write.Label labelC11 = new jxl.write.Label(6, 11,
            "Salztabletten EUR/kg");
        jxl.write.Label labelC12 = new jxl.write.Label(6, 12,
            "Salzsäure EUR/kg");
        jxl.write.Label labelC13 = new jxl.write.Label(6, 13,
            "Schwefelsäure EUR/kg");
        jxl.write.Label labelC14 = new jxl.write.Label(6, 14,
            "RO Dosiermittel EUR/kg");
        jxl.write.Label labelC15 = new jxl.write.Label(6, 15,
            "RO Dosierhöhe g/m³");
        jxl.write.Label labelC16 = new jxl.write.Label(6, 16, "Dosiermittel");

        //
        sheet1.addCell(labelC1);
        sheet1.addCell(labelC2);
        sheet1.addCell(labelC3);
        sheet1.addCell(labelC4);
        sheet1.addCell(labelC5);
        sheet1.addCell(labelC6);
        sheet1.addCell(labelC7);
        sheet1.addCell(labelC8);
        sheet1.addCell(labelC9);
        sheet1.addCell(labelC10);
        sheet1.addCell(labelC11);
        sheet1.addCell(labelC12);
        sheet1.addCell(labelC13);
        sheet1.addCell(labelC14);
        sheet1.addCell(labelC15);
        sheet1.addCell(labelC16);

        // EINGABEWERTE EINFÜGEN

        jxl.write.Label labelWA1 = new jxl.write.Label(1, 2,
            f.anaroh.analysenNummer);
        jxl.write.Label labelWA2 = new jxl.write.Label(1, 3, f.anaroh.kunde);
        jxl.write.Label labelWA3 = new jxl.write.Label(1, 4, f.anaroh.projekt);
        jxl.write.Label labelWA4 = new jxl.write.Label(1, 5,
            f.anaroh.bearbeiter);
        jxl.write.Number numberWA5 = new jxl.write.Number(1, 6, f.anaroh.tE,
            nf1cell);
        jxl.write.Number numberWA6 = new jxl.write.Number(1, 7, f.anaroh.pHtE,
            nf1cell);
        jxl.write.Number numberWA7 = new jxl.write.Number(1, 8, f.anaroh.lF,
            nf1cell);
        jxl.write.Number numberWA8 = new jxl.write.Number(1, 9, f.anaroh.ca,
            nf1cell);
        jxl.write.Number numberWA9 = new jxl.write.Number(1, 10, f.anaroh.mg,
            nf1cell);
        jxl.write.Number numberWA10 = new jxl.write.Number(1, 11, f.anaroh.ks,
            nf1cell);
        jxl.write.Number numberWA11 = new jxl.write.Number(1, 12, f.anaroh.cl,
            nf1cell);
        jxl.write.Number numberWA12 = new jxl.write.Number(1, 13, f.anaroh.so4,
            nf1cell);
        jxl.write.Number numberWA13 = new jxl.write.Number(1, 14,
            f.anaroh.pHggW, nf1cell);
        jxl.write.Number numberWA14 = new jxl.write.Number(1, 15, f.anaroh.no3,
            nf1cell);
        jxl.write.Number numberWA15 = new jxl.write.Number(1, 16, f.anaroh.sitE,
            nf1cell);
        jxl.write.Number numberWA16 = new jxl.write.Number(1, 17,
            f.anaroh.h2co3,
            nf1cell);
        jxl.write.Number numberWA17 = new jxl.write.Number(1, 18, f.anaroh.co3,
            nf1cell);
        jxl.write.Number numberWA18 = new jxl.write.Number(1, 19, f.anaroh.hco3,
            nf1cell);

        sheet1.addCell(labelWA1);
        sheet1.addCell(labelWA2);
        sheet1.addCell(labelWA3);
        sheet1.addCell(labelWA4);
        sheet1.addCell(numberWA5);
        sheet1.addCell(numberWA6);
        sheet1.addCell(numberWA7);
        sheet1.addCell(numberWA8);
        sheet1.addCell(numberWA9);
        sheet1.addCell(numberWA10);
        sheet1.addCell(numberWA11);
        sheet1.addCell(numberWA12);
        sheet1.addCell(numberWA13);
        sheet1.addCell(numberWA14);
        sheet1.addCell(numberWA15);
        sheet1.addCell(numberWA16);
        sheet1.addCell(numberWA17);
        sheet1.addCell(numberWA18);
        //Grenzwerte einfügen
        jxl.write.Label labelGW1 = new jxl.write.Label(4, 2, "Kühlturm");
        jxl.write.Number numberGW2 = new jxl.write.Number(4, 3,
            f.bedingungen.EF, nf1cell);
        jxl.write.Number numberGW3 = new jxl.write.Number(4, 4,
            f.bedingungen.siMax, nf1cell);
        jxl.write.Number numberGW4 = new jxl.write.Number(4, 5,
            f.bedingungen.clMax, nf1cell);
        jxl.write.Number numberGW5 = new jxl.write.Number(4, 6,
            f.bedingungen.so4Max, nf1cell);
        jxl.write.Number numberGW6 = new jxl.write.Number(4, 7,
            f.bedingungen.roMax, nf1cell);
        jxl.write.Number numberGW7 = new jxl.write.Number(4, 8,
            f.bedingungen.tKT, nf1cell);
        jxl.write.Number numberGW8 = new jxl.write.Number(4, 9,
            f.bedingungen.tW, nf1cell);
        jxl.write.Number numberGW9 = new jxl.write.Number(4, 10,
            f.bedingungen.caMax, nf1cell);
        if (f.baufbereitung == false) { //falls Luftwäscher
          labelGW1.setString("Luftwäscher");
          numberGW2.setValue(f.bedingungen2.siMax);
          numberGW3.setValue(f.bedingungen2.dhMax);
          numberGW4.setValue(f.bedingungen2.dhMin);
          numberGW5.setValue(f.bedingungen2.lF);
          numberGW6.setValue(f.bedingungen2.alkMin);
          numberGW7.setValue(f.bedingungen2.tLW);
          numberGW8.setValue(f.bedingungen2.roMax);
          //numberGW8.setCellFormat();
        }
        //Grenzwerte Einfügen
        sheet1.addCell(labelGW1);
        sheet1.addCell(numberGW2);
        sheet1.addCell(numberGW3);
        sheet1.addCell(numberGW4);
        sheet1.addCell(numberGW5);
        sheet1.addCell(numberGW6);
        sheet1.addCell(numberGW7);
        sheet1.addCell(numberGW8);
        sheet1.addCell(numberGW9);

        //Kosten
        jxl.write.Number numberWK1 = new jxl.write.Number(7, 2,
            f.betriebsMittelKosten.stadtWasser, nf1cell);
        jxl.write.Number numberWK2 = new jxl.write.Number(7, 3,
            f.betriebsMittelKosten.abWasser, nf1cell);
        jxl.write.Number numberWK3 = new jxl.write.Number(7, 4,
            f.betriebsMittelKosten.regenWasser, nf1cell);
        jxl.write.Number numberWK4 = new jxl.write.Number(7, 5,
            f.betriebsMittelKosten.energie, nf1cell);
        jxl.write.Number numberWK5 = new jxl.write.Number(7, 6,
            f.betriebsMittelKosten.leistung, nf1cell);
        jxl.write.Number numberWK6 = new jxl.write.Number(7, 7,
            f.betriebsMittelKosten.leistung2, nf1cell);
        jxl.write.Number numberWK7 = new jxl.write.Number(7, 8,
            f.betriebsMittelKosten.auslastung, nf1cell);
        jxl.write.Number numberWK8 = new jxl.write.Number(7, 9,
            f.betriebsMittelKosten.dosierMittel, nf1cell);
        jxl.write.Number numberWK9 = new jxl.write.Number(7, 10,
            f.betriebsMittelKosten.dosierMenge, nf1cell);
        jxl.write.Number numberWK10 = new jxl.write.Number(7, 11,
            f.betriebsMittelKosten.salzTabletten, nf1cell);
        jxl.write.Number numberWK11 = new jxl.write.Number(7, 12,
            f.betriebsMittelKosten.salzSaeure, nf1cell);
        jxl.write.Number numberWK12 = new jxl.write.Number(7, 13,
            f.betriebsMittelKosten.schwefelSaeure, nf1cell);
        jxl.write.Number numberWK13 = new jxl.write.Number(7, 14,
            f.betriebsMittelKosten.ro, nf1cell);
        jxl.write.Number numberWK14 = new jxl.write.Number(7, 15,
            f.betriebsMittelKosten.roMenge, nf1cell);
        jxl.write.Label labelWK15 = new jxl.write.Label(7, 16,
            f.betriebsMittelKosten.dosierMittelName, nf1cell);

        sheet1.addCell(numberWK1);
        sheet1.addCell(numberWK2);
        sheet1.addCell(numberWK3);
        sheet1.addCell(numberWK4);
        sheet1.addCell(numberWK5);
        sheet1.addCell(numberWK6);
        sheet1.addCell(numberWK7);
        sheet1.addCell(numberWK8);
        sheet1.addCell(numberWK9);
        sheet1.addCell(numberWK10);
        sheet1.addCell(numberWK11);
        sheet1.addCell(numberWK12);
        sheet1.addCell(numberWK13);
        sheet1.addCell(numberWK14);
        sheet1.addCell(labelWK15);

//

        //Berechnung und Einfügen in Excel Spreadsheet für jede Aufbereitungsart



        int m, k;
        k = 6;
//         if (f.baufbereitung == false) { k = 5} // wenn Luftwäscher,
        //dann nur 5 Aufbereitungsarten. Scwefelsäuredosierung fällt weg
        // for (m = 1; m <= k ; m++)
        // {



//Umlaufwasseranalyse THRESH
        jxl.write.Label labelD1 = new jxl.write.Label(3, 0, "Umlaufwasser");
        //jxl.write.Label labelD2 = new jxl.write.Label(3, 1, "Aufbereitungsart");
        jxl.write.Label labelD2 = new jxl.write.Label(3, 2, "Verschnitt RW %");
        jxl.write.Label labelD3 = new jxl.write.Label(3, 3, "Eindickung E");
        jxl.write.Label labelD4 = new jxl.write.Label(3, 4, "TKT°C");
        jxl.write.Label labelD5 = new jxl.write.Label(3, 5, "TW°C");
        jxl.write.Label labelD6 = new jxl.write.Label(3, 6, "LF 25 ");
        jxl.write.Label labelD7 = new jxl.write.Label(3, 7, "Calcium mg/l");
        jxl.write.Label labelD8 = new jxl.write.Label(3, 8, "Magnesium mg/l");
        jxl.write.Label labelD9 = new jxl.write.Label(3, 9, "Na. ber. mg/l");
        jxl.write.Label labelD10 = new jxl.write.Label(3, 10, "KS 4,3 mmol/l");
        jxl.write.Label labelD11 = new jxl.write.Label(3, 11, "Chlorid mg/l");
        jxl.write.Label labelD12 = new jxl.write.Label(3, 12, "Sulfat mg/l");
        jxl.write.Label labelD13 = new jxl.write.Label(3, 13, "Nitrat mg/l");
        jxl.write.Label labelD14 = new jxl.write.Label(3, 14, "pH KTNV");
        jxl.write.Label labelD15 = new jxl.write.Label(3, 15, "GGW pH TKT");
        jxl.write.Label labelD16 = new jxl.write.Label(3, 16, "SI TKT");
        jxl.write.Label labelD17 = new jxl.write.Label(3, 17, "GGW pH W");
        jxl.write.Label labelD18 = new jxl.write.Label(3, 18, "SI W");
        jxl.write.Label labelD19 = new jxl.write.Label(3, 19,
            "Salzgehalt mmol/l");
        jxl.write.Label labelD20 = new jxl.write.Label(3, 20, "Ionenstärke I");
        jxl.write.Label labelD21 = new jxl.write.Label(3, 21, "H2Co3 mg/l");
        jxl.write.Label labelD22 = new jxl.write.Label(3, 22, "HCo3 mg/l");
        jxl.write.Label labelD23 = new jxl.write.Label(3, 23, "GCo3 mg/l");
        if (f.baufbereitung == false) {
          labelD4.setString("T LW)");
          labelD5.setString("");
          labelD14.setString("pH LWNV");
          labelD15.setString("GGWpH TLW");
          labelD17.setString("");
          labelD18.setString("");
        }
        sheet2.addCell(labelD1);
        sheet2.addCell(labelD2);
        sheet2.addCell(labelD3);
        sheet2.addCell(labelD4);
        sheet2.addCell(labelD5);
        sheet2.addCell(labelD6);
        sheet2.addCell(labelD7);
        sheet2.addCell(labelD8);
        sheet2.addCell(labelD9);
        sheet2.addCell(labelD10);
        sheet2.addCell(labelD11);
        sheet2.addCell(labelD12);
        sheet2.addCell(labelD13);
        sheet2.addCell(labelD14);
        sheet2.addCell(labelD15);
        sheet2.addCell(labelD16);
        sheet2.addCell(labelD17);
        sheet2.addCell(labelD18);
        sheet2.addCell(labelD19);
        sheet2.addCell(labelD20);
        sheet2.addCell(labelD21);
        sheet2.addCell(labelD22);
        sheet2.addCell(labelD23);

        //Umlaufwasseranalyse ENTHÄRTUNG
        jxl.write.Label labelEHU1 = new jxl.write.Label(3, 0, "Umlaufwasser");
        //jxl.write.Label labelEHU2 = new jxl.write.Label(3, 1, "Aufbereitungsart");
        jxl.write.Label labelEHU2 = new jxl.write.Label(3, 2, "Verschnitt RW %");
        jxl.write.Label labelEHU3 = new jxl.write.Label(3, 3, "Eindickung E");
        jxl.write.Label labelEHU4 = new jxl.write.Label(3, 4, "TKT°C");
        jxl.write.Label labelEHU5 = new jxl.write.Label(3, 5, "TW°C");
        jxl.write.Label labelEHU6 = new jxl.write.Label(3, 6, "LF 25 ");
        jxl.write.Label labelEHU7 = new jxl.write.Label(3, 7, "Calcium mg/l");
        jxl.write.Label labelEHU8 = new jxl.write.Label(3, 8, "Magnesium mg/l");
        jxl.write.Label labelEHU9 = new jxl.write.Label(3, 9, "Na. ber. mg/l");
        jxl.write.Label labelEHU10 = new jxl.write.Label(3, 10, "KS 4,3 mmol/l");
        jxl.write.Label labelEHU11 = new jxl.write.Label(3, 11, "Chlorid mg/l");
        jxl.write.Label labelEHU12 = new jxl.write.Label(3, 12, "Sulfat mg/l");
        jxl.write.Label labelEHU13 = new jxl.write.Label(3, 13, "Nitrat mg/l");
        jxl.write.Label labelEHU14 = new jxl.write.Label(3, 14, "pH KTNV");
        jxl.write.Label labelEHU15 = new jxl.write.Label(3, 15, "GGW pH TKT");
        jxl.write.Label labelEHU16 = new jxl.write.Label(3, 16, "SI TKT");
        jxl.write.Label labelEHU17 = new jxl.write.Label(3, 17, "GGW pH W");
        jxl.write.Label labelEHU18 = new jxl.write.Label(3, 18, "SI W");
        jxl.write.Label labelEHU19 = new jxl.write.Label(3, 19,
            "Salzgehalt mmol/l");
        jxl.write.Label labelEHU20 = new jxl.write.Label(3, 20, "Ionenstärke I");
        jxl.write.Label labelEHU21 = new jxl.write.Label(3, 21, "H2Co3 mg/l");
        jxl.write.Label labelEHU22 = new jxl.write.Label(3, 22, "HCo3 mg/l");
        jxl.write.Label labelEHU23 = new jxl.write.Label(3, 23, "GCo3 mg/l");
        if (f.baufbereitung == false) {
          labelD4.setString("T LW)");
          labelD5.setString("");
          labelD14.setString("pH LWNV");
          labelD15.setString("GGWpH TLW");
          labelD17.setString("");
          labelD18.setString("");
        }
        //
        sheet3.addCell(labelEHU1);
        sheet3.addCell(labelEHU2);
        sheet3.addCell(labelEHU3);
        sheet3.addCell(labelEHU4);
        sheet3.addCell(labelEHU5);
        sheet3.addCell(labelEHU6);
        sheet3.addCell(labelEHU7);
        sheet3.addCell(labelEHU8);
        sheet3.addCell(labelEHU9);
        sheet3.addCell(labelEHU10);
        sheet3.addCell(labelEHU11);
        sheet3.addCell(labelEHU12);
        sheet3.addCell(labelEHU13);
        sheet3.addCell(labelEHU14);
        sheet3.addCell(labelEHU15);
        sheet3.addCell(labelEHU16);
        sheet3.addCell(labelEHU17);
        sheet3.addCell(labelEHU18);
        sheet3.addCell(labelEHU19);
        sheet3.addCell(labelEHU20);
        sheet3.addCell(labelEHU21);
        sheet3.addCell(labelEHU22);
        sheet3.addCell(labelEHU23);
        //Umlaufwasseranalyse ENTHÄRTUNG
        jxl.write.Label labelECU1 = new jxl.write.Label(3, 0, "Umlaufwasser");
        //jxl.write.Label labelECU2 = new jxl.write.Label(3, 1, "Aufbereitungsart");
        jxl.write.Label labelECU2 = new jxl.write.Label(3, 2, "Verschnitt RW %");
        jxl.write.Label labelECU3 = new jxl.write.Label(3, 3, "Eindickung E");
        jxl.write.Label labelECU4 = new jxl.write.Label(3, 4, "TKT°C");
        jxl.write.Label labelECU5 = new jxl.write.Label(3, 5, "TW°C");
        jxl.write.Label labelECU6 = new jxl.write.Label(3, 6, "LF 25 ");
        jxl.write.Label labelECU7 = new jxl.write.Label(3, 7, "Calcium mg/l");
        jxl.write.Label labelECU8 = new jxl.write.Label(3, 8, "Magnesium mg/l");
        jxl.write.Label labelECU9 = new jxl.write.Label(3, 9, "Na. ber. mg/l");
        jxl.write.Label labelECU10 = new jxl.write.Label(3, 10, "KS 4,3 mmol/l");
        jxl.write.Label labelECU11 = new jxl.write.Label(3, 11, "Chlorid mg/l");
        jxl.write.Label labelECU12 = new jxl.write.Label(3, 12, "Sulfat mg/l");
        jxl.write.Label labelECU13 = new jxl.write.Label(3, 13, "Nitrat mg/l");
        jxl.write.Label labelECU14 = new jxl.write.Label(3, 14, "pH KTNV");
        jxl.write.Label labelECU15 = new jxl.write.Label(3, 15, "GGW pH TKT");
        jxl.write.Label labelECU16 = new jxl.write.Label(3, 16, "SI TKT");
        jxl.write.Label labelECU17 = new jxl.write.Label(3, 17, "GGW pH W");
        jxl.write.Label labelECU18 = new jxl.write.Label(3, 18, "SI W");
        jxl.write.Label labelECU19 = new jxl.write.Label(3, 19,
            "Salzgehalt mmol/l");
        jxl.write.Label labelECU20 = new jxl.write.Label(3, 20, "Ionenstärke I");
        jxl.write.Label labelECU21 = new jxl.write.Label(3, 21, "H2Co3 mg/l");
        jxl.write.Label labelECU22 = new jxl.write.Label(3, 22, "HCo3 mg/l");
        jxl.write.Label labelECU23 = new jxl.write.Label(3, 23, "GCo3 mg/l");
        if (f.baufbereitung == false) {
          labelD4.setString("T LW)");
          labelD5.setString("");
          labelD14.setString("pH LWNV");
          labelD15.setString("GGWpH TLW");
          labelD17.setString("");
          labelD18.setString("");
        }
        //
        //
        sheet4.addCell(labelECU1);
        sheet4.addCell(labelECU2);
        sheet4.addCell(labelECU3);
        sheet4.addCell(labelECU4);
        sheet4.addCell(labelECU5);
        sheet4.addCell(labelECU6);
        sheet4.addCell(labelECU7);
        sheet4.addCell(labelECU8);
        sheet4.addCell(labelECU9);
        sheet4.addCell(labelECU10);
        sheet4.addCell(labelECU11);
        sheet4.addCell(labelECU12);
        sheet4.addCell(labelECU13);
        sheet4.addCell(labelECU14);
        sheet4.addCell(labelECU15);
        sheet4.addCell(labelECU16);
        sheet4.addCell(labelECU17);
        sheet4.addCell(labelECU18);
        sheet4.addCell(labelECU19);
        sheet4.addCell(labelECU20);
        sheet4.addCell(labelECU21);
        sheet4.addCell(labelECU22);
        sheet4.addCell(labelECU23);

        //
        //
        //Umlaufwasseranalyse ENTHÄRTUNG
        jxl.write.Label labelUOU1 = new jxl.write.Label(3, 0, "Umlaufwasser");
        //jxl.write.Label labelUOU2 = new jxl.write.Label(3, 1, "Aufbereitungsart");
        jxl.write.Label labelUOU2 = new jxl.write.Label(3, 2, "Verschnitt RW %");
        jxl.write.Label labelUOU3 = new jxl.write.Label(3, 3, "Eindickung E");
        jxl.write.Label labelUOU4 = new jxl.write.Label(3, 4, "TKT°C");
        jxl.write.Label labelUOU5 = new jxl.write.Label(3, 5, "TW°C");
        jxl.write.Label labelUOU6 = new jxl.write.Label(3, 6, "LF 25 ");
        jxl.write.Label labelUOU7 = new jxl.write.Label(3, 7, "Calcium mg/l");
        jxl.write.Label labelUOU8 = new jxl.write.Label(3, 8, "Magnesium mg/l");
        jxl.write.Label labelUOU9 = new jxl.write.Label(3, 9, "Na. ber. mg/l");
        jxl.write.Label labelUOU10 = new jxl.write.Label(3, 10, "KS 4,3 mmol/l");
        jxl.write.Label labelUOU11 = new jxl.write.Label(3, 11, "Chlorid mg/l");
        jxl.write.Label labelUOU12 = new jxl.write.Label(3, 12, "Sulfat mg/l");
        jxl.write.Label labelUOU13 = new jxl.write.Label(3, 13, "Nitrat mg/l");
        jxl.write.Label labelUOU14 = new jxl.write.Label(3, 14, "pH KTNV");
        jxl.write.Label labelUOU15 = new jxl.write.Label(3, 15, "GGW pH TKT");
        jxl.write.Label labelUOU16 = new jxl.write.Label(3, 16, "SI TKT");
        jxl.write.Label labelUOU17 = new jxl.write.Label(3, 17, "GGW pH W");
        jxl.write.Label labelUOU18 = new jxl.write.Label(3, 18, "SI W");
        jxl.write.Label labelUOU19 = new jxl.write.Label(3, 19,
            "Salzgehalt mmol/l");
        jxl.write.Label labelUOU20 = new jxl.write.Label(3, 20, "Ionenstärke I");
        jxl.write.Label labelUOU21 = new jxl.write.Label(3, 21, "H2Co3 mg/l");
        jxl.write.Label labelUOU22 = new jxl.write.Label(3, 22, "HCo3 mg/l");
        jxl.write.Label labelUOU23 = new jxl.write.Label(3, 23, "GCo3 mg/l");
        if (f.baufbereitung == false) {
          labelD4.setString("T LW)");
          labelD5.setString("");
          labelD14.setString("pH LWNV");
          labelD15.setString("GGWpH TLW");
          labelD17.setString("");
          labelD18.setString("");
        }
        //
        //
        sheet5.addCell(labelUOU1);
        sheet5.addCell(labelUOU2);
        sheet5.addCell(labelUOU3);
        sheet5.addCell(labelUOU4);
        sheet5.addCell(labelUOU5);
        sheet5.addCell(labelUOU6);
        sheet5.addCell(labelUOU7);
        sheet5.addCell(labelUOU8);
        sheet5.addCell(labelUOU9);
        sheet5.addCell(labelUOU10);
        sheet5.addCell(labelUOU11);
        sheet5.addCell(labelUOU12);
        sheet5.addCell(labelUOU13);
        sheet5.addCell(labelUOU14);
        sheet5.addCell(labelUOU15);
        sheet5.addCell(labelUOU16);
        sheet5.addCell(labelUOU17);
        sheet5.addCell(labelUOU18);
        sheet5.addCell(labelUOU19);
        sheet5.addCell(labelUOU20);
        sheet5.addCell(labelUOU21);
        sheet5.addCell(labelUOU22);
        sheet5.addCell(labelUOU23);

        //
        //Umlaufwasseranalyse ENTHÄRTUNG
        jxl.write.Label labelUMU1 = new jxl.write.Label(3, 0, "Umlaufwasser");
        //jxl.write.Label labelUMU2 = new jxl.write.Label(3, 1, "Aufbereitungsart");
        jxl.write.Label labelUMU2 = new jxl.write.Label(3, 2, "Verschnitt RW %");
        jxl.write.Label labelUMU3 = new jxl.write.Label(3, 3, "Eindickung E");
        jxl.write.Label labelUMU4 = new jxl.write.Label(3, 4, "TKT°C");
        jxl.write.Label labelUMU5 = new jxl.write.Label(3, 5, "TW°C");
        jxl.write.Label labelUMU6 = new jxl.write.Label(3, 6, "LF 25 ");
        jxl.write.Label labelUMU7 = new jxl.write.Label(3, 7, "Calcium mg/l");
        jxl.write.Label labelUMU8 = new jxl.write.Label(3, 8, "Magnesium mg/l");
        jxl.write.Label labelUMU9 = new jxl.write.Label(3, 9, "Na. ber. mg/l");
        jxl.write.Label labelUMU10 = new jxl.write.Label(3, 10, "KS 4,3 mmol/l");
        jxl.write.Label labelUMU11 = new jxl.write.Label(3, 11, "Chlorid mg/l");
        jxl.write.Label labelUMU12 = new jxl.write.Label(3, 12, "Sulfat mg/l");
        jxl.write.Label labelUMU13 = new jxl.write.Label(3, 13, "Nitrat mg/l");
        jxl.write.Label labelUMU14 = new jxl.write.Label(3, 14, "pH KTNV");
        jxl.write.Label labelUMU15 = new jxl.write.Label(3, 15, "GGW pH TKT");
        jxl.write.Label labelUMU16 = new jxl.write.Label(3, 16, "SI TKT");
        jxl.write.Label labelUMU17 = new jxl.write.Label(3, 17, "GGW pH W");
        jxl.write.Label labelUMU18 = new jxl.write.Label(3, 18, "SI W");
        jxl.write.Label labelUMU19 = new jxl.write.Label(3, 19,
            "Salzgehalt mmol/l");
        jxl.write.Label labelUMU20 = new jxl.write.Label(3, 20, "Ionenstärke I");
        jxl.write.Label labelUMU21 = new jxl.write.Label(3, 21, "H2Co3 mg/l");
        jxl.write.Label labelUMU22 = new jxl.write.Label(3, 22, "HCo3 mg/l");
        jxl.write.Label labelUMU23 = new jxl.write.Label(3, 23, "GCo3 mg/l");
        if (f.baufbereitung == false) {
          labelD4.setString("T LW)");
          labelD5.setString("");
          labelD14.setString("pH LWNV");
          labelD15.setString("GGWpH TLW");
          labelD17.setString("");
          labelD18.setString("");
        }
        //
        //
        sheet6.addCell(labelUMU1);
        sheet6.addCell(labelUMU2);
        sheet6.addCell(labelUMU3);
        sheet6.addCell(labelUMU4);
        sheet6.addCell(labelUMU5);
        sheet6.addCell(labelUMU6);
        sheet6.addCell(labelUMU7);
        sheet6.addCell(labelUMU8);
        sheet6.addCell(labelUMU9);
        sheet6.addCell(labelUMU10);
        sheet6.addCell(labelUMU11);
        sheet6.addCell(labelUMU12);
        sheet6.addCell(labelUMU13);
        sheet6.addCell(labelUMU14);
        sheet6.addCell(labelUMU15);
        sheet6.addCell(labelUMU16);
        sheet6.addCell(labelUMU17);
        sheet6.addCell(labelUMU18);
        sheet6.addCell(labelUMU19);
        sheet6.addCell(labelUMU20);
        sheet6.addCell(labelUMU21);
        sheet6.addCell(labelUMU22);
        sheet6.addCell(labelUMU23);
        //
        //Umlaufwasseranalyse ENTHÄRTUNG
        jxl.write.Label labelSDU1 = new jxl.write.Label(3, 0, "Umlaufwasser");
        //jxl.write.Label labelSDU2 = new jxl.write.Label(3, 1, "Aufbereitungsart");
        jxl.write.Label labelSDU2 = new jxl.write.Label(3, 2, "Verschnitt RW %");
        jxl.write.Label labelSDU3 = new jxl.write.Label(3, 3, "Eindickung E");
        jxl.write.Label labelSDU4 = new jxl.write.Label(3, 4, "TKT°C");
        jxl.write.Label labelSDU5 = new jxl.write.Label(3, 5, "TW°C");
        jxl.write.Label labelSDU6 = new jxl.write.Label(3, 6, "LF 25 ");
        jxl.write.Label labelSDU7 = new jxl.write.Label(3, 7, "Calcium mg/l");
        jxl.write.Label labelSDU8 = new jxl.write.Label(3, 8, "Magnesium mg/l");
        jxl.write.Label labelSDU9 = new jxl.write.Label(3, 9, "Na. ber. mg/l");
        jxl.write.Label labelSDU10 = new jxl.write.Label(3, 10, "KS 4,3 mmol/l");
        jxl.write.Label labelSDU11 = new jxl.write.Label(3, 11, "Chlorid mg/l");
        jxl.write.Label labelSDU12 = new jxl.write.Label(3, 12, "Sulfat mg/l");
        jxl.write.Label labelSDU13 = new jxl.write.Label(3, 13, "Nitrat mg/l");
        jxl.write.Label labelSDU14 = new jxl.write.Label(3, 14, "pH KTNV");
        jxl.write.Label labelSDU15 = new jxl.write.Label(3, 15, "GGW pH TKT");
        jxl.write.Label labelSDU16 = new jxl.write.Label(3, 16, "SI TKT");
        jxl.write.Label labelSDU17 = new jxl.write.Label(3, 17, "GGW pH W");
        jxl.write.Label labelSDU18 = new jxl.write.Label(3, 18, "SI W");
        jxl.write.Label labelSDU19 = new jxl.write.Label(3, 19,
            "Salzgehalt mmol/l");
        jxl.write.Label labelSDU20 = new jxl.write.Label(3, 20, "Ionenstärke I");
        jxl.write.Label labelSDU21 = new jxl.write.Label(3, 21, "H2Co3 mg/l");
        jxl.write.Label labelSDU22 = new jxl.write.Label(3, 22, "HCo3 mg/l");
        jxl.write.Label labelSDU23 = new jxl.write.Label(3, 23, "GCo3 mg/l");
        if (f.baufbereitung == false) {
          labelD4.setString("T LW)");
          labelD5.setString("");
          labelD14.setString("pH LWNV");
          labelD15.setString("GGWpH TLW");
          labelD17.setString("");
          labelD18.setString("");
        }
//
//
        sheet7.addCell(labelSDU1);
        sheet7.addCell(labelSDU2);
        sheet7.addCell(labelSDU3);
        sheet7.addCell(labelSDU4);
        sheet7.addCell(labelSDU5);
        sheet7.addCell(labelSDU6);
        sheet7.addCell(labelSDU7);
        sheet7.addCell(labelSDU8);
        sheet7.addCell(labelSDU9);
        sheet7.addCell(labelSDU10);
        sheet7.addCell(labelSDU11);
        sheet7.addCell(labelSDU12);
        sheet7.addCell(labelSDU13);
        sheet7.addCell(labelSDU14);
        sheet7.addCell(labelSDU15);
        sheet7.addCell(labelSDU16);
        sheet7.addCell(labelSDU17);
        sheet7.addCell(labelSDU18);
        sheet7.addCell(labelSDU19);
        sheet7.addCell(labelSDU20);
        sheet7.addCell(labelSDU21);
        sheet7.addCell(labelSDU22);
        sheet7.addCell(labelSDU23);

//VERBRAUCH  THRESH
        jxl.write.Label labelTHM1 = new jxl.write.Label(6, 0,
            "Verbrauchsmengen");
        jxl.write.Label labelTHM2 = new jxl.write.Label(6, 2, "Energie kWh/a");
        jxl.write.Label labelTHM3 = new jxl.write.Label(6, 3,
            "Zusatzwasser m³/a");
        jxl.write.Label labelTHM4 = new jxl.write.Label(6, 4,
            "Schmutzwassersiel m³/a");
        jxl.write.Label labelTHM5 = new jxl.write.Label(6, 5,
            "Regenwassersiel m³/a");
        jxl.write.Label labelTHM6 = new jxl.write.Label(6, 6,
            "Dosiermittel kg/a");
        jxl.write.Label labelTHM7 = new jxl.write.Label(6, 7,
            "Salztabletten kg/a ");
        jxl.write.Label labelTHM8 = new jxl.write.Label(6, 8, "Salzsäure kg/a");
        jxl.write.Label labelTHM9 = new jxl.write.Label(6, 9,
            "Schwefelsäure kg/l");
        jxl.write.Label labelTHM10 = new jxl.write.Label(6, 10,
            "RO Dosiermittel kg/a");

        //
        sheet2.addCell(labelTHM1);
        sheet2.addCell(labelTHM2);
        sheet2.addCell(labelTHM3);
        sheet2.addCell(labelTHM4);
        sheet2.addCell(labelTHM5);
        sheet2.addCell(labelTHM6);
        sheet2.addCell(labelTHM7);
        sheet2.addCell(labelTHM8);
        sheet2.addCell(labelTHM9);
        sheet2.addCell(labelTHM10);

        //VERBRAUCH  EH
        jxl.write.Label labelEHM1 = new jxl.write.Label(6, 0,
            "Verbrauchsmengen");
        jxl.write.Label labelEHM2 = new jxl.write.Label(6, 2, "Energie kWh/a");
        jxl.write.Label labelEHM3 = new jxl.write.Label(6, 3,
            "Zusatzwasser m³/a");
        jxl.write.Label labelEHM4 = new jxl.write.Label(6, 4,
            "Schmutzwassersiel m³/a");
        jxl.write.Label labelEHM5 = new jxl.write.Label(6, 5,
            "Regenwassersiel m³/a");
        jxl.write.Label labelEHM6 = new jxl.write.Label(6, 6,
            "Dosiermittel kg/a");
        jxl.write.Label labelEHM7 = new jxl.write.Label(6, 7,
            "Salztabletten kg/a ");
        jxl.write.Label labelEHM8 = new jxl.write.Label(6, 8, "Salzsäure kg/a");
        jxl.write.Label labelEHM9 = new jxl.write.Label(6, 9,
            "Schwefelsäure kg/l");
        jxl.write.Label labelEHM10 = new jxl.write.Label(6, 10,
            "RO Dosiermittel kg/a");

        //
        sheet3.addCell(labelEHM1);
        sheet3.addCell(labelEHM2);
        sheet3.addCell(labelEHM3);
        sheet3.addCell(labelEHM4);
        sheet3.addCell(labelEHM5);
        sheet3.addCell(labelEHM6);
        sheet3.addCell(labelEHM7);
        sheet3.addCell(labelEHM8);
        sheet3.addCell(labelEHM9);
        sheet3.addCell(labelEHM10);

        //VERBRAUCH  EC
        jxl.write.Label labelECM1 = new jxl.write.Label(6, 0,
            "Verbrauchsmengen");
        jxl.write.Label labelECM2 = new jxl.write.Label(6, 2, "Energie kWh/a");
        jxl.write.Label labelECM3 = new jxl.write.Label(6, 3,
            "Zusatzwasser m³/a");
        jxl.write.Label labelECM4 = new jxl.write.Label(6, 4,
            "Schmutzwassersiel m³/a");
        jxl.write.Label labelECM5 = new jxl.write.Label(6, 5,
            "Regenwassersiel m³/a");
        jxl.write.Label labelECM6 = new jxl.write.Label(6, 6,
            "Dosiermittel kg/a");
        jxl.write.Label labelECM7 = new jxl.write.Label(6, 7,
            "Salztabletten kg/a ");
        jxl.write.Label labelECM8 = new jxl.write.Label(6, 8, "Salzsäure kg/a");
        jxl.write.Label labelECM9 = new jxl.write.Label(6, 9,
            "Schwefelsäure kg/l");
        jxl.write.Label labelECM10 = new jxl.write.Label(6, 10,
            "RO Dosiermittel kg/a");

        //
        sheet4.addCell(labelECM1);
        sheet4.addCell(labelECM2);
        sheet4.addCell(labelECM3);
        sheet4.addCell(labelECM4);
        sheet4.addCell(labelECM5);
        sheet4.addCell(labelECM6);
        sheet4.addCell(labelECM7);
        sheet4.addCell(labelECM8);
        sheet4.addCell(labelECM9);
        sheet4.addCell(labelECM10);

        //
//VERBRAUCH  UO
        jxl.write.Label labelUOM1 = new jxl.write.Label(6, 0,
            "Verbrauchsmengen");
        jxl.write.Label labelUOM2 = new jxl.write.Label(6, 2, "Energie kWh/a");
        jxl.write.Label labelUOM3 = new jxl.write.Label(6, 3,
            "Zusatzwasser m³/a");
        jxl.write.Label labelUOM4 = new jxl.write.Label(6, 4,
            "Schmutzwassersiel m³/a");
        jxl.write.Label labelUOM5 = new jxl.write.Label(6, 5,
            "Regenwassersiel m³/a");
        jxl.write.Label labelUOM6 = new jxl.write.Label(6, 6,
            "Dosiermittel kg/a");
        jxl.write.Label labelUOM7 = new jxl.write.Label(6, 7,
            "Salztabletten kg/a ");
        jxl.write.Label labelUOM8 = new jxl.write.Label(6, 8, "Salzsäure kg/a");
        jxl.write.Label labelUOM9 = new jxl.write.Label(6, 9,
            "Schwefelsäure kg/l");
        jxl.write.Label labelUOM10 = new jxl.write.Label(6, 10,
            "RO Dosiermittel kg/a");

        //
        sheet5.addCell(labelUOM1);
        sheet5.addCell(labelUOM2);
        sheet5.addCell(labelUOM3);
        sheet5.addCell(labelUOM4);
        sheet5.addCell(labelUOM5);
        sheet5.addCell(labelUOM6);
        sheet5.addCell(labelUOM7);
        sheet5.addCell(labelUOM8);
        sheet5.addCell(labelUOM9);
        sheet5.addCell(labelUOM10);

        //VERBRAUCH  THRESH
        jxl.write.Label labelUMM1 = new jxl.write.Label(6, 0,
            "Verbrauchsmengen");
        jxl.write.Label labelUMM2 = new jxl.write.Label(6, 2, "Energie kWh/a");
        jxl.write.Label labelUMM3 = new jxl.write.Label(6, 3,
            "Zusatzwasser m³/a");
        jxl.write.Label labelUMM4 = new jxl.write.Label(6, 4,
            "Schmutzwassersiel m³/a");
        jxl.write.Label labelUMM5 = new jxl.write.Label(6, 5,
            "Regenwassersiel m³/a");
        jxl.write.Label labelUMM6 = new jxl.write.Label(6, 6,
            "Dosiermittel kg/a");
        jxl.write.Label labelUMM7 = new jxl.write.Label(6, 7,
            "Salztabletten kg/a ");
        jxl.write.Label labelUMM8 = new jxl.write.Label(6, 8, "Salzsäure kg/a");
        jxl.write.Label labelUMM9 = new jxl.write.Label(6, 9,
            "Schwefelsäure kg/l");
        jxl.write.Label labelUMM10 = new jxl.write.Label(6, 10,
            "RO Dosiermittel kg/a");

        //
        sheet6.addCell(labelUMM1);
        sheet6.addCell(labelUMM2);
        sheet6.addCell(labelUMM3);
        sheet6.addCell(labelUMM4);
        sheet6.addCell(labelUMM5);
        sheet6.addCell(labelUMM6);
        sheet6.addCell(labelUMM7);
        sheet6.addCell(labelUMM8);
        sheet6.addCell(labelUMM9);
        sheet6.addCell(labelUMM10);
//

        //VERBRAUCH  THRESH
        jxl.write.Label labelSDM1 = new jxl.write.Label(6, 0,
            "Verbrauchsmengen");
        jxl.write.Label labelSDM2 = new jxl.write.Label(6, 2, "Energie kWh/a");
        jxl.write.Label labelSDM3 = new jxl.write.Label(6, 3,
            "Zusatzwasser m³/a");
        jxl.write.Label labelSDM4 = new jxl.write.Label(6, 4,
            "Schmutzwassersiel m³/a");
        jxl.write.Label labelSDM5 = new jxl.write.Label(6, 5,
            "Regenwassersiel m³/a");
        jxl.write.Label labelSDM6 = new jxl.write.Label(6, 6,
            "Dosiermittel kg/a");
        jxl.write.Label labelSDM7 = new jxl.write.Label(6, 7,
            "Salztabletten kg/a ");
        jxl.write.Label labelSDM8 = new jxl.write.Label(6, 8, "Salzsäure kg/a");
        jxl.write.Label labelSDM9 = new jxl.write.Label(6, 9,
            "Schwefelsäure kg/l");
        jxl.write.Label labelSDM10 = new jxl.write.Label(6, 10,
            "RO Dosiermittel kg/a");

        //
        sheet7.addCell(labelSDM1);
        sheet7.addCell(labelSDM2);
        sheet7.addCell(labelSDM3);
        sheet7.addCell(labelSDM4);
        sheet7.addCell(labelSDM5);
        sheet7.addCell(labelSDM6);
        sheet7.addCell(labelSDM7);
        sheet7.addCell(labelSDM8);
        sheet7.addCell(labelSDM9);
        sheet7.addCell(labelSDM10);

        //Kosten TH
        jxl.write.Label labelTHK1 = new jxl.write.Label(6, 11, "Kosten");
        jxl.write.Label labelTHK2 = new jxl.write.Label(6, 13, "Energie EUR/a");
        jxl.write.Label labelTHK3 = new jxl.write.Label(6, 14,
            "Zusatzwasser EUR/a");
        jxl.write.Label labelTHK4 = new jxl.write.Label(6, 15,
            "Schmutzwassersiel EUR/a");
        jxl.write.Label labelTHK5 = new jxl.write.Label(6, 16,
            "Regenwassersiel EUR/a");
        jxl.write.Label labelTHK6 = new jxl.write.Label(6, 17,
            "Dosiermittel EUR/a");
        jxl.write.Label labelTHK7 = new jxl.write.Label(6, 18,
            "Salztabletten EUR/a ");
        jxl.write.Label labelTHK8 = new jxl.write.Label(6, 19,
            "Salzsäure EUR/a");
        jxl.write.Label labelTHK9 = new jxl.write.Label(6, 20,
            "Schwefelsäure EUR/l");
        jxl.write.Label labelTHK10 = new jxl.write.Label(6, 21,
            "RO Dosiermittel EUR/a");
        jxl.write.Label labelTHK11 = new jxl.write.Label(9, 23,
            "Gesamtkosten EUR/a");

        //
        sheet2.addCell(labelTHK1);
        sheet2.addCell(labelTHK2);
        sheet2.addCell(labelTHK3);
        sheet2.addCell(labelTHK4);
        sheet2.addCell(labelTHK5);
        sheet2.addCell(labelTHK6);
        sheet2.addCell(labelTHK7);
        sheet2.addCell(labelTHK8);
        sheet2.addCell(labelTHK9);
        sheet2.addCell(labelTHK10);
        sheet2.addCell(labelTHK11);

        //
        //Kosten
        jxl.write.Label labelEHK1 = new jxl.write.Label(6, 11, "Kosten");
        jxl.write.Label labelEHK2 = new jxl.write.Label(6, 13, "Energie EUR/a");
        jxl.write.Label labelEHK3 = new jxl.write.Label(6, 14,
            "Zusatzwasser EUR/a");
        jxl.write.Label labelEHK4 = new jxl.write.Label(6, 15,
            "Schmutzwassersiel EUR/a");
        jxl.write.Label labelEHK5 = new jxl.write.Label(6, 16,
            "Regenwassersiel EUR/a");
        jxl.write.Label labelEHK6 = new jxl.write.Label(6, 17,
            "Dosiermittel EUR/a");
        jxl.write.Label labelEHK7 = new jxl.write.Label(6, 18,
            "Salztabletten EUR/a ");
        jxl.write.Label labelEHK8 = new jxl.write.Label(6, 19,
            "Salzsäure EUR/a");
        jxl.write.Label labelEHK9 = new jxl.write.Label(6, 20,
            "Schwefelsäure EUR/l");
        jxl.write.Label labelEHK10 = new jxl.write.Label(6, 21,
            "RO Dosiermittel EUR/a");
        jxl.write.Label labelEHK11 = new jxl.write.Label(6, 22,
            "Gesamtkosten EUR/a");

//
        sheet3.addCell(labelEHK1);
        sheet3.addCell(labelEHK2);
        sheet3.addCell(labelEHK3);
        sheet3.addCell(labelEHK4);
        sheet3.addCell(labelEHK5);
        sheet3.addCell(labelEHK6);
        sheet3.addCell(labelEHK7);
        sheet3.addCell(labelEHK8);
        sheet3.addCell(labelEHK9);
        sheet3.addCell(labelEHK10);
        sheet3.addCell(labelEHK11);

        //Kosten EC
        jxl.write.Label labelECK1 = new jxl.write.Label(6, 11, "Kosten");
        jxl.write.Label labelECK2 = new jxl.write.Label(6, 13, "Energie EUR/a");
        jxl.write.Label labelECK3 = new jxl.write.Label(6, 14,
            "Zusatzwasser EUR/a");
        jxl.write.Label labelECK4 = new jxl.write.Label(6, 15,
            "Schmutzwassersiel EUR/a");
        jxl.write.Label labelECK5 = new jxl.write.Label(6, 16,
            "Regenwassersiel EUR/a");
        jxl.write.Label labelECK6 = new jxl.write.Label(6, 17,
            "Dosiermittel EUR/a");
        jxl.write.Label labelECK7 = new jxl.write.Label(6, 18,
            "Salztabletten EUR/a ");
        jxl.write.Label labelECK8 = new jxl.write.Label(6, 19,
            "Salzsäure EUR/a");
        jxl.write.Label labelECK9 = new jxl.write.Label(6, 20,
            "Schwefelsäure EUR/l");
        jxl.write.Label labelECK10 = new jxl.write.Label(6, 21,
            "RO Dosiermittel EUR/a");
        jxl.write.Label labelECK11 = new jxl.write.Label(6, 22,
            "Gesamtkosten EUR/a");

//
        sheet4.addCell(labelECK1);
        sheet4.addCell(labelECK2);
        sheet4.addCell(labelECK3);
        sheet4.addCell(labelECK4);
        sheet4.addCell(labelECK5);
        sheet4.addCell(labelECK6);
        sheet4.addCell(labelECK7);
        sheet4.addCell(labelECK8);
        sheet4.addCell(labelECK9);
        sheet4.addCell(labelECK10);
        sheet4.addCell(labelECK11);

//
        //Kosten
        jxl.write.Label labelUOK1 = new jxl.write.Label(6, 11, "Kosten");
        jxl.write.Label labelUOK2 = new jxl.write.Label(6, 13, "Energie EUR/a");
        jxl.write.Label labelUOK3 = new jxl.write.Label(6, 14,
            "Zusatzwasser EUR/a");
        jxl.write.Label labelUOK4 = new jxl.write.Label(6, 15,
            "Schmutzwassersiel EUR/a");
        jxl.write.Label labelUOK5 = new jxl.write.Label(6, 16,
            "Regenwassersiel EUR/a");
        jxl.write.Label labelUOK6 = new jxl.write.Label(6, 17,
            "Dosiermittel EUR/a");
        jxl.write.Label labelUOK7 = new jxl.write.Label(6, 18,
            "Salztabletten EUR/a ");
        jxl.write.Label labelUOK8 = new jxl.write.Label(6, 19,
            "Salzsäure EUR/a");
        jxl.write.Label labelUOK9 = new jxl.write.Label(6, 20,
            "Schwefelsäure EUR/l");
        jxl.write.Label labelUOK10 = new jxl.write.Label(6, 21,
            "RO Dosiermittel EUR/a");
        jxl.write.Label labelUOK11 = new jxl.write.Label(6, 22,
            "Gesamtkosten EUR/a");

        //
        sheet5.addCell(labelUOK1);
        sheet5.addCell(labelUOK2);
        sheet5.addCell(labelUOK3);
        sheet5.addCell(labelUOK4);
        sheet5.addCell(labelUOK5);
        sheet5.addCell(labelUOK6);
        sheet5.addCell(labelUOK7);
        sheet5.addCell(labelUOK8);
        sheet5.addCell(labelUOK9);
        sheet5.addCell(labelUOK10);
        sheet5.addCell(labelUOK11);
//

        //Kosten UM
        jxl.write.Label labelUMK1 = new jxl.write.Label(6, 11, "Kosten");
        jxl.write.Label labelUMK2 = new jxl.write.Label(6, 13, "Energie EUR/a");
        jxl.write.Label labelUMK3 = new jxl.write.Label(6, 14,
            "Zusatzwasser EUR/a");
        jxl.write.Label labelUMK4 = new jxl.write.Label(6, 15,
            "Schmutzwassersiel EUR/a");
        jxl.write.Label labelUMK5 = new jxl.write.Label(6, 16,
            "Regenwassersiel EUR/a");
        jxl.write.Label labelUMK6 = new jxl.write.Label(6, 17,
            "Dosiermittel EUR/a");
        jxl.write.Label labelUMK7 = new jxl.write.Label(6, 18,
            "Salztabletten EUR/a ");
        jxl.write.Label labelUMK8 = new jxl.write.Label(6, 19,
            "Salzsäure EUR/a");
        jxl.write.Label labelUMK9 = new jxl.write.Label(6, 20,
            "Schwefelsäure EUR/l");
        jxl.write.Label labelUMK10 = new jxl.write.Label(6, 21,
            "RO Dosiermittel EUR/a");
        jxl.write.Label labelUMK11 = new jxl.write.Label(6, 22,
            "Gesamtkosten EUR/a");

        //
        sheet6.addCell(labelUMK1);
        sheet6.addCell(labelUMK2);
        sheet6.addCell(labelUMK3);
        sheet6.addCell(labelUMK4);
        sheet6.addCell(labelUMK5);
        sheet6.addCell(labelUMK6);
        sheet6.addCell(labelUMK7);
        sheet6.addCell(labelUMK8);
        sheet6.addCell(labelUMK9);
        sheet6.addCell(labelUMK10);
        sheet6.addCell(labelUMK11);

//

        //Kosten SD
        jxl.write.Label labelSDK1 = new jxl.write.Label(6, 11, "Kosten");
        jxl.write.Label labelSDK2 = new jxl.write.Label(6, 13, "Energie EUR/a");
        jxl.write.Label labelSDK3 = new jxl.write.Label(6, 14,
            "Zusatzwasser EUR/a");
        jxl.write.Label labelSDK4 = new jxl.write.Label(6, 15,
            "Schmutzwassersiel EUR/a");
        jxl.write.Label labelSDK5 = new jxl.write.Label(6, 16,
            "Regenwassersiel EUR/a");
        jxl.write.Label labelSDK6 = new jxl.write.Label(6, 17,
            "Dosiermittel EUR/a");
        jxl.write.Label labelSDK7 = new jxl.write.Label(6, 18,
            "Salztabletten EUR/a ");
        jxl.write.Label labelSDK8 = new jxl.write.Label(6, 19,
            "Salzsäure EUR/a");
        jxl.write.Label labelSDK9 = new jxl.write.Label(6, 20,
            "Schwefelsäure EUR/l");
        jxl.write.Label labelSDK10 = new jxl.write.Label(6, 21,
            "RO Dosiermittel EUR/a");
        jxl.write.Label labelSDK11 = new jxl.write.Label(6, 22,
            "Gesamtkosten EUR/a");

//
        sheet7.addCell(labelSDK1);
        sheet7.addCell(labelSDK2);
        sheet7.addCell(labelSDK3);
        sheet7.addCell(labelSDK4);
        sheet7.addCell(labelSDK5);
        sheet7.addCell(labelSDK6);
        sheet7.addCell(labelSDK7);
        sheet7.addCell(labelSDK8);
        sheet7.addCell(labelSDK9);
        sheet7.addCell(labelSDK10);
        sheet7.addCell(labelSDK11);

//



//*****************************************************************
//   WERTE EINFÜGEN
//*****************************************************************
///
          f.threshhold();
        //Umlaufwasseranalyse
        jxl.write.Label labelUW1 = new jxl.write.Label(4, 0,
            f.aufbereitung, nf1cell);
        jxl.write.Number numberUW2 = new jxl.write.Number(4, 2,
            f.anauml.verSchnitt, nf1cell);
        jxl.write.Number numberUW3 = new jxl.write.Number(4, 3,
            f.anauml.eindickung, nf1cell);
        jxl.write.Number numberUW4 = new jxl.write.Number(4, 4, f.anauml.tKT,
            nf1cell);
        jxl.write.Number numberUW5 = new jxl.write.Number(4, 5, f.anauml.tW,
            nf1cell);
        jxl.write.Number numberUW6 = new jxl.write.Number(4, 6, f.anauml.lF,
            nf1cell);
        jxl.write.Number numberUW7 = new jxl.write.Number(4, 7, f.anauml.ca,
            nf1cell);
        jxl.write.Number numberUW8 = new jxl.write.Number(4, 8, f.anauml.mg,
            nf1cell);
        jxl.write.Number numberUW9 = new jxl.write.Number(4, 9, f.anauml.na,
            nf1cell);
        jxl.write.Number numberUW10 = new jxl.write.Number(4, 10, f.anauml.ks,
            nf1cell);
        jxl.write.Number numberUW11 = new jxl.write.Number(4, 11, f.anauml.cl,
            nf1cell);
        jxl.write.Number numberUW12 = new jxl.write.Number(4, 12, f.anauml.so4,
            nf1cell);
        jxl.write.Number numberUW13 = new jxl.write.Number(4, 13, f.anauml.no3,
            nf1cell);
        jxl.write.Number numberUW14 = new jxl.write.Number(4, 14,
            f.anauml.pHKTnV, nf1cell);
        jxl.write.Number numberUW15 = new jxl.write.Number(4, 15,
            f.anauml.pHTKT, nf1cell);
        jxl.write.Number numberUW16 = new jxl.write.Number(4, 16,
            f.anauml.siTKT, nf1cell);
        jxl.write.Number numberUW17 = new jxl.write.Number(4, 17,
            f.anauml.pHggWW, nf1cell);
        jxl.write.Number numberUW18 = new jxl.write.Number(4, 18, f.anauml.sIW,
            nf1cell);
        jxl.write.Number numberUW19 = new jxl.write.Number(4, 19, f.anauml.salz,
            nf1cell);
        jxl.write.Number numberUW20 = new jxl.write.Number(4, 20,
            f.anauml.ionen, nf1cell);
        jxl.write.Number numberUW21 = new jxl.write.Number(4, 21,
            f.anauml.h2co3, nf1cell);
        jxl.write.Number numberUW22 = new jxl.write.Number(4, 22, f.anauml.hco3,
            nf1cell);
        jxl.write.Number numberUW23 = new jxl.write.Number(4, 23, f.anauml.co3,
            nf1cell);

        sheet2.addCell(labelUW1);
        sheet2.addCell(numberUW2);
        sheet2.addCell(numberUW3);
        sheet2.addCell(numberUW4);
        sheet2.addCell(numberUW5);
        sheet2.addCell(numberUW6);
        sheet2.addCell(numberUW7);
        sheet2.addCell(numberUW8);
        sheet2.addCell(numberUW9);
        sheet2.addCell(numberUW10);
        sheet2.addCell(numberUW11);
        sheet2.addCell(numberUW12);
        sheet2.addCell(numberUW13);
        sheet2.addCell(numberUW14);
        sheet2.addCell(numberUW15);
        sheet2.addCell(numberUW16);
        sheet2.addCell(numberUW17);
        sheet2.addCell(numberUW18);
        sheet2.addCell(numberUW19);
        sheet2.addCell(numberUW20);
        sheet2.addCell(numberUW21);
        sheet2.addCell(numberUW22);
        sheet2.addCell(numberUW23);

//VERBRAUCH

        jxl.write.Number numberVB1 = new jxl.write.Number(7, 2,
            f.betrkost.enVer, nf1cell);
        jxl.write.Number numberVB2 = new jxl.write.Number(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        jxl.write.Number numberVB3 = new jxl.write.Number(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        jxl.write.Number numberVB4 = new jxl.write.Number(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        jxl.write.Number numberVB5 = new jxl.write.Number(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        jxl.write.Number numberVB6 = new jxl.write.Number(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        jxl.write.Number numberVB7 = new jxl.write.Number(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        jxl.write.Number numberVB8 = new jxl.write.Number(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        jxl.write.Number numberVB9 = new jxl.write.Number(7, 10,
            f.betrkost.roVer, nf1cell);

        sheet2.addCell(numberVB1);
        sheet2.addCell(numberVB2);
        sheet2.addCell(numberVB3);
        sheet2.addCell(numberVB4);
        sheet2.addCell(numberVB5);
        sheet2.addCell(numberVB6);
        sheet2.addCell(numberVB7);
        sheet2.addCell(numberVB8);
        sheet2.addCell(numberVB9);

//KOSTEN

        jxl.write.Number numberKO1 = new jxl.write.Number(7, 13,
            f.betrkost.enKost, nf1cell);
        jxl.write.Number numberKO2 = new jxl.write.Number(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        jxl.write.Number numberKO3 = new jxl.write.Number(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        jxl.write.Number numberKO4 = new jxl.write.Number(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        jxl.write.Number numberKO5 = new jxl.write.Number(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        jxl.write.Number numberKO6 = new jxl.write.Number(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        jxl.write.Number numberKO7 = new jxl.write.Number(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        jxl.write.Number numberKO8 = new jxl.write.Number(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        jxl.write.Number numberKO9 = new jxl.write.Number(7, 21,
            f.betrkost.roKost, nf1cell);
        jxl.write.Number numberKO10 = new jxl.write.Number(7, 23,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
            f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
            f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
            f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
            f.anlkost.jahresBetrag, nf1cell);

        sheet2.addCell(numberKO1);
        sheet2.addCell(numberKO2);
        sheet2.addCell(numberKO3);
        sheet2.addCell(numberKO4);
        sheet2.addCell(numberKO5);
        sheet2.addCell(numberKO6);
        sheet2.addCell(numberKO7);
        sheet2.addCell(numberKO8);
        sheet2.addCell(numberKO9);
        sheet2.addCell(numberKO10);
        //******ANLAGE THRESHOLD*************************************************

         jxl.write.Label labelG1 = new jxl.write.Label(9, 0,
             "Anlageinformationen");
        sheet2.addCell(labelG1);

        jxl.write.Label labelG15 = new jxl.write.Label(9, 3,
            "Anlage,Typ:");
        sheet2.addCell(labelG15);
        jxl.write.Label LabelAK15 = new jxl.write.Label(10, 3,
            f.anlkost.typ3, nf1cell);
        sheet2.addCell(LabelAK15);

        jxl.write.Label labelG16 = new jxl.write.Label(9, 4,
            "Dosier und Schutzbehälter:");
        sheet2.addCell(labelG16);
        jxl.write.Label labelAK16 = new jxl.write.Label(10, 4,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        sheet2.addCell(labelAK16);

        jxl.write.Label labelG17 = new jxl.write.Label(9, 5,
            "Werkstoff:");
        sheet2.addCell(labelG17);
        jxl.write.Label LabelAK17 = new jxl.write.Label(10, 5,
            f.anlkost.ws3, nf1cell);

        jxl.write.Label labelG18 = new jxl.write.Label(9, 6,
            "Steuerung::");
        sheet2.addCell(labelG18);
        sheet2.addCell(LabelAK17);
        jxl.write.Label LabelAK18 = new jxl.write.Label(10, 6,
            f.anlkost.st3, nf1cell);
        sheet2.addCell(LabelAK18);

        jxl.write.Label labelG19 = new jxl.write.Label(9, 7,
            "Wassermengenzähler:");
        sheet2.addCell(labelG19);
        jxl.write.Label NumberAK19 = new jxl.write.Label(10, 7,
            f.anlkost.wz3, nf1cell);
        sheet2.addCell(NumberAK19);

        jxl.write.Label labelG20 = new jxl.write.Label(9, 8,
            "Richtpreis einschl. Montage:");
        sheet2.addCell(labelG20);
        jxl.write.Number NumberAK20 = new jxl.write.Number(10, 8,
            f.anlkost.aP3, nf1cell);
        sheet2.addCell(NumberAK20);

        jxl.write.Label labelG21 = new jxl.write.Label(9, 9,
            "Systemtrenner und Feinfilter:");
        sheet2.addCell(labelG21);
        jxl.write.Number NumberAK21 = new jxl.write.Number(10, 9,
            f.anlkost.stffP, nf1cell);
        sheet2.addCell(NumberAK21);

        jxl.write.Label labelG22 = new jxl.write.Label(9, 11,
            "Gesamtanlagenpreis:");
        sheet2.addCell(labelG22);
        jxl.write.Number NumberAK22 = new jxl.write.Number(10, 11,
            f.anlkost.summe, nf1cell);
        sheet2.addCell(NumberAK22);

        jxl.write.Label labelG23 = new jxl.write.Label(9, 12,
            "Anlagenkosten/Jahr:");
        sheet2.addCell(labelG23);
        jxl.write.Number NumberAK23 = new jxl.write.Number(10, 12,
            f.anlkost.jahresBetrag, nf1cell);
        sheet2.addCell(NumberAK23);
        //} // Ende der for Schleife
        //**********

         //ENTHÄRTUNG
         f.enthaertung();

//Umlaufwasseranalyse
        jxl.write.Label labelEHUW1 = new jxl.write.Label(4, 0,
            f.aufbereitung, nf1cell);
        jxl.write.Number numberEHUW2 = new jxl.write.Number(4, 2,
            f.anauml.verSchnitt, nf1cell);
        jxl.write.Number numberEHUW3 = new jxl.write.Number(4, 3,
            f.anauml.eindickung, nf1cell);
        jxl.write.Number numberEHUW4 = new jxl.write.Number(4, 4, f.anauml.tKT,
            nf1cell);
        jxl.write.Number numberEHUW5 = new jxl.write.Number(4, 5, f.anauml.tW,
            nf1cell);
        jxl.write.Number numberEHUW6 = new jxl.write.Number(4, 6, f.anauml.lF,
            nf1cell);
        jxl.write.Number numberEHUW7 = new jxl.write.Number(4, 7, f.anauml.ca,
            nf1cell);
        jxl.write.Number numberEHUW8 = new jxl.write.Number(4, 8, f.anauml.mg,
            nf1cell);
        jxl.write.Number numberEHUW9 = new jxl.write.Number(4, 9, f.anauml.na,
            nf1cell);
        jxl.write.Number numberEHUW10 = new jxl.write.Number(4, 10, f.anauml.ks,
            nf1cell);
        jxl.write.Number numberEHUW11 = new jxl.write.Number(4, 11, f.anauml.cl,
            nf1cell);
        jxl.write.Number numberEHUW12 = new jxl.write.Number(4, 12,
            f.anauml.so4,
            nf1cell);
        jxl.write.Number numberEHUW13 = new jxl.write.Number(4, 13,
            f.anauml.no3,
            nf1cell);
        jxl.write.Number numberEHUW14 = new jxl.write.Number(4, 14,
            f.anauml.pHKTnV, nf1cell);
        jxl.write.Number numberEHUW15 = new jxl.write.Number(4, 15,
            f.anauml.pHTKT, nf1cell);
        jxl.write.Number numberEHUW16 = new jxl.write.Number(4, 16,
            f.anauml.siTKT, nf1cell);
        jxl.write.Number numberEHUW17 = new jxl.write.Number(4, 17,
            f.anauml.pHggWW, nf1cell);
        jxl.write.Number numberEHUW18 = new jxl.write.Number(4, 18,
            f.anauml.sIW,
            nf1cell);
        jxl.write.Number numberEHUW19 = new jxl.write.Number(4, 19,
            f.anauml.salz,
            nf1cell);
        jxl.write.Number numberEHUW20 = new jxl.write.Number(4, 20,
            f.anauml.ionen, nf1cell);
        jxl.write.Number numberEHUW21 = new jxl.write.Number(4, 21,
            f.anauml.h2co3, nf1cell);
        jxl.write.Number numberEHUW22 = new jxl.write.Number(4, 22,
            f.anauml.hco3,
            nf1cell);
        jxl.write.Number numberEHUW23 = new jxl.write.Number(4, 23,
            f.anauml.co3,
            nf1cell);

        sheet3.addCell(labelEHUW1);
        sheet3.addCell(numberEHUW2);

        sheet3.addCell(numberEHUW3);
        sheet3.addCell(numberEHUW4);
        sheet3.addCell(numberEHUW5);
        sheet3.addCell(numberEHUW6);
        sheet3.addCell(numberEHUW7);
        sheet3.addCell(numberEHUW8);
        sheet3.addCell(numberEHUW9);
        sheet3.addCell(numberEHUW10);
        sheet3.addCell(numberEHUW11);
        sheet3.addCell(numberEHUW12);
        sheet3.addCell(numberEHUW13);
        sheet3.addCell(numberEHUW14);
        sheet3.addCell(numberEHUW15);
        sheet3.addCell(numberEHUW16);
        sheet3.addCell(numberEHUW17);
        sheet3.addCell(numberEHUW18);
        sheet3.addCell(numberEHUW19);
        sheet3.addCell(numberEHUW20);
        sheet3.addCell(numberEHUW21);
        sheet3.addCell(numberEHUW22);
        sheet3.addCell(numberEHUW23);
//VERBRAUCH

        jxl.write.Number numberEHVB1 = new jxl.write.Number(7, 2,
            f.betrkost.enVer, nf1cell);
        jxl.write.Number numberEHVB2 = new jxl.write.Number(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        jxl.write.Number numberEHVB3 = new jxl.write.Number(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        jxl.write.Number numberEHVB4 = new jxl.write.Number(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        jxl.write.Number numberEHVB5 = new jxl.write.Number(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        jxl.write.Number numberEHVB6 = new jxl.write.Number(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        jxl.write.Number numberEHVB7 = new jxl.write.Number(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        jxl.write.Number numberEHVB8 = new jxl.write.Number(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        jxl.write.Number numberEHVB9 = new jxl.write.Number(7, 10,
            f.betrkost.roVer, nf1cell);

        sheet3.addCell(numberEHVB1);
        sheet3.addCell(numberEHVB2);
        sheet3.addCell(numberEHVB3);
        sheet3.addCell(numberEHVB4);
        sheet3.addCell(numberEHVB5);
        sheet3.addCell(numberEHVB6);
        sheet3.addCell(numberEHVB7);
        sheet3.addCell(numberEHVB8);
        sheet3.addCell(numberEHVB9);

//KOSTEN

        jxl.write.Number numberEHKO1 = new jxl.write.Number(7, 13,
            f.betrkost.enKost, nf1cell);
        jxl.write.Number numberEHKO2 = new jxl.write.Number(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        jxl.write.Number numberEHKO3 = new jxl.write.Number(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        jxl.write.Number numberEHKO4 = new jxl.write.Number(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        jxl.write.Number numberEHKO5 = new jxl.write.Number(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        jxl.write.Number numberEHKO6 = new jxl.write.Number(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        jxl.write.Number numberEHKO7 = new jxl.write.Number(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        jxl.write.Number numberEHKO8 = new jxl.write.Number(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        jxl.write.Number numberEHKO9 = new jxl.write.Number(7, 21,
            f.betrkost.roKost, nf1cell);
        jxl.write.Number numberEHKO10 = new jxl.write.Number(7, 22,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
            f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
            f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
            f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
            f.anlkost.jahresBetrag, nf1cell);

        sheet3.addCell(numberEHKO1);
        sheet3.addCell(numberEHKO2);
        sheet3.addCell(numberEHKO3);
        sheet3.addCell(numberEHKO4);
        sheet3.addCell(numberEHKO5);
        sheet3.addCell(numberEHKO6);
        sheet3.addCell(numberEHKO7);
        sheet3.addCell(numberEHKO8);
        sheet3.addCell(numberEHKO9);
        sheet3.addCell(numberEHKO10);
//*******************ANLAGE ENTHÄRTUNG*******+


         jxl.write.Label labelEHG1 = new jxl.write.Label(9, 0,
             "Anlageinformationen");
        sheet3.addCell(labelEHG1);
        jxl.write.Label labelEHAK1 = new jxl.write.Label(10, 0,
            f.anlkost.aufbereitungsart, nf1cell);
        sheet3.addCell(labelEHAK1);

        jxl.write.Label labelEHG2 = new jxl.write.Label(9, 2,
            "Anlage,Typ:");
        sheet3.addCell(labelEHG2);
        jxl.write.Label labelEHAK2 = new jxl.write.Label(10, 2, f.anlkost.typ1,
            nf1cell);
        sheet3.addCell(labelEHAK2);

        jxl.write.Label labelEHG3 = new jxl.write.Label(9, 3,
            "Kapazität:");
        sheet3.addCell(labelEHG3);
        jxl.write.Number numberEHAK3 = new jxl.write.Number(10, 3,
            f.anlkost.kap1, nf1cell);
        sheet3.addCell(numberEHAK3);

        jxl.write.Label labelEHG4 = new jxl.write.Label(9, 4,
            "Verrohrung:");
        sheet3.addCell(labelEHG4);
        jxl.write.Label labelEHAK4 = new jxl.write.Label(10, 4,
            f.anlkost.nennweite1, nf1cell);
        sheet3.addCell(labelEHAK4);

        jxl.write.Label labelEHG5 = new jxl.write.Label(9, 5,
            "Werkstoff:");
        sheet3.addCell(labelEHG5);
        jxl.write.Label labelEHAK5 = new jxl.write.Label(10, 5, f.anlkost.ws1,
            nf1cell);
        sheet3.addCell(labelEHAK5);

        jxl.write.Label labelEHG6 = new jxl.write.Label(9, 6,
            "Steuerung:");
        sheet3.addCell(labelEHG6);
        jxl.write.Label labelEHAK6 = new jxl.write.Label(10, 6, f.anlkost.st1,
            nf1cell);
        sheet3.addCell(labelEHAK6);

        jxl.write.Label labelEHG7 = new jxl.write.Label(9, 7,
            "Wassermengenzähler:");
        sheet3.addCell(labelEHG7);
        jxl.write.Label labelEHAK7 = new jxl.write.Label(10, 7, f.anlkost.wz1,
            nf1cell);
        sheet3.addCell(labelEHAK7);

        jxl.write.Label labelEHG9 = new jxl.write.Label(9, 8,
            "Richtpreis einschl. Montage:");
        sheet3.addCell(labelEHG9);
        jxl.write.Number numberEHAK9 = new jxl.write.Number(10, 8,
            f.anlkost.aP1, nf1cell);
        sheet3.addCell(numberEHAK9);
        //
        //


        jxl.write.Label labelEHG15 = new jxl.write.Label(9, 10,
            "Anlage,Typ:");
        sheet3.addCell(labelEHG15);
        jxl.write.Label labelEHAK15 = new jxl.write.Label(10, 10,
            f.anlkost.typ3, nf1cell);
        sheet3.addCell(labelEHAK15);

        jxl.write.Label labelEHG16 = new jxl.write.Label(9, 11,
            "Dosier und Schutzbehälter:");
        sheet3.addCell(labelEHG16);
        jxl.write.Label labelEHAK16 = new jxl.write.Label(10, 11,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        sheet3.addCell(labelEHAK16);

        jxl.write.Label labelEHG17 = new jxl.write.Label(9, 12,
            "Werkstoff:");
        sheet3.addCell(labelEHG17);
        jxl.write.Label labelEHAK17 = new jxl.write.Label(10, 12,
            f.anlkost.ws3, nf1cell);

        jxl.write.Label labelEHG18 = new jxl.write.Label(9, 13,
            "Steuerung::");
        sheet3.addCell(labelEHG18);
        sheet3.addCell(labelEHAK17);
        jxl.write.Label labelEHAK18 = new jxl.write.Label(10, 13,
            f.anlkost.st3, nf1cell);
        sheet3.addCell(labelEHAK18);

        jxl.write.Label labelEHG19 = new jxl.write.Label(9, 14,
            "Wassermengenzähler:");
        sheet3.addCell(labelEHG19);
        jxl.write.Label numberEHAK19 = new jxl.write.Label(10, 14,
            f.anlkost.wz3, nf1cell);
        sheet3.addCell(numberEHAK19);

        jxl.write.Label labelEHG20 = new jxl.write.Label(9, 15,
            "Richtpreis einschl. Montage:");
        sheet3.addCell(labelEHG20);
        jxl.write.Number numberEHAK20 = new jxl.write.Number(10, 15,
            f.anlkost.aP3, nf1cell);
        sheet3.addCell(numberEHAK20);

        jxl.write.Label labelEHG21 = new jxl.write.Label(9, 16,
            "Systemtrenner und Feinfilter:");
        sheet3.addCell(labelEHG21);
        jxl.write.Number numberEHAK21 = new jxl.write.Number(10, 16,
            f.anlkost.stffP, nf1cell);
        sheet3.addCell(numberEHAK21);

        jxl.write.Label labelEHG22 = new jxl.write.Label(9, 18,
            "Gesamtanlagenpreis:");
        sheet3.addCell(labelEHG22);
        jxl.write.Number numberEHAK22 = new jxl.write.Number(10, 18,
            f.anlkost.summe, nf1cell);
        sheet3.addCell(numberEHAK22);

        jxl.write.Label labelEHG23 = new jxl.write.Label(9, 19,
            "Anlagenkosten/Jahr:");
        sheet3.addCell(labelEHG23);
        jxl.write.Number numberEHAK23 = new jxl.write.Number(10, 19,
            f.anlkost.jahresBetrag, nf1cell);
        sheet3.addCell(numberEHAK23);
//} // Ende der for Schleife
//*************************ENDE ANLAGE ENTHÄRTUNG*******

//ENTCARBONISIERUNG
         f.entcarbonisierung();

//Umlaufwasseranalyse
        jxl.write.Label labelECUW1 = new jxl.write.Label(4, 0,
            f.aufbereitung, nf1cell);
        jxl.write.Number numberECUW2 = new jxl.write.Number(4, 2,
            f.anauml.verSchnitt, nf1cell);
        jxl.write.Number numberECUW3 = new jxl.write.Number(4, 3,
            f.anauml.eindickung, nf1cell);
        jxl.write.Number numberECUW4 = new jxl.write.Number(4, 4, f.anauml.tKT,
            nf1cell);
        jxl.write.Number numberECUW5 = new jxl.write.Number(4, 5, f.anauml.tW,
            nf1cell);
        jxl.write.Number numberECUW6 = new jxl.write.Number(4, 6, f.anauml.lF,
            nf1cell);
        jxl.write.Number numberECUW7 = new jxl.write.Number(4, 7, f.anauml.ca,
            nf1cell);
        jxl.write.Number numberECUW8 = new jxl.write.Number(4, 8, f.anauml.mg,
            nf1cell);
        jxl.write.Number numberECUW9 = new jxl.write.Number(4, 9, f.anauml.na,
            nf1cell);
        jxl.write.Number numberECUW10 = new jxl.write.Number(4, 10, f.anauml.ks,
            nf1cell);
        jxl.write.Number numberECUW11 = new jxl.write.Number(4, 11, f.anauml.cl,
            nf1cell);
        jxl.write.Number numberECUW12 = new jxl.write.Number(4, 12,
            f.anauml.so4,
            nf1cell);
        jxl.write.Number numberECUW13 = new jxl.write.Number(4, 13,
            f.anauml.no3,
            nf1cell);
        jxl.write.Number numberECUW14 = new jxl.write.Number(4, 14,
            f.anauml.pHKTnV, nf1cell);
        jxl.write.Number numberECUW15 = new jxl.write.Number(4, 15,
            f.anauml.pHTKT, nf1cell);
        jxl.write.Number numberECUW16 = new jxl.write.Number(4, 16,
            f.anauml.siTKT, nf1cell);
        jxl.write.Number numberECUW17 = new jxl.write.Number(4, 17,
            f.anauml.pHggWW, nf1cell);
        jxl.write.Number numberECUW18 = new jxl.write.Number(4, 18,
            f.anauml.sIW,
            nf1cell);
        jxl.write.Number numberECUW19 = new jxl.write.Number(4, 19,
            f.anauml.salz,
            nf1cell);
        jxl.write.Number numberECUW20 = new jxl.write.Number(4, 20,
            f.anauml.ionen, nf1cell);
        jxl.write.Number numberECUW21 = new jxl.write.Number(4, 21,
            f.anauml.h2co3, nf1cell);
        jxl.write.Number numberECUW22 = new jxl.write.Number(4, 22,
            f.anauml.hco3,
            nf1cell);
        jxl.write.Number numberECUW23 = new jxl.write.Number(4, 23,
            f.anauml.co3,
            nf1cell);

        sheet4.addCell(labelECUW1);
        sheet4.addCell(numberECUW2);

        sheet4.addCell(numberECUW3);
        sheet4.addCell(numberECUW4);
        sheet4.addCell(numberECUW5);
        sheet4.addCell(numberECUW6);
        sheet4.addCell(numberECUW7);
        sheet4.addCell(numberECUW8);
        sheet4.addCell(numberECUW9);
        sheet4.addCell(numberECUW10);
        sheet4.addCell(numberECUW11);
        sheet4.addCell(numberECUW12);
        sheet4.addCell(numberECUW13);
        sheet4.addCell(numberECUW14);
        sheet4.addCell(numberECUW15);
        sheet4.addCell(numberECUW16);
        sheet4.addCell(numberECUW17);
        sheet4.addCell(numberECUW18);
        sheet4.addCell(numberECUW19);
        sheet4.addCell(numberECUW20);
        sheet4.addCell(numberECUW21);
        sheet4.addCell(numberECUW22);
        sheet4.addCell(numberECUW23);
//VERBRAUCH

        jxl.write.Number numberECVB1 = new jxl.write.Number(7, 2,
            f.betrkost.enVer, nf1cell);
        jxl.write.Number numberECVB2 = new jxl.write.Number(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        jxl.write.Number numberECVB3 = new jxl.write.Number(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        jxl.write.Number numberECVB4 = new jxl.write.Number(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        jxl.write.Number numberECVB5 = new jxl.write.Number(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        jxl.write.Number numberECVB6 = new jxl.write.Number(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        jxl.write.Number numberECVB7 = new jxl.write.Number(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        jxl.write.Number numberECVB8 = new jxl.write.Number(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        jxl.write.Number numberECVB9 = new jxl.write.Number(7, 10,
            f.betrkost.roVer, nf1cell);
        sheet4.addCell(numberECVB1);
        sheet4.addCell(numberECVB2);
        sheet4.addCell(numberECVB3);
        sheet4.addCell(numberECVB4);
        sheet4.addCell(numberECVB5);
        sheet4.addCell(numberECVB6);
        sheet4.addCell(numberECVB7);
        sheet4.addCell(numberECVB8);
        sheet4.addCell(numberECVB9);

//KOSTEN

        jxl.write.Number numberECKO1 = new jxl.write.Number(7, 13,
            f.betrkost.enKost, nf1cell);
        jxl.write.Number numberECKO2 = new jxl.write.Number(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        jxl.write.Number numberECKO3 = new jxl.write.Number(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        jxl.write.Number numberECKO4 = new jxl.write.Number(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        jxl.write.Number numberECKO5 = new jxl.write.Number(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        jxl.write.Number numberECKO6 = new jxl.write.Number(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        jxl.write.Number numberECKO7 = new jxl.write.Number(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        jxl.write.Number numberECKO8 = new jxl.write.Number(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        jxl.write.Number numberECKO9 = new jxl.write.Number(7, 21,
            f.betrkost.roKost, nf1cell);
        jxl.write.Number numberECKO10 = new jxl.write.Number(7, 22,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
            f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
            f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
            f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
            f.anlkost.jahresBetrag, nf1cell);

        sheet4.addCell(numberECKO1);
        sheet4.addCell(numberECKO2);
        sheet4.addCell(numberECKO3);
        sheet4.addCell(numberECKO4);
        sheet4.addCell(numberECKO5);
        sheet4.addCell(numberECKO6);
        sheet4.addCell(numberECKO7);
        sheet4.addCell(numberECKO8);
        sheet4.addCell(numberECKO9);
        sheet4.addCell(numberECKO10);

//*****ANLAGE ENTCARBONISIERUNG*******




         jxl.write.Label labelECG1 = new jxl.write.Label(9, 0,
             "Anlageinformationen");
        sheet4.addCell(labelECG1);
        jxl.write.Label labelECAK1 = new jxl.write.Label(10, 0,
            f.anlkost.aufbereitungsart, nf1cell);
        sheet4.addCell(labelECAK1);

        jxl.write.Label labelECG2 = new jxl.write.Label(9, 2,
            "Anlage,Typ:");
        sheet4.addCell(labelECG2);
        jxl.write.Label labelECAK2 = new jxl.write.Label(10, 2, f.anlkost.typ1,
            nf1cell);
        sheet4.addCell(labelECAK2);

        jxl.write.Label labelECG3 = new jxl.write.Label(9, 3,
            "Kapazität:");
        sheet4.addCell(labelECG3);
        jxl.write.Number numberECAK3 = new jxl.write.Number(10, 3,
            f.anlkost.kap1, nf1cell);
        sheet4.addCell(numberECAK3);

        jxl.write.Label labelECG4 = new jxl.write.Label(9, 4,
            "Verrohrung:");
        sheet4.addCell(labelECG4);
        jxl.write.Label labelECAK4 = new jxl.write.Label(10, 4,
            f.anlkost.nennweite1, nf1cell);
        sheet4.addCell(labelECAK4);

        jxl.write.Label labelECG5 = new jxl.write.Label(9, 5,
            "Werkstoff:");
        sheet4.addCell(labelECG5);
        jxl.write.Label labelECAK5 = new jxl.write.Label(10, 5, f.anlkost.ws1,
            nf1cell);
        sheet4.addCell(labelECAK5);

        jxl.write.Label labelECG6 = new jxl.write.Label(9, 6,
            "Steuerung:");
        sheet4.addCell(labelECG6);
        jxl.write.Label labelECAK6 = new jxl.write.Label(10, 6, f.anlkost.st1,
            nf1cell);
        sheet4.addCell(labelECAK6);

        jxl.write.Label labelECG7 = new jxl.write.Label(9, 7,
            "Wassermengenzähler:");
        sheet4.addCell(labelECG7);
        jxl.write.Label labelECAK7 = new jxl.write.Label(10, 7, f.anlkost.wz1,
            nf1cell);
        sheet4.addCell(labelECAK7);

        jxl.write.Label labelECG8 = new jxl.write.Label(9, 8,
            "Neutralfilter:");
        sheet4.addCell(labelECG8);
        jxl.write.Label labelECAK8 = new jxl.write.Label(10, 8, f.anlkost.nf,
            nf1cell);
        sheet4.addCell(labelECAK8);

        jxl.write.Label labelECG9 = new jxl.write.Label(9, 9,
            "Richtpreis einschl. Montage:");
        sheet4.addCell(labelECG9);
        jxl.write.Number numberECAK9 = new jxl.write.Number(10, 9,
            f.anlkost.aP1, nf1cell);
        sheet4.addCell(numberECAK9);
        //
        //

        jxl.write.Label labelECG15 = new jxl.write.Label(9, 11,
            "Anlage,Typ:");
        sheet4.addCell(labelECG15);
        jxl.write.Label labelECAK15 = new jxl.write.Label(10, 11,
            f.anlkost.typ3, nf1cell);
        sheet4.addCell(labelECAK15);

        jxl.write.Label labelECG16 = new jxl.write.Label(9, 12,
            "Dosier und Schutzbehälter:");
        sheet4.addCell(labelECG16);
        jxl.write.Label labelECAK16 = new jxl.write.Label(10, 12,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        sheet4.addCell(labelECAK16);

        jxl.write.Label labelECG17 = new jxl.write.Label(9, 13,
            "Werkstoff:");
        sheet4.addCell(labelECG17);
        jxl.write.Label labelECAK17 = new jxl.write.Label(10, 13,
            f.anlkost.ws3, nf1cell);

        jxl.write.Label labelECG18 = new jxl.write.Label(9, 14,
            "Steuerung::");
        sheet4.addCell(labelECG18);
        sheet4.addCell(labelECAK17);
        jxl.write.Label labelECAK18 = new jxl.write.Label(10, 14,
            f.anlkost.st3, nf1cell);
        sheet4.addCell(labelECAK18);

        jxl.write.Label labelECG19 = new jxl.write.Label(9, 15,
            "Wassermengenzähler:");
        sheet4.addCell(labelECG19);
        jxl.write.Label numberECAK19 = new jxl.write.Label(10, 15,
            f.anlkost.wz3, nf1cell);
        sheet4.addCell(numberECAK19);

        jxl.write.Label labelECG20 = new jxl.write.Label(9, 16,
            "Richtpreis einschl. Montage:");
        sheet4.addCell(labelECG20);
        jxl.write.Number numberECAK20 = new jxl.write.Number(10, 16,
            f.anlkost.aP3, nf1cell);
        sheet4.addCell(numberECAK20);

        jxl.write.Label labelECG21 = new jxl.write.Label(9, 17,
            "Systemtrenner und Feinfilter:");
        sheet4.addCell(labelECG21);
        jxl.write.Number numberECAK21 = new jxl.write.Number(10, 17,
            f.anlkost.stffP, nf1cell);
        sheet4.addCell(numberECAK21);

        jxl.write.Label labelECG22 = new jxl.write.Label(9, 19,
            "Gesamtanlagenpreis:");
        sheet4.addCell(labelECG22);
        jxl.write.Number numberECAK22 = new jxl.write.Number(10, 19,
            f.anlkost.summe, nf1cell);
        sheet4.addCell(numberECAK22);

        jxl.write.Label labelECG23 = new jxl.write.Label(9, 20,
            "Anlagenkosten/Jahr:");
        sheet4.addCell(labelECG23);
        jxl.write.Number numberECAK23 = new jxl.write.Number(10, 20,
            f.anlkost.jahresBetrag, nf1cell);
        sheet4.addCell(numberECAK23);
//************************************
//UMKEHROSMOSE OHNE ENTHÄRTUNG
         f.umkehrosmoseo();

//Umlaufwasseranalyse
        jxl.write.Label labelUOOUW1 = new jxl.write.Label(4, 0,
            f.aufbereitung, nf1cell);
        jxl.write.Number numberUOOUW2 = new jxl.write.Number(4, 2,
            f.anauml.verSchnitt, nf1cell);
        jxl.write.Number numberUOOUW3 = new jxl.write.Number(4, 3,
            f.anauml.eindickung, nf1cell);
        jxl.write.Number numberUOOUW4 = new jxl.write.Number(4, 4, f.anauml.tKT,
            nf1cell);
        jxl.write.Number numberUOOUW5 = new jxl.write.Number(4, 5, f.anauml.tW,
            nf1cell);
        jxl.write.Number numberUOOUW6 = new jxl.write.Number(4, 6, f.anauml.lF,
            nf1cell);
        jxl.write.Number numberUOOUW7 = new jxl.write.Number(4, 7, f.anauml.ca,
            nf1cell);
        jxl.write.Number numberUOOUW8 = new jxl.write.Number(4, 8, f.anauml.mg,
            nf1cell);
        jxl.write.Number numberUOOUW9 = new jxl.write.Number(4, 9, f.anauml.na,
            nf1cell);
        jxl.write.Number numberUOOUW10 = new jxl.write.Number(4, 10,
            f.anauml.ks,
            nf1cell);
        jxl.write.Number numberUOOUW11 = new jxl.write.Number(4, 11,
            f.anauml.cl,
            nf1cell);
        jxl.write.Number numberUOOUW12 = new jxl.write.Number(4, 12,
            f.anauml.so4,
            nf1cell);
        jxl.write.Number numberUOOUW13 = new jxl.write.Number(4, 13,
            f.anauml.no3,
            nf1cell);
        jxl.write.Number numberUOOUW14 = new jxl.write.Number(4, 14,
            f.anauml.pHKTnV, nf1cell);
        jxl.write.Number numberUOOUW15 = new jxl.write.Number(4, 15,
            f.anauml.pHTKT, nf1cell);
        jxl.write.Number numberUOOUW16 = new jxl.write.Number(4, 16,
            f.anauml.siTKT, nf1cell);
        jxl.write.Number numberUOOUW17 = new jxl.write.Number(4, 17,
            f.anauml.pHggWW, nf1cell);
        jxl.write.Number numberUOOUW18 = new jxl.write.Number(4, 18,
            f.anauml.sIW,
            nf1cell);
        jxl.write.Number numberUOOUW19 = new jxl.write.Number(4, 19,
            f.anauml.salz,
            nf1cell);
        jxl.write.Number numberUOOUW20 = new jxl.write.Number(4, 20,
            f.anauml.ionen, nf1cell);
        jxl.write.Number numberUOOUW21 = new jxl.write.Number(4, 21,
            f.anauml.h2co3, nf1cell);
        jxl.write.Number numberUOOUW22 = new jxl.write.Number(4, 22,
            f.anauml.hco3,
            nf1cell);
        jxl.write.Number numberUOOUW23 = new jxl.write.Number(4, 23,
            f.anauml.co3,
            nf1cell);
        sheet5.addCell(labelUOOUW1);
        sheet5.addCell(numberUOOUW2);
        sheet5.addCell(numberUOOUW3);
        sheet5.addCell(numberUOOUW4);
        sheet5.addCell(numberUOOUW5);
        sheet5.addCell(numberUOOUW6);
        sheet5.addCell(numberUOOUW7);
        sheet5.addCell(numberUOOUW8);
        sheet5.addCell(numberUOOUW9);
        sheet5.addCell(numberUOOUW10);
        sheet5.addCell(numberUOOUW11);
        sheet5.addCell(numberUOOUW12);
        sheet5.addCell(numberUOOUW13);
        sheet5.addCell(numberUOOUW14);
        sheet5.addCell(numberUOOUW15);
        sheet5.addCell(numberUOOUW16);
        sheet5.addCell(numberUOOUW17);
        sheet5.addCell(numberUOOUW18);
        sheet5.addCell(numberUOOUW19);
        sheet5.addCell(numberUOOUW20);
        sheet5.addCell(numberUOOUW21);
        sheet5.addCell(numberUOOUW22);
        sheet5.addCell(numberUOOUW23);
//VERBRAUCH

        jxl.write.Number numberUOOVB1 = new jxl.write.Number(7, 2,
            f.betrkost.enVer, nf1cell);
        jxl.write.Number numberUOOVB2 = new jxl.write.Number(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        jxl.write.Number numberUOOVB3 = new jxl.write.Number(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        jxl.write.Number numberUOOVB4 = new jxl.write.Number(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        jxl.write.Number numberUOOVB5 = new jxl.write.Number(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        jxl.write.Number numberUOOVB6 = new jxl.write.Number(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        jxl.write.Number numberUOOVB7 = new jxl.write.Number(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        jxl.write.Number numberUOOVB8 = new jxl.write.Number(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        jxl.write.Number numberUOOVB9 = new jxl.write.Number(7, 10,
            f.betrkost.roVer, nf1cell);

        sheet5.addCell(numberUOOVB1);
        sheet5.addCell(numberUOOVB2);
        sheet5.addCell(numberUOOVB3);
        sheet5.addCell(numberUOOVB4);
        sheet5.addCell(numberUOOVB5);
        sheet5.addCell(numberUOOVB6);
        sheet5.addCell(numberUOOVB7);
        sheet5.addCell(numberUOOVB8);
        sheet5.addCell(numberUOOVB9);

//KOSTEN

        jxl.write.Number numberUOOKO1 = new jxl.write.Number(7, 13,
            f.betrkost.enKost, nf1cell);
        jxl.write.Number numberUOOKO2 = new jxl.write.Number(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        jxl.write.Number numberUOOKO3 = new jxl.write.Number(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        jxl.write.Number numberUOOKO4 = new jxl.write.Number(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        jxl.write.Number numberUOOKO5 = new jxl.write.Number(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        jxl.write.Number numberUOOKO6 = new jxl.write.Number(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        jxl.write.Number numberUOOKO7 = new jxl.write.Number(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        jxl.write.Number numberUOOKO8 = new jxl.write.Number(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        jxl.write.Number numberUOOKO9 = new jxl.write.Number(7, 21,
            f.betrkost.roKost, nf1cell);
        jxl.write.Number numberUOOKO10 = new jxl.write.Number(7, 22,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
             f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
             f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
             f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
             f.anlkost.jahresBetrag, nf1cell);

        sheet5.addCell(numberUOOKO1);
        sheet5.addCell(numberUOOKO2);
        sheet5.addCell(numberUOOKO3);
        sheet5.addCell(numberUOOKO4);
        sheet5.addCell(numberUOOKO5);
        sheet5.addCell(numberUOOKO6);
        sheet5.addCell(numberUOOKO7);
        sheet5.addCell(numberUOOKO8);
        sheet5.addCell(numberUOOKO9);
        sheet5.addCell(numberUOOKO10);

//UMKEHROSMOSE OHNE ENTHÄRTUNG*******************************
        //ANLAGE


        jxl.write.Label labelUOOG1 = new jxl.write.Label(9, 0,
            "Anlageinformationen");
        sheet5.addCell(labelUOOG1);
        jxl.write.Label labelUOOAK1 = new jxl.write.Label(10, 0,
            f.anlkost.aufbereitungsart, nf1cell);
        sheet5.addCell(labelUOOAK1);

        jxl.write.Label labelUOOG10 = new jxl.write.Label(9, 2,
            "Anlage,Typ:");
        sheet5.addCell(labelUOOG10);
        jxl.write.Label labelUOOAK10 = new jxl.write.Label(10, 2,
            f.anlkost.typ2, nf1cell);
        sheet5.addCell(labelUOOAK10);

        jxl.write.Label labelUOOG11 = new jxl.write.Label(9, 3,
            "Leistung:");
        sheet5.addCell(labelUOOG11);
        jxl.write.Number numberUOOAK11 = new jxl.write.Number(10, 3,
            f.anlkost.kap2, nf1cell);
        sheet5.addCell(numberUOOAK11);

        jxl.write.Label labelUOOG12 = new jxl.write.Label(9, 4,
            "Verrohrung:");
        sheet5.addCell(labelUOOG12);
        jxl.write.Label labelUOOAK12 = new jxl.write.Label(10, 4,
            f.anlkost.ws2, nf1cell);
        sheet5.addCell(labelUOOAK12);

        jxl.write.Label labelUOOG13 = new jxl.write.Label(9, 5,
            "Steuerung:");
        sheet5.addCell(labelUOOG13);
        jxl.write.Label labelUOOAK13 = new jxl.write.Label(10, 5,
            f.anlkost.st2, nf1cell);
        sheet5.addCell(labelUOOAK13);

        jxl.write.Label labelUOOG14 = new jxl.write.Label(9, 6,
            "Richtpreis einschl. Montage::");
        sheet5.addCell(labelUOOG14);
        jxl.write.Number numberUOOAK14 = new jxl.write.Number(10, 6,
            f.anlkost.aP2, nf1cell);
        sheet5.addCell(numberUOOAK14);

        jxl.write.Label labelUOOG15 = new jxl.write.Label(9, 8,
            "Anlage,Typ:");
        sheet5.addCell(labelUOOG15);
        jxl.write.Label labelUOOAK15 = new jxl.write.Label(10, 8,
            f.anlkost.typ3, nf1cell);
        sheet5.addCell(labelUOOAK15);

        jxl.write.Label labelUOOG16 = new jxl.write.Label(9, 9,
            "Dosier und Schutzbehälter:");
        sheet5.addCell(labelUOOG16);
        jxl.write.Label labelUOOAK16 = new jxl.write.Label(10, 9,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        sheet5.addCell(labelUOOAK16);

        jxl.write.Label labelUOOG17 = new jxl.write.Label(9, 10,
            "Werkstoff:");
        sheet5.addCell(labelUOOG17);
        jxl.write.Label labelUOOAK17 = new jxl.write.Label(10, 10,
            f.anlkost.ws3, nf1cell);

        jxl.write.Label labelUOOG18 = new jxl.write.Label(9, 11,
            "Steuerung::");
        sheet5.addCell(labelUOOG18);
        sheet5.addCell(labelUOOAK17);
        jxl.write.Label labelUOOAK18 = new jxl.write.Label(10, 11,
            f.anlkost.st3, nf1cell);
        sheet5.addCell(labelUOOAK18);

        jxl.write.Label labelUOOG19 = new jxl.write.Label(9, 12,
            "Wassermengenzähler:");
        sheet5.addCell(labelUOOG19);
        jxl.write.Label numberUOOAK19 = new jxl.write.Label(10, 12,
            f.anlkost.wz3, nf1cell);
        sheet5.addCell(numberUOOAK19);

        jxl.write.Label labelUOOG20 = new jxl.write.Label(9, 13,
            "Richtpreis einschl. Montage:");
        sheet5.addCell(labelUOOG20);
        jxl.write.Number numberUOOAK20 = new jxl.write.Number(10, 13,
            f.anlkost.aP3, nf1cell);
        sheet5.addCell(numberUOOAK20);

        jxl.write.Label labelUOOG21 = new jxl.write.Label(9, 14,
            "Systemtrenner und Feinfilter:");
        sheet5.addCell(labelUOOG21);
        jxl.write.Number numberUOOAK21 = new jxl.write.Number(10, 14,
            f.anlkost.stffP, nf1cell);
        sheet5.addCell(numberUOOAK21);

        jxl.write.Label labelUOOG22 = new jxl.write.Label(9, 16,
            "Gesamtanlagenpreis:");
        sheet5.addCell(labelUOOG22);
        jxl.write.Number numberUOOAK22 = new jxl.write.Number(10, 16,
            f.anlkost.summe, nf1cell);
        sheet5.addCell(numberUOOAK22);

        jxl.write.Label labelUOOG23 = new jxl.write.Label(9, 17,
            "Anlagenkosten/Jahr:");
        sheet5.addCell(labelUOOG23);
        jxl.write.Number numberUOOAK23 = new jxl.write.Number(10, 17,
            f.anlkost.jahresBetrag, nf1cell);
        sheet5.addCell(numberUOOAK23);
        //} // Ende der for Schleife

        // ************************************************
//UMKEHROSMOSE MIT ENTHÄRTUNG
        f.umkehrosmosem();

//Umlaufwasseranalyse
        jxl.write.Label labelUOMUW1 = new jxl.write.Label(4, 0,
            f.aufbereitung, nf1cell);
        jxl.write.Number numberUOMUW2 = new jxl.write.Number(4, 2,
            f.anauml.verSchnitt, nf1cell);
        jxl.write.Number numberUOMUW3 = new jxl.write.Number(4, 3,
            f.anauml.eindickung, nf1cell);
        jxl.write.Number numberUOMUW4 = new jxl.write.Number(4, 4, f.anauml.tKT,
            nf1cell);
        jxl.write.Number numberUOMUW5 = new jxl.write.Number(4, 5, f.anauml.tW,
            nf1cell);
        jxl.write.Number numberUOMUW6 = new jxl.write.Number(4, 6, f.anauml.lF,
            nf1cell);
        jxl.write.Number numberUOMUW7 = new jxl.write.Number(4, 7, f.anauml.ca,
            nf1cell);
        jxl.write.Number numberUOMUW8 = new jxl.write.Number(4, 8, f.anauml.mg,
            nf1cell);
        jxl.write.Number numberUOMUW9 = new jxl.write.Number(4, 9, f.anauml.na,
            nf1cell);
        jxl.write.Number numberUOMUW10 = new jxl.write.Number(4, 10,
            f.anauml.ks,
            nf1cell);
        jxl.write.Number numberUOMUW11 = new jxl.write.Number(4, 11,
            f.anauml.cl,
            nf1cell);
        jxl.write.Number numberUOMUW12 = new jxl.write.Number(4, 12,
            f.anauml.so4,
            nf1cell);
        jxl.write.Number numberUOMUW13 = new jxl.write.Number(4, 13,
            f.anauml.no3,
            nf1cell);
        jxl.write.Number numberUOMUW14 = new jxl.write.Number(4, 14,
            f.anauml.pHKTnV, nf1cell);
        jxl.write.Number numberUOMUW15 = new jxl.write.Number(4, 15,
            f.anauml.pHTKT, nf1cell);
        jxl.write.Number numberUOMUW16 = new jxl.write.Number(4, 16,
            f.anauml.siTKT, nf1cell);
        jxl.write.Number numberUOMUW17 = new jxl.write.Number(4, 17,
            f.anauml.pHggWW, nf1cell);
        jxl.write.Number numberUOMUW18 = new jxl.write.Number(4, 18,
            f.anauml.sIW,
            nf1cell);
        jxl.write.Number numberUOMUW19 = new jxl.write.Number(4, 19,
            f.anauml.salz,
            nf1cell);
        jxl.write.Number numberUOMUW20 = new jxl.write.Number(4, 20,
            f.anauml.ionen, nf1cell);
        jxl.write.Number numberUOMUW21 = new jxl.write.Number(4, 21,
            f.anauml.h2co3, nf1cell);
        jxl.write.Number numberUOMUW22 = new jxl.write.Number(4, 22,
            f.anauml.hco3,
            nf1cell);
        jxl.write.Number numberUOMUW23 = new jxl.write.Number(4, 23,
            f.anauml.co3,
            nf1cell);

        sheet6.addCell(labelUOMUW1);
        sheet6.addCell(numberUOMUW2);
        sheet6.addCell(numberUOMUW3);
        sheet6.addCell(numberUOMUW4);
        sheet6.addCell(numberUOMUW5);
        sheet6.addCell(numberUOMUW6);
        sheet6.addCell(numberUOMUW7);
        sheet6.addCell(numberUOMUW8);
        sheet6.addCell(numberUOMUW9);
        sheet6.addCell(numberUOMUW10);
        sheet6.addCell(numberUOMUW11);
        sheet6.addCell(numberUOMUW12);
        sheet6.addCell(numberUOMUW13);
        sheet6.addCell(numberUOMUW14);
        sheet6.addCell(numberUOMUW15);
        sheet6.addCell(numberUOMUW16);
        sheet6.addCell(numberUOMUW17);
        sheet6.addCell(numberUOMUW18);
        sheet6.addCell(numberUOMUW19);
        sheet6.addCell(numberUOMUW20);
        sheet6.addCell(numberUOMUW21);
        sheet6.addCell(numberUOMUW22);
        sheet6.addCell(numberUOMUW23);
//VERBRAUCH

        jxl.write.Number numberUOMVB1 = new jxl.write.Number(7, 2,
            f.betrkost.enVer, nf1cell);
        jxl.write.Number numberUOMVB2 = new jxl.write.Number(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        jxl.write.Number numberUOMVB3 = new jxl.write.Number(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        jxl.write.Number numberUOMVB4 = new jxl.write.Number(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        jxl.write.Number numberUOMVB5 = new jxl.write.Number(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        jxl.write.Number numberUOMVB6 = new jxl.write.Number(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        jxl.write.Number numberUOMVB7 = new jxl.write.Number(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        jxl.write.Number numberUOMVB8 = new jxl.write.Number(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        jxl.write.Number numberUOMVB9 = new jxl.write.Number(7, 10,
            f.betrkost.roVer, nf1cell);

        sheet6.addCell(numberUOMVB1);
        sheet6.addCell(numberUOMVB2);
        sheet6.addCell(numberUOMVB3);
        sheet6.addCell(numberUOMVB4);
        sheet6.addCell(numberUOMVB5);
        sheet6.addCell(numberUOMVB6);
        sheet6.addCell(numberUOMVB7);
        sheet6.addCell(numberUOMVB8);
        sheet6.addCell(numberUOMVB9);

//KOSTEN

        jxl.write.Number numberUOMKO1 = new jxl.write.Number(7, 13,
            f.betrkost.enKost, nf1cell);
        jxl.write.Number numberUOMKO2 = new jxl.write.Number(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        jxl.write.Number numberUOMKO3 = new jxl.write.Number(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        jxl.write.Number numberUOMKO4 = new jxl.write.Number(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        jxl.write.Number numberUOMKO5 = new jxl.write.Number(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        jxl.write.Number numberUOMKO6 = new jxl.write.Number(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        jxl.write.Number numberUOMKO7 = new jxl.write.Number(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        jxl.write.Number numberUOMKO8 = new jxl.write.Number(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        jxl.write.Number numberUOMKO9 = new jxl.write.Number(7, 21,
            f.betrkost.roKost, nf1cell);
        jxl.write.Number numberUOMKO10 = new jxl.write.Number(7, 22,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
             f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
             f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
             f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
             f.anlkost.jahresBetrag, nf1cell);

        sheet6.addCell(numberUOMKO1);
        sheet6.addCell(numberUOMKO2);
        sheet6.addCell(numberUOMKO3);
        sheet6.addCell(numberUOMKO4);
        sheet6.addCell(numberUOMKO5);
        sheet6.addCell(numberUOMKO6);
        sheet6.addCell(numberUOMKO7);
        sheet6.addCell(numberUOMKO8);
        sheet6.addCell(numberUOMKO9);
        sheet6.addCell(numberUOMKO10);

        //*********ANLAGE UMKEHROSMOSE MIT ENTHÄRTUNG****************


         jxl.write.Label labelUOMG1 = new jxl.write.Label(9, 0,
             "Anlageinformation für Aufbereitungsart:");
        sheet6.addCell(labelUOMG1);
        jxl.write.Label labelUOMAK1 = new jxl.write.Label(10, 0,
            f.anlkost.aufbereitungsart, nf1cell);
        sheet6.addCell(labelUOMAK1);

        jxl.write.Label labelUOMG2 = new jxl.write.Label(9, 2,
            "Anlage,Typ:");
        sheet6.addCell(labelUOMG2);
        jxl.write.Label labelUOMAK2 = new jxl.write.Label(10, 2, f.anlkost.typ1,
            nf1cell);
        sheet6.addCell(labelUOMAK2);

        jxl.write.Label labelUOMG3 = new jxl.write.Label(9, 3,
            "Kapazität:");
        sheet6.addCell(labelUOMG3);
        jxl.write.Number numberlUOMAK3 = new jxl.write.Number(10, 3,
            f.anlkost.kap1, nf1cell);
        sheet6.addCell(numberlUOMAK3);

        jxl.write.Label labelUOMG4 = new jxl.write.Label(9, 4,
            "Verrohrung:");
        sheet6.addCell(labelUOMG4);
        jxl.write.Label labelUOMAK4 = new jxl.write.Label(10, 4,
            f.anlkost.nennweite1, nf1cell);
        sheet6.addCell(labelUOMAK4);

        jxl.write.Label labelUOMG5 = new jxl.write.Label(9, 5,
            "Werkstoff:");
        sheet6.addCell(labelUOMG5);
        jxl.write.Label labelUOMAK5 = new jxl.write.Label(10, 5, f.anlkost.ws1,
            nf1cell);
        sheet6.addCell(labelUOMAK5);

        jxl.write.Label labelUOMG6 = new jxl.write.Label(9, 6,
            "Steuerung:");
        sheet6.addCell(labelUOMG6);
        jxl.write.Label labelUOMAK6 = new jxl.write.Label(10, 6, f.anlkost.st1,
            nf1cell);
        sheet6.addCell(labelUOMAK6);

        jxl.write.Label labelUOMG7 = new jxl.write.Label(9, 7,
            "Wassermengenzähler:");
        sheet6.addCell(labelUOMG7);
        jxl.write.Label labelUOMAK7 = new jxl.write.Label(10, 7, f.anlkost.wz1,
            nf1cell);
        sheet6.addCell(labelUOMAK7);

        jxl.write.Label labelUOMG9 = new jxl.write.Label(9, 8,
            "Richtpreis einschl. Montage:");
        sheet6.addCell(labelUOMG9);
        jxl.write.Number numberlUOMAK9 = new jxl.write.Number(10, 8,
            f.anlkost.aP1, nf1cell);
        sheet6.addCell(numberlUOMAK9);
        //
        //

        jxl.write.Label labelUOMG10 = new jxl.write.Label(9, 10,
            "Anlage,Typ:");
        sheet6.addCell(labelUOMG10);
        jxl.write.Label labelUOMAK10 = new jxl.write.Label(10, 10,
            f.anlkost.typ2, nf1cell);
        sheet6.addCell(labelUOMAK10);

        jxl.write.Label labelUOMG11 = new jxl.write.Label(9, 11,
            "Leistung:");
        sheet6.addCell(labelUOMG11);
        jxl.write.Number numberlUOMAK11 = new jxl.write.Number(10, 11,
            f.anlkost.kap2, nf1cell);
        sheet6.addCell(numberlUOMAK11);

        jxl.write.Label labelUOMG12 = new jxl.write.Label(9, 12,
            "Verrohrung:");
        sheet6.addCell(labelUOMG12);
        jxl.write.Label labelUOMAK12 = new jxl.write.Label(10, 12,
            f.anlkost.ws2, nf1cell);
        sheet6.addCell(labelUOMAK12);

        jxl.write.Label labelUOMG13 = new jxl.write.Label(9, 13,
            "Steuerung:");
        sheet6.addCell(labelUOMG13);
        jxl.write.Label labelUOMAK13 = new jxl.write.Label(10, 13,
            f.anlkost.st2, nf1cell);
        sheet6.addCell(labelUOMAK13);

        /*jxl.write.Label labelUOMG14 = new jxl.write.Label(13, 0,
                   "Dosierstation:");
                   sheet6.addCell(labelUOMG14);

                   jxl.write.Label labelUOMG15 = new jxl.write.Label(14, 0,
                   "Dosierstation:");
                   sheet6.addCell(labelUOMG15);
         */
        jxl.write.Label labelUOMG14 = new jxl.write.Label(9, 14,
            "Richtpreis einschl. Montage::");
        sheet6.addCell(labelUOMG14);
        jxl.write.Number numberlUOMAK14 = new jxl.write.Number(10, 14,
            f.anlkost.aP2, nf1cell);
        sheet6.addCell(numberlUOMAK14);

        jxl.write.Label labelUOMG15 = new jxl.write.Label(9, 16,
            "Anlage,Typ:");
        sheet6.addCell(labelUOMG15);
        jxl.write.Label labelUOMAK15 = new jxl.write.Label(10, 16,
            f.anlkost.typ3, nf1cell);
        sheet6.addCell(labelUOMAK15);

        jxl.write.Label labelUOMG16 = new jxl.write.Label(9, 17,
            "Dosier und Schutzbehälter:");
        sheet6.addCell(labelUOMG16);
        jxl.write.Label labelUOMAK16 = new jxl.write.Label(10, 17,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        sheet6.addCell(labelUOMAK16);

        jxl.write.Label labelUOMG17 = new jxl.write.Label(9, 18,
            "Werkstoff:");
        sheet6.addCell(labelUOMG17);
        jxl.write.Label labelUOMAK17 = new jxl.write.Label(10, 18,
            f.anlkost.ws3, nf1cell);

        jxl.write.Label labelUOMG18 = new jxl.write.Label(9, 19,
            "Steuerung::");
        sheet6.addCell(labelUOMG18);
        sheet6.addCell(labelUOMAK17);
        jxl.write.Label labelUOMAK18 = new jxl.write.Label(10, 19,
            f.anlkost.st3, nf1cell);
        sheet6.addCell(labelUOMAK18);

        jxl.write.Label labelUOMG19 = new jxl.write.Label(9, 20,
            "Wassermengenzähler:");
        sheet6.addCell(labelUOMG19);
        jxl.write.Label numberlUOMAK19 = new jxl.write.Label(10, 20,
            f.anlkost.wz3, nf1cell);
        sheet6.addCell(numberlUOMAK19);

        jxl.write.Label labelUOMG20 = new jxl.write.Label(9, 21,
            "Richtpreis einschl. Montage:");
        sheet6.addCell(labelUOMG20);
        jxl.write.Number numberlUOMAK20 = new jxl.write.Number(10, 21,
            f.anlkost.aP3, nf1cell);
        sheet6.addCell(numberlUOMAK20);

        jxl.write.Label labelUOMG21 = new jxl.write.Label(9, 22,
            "Systemtrenner und Feinfilter:");
        sheet6.addCell(labelUOMG21);
        jxl.write.Number numberlUOMAK21 = new jxl.write.Number(10, 22,
            f.anlkost.stffP, nf1cell);
        sheet6.addCell(numberlUOMAK21);

        jxl.write.Label labelUOMG22 = new jxl.write.Label(9, 24,
            "Gesamtanlagenpreis:");
        sheet6.addCell(labelUOMG22);
        jxl.write.Number numberlUOMAK22 = new jxl.write.Number(10, 24,
            f.anlkost.summe, nf1cell);
        sheet6.addCell(numberlUOMAK22);

        jxl.write.Label labelUOMG23 = new jxl.write.Label(9, 25,
            "Anlagenkosten/Jahr:");
        sheet6.addCell(labelUOMG23);
        jxl.write.Number numberlUOMAK23 = new jxl.write.Number(10, 25,
            f.anlkost.jahresBetrag, nf1cell);
        sheet6.addCell(numberlUOMAK23);
        //} // Ende der for Schleife

        //**********************************************************

//SCHWEFELSÄUREDOSIERUNG
         f.schwefelsaeuredos();

//Umlaufwasseranalyse
        jxl.write.Label labelSDUW1 = new jxl.write.Label(4, 0,
            f.aufbereitung, nf1cell);
        jxl.write.Number numberSDUW2 = new jxl.write.Number(4, 2,
            f.anauml.verSchnitt, nf1cell);
        jxl.write.Number numberSDUW3 = new jxl.write.Number(4, 3,
            f.anauml.eindickung, nf1cell);
        jxl.write.Number numberSDUW4 = new jxl.write.Number(4, 4, f.anauml.tKT,
            nf1cell);
        jxl.write.Number numberSDUW5 = new jxl.write.Number(4, 5, f.anauml.tW,
            nf1cell);
        jxl.write.Number numberSDUW6 = new jxl.write.Number(4, 6, f.anauml.lF,
            nf1cell);
        jxl.write.Number numberSDUW7 = new jxl.write.Number(4, 7, f.anauml.ca,
            nf1cell);
        jxl.write.Number numberSDUW8 = new jxl.write.Number(4, 8, f.anauml.mg,
            nf1cell);
        jxl.write.Number numberSDUW9 = new jxl.write.Number(4, 9, f.anauml.na,
            nf1cell);
        jxl.write.Number numberSDUW10 = new jxl.write.Number(4, 10, f.anauml.ks,
            nf1cell);
        jxl.write.Number numberSDUW11 = new jxl.write.Number(4, 11, f.anauml.cl,
            nf1cell);
        jxl.write.Number numberSDUW12 = new jxl.write.Number(4, 12,
            f.anauml.so4,
            nf1cell);
        jxl.write.Number numberSDUW13 = new jxl.write.Number(4, 13,
            f.anauml.no3,
            nf1cell);
        jxl.write.Number numberSDUW14 = new jxl.write.Number(4, 14,
            f.anauml.pHKTnV, nf1cell);
        jxl.write.Number numberSDUW15 = new jxl.write.Number(4, 15,
            f.anauml.pHTKT, nf1cell);
        jxl.write.Number numberSDUW16 = new jxl.write.Number(4, 16,
            f.anauml.siTKT, nf1cell);
        jxl.write.Number numberSDUW17 = new jxl.write.Number(4, 17,
            f.anauml.pHggWW, nf1cell);
        jxl.write.Number numberSDUW18 = new jxl.write.Number(4, 18,
            f.anauml.sIW,
            nf1cell);
        jxl.write.Number numberSDUW19 = new jxl.write.Number(4, 19,
            f.anauml.salz,
            nf1cell);
        jxl.write.Number numberSDUW20 = new jxl.write.Number(4, 20,
            f.anauml.ionen, nf1cell);
        jxl.write.Number numberSDUW21 = new jxl.write.Number(4, 21,
            f.anauml.h2co3, nf1cell);
        jxl.write.Number numberSDUW22 = new jxl.write.Number(4, 22,
            f.anauml.hco3,
            nf1cell);
        jxl.write.Number numberSDUW23 = new jxl.write.Number(4, 23,
            f.anauml.co3,
            nf1cell);

        sheet7.addCell(labelSDUW1);
        sheet7.addCell(numberSDUW2);

        sheet7.addCell(numberSDUW3);
        sheet7.addCell(numberSDUW4);
        sheet7.addCell(numberSDUW5);
        sheet7.addCell(numberSDUW6);
        sheet7.addCell(numberSDUW7);
        sheet7.addCell(numberSDUW8);
        sheet7.addCell(numberSDUW9);
        sheet7.addCell(numberSDUW10);
        sheet7.addCell(numberSDUW11);
        sheet7.addCell(numberSDUW12);
        sheet7.addCell(numberSDUW13);
        sheet7.addCell(numberSDUW14);
        sheet7.addCell(numberSDUW15);
        sheet7.addCell(numberSDUW16);
        sheet7.addCell(numberSDUW17);
        sheet7.addCell(numberSDUW18);
        sheet7.addCell(numberSDUW19);
        sheet7.addCell(numberSDUW20);
        sheet7.addCell(numberSDUW21);
        sheet7.addCell(numberSDUW22);
        sheet7.addCell(numberSDUW23);
//VERBRAUCH
        jxl.write.Number numberSDVB1 = new jxl.write.Number(7, 2,
            f.betrkost.enVer, nf1cell);
        jxl.write.Number numberSDVB2 = new jxl.write.Number(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        jxl.write.Number numberSDVB3 = new jxl.write.Number(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        jxl.write.Number numberSDVB4 = new jxl.write.Number(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        jxl.write.Number numberSDVB5 = new jxl.write.Number(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        jxl.write.Number numberSDVB6 = new jxl.write.Number(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        jxl.write.Number numberSDVB7 = new jxl.write.Number(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        jxl.write.Number numberSDVB8 = new jxl.write.Number(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        jxl.write.Number numberSDVB9 = new jxl.write.Number(7, 10,
            f.betrkost.roVer, nf1cell);

        sheet7.addCell(numberSDVB1);
        sheet7.addCell(numberSDVB2);
        sheet7.addCell(numberSDVB3);
        sheet7.addCell(numberSDVB4);
        sheet7.addCell(numberSDVB5);
        sheet7.addCell(numberSDVB6);
        sheet7.addCell(numberSDVB7);
        sheet7.addCell(numberSDVB8);
        sheet7.addCell(numberSDVB9);

//KOSTEN

        jxl.write.Number numberSDKO1 = new jxl.write.Number(7, 13,
            f.betrkost.enKost, nf1cell);
        jxl.write.Number numberSDKO2 = new jxl.write.Number(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        jxl.write.Number numberSDKO3 = new jxl.write.Number(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        jxl.write.Number numberSDKO4 = new jxl.write.Number(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        jxl.write.Number numberSDKO5 = new jxl.write.Number(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        jxl.write.Number numberSDKO6 = new jxl.write.Number(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        jxl.write.Number numberSDKO7 = new jxl.write.Number(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        jxl.write.Number numberSDKO8 = new jxl.write.Number(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        jxl.write.Number numberSDKO9 = new jxl.write.Number(7, 21,
            f.betrkost.roKost, nf1cell);
        jxl.write.Number numberSDKO10 = new jxl.write.Number(7, 22,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
            f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
            f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
            f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
            f.anlkost.jahresBetrag, nf1cell);

        sheet7.addCell(numberSDKO1);
        sheet7.addCell(numberSDKO2);
        sheet7.addCell(numberSDKO3);
        sheet7.addCell(numberSDKO4);
        sheet7.addCell(numberSDKO5);
        sheet7.addCell(numberSDKO6);
        sheet7.addCell(numberSDKO7);
        sheet7.addCell(numberSDKO8);
        sheet7.addCell(numberSDKO9);
        sheet7.addCell(numberSDKO10);

//*****************ANLAGE SCHWEFELSÄUREDOSIERUNG**************************
         jxl.write.Label labelSDG1 = new jxl.write.Label(9, 0,
             "Anlageinformationen");
        sheet7.addCell(labelSDG1);
        jxl.write.Label labelSDAK1 = new jxl.write.Label(10, 0,
            f.anlkost.aufbereitungsart, nf1cell);
        sheet7.addCell(labelSDAK1);

        jxl.write.Label labelSDG2 = new jxl.write.Label(9, 2,
            "Anlage,Typ:");
        sheet7.addCell(labelSDG2);
        jxl.write.Label labelSDAK2 = new jxl.write.Label(10, 2, f.anlkost.typ1,
            nf1cell);
        sheet7.addCell(labelSDAK2);

        jxl.write.Label labelSDG3 = new jxl.write.Label(9, 3,
            "Dosier und Schutzbehälter:");
        sheet7.addCell(labelSDG3);
        jxl.write.Label labelSDAK3 = new jxl.write.Label(10, 3,
            "V " + Double.toString(f.anlkost.kap1), nf1cell);
        sheet7.addCell(labelSDAK3);

        jxl.write.Label labelSDG4 = new jxl.write.Label(9, 4,
            "Werkstoff:");
        sheet7.addCell(labelSDG4);
        jxl.write.Label labelSDAK4 = new jxl.write.Label(10, 4, f.anlkost.ws1,
            nf1cell);
        sheet7.addCell(labelSDAK4);

        jxl.write.Label labelSDG5 = new jxl.write.Label(9, 5,
            "Steuerung:");
        sheet7.addCell(labelSDG5);
        jxl.write.Label labelSDAK5 = new jxl.write.Label(10, 5, f.anlkost.st1,
            nf1cell);
        sheet7.addCell(labelSDAK5);

        jxl.write.Label labelSDG6 = new jxl.write.Label(9, 6,
            "Richtpreis einschl. Montage:");
        sheet7.addCell(labelSDG6);
        jxl.write.Number numberSDAK6 = new jxl.write.Number(10, 6,
            f.anlkost.aP1, nf1cell);
        sheet7.addCell(numberSDAK6);

        jxl.write.Label labelSDG15 = new jxl.write.Label(9, 8,
            "Anlage,Typ:");
        sheet7.addCell(labelSDG15);
        jxl.write.Label labelSDAK15 = new jxl.write.Label(10, 8,
            f.anlkost.typ3, nf1cell);
        sheet7.addCell(labelSDAK15);

        jxl.write.Label labelSDG16 = new jxl.write.Label(9, 9,
            "Dosier und Schutzbehälter:");
        sheet7.addCell(labelSDG16);
        jxl.write.Label labelSDAK16 = new jxl.write.Label(10, 9,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        sheet7.addCell(labelSDAK16);

        jxl.write.Label labelSDG17 = new jxl.write.Label(9, 10,
            "Werkstoff:");
        sheet7.addCell(labelSDG17);
        jxl.write.Label labelSDAK17 = new jxl.write.Label(10, 10,
            f.anlkost.ws3, nf1cell);

        jxl.write.Label labelSDG18 = new jxl.write.Label(9, 11,
            "Steuerung::");
        sheet7.addCell(labelSDG18);
        sheet7.addCell(labelSDAK17);
        jxl.write.Label labelSDAK18 = new jxl.write.Label(10, 11,
            f.anlkost.st3, nf1cell);
        sheet7.addCell(labelSDAK18);

        jxl.write.Label labelSDG19 = new jxl.write.Label(9, 12,
            "Wassermengenzähler:");
        sheet7.addCell(labelSDG19);
        jxl.write.Label numberSDAK19 = new jxl.write.Label(10, 12,
            f.anlkost.wz3, nf1cell);
        sheet7.addCell(numberSDAK19);

        jxl.write.Label labelSDG20 = new jxl.write.Label(9, 13,
            "Richtpreis einschl. Montage:");
        sheet7.addCell(labelSDG20);
        jxl.write.Number numberSDAK20 = new jxl.write.Number(10, 13,
            f.anlkost.aP3, nf1cell);
        sheet7.addCell(numberSDAK20);

        jxl.write.Label labelSDG21 = new jxl.write.Label(9, 14,
            "Systemtrenner und Feinfilter:");
        sheet7.addCell(labelSDG21);
        jxl.write.Number numberSDAK21 = new jxl.write.Number(10, 14,
            f.anlkost.stffP, nf1cell);
        sheet7.addCell(numberSDAK21);

        jxl.write.Label labelSDG22 = new jxl.write.Label(9, 16,
            "Gesamtanlagenpreis:");
        sheet7.addCell(labelSDG22);
        jxl.write.Number numberSDAK22 = new jxl.write.Number(10, 16,
            f.anlkost.summe, nf1cell);
        sheet7.addCell(numberSDAK22);

        jxl.write.Label labelSDG23 = new jxl.write.Label(9, 17,
            "Anlagenkosten/Jahr:");
        sheet7.addCell(labelSDG23);
        jxl.write.Number numberSDAK23 = new jxl.write.Number(10, 17,
            f.anlkost.jahresBetrag, nf1cell);
        sheet7.addCell(numberSDAK23);

        //*************************************************


         workbook.write();
        workbook.close();
      }

      catch (jxl.write.WriteException IOE) {
        System.out.println("IO Fehler" + IOE);
      }

    }
    catch (java.io.IOException IOE) {
      System.out.println("IO Fehler" + IOE);
    }

  }

  //

  void laden() {
    passwd pf = new passwd(); //passwortcheck
    //Objekte definieren
    passwd lpf = new passwd();
    projektdatei datei = new projektdatei();
    projektdateiAlt dateiAlt = new projektdateiAlt();
    boolean alt = false;
    f.frei(); //Fesnter Daten löschen
    //FileDialogFenster
    fd.setTitle("Datei laden");
    fd.setDirectory("");
    //fd.setFilenameFilter("*.wkp");
    fd.setFile("*.wkp");
    fd.setMode(FileDialog.LOAD);
    fd.setLocation(positionX(fd.getWidth()), 200);
    fd.show();
    String dateiName = fd.getDirectory() + fd.getFile();

    //laden
    try {
      FileInputStream file = new FileInputStream(dateiName);
      ObjectInputStream in = new ObjectInputStream(file);
      datei = (projektdatei) in.readObject();
      in.close();
      //in.flush();
    }
    catch (java.io.IOException IOE) {
      System.out.println("IO Fehler" + IOE);
      dialogframe meinDialog = new dialogframe(); //warndialog anzeigen
      warndialog Versionskonflikt = new warndialog(meinDialog, "Achtung", true);
      Versionskonflikt.setSize(300, 150);
      Versionskonflikt.setLocation(f.positionX(300), f.positionY(150));
      Versionskonflikt.meldung(
          "Datei kann nicht geöffnet werden. Versionskonflikt.");
      Versionskonflikt.setVisible(true);
      meinDialog.dispose();
      return;
    }
    /*try{
        in.close();
        FileInputStream fileAlt = new FileInputStream(dateiName);
        ObjectInputStream inAlt = new ObjectInputStream(fileAlt);
        dateiAlt = (projektdateiAlt) inAlt.readObject();
        in.close();
        alt = true; //alte analyse gelesen
        }
      catch(java.io.IOException IOE2)
      {
        System.out.println("IO Fehler"+IOE2);

      }
      catch(ClassNotFoundException cne2)
      {
        System.out.println("class Fehler"+cne2);
      }
           }*/
    catch (ClassNotFoundException cne) {
      System.out.println("class Fehler" + cne);

    }

    if (alt) {
      datei = altInNeu(dateiAlt);
    }
    f.anaroh = datei.getAnalyse();
    f.betriebsMittelKosten = datei.getKosten();
    f.bedingungen = datei.getG1();
    f.bedingungen2 = datei.getG2();
    f.textFieldAnalyse.setText(f.anaroh.analysenNummer);
  }

  //
  void speichern() {

  }

  //
  void speichernunter() {
    //Objekte definieren
    projektdatei datei = new projektdatei();

    //FileDialogFenster
    fd.setTitle("Datei speichern unter ...");
    fd.setDirectory("");
    //fd.setFilenameFilter("*.wkp");
    fd.setFile("*.wkp");
    fd.setMode(FileDialog.SAVE);
    fd.setLocation(positionX(fd.getWidth()), 200);
    fd.show();
    String dateiName = fd.getDirectory() + fd.getFile();

    //speichern
    datei.setData(f.anaroh, f.betriebsMittelKosten, f.bedingungen,
                  f.bedingungen2);
    try {
      FileOutputStream file = new FileOutputStream(dateiName);
      ObjectOutputStream in = new ObjectOutputStream(file);
      in.writeObject(datei);
      in.flush();
      file.close(); ;
    }
    catch (java.io.IOException IOE) {
      System.out.println("IO Fehler" + IOE);
    }

  }

  //
  void drucken1() {
    rohReport druckFenster = new rohReport();
    druckFenster.setAnalyse(f.anaroh);
    druckFenster.drucken();
  }

  void drucken2() {
    if (f.banalyseberechnet) { //wenn schon eine Analysenberecnung durchgefuehrt wurde
      if (f.baufbereitung) { //wenn Kuehlturmkreislauf

        umReport druckFenster = new umReport();
        druckFenster.setAnalyse(f.anauml, f.aufbereitung);
        druckFenster.drucken();
      }
      else { //sonst Luftwaescher
        umlwReport druckFenster = new umlwReport();
        druckFenster.setAnalyse(f.anauml, f.aufbereitung);
        druckFenster.drucken();
      }
    }
  }

  //
  void drucken3() {
    if (f.bkostenberechnet) { //wenn schon eine kostenrechnung durchgefuehrt wurde
      if (f.bkosten) {
        if (f.baufbereitung) {
          kostenReport druckKosten = new kostenReport();
          druckKosten.setAnalyse(f.betriebsMittelKosten, f.betrkost, f.anauml,
                                 f.aufbereitung, f.anlkost.jahresBetrag);
          druckKosten.drucken();
        }
        else {
          kostenlwReport druckKosten = new kostenlwReport();
          druckKosten.setAnalyse(f.betriebsMittelKosten, f.betrkost, f.anauml,
                                 f.aufbereitung, f.anlkost.jahresBetrag);
          druckKosten.drucken();
        }
      }
    }
  }

  void drucken4() { //anlagen Report

    anlageReport anlInfo = new anlageReport(f);
    anlInfo.setAnalyse(f.anlkost, f.anauml, f.aufbereitung, f.aufbereitungAnzeige);
    anlInfo.drucken();

  }

  void hilfe() {
    //Runtime.exec(startframe.homeDir + "/../help/index.html");
    try {
      Runtime.getRuntime().exec("cmd.exe " + startframe.homeDir + "index.html");
      //rt.exec(startframe.homeDir + "start index.html");
    }

    catch (java.lang.NullPointerException e) {
      System.out.print(e + startframe.homeDir + "../help/index.html");
    }
    catch (java.io.IOException eo) {
      System.out.print(eo);
    }

  }

  void info() {
    dialogframe frame = new dialogframe();
    infodialog infofenster = new infodialog(frame, "Über Watkost", true);
    infofenster.setSize(400, 300);
    infofenster.setLocation(positionX(400), 150);
    infofenster.setVisible(true);
    frame.dispose();

  }

  //Rückgabe der Position
  int positionX(int x) {
    Point posParent;
    int b, posX;
    posParent = f.getLocation();
    b = f.getSize().width;
    posX = (int) ( (posParent.x + b / 2) - (x / 2));
    return posX;
  }

  void sprachwahl() {
    f.sprache();
  }
  //
  projektdatei altInNeu(projektdateiAlt alteDaten) {
    projektdatei neueDaten = new projektdatei();
    kostenAlt alteKosten = alteDaten.getKosten(); ;
    rohanalyseAlt alteAnalyse = alteDaten.getAnalyse();
    neueDaten.analysendaten.analysenNummer = alteAnalyse.analysenNummer;
    neueDaten.analysendaten.bearbeiter = alteAnalyse.bearbeiter;
    neueDaten.analysendaten.ca = alteAnalyse.ca;
    neueDaten.analysendaten.cl = alteAnalyse.cl;
    neueDaten.analysendaten.co3 = alteAnalyse.co3;
    neueDaten.analysendaten.h2co3 = alteAnalyse.h2co3;
    neueDaten.analysendaten.hco3 = alteAnalyse.hco3;
    neueDaten.analysendaten.i = alteAnalyse.i;
    neueDaten.analysendaten.ks = alteAnalyse.ks;
    neueDaten.analysendaten.kunde = alteAnalyse.kunde;
    neueDaten.analysendaten.lF = alteAnalyse.lF;
    neueDaten.analysendaten.lFBer = alteAnalyse.lFBer;
    neueDaten.analysendaten.mg = alteAnalyse.mg;
    neueDaten.analysendaten.na = alteAnalyse.na;
    neueDaten.analysendaten.no3 = alteAnalyse.no3;
    neueDaten.analysendaten.pHggW = alteAnalyse.pHggW;
    neueDaten.analysendaten.pHtE = alteAnalyse.pHtE;
    neueDaten.analysendaten.plz = "";
    neueDaten.analysendaten.projekt = alteAnalyse.projekt;
    neueDaten.analysendaten.sitE = alteAnalyse.sitE;
    neueDaten.analysendaten.so4 = alteAnalyse.so4;
    neueDaten.analysendaten.stadt = "";
    neueDaten.analysendaten.suA = alteAnalyse.suA;
    neueDaten.analysendaten.suK = alteAnalyse.suK;
    neueDaten.analysendaten.tE = alteAnalyse.tE;
    neueDaten.grenz1 = alteDaten.getG1();
    neueDaten.grenz2 = alteDaten.getG2();
    //jetzt die alten kosten konvertieren
    neueDaten.betriebskosten.abWasser = alteKosten.abWasser;
    neueDaten.betriebskosten.auslastung = alteKosten.auslastung;
    neueDaten.betriebskosten.dosierMenge = alteKosten.dosierMenge;
    neueDaten.betriebskosten.dosierMittel = alteKosten.dosierMittel;
    neueDaten.betriebskosten.energie = alteKosten.energie;
    neueDaten.betriebskosten.leistung = alteKosten.leistung;
    neueDaten.betriebskosten.leistung2 = alteKosten.leistung2;
    neueDaten.betriebskosten.ro = alteKosten.ro;
    neueDaten.betriebskosten.roMenge = alteKosten.roMenge;
    neueDaten.betriebskosten.salzSaeure = alteKosten.salzSaeure;
    neueDaten.betriebskosten.salzTabletten = alteKosten.salzTabletten;
    neueDaten.betriebskosten.schwefelSaeure = alteKosten.schwefelSaeure;
    neueDaten.betriebskosten.stadtWasser = alteKosten.stadtWasser;
    neueDaten.betriebskosten.regenWasser = 0.0;
    return neueDaten;
  }

  void anzeigen()
  {
    try
         {

     m1.setLabel(startframe.Texte.elementAt(1).toString());

        }
      catch (java.lang.NullPointerException IOE) {
       System.out.println("IO Fehler" + IOE);

     }
  }
}
/*//ANLAGE
void anlage()
{
      int i = 0;
      if (f.aufbereitung == "Enthärtung" ||
          f.aufbereitung == "Entcarbonisierung" ||
          f.aufbereitung == "Umkehrosmose m. v. Enthärtung") {
        jxl.write.Label labelG1 = new jxl.write.Label(0, 0,
          "Anlageinformation für Aufbereitungsart:");
       sheet2.addCell(labelG1);
        jxl.write.Label LabelAK1 = new jxl.write.Label(i++, 1,
            f.anlkost.aufbereitungsart, nf1cell);
         sheet7.addCell(LabelAK1);

         jxl.write.Label labelG2 = new jxl.write.Label(i, 0,
          "Anlage,Typ:");
       sheet7.addCell(labelG2);
        jxl.write.Label LabelAK2 = new jxl.write.Label(i++, 1, f.anlkost.typ1,
            nf1cell);
        sheet7.addCell(LabelAK2);

        jxl.write.Label labelG3 = new jxl.write.Label(i, 0,
          "Kapazität:");
       sheet7.addCell(labelG3);
       jxl.write.Number numberAK3 = new jxl.write.Number(i++, 1,
            f.anlkost.kap1, nf1cell);
        sheet7.addCell(numberAK3);

        jxl.write.Label labelG4 = new jxl.write.Label(i, 0,
          "Verrohrung:");
       sheet7.addCell(labelG4);
        jxl.write.Label LabelAK4 = new jxl.write.Label(i++, 1,
            f.anlkost.nennweite1, nf1cell);
        sheet7.addCell(LabelAK4);

        jxl.write.Label labelG5 = new jxl.write.Label(i, 0,
          "Werkstoff:");
       sheet7.addCell(labelG5);
        jxl.write.Label LabelAK5 = new jxl.write.Label(i++, 1, f.anlkost.ws1,
            nf1cell);
        sheet7.addCell(LabelAK5);

        jxl.write.Label labelG6 = new jxl.write.Label(i, 0,
          "Steuerung:");
       sheet7.addCell(labelG6);
        jxl.write.Label LabelAK6 = new jxl.write.Label(i++, 1, f.anlkost.st1,
            nf1cell);
        sheet7.addCell(LabelAK6);

        jxl.write.Label labelG7 = new jxl.write.Label(i, 0,
          "Wassermengenzähler:");
       sheet7.addCell(labelG7);
        jxl.write.Label LabelAK7 = new jxl.write.Label(i++, 1, f.anlkost.wz1,
            nf1cell);
        sheet7.addCell(LabelAK7);


        if (f.anlkost.verfahren == "Entcarbonisierung") {
          jxl.write.Label labelG8 = new jxl.write.Label(i, 0,
          "Neutralfilter:");
       sheet7.addCell(labelG8);
          jxl.write.Label LabelAK8 = new jxl.write.Label(i++, 1, f.anlkost.nf,
              nf1cell);
          sheet7.addCell(LabelAK8);
        }
        jxl.write.Label labelG9 = new jxl.write.Label(i, 0,
           "Richtpreis einschl. Montage:");
        sheet7.addCell(labelG9);
        jxl.write.Number numberAK9 = new jxl.write.Number(i++, 1,
            f.anlkost.aP1, nf1cell);
         sheet7.addCell(numberAK9);
        //
        //
        if (f.aufbereitung == "Umkehrosmose m. v. Enthärtung" ||
            f.aufbereitung == "Umkehrosmose o. v. Enthärtung") {

          jxl.write.Label labelG10 = new jxl.write.Label(i, 0,
          "Anlage,Typ:");
           sheet7.addCell(labelG10);
          jxl.write.Label LabelAK10 = new jxl.write.Label(i++, 1,
              f.anlkost.typ2, nf1cell);
          sheet7.addCell(LabelAK10);

          jxl.write.Label labelG11 = new jxl.write.Label(i, 0,
          "Leistung:");
          sheet7.addCell(labelG11);
          jxl.write.Number numberAK11 = new jxl.write.Number(i++, 1,
              f.anlkost.kap2, nf1cell);
          sheet7.addCell(numberAK11);

          jxl.write.Label labelG12 = new jxl.write.Label(i, 0,
          "Verrohrung:");
          sheet7.addCell(labelG12);
          jxl.write.Label LabelAK12 = new jxl.write.Label(i++, 1,
              f.anlkost.ws2, nf1cell);
          sheet7.addCell(LabelAK12);

          jxl.write.Label labelG13 = new jxl.write.Label(i, 0,
          "Steuerung:");
          sheet7.addCell(labelG13);
          jxl.write.Label LabelAK13 = new jxl.write.Label(i++, 1,
              f.anlkost.st2, nf1cell);
          sheet7.addCell(LabelAK13);


          jxl.write.Label labelG14 = new jxl.write.Label(i, 0,
          "Richtpreis einschl. Montage::");
          sheet7.addCell(labelG14);
          jxl.write.Number NumberAK14 = new jxl.write.Number(i++, 1,
              f.anlkost.aP2, nf1cell);
          sheet7.addCell(NumberAK14);


        }
      }
      if (f.aufbereitung == "Schwefelsäuredosierung")
      {
        jxl.write.Label labelG2 = new jxl.write.Label(i, 0,
          "Anlage,Typ:");
          sheet7.addCell(labelG2);
        jxl.write.Label LabelAK2 = new jxl.write.Label(i++, 1, f.anlkost.typ1,
           nf1cell);
       sheet7.addCell(LabelAK2);

       jxl.write.Label labelG3 = new jxl.write.Label(i, 0,
          "Dosier und Schutzbehälter:");
          sheet7.addCell(labelG3);
       jxl.write.Label labelAK3 = new jxl.write.Label(i++, 1,
           "V " + Double.toString(f.anlkost.kap1), nf1cell);
       sheet7.addCell(labelAK3);

       jxl.write.Label labelG4 = new jxl.write.Label(i, 0,
          "Werkstoff:");
          sheet7.addCell(labelG4);
       jxl.write.Label LabelAK4 = new jxl.write.Label(i++, 1, f.anlkost.ws1,
           nf1cell);
       sheet7.addCell(LabelAK4);

       jxl.write.Label labelG5 = new jxl.write.Label(i, 0,
          "Steuerung:");
          sheet7.addCell(labelG5);
       jxl.write.Label LabelAK5 = new jxl.write.Label(i++, 1, f.anlkost.st1,
           nf1cell);
       sheet7.addCell(LabelAK5);

       jxl.write.Label labelG6 = new jxl.write.Label(i, 0,
          "Richtpreis einschl. Montage:");
          sheet7.addCell(labelG6);
       jxl.write.Number numberAK6 = new jxl.write.Number(i++, 1,
           f.anlkost.aP1, nf1cell);
       sheet7.addCell(numberAK6);
     }

     jxl.write.Label labelG15 = new jxl.write.Label(i, 0,
          "Anlage,Typ:");
          sheet7.addCell(labelG15);
     jxl.write.Label LabelAK15 = new jxl.write.Label(i++, 1,
          f.anlkost.typ3, nf1cell);
     sheet7.addCell(LabelAK15);

     jxl.write.Label labelG16 = new jxl.write.Label(i, 0,
          "Dosier und Schutzbehälter:");
          sheet7.addCell(labelG16);
          jxl.write.Label labelAK16 = new jxl.write.Label(i++, 1,
          "V " + Double.toString(f.anlkost.kap3), nf1cell);
      sheet7.addCell(labelAK16);

      jxl.write.Label labelG17 = new jxl.write.Label(i, 0,
          "Werkstoff:");
          sheet7.addCell(labelG17);
  jxl.write.Label LabelAK17 = new jxl.write.Label(i++, 1,
          f.anlkost.ws3, nf1cell);

jxl.write.Label labelG18 = new jxl.write.Label(i, 0,
          "Steuerung::");
          sheet7.addCell(labelG18);
sheet7.addCell(LabelAK17);
      jxl.write.Label LabelAK18 = new jxl.write.Label(i++, 1,
          f.anlkost.st3, nf1cell);
sheet7.addCell(LabelAK18);

jxl.write.Label labelG19 = new jxl.write.Label(i, 0,
          "Wassermengenzähler:");
          sheet7.addCell(labelG19);
          jxl.write.Label NumberAK19 = new jxl.write.Label(i++, 1,
        f.anlkost.wz3, nf1cell);
        sheet7.addCell(NumberAK19);

      jxl.write.Label labelG20 = new jxl.write.Label(i, 0,
                    "Richtpreis einschl. Montage:");
      sheet7.addCell(labelG20);
      jxl.write.Number NumberAK20 = new jxl.write.Number(i++, 1,
         f.anlkost.aP3, nf1cell);
      sheet7.addCell(NumberAK20);

     jxl.write.Label labelG21 = new jxl.write.Label(i, 0,
          "Systemtrenner und Feinfilter:");
          sheet7.addCell(labelG21);
     jxl.write.Number NumberAK21 = new jxl.write.Number(i++, 1,
         f.anlkost.stffP, nf1cell);
     sheet7.addCell(NumberAK21);

     jxl.write.Label labelG22 = new jxl.write.Label(i, 0,
          "Gesamtanlagenpreis:");
          sheet7.addCell(labelG22);
     jxl.write.Number NumberAK22 = new jxl.write.Number(i++, 1,
         f.anlkost.summe, nf1cell);
    sheet7.addCell(NumberAK22);

    jxl.write.Label labelG23 = new jxl.write.Label(i, 0,
          "Anlagenkosten/Jahr:");
          sheet7.addCell(labelG23);
     jxl.write.Number NumberAK23 = new jxl.write.Number(i++, 1,
         f.anlkost.jahresBetrag, nf1cell);
     sheet7.addCell(NumberAK23);
    //} // Ende der for Schleife

*/
