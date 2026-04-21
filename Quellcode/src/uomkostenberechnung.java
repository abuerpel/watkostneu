/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */


public class uomkostenberechnung {

  public uomkostenberechnung() {
  }

  static betriebskosten kostuorechmit(kosten preise, double dNE,
                                      double dNVerschnitt, double dNSUK,
                                      int siel) {
    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    double dNVWM, dLeistung;
    dLeistung = preise.leistung; //Bei Luftwaescherleistung
    dNVWM = dLeistung * 12.97 * preise.auslastung / 100; //Verdunstungswassermenge/Jahr
    betrieb = berechne(preise, dNE, dNVerschnitt, dNSUK, dNVWM, siel);
    return betrieb; //objekt zurueckgeben
  }

//

  static betriebskosten kostuorechmitL(kosten preise, double dNE,
                                       double dNVerschnitt, double dNSUK,
                                       int siel) {
    double dNVWM, dLeistung;
    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    dLeistung = preise.leistung2; //Bei Luftwaescherleistung
    dNVWM = dLeistung * 26.28 * preise.auslastung / 100000; //Verdunstungswassermenge/Jahr
    betrieb = berechne(preise, dNE, dNVerschnitt, dNSUK, dNVWM, siel);
    return betrieb; //objekt zurueckgeben
  }

//
  static betriebskosten berechne(kosten preise, double dNE, double dNVerschnitt,
                                 double dNSUK, double dNVWM, int siel) {
    double dSPWM, dSPWM2; //Variablen deklarieren
    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    //Verbrauch berechnen
    betrieb.abWasserVer = dNVWM / (dNE - 1); //Abwassermenge/Jahr
    betrieb.stadtWasserVer = dNVWM + betrieb.abWasserVer; //Speisewassermenge/Jahr
    betrieb.dosMittelVer = betrieb.abWasserVer * preise.dosierMenge / 1000; //Chemiklaienmenge
    betrieb.salzTabVer = 1.25 * dNSUK * betrieb.stadtWasserVer *
        (1 - dNVerschnitt) * 120; //*Salzmenge/Jahr, 2-facher šberschuá (120g), bez. auf SUK
    //double svt = 1.25 * dNSUK * betrieb.stadtWasserVer * (1-(((int)(dNVerschnitt*100))/100)) * 120; //*Salzmenge/Jahr, 2-facher šberschuá (120g), bez. auf SUK

     //Stadt- und Abwasserkosten zum Betreiben der Enth„rtungsanlage berechnen
     //Berechnungsgrundlage: Proportionalit„t von Salzverbrauch und Sp?lwasser
     //5 l Sp?lwasser/ l Harz oder 180g Salz
     dSPWM = betrieb.salzTabVer * 0.0278;

    //Stadt- Abwasser- und Energiemengen zum Betreiben der Umkehrosmoseanlage berechnen
    //Energie: 1,0 kWh / 1 m3 Speisewasser
    dSPWM2 = betrieb.stadtWasserVer * 0.25 * (1 - dNVerschnitt);

    //Energie: 1,0 kWh / 1m³ Speisewasser
    betrieb.enVer = betrieb.stadtWasserVer * (1 - dNVerschnitt);

    //Gesamte Stadt- und Abwassermenge korrigieren
    betrieb.stadtWasserVer = betrieb.stadtWasserVer + dSPWM + dSPWM2;
    if (siel == 1) { //siel 1/2
      betrieb.abWasserVer = betrieb.abWasserVer + dSPWM + dSPWM2;
    }
    else {
      betrieb.abWasserVer = betrieb.abWasserVer + dSPWM;
      betrieb.regenSielVer = dSPWM2;
    }

    //Jahresbetriebskosten in Tabelle kopieren
    betrieb.stadtWasserKost = betrieb.stadtWasserVer * preise.stadtWasser; //Speisewasser
    betrieb.abWasserKost = betrieb.abWasserVer * preise.abWasser; //Abwasser
    betrieb.regenSielKost = betrieb.regenSielVer * preise.regenWasser; //Regensiel
    //wenn nur ein Siel
    betrieb.dosMittelKost = betrieb.dosMittelVer * preise.dosierMittel; //
    betrieb.salzTabKost = betrieb.salzTabVer * preise.salzTabletten; //Salzkosten
    betrieb.enKost = betrieb.enVer * preise.energie; //Energiekosten
    return betrieb; //objekt zurueckgeben
  }
//
}