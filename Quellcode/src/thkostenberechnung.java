/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author       H. Kacirek
 * @version 1.0
 */


public class thkostenberechnung {

  public thkostenberechnung() {
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
    //Wassermengen f?r Verdunstung Speisewasser und Abwasser berechnen;
    ///Bezug: Verdampfungsenthalpie bei 30øC betr„gt 0,6758 kWh/kg
    //Grundlage: 1 kW verdampft 1,480 l/h; 8760 h = 1 a.
    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    double dNVWM, dLeistung;
    dLeistung = preise.leistung; //Bei Luftwaescherleistung
    dNVWM = dLeistung * 12.97 * preise.auslastung / 100; //Verdunstungswassermenge/Jahr
    betrieb = berechne(preise, dNE, dNVerschnitt, dNVWM);
    return betrieb; //objekt zurueckgeben
  }

//
  static betriebskosten kostthrechL(kosten preise, double dNE,
                                    double dNVerschnitt) {
    //Programm zur Berechnung von Betriebskosten
    //bei threshold-Stabilisierung
    //kost11l.prg
    //Betriebskostenrechnung f?r Aufbereitungsart 1, Threshold Stabilisierung
    //Wassermengen f?r Verdunstung Speisewasser und Abwasser berechnen;
    ///Bezug: 3 g Wasser pro m³ Luft im Jahresmittel
    //Grundlage: 12 o C ergibt 50 % Feuchte bei 22 o C

    double dNVWM;
    double dLeistung; //Leistung
    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    dLeistung = preise.leistung2; //Bei Luftwaescherleistung
    dNVWM = dLeistung * 26.28 * preise.auslastung / 100000; //Verdunstungswassermenge/Jahr
    betrieb = berechne(preise, dNE, dNVerschnitt, dNVWM);
    return betrieb; //objekt zurueckgeben
  }

  static betriebskosten berechne(kosten preise, double dNE, double dNVerschnitt,
                                 double dNVWM) {
    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    //Verbrauch berechnen
    betrieb.abWasserVer = dNVWM / (dNE - 1); //Abwassermenge/Jahr
    betrieb.stadtWasserVer = dNVWM + betrieb.abWasserVer; //Speisewassermenge/Jahr
    betrieb.dosMittelVer = betrieb.abWasserVer * preise.dosierMenge / 1000; //Chemiklaienmenge

    //Jahresbetriebskosten in Tabelle kopieren
    betrieb.stadtWasserKost = betrieb.stadtWasserVer * preise.stadtWasser; //Speisewasser
    betrieb.abWasserKost = betrieb.abWasserVer * preise.abWasser; //Abwasser
    betrieb.dosMittelKost = betrieb.dosMittelVer * preise.dosierMittel; //
    return betrieb; //objekt zurueckgeben
  }
//
}