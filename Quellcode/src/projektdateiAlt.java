/**
 * Title:        projektdatei
 * Description:  Datenformat Input/Output
 * Copyright:    Copyright (c) nils kacirek
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */


public class projektdateiAlt
    implements java.io.Serializable {
  rohanalyseAlt analysendaten = new rohanalyseAlt();
  kostenAlt betriebskosten = new kostenAlt();
  grenzwerte grenz1 = new grenzwerte();
  grenzwerte grenz2 = new grenzwerte();

  public void setData(rohanalyseAlt rohana, kostenAlt betriebskost,
                      grenzwerte g1, grenzwerte g2) {
    analysendaten = (rohanalyseAlt) rohana;
    betriebskosten = (kostenAlt) betriebskost;
    grenz1 = g1;
    grenz2 = g2;
  }

  //
  public rohanalyseAlt getAnalyse() {

    return analysendaten;
  }

  //
  public kostenAlt getKosten() {
    return betriebskosten;
  }

  //
  public grenzwerte getG1() {
    return grenz1;
  }

  //
  public grenzwerte getG2() {
    return grenz2;
  }

  public projektdateiAlt() {

  }
}