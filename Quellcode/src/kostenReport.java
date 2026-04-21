/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */

import java.awt.*;
import java.awt.print.*;

public class kostenReport
    extends SimplePrint

{

  private betriebskosten betrkosten;
  private kosten kosten;
  private String aufbereitung;
  private umlaufanalyse analyse;
  private int anlageKostenJahr;
  private Image logo;

  public kostenReport() {
    //logo = getImage.(this.getCodeBase(),"images/logo.bmp");
  }

  //
  public void setAnalyse(kosten ko, betriebskosten bk, umlaufanalyse au,
                         String ab, int ak) {
    kosten = ko;
    betrkosten = bk;
    analyse = au;
    aufbereitung = ab;
    anlageKostenJahr = ak;

  }

  public void paint(Graphics g, int pageIndex)

  {

    int i;
    i = 0;
    g.setFont(fnt);
    g.setColor(Color.black);

    //g.drawString("Page " + (pageIndex+1), 100, 100);
    i = zaehlen(i, 90);
    g.drawString(startframe.Texte.elementAt(213).toString(), 80, i);
    g.setFont(fnt6);

    i = zaehlen(i, 50);
    g.drawString(startframe.Texte.elementAt(47).toString(), 100, i);
    g.drawString(analyse.analysenNummer, 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(31).toString(), 100, i);
    g.drawString(aufbereitung, 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(139).toString(), 100, i);
    g.drawString(Datum, 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(111).toString(), 100, i);
    g.drawString(analyse.kunde, 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(112).toString(), 100, i);
    g.drawString(analyse.projekt, 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(113).toString(), 100, i);
    g.drawString(analyse.bearbeiter, 300, i);
    i = zaehlen(i, 20);
    // Kosten
    g.drawString(startframe.Texte.elementAt(190).toString(), 100, i);
    g.drawString(Integer.toString( (int) (analyse.verSchnitt * 100)) + " %",
                 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(191).toString(), 100, i);
    g.drawString(zahltostring(analyse.eindickung), 300, i);
    i = zaehlen(i, 20);
    //Kosten
    g.drawString(startframe.Texte.elementAt(216).toString(), 100, i);
    g.drawString(Double.toString(kosten.stadtWasser) + " EUR/m³", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(217).toString(), 100, i);
    g.drawString(Double.toString(kosten.abWasser) + " EUR/m³", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(218).toString(), 100, i);
    g.drawString(Double.toString(kosten.regenWasser) + " EUR/m³", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(219).toString(), 100, i);
    g.drawString(Double.toString(kosten.energie) + " EUR/kWh", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(247).toString(), 100, i);
    g.drawString(Integer.toString( (int) kosten.leistung) + " kW", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(221).toString(), 100, i);
    g.drawString(Integer.toString( (int) kosten.auslastung) + " %", 300, i);
    //
    i = zaehlen(i, 20);
    g.drawString(startframe.Texte.elementAt(222).toString(), 100, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(223).toString(), 100, i);
    g.drawString(zahltostring(kosten.dosierMittel) + " EUR/kg", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(224).toString(), 100, i);
    g.drawString(Integer.toString( (int) kosten.dosierMenge) + " g/m³", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(225).toString(), 100, i);
    g.drawString(zahltostring(kosten.salzTabletten) + " EUR/kg", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(226).toString(), 100, i);
    g.drawString(zahltostring(kosten.salzSaeure) + " EUR/kg", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(249).toString(), 100, i);
    g.drawString(zahltostring(kosten.schwefelSaeure) + " EUR/kg", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(227).toString(), 100, i);
    g.drawString(zahltostring(kosten.ro) + " EUR/kg", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(228).toString(), 100, i);
    g.drawString(zahltostring(kosten.roMenge) + " g/m³", 300, i);
    i = zaehlen(i, 20);

    //
    g.drawString(startframe.Texte.elementAt(229).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.enVer) + " kWh/Jahr", 300,
                 i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(230).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.stadtWasserVer) +
                 " m³/Jahr", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(231).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.abWasserVer) + " m³/Jahr",
                 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(232).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.regenSielVer) + " m³/Jahr",
                 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(233).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.dosMittelVer) + " kg/Jahr",
                 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(234).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.salzTabVer) + " kg/Jahr",
                 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(235).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.salzSaeureVer) + " kg/Jahr",
                 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(249).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.schwefelSaeureVer) +
                 " kg/Jahr", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(236).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.roVer) + " kg/Jahr", 300, i);
    i = zaehlen(i, 20);
    //Kosten
    g.drawString(startframe.Texte.elementAt(237).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.enKost) + " EUR/Jahr", 300,
                 i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(238).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.stadtWasserKost) +
                 " EUR/Jahr", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(239).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.abWasserKost) + " EUR/Jahr",
                 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(240).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.regenSielKost) +
                 " EUR/Jahr", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(241).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.dosMittelKost) +
                 " EUR/Jahr", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(242).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.salzTabKost) + " EUR/Jahr",
                 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(243).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.salzSaeureKost) +
                 " EUR/Jahr", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(250).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.schwefelSaeureKost) +
                 " EUR/Jahr", 300, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(244).toString(), 100, i);
    g.drawString(Integer.toString( (int) betrkosten.roKost) + " EUR/Jahr", 300,
                 i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(245).toString(), 100, i);
    g.drawString(Integer.toString( (int) anlageKostenJahr) + " EUR/Jahr", 300,
                 i); ;
    i = zaehlen(i, 20);
    g.drawString(startframe.Texte.elementAt(246).toString(), 100, i);
    g.drawString(Integer.toString( (int) (betrkosten.roKost +
                                          betrkosten.schwefelSaeureKost
                                          + betrkosten.salzSaeureKost +
                                          betrkosten.salzTabKost +
                                          betrkosten.dosMittelKost +
                                          betrkosten.abWasserKost +
                                          betrkosten.stadtWasserKost +
                                          betrkosten.regenSielKost +
                                          betrkosten.enKost + anlageKostenJahr)) +
                 " EUR/Jahr", 300, i);
    //g.drawString(zahltostring(i,2),400,400);

    g.setColor(Color.blue);
    g.setFont(fnt3);
    g.drawString("Copyright © 1999-2013  Dr. H. Kacirek, N. Kacirek",80, 700);
  }
}
