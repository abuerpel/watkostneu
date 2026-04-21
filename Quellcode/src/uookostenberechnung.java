/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */

public class uookostenberechnung {

  public uookostenberechnung() {
  }

//
  static betriebskosten kostuorechL(kosten preise, grenzwerte bedingungen,
                                    rohanalyse anaroh, double dNE,
                                    double dNVerschnitt, int siel) {
    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    double dNVWM, dLeistung;
    dLeistung = preise.leistung2; //Bei Luftwaescherleistung
    dNVWM = dLeistung * 26.28 * preise.auslastung / 100000; //Verdunstungswassermenge/Jahr
    betrieb = berechne(preise, bedingungen, anaroh, dNE, dNVerschnitt, dNVWM,
                       siel);
    return betrieb; //objekt zurueckgeben
  }

//
  static betriebskosten kostuorech(kosten preise, grenzwerte bedingungen,
                                   rohanalyse anaroh, double dNE,
                                   double dNVerschnitt, int siel) {
    double dNVWM, dLeistung;
    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    dLeistung = preise.leistung; //Bei Luftwaescherleistung
    dNVWM = dLeistung * 12.97 * preise.auslastung / 100; //Verdunstungswassermenge/Jahr
    betrieb = berechne(preise, bedingungen, anaroh, dNE, dNVerschnitt, dNVWM,
                       siel);
    return betrieb; //objekt zurueckgeben
  }

//
  static betriebskosten berechne(kosten preise, grenzwerte bedingungen,
                                 rohanalyse anaroh, double dNE,
                                 double dNVerschnitt, double dNVWM, int siel) {
    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    double dSPWM2; //Variablen deklarieren
    //Verbrauch berechnen
    betrieb.abWasserVer = dNVWM / (dNE - 1); //Abwassermenge/Jahr
    betrieb.stadtWasserVer = dNVWM + betrieb.abWasserVer; //Speisewassermenge/Jahr
    betrieb.dosMittelVer = betrieb.abWasserVer * preise.dosierMenge / 1000; //Chemiklaienmenge

    //Stadt-/ und Abwasser-/ und Energiemengen zum
    //Betreiben der Umkehrosmoseanlage berechnen

    //Energie: 1,0 kWh / 1m³ Speisewasser
    betrieb.enVer = betrieb.stadtWasserVer * (1 - dNVerschnitt);

    //Konzentrat und zusaetzliche Speisewassermenge
    //hierzu muß die Eindickung bei RO bestimmt werden

    dNE = watkostberechnung.kostuo(anaroh, bedingungen);

    dSPWM2 = betrieb.stadtWasserVer * (1 - dNVerschnitt) / (dNE - 1); //fehler
    //Gesamte Stadt und Abwassermenge korrigieren
    betrieb.stadtWasserVer = betrieb.stadtWasserVer + dSPWM2;
    if (siel == 1) { //siel 1/2
      betrieb.abWasserVer = betrieb.abWasserVer + dSPWM2;
    }
    else {
      betrieb.abWasserVer = betrieb.abWasserVer;
      betrieb.regenSielVer = dSPWM2;
    }
    //Dosiermenge RO berechnen
    betrieb.roVer = dSPWM2 * preise.roMenge / 1000;

    //Jahresbetriebskosten in Tabelle kopieren
    betrieb.stadtWasserKost = betrieb.stadtWasserVer * preise.stadtWasser; //Speisewasser
    betrieb.abWasserKost = betrieb.abWasserVer * preise.abWasser; //Abwasser
    betrieb.regenSielKost = betrieb.regenSielVer * preise.regenWasser; //Regensiel
    betrieb.dosMittelKost = betrieb.dosMittelVer * preise.dosierMittel;
    betrieb.roKost = betrieb.roVer * preise.ro; // Dosiermittel RO
    betrieb.enKost = betrieb.enVer * preise.energie; //Energiekosten
    return betrieb; //objekt zurueckgeben
  }
}