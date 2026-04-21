/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */


public class sdkostenberechnung {

  public sdkostenberechnung() {
  }

  //


  static betriebskosten kostsdrech(kosten preise, rohanalyse anaroh, double dNE,
                                   double dNVerschnitt, double dEKS43M) {
    //kost15.prg
    //Betriebskostenrechnung f?r Aufbereitungsart 5, Teilentcarbonisierung
    //?ber Schwefels„uredosierung mit Threshold Stabilisierung
    //Wassermengen f?r Verdunstung Speisewasser und Abwasser berechnen;
    //Bezug: Verdampfungsenthalpie bei 30øC betr„gt 0,6758 kWh/kg
    //Grundlage: 1 kW verdampft 1,480 l/h; 8760 h = 1 a.

    betriebskosten betrieb = new betriebskosten(); //objekt erzeugen
    double dNVWM, dNKS43M, dH2SO4M;
    dNKS43M = anaroh.ks;
    dNVWM = preise.leistung * 12.97 * preise.auslastung / 100; //Verdunstungswassermenge/Jahr
    //Verbrauch berechnen
    betrieb.abWasserVer = dNVWM / (dNE - 1); //Abwassermenge/Jahr
    betrieb.stadtWasserVer = dNVWM + betrieb.abWasserVer; //Speisewassermenge/Jahr
    betrieb.dosMittelVer = betrieb.abWasserVer * preise.dosierMenge / 1000; //Chemiklaienmenge
    dH2SO4M = (dNKS43M / 1000) * dNE - (dEKS43M / 1000);
    betrieb.schwefelSaeureVer = dH2SO4M * betrieb.abWasserVer * 50;
    //vorläufig  verhindern, dass Schwefelsäure 0 wird
    if (betrieb.schwefelSaeureVer < 0) {
      betrieb.schwefelSaeureVer = 0;
    }
    //Jahresbetriebskosten in Tabelle kopieren
    betrieb.stadtWasserKost = betrieb.stadtWasserVer * preise.stadtWasser; //Speisewasser
    betrieb.abWasserKost = betrieb.abWasserVer * preise.abWasser; //Abwasser
    betrieb.dosMittelKost = betrieb.dosMittelVer * preise.dosierMittel; //
    betrieb.schwefelSaeureKost = betrieb.schwefelSaeureVer *
        preise.schwefelSaeure; //schwefelsaeure
    return betrieb; //objekt zurueckgeben
  }
}