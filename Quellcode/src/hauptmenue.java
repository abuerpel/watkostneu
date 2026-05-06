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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
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
    fd.setFile("*.xls*");
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
    fd.setFile("*.xlsx");
    fd.setMode(FileDialog.SAVE);
    fd.setLocation(positionX(fd.getWidth()), 200);
    fd.show();
    String dateiName = fd.getDirectory() + fd.getFile();
    if (dateiName != null && !dateiName.toLowerCase().endsWith(".xlsx")
                          && !dateiName.toLowerCase().endsWith(".xls")) {
      dateiName = dateiName + ".xlsx";
    }

    try {
      org.apache.poi.ss.usermodel.Workbook workbook = new XSSFWorkbook();
      Sheet sheet1 = workbook.createSheet("Eingabeparameter");
      Sheet sheet2 = workbook.createSheet("Threshhold Stabilisierung");
      Sheet sheet3 = workbook.createSheet("Enthärtung");
      Sheet sheet4 = workbook.createSheet("Entcarbonisierung");
      Sheet sheet5 = workbook.createSheet("Umkehrosmose o. Eh.");
      Sheet sheet6 = workbook.createSheet("Umkehrosmose m. Eh.");
      Sheet sheet7 = workbook.createSheet("Schwefelsäuredosierung");

      // Format für die Ausgabe der Werte vorgeben
      CellStyle nf1cell = workbook.createCellStyle();
      nf1cell.setDataFormat(workbook.createDataFormat().getFormat("#.00"));

      {
        //rohanalyse
        LabelW labelA1 = new LabelW(0, 0, "Rohwasseranalyse");
        LabelW labelA2 = new LabelW(0, 2, "Analysennummer:");
        LabelW labelA3 = new LabelW(0, 3, "Kunde");
        LabelW labelA4 = new LabelW(0, 4, "Projekt");
        LabelW labelA5 = new LabelW(0, 5, "Bearbeiter");
        LabelW labelA6 = new LabelW(0, 6, "TE°C");
        LabelW labelA7 = new LabelW(0, 7, "pH TE");
        LabelW labelA8 = new LabelW(0, 8, "LF K25");
        LabelW labelA9 = new LabelW(0, 9, "Calcium mg/l");
        LabelW labelA10 = new LabelW(0, 10, "Magnesium mg/l");
        LabelW labelA11 = new LabelW(0, 11, "KS 4,3 mmol/l");
        LabelW labelA12 = new LabelW(0, 12, "Chlorid mg/l");
        LabelW labelA13 = new LabelW(0, 13, "Sulfat mg/l");
        LabelW labelA14 = new LabelW(0, 14, "GGW pH TE");
        LabelW labelA15 = new LabelW(0, 15, "Nitrat mg/l");
        LabelW labelA16 = new LabelW(0, 16, "SI TE");
        LabelW labelA17 = new LabelW(0, 17, "Co2 mg/l");
        LabelW labelA18 = new LabelW(0, 18, "Co3 mg/l");
        LabelW labelA19 = new LabelW(0, 19, "HCo3 mg/l");
        //
        addCell(sheet1, labelA1);
        addCell(sheet1, labelA2);
        addCell(sheet1, labelA3);
        addCell(sheet1, labelA4);
        addCell(sheet1, labelA5);
        addCell(sheet1, labelA6);
        addCell(sheet1, labelA7);
        addCell(sheet1, labelA8);
        addCell(sheet1, labelA9);
        addCell(sheet1, labelA10);
        addCell(sheet1, labelA11);
        addCell(sheet1, labelA12);
        addCell(sheet1, labelA13);
        addCell(sheet1, labelA14);
        addCell(sheet1, labelA15);
        addCell(sheet1, labelA16);
        addCell(sheet1, labelA17);
        addCell(sheet1, labelA18);
        addCell(sheet1, labelA19);

        //Grenzwerte
        LabelW labelB1 = new LabelW(3, 0, "Grenzwerte");
        LabelW labelB2 = new LabelW(3, 2, "Anlage");
        LabelW labelB3 = new LabelW(3, 3, "Eindickungsfaktor");
        LabelW labelB4 = new LabelW(3, 4,
            "max. Sättigungsindex ");
        LabelW labelB5 = new LabelW(3, 5, "max. Chlorid");
        LabelW labelB6 = new LabelW(3, 6, "max. Sulfat");
        LabelW labelB7 = new LabelW(3, 7, "max. SI RO.");
        LabelW labelB8 = new LabelW(3, 8, "T KT");
        LabelW labelB9 = new LabelW(3, 9, "T Wand");
        LabelW labelB10 = new LabelW(3, 10,
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

        addCell(sheet1, labelB1);
        addCell(sheet1, labelB2);
        addCell(sheet1, labelB3);
        addCell(sheet1, labelB4);
        addCell(sheet1, labelB5);
        addCell(sheet1, labelB6);
        addCell(sheet1, labelB7);
        addCell(sheet1, labelB8);
        addCell(sheet1, labelB9);
        addCell(sheet1, labelB10);

        //Kosten
        LabelW labelC1 = new LabelW(6, 0,
            "Wirtschaftsdaten");
        LabelW labelC2 = new LabelW(6, 2,
            "Stadtwasser EUR/m³");
        LabelW labelC3 = new LabelW(6, 3,
            "Schmutzwasser EUR/m³");
        LabelW labelC4 = new LabelW(6, 4,
            "Regenwassersiel EUR/m³");
        LabelW labelC5 = new LabelW(6, 5, "Energie EUR/kWh");
        LabelW labelC6 = new LabelW(6, 6, "Kühlleistung kW");
        LabelW labelC7
            = new LabelW(6, 7,
                                  "Luftwäscherleistung kW");
        LabelW labelC8 = new LabelW(6, 8, "Auslastung %");
        LabelW labelC9 = new LabelW(6, 9,
            "Dosiermittel EUR/kg");
        LabelW labelC10 = new LabelW(6, 10, "Dosierhöhe g/m³");
        LabelW labelC11 = new LabelW(6, 11,
            "Salztabletten EUR/kg");
        LabelW labelC12 = new LabelW(6, 12,
            "Salzsäure EUR/kg");
        LabelW labelC13 = new LabelW(6, 13,
            "Schwefelsäure EUR/kg");
        LabelW labelC14 = new LabelW(6, 14,
            "RO Dosiermittel EUR/kg");
        LabelW labelC15 = new LabelW(6, 15,
            "RO Dosierhöhe g/m³");
        LabelW labelC16 = new LabelW(6, 16, "Dosiermittel");

        //
        addCell(sheet1, labelC1);
        addCell(sheet1, labelC2);
        addCell(sheet1, labelC3);
        addCell(sheet1, labelC4);
        addCell(sheet1, labelC5);
        addCell(sheet1, labelC6);
        addCell(sheet1, labelC7);
        addCell(sheet1, labelC8);
        addCell(sheet1, labelC9);
        addCell(sheet1, labelC10);
        addCell(sheet1, labelC11);
        addCell(sheet1, labelC12);
        addCell(sheet1, labelC13);
        addCell(sheet1, labelC14);
        addCell(sheet1, labelC15);
        addCell(sheet1, labelC16);

        // EINGABEWERTE EINFÜGEN

        LabelW labelWA1 = new LabelW(1, 2,
            f.anaroh.analysenNummer);
        LabelW labelWA2 = new LabelW(1, 3, f.anaroh.kunde);
        LabelW labelWA3 = new LabelW(1, 4, f.anaroh.projekt);
        LabelW labelWA4 = new LabelW(1, 5,
            f.anaroh.bearbeiter);
        NumberW numberWA5 = new NumberW(1, 6, f.anaroh.tE,
            nf1cell);
        NumberW numberWA6 = new NumberW(1, 7, f.anaroh.pHtE,
            nf1cell);
        NumberW numberWA7 = new NumberW(1, 8, f.anaroh.lF,
            nf1cell);
        NumberW numberWA8 = new NumberW(1, 9, f.anaroh.ca,
            nf1cell);
        NumberW numberWA9 = new NumberW(1, 10, f.anaroh.mg,
            nf1cell);
        NumberW numberWA10 = new NumberW(1, 11, f.anaroh.ks,
            nf1cell);
        NumberW numberWA11 = new NumberW(1, 12, f.anaroh.cl,
            nf1cell);
        NumberW numberWA12 = new NumberW(1, 13, f.anaroh.so4,
            nf1cell);
        NumberW numberWA13 = new NumberW(1, 14,
            f.anaroh.pHggW, nf1cell);
        NumberW numberWA14 = new NumberW(1, 15, f.anaroh.no3,
            nf1cell);
        NumberW numberWA15 = new NumberW(1, 16, f.anaroh.sitE,
            nf1cell);
        NumberW numberWA16 = new NumberW(1, 17,
            f.anaroh.h2co3,
            nf1cell);
        NumberW numberWA17 = new NumberW(1, 18, f.anaroh.co3,
            nf1cell);
        NumberW numberWA18 = new NumberW(1, 19, f.anaroh.hco3,
            nf1cell);

        addCell(sheet1, labelWA1);
        addCell(sheet1, labelWA2);
        addCell(sheet1, labelWA3);
        addCell(sheet1, labelWA4);
        addCell(sheet1, numberWA5);
        addCell(sheet1, numberWA6);
        addCell(sheet1, numberWA7);
        addCell(sheet1, numberWA8);
        addCell(sheet1, numberWA9);
        addCell(sheet1, numberWA10);
        addCell(sheet1, numberWA11);
        addCell(sheet1, numberWA12);
        addCell(sheet1, numberWA13);
        addCell(sheet1, numberWA14);
        addCell(sheet1, numberWA15);
        addCell(sheet1, numberWA16);
        addCell(sheet1, numberWA17);
        addCell(sheet1, numberWA18);
        //Grenzwerte einfügen
        LabelW labelGW1 = new LabelW(4, 2, "Kühlturm");
        NumberW numberGW2 = new NumberW(4, 3,
            f.bedingungen.EF, nf1cell);
        NumberW numberGW3 = new NumberW(4, 4,
            f.bedingungen.siMax, nf1cell);
        NumberW numberGW4 = new NumberW(4, 5,
            f.bedingungen.clMax, nf1cell);
        NumberW numberGW5 = new NumberW(4, 6,
            f.bedingungen.so4Max, nf1cell);
        NumberW numberGW6 = new NumberW(4, 7,
            f.bedingungen.roMax, nf1cell);
        NumberW numberGW7 = new NumberW(4, 8,
            f.bedingungen.tKT, nf1cell);
        NumberW numberGW8 = new NumberW(4, 9,
            f.bedingungen.tW, nf1cell);
        NumberW numberGW9 = new NumberW(4, 10,
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
        addCell(sheet1, labelGW1);
        addCell(sheet1, numberGW2);
        addCell(sheet1, numberGW3);
        addCell(sheet1, numberGW4);
        addCell(sheet1, numberGW5);
        addCell(sheet1, numberGW6);
        addCell(sheet1, numberGW7);
        addCell(sheet1, numberGW8);
        addCell(sheet1, numberGW9);

        //Kosten
        NumberW numberWK1 = new NumberW(7, 2,
            f.betriebsMittelKosten.stadtWasser, nf1cell);
        NumberW numberWK2 = new NumberW(7, 3,
            f.betriebsMittelKosten.abWasser, nf1cell);
        NumberW numberWK3 = new NumberW(7, 4,
            f.betriebsMittelKosten.regenWasser, nf1cell);
        NumberW numberWK4 = new NumberW(7, 5,
            f.betriebsMittelKosten.energie, nf1cell);
        NumberW numberWK5 = new NumberW(7, 6,
            f.betriebsMittelKosten.leistung, nf1cell);
        NumberW numberWK6 = new NumberW(7, 7,
            f.betriebsMittelKosten.leistung2, nf1cell);
        NumberW numberWK7 = new NumberW(7, 8,
            f.betriebsMittelKosten.auslastung, nf1cell);
        NumberW numberWK8 = new NumberW(7, 9,
            f.betriebsMittelKosten.dosierMittel, nf1cell);
        NumberW numberWK9 = new NumberW(7, 10,
            f.betriebsMittelKosten.dosierMenge, nf1cell);
        NumberW numberWK10 = new NumberW(7, 11,
            f.betriebsMittelKosten.salzTabletten, nf1cell);
        NumberW numberWK11 = new NumberW(7, 12,
            f.betriebsMittelKosten.salzSaeure, nf1cell);
        NumberW numberWK12 = new NumberW(7, 13,
            f.betriebsMittelKosten.schwefelSaeure, nf1cell);
        NumberW numberWK13 = new NumberW(7, 14,
            f.betriebsMittelKosten.ro, nf1cell);
        NumberW numberWK14 = new NumberW(7, 15,
            f.betriebsMittelKosten.roMenge, nf1cell);
        LabelW labelWK15 = new LabelW(7, 16,
            f.betriebsMittelKosten.dosierMittelName, nf1cell);

        addCell(sheet1, numberWK1);
        addCell(sheet1, numberWK2);
        addCell(sheet1, numberWK3);
        addCell(sheet1, numberWK4);
        addCell(sheet1, numberWK5);
        addCell(sheet1, numberWK6);
        addCell(sheet1, numberWK7);
        addCell(sheet1, numberWK8);
        addCell(sheet1, numberWK9);
        addCell(sheet1, numberWK10);
        addCell(sheet1, numberWK11);
        addCell(sheet1, numberWK12);
        addCell(sheet1, numberWK13);
        addCell(sheet1, numberWK14);
        addCell(sheet1, labelWK15);

//

        //Berechnung und Einfügen in Excel Spreadsheet für jede Aufbereitungsart



        int m, k;
        k = 6;
//         if (f.baufbereitung == false) { k = 5} // wenn Luftwäscher,
        //dann nur 5 Aufbereitungsarten. Scwefelsäuredosierung fällt weg
        // for (m = 1; m <= k ; m++)
        // {



//Umlaufwasseranalyse THRESH
        LabelW labelD1 = new LabelW(3, 0, "Umlaufwasser");
        //LabelW labelD2 = new LabelW(3, 1, "Aufbereitungsart");
        LabelW labelD2 = new LabelW(3, 2, "Verschnitt RW %");
        LabelW labelD3 = new LabelW(3, 3, "Eindickung E");
        LabelW labelD4 = new LabelW(3, 4, "TKT°C");
        LabelW labelD5 = new LabelW(3, 5, "TW°C");
        LabelW labelD6 = new LabelW(3, 6, "LF 25 ");
        LabelW labelD7 = new LabelW(3, 7, "Calcium mg/l");
        LabelW labelD8 = new LabelW(3, 8, "Magnesium mg/l");
        LabelW labelD9 = new LabelW(3, 9, "Na. ber. mg/l");
        LabelW labelD10 = new LabelW(3, 10, "KS 4,3 mmol/l");
        LabelW labelD11 = new LabelW(3, 11, "Chlorid mg/l");
        LabelW labelD12 = new LabelW(3, 12, "Sulfat mg/l");
        LabelW labelD13 = new LabelW(3, 13, "Nitrat mg/l");
        LabelW labelD14 = new LabelW(3, 14, "pH KTNV");
        LabelW labelD15 = new LabelW(3, 15, "GGW pH TKT");
        LabelW labelD16 = new LabelW(3, 16, "SI TKT");
        LabelW labelD17 = new LabelW(3, 17, "GGW pH W");
        LabelW labelD18 = new LabelW(3, 18, "SI W");
        LabelW labelD19 = new LabelW(3, 19,
            "Salzgehalt mmol/l");
        LabelW labelD20 = new LabelW(3, 20, "Ionenstärke I");
        LabelW labelD21 = new LabelW(3, 21, "H2Co3 mg/l");
        LabelW labelD22 = new LabelW(3, 22, "HCo3 mg/l");
        LabelW labelD23 = new LabelW(3, 23, "GCo3 mg/l");
        if (f.baufbereitung == false) {
          labelD4.setString("T LW)");
          labelD5.setString("");
          labelD14.setString("pH LWNV");
          labelD15.setString("GGWpH TLW");
          labelD17.setString("");
          labelD18.setString("");
        }
        addCell(sheet2, labelD1);
        addCell(sheet2, labelD2);
        addCell(sheet2, labelD3);
        addCell(sheet2, labelD4);
        addCell(sheet2, labelD5);
        addCell(sheet2, labelD6);
        addCell(sheet2, labelD7);
        addCell(sheet2, labelD8);
        addCell(sheet2, labelD9);
        addCell(sheet2, labelD10);
        addCell(sheet2, labelD11);
        addCell(sheet2, labelD12);
        addCell(sheet2, labelD13);
        addCell(sheet2, labelD14);
        addCell(sheet2, labelD15);
        addCell(sheet2, labelD16);
        addCell(sheet2, labelD17);
        addCell(sheet2, labelD18);
        addCell(sheet2, labelD19);
        addCell(sheet2, labelD20);
        addCell(sheet2, labelD21);
        addCell(sheet2, labelD22);
        addCell(sheet2, labelD23);

        //Umlaufwasseranalyse ENTHÄRTUNG
        LabelW labelEHU1 = new LabelW(3, 0, "Umlaufwasser");
        //LabelW labelEHU2 = new LabelW(3, 1, "Aufbereitungsart");
        LabelW labelEHU2 = new LabelW(3, 2, "Verschnitt RW %");
        LabelW labelEHU3 = new LabelW(3, 3, "Eindickung E");
        LabelW labelEHU4 = new LabelW(3, 4, "TKT°C");
        LabelW labelEHU5 = new LabelW(3, 5, "TW°C");
        LabelW labelEHU6 = new LabelW(3, 6, "LF 25 ");
        LabelW labelEHU7 = new LabelW(3, 7, "Calcium mg/l");
        LabelW labelEHU8 = new LabelW(3, 8, "Magnesium mg/l");
        LabelW labelEHU9 = new LabelW(3, 9, "Na. ber. mg/l");
        LabelW labelEHU10 = new LabelW(3, 10, "KS 4,3 mmol/l");
        LabelW labelEHU11 = new LabelW(3, 11, "Chlorid mg/l");
        LabelW labelEHU12 = new LabelW(3, 12, "Sulfat mg/l");
        LabelW labelEHU13 = new LabelW(3, 13, "Nitrat mg/l");
        LabelW labelEHU14 = new LabelW(3, 14, "pH KTNV");
        LabelW labelEHU15 = new LabelW(3, 15, "GGW pH TKT");
        LabelW labelEHU16 = new LabelW(3, 16, "SI TKT");
        LabelW labelEHU17 = new LabelW(3, 17, "GGW pH W");
        LabelW labelEHU18 = new LabelW(3, 18, "SI W");
        LabelW labelEHU19 = new LabelW(3, 19,
            "Salzgehalt mmol/l");
        LabelW labelEHU20 = new LabelW(3, 20, "Ionenstärke I");
        LabelW labelEHU21 = new LabelW(3, 21, "H2Co3 mg/l");
        LabelW labelEHU22 = new LabelW(3, 22, "HCo3 mg/l");
        LabelW labelEHU23 = new LabelW(3, 23, "GCo3 mg/l");
        if (f.baufbereitung == false) {
          labelD4.setString("T LW)");
          labelD5.setString("");
          labelD14.setString("pH LWNV");
          labelD15.setString("GGWpH TLW");
          labelD17.setString("");
          labelD18.setString("");
        }
        //
        addCell(sheet3, labelEHU1);
        addCell(sheet3, labelEHU2);
        addCell(sheet3, labelEHU3);
        addCell(sheet3, labelEHU4);
        addCell(sheet3, labelEHU5);
        addCell(sheet3, labelEHU6);
        addCell(sheet3, labelEHU7);
        addCell(sheet3, labelEHU8);
        addCell(sheet3, labelEHU9);
        addCell(sheet3, labelEHU10);
        addCell(sheet3, labelEHU11);
        addCell(sheet3, labelEHU12);
        addCell(sheet3, labelEHU13);
        addCell(sheet3, labelEHU14);
        addCell(sheet3, labelEHU15);
        addCell(sheet3, labelEHU16);
        addCell(sheet3, labelEHU17);
        addCell(sheet3, labelEHU18);
        addCell(sheet3, labelEHU19);
        addCell(sheet3, labelEHU20);
        addCell(sheet3, labelEHU21);
        addCell(sheet3, labelEHU22);
        addCell(sheet3, labelEHU23);
        //Umlaufwasseranalyse ENTHÄRTUNG
        LabelW labelECU1 = new LabelW(3, 0, "Umlaufwasser");
        //LabelW labelECU2 = new LabelW(3, 1, "Aufbereitungsart");
        LabelW labelECU2 = new LabelW(3, 2, "Verschnitt RW %");
        LabelW labelECU3 = new LabelW(3, 3, "Eindickung E");
        LabelW labelECU4 = new LabelW(3, 4, "TKT°C");
        LabelW labelECU5 = new LabelW(3, 5, "TW°C");
        LabelW labelECU6 = new LabelW(3, 6, "LF 25 ");
        LabelW labelECU7 = new LabelW(3, 7, "Calcium mg/l");
        LabelW labelECU8 = new LabelW(3, 8, "Magnesium mg/l");
        LabelW labelECU9 = new LabelW(3, 9, "Na. ber. mg/l");
        LabelW labelECU10 = new LabelW(3, 10, "KS 4,3 mmol/l");
        LabelW labelECU11 = new LabelW(3, 11, "Chlorid mg/l");
        LabelW labelECU12 = new LabelW(3, 12, "Sulfat mg/l");
        LabelW labelECU13 = new LabelW(3, 13, "Nitrat mg/l");
        LabelW labelECU14 = new LabelW(3, 14, "pH KTNV");
        LabelW labelECU15 = new LabelW(3, 15, "GGW pH TKT");
        LabelW labelECU16 = new LabelW(3, 16, "SI TKT");
        LabelW labelECU17 = new LabelW(3, 17, "GGW pH W");
        LabelW labelECU18 = new LabelW(3, 18, "SI W");
        LabelW labelECU19 = new LabelW(3, 19,
            "Salzgehalt mmol/l");
        LabelW labelECU20 = new LabelW(3, 20, "Ionenstärke I");
        LabelW labelECU21 = new LabelW(3, 21, "H2Co3 mg/l");
        LabelW labelECU22 = new LabelW(3, 22, "HCo3 mg/l");
        LabelW labelECU23 = new LabelW(3, 23, "GCo3 mg/l");
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
        addCell(sheet4, labelECU1);
        addCell(sheet4, labelECU2);
        addCell(sheet4, labelECU3);
        addCell(sheet4, labelECU4);
        addCell(sheet4, labelECU5);
        addCell(sheet4, labelECU6);
        addCell(sheet4, labelECU7);
        addCell(sheet4, labelECU8);
        addCell(sheet4, labelECU9);
        addCell(sheet4, labelECU10);
        addCell(sheet4, labelECU11);
        addCell(sheet4, labelECU12);
        addCell(sheet4, labelECU13);
        addCell(sheet4, labelECU14);
        addCell(sheet4, labelECU15);
        addCell(sheet4, labelECU16);
        addCell(sheet4, labelECU17);
        addCell(sheet4, labelECU18);
        addCell(sheet4, labelECU19);
        addCell(sheet4, labelECU20);
        addCell(sheet4, labelECU21);
        addCell(sheet4, labelECU22);
        addCell(sheet4, labelECU23);

        //
        //
        //Umlaufwasseranalyse ENTHÄRTUNG
        LabelW labelUOU1 = new LabelW(3, 0, "Umlaufwasser");
        //LabelW labelUOU2 = new LabelW(3, 1, "Aufbereitungsart");
        LabelW labelUOU2 = new LabelW(3, 2, "Verschnitt RW %");
        LabelW labelUOU3 = new LabelW(3, 3, "Eindickung E");
        LabelW labelUOU4 = new LabelW(3, 4, "TKT°C");
        LabelW labelUOU5 = new LabelW(3, 5, "TW°C");
        LabelW labelUOU6 = new LabelW(3, 6, "LF 25 ");
        LabelW labelUOU7 = new LabelW(3, 7, "Calcium mg/l");
        LabelW labelUOU8 = new LabelW(3, 8, "Magnesium mg/l");
        LabelW labelUOU9 = new LabelW(3, 9, "Na. ber. mg/l");
        LabelW labelUOU10 = new LabelW(3, 10, "KS 4,3 mmol/l");
        LabelW labelUOU11 = new LabelW(3, 11, "Chlorid mg/l");
        LabelW labelUOU12 = new LabelW(3, 12, "Sulfat mg/l");
        LabelW labelUOU13 = new LabelW(3, 13, "Nitrat mg/l");
        LabelW labelUOU14 = new LabelW(3, 14, "pH KTNV");
        LabelW labelUOU15 = new LabelW(3, 15, "GGW pH TKT");
        LabelW labelUOU16 = new LabelW(3, 16, "SI TKT");
        LabelW labelUOU17 = new LabelW(3, 17, "GGW pH W");
        LabelW labelUOU18 = new LabelW(3, 18, "SI W");
        LabelW labelUOU19 = new LabelW(3, 19,
            "Salzgehalt mmol/l");
        LabelW labelUOU20 = new LabelW(3, 20, "Ionenstärke I");
        LabelW labelUOU21 = new LabelW(3, 21, "H2Co3 mg/l");
        LabelW labelUOU22 = new LabelW(3, 22, "HCo3 mg/l");
        LabelW labelUOU23 = new LabelW(3, 23, "GCo3 mg/l");
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
        addCell(sheet5, labelUOU1);
        addCell(sheet5, labelUOU2);
        addCell(sheet5, labelUOU3);
        addCell(sheet5, labelUOU4);
        addCell(sheet5, labelUOU5);
        addCell(sheet5, labelUOU6);
        addCell(sheet5, labelUOU7);
        addCell(sheet5, labelUOU8);
        addCell(sheet5, labelUOU9);
        addCell(sheet5, labelUOU10);
        addCell(sheet5, labelUOU11);
        addCell(sheet5, labelUOU12);
        addCell(sheet5, labelUOU13);
        addCell(sheet5, labelUOU14);
        addCell(sheet5, labelUOU15);
        addCell(sheet5, labelUOU16);
        addCell(sheet5, labelUOU17);
        addCell(sheet5, labelUOU18);
        addCell(sheet5, labelUOU19);
        addCell(sheet5, labelUOU20);
        addCell(sheet5, labelUOU21);
        addCell(sheet5, labelUOU22);
        addCell(sheet5, labelUOU23);

        //
        //Umlaufwasseranalyse ENTHÄRTUNG
        LabelW labelUMU1 = new LabelW(3, 0, "Umlaufwasser");
        //LabelW labelUMU2 = new LabelW(3, 1, "Aufbereitungsart");
        LabelW labelUMU2 = new LabelW(3, 2, "Verschnitt RW %");
        LabelW labelUMU3 = new LabelW(3, 3, "Eindickung E");
        LabelW labelUMU4 = new LabelW(3, 4, "TKT°C");
        LabelW labelUMU5 = new LabelW(3, 5, "TW°C");
        LabelW labelUMU6 = new LabelW(3, 6, "LF 25 ");
        LabelW labelUMU7 = new LabelW(3, 7, "Calcium mg/l");
        LabelW labelUMU8 = new LabelW(3, 8, "Magnesium mg/l");
        LabelW labelUMU9 = new LabelW(3, 9, "Na. ber. mg/l");
        LabelW labelUMU10 = new LabelW(3, 10, "KS 4,3 mmol/l");
        LabelW labelUMU11 = new LabelW(3, 11, "Chlorid mg/l");
        LabelW labelUMU12 = new LabelW(3, 12, "Sulfat mg/l");
        LabelW labelUMU13 = new LabelW(3, 13, "Nitrat mg/l");
        LabelW labelUMU14 = new LabelW(3, 14, "pH KTNV");
        LabelW labelUMU15 = new LabelW(3, 15, "GGW pH TKT");
        LabelW labelUMU16 = new LabelW(3, 16, "SI TKT");
        LabelW labelUMU17 = new LabelW(3, 17, "GGW pH W");
        LabelW labelUMU18 = new LabelW(3, 18, "SI W");
        LabelW labelUMU19 = new LabelW(3, 19,
            "Salzgehalt mmol/l");
        LabelW labelUMU20 = new LabelW(3, 20, "Ionenstärke I");
        LabelW labelUMU21 = new LabelW(3, 21, "H2Co3 mg/l");
        LabelW labelUMU22 = new LabelW(3, 22, "HCo3 mg/l");
        LabelW labelUMU23 = new LabelW(3, 23, "GCo3 mg/l");
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
        addCell(sheet6, labelUMU1);
        addCell(sheet6, labelUMU2);
        addCell(sheet6, labelUMU3);
        addCell(sheet6, labelUMU4);
        addCell(sheet6, labelUMU5);
        addCell(sheet6, labelUMU6);
        addCell(sheet6, labelUMU7);
        addCell(sheet6, labelUMU8);
        addCell(sheet6, labelUMU9);
        addCell(sheet6, labelUMU10);
        addCell(sheet6, labelUMU11);
        addCell(sheet6, labelUMU12);
        addCell(sheet6, labelUMU13);
        addCell(sheet6, labelUMU14);
        addCell(sheet6, labelUMU15);
        addCell(sheet6, labelUMU16);
        addCell(sheet6, labelUMU17);
        addCell(sheet6, labelUMU18);
        addCell(sheet6, labelUMU19);
        addCell(sheet6, labelUMU20);
        addCell(sheet6, labelUMU21);
        addCell(sheet6, labelUMU22);
        addCell(sheet6, labelUMU23);
        //
        //Umlaufwasseranalyse ENTHÄRTUNG
        LabelW labelSDU1 = new LabelW(3, 0, "Umlaufwasser");
        //LabelW labelSDU2 = new LabelW(3, 1, "Aufbereitungsart");
        LabelW labelSDU2 = new LabelW(3, 2, "Verschnitt RW %");
        LabelW labelSDU3 = new LabelW(3, 3, "Eindickung E");
        LabelW labelSDU4 = new LabelW(3, 4, "TKT°C");
        LabelW labelSDU5 = new LabelW(3, 5, "TW°C");
        LabelW labelSDU6 = new LabelW(3, 6, "LF 25 ");
        LabelW labelSDU7 = new LabelW(3, 7, "Calcium mg/l");
        LabelW labelSDU8 = new LabelW(3, 8, "Magnesium mg/l");
        LabelW labelSDU9 = new LabelW(3, 9, "Na. ber. mg/l");
        LabelW labelSDU10 = new LabelW(3, 10, "KS 4,3 mmol/l");
        LabelW labelSDU11 = new LabelW(3, 11, "Chlorid mg/l");
        LabelW labelSDU12 = new LabelW(3, 12, "Sulfat mg/l");
        LabelW labelSDU13 = new LabelW(3, 13, "Nitrat mg/l");
        LabelW labelSDU14 = new LabelW(3, 14, "pH KTNV");
        LabelW labelSDU15 = new LabelW(3, 15, "GGW pH TKT");
        LabelW labelSDU16 = new LabelW(3, 16, "SI TKT");
        LabelW labelSDU17 = new LabelW(3, 17, "GGW pH W");
        LabelW labelSDU18 = new LabelW(3, 18, "SI W");
        LabelW labelSDU19 = new LabelW(3, 19,
            "Salzgehalt mmol/l");
        LabelW labelSDU20 = new LabelW(3, 20, "Ionenstärke I");
        LabelW labelSDU21 = new LabelW(3, 21, "H2Co3 mg/l");
        LabelW labelSDU22 = new LabelW(3, 22, "HCo3 mg/l");
        LabelW labelSDU23 = new LabelW(3, 23, "GCo3 mg/l");
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
        addCell(sheet7, labelSDU1);
        addCell(sheet7, labelSDU2);
        addCell(sheet7, labelSDU3);
        addCell(sheet7, labelSDU4);
        addCell(sheet7, labelSDU5);
        addCell(sheet7, labelSDU6);
        addCell(sheet7, labelSDU7);
        addCell(sheet7, labelSDU8);
        addCell(sheet7, labelSDU9);
        addCell(sheet7, labelSDU10);
        addCell(sheet7, labelSDU11);
        addCell(sheet7, labelSDU12);
        addCell(sheet7, labelSDU13);
        addCell(sheet7, labelSDU14);
        addCell(sheet7, labelSDU15);
        addCell(sheet7, labelSDU16);
        addCell(sheet7, labelSDU17);
        addCell(sheet7, labelSDU18);
        addCell(sheet7, labelSDU19);
        addCell(sheet7, labelSDU20);
        addCell(sheet7, labelSDU21);
        addCell(sheet7, labelSDU22);
        addCell(sheet7, labelSDU23);

//VERBRAUCH  THRESH
        LabelW labelTHM1 = new LabelW(6, 0,
            "Verbrauchsmengen");
        LabelW labelTHM2 = new LabelW(6, 2, "Energie kWh/a");
        LabelW labelTHM3 = new LabelW(6, 3,
            "Zusatzwasser m³/a");
        LabelW labelTHM4 = new LabelW(6, 4,
            "Schmutzwassersiel m³/a");
        LabelW labelTHM5 = new LabelW(6, 5,
            "Regenwassersiel m³/a");
        LabelW labelTHM6 = new LabelW(6, 6,
            "Dosiermittel kg/a");
        LabelW labelTHM7 = new LabelW(6, 7,
            "Salztabletten kg/a ");
        LabelW labelTHM8 = new LabelW(6, 8, "Salzsäure kg/a");
        LabelW labelTHM9 = new LabelW(6, 9,
            "Schwefelsäure kg/l");
        LabelW labelTHM10 = new LabelW(6, 10,
            "RO Dosiermittel kg/a");

        //
        addCell(sheet2, labelTHM1);
        addCell(sheet2, labelTHM2);
        addCell(sheet2, labelTHM3);
        addCell(sheet2, labelTHM4);
        addCell(sheet2, labelTHM5);
        addCell(sheet2, labelTHM6);
        addCell(sheet2, labelTHM7);
        addCell(sheet2, labelTHM8);
        addCell(sheet2, labelTHM9);
        addCell(sheet2, labelTHM10);

        //VERBRAUCH  EH
        LabelW labelEHM1 = new LabelW(6, 0,
            "Verbrauchsmengen");
        LabelW labelEHM2 = new LabelW(6, 2, "Energie kWh/a");
        LabelW labelEHM3 = new LabelW(6, 3,
            "Zusatzwasser m³/a");
        LabelW labelEHM4 = new LabelW(6, 4,
            "Schmutzwassersiel m³/a");
        LabelW labelEHM5 = new LabelW(6, 5,
            "Regenwassersiel m³/a");
        LabelW labelEHM6 = new LabelW(6, 6,
            "Dosiermittel kg/a");
        LabelW labelEHM7 = new LabelW(6, 7,
            "Salztabletten kg/a ");
        LabelW labelEHM8 = new LabelW(6, 8, "Salzsäure kg/a");
        LabelW labelEHM9 = new LabelW(6, 9,
            "Schwefelsäure kg/l");
        LabelW labelEHM10 = new LabelW(6, 10,
            "RO Dosiermittel kg/a");

        //
        addCell(sheet3, labelEHM1);
        addCell(sheet3, labelEHM2);
        addCell(sheet3, labelEHM3);
        addCell(sheet3, labelEHM4);
        addCell(sheet3, labelEHM5);
        addCell(sheet3, labelEHM6);
        addCell(sheet3, labelEHM7);
        addCell(sheet3, labelEHM8);
        addCell(sheet3, labelEHM9);
        addCell(sheet3, labelEHM10);

        //VERBRAUCH  EC
        LabelW labelECM1 = new LabelW(6, 0,
            "Verbrauchsmengen");
        LabelW labelECM2 = new LabelW(6, 2, "Energie kWh/a");
        LabelW labelECM3 = new LabelW(6, 3,
            "Zusatzwasser m³/a");
        LabelW labelECM4 = new LabelW(6, 4,
            "Schmutzwassersiel m³/a");
        LabelW labelECM5 = new LabelW(6, 5,
            "Regenwassersiel m³/a");
        LabelW labelECM6 = new LabelW(6, 6,
            "Dosiermittel kg/a");
        LabelW labelECM7 = new LabelW(6, 7,
            "Salztabletten kg/a ");
        LabelW labelECM8 = new LabelW(6, 8, "Salzsäure kg/a");
        LabelW labelECM9 = new LabelW(6, 9,
            "Schwefelsäure kg/l");
        LabelW labelECM10 = new LabelW(6, 10,
            "RO Dosiermittel kg/a");

        //
        addCell(sheet4, labelECM1);
        addCell(sheet4, labelECM2);
        addCell(sheet4, labelECM3);
        addCell(sheet4, labelECM4);
        addCell(sheet4, labelECM5);
        addCell(sheet4, labelECM6);
        addCell(sheet4, labelECM7);
        addCell(sheet4, labelECM8);
        addCell(sheet4, labelECM9);
        addCell(sheet4, labelECM10);

        //
//VERBRAUCH  UO
        LabelW labelUOM1 = new LabelW(6, 0,
            "Verbrauchsmengen");
        LabelW labelUOM2 = new LabelW(6, 2, "Energie kWh/a");
        LabelW labelUOM3 = new LabelW(6, 3,
            "Zusatzwasser m³/a");
        LabelW labelUOM4 = new LabelW(6, 4,
            "Schmutzwassersiel m³/a");
        LabelW labelUOM5 = new LabelW(6, 5,
            "Regenwassersiel m³/a");
        LabelW labelUOM6 = new LabelW(6, 6,
            "Dosiermittel kg/a");
        LabelW labelUOM7 = new LabelW(6, 7,
            "Salztabletten kg/a ");
        LabelW labelUOM8 = new LabelW(6, 8, "Salzsäure kg/a");
        LabelW labelUOM9 = new LabelW(6, 9,
            "Schwefelsäure kg/l");
        LabelW labelUOM10 = new LabelW(6, 10,
            "RO Dosiermittel kg/a");

        //
        addCell(sheet5, labelUOM1);
        addCell(sheet5, labelUOM2);
        addCell(sheet5, labelUOM3);
        addCell(sheet5, labelUOM4);
        addCell(sheet5, labelUOM5);
        addCell(sheet5, labelUOM6);
        addCell(sheet5, labelUOM7);
        addCell(sheet5, labelUOM8);
        addCell(sheet5, labelUOM9);
        addCell(sheet5, labelUOM10);

        //VERBRAUCH  THRESH
        LabelW labelUMM1 = new LabelW(6, 0,
            "Verbrauchsmengen");
        LabelW labelUMM2 = new LabelW(6, 2, "Energie kWh/a");
        LabelW labelUMM3 = new LabelW(6, 3,
            "Zusatzwasser m³/a");
        LabelW labelUMM4 = new LabelW(6, 4,
            "Schmutzwassersiel m³/a");
        LabelW labelUMM5 = new LabelW(6, 5,
            "Regenwassersiel m³/a");
        LabelW labelUMM6 = new LabelW(6, 6,
            "Dosiermittel kg/a");
        LabelW labelUMM7 = new LabelW(6, 7,
            "Salztabletten kg/a ");
        LabelW labelUMM8 = new LabelW(6, 8, "Salzsäure kg/a");
        LabelW labelUMM9 = new LabelW(6, 9,
            "Schwefelsäure kg/l");
        LabelW labelUMM10 = new LabelW(6, 10,
            "RO Dosiermittel kg/a");

        //
        addCell(sheet6, labelUMM1);
        addCell(sheet6, labelUMM2);
        addCell(sheet6, labelUMM3);
        addCell(sheet6, labelUMM4);
        addCell(sheet6, labelUMM5);
        addCell(sheet6, labelUMM6);
        addCell(sheet6, labelUMM7);
        addCell(sheet6, labelUMM8);
        addCell(sheet6, labelUMM9);
        addCell(sheet6, labelUMM10);
//

        //VERBRAUCH  THRESH
        LabelW labelSDM1 = new LabelW(6, 0,
            "Verbrauchsmengen");
        LabelW labelSDM2 = new LabelW(6, 2, "Energie kWh/a");
        LabelW labelSDM3 = new LabelW(6, 3,
            "Zusatzwasser m³/a");
        LabelW labelSDM4 = new LabelW(6, 4,
            "Schmutzwassersiel m³/a");
        LabelW labelSDM5 = new LabelW(6, 5,
            "Regenwassersiel m³/a");
        LabelW labelSDM6 = new LabelW(6, 6,
            "Dosiermittel kg/a");
        LabelW labelSDM7 = new LabelW(6, 7,
            "Salztabletten kg/a ");
        LabelW labelSDM8 = new LabelW(6, 8, "Salzsäure kg/a");
        LabelW labelSDM9 = new LabelW(6, 9,
            "Schwefelsäure kg/l");
        LabelW labelSDM10 = new LabelW(6, 10,
            "RO Dosiermittel kg/a");

        //
        addCell(sheet7, labelSDM1);
        addCell(sheet7, labelSDM2);
        addCell(sheet7, labelSDM3);
        addCell(sheet7, labelSDM4);
        addCell(sheet7, labelSDM5);
        addCell(sheet7, labelSDM6);
        addCell(sheet7, labelSDM7);
        addCell(sheet7, labelSDM8);
        addCell(sheet7, labelSDM9);
        addCell(sheet7, labelSDM10);

        //Kosten TH
        LabelW labelTHK1 = new LabelW(6, 11, "Kosten");
        LabelW labelTHK2 = new LabelW(6, 13, "Energie EUR/a");
        LabelW labelTHK3 = new LabelW(6, 14,
            "Zusatzwasser EUR/a");
        LabelW labelTHK4 = new LabelW(6, 15,
            "Schmutzwassersiel EUR/a");
        LabelW labelTHK5 = new LabelW(6, 16,
            "Regenwassersiel EUR/a");
        LabelW labelTHK6 = new LabelW(6, 17,
            "Dosiermittel EUR/a");
        LabelW labelTHK7 = new LabelW(6, 18,
            "Salztabletten EUR/a ");
        LabelW labelTHK8 = new LabelW(6, 19,
            "Salzsäure EUR/a");
        LabelW labelTHK9 = new LabelW(6, 20,
            "Schwefelsäure EUR/l");
        LabelW labelTHK10 = new LabelW(6, 21,
            "RO Dosiermittel EUR/a");
        LabelW labelTHK11 = new LabelW(9, 23,
            "Gesamtkosten EUR/a");

        //
        addCell(sheet2, labelTHK1);
        addCell(sheet2, labelTHK2);
        addCell(sheet2, labelTHK3);
        addCell(sheet2, labelTHK4);
        addCell(sheet2, labelTHK5);
        addCell(sheet2, labelTHK6);
        addCell(sheet2, labelTHK7);
        addCell(sheet2, labelTHK8);
        addCell(sheet2, labelTHK9);
        addCell(sheet2, labelTHK10);
        addCell(sheet2, labelTHK11);

        //
        //Kosten
        LabelW labelEHK1 = new LabelW(6, 11, "Kosten");
        LabelW labelEHK2 = new LabelW(6, 13, "Energie EUR/a");
        LabelW labelEHK3 = new LabelW(6, 14,
            "Zusatzwasser EUR/a");
        LabelW labelEHK4 = new LabelW(6, 15,
            "Schmutzwassersiel EUR/a");
        LabelW labelEHK5 = new LabelW(6, 16,
            "Regenwassersiel EUR/a");
        LabelW labelEHK6 = new LabelW(6, 17,
            "Dosiermittel EUR/a");
        LabelW labelEHK7 = new LabelW(6, 18,
            "Salztabletten EUR/a ");
        LabelW labelEHK8 = new LabelW(6, 19,
            "Salzsäure EUR/a");
        LabelW labelEHK9 = new LabelW(6, 20,
            "Schwefelsäure EUR/l");
        LabelW labelEHK10 = new LabelW(6, 21,
            "RO Dosiermittel EUR/a");
        LabelW labelEHK11 = new LabelW(6, 22,
            "Gesamtkosten EUR/a");

//
        addCell(sheet3, labelEHK1);
        addCell(sheet3, labelEHK2);
        addCell(sheet3, labelEHK3);
        addCell(sheet3, labelEHK4);
        addCell(sheet3, labelEHK5);
        addCell(sheet3, labelEHK6);
        addCell(sheet3, labelEHK7);
        addCell(sheet3, labelEHK8);
        addCell(sheet3, labelEHK9);
        addCell(sheet3, labelEHK10);
        addCell(sheet3, labelEHK11);

        //Kosten EC
        LabelW labelECK1 = new LabelW(6, 11, "Kosten");
        LabelW labelECK2 = new LabelW(6, 13, "Energie EUR/a");
        LabelW labelECK3 = new LabelW(6, 14,
            "Zusatzwasser EUR/a");
        LabelW labelECK4 = new LabelW(6, 15,
            "Schmutzwassersiel EUR/a");
        LabelW labelECK5 = new LabelW(6, 16,
            "Regenwassersiel EUR/a");
        LabelW labelECK6 = new LabelW(6, 17,
            "Dosiermittel EUR/a");
        LabelW labelECK7 = new LabelW(6, 18,
            "Salztabletten EUR/a ");
        LabelW labelECK8 = new LabelW(6, 19,
            "Salzsäure EUR/a");
        LabelW labelECK9 = new LabelW(6, 20,
            "Schwefelsäure EUR/l");
        LabelW labelECK10 = new LabelW(6, 21,
            "RO Dosiermittel EUR/a");
        LabelW labelECK11 = new LabelW(6, 22,
            "Gesamtkosten EUR/a");

//
        addCell(sheet4, labelECK1);
        addCell(sheet4, labelECK2);
        addCell(sheet4, labelECK3);
        addCell(sheet4, labelECK4);
        addCell(sheet4, labelECK5);
        addCell(sheet4, labelECK6);
        addCell(sheet4, labelECK7);
        addCell(sheet4, labelECK8);
        addCell(sheet4, labelECK9);
        addCell(sheet4, labelECK10);
        addCell(sheet4, labelECK11);

//
        //Kosten
        LabelW labelUOK1 = new LabelW(6, 11, "Kosten");
        LabelW labelUOK2 = new LabelW(6, 13, "Energie EUR/a");
        LabelW labelUOK3 = new LabelW(6, 14,
            "Zusatzwasser EUR/a");
        LabelW labelUOK4 = new LabelW(6, 15,
            "Schmutzwassersiel EUR/a");
        LabelW labelUOK5 = new LabelW(6, 16,
            "Regenwassersiel EUR/a");
        LabelW labelUOK6 = new LabelW(6, 17,
            "Dosiermittel EUR/a");
        LabelW labelUOK7 = new LabelW(6, 18,
            "Salztabletten EUR/a ");
        LabelW labelUOK8 = new LabelW(6, 19,
            "Salzsäure EUR/a");
        LabelW labelUOK9 = new LabelW(6, 20,
            "Schwefelsäure EUR/l");
        LabelW labelUOK10 = new LabelW(6, 21,
            "RO Dosiermittel EUR/a");
        LabelW labelUOK11 = new LabelW(6, 22,
            "Gesamtkosten EUR/a");

        //
        addCell(sheet5, labelUOK1);
        addCell(sheet5, labelUOK2);
        addCell(sheet5, labelUOK3);
        addCell(sheet5, labelUOK4);
        addCell(sheet5, labelUOK5);
        addCell(sheet5, labelUOK6);
        addCell(sheet5, labelUOK7);
        addCell(sheet5, labelUOK8);
        addCell(sheet5, labelUOK9);
        addCell(sheet5, labelUOK10);
        addCell(sheet5, labelUOK11);
//

        //Kosten UM
        LabelW labelUMK1 = new LabelW(6, 11, "Kosten");
        LabelW labelUMK2 = new LabelW(6, 13, "Energie EUR/a");
        LabelW labelUMK3 = new LabelW(6, 14,
            "Zusatzwasser EUR/a");
        LabelW labelUMK4 = new LabelW(6, 15,
            "Schmutzwassersiel EUR/a");
        LabelW labelUMK5 = new LabelW(6, 16,
            "Regenwassersiel EUR/a");
        LabelW labelUMK6 = new LabelW(6, 17,
            "Dosiermittel EUR/a");
        LabelW labelUMK7 = new LabelW(6, 18,
            "Salztabletten EUR/a ");
        LabelW labelUMK8 = new LabelW(6, 19,
            "Salzsäure EUR/a");
        LabelW labelUMK9 = new LabelW(6, 20,
            "Schwefelsäure EUR/l");
        LabelW labelUMK10 = new LabelW(6, 21,
            "RO Dosiermittel EUR/a");
        LabelW labelUMK11 = new LabelW(6, 22,
            "Gesamtkosten EUR/a");

        //
        addCell(sheet6, labelUMK1);
        addCell(sheet6, labelUMK2);
        addCell(sheet6, labelUMK3);
        addCell(sheet6, labelUMK4);
        addCell(sheet6, labelUMK5);
        addCell(sheet6, labelUMK6);
        addCell(sheet6, labelUMK7);
        addCell(sheet6, labelUMK8);
        addCell(sheet6, labelUMK9);
        addCell(sheet6, labelUMK10);
        addCell(sheet6, labelUMK11);

//

        //Kosten SD
        LabelW labelSDK1 = new LabelW(6, 11, "Kosten");
        LabelW labelSDK2 = new LabelW(6, 13, "Energie EUR/a");
        LabelW labelSDK3 = new LabelW(6, 14,
            "Zusatzwasser EUR/a");
        LabelW labelSDK4 = new LabelW(6, 15,
            "Schmutzwassersiel EUR/a");
        LabelW labelSDK5 = new LabelW(6, 16,
            "Regenwassersiel EUR/a");
        LabelW labelSDK6 = new LabelW(6, 17,
            "Dosiermittel EUR/a");
        LabelW labelSDK7 = new LabelW(6, 18,
            "Salztabletten EUR/a ");
        LabelW labelSDK8 = new LabelW(6, 19,
            "Salzsäure EUR/a");
        LabelW labelSDK9 = new LabelW(6, 20,
            "Schwefelsäure EUR/l");
        LabelW labelSDK10 = new LabelW(6, 21,
            "RO Dosiermittel EUR/a");
        LabelW labelSDK11 = new LabelW(6, 22,
            "Gesamtkosten EUR/a");

//
        addCell(sheet7, labelSDK1);
        addCell(sheet7, labelSDK2);
        addCell(sheet7, labelSDK3);
        addCell(sheet7, labelSDK4);
        addCell(sheet7, labelSDK5);
        addCell(sheet7, labelSDK6);
        addCell(sheet7, labelSDK7);
        addCell(sheet7, labelSDK8);
        addCell(sheet7, labelSDK9);
        addCell(sheet7, labelSDK10);
        addCell(sheet7, labelSDK11);

//



//*****************************************************************
//   WERTE EINFÜGEN
//*****************************************************************
///
          f.threshhold();
        //Umlaufwasseranalyse
        LabelW labelUW1 = new LabelW(4, 0,
            f.aufbereitung, nf1cell);
        NumberW numberUW2 = new NumberW(4, 2,
            f.anauml.verSchnitt, nf1cell);
        NumberW numberUW3 = new NumberW(4, 3,
            f.anauml.eindickung, nf1cell);
        NumberW numberUW4 = new NumberW(4, 4, f.anauml.tKT,
            nf1cell);
        NumberW numberUW5 = new NumberW(4, 5, f.anauml.tW,
            nf1cell);
        NumberW numberUW6 = new NumberW(4, 6, f.anauml.lF,
            nf1cell);
        NumberW numberUW7 = new NumberW(4, 7, f.anauml.ca,
            nf1cell);
        NumberW numberUW8 = new NumberW(4, 8, f.anauml.mg,
            nf1cell);
        NumberW numberUW9 = new NumberW(4, 9, f.anauml.na,
            nf1cell);
        NumberW numberUW10 = new NumberW(4, 10, f.anauml.ks,
            nf1cell);
        NumberW numberUW11 = new NumberW(4, 11, f.anauml.cl,
            nf1cell);
        NumberW numberUW12 = new NumberW(4, 12, f.anauml.so4,
            nf1cell);
        NumberW numberUW13 = new NumberW(4, 13, f.anauml.no3,
            nf1cell);
        NumberW numberUW14 = new NumberW(4, 14,
            f.anauml.pHKTnV, nf1cell);
        NumberW numberUW15 = new NumberW(4, 15,
            f.anauml.pHTKT, nf1cell);
        NumberW numberUW16 = new NumberW(4, 16,
            f.anauml.siTKT, nf1cell);
        NumberW numberUW17 = new NumberW(4, 17,
            f.anauml.pHggWW, nf1cell);
        NumberW numberUW18 = new NumberW(4, 18, f.anauml.sIW,
            nf1cell);
        NumberW numberUW19 = new NumberW(4, 19, f.anauml.salz,
            nf1cell);
        NumberW numberUW20 = new NumberW(4, 20,
            f.anauml.ionen, nf1cell);
        NumberW numberUW21 = new NumberW(4, 21,
            f.anauml.h2co3, nf1cell);
        NumberW numberUW22 = new NumberW(4, 22, f.anauml.hco3,
            nf1cell);
        NumberW numberUW23 = new NumberW(4, 23, f.anauml.co3,
            nf1cell);

        addCell(sheet2, labelUW1);
        addCell(sheet2, numberUW2);
        addCell(sheet2, numberUW3);
        addCell(sheet2, numberUW4);
        addCell(sheet2, numberUW5);
        addCell(sheet2, numberUW6);
        addCell(sheet2, numberUW7);
        addCell(sheet2, numberUW8);
        addCell(sheet2, numberUW9);
        addCell(sheet2, numberUW10);
        addCell(sheet2, numberUW11);
        addCell(sheet2, numberUW12);
        addCell(sheet2, numberUW13);
        addCell(sheet2, numberUW14);
        addCell(sheet2, numberUW15);
        addCell(sheet2, numberUW16);
        addCell(sheet2, numberUW17);
        addCell(sheet2, numberUW18);
        addCell(sheet2, numberUW19);
        addCell(sheet2, numberUW20);
        addCell(sheet2, numberUW21);
        addCell(sheet2, numberUW22);
        addCell(sheet2, numberUW23);

//VERBRAUCH

        NumberW numberVB1 = new NumberW(7, 2,
            f.betrkost.enVer, nf1cell);
        NumberW numberVB2 = new NumberW(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        NumberW numberVB3 = new NumberW(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        NumberW numberVB4 = new NumberW(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        NumberW numberVB5 = new NumberW(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        NumberW numberVB6 = new NumberW(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        NumberW numberVB7 = new NumberW(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        NumberW numberVB8 = new NumberW(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        NumberW numberVB9 = new NumberW(7, 10,
            f.betrkost.roVer, nf1cell);

        addCell(sheet2, numberVB1);
        addCell(sheet2, numberVB2);
        addCell(sheet2, numberVB3);
        addCell(sheet2, numberVB4);
        addCell(sheet2, numberVB5);
        addCell(sheet2, numberVB6);
        addCell(sheet2, numberVB7);
        addCell(sheet2, numberVB8);
        addCell(sheet2, numberVB9);

//KOSTEN

        NumberW numberKO1 = new NumberW(7, 13,
            f.betrkost.enKost, nf1cell);
        NumberW numberKO2 = new NumberW(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        NumberW numberKO3 = new NumberW(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        NumberW numberKO4 = new NumberW(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        NumberW numberKO5 = new NumberW(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        NumberW numberKO6 = new NumberW(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        NumberW numberKO7 = new NumberW(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        NumberW numberKO8 = new NumberW(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        NumberW numberKO9 = new NumberW(7, 21,
            f.betrkost.roKost, nf1cell);
        NumberW numberKO10 = new NumberW(7, 23,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
            f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
            f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
            f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
            f.anlkost.jahresBetrag, nf1cell);

        addCell(sheet2, numberKO1);
        addCell(sheet2, numberKO2);
        addCell(sheet2, numberKO3);
        addCell(sheet2, numberKO4);
        addCell(sheet2, numberKO5);
        addCell(sheet2, numberKO6);
        addCell(sheet2, numberKO7);
        addCell(sheet2, numberKO8);
        addCell(sheet2, numberKO9);
        addCell(sheet2, numberKO10);
        //******ANLAGE THRESHOLD*************************************************

         LabelW labelG1 = new LabelW(9, 0,
             "Anlageinformationen");
        addCell(sheet2, labelG1);

        LabelW labelG15 = new LabelW(9, 3,
            "Anlage,Typ:");
        addCell(sheet2, labelG15);
        LabelW LabelAK15 = new LabelW(10, 3,
            f.anlkost.typ3, nf1cell);
        addCell(sheet2, LabelAK15);

        LabelW labelG16 = new LabelW(9, 4,
            "Dosier und Schutzbehälter:");
        addCell(sheet2, labelG16);
        LabelW labelAK16 = new LabelW(10, 4,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        addCell(sheet2, labelAK16);

        LabelW labelG17 = new LabelW(9, 5,
            "Werkstoff:");
        addCell(sheet2, labelG17);
        LabelW LabelAK17 = new LabelW(10, 5,
            f.anlkost.ws3, nf1cell);

        LabelW labelG18 = new LabelW(9, 6,
            "Steuerung::");
        addCell(sheet2, labelG18);
        addCell(sheet2, LabelAK17);
        LabelW LabelAK18 = new LabelW(10, 6,
            f.anlkost.st3, nf1cell);
        addCell(sheet2, LabelAK18);

        LabelW labelG19 = new LabelW(9, 7,
            "Wassermengenzähler:");
        addCell(sheet2, labelG19);
        LabelW NumberAK19 = new LabelW(10, 7,
            f.anlkost.wz3, nf1cell);
        addCell(sheet2, NumberAK19);

        LabelW labelG20 = new LabelW(9, 8,
            "Richtpreis einschl. Montage:");
        addCell(sheet2, labelG20);
        NumberW NumberAK20 = new NumberW(10, 8,
            f.anlkost.aP3, nf1cell);
        addCell(sheet2, NumberAK20);

        LabelW labelG21 = new LabelW(9, 9,
            "Systemtrenner und Feinfilter:");
        addCell(sheet2, labelG21);
        NumberW NumberAK21 = new NumberW(10, 9,
            f.anlkost.stffP, nf1cell);
        addCell(sheet2, NumberAK21);

        LabelW labelG22 = new LabelW(9, 11,
            "Gesamtanlagenpreis:");
        addCell(sheet2, labelG22);
        NumberW NumberAK22 = new NumberW(10, 11,
            f.anlkost.summe, nf1cell);
        addCell(sheet2, NumberAK22);

        LabelW labelG23 = new LabelW(9, 12,
            "Anlagenkosten/Jahr:");
        addCell(sheet2, labelG23);
        NumberW NumberAK23 = new NumberW(10, 12,
            f.anlkost.jahresBetrag, nf1cell);
        addCell(sheet2, NumberAK23);
        //} // Ende der for Schleife
        //**********

         //ENTHÄRTUNG
         f.enthaertung();

//Umlaufwasseranalyse
        LabelW labelEHUW1 = new LabelW(4, 0,
            f.aufbereitung, nf1cell);
        NumberW numberEHUW2 = new NumberW(4, 2,
            f.anauml.verSchnitt, nf1cell);
        NumberW numberEHUW3 = new NumberW(4, 3,
            f.anauml.eindickung, nf1cell);
        NumberW numberEHUW4 = new NumberW(4, 4, f.anauml.tKT,
            nf1cell);
        NumberW numberEHUW5 = new NumberW(4, 5, f.anauml.tW,
            nf1cell);
        NumberW numberEHUW6 = new NumberW(4, 6, f.anauml.lF,
            nf1cell);
        NumberW numberEHUW7 = new NumberW(4, 7, f.anauml.ca,
            nf1cell);
        NumberW numberEHUW8 = new NumberW(4, 8, f.anauml.mg,
            nf1cell);
        NumberW numberEHUW9 = new NumberW(4, 9, f.anauml.na,
            nf1cell);
        NumberW numberEHUW10 = new NumberW(4, 10, f.anauml.ks,
            nf1cell);
        NumberW numberEHUW11 = new NumberW(4, 11, f.anauml.cl,
            nf1cell);
        NumberW numberEHUW12 = new NumberW(4, 12,
            f.anauml.so4,
            nf1cell);
        NumberW numberEHUW13 = new NumberW(4, 13,
            f.anauml.no3,
            nf1cell);
        NumberW numberEHUW14 = new NumberW(4, 14,
            f.anauml.pHKTnV, nf1cell);
        NumberW numberEHUW15 = new NumberW(4, 15,
            f.anauml.pHTKT, nf1cell);
        NumberW numberEHUW16 = new NumberW(4, 16,
            f.anauml.siTKT, nf1cell);
        NumberW numberEHUW17 = new NumberW(4, 17,
            f.anauml.pHggWW, nf1cell);
        NumberW numberEHUW18 = new NumberW(4, 18,
            f.anauml.sIW,
            nf1cell);
        NumberW numberEHUW19 = new NumberW(4, 19,
            f.anauml.salz,
            nf1cell);
        NumberW numberEHUW20 = new NumberW(4, 20,
            f.anauml.ionen, nf1cell);
        NumberW numberEHUW21 = new NumberW(4, 21,
            f.anauml.h2co3, nf1cell);
        NumberW numberEHUW22 = new NumberW(4, 22,
            f.anauml.hco3,
            nf1cell);
        NumberW numberEHUW23 = new NumberW(4, 23,
            f.anauml.co3,
            nf1cell);

        addCell(sheet3, labelEHUW1);
        addCell(sheet3, numberEHUW2);

        addCell(sheet3, numberEHUW3);
        addCell(sheet3, numberEHUW4);
        addCell(sheet3, numberEHUW5);
        addCell(sheet3, numberEHUW6);
        addCell(sheet3, numberEHUW7);
        addCell(sheet3, numberEHUW8);
        addCell(sheet3, numberEHUW9);
        addCell(sheet3, numberEHUW10);
        addCell(sheet3, numberEHUW11);
        addCell(sheet3, numberEHUW12);
        addCell(sheet3, numberEHUW13);
        addCell(sheet3, numberEHUW14);
        addCell(sheet3, numberEHUW15);
        addCell(sheet3, numberEHUW16);
        addCell(sheet3, numberEHUW17);
        addCell(sheet3, numberEHUW18);
        addCell(sheet3, numberEHUW19);
        addCell(sheet3, numberEHUW20);
        addCell(sheet3, numberEHUW21);
        addCell(sheet3, numberEHUW22);
        addCell(sheet3, numberEHUW23);
//VERBRAUCH

        NumberW numberEHVB1 = new NumberW(7, 2,
            f.betrkost.enVer, nf1cell);
        NumberW numberEHVB2 = new NumberW(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        NumberW numberEHVB3 = new NumberW(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        NumberW numberEHVB4 = new NumberW(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        NumberW numberEHVB5 = new NumberW(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        NumberW numberEHVB6 = new NumberW(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        NumberW numberEHVB7 = new NumberW(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        NumberW numberEHVB8 = new NumberW(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        NumberW numberEHVB9 = new NumberW(7, 10,
            f.betrkost.roVer, nf1cell);

        addCell(sheet3, numberEHVB1);
        addCell(sheet3, numberEHVB2);
        addCell(sheet3, numberEHVB3);
        addCell(sheet3, numberEHVB4);
        addCell(sheet3, numberEHVB5);
        addCell(sheet3, numberEHVB6);
        addCell(sheet3, numberEHVB7);
        addCell(sheet3, numberEHVB8);
        addCell(sheet3, numberEHVB9);

//KOSTEN

        NumberW numberEHKO1 = new NumberW(7, 13,
            f.betrkost.enKost, nf1cell);
        NumberW numberEHKO2 = new NumberW(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        NumberW numberEHKO3 = new NumberW(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        NumberW numberEHKO4 = new NumberW(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        NumberW numberEHKO5 = new NumberW(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        NumberW numberEHKO6 = new NumberW(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        NumberW numberEHKO7 = new NumberW(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        NumberW numberEHKO8 = new NumberW(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        NumberW numberEHKO9 = new NumberW(7, 21,
            f.betrkost.roKost, nf1cell);
        NumberW numberEHKO10 = new NumberW(7, 22,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
            f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
            f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
            f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
            f.anlkost.jahresBetrag, nf1cell);

        addCell(sheet3, numberEHKO1);
        addCell(sheet3, numberEHKO2);
        addCell(sheet3, numberEHKO3);
        addCell(sheet3, numberEHKO4);
        addCell(sheet3, numberEHKO5);
        addCell(sheet3, numberEHKO6);
        addCell(sheet3, numberEHKO7);
        addCell(sheet3, numberEHKO8);
        addCell(sheet3, numberEHKO9);
        addCell(sheet3, numberEHKO10);
//*******************ANLAGE ENTHÄRTUNG*******+


         LabelW labelEHG1 = new LabelW(9, 0,
             "Anlageinformationen");
        addCell(sheet3, labelEHG1);
        LabelW labelEHAK1 = new LabelW(10, 0,
            f.anlkost.aufbereitungsart, nf1cell);
        addCell(sheet3, labelEHAK1);

        LabelW labelEHG2 = new LabelW(9, 2,
            "Anlage,Typ:");
        addCell(sheet3, labelEHG2);
        LabelW labelEHAK2 = new LabelW(10, 2, f.anlkost.typ1,
            nf1cell);
        addCell(sheet3, labelEHAK2);

        LabelW labelEHG3 = new LabelW(9, 3,
            "Kapazität:");
        addCell(sheet3, labelEHG3);
        NumberW numberEHAK3 = new NumberW(10, 3,
            f.anlkost.kap1, nf1cell);
        addCell(sheet3, numberEHAK3);

        LabelW labelEHG4 = new LabelW(9, 4,
            "Verrohrung:");
        addCell(sheet3, labelEHG4);
        LabelW labelEHAK4 = new LabelW(10, 4,
            f.anlkost.nennweite1, nf1cell);
        addCell(sheet3, labelEHAK4);

        LabelW labelEHG5 = new LabelW(9, 5,
            "Werkstoff:");
        addCell(sheet3, labelEHG5);
        LabelW labelEHAK5 = new LabelW(10, 5, f.anlkost.ws1,
            nf1cell);
        addCell(sheet3, labelEHAK5);

        LabelW labelEHG6 = new LabelW(9, 6,
            "Steuerung:");
        addCell(sheet3, labelEHG6);
        LabelW labelEHAK6 = new LabelW(10, 6, f.anlkost.st1,
            nf1cell);
        addCell(sheet3, labelEHAK6);

        LabelW labelEHG7 = new LabelW(9, 7,
            "Wassermengenzähler:");
        addCell(sheet3, labelEHG7);
        LabelW labelEHAK7 = new LabelW(10, 7, f.anlkost.wz1,
            nf1cell);
        addCell(sheet3, labelEHAK7);

        LabelW labelEHG9 = new LabelW(9, 8,
            "Richtpreis einschl. Montage:");
        addCell(sheet3, labelEHG9);
        NumberW numberEHAK9 = new NumberW(10, 8,
            f.anlkost.aP1, nf1cell);
        addCell(sheet3, numberEHAK9);
        //
        //


        LabelW labelEHG15 = new LabelW(9, 10,
            "Anlage,Typ:");
        addCell(sheet3, labelEHG15);
        LabelW labelEHAK15 = new LabelW(10, 10,
            f.anlkost.typ3, nf1cell);
        addCell(sheet3, labelEHAK15);

        LabelW labelEHG16 = new LabelW(9, 11,
            "Dosier und Schutzbehälter:");
        addCell(sheet3, labelEHG16);
        LabelW labelEHAK16 = new LabelW(10, 11,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        addCell(sheet3, labelEHAK16);

        LabelW labelEHG17 = new LabelW(9, 12,
            "Werkstoff:");
        addCell(sheet3, labelEHG17);
        LabelW labelEHAK17 = new LabelW(10, 12,
            f.anlkost.ws3, nf1cell);

        LabelW labelEHG18 = new LabelW(9, 13,
            "Steuerung::");
        addCell(sheet3, labelEHG18);
        addCell(sheet3, labelEHAK17);
        LabelW labelEHAK18 = new LabelW(10, 13,
            f.anlkost.st3, nf1cell);
        addCell(sheet3, labelEHAK18);

        LabelW labelEHG19 = new LabelW(9, 14,
            "Wassermengenzähler:");
        addCell(sheet3, labelEHG19);
        LabelW numberEHAK19 = new LabelW(10, 14,
            f.anlkost.wz3, nf1cell);
        addCell(sheet3, numberEHAK19);

        LabelW labelEHG20 = new LabelW(9, 15,
            "Richtpreis einschl. Montage:");
        addCell(sheet3, labelEHG20);
        NumberW numberEHAK20 = new NumberW(10, 15,
            f.anlkost.aP3, nf1cell);
        addCell(sheet3, numberEHAK20);

        LabelW labelEHG21 = new LabelW(9, 16,
            "Systemtrenner und Feinfilter:");
        addCell(sheet3, labelEHG21);
        NumberW numberEHAK21 = new NumberW(10, 16,
            f.anlkost.stffP, nf1cell);
        addCell(sheet3, numberEHAK21);

        LabelW labelEHG22 = new LabelW(9, 18,
            "Gesamtanlagenpreis:");
        addCell(sheet3, labelEHG22);
        NumberW numberEHAK22 = new NumberW(10, 18,
            f.anlkost.summe, nf1cell);
        addCell(sheet3, numberEHAK22);

        LabelW labelEHG23 = new LabelW(9, 19,
            "Anlagenkosten/Jahr:");
        addCell(sheet3, labelEHG23);
        NumberW numberEHAK23 = new NumberW(10, 19,
            f.anlkost.jahresBetrag, nf1cell);
        addCell(sheet3, numberEHAK23);
//} // Ende der for Schleife
//*************************ENDE ANLAGE ENTHÄRTUNG*******

//ENTCARBONISIERUNG
         f.entcarbonisierung();

//Umlaufwasseranalyse
        LabelW labelECUW1 = new LabelW(4, 0,
            f.aufbereitung, nf1cell);
        NumberW numberECUW2 = new NumberW(4, 2,
            f.anauml.verSchnitt, nf1cell);
        NumberW numberECUW3 = new NumberW(4, 3,
            f.anauml.eindickung, nf1cell);
        NumberW numberECUW4 = new NumberW(4, 4, f.anauml.tKT,
            nf1cell);
        NumberW numberECUW5 = new NumberW(4, 5, f.anauml.tW,
            nf1cell);
        NumberW numberECUW6 = new NumberW(4, 6, f.anauml.lF,
            nf1cell);
        NumberW numberECUW7 = new NumberW(4, 7, f.anauml.ca,
            nf1cell);
        NumberW numberECUW8 = new NumberW(4, 8, f.anauml.mg,
            nf1cell);
        NumberW numberECUW9 = new NumberW(4, 9, f.anauml.na,
            nf1cell);
        NumberW numberECUW10 = new NumberW(4, 10, f.anauml.ks,
            nf1cell);
        NumberW numberECUW11 = new NumberW(4, 11, f.anauml.cl,
            nf1cell);
        NumberW numberECUW12 = new NumberW(4, 12,
            f.anauml.so4,
            nf1cell);
        NumberW numberECUW13 = new NumberW(4, 13,
            f.anauml.no3,
            nf1cell);
        NumberW numberECUW14 = new NumberW(4, 14,
            f.anauml.pHKTnV, nf1cell);
        NumberW numberECUW15 = new NumberW(4, 15,
            f.anauml.pHTKT, nf1cell);
        NumberW numberECUW16 = new NumberW(4, 16,
            f.anauml.siTKT, nf1cell);
        NumberW numberECUW17 = new NumberW(4, 17,
            f.anauml.pHggWW, nf1cell);
        NumberW numberECUW18 = new NumberW(4, 18,
            f.anauml.sIW,
            nf1cell);
        NumberW numberECUW19 = new NumberW(4, 19,
            f.anauml.salz,
            nf1cell);
        NumberW numberECUW20 = new NumberW(4, 20,
            f.anauml.ionen, nf1cell);
        NumberW numberECUW21 = new NumberW(4, 21,
            f.anauml.h2co3, nf1cell);
        NumberW numberECUW22 = new NumberW(4, 22,
            f.anauml.hco3,
            nf1cell);
        NumberW numberECUW23 = new NumberW(4, 23,
            f.anauml.co3,
            nf1cell);

        addCell(sheet4, labelECUW1);
        addCell(sheet4, numberECUW2);

        addCell(sheet4, numberECUW3);
        addCell(sheet4, numberECUW4);
        addCell(sheet4, numberECUW5);
        addCell(sheet4, numberECUW6);
        addCell(sheet4, numberECUW7);
        addCell(sheet4, numberECUW8);
        addCell(sheet4, numberECUW9);
        addCell(sheet4, numberECUW10);
        addCell(sheet4, numberECUW11);
        addCell(sheet4, numberECUW12);
        addCell(sheet4, numberECUW13);
        addCell(sheet4, numberECUW14);
        addCell(sheet4, numberECUW15);
        addCell(sheet4, numberECUW16);
        addCell(sheet4, numberECUW17);
        addCell(sheet4, numberECUW18);
        addCell(sheet4, numberECUW19);
        addCell(sheet4, numberECUW20);
        addCell(sheet4, numberECUW21);
        addCell(sheet4, numberECUW22);
        addCell(sheet4, numberECUW23);
//VERBRAUCH

        NumberW numberECVB1 = new NumberW(7, 2,
            f.betrkost.enVer, nf1cell);
        NumberW numberECVB2 = new NumberW(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        NumberW numberECVB3 = new NumberW(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        NumberW numberECVB4 = new NumberW(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        NumberW numberECVB5 = new NumberW(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        NumberW numberECVB6 = new NumberW(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        NumberW numberECVB7 = new NumberW(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        NumberW numberECVB8 = new NumberW(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        NumberW numberECVB9 = new NumberW(7, 10,
            f.betrkost.roVer, nf1cell);
        addCell(sheet4, numberECVB1);
        addCell(sheet4, numberECVB2);
        addCell(sheet4, numberECVB3);
        addCell(sheet4, numberECVB4);
        addCell(sheet4, numberECVB5);
        addCell(sheet4, numberECVB6);
        addCell(sheet4, numberECVB7);
        addCell(sheet4, numberECVB8);
        addCell(sheet4, numberECVB9);

//KOSTEN

        NumberW numberECKO1 = new NumberW(7, 13,
            f.betrkost.enKost, nf1cell);
        NumberW numberECKO2 = new NumberW(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        NumberW numberECKO3 = new NumberW(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        NumberW numberECKO4 = new NumberW(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        NumberW numberECKO5 = new NumberW(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        NumberW numberECKO6 = new NumberW(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        NumberW numberECKO7 = new NumberW(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        NumberW numberECKO8 = new NumberW(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        NumberW numberECKO9 = new NumberW(7, 21,
            f.betrkost.roKost, nf1cell);
        NumberW numberECKO10 = new NumberW(7, 22,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
            f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
            f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
            f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
            f.anlkost.jahresBetrag, nf1cell);

        addCell(sheet4, numberECKO1);
        addCell(sheet4, numberECKO2);
        addCell(sheet4, numberECKO3);
        addCell(sheet4, numberECKO4);
        addCell(sheet4, numberECKO5);
        addCell(sheet4, numberECKO6);
        addCell(sheet4, numberECKO7);
        addCell(sheet4, numberECKO8);
        addCell(sheet4, numberECKO9);
        addCell(sheet4, numberECKO10);

//*****ANLAGE ENTCARBONISIERUNG*******




         LabelW labelECG1 = new LabelW(9, 0,
             "Anlageinformationen");
        addCell(sheet4, labelECG1);
        LabelW labelECAK1 = new LabelW(10, 0,
            f.anlkost.aufbereitungsart, nf1cell);
        addCell(sheet4, labelECAK1);

        LabelW labelECG2 = new LabelW(9, 2,
            "Anlage,Typ:");
        addCell(sheet4, labelECG2);
        LabelW labelECAK2 = new LabelW(10, 2, f.anlkost.typ1,
            nf1cell);
        addCell(sheet4, labelECAK2);

        LabelW labelECG3 = new LabelW(9, 3,
            "Kapazität:");
        addCell(sheet4, labelECG3);
        NumberW numberECAK3 = new NumberW(10, 3,
            f.anlkost.kap1, nf1cell);
        addCell(sheet4, numberECAK3);

        LabelW labelECG4 = new LabelW(9, 4,
            "Verrohrung:");
        addCell(sheet4, labelECG4);
        LabelW labelECAK4 = new LabelW(10, 4,
            f.anlkost.nennweite1, nf1cell);
        addCell(sheet4, labelECAK4);

        LabelW labelECG5 = new LabelW(9, 5,
            "Werkstoff:");
        addCell(sheet4, labelECG5);
        LabelW labelECAK5 = new LabelW(10, 5, f.anlkost.ws1,
            nf1cell);
        addCell(sheet4, labelECAK5);

        LabelW labelECG6 = new LabelW(9, 6,
            "Steuerung:");
        addCell(sheet4, labelECG6);
        LabelW labelECAK6 = new LabelW(10, 6, f.anlkost.st1,
            nf1cell);
        addCell(sheet4, labelECAK6);

        LabelW labelECG7 = new LabelW(9, 7,
            "Wassermengenzähler:");
        addCell(sheet4, labelECG7);
        LabelW labelECAK7 = new LabelW(10, 7, f.anlkost.wz1,
            nf1cell);
        addCell(sheet4, labelECAK7);

        LabelW labelECG8 = new LabelW(9, 8,
            "Neutralfilter:");
        addCell(sheet4, labelECG8);
        LabelW labelECAK8 = new LabelW(10, 8, f.anlkost.nf,
            nf1cell);
        addCell(sheet4, labelECAK8);

        LabelW labelECG9 = new LabelW(9, 9,
            "Richtpreis einschl. Montage:");
        addCell(sheet4, labelECG9);
        NumberW numberECAK9 = new NumberW(10, 9,
            f.anlkost.aP1, nf1cell);
        addCell(sheet4, numberECAK9);
        //
        //

        LabelW labelECG15 = new LabelW(9, 11,
            "Anlage,Typ:");
        addCell(sheet4, labelECG15);
        LabelW labelECAK15 = new LabelW(10, 11,
            f.anlkost.typ3, nf1cell);
        addCell(sheet4, labelECAK15);

        LabelW labelECG16 = new LabelW(9, 12,
            "Dosier und Schutzbehälter:");
        addCell(sheet4, labelECG16);
        LabelW labelECAK16 = new LabelW(10, 12,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        addCell(sheet4, labelECAK16);

        LabelW labelECG17 = new LabelW(9, 13,
            "Werkstoff:");
        addCell(sheet4, labelECG17);
        LabelW labelECAK17 = new LabelW(10, 13,
            f.anlkost.ws3, nf1cell);

        LabelW labelECG18 = new LabelW(9, 14,
            "Steuerung::");
        addCell(sheet4, labelECG18);
        addCell(sheet4, labelECAK17);
        LabelW labelECAK18 = new LabelW(10, 14,
            f.anlkost.st3, nf1cell);
        addCell(sheet4, labelECAK18);

        LabelW labelECG19 = new LabelW(9, 15,
            "Wassermengenzähler:");
        addCell(sheet4, labelECG19);
        LabelW numberECAK19 = new LabelW(10, 15,
            f.anlkost.wz3, nf1cell);
        addCell(sheet4, numberECAK19);

        LabelW labelECG20 = new LabelW(9, 16,
            "Richtpreis einschl. Montage:");
        addCell(sheet4, labelECG20);
        NumberW numberECAK20 = new NumberW(10, 16,
            f.anlkost.aP3, nf1cell);
        addCell(sheet4, numberECAK20);

        LabelW labelECG21 = new LabelW(9, 17,
            "Systemtrenner und Feinfilter:");
        addCell(sheet4, labelECG21);
        NumberW numberECAK21 = new NumberW(10, 17,
            f.anlkost.stffP, nf1cell);
        addCell(sheet4, numberECAK21);

        LabelW labelECG22 = new LabelW(9, 19,
            "Gesamtanlagenpreis:");
        addCell(sheet4, labelECG22);
        NumberW numberECAK22 = new NumberW(10, 19,
            f.anlkost.summe, nf1cell);
        addCell(sheet4, numberECAK22);

        LabelW labelECG23 = new LabelW(9, 20,
            "Anlagenkosten/Jahr:");
        addCell(sheet4, labelECG23);
        NumberW numberECAK23 = new NumberW(10, 20,
            f.anlkost.jahresBetrag, nf1cell);
        addCell(sheet4, numberECAK23);
//************************************
//UMKEHROSMOSE OHNE ENTHÄRTUNG
         f.umkehrosmoseo();

//Umlaufwasseranalyse
        LabelW labelUOOUW1 = new LabelW(4, 0,
            f.aufbereitung, nf1cell);
        NumberW numberUOOUW2 = new NumberW(4, 2,
            f.anauml.verSchnitt, nf1cell);
        NumberW numberUOOUW3 = new NumberW(4, 3,
            f.anauml.eindickung, nf1cell);
        NumberW numberUOOUW4 = new NumberW(4, 4, f.anauml.tKT,
            nf1cell);
        NumberW numberUOOUW5 = new NumberW(4, 5, f.anauml.tW,
            nf1cell);
        NumberW numberUOOUW6 = new NumberW(4, 6, f.anauml.lF,
            nf1cell);
        NumberW numberUOOUW7 = new NumberW(4, 7, f.anauml.ca,
            nf1cell);
        NumberW numberUOOUW8 = new NumberW(4, 8, f.anauml.mg,
            nf1cell);
        NumberW numberUOOUW9 = new NumberW(4, 9, f.anauml.na,
            nf1cell);
        NumberW numberUOOUW10 = new NumberW(4, 10,
            f.anauml.ks,
            nf1cell);
        NumberW numberUOOUW11 = new NumberW(4, 11,
            f.anauml.cl,
            nf1cell);
        NumberW numberUOOUW12 = new NumberW(4, 12,
            f.anauml.so4,
            nf1cell);
        NumberW numberUOOUW13 = new NumberW(4, 13,
            f.anauml.no3,
            nf1cell);
        NumberW numberUOOUW14 = new NumberW(4, 14,
            f.anauml.pHKTnV, nf1cell);
        NumberW numberUOOUW15 = new NumberW(4, 15,
            f.anauml.pHTKT, nf1cell);
        NumberW numberUOOUW16 = new NumberW(4, 16,
            f.anauml.siTKT, nf1cell);
        NumberW numberUOOUW17 = new NumberW(4, 17,
            f.anauml.pHggWW, nf1cell);
        NumberW numberUOOUW18 = new NumberW(4, 18,
            f.anauml.sIW,
            nf1cell);
        NumberW numberUOOUW19 = new NumberW(4, 19,
            f.anauml.salz,
            nf1cell);
        NumberW numberUOOUW20 = new NumberW(4, 20,
            f.anauml.ionen, nf1cell);
        NumberW numberUOOUW21 = new NumberW(4, 21,
            f.anauml.h2co3, nf1cell);
        NumberW numberUOOUW22 = new NumberW(4, 22,
            f.anauml.hco3,
            nf1cell);
        NumberW numberUOOUW23 = new NumberW(4, 23,
            f.anauml.co3,
            nf1cell);
        addCell(sheet5, labelUOOUW1);
        addCell(sheet5, numberUOOUW2);
        addCell(sheet5, numberUOOUW3);
        addCell(sheet5, numberUOOUW4);
        addCell(sheet5, numberUOOUW5);
        addCell(sheet5, numberUOOUW6);
        addCell(sheet5, numberUOOUW7);
        addCell(sheet5, numberUOOUW8);
        addCell(sheet5, numberUOOUW9);
        addCell(sheet5, numberUOOUW10);
        addCell(sheet5, numberUOOUW11);
        addCell(sheet5, numberUOOUW12);
        addCell(sheet5, numberUOOUW13);
        addCell(sheet5, numberUOOUW14);
        addCell(sheet5, numberUOOUW15);
        addCell(sheet5, numberUOOUW16);
        addCell(sheet5, numberUOOUW17);
        addCell(sheet5, numberUOOUW18);
        addCell(sheet5, numberUOOUW19);
        addCell(sheet5, numberUOOUW20);
        addCell(sheet5, numberUOOUW21);
        addCell(sheet5, numberUOOUW22);
        addCell(sheet5, numberUOOUW23);
//VERBRAUCH

        NumberW numberUOOVB1 = new NumberW(7, 2,
            f.betrkost.enVer, nf1cell);
        NumberW numberUOOVB2 = new NumberW(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        NumberW numberUOOVB3 = new NumberW(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        NumberW numberUOOVB4 = new NumberW(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        NumberW numberUOOVB5 = new NumberW(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        NumberW numberUOOVB6 = new NumberW(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        NumberW numberUOOVB7 = new NumberW(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        NumberW numberUOOVB8 = new NumberW(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        NumberW numberUOOVB9 = new NumberW(7, 10,
            f.betrkost.roVer, nf1cell);

        addCell(sheet5, numberUOOVB1);
        addCell(sheet5, numberUOOVB2);
        addCell(sheet5, numberUOOVB3);
        addCell(sheet5, numberUOOVB4);
        addCell(sheet5, numberUOOVB5);
        addCell(sheet5, numberUOOVB6);
        addCell(sheet5, numberUOOVB7);
        addCell(sheet5, numberUOOVB8);
        addCell(sheet5, numberUOOVB9);

//KOSTEN

        NumberW numberUOOKO1 = new NumberW(7, 13,
            f.betrkost.enKost, nf1cell);
        NumberW numberUOOKO2 = new NumberW(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        NumberW numberUOOKO3 = new NumberW(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        NumberW numberUOOKO4 = new NumberW(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        NumberW numberUOOKO5 = new NumberW(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        NumberW numberUOOKO6 = new NumberW(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        NumberW numberUOOKO7 = new NumberW(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        NumberW numberUOOKO8 = new NumberW(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        NumberW numberUOOKO9 = new NumberW(7, 21,
            f.betrkost.roKost, nf1cell);
        NumberW numberUOOKO10 = new NumberW(7, 22,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
             f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
             f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
             f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
             f.anlkost.jahresBetrag, nf1cell);

        addCell(sheet5, numberUOOKO1);
        addCell(sheet5, numberUOOKO2);
        addCell(sheet5, numberUOOKO3);
        addCell(sheet5, numberUOOKO4);
        addCell(sheet5, numberUOOKO5);
        addCell(sheet5, numberUOOKO6);
        addCell(sheet5, numberUOOKO7);
        addCell(sheet5, numberUOOKO8);
        addCell(sheet5, numberUOOKO9);
        addCell(sheet5, numberUOOKO10);

//UMKEHROSMOSE OHNE ENTHÄRTUNG*******************************
        //ANLAGE


        LabelW labelUOOG1 = new LabelW(9, 0,
            "Anlageinformationen");
        addCell(sheet5, labelUOOG1);
        LabelW labelUOOAK1 = new LabelW(10, 0,
            f.anlkost.aufbereitungsart, nf1cell);
        addCell(sheet5, labelUOOAK1);

        LabelW labelUOOG10 = new LabelW(9, 2,
            "Anlage,Typ:");
        addCell(sheet5, labelUOOG10);
        LabelW labelUOOAK10 = new LabelW(10, 2,
            f.anlkost.typ2, nf1cell);
        addCell(sheet5, labelUOOAK10);

        LabelW labelUOOG11 = new LabelW(9, 3,
            "Leistung:");
        addCell(sheet5, labelUOOG11);
        NumberW numberUOOAK11 = new NumberW(10, 3,
            f.anlkost.kap2, nf1cell);
        addCell(sheet5, numberUOOAK11);

        LabelW labelUOOG12 = new LabelW(9, 4,
            "Verrohrung:");
        addCell(sheet5, labelUOOG12);
        LabelW labelUOOAK12 = new LabelW(10, 4,
            f.anlkost.ws2, nf1cell);
        addCell(sheet5, labelUOOAK12);

        LabelW labelUOOG13 = new LabelW(9, 5,
            "Steuerung:");
        addCell(sheet5, labelUOOG13);
        LabelW labelUOOAK13 = new LabelW(10, 5,
            f.anlkost.st2, nf1cell);
        addCell(sheet5, labelUOOAK13);

        LabelW labelUOOG14 = new LabelW(9, 6,
            "Richtpreis einschl. Montage::");
        addCell(sheet5, labelUOOG14);
        NumberW numberUOOAK14 = new NumberW(10, 6,
            f.anlkost.aP2, nf1cell);
        addCell(sheet5, numberUOOAK14);

        LabelW labelUOOG15 = new LabelW(9, 8,
            "Anlage,Typ:");
        addCell(sheet5, labelUOOG15);
        LabelW labelUOOAK15 = new LabelW(10, 8,
            f.anlkost.typ3, nf1cell);
        addCell(sheet5, labelUOOAK15);

        LabelW labelUOOG16 = new LabelW(9, 9,
            "Dosier und Schutzbehälter:");
        addCell(sheet5, labelUOOG16);
        LabelW labelUOOAK16 = new LabelW(10, 9,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        addCell(sheet5, labelUOOAK16);

        LabelW labelUOOG17 = new LabelW(9, 10,
            "Werkstoff:");
        addCell(sheet5, labelUOOG17);
        LabelW labelUOOAK17 = new LabelW(10, 10,
            f.anlkost.ws3, nf1cell);

        LabelW labelUOOG18 = new LabelW(9, 11,
            "Steuerung::");
        addCell(sheet5, labelUOOG18);
        addCell(sheet5, labelUOOAK17);
        LabelW labelUOOAK18 = new LabelW(10, 11,
            f.anlkost.st3, nf1cell);
        addCell(sheet5, labelUOOAK18);

        LabelW labelUOOG19 = new LabelW(9, 12,
            "Wassermengenzähler:");
        addCell(sheet5, labelUOOG19);
        LabelW numberUOOAK19 = new LabelW(10, 12,
            f.anlkost.wz3, nf1cell);
        addCell(sheet5, numberUOOAK19);

        LabelW labelUOOG20 = new LabelW(9, 13,
            "Richtpreis einschl. Montage:");
        addCell(sheet5, labelUOOG20);
        NumberW numberUOOAK20 = new NumberW(10, 13,
            f.anlkost.aP3, nf1cell);
        addCell(sheet5, numberUOOAK20);

        LabelW labelUOOG21 = new LabelW(9, 14,
            "Systemtrenner und Feinfilter:");
        addCell(sheet5, labelUOOG21);
        NumberW numberUOOAK21 = new NumberW(10, 14,
            f.anlkost.stffP, nf1cell);
        addCell(sheet5, numberUOOAK21);

        LabelW labelUOOG22 = new LabelW(9, 16,
            "Gesamtanlagenpreis:");
        addCell(sheet5, labelUOOG22);
        NumberW numberUOOAK22 = new NumberW(10, 16,
            f.anlkost.summe, nf1cell);
        addCell(sheet5, numberUOOAK22);

        LabelW labelUOOG23 = new LabelW(9, 17,
            "Anlagenkosten/Jahr:");
        addCell(sheet5, labelUOOG23);
        NumberW numberUOOAK23 = new NumberW(10, 17,
            f.anlkost.jahresBetrag, nf1cell);
        addCell(sheet5, numberUOOAK23);
        //} // Ende der for Schleife

        // ************************************************
//UMKEHROSMOSE MIT ENTHÄRTUNG
        f.umkehrosmosem();

//Umlaufwasseranalyse
        LabelW labelUOMUW1 = new LabelW(4, 0,
            f.aufbereitung, nf1cell);
        NumberW numberUOMUW2 = new NumberW(4, 2,
            f.anauml.verSchnitt, nf1cell);
        NumberW numberUOMUW3 = new NumberW(4, 3,
            f.anauml.eindickung, nf1cell);
        NumberW numberUOMUW4 = new NumberW(4, 4, f.anauml.tKT,
            nf1cell);
        NumberW numberUOMUW5 = new NumberW(4, 5, f.anauml.tW,
            nf1cell);
        NumberW numberUOMUW6 = new NumberW(4, 6, f.anauml.lF,
            nf1cell);
        NumberW numberUOMUW7 = new NumberW(4, 7, f.anauml.ca,
            nf1cell);
        NumberW numberUOMUW8 = new NumberW(4, 8, f.anauml.mg,
            nf1cell);
        NumberW numberUOMUW9 = new NumberW(4, 9, f.anauml.na,
            nf1cell);
        NumberW numberUOMUW10 = new NumberW(4, 10,
            f.anauml.ks,
            nf1cell);
        NumberW numberUOMUW11 = new NumberW(4, 11,
            f.anauml.cl,
            nf1cell);
        NumberW numberUOMUW12 = new NumberW(4, 12,
            f.anauml.so4,
            nf1cell);
        NumberW numberUOMUW13 = new NumberW(4, 13,
            f.anauml.no3,
            nf1cell);
        NumberW numberUOMUW14 = new NumberW(4, 14,
            f.anauml.pHKTnV, nf1cell);
        NumberW numberUOMUW15 = new NumberW(4, 15,
            f.anauml.pHTKT, nf1cell);
        NumberW numberUOMUW16 = new NumberW(4, 16,
            f.anauml.siTKT, nf1cell);
        NumberW numberUOMUW17 = new NumberW(4, 17,
            f.anauml.pHggWW, nf1cell);
        NumberW numberUOMUW18 = new NumberW(4, 18,
            f.anauml.sIW,
            nf1cell);
        NumberW numberUOMUW19 = new NumberW(4, 19,
            f.anauml.salz,
            nf1cell);
        NumberW numberUOMUW20 = new NumberW(4, 20,
            f.anauml.ionen, nf1cell);
        NumberW numberUOMUW21 = new NumberW(4, 21,
            f.anauml.h2co3, nf1cell);
        NumberW numberUOMUW22 = new NumberW(4, 22,
            f.anauml.hco3,
            nf1cell);
        NumberW numberUOMUW23 = new NumberW(4, 23,
            f.anauml.co3,
            nf1cell);

        addCell(sheet6, labelUOMUW1);
        addCell(sheet6, numberUOMUW2);
        addCell(sheet6, numberUOMUW3);
        addCell(sheet6, numberUOMUW4);
        addCell(sheet6, numberUOMUW5);
        addCell(sheet6, numberUOMUW6);
        addCell(sheet6, numberUOMUW7);
        addCell(sheet6, numberUOMUW8);
        addCell(sheet6, numberUOMUW9);
        addCell(sheet6, numberUOMUW10);
        addCell(sheet6, numberUOMUW11);
        addCell(sheet6, numberUOMUW12);
        addCell(sheet6, numberUOMUW13);
        addCell(sheet6, numberUOMUW14);
        addCell(sheet6, numberUOMUW15);
        addCell(sheet6, numberUOMUW16);
        addCell(sheet6, numberUOMUW17);
        addCell(sheet6, numberUOMUW18);
        addCell(sheet6, numberUOMUW19);
        addCell(sheet6, numberUOMUW20);
        addCell(sheet6, numberUOMUW21);
        addCell(sheet6, numberUOMUW22);
        addCell(sheet6, numberUOMUW23);
//VERBRAUCH

        NumberW numberUOMVB1 = new NumberW(7, 2,
            f.betrkost.enVer, nf1cell);
        NumberW numberUOMVB2 = new NumberW(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        NumberW numberUOMVB3 = new NumberW(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        NumberW numberUOMVB4 = new NumberW(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        NumberW numberUOMVB5 = new NumberW(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        NumberW numberUOMVB6 = new NumberW(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        NumberW numberUOMVB7 = new NumberW(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        NumberW numberUOMVB8 = new NumberW(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        NumberW numberUOMVB9 = new NumberW(7, 10,
            f.betrkost.roVer, nf1cell);

        addCell(sheet6, numberUOMVB1);
        addCell(sheet6, numberUOMVB2);
        addCell(sheet6, numberUOMVB3);
        addCell(sheet6, numberUOMVB4);
        addCell(sheet6, numberUOMVB5);
        addCell(sheet6, numberUOMVB6);
        addCell(sheet6, numberUOMVB7);
        addCell(sheet6, numberUOMVB8);
        addCell(sheet6, numberUOMVB9);

//KOSTEN

        NumberW numberUOMKO1 = new NumberW(7, 13,
            f.betrkost.enKost, nf1cell);
        NumberW numberUOMKO2 = new NumberW(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        NumberW numberUOMKO3 = new NumberW(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        NumberW numberUOMKO4 = new NumberW(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        NumberW numberUOMKO5 = new NumberW(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        NumberW numberUOMKO6 = new NumberW(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        NumberW numberUOMKO7 = new NumberW(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        NumberW numberUOMKO8 = new NumberW(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        NumberW numberUOMKO9 = new NumberW(7, 21,
            f.betrkost.roKost, nf1cell);
        NumberW numberUOMKO10 = new NumberW(7, 22,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
             f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
             f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
             f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
             f.anlkost.jahresBetrag, nf1cell);

        addCell(sheet6, numberUOMKO1);
        addCell(sheet6, numberUOMKO2);
        addCell(sheet6, numberUOMKO3);
        addCell(sheet6, numberUOMKO4);
        addCell(sheet6, numberUOMKO5);
        addCell(sheet6, numberUOMKO6);
        addCell(sheet6, numberUOMKO7);
        addCell(sheet6, numberUOMKO8);
        addCell(sheet6, numberUOMKO9);
        addCell(sheet6, numberUOMKO10);

        //*********ANLAGE UMKEHROSMOSE MIT ENTHÄRTUNG****************


         LabelW labelUOMG1 = new LabelW(9, 0,
             "Anlageinformation für Aufbereitungsart:");
        addCell(sheet6, labelUOMG1);
        LabelW labelUOMAK1 = new LabelW(10, 0,
            f.anlkost.aufbereitungsart, nf1cell);
        addCell(sheet6, labelUOMAK1);

        LabelW labelUOMG2 = new LabelW(9, 2,
            "Anlage,Typ:");
        addCell(sheet6, labelUOMG2);
        LabelW labelUOMAK2 = new LabelW(10, 2, f.anlkost.typ1,
            nf1cell);
        addCell(sheet6, labelUOMAK2);

        LabelW labelUOMG3 = new LabelW(9, 3,
            "Kapazität:");
        addCell(sheet6, labelUOMG3);
        NumberW numberlUOMAK3 = new NumberW(10, 3,
            f.anlkost.kap1, nf1cell);
        addCell(sheet6, numberlUOMAK3);

        LabelW labelUOMG4 = new LabelW(9, 4,
            "Verrohrung:");
        addCell(sheet6, labelUOMG4);
        LabelW labelUOMAK4 = new LabelW(10, 4,
            f.anlkost.nennweite1, nf1cell);
        addCell(sheet6, labelUOMAK4);

        LabelW labelUOMG5 = new LabelW(9, 5,
            "Werkstoff:");
        addCell(sheet6, labelUOMG5);
        LabelW labelUOMAK5 = new LabelW(10, 5, f.anlkost.ws1,
            nf1cell);
        addCell(sheet6, labelUOMAK5);

        LabelW labelUOMG6 = new LabelW(9, 6,
            "Steuerung:");
        addCell(sheet6, labelUOMG6);
        LabelW labelUOMAK6 = new LabelW(10, 6, f.anlkost.st1,
            nf1cell);
        addCell(sheet6, labelUOMAK6);

        LabelW labelUOMG7 = new LabelW(9, 7,
            "Wassermengenzähler:");
        addCell(sheet6, labelUOMG7);
        LabelW labelUOMAK7 = new LabelW(10, 7, f.anlkost.wz1,
            nf1cell);
        addCell(sheet6, labelUOMAK7);

        LabelW labelUOMG9 = new LabelW(9, 8,
            "Richtpreis einschl. Montage:");
        addCell(sheet6, labelUOMG9);
        NumberW numberlUOMAK9 = new NumberW(10, 8,
            f.anlkost.aP1, nf1cell);
        addCell(sheet6, numberlUOMAK9);
        //
        //

        LabelW labelUOMG10 = new LabelW(9, 10,
            "Anlage,Typ:");
        addCell(sheet6, labelUOMG10);
        LabelW labelUOMAK10 = new LabelW(10, 10,
            f.anlkost.typ2, nf1cell);
        addCell(sheet6, labelUOMAK10);

        LabelW labelUOMG11 = new LabelW(9, 11,
            "Leistung:");
        addCell(sheet6, labelUOMG11);
        NumberW numberlUOMAK11 = new NumberW(10, 11,
            f.anlkost.kap2, nf1cell);
        addCell(sheet6, numberlUOMAK11);

        LabelW labelUOMG12 = new LabelW(9, 12,
            "Verrohrung:");
        addCell(sheet6, labelUOMG12);
        LabelW labelUOMAK12 = new LabelW(10, 12,
            f.anlkost.ws2, nf1cell);
        addCell(sheet6, labelUOMAK12);

        LabelW labelUOMG13 = new LabelW(9, 13,
            "Steuerung:");
        addCell(sheet6, labelUOMG13);
        LabelW labelUOMAK13 = new LabelW(10, 13,
            f.anlkost.st2, nf1cell);
        addCell(sheet6, labelUOMAK13);

        /*LabelW labelUOMG14 = new LabelW(13, 0,
                   "Dosierstation:");
                   addCell(sheet6, labelUOMG14);

                   LabelW labelUOMG15 = new LabelW(14, 0,
                   "Dosierstation:");
                   addCell(sheet6, labelUOMG15);
         */
        LabelW labelUOMG14 = new LabelW(9, 14,
            "Richtpreis einschl. Montage::");
        addCell(sheet6, labelUOMG14);
        NumberW numberlUOMAK14 = new NumberW(10, 14,
            f.anlkost.aP2, nf1cell);
        addCell(sheet6, numberlUOMAK14);

        LabelW labelUOMG15 = new LabelW(9, 16,
            "Anlage,Typ:");
        addCell(sheet6, labelUOMG15);
        LabelW labelUOMAK15 = new LabelW(10, 16,
            f.anlkost.typ3, nf1cell);
        addCell(sheet6, labelUOMAK15);

        LabelW labelUOMG16 = new LabelW(9, 17,
            "Dosier und Schutzbehälter:");
        addCell(sheet6, labelUOMG16);
        LabelW labelUOMAK16 = new LabelW(10, 17,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        addCell(sheet6, labelUOMAK16);

        LabelW labelUOMG17 = new LabelW(9, 18,
            "Werkstoff:");
        addCell(sheet6, labelUOMG17);
        LabelW labelUOMAK17 = new LabelW(10, 18,
            f.anlkost.ws3, nf1cell);

        LabelW labelUOMG18 = new LabelW(9, 19,
            "Steuerung::");
        addCell(sheet6, labelUOMG18);
        addCell(sheet6, labelUOMAK17);
        LabelW labelUOMAK18 = new LabelW(10, 19,
            f.anlkost.st3, nf1cell);
        addCell(sheet6, labelUOMAK18);

        LabelW labelUOMG19 = new LabelW(9, 20,
            "Wassermengenzähler:");
        addCell(sheet6, labelUOMG19);
        LabelW numberlUOMAK19 = new LabelW(10, 20,
            f.anlkost.wz3, nf1cell);
        addCell(sheet6, numberlUOMAK19);

        LabelW labelUOMG20 = new LabelW(9, 21,
            "Richtpreis einschl. Montage:");
        addCell(sheet6, labelUOMG20);
        NumberW numberlUOMAK20 = new NumberW(10, 21,
            f.anlkost.aP3, nf1cell);
        addCell(sheet6, numberlUOMAK20);

        LabelW labelUOMG21 = new LabelW(9, 22,
            "Systemtrenner und Feinfilter:");
        addCell(sheet6, labelUOMG21);
        NumberW numberlUOMAK21 = new NumberW(10, 22,
            f.anlkost.stffP, nf1cell);
        addCell(sheet6, numberlUOMAK21);

        LabelW labelUOMG22 = new LabelW(9, 24,
            "Gesamtanlagenpreis:");
        addCell(sheet6, labelUOMG22);
        NumberW numberlUOMAK22 = new NumberW(10, 24,
            f.anlkost.summe, nf1cell);
        addCell(sheet6, numberlUOMAK22);

        LabelW labelUOMG23 = new LabelW(9, 25,
            "Anlagenkosten/Jahr:");
        addCell(sheet6, labelUOMG23);
        NumberW numberlUOMAK23 = new NumberW(10, 25,
            f.anlkost.jahresBetrag, nf1cell);
        addCell(sheet6, numberlUOMAK23);
        //} // Ende der for Schleife

        //**********************************************************

//SCHWEFELSÄUREDOSIERUNG
         f.schwefelsaeuredos();

//Umlaufwasseranalyse
        LabelW labelSDUW1 = new LabelW(4, 0,
            f.aufbereitung, nf1cell);
        NumberW numberSDUW2 = new NumberW(4, 2,
            f.anauml.verSchnitt, nf1cell);
        NumberW numberSDUW3 = new NumberW(4, 3,
            f.anauml.eindickung, nf1cell);
        NumberW numberSDUW4 = new NumberW(4, 4, f.anauml.tKT,
            nf1cell);
        NumberW numberSDUW5 = new NumberW(4, 5, f.anauml.tW,
            nf1cell);
        NumberW numberSDUW6 = new NumberW(4, 6, f.anauml.lF,
            nf1cell);
        NumberW numberSDUW7 = new NumberW(4, 7, f.anauml.ca,
            nf1cell);
        NumberW numberSDUW8 = new NumberW(4, 8, f.anauml.mg,
            nf1cell);
        NumberW numberSDUW9 = new NumberW(4, 9, f.anauml.na,
            nf1cell);
        NumberW numberSDUW10 = new NumberW(4, 10, f.anauml.ks,
            nf1cell);
        NumberW numberSDUW11 = new NumberW(4, 11, f.anauml.cl,
            nf1cell);
        NumberW numberSDUW12 = new NumberW(4, 12,
            f.anauml.so4,
            nf1cell);
        NumberW numberSDUW13 = new NumberW(4, 13,
            f.anauml.no3,
            nf1cell);
        NumberW numberSDUW14 = new NumberW(4, 14,
            f.anauml.pHKTnV, nf1cell);
        NumberW numberSDUW15 = new NumberW(4, 15,
            f.anauml.pHTKT, nf1cell);
        NumberW numberSDUW16 = new NumberW(4, 16,
            f.anauml.siTKT, nf1cell);
        NumberW numberSDUW17 = new NumberW(4, 17,
            f.anauml.pHggWW, nf1cell);
        NumberW numberSDUW18 = new NumberW(4, 18,
            f.anauml.sIW,
            nf1cell);
        NumberW numberSDUW19 = new NumberW(4, 19,
            f.anauml.salz,
            nf1cell);
        NumberW numberSDUW20 = new NumberW(4, 20,
            f.anauml.ionen, nf1cell);
        NumberW numberSDUW21 = new NumberW(4, 21,
            f.anauml.h2co3, nf1cell);
        NumberW numberSDUW22 = new NumberW(4, 22,
            f.anauml.hco3,
            nf1cell);
        NumberW numberSDUW23 = new NumberW(4, 23,
            f.anauml.co3,
            nf1cell);

        addCell(sheet7, labelSDUW1);
        addCell(sheet7, numberSDUW2);

        addCell(sheet7, numberSDUW3);
        addCell(sheet7, numberSDUW4);
        addCell(sheet7, numberSDUW5);
        addCell(sheet7, numberSDUW6);
        addCell(sheet7, numberSDUW7);
        addCell(sheet7, numberSDUW8);
        addCell(sheet7, numberSDUW9);
        addCell(sheet7, numberSDUW10);
        addCell(sheet7, numberSDUW11);
        addCell(sheet7, numberSDUW12);
        addCell(sheet7, numberSDUW13);
        addCell(sheet7, numberSDUW14);
        addCell(sheet7, numberSDUW15);
        addCell(sheet7, numberSDUW16);
        addCell(sheet7, numberSDUW17);
        addCell(sheet7, numberSDUW18);
        addCell(sheet7, numberSDUW19);
        addCell(sheet7, numberSDUW20);
        addCell(sheet7, numberSDUW21);
        addCell(sheet7, numberSDUW22);
        addCell(sheet7, numberSDUW23);
//VERBRAUCH
        NumberW numberSDVB1 = new NumberW(7, 2,
            f.betrkost.enVer, nf1cell);
        NumberW numberSDVB2 = new NumberW(7, 3,
            f.betrkost.stadtWasserVer, nf1cell);
        NumberW numberSDVB3 = new NumberW(7, 4,
            f.betrkost.abWasserVer, nf1cell);
        NumberW numberSDVB4 = new NumberW(7, 5,
            f.betrkost.regenSielVer, nf1cell);
        NumberW numberSDVB5 = new NumberW(7, 6,
            f.betrkost.dosMittelVer, nf1cell);
        NumberW numberSDVB6 = new NumberW(7, 7,
            f.betrkost.salzTabVer, nf1cell);
        NumberW numberSDVB7 = new NumberW(7, 8,
            f.betrkost.salzSaeureVer, nf1cell);
        NumberW numberSDVB8 = new NumberW(7, 9,
            f.betrkost.schwefelSaeureVer, nf1cell);
        NumberW numberSDVB9 = new NumberW(7, 10,
            f.betrkost.roVer, nf1cell);

        addCell(sheet7, numberSDVB1);
        addCell(sheet7, numberSDVB2);
        addCell(sheet7, numberSDVB3);
        addCell(sheet7, numberSDVB4);
        addCell(sheet7, numberSDVB5);
        addCell(sheet7, numberSDVB6);
        addCell(sheet7, numberSDVB7);
        addCell(sheet7, numberSDVB8);
        addCell(sheet7, numberSDVB9);

//KOSTEN

        NumberW numberSDKO1 = new NumberW(7, 13,
            f.betrkost.enKost, nf1cell);
        NumberW numberSDKO2 = new NumberW(7, 14,
            f.betrkost.stadtWasserKost, nf1cell);
        NumberW numberSDKO3 = new NumberW(7, 15,
            f.betrkost.abWasserKost, nf1cell);
        NumberW numberSDKO4 = new NumberW(7, 16,
            f.betrkost.regenSielKost, nf1cell);
        NumberW numberSDKO5 = new NumberW(7, 17,
            f.betrkost.dosMittelKost, nf1cell);
        NumberW numberSDKO6 = new NumberW(7, 18,
            f.betrkost.salzTabKost, nf1cell);
        NumberW numberSDKO7 = new NumberW(7, 19,
            f.betrkost.salzSaeureKost, nf1cell);
        NumberW numberSDKO8 = new NumberW(7, 20,
            f.betrkost.schwefelSaeureKost, nf1cell);
        NumberW numberSDKO9 = new NumberW(7, 21,
            f.betrkost.roKost, nf1cell);
        NumberW numberSDKO10 = new NumberW(7, 22,
            f.betrkost.enKost + f.betrkost.stadtWasserKost +
            f.betrkost.abWasserKost +
            f.betrkost.regenSielKost + f.betrkost.dosMittelKost +
            f.betrkost.salzTabKost + f.betrkost.salzSaeureKost +
            f.betrkost.schwefelSaeureKost + f.betrkost.roKost +
            f.anlkost.jahresBetrag, nf1cell);

        addCell(sheet7, numberSDKO1);
        addCell(sheet7, numberSDKO2);
        addCell(sheet7, numberSDKO3);
        addCell(sheet7, numberSDKO4);
        addCell(sheet7, numberSDKO5);
        addCell(sheet7, numberSDKO6);
        addCell(sheet7, numberSDKO7);
        addCell(sheet7, numberSDKO8);
        addCell(sheet7, numberSDKO9);
        addCell(sheet7, numberSDKO10);

//*****************ANLAGE SCHWEFELSÄUREDOSIERUNG**************************
         LabelW labelSDG1 = new LabelW(9, 0,
             "Anlageinformationen");
        addCell(sheet7, labelSDG1);
        LabelW labelSDAK1 = new LabelW(10, 0,
            f.anlkost.aufbereitungsart, nf1cell);
        addCell(sheet7, labelSDAK1);

        LabelW labelSDG2 = new LabelW(9, 2,
            "Anlage,Typ:");
        addCell(sheet7, labelSDG2);
        LabelW labelSDAK2 = new LabelW(10, 2, f.anlkost.typ1,
            nf1cell);
        addCell(sheet7, labelSDAK2);

        LabelW labelSDG3 = new LabelW(9, 3,
            "Dosier und Schutzbehälter:");
        addCell(sheet7, labelSDG3);
        LabelW labelSDAK3 = new LabelW(10, 3,
            "V " + Double.toString(f.anlkost.kap1), nf1cell);
        addCell(sheet7, labelSDAK3);

        LabelW labelSDG4 = new LabelW(9, 4,
            "Werkstoff:");
        addCell(sheet7, labelSDG4);
        LabelW labelSDAK4 = new LabelW(10, 4, f.anlkost.ws1,
            nf1cell);
        addCell(sheet7, labelSDAK4);

        LabelW labelSDG5 = new LabelW(9, 5,
            "Steuerung:");
        addCell(sheet7, labelSDG5);
        LabelW labelSDAK5 = new LabelW(10, 5, f.anlkost.st1,
            nf1cell);
        addCell(sheet7, labelSDAK5);

        LabelW labelSDG6 = new LabelW(9, 6,
            "Richtpreis einschl. Montage:");
        addCell(sheet7, labelSDG6);
        NumberW numberSDAK6 = new NumberW(10, 6,
            f.anlkost.aP1, nf1cell);
        addCell(sheet7, numberSDAK6);

        LabelW labelSDG15 = new LabelW(9, 8,
            "Anlage,Typ:");
        addCell(sheet7, labelSDG15);
        LabelW labelSDAK15 = new LabelW(10, 8,
            f.anlkost.typ3, nf1cell);
        addCell(sheet7, labelSDAK15);

        LabelW labelSDG16 = new LabelW(9, 9,
            "Dosier und Schutzbehälter:");
        addCell(sheet7, labelSDG16);
        LabelW labelSDAK16 = new LabelW(10, 9,
            "V " + Double.toString(f.anlkost.kap3), nf1cell);
        addCell(sheet7, labelSDAK16);

        LabelW labelSDG17 = new LabelW(9, 10,
            "Werkstoff:");
        addCell(sheet7, labelSDG17);
        LabelW labelSDAK17 = new LabelW(10, 10,
            f.anlkost.ws3, nf1cell);

        LabelW labelSDG18 = new LabelW(9, 11,
            "Steuerung::");
        addCell(sheet7, labelSDG18);
        addCell(sheet7, labelSDAK17);
        LabelW labelSDAK18 = new LabelW(10, 11,
            f.anlkost.st3, nf1cell);
        addCell(sheet7, labelSDAK18);

        LabelW labelSDG19 = new LabelW(9, 12,
            "Wassermengenzähler:");
        addCell(sheet7, labelSDG19);
        LabelW numberSDAK19 = new LabelW(10, 12,
            f.anlkost.wz3, nf1cell);
        addCell(sheet7, numberSDAK19);

        LabelW labelSDG20 = new LabelW(9, 13,
            "Richtpreis einschl. Montage:");
        addCell(sheet7, labelSDG20);
        NumberW numberSDAK20 = new NumberW(10, 13,
            f.anlkost.aP3, nf1cell);
        addCell(sheet7, numberSDAK20);

        LabelW labelSDG21 = new LabelW(9, 14,
            "Systemtrenner und Feinfilter:");
        addCell(sheet7, labelSDG21);
        NumberW numberSDAK21 = new NumberW(10, 14,
            f.anlkost.stffP, nf1cell);
        addCell(sheet7, numberSDAK21);

        LabelW labelSDG22 = new LabelW(9, 16,
            "Gesamtanlagenpreis:");
        addCell(sheet7, labelSDG22);
        NumberW numberSDAK22 = new NumberW(10, 16,
            f.anlkost.summe, nf1cell);
        addCell(sheet7, numberSDAK22);

        LabelW labelSDG23 = new LabelW(9, 17,
            "Anlagenkosten/Jahr:");
        addCell(sheet7, labelSDG23);
        NumberW numberSDAK23 = new NumberW(10, 17,
            f.anlkost.jahresBetrag, nf1cell);
        addCell(sheet7, numberSDAK23);

        //*************************************************


         try (FileOutputStream out = new FileOutputStream(new File(dateiName))) {
          workbook.write(out);
        }
        workbook.close();
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

  // POI-Hilfsklassen: ahmen jxl.write.Label / jxl.write.Number nach,
  // damit die mechanische Migration die ursprueglichen Variablenketten
  // (inkl. setString-Re-Assignment) unveraendert lassen konnte.
  private static class LabelW {
    final int col, row;
    String text;
    LabelW(int c, int r, String t) { col = c; row = r; text = t; }
    LabelW(int c, int r, String t, CellStyle style) { col = c; row = r; text = t; }
    void setString(String s) { text = s; }
  }

  private static class NumberW {
    final int col, row;
    double value;
    final CellStyle style;
    NumberW(int c, int r, double v) { col = c; row = r; value = v; style = null; }
    NumberW(int c, int r, double v, CellStyle s) { col = c; row = r; value = v; style = s; }
    void setValue(double v) { value = v; }
  }

  private static void addCell(Sheet sheet, LabelW lbl) {
    Row row = sheet.getRow(lbl.row);
    if (row == null) row = sheet.createRow(lbl.row);
    row.createCell(lbl.col).setCellValue(lbl.text != null ? lbl.text : "");
  }

  private static void addCell(Sheet sheet, NumberW num) {
    Row row = sheet.getRow(num.row);
    if (row == null) row = sheet.createRow(num.row);
    Cell c = row.createCell(num.col);
    c.setCellValue(num.value);
    if (num.style != null) c.setCellStyle(num.style);
  }
}
/*//ANLAGE
void anlage()
{
      int i = 0;
      if (f.aufbereitung == "Enthärtung" ||
          f.aufbereitung == "Entcarbonisierung" ||
          f.aufbereitung == "Umkehrosmose m. v. Enthärtung") {
        LabelW labelG1 = new LabelW(0, 0,
          "Anlageinformation für Aufbereitungsart:");
       addCell(sheet2, labelG1);
        LabelW LabelAK1 = new LabelW(i++, 1,
            f.anlkost.aufbereitungsart, nf1cell);
         addCell(sheet7, LabelAK1);

         LabelW labelG2 = new LabelW(i, 0,
          "Anlage,Typ:");
       addCell(sheet7, labelG2);
        LabelW LabelAK2 = new LabelW(i++, 1, f.anlkost.typ1,
            nf1cell);
        addCell(sheet7, LabelAK2);

        LabelW labelG3 = new LabelW(i, 0,
          "Kapazität:");
       addCell(sheet7, labelG3);
       NumberW numberAK3 = new NumberW(i++, 1,
            f.anlkost.kap1, nf1cell);
        addCell(sheet7, numberAK3);

        LabelW labelG4 = new LabelW(i, 0,
          "Verrohrung:");
       addCell(sheet7, labelG4);
        LabelW LabelAK4 = new LabelW(i++, 1,
            f.anlkost.nennweite1, nf1cell);
        addCell(sheet7, LabelAK4);

        LabelW labelG5 = new LabelW(i, 0,
          "Werkstoff:");
       addCell(sheet7, labelG5);
        LabelW LabelAK5 = new LabelW(i++, 1, f.anlkost.ws1,
            nf1cell);
        addCell(sheet7, LabelAK5);

        LabelW labelG6 = new LabelW(i, 0,
          "Steuerung:");
       addCell(sheet7, labelG6);
        LabelW LabelAK6 = new LabelW(i++, 1, f.anlkost.st1,
            nf1cell);
        addCell(sheet7, LabelAK6);

        LabelW labelG7 = new LabelW(i, 0,
          "Wassermengenzähler:");
       addCell(sheet7, labelG7);
        LabelW LabelAK7 = new LabelW(i++, 1, f.anlkost.wz1,
            nf1cell);
        addCell(sheet7, LabelAK7);


        if (f.anlkost.verfahren == "Entcarbonisierung") {
          LabelW labelG8 = new LabelW(i, 0,
          "Neutralfilter:");
       addCell(sheet7, labelG8);
          LabelW LabelAK8 = new LabelW(i++, 1, f.anlkost.nf,
              nf1cell);
          addCell(sheet7, LabelAK8);
        }
        LabelW labelG9 = new LabelW(i, 0,
           "Richtpreis einschl. Montage:");
        addCell(sheet7, labelG9);
        NumberW numberAK9 = new NumberW(i++, 1,
            f.anlkost.aP1, nf1cell);
         addCell(sheet7, numberAK9);
        //
        //
        if (f.aufbereitung == "Umkehrosmose m. v. Enthärtung" ||
            f.aufbereitung == "Umkehrosmose o. v. Enthärtung") {

          LabelW labelG10 = new LabelW(i, 0,
          "Anlage,Typ:");
           addCell(sheet7, labelG10);
          LabelW LabelAK10 = new LabelW(i++, 1,
              f.anlkost.typ2, nf1cell);
          addCell(sheet7, LabelAK10);

          LabelW labelG11 = new LabelW(i, 0,
          "Leistung:");
          addCell(sheet7, labelG11);
          NumberW numberAK11 = new NumberW(i++, 1,
              f.anlkost.kap2, nf1cell);
          addCell(sheet7, numberAK11);

          LabelW labelG12 = new LabelW(i, 0,
          "Verrohrung:");
          addCell(sheet7, labelG12);
          LabelW LabelAK12 = new LabelW(i++, 1,
              f.anlkost.ws2, nf1cell);
          addCell(sheet7, LabelAK12);

          LabelW labelG13 = new LabelW(i, 0,
          "Steuerung:");
          addCell(sheet7, labelG13);
          LabelW LabelAK13 = new LabelW(i++, 1,
              f.anlkost.st2, nf1cell);
          addCell(sheet7, LabelAK13);


          LabelW labelG14 = new LabelW(i, 0,
          "Richtpreis einschl. Montage::");
          addCell(sheet7, labelG14);
          NumberW NumberAK14 = new NumberW(i++, 1,
              f.anlkost.aP2, nf1cell);
          addCell(sheet7, NumberAK14);


        }
      }
      if (f.aufbereitung == "Schwefelsäuredosierung")
      {
        LabelW labelG2 = new LabelW(i, 0,
          "Anlage,Typ:");
          addCell(sheet7, labelG2);
        LabelW LabelAK2 = new LabelW(i++, 1, f.anlkost.typ1,
           nf1cell);
       addCell(sheet7, LabelAK2);

       LabelW labelG3 = new LabelW(i, 0,
          "Dosier und Schutzbehälter:");
          addCell(sheet7, labelG3);
       LabelW labelAK3 = new LabelW(i++, 1,
           "V " + Double.toString(f.anlkost.kap1), nf1cell);
       addCell(sheet7, labelAK3);

       LabelW labelG4 = new LabelW(i, 0,
          "Werkstoff:");
          addCell(sheet7, labelG4);
       LabelW LabelAK4 = new LabelW(i++, 1, f.anlkost.ws1,
           nf1cell);
       addCell(sheet7, LabelAK4);

       LabelW labelG5 = new LabelW(i, 0,
          "Steuerung:");
          addCell(sheet7, labelG5);
       LabelW LabelAK5 = new LabelW(i++, 1, f.anlkost.st1,
           nf1cell);
       addCell(sheet7, LabelAK5);

       LabelW labelG6 = new LabelW(i, 0,
          "Richtpreis einschl. Montage:");
          addCell(sheet7, labelG6);
       NumberW numberAK6 = new NumberW(i++, 1,
           f.anlkost.aP1, nf1cell);
       addCell(sheet7, numberAK6);
     }

     LabelW labelG15 = new LabelW(i, 0,
          "Anlage,Typ:");
          addCell(sheet7, labelG15);
     LabelW LabelAK15 = new LabelW(i++, 1,
          f.anlkost.typ3, nf1cell);
     addCell(sheet7, LabelAK15);

     LabelW labelG16 = new LabelW(i, 0,
          "Dosier und Schutzbehälter:");
          addCell(sheet7, labelG16);
          LabelW labelAK16 = new LabelW(i++, 1,
          "V " + Double.toString(f.anlkost.kap3), nf1cell);
      addCell(sheet7, labelAK16);

      LabelW labelG17 = new LabelW(i, 0,
          "Werkstoff:");
          addCell(sheet7, labelG17);
  LabelW LabelAK17 = new LabelW(i++, 1,
          f.anlkost.ws3, nf1cell);

LabelW labelG18 = new LabelW(i, 0,
          "Steuerung::");
          addCell(sheet7, labelG18);
addCell(sheet7, LabelAK17);
      LabelW LabelAK18 = new LabelW(i++, 1,
          f.anlkost.st3, nf1cell);
addCell(sheet7, LabelAK18);

LabelW labelG19 = new LabelW(i, 0,
          "Wassermengenzähler:");
          addCell(sheet7, labelG19);
          LabelW NumberAK19 = new LabelW(i++, 1,
        f.anlkost.wz3, nf1cell);
        addCell(sheet7, NumberAK19);

      LabelW labelG20 = new LabelW(i, 0,
                    "Richtpreis einschl. Montage:");
      addCell(sheet7, labelG20);
      NumberW NumberAK20 = new NumberW(i++, 1,
         f.anlkost.aP3, nf1cell);
      addCell(sheet7, NumberAK20);

     LabelW labelG21 = new LabelW(i, 0,
          "Systemtrenner und Feinfilter:");
          addCell(sheet7, labelG21);
     NumberW NumberAK21 = new NumberW(i++, 1,
         f.anlkost.stffP, nf1cell);
     addCell(sheet7, NumberAK21);

     LabelW labelG22 = new LabelW(i, 0,
          "Gesamtanlagenpreis:");
          addCell(sheet7, labelG22);
     NumberW NumberAK22 = new NumberW(i++, 1,
         f.anlkost.summe, nf1cell);
    addCell(sheet7, NumberAK22);

    LabelW labelG23 = new LabelW(i, 0,
          "Anlagenkosten/Jahr:");
          addCell(sheet7, labelG23);
     NumberW NumberAK23 = new NumberW(i++, 1,
         f.anlkost.jahresBetrag, nf1cell);
     addCell(sheet7, NumberAK23);
    //} // Ende der for Schleife

*/
