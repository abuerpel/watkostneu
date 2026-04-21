/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */


public class ehkostenberechnung {

  public ehkostenberechnung() {
  }

  static betriebskosten kostehrech(kosten preise, double dNE,
                                   double dNVerschnitt, double dNSUK) {
    //Programm zur Berechnung von Betriebskosten
    //bei Enth„rtung
    //kost12.prg
    //Betriebskostenrechnung f?r Aufbereitungsart 2, Teilenth„rtung mit
    //Threshold Stabilisierung
    //Wassermengen f?r Verdunstung Speisewasser und Abwasser berechnen;
    //Bezug: Verdampfungsenthalpie bei 30øC betr„gt 0,6758 kWh/kg
    //Grundlage: 1 kW verdampft 1,480 l/h; 8760 h = 1 a.
    //Verbrauch berechnen
    double dNVWM, dLeistung;
    betriebskosten betrieb = new betriebskosten(); //object erzeugen
    dLeistung = preise.leistung; //Bei Luftwaescherleistung
    dNVWM = dLeistung * 12.97 * preise.auslastung / 100; //Verdunstungswassermenge/Jahr
    betrieb = berechne(preise, dNE, dNVerschnitt, dNSUK, dNVWM);
    return betrieb; //objekt zurueckgeben
  }

//
  static betriebskosten kostehrechL(kosten preise, double dNE,
                                    double dNVerschnitt, double dNSUK) {
    //Wassermengen f?r Verdunstung Speisewasser und Abwasser berechnen;
    //Bezug: 3 g Wasser pro m³ Luft im Jahresmittel
    //Grundlage: 12 o C ergibt 50 % Feuchte bei 22 o C
    //Verbrauch berechnen
    double dNVWM, dLeistung;
    betriebskosten betrieb = new betriebskosten(); //object erzeugen
    dLeistung = preise.leistung2; //Bei Luftwaescherleistung
    dNVWM = dLeistung * 26.28 * preise.auslastung / 100000; //Verdunstungswassermenge/Jahr
    betrieb = berechne(preise, dNE, dNVerschnitt, dNSUK, dNVWM);
    return betrieb;
  }

  static betriebskosten berechne(kosten preise, double dNE, double dNVerschnitt,
                                 double dNSUK, double dNVWM) {

    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    double dSPWM; //Variablen deklarieren

    //Verbrauch berechnen
    betrieb.abWasserVer = dNVWM / (dNE - 1); //Abwassermenge/Jahr
    betrieb.stadtWasserVer = dNVWM + betrieb.abWasserVer; //Speisewassermenge/Jahr
    betrieb.dosMittelVer = betrieb.abWasserVer * preise.dosierMenge / 1000; //Chemiklaienmenge
    betrieb.salzTabVer = dNSUK * betrieb.stadtWasserVer * (1 - dNVerschnitt) *
        120; //*Salzmenge/Jahr, 2-facher šberschuá (120g), bez. auf SUK

    //Stadt- und Abwasserkosten zum Betreiben der Enth„rtungsanlage berechnen
    //Berechnungsgrundlage: Proportionalit„t von Salzverbrauch und Sp?lwasser
    //5 l Sp?lwasser/ l Harz oder 180g Salz
    dSPWM = betrieb.salzTabVer * 0.0278;

    //Gesamte Stadt- und Abwassermenge korrigieren
    betrieb.stadtWasserVer = betrieb.stadtWasserVer + dSPWM;
    betrieb.abWasserVer = betrieb.abWasserVer + dSPWM;

    //Jahresbetriebskosten in Tabelle kopieren
    betrieb.stadtWasserKost = betrieb.stadtWasserVer * preise.stadtWasser; //Speisewasser
    betrieb.abWasserKost = betrieb.abWasserVer * preise.abWasser; //Abwasser
    betrieb.dosMittelKost = betrieb.dosMittelVer * preise.dosierMittel; //
    betrieb.salzTabKost = betrieb.salzTabVer * preise.salzTabletten; //Salzkosten
    return betrieb; //objekt zurueckgeben
  }
//
}