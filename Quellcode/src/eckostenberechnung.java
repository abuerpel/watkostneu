/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */

public class eckostenberechnung {

  public eckostenberechnung() {
  }

  static betriebskosten kostecrech(kosten preise, double dNE,
                                   double dNVerschnitt, double dNKS43) {
    //Programm zur Berechnung von Betriebskosten
    //bei Entcarbonisierung
    //kost13.prg
    //Betriebskostenrechnung f?r Aufbereitungsart 3, Teilentcarbonisierung mit
    //Threshold Stabilisierung
    //Wassermengen f?r Verdunstung Speisewasser und Abwasser berechnen;
    //Bezug: Verdampfungsenthalpie bei 30øC betr„gt 0,6758 kWh/kg
    //Grundlage: 1 kW verdampft 1,480 l/h; 8760 h = 1 a.

    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    double dNVWM, dLeistung;
    dLeistung = preise.leistung; //Bei Luftwaescherleistung
    dNVWM = dLeistung * 12.97 * preise.auslastung / 100; //Verdunstungswassermenge/Jahr
    betrieb = berechne(preise, dNE, dNVerschnitt, dNKS43, dNVWM);
    return betrieb; //objekt zurueckgeben
  }

//
  static betriebskosten kostecrechL(kosten preise, double dNE,
                                    double dNVerschnitt, double dNKS43) {
    //kost13l.prg Stand 02.11.00
    //Betriebskostenrechnung f?r Aufbereitungsart 3, Teilentcarbonisierung mit
    //Threshold Stabilisierung
    //Wassermengen f?r Verdunstung Speisewasser und Abwasser berechnen;
    //Bezug: 3 g Wasser pro m3 Luft im Jahresmittel
    //S„ttigung bei 12øC ergibt 50 % Feuchte bei 22øC.

    double dNVWM, dLeistung;
    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    dLeistung = preise.leistung2; //Bei Luftwaescherleistung
    dNVWM = dLeistung * 26.28 * preise.auslastung / 100000; //Verdunstungswassermenge/Jahr
    betrieb = berechne(preise, dNE, dNVerschnitt, dNKS43, dNVWM);
    return betrieb; //objekt zurueckgeben
  }

//
  static betriebskosten berechne(kosten preise, double dNE, double dNVerschnitt,
                                 double dNKS43, double dNVWM) {

    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    double dSPWM; //Variablen deklarieren

    //Verbrauch berechnen
    betrieb.abWasserVer = dNVWM / (dNE - 1); //Abwassermenge/Jahr
    betrieb.stadtWasserVer = dNVWM + betrieb.abWasserVer; //Speisewassermenge/Jahr
    betrieb.dosMittelVer = betrieb.abWasserVer * preise.dosierMenge / 1000; //Chemiklaienmenge

    betrieb.salzSaeureVer = (dNKS43 / 1000) * betrieb.stadtWasserVer *
        (1 - dNVerschnitt) * 120; //*Salzsaeuremenge 30-31 % Jahr

    //Stadt- und Abwasserkosten zum Betreiben der Enth„rtungsanlage berechnen
    //Berechnungsgrundlage: Proportionalit„t von Salzverbrauch und Sp?lwasser
    //5 l Sp?lwasser/ l Harz oder 180g Salz
    dSPWM = betrieb.salzSaeureVer * 0.0167;

    //Gesamte Stadt- und Abwassermenge korrigieren
    betrieb.stadtWasserVer = betrieb.stadtWasserVer + dSPWM;
    betrieb.abWasserVer = betrieb.abWasserVer + dSPWM;

    //Jahresbetriebskosten in Tabelle kopieren
    betrieb.stadtWasserKost = betrieb.stadtWasserVer * preise.stadtWasser; //Speisewasser
    betrieb.abWasserKost = betrieb.abWasserVer * preise.abWasser; //Abwasser
    betrieb.dosMittelKost = betrieb.dosMittelVer * preise.dosierMittel; //
    betrieb.salzSaeureKost = betrieb.salzSaeureVer * preise.salzSaeure; //Salzkosten
    return betrieb; //objekt zurueckgeben
  }
//
}