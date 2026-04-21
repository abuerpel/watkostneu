/**
 * Title:        projektdatei
 * Description:  Datenformat Input/Output
 * Copyright:    Copyright (c) nils kacirek
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */


public class projektdatei
    implements java.io.Serializable {
  rohanalyse analysendaten = new rohanalyse();
  kosten betriebskosten = new kosten();
  grenzwerte grenz1 = new grenzwerte();
  grenzwerte grenz2 = new grenzwerte();

  public void setData(rohanalyse rohana, kosten betriebskost, grenzwerte g1,
                      grenzwerte g2) {
    analysendaten = (rohanalyse) rohana;
    betriebskosten = (kosten) betriebskost;
    grenz1 = g1;
    grenz2 = g2;
  }

  //
  public rohanalyse getAnalyse() {

    return analysendaten;
  }

  //
  public kosten getKosten() {
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

  public projektdatei() {

  }
}