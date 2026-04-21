/**
 * Title:        rohanalyse
 * Description:  klasse zum speichern von analysenwerten
 * Copyright:    Copyright (c) nils kacirek
 * Company:      wat
 * @author nils kacirek
 * @version 1.0
 */
//package watkost;

public class rohanalyse
    implements java.io.Serializable {
  String analysenNummer, kunde, bearbeiter, projekt;
  //neu
  String stadt, plz;
  //
  double tE, pHtE, lF, lFBer, ca, mg, ks, cl, so4, no3, pHggW, sitE, na, suK,
      suA, i;
  double hco3, co3, h2co3;
  public rohanalyse() {

  }
}