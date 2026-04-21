/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author       H. Kacirek
 * @version 1.0
 */


public class kostenberechnung {

  public kostenberechnung() {
  }

//
//einlesen der Ergebnisse in kostenklasse
  static betriebskosten kosteneinlesen() {
    betriebskosten kostenAus = new betriebskosten();
    return kostenAus;
  }

//
  static betriebskosten kostthrech(kosten preise, double dNE,
                                   double dNVerschnitt) {
    //Programm zur Berechnung von Betriebskosten
    //bei threshold-Stabilisierung
    //kost11.prg
    //Betriebskostenrechnung f?r Aufbereitungsart 1, Threshold Stabilisierung

    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    double dNVWM;
    //Wassermengen f?r Verdunstung Speisewasser und Abwasser berechnen;
    ///Bezug: Verdampfungsenthalpie bei 30øC betr„gt 0,6758 kWh/kg
    //Grundlage: 1 kW verdampft 1,480 l/h; 8760 h = 1 a.



    //Verbrauch berechnen
    dNVWM = preise.leistung * 12.97 * preise.auslastung / 100; //Verdunstungswassermenge/Jahr
    betrieb.abWasserVer = dNVWM / (dNE - 1); //Abwassermenge/Jahr
    betrieb.stadtWasserVer = dNVWM + betrieb.abWasserVer; //Speisewassermenge/Jahr
    betrieb.dosMittelVer = betrieb.abWasserVer * preise.dosierMittel / 1000; //Chemiklaienmenge

    //Jahresbetriebskosten in Tabelle kopieren
    betrieb.stadtWasserKost = betrieb.stadtWasserVer * preise.stadtWasser; //Speisewasser
    betrieb.abWasserKost = betrieb.abWasserVer * preise.abWasser; //Abwasser
    betrieb.dosMittelKost = betrieb.dosMittelVer * preise.dosierMittel; //
    return betrieb; //objekt zurueckgeben
  }

//
  static betriebskosten kostthrechL(kosten preise, double dNE,
                                    double dNVerschnitt) {
    //Programm zur Berechnung von Betriebskosten
    //bei threshold-Stabilisierung
    //kost11l.prg
    //Betriebskostenrechnung f?r Aufbereitungsart 1, Threshold Stabilisierung

    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    double dNVWM;
    //Wassermengen f?r Verdunstung Speisewasser und Abwasser berechnen;
    ///Bezug: 3 g Wasser pro m³ Luft im Jahresmittel
    //Grundlage: 12 o C ergibt 50 % Feuchte bei 22 o C



    //Verbrauch berechnen
    dNVWM = preise.leistung * 26.28 * preise.auslastung / 100000; //Verdunstungswassermenge/Jahr
    betrieb.abWasserVer = dNVWM / (dNE - 1); //Abwassermenge/Jahr
    betrieb.stadtWasserVer = dNVWM + betrieb.abWasserVer; //Speisewassermenge/Jahr
    betrieb.dosMittelVer = betrieb.abWasserVer * preise.dosierMittel / 1000; //Chemiklaienmenge

    //Jahresbetriebskosten in Tabelle kopieren
    betrieb.stadtWasserKost = betrieb.stadtWasserVer * preise.stadtWasser; //Speisewasser
    betrieb.abWasserKost = betrieb.abWasserVer * preise.abWasser; //Abwasser
    betrieb.dosMittelKost = betrieb.dosMittelVer * preise.dosierMittel; //Chemikalienkosten

    return betrieb; //objekt zurueckgeben
  }

//
  static void kostehrech(kosten preise) {

  }

  static void kostehrechL(kosten preise) {

  }

//
  static void kostecrech(kosten preise) {

  }

//
  static void kostecrechL(kosten preise) {

  }

//
  static void kostsdrech(kosten preise) {

  }

//
  static void kostsdrechL(kosten preise) {

  }

//
  static void kostuorech(kosten preise) {

  }

//
  static void kostuorechL(kosten preise) {

  }

//
  static void kostuorechmit(kosten preise) {

  }

//
  static void kostuorechmitL(kosten preise) {

  }
//
}