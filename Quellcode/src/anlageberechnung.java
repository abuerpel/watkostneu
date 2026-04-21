/**
 * Title:        Watkost<p> *
 * Description:  Berechnung der Anlagengrösse und der Kosten anhand des Volumenstroms und des Salzgehaltes
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */

import java.sql.*;

public class anlageberechnung {
  //private static String verfahren,modelName,rohrWeite, uoModelName, zusatzName1;
  /*private static int modelPreis,rohrPreis,zusatzPreis1,zusatzPreis2,zusatzPreis3,uoModelPreis,
                      optionPreis1,optionPreis2,optionPreis3;
   */
  private static ResultSet rsAnlage;
  //neu
  private static String aufbereitungsart, typ1, typ2, typ3, nennweite1,
      nennweite2, nennweite3,
      ws1, ws2, ws3, st1, st2, st3, wz1, wz2, wz3, dosuo, nf;

  private static int kap1, kap2, kap3, aP1, aP2, aP3, stffP;
  private final double faktor = 1.2; //+ 17% annuität + 3% Service

  public anlageberechnung() {

  }

  //
  public static anlagekosten thberechne(double vs, double al, double dmv) { //berechnen der Enthärtungsanlage aus volumenstrom salzgehalt und auslastung

    int grundPreisP = 0, wasserZaehlerP = 0;
    // berechnung der spitzenlast
    double spitzenLast = (int) (vs / (8600 * al * 0.01));
    // berechnung des monatlichen dosiermittelverbrauchs
    int dv = (int) Math.round(dmv / 12);
    rsAnlage = startframe.datenBank.getAnlData(
        "SELECT * FROM THANLAGENPREISE WHERE VOLUMEN >=" + dv);
    try {
      kap3 = rsAnlage.getInt(3); //Volumen
      grundPreisP = rsAnlage.getInt(4) * 2 + rsAnlage.getInt(5) * 2 + 2470 +
          800 + 725; //behälter +schutzbehälter+ anlagenpreis + propdosierpumpe + bioziddosierpumpe
    }
    catch (java.lang.NullPointerException e) {
      System.out.print(e);
    }
    catch (java.sql.SQLException e) {
      System.out.print(e);
    }

    rsAnlage = startframe.datenBank.getAnlData(
        "SELECT * FROM THROHRPREISE WHERE VMAX >= " + spitzenLast);
    try {
      wz3 = rsAnlage.getString(2); //nennweite des Wasserzählers
      wasserZaehlerP = rsAnlage.getInt(5); // wassermengenzähler
      stffP = rsAnlage.getInt(4) + rsAnlage.getInt(6); //systemtrenner-/ + feinfilterpreis

    }
    catch (java.lang.NullPointerException e) {
      System.out.print(e);
    }
    catch (java.sql.SQLException e) {
      System.out.print(e);
    }

    typ3 = "Regel- und Dosierstation RBPD"; //VerfahrensKürzel
    ws3 = "PVC"; //Werksstoff
    st3 = "PILOT "; //Steuerung
    aP3 = grundPreisP + wasserZaehlerP; //anlagenpreis
    return zurueckgeben();
  }

  //
  public static anlagekosten ehberechne(double vs, double sg, double al,
                                        double dmv) { //berechnen der Enthärtungsanlage aus volumenstrom salzgehalt und auslastung

    int grundPreisP = 0, rohrPreisP = 0, wasserZaehlerPreisP = 0,
        steuerungPreisP = 0;
    // berechnung der spitzenlast
    double spitzenLast = (int) (vs / (8600 * al * 0.01));
    double kErf = (int) (spitzenLast * sg * 8);
    rsAnlage = startframe.datenBank.getAnlData(
        "SELECT * FROM EHSTRASSENPREISE WHERE KAPAZITAET >= " +
        Integer.toString( (int) kErf));
    try {
      typ1 = "Enthärtungsanlage EHD-" + rsAnlage.getString(2); //anlagentyp
      kap1 = rsAnlage.getInt(3); //kapazität
      grundPreisP = rsAnlage.getInt(4);
    }
    catch (java.lang.NullPointerException e) {
      //
    }
    catch (java.sql.SQLException e) {
      //
    }

    rsAnlage = startframe.datenBank.getAnlData(
        "SELECT * FROM EHROHRPREISE WHERE VMAX >= " + spitzenLast);
    try {
      nennweite1 = rsAnlage.getString(2); //nennweite
      rohrPreisP = rsAnlage.getInt(4);
      wz1 = nennweite1;
      wasserZaehlerPreisP = rsAnlage.getInt(5); // wassermengenzähler
      st1 = "M3";
      steuerungPreisP = 570; //Steuerung Version Aufbau M3

    }
    catch (java.lang.NullPointerException e) {
      //
    }
    catch (java.sql.SQLException e) {
      //
    }

    ws1 = "PVC"; //Werksstoff
    aP1 = grundPreisP + rohrPreisP + wasserZaehlerPreisP + steuerungPreisP;
    return thberechne(vs, al, dmv);
  }

  //
  public static anlagekosten ecberechne(double vs, double ks43, double al,
                                        double dmv) { //berechnen der Encarbonisierungsanlage aus volumenstrom salzgehalt und auslastung
    int grundPreisP = 0, rohrPreisP = 0, steuerungPreisP = 0,
        verschneidungPreisP = 0;
    // berechnung der spitzenlast
    double spitzenLast = (int) (vs / (8600 * al * 0.01));
    double kErf = (int) (spitzenLast * ks43 * 8);
    rsAnlage = startframe.datenBank.getAnlData(
        "SELECT * FROM ECSTRASSENPREISE WHERE KAPAZITAET >= " +
        Integer.toString( (int) kErf));
    try {
      typ1 = "Entcarbonisierungsanlage ECD- " + rsAnlage.getString(2); //anlagenname
      grundPreisP = rsAnlage.getInt(4) + rsAnlage.getInt(5) + 1800; //anlagenpreis + neutralfilterpreis + zumesseinrichtung
      kap1 = rsAnlage.getInt(3); //kapazität
      nf = "für " + rsAnlage.getString(2); //neutralfiltername
    }
    catch (java.lang.NullPointerException e) {
      //
    }
    catch (java.sql.SQLException e) {
      //
    }

    rsAnlage = startframe.datenBank.getAnlData(
        "SELECT * FROM ECROHRPREISE WHERE VMAX >= " + spitzenLast);
    try {
      nennweite1 = rsAnlage.getString(2);
      wz1 = nennweite1;
      rohrPreisP = rsAnlage.getInt(4);
      steuerungPreisP = 800; //Steuerung AufbauVersion
      st1 = "A +Zumesseinrichtung ";
      verschneidungPreisP = rsAnlage.getInt(5); //Verschneidung
    }
    catch (java.lang.NullPointerException e) {
      //
    }
    catch (java.sql.SQLException e) {
      //
    }
    aP1 = grundPreisP + rohrPreisP + steuerungPreisP + verschneidungPreisP;
    ws1 = "PVC";
    return thberechne(vs, al, dmv);

  }

  //
  public static anlagekosten uoehberechne(double vs, double sg, double al,
                                          double dmv) { //berechnen der Umkehrosmose aus volumenstrom Enthärtung au Salzgehalt
    int grundPreisP = 0;
    // berechnung der spitzenlast
    double spitzenLast = (int) (vs / (8600 * al * 0.01) * 1000); //Spitzenstrom l/h
    rsAnlage = startframe.datenBank.getAnlData(
        "SELECT * FROM UOANLAGENPREISE WHERE KAPAZITAET >= " +
        Integer.toString( (int) spitzenLast));
    try {
      typ2 = "RO-" + rsAnlage.getString(2); //anlage
      kap2 = rsAnlage.getInt(3); //kapazität
      aP2 = rsAnlage.getInt(5) + rsAnlage.getInt(6) + 370; //preis + Verschneidung + steuerung
      st2 = "ROE 901 A"; //steuerung
      dosuo = "Proportionaldosierstation für RO"; //dosstation
    }
    catch (java.lang.NullPointerException e) {
      //
    }
    catch (java.sql.SQLException e) {
      //
    }
    ws2 = "PVC";
    return ehberechne(vs, sg, al, dmv);
  }

  public static anlagekosten uoberechne(double vs, double al, double dmv) { //berechnen der Umkehrosmose aus volumenstrom
    int grundPreisP = 0;
    // berechnung der spitzenlast
    double spitzenLast = (int) (vs / (8600 * al * 0.01) * 1000); //Spitzenstrom l/h
    rsAnlage = startframe.datenBank.getAnlData(
        "SELECT * FROM UOANLAGENPREISE WHERE KAPAZITAET >= " +
        Integer.toString( (int) spitzenLast));
    try {
      typ2 = " RO-" + rsAnlage.getString(2); //anlage
      kap2 = rsAnlage.getInt(3); //kapazität
      aP2 = rsAnlage.getInt(5) + rsAnlage.getInt(6) + 370 + 900; //preis + Verschneidung + steuerung + dosStation RO
      st2 = "ROE 901 A"; //steuerung
      dosuo = "Proportionaldosierstation für RO"; //dosstation
    }
    catch (java.lang.NullPointerException e) {
      //
    }
    catch (java.sql.SQLException e) {
      //
    }
    ws2 = "PVC";
    return thberechne(vs, al, dmv);
  }

  //
  public static anlagekosten sdberechne(double vs, double al, double dmv) { //berechnen der threshol dosierstation
    typ1 = "Schwefelsäuredosierstation";
    ws1 = "PVC";
    aP1 = 2000;
    kap1 = kap3; //Volumen Schutzbehälter
    st1 = "Liquisis P-Regelung"; //Steuerung
    return thberechne(vs, al, dmv);
  }

  //
  public static anlagekosten zurueckgeben() { //einlesen der Daten in Datenstruktur
    anlagekosten anlKosten = new anlagekosten();
    aufbereitungsart = "";
    anlKosten.aP1 = (int) (aP1 * 1.1);
    anlKosten.aP2 = (int) (aP2 * 1.1);
    anlKosten.aP3 = (int) (aP3 * 1.1);
    anlKosten.kap1 = kap1;
    anlKosten.kap2 = kap2;
    anlKosten.kap3 = kap3;
    anlKosten.typ1 = typ1;
    anlKosten.typ2 = typ2;
    anlKosten.typ3 = typ3;
    anlKosten.stffP = (int) (stffP * 1.1);
    anlKosten.nennweite1 = nennweite1;
    anlKosten.nennweite2 = nennweite2;
    anlKosten.nennweite3 = nennweite3;
    anlKosten.ws1 = ws1;
    anlKosten.ws2 = ws2;
    anlKosten.ws3 = ws3;
    anlKosten.st1 = st1;
    anlKosten.st2 = st2;
    anlKosten.st3 = st3;
    anlKosten.wz1 = wz1;
    anlKosten.wz2 = wz2;
    anlKosten.wz3 = wz3;
    anlKosten.dosuo = dosuo;
    anlKosten.nf = nf;
    anlKosten.summe = (int) ( (aP1 + aP2 + aP3 + stffP) * 1.1);
    anlKosten.jahresBetrag = (int) anlKosten.summe / 5; //Abschreibung 10 Jahre  linear 10%, Verzinsung 7%, Service reparatur 3%
    nullen(); // Variablen auf Null zrücksetzen
    return anlKosten;
  }

  //
  static void nullen() { //alle Variablen auf Null setzen
    aufbereitungsart = "";
    aP1 = 0;
    aP2 = 0;
    aP3 = 0;
    kap1 = 0;
    kap2 = 0;
    kap3 = 0;
    typ1 = "";
    typ2 = "";
    typ3 = "";
    stffP = 0;
    nennweite1 = "";
    nennweite2 = "";
    nennweite3 = "";
    ws1 = "";
    ws2 = "";
    ws3 = "";
    st1 = "";
    st2 = "";
    st3 = "";
    wz1 = "";
    wz2 = "";
    dosuo = "";
    nf = "";

  }
}
