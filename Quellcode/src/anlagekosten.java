/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */


public class anlagekosten {
  String verfahren, model, rohr, uomodel, zusatzName1, thName, thRohr,
      thBehaelter;
  int preis, rohrpreis, zusatz1, zusatz2, zusatz3, option1, option2, option3,
      dosierstation
      , thPreis, thRohrPreis, thZaehler, thSystemtrenner, uopreis;

  //neu
  String aufbereitungsart, typ1, typ2, typ3, nennweite1, nennweite2, nennweite3,
      ws1, ws2, ws3, st1, st2, st3, wz1, wz2, wz3, dosuo, nf;

  int kap1, kap2, kap3, aP1, aP2, aP3, stffP, summe, jahresBetrag;

  public anlagekosten() {
  }

  public void nullen() {
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
