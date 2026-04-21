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

public class anaReport
    extends SimplePrint {
  private umlaufanalyse analyse;
  private String aufbereitung;
  public anaReport() {

  }

  //
  public void setAnalyse(umlaufanalyse ra, String ab) {
    analyse = ra;
    aufbereitung = ab;
  }

  public void paint(Graphics g, int pageIndex)

  {
    int i;
    i = 0;
    g.setFont(fnt);
    g.setColor(Color.black);
    //g.drawString("Page " + (pageIndex+1), 100, 100);
    i = zaehlen(i, 1);
    g.drawString(startframe.Texte.elementAt(89).toString(), 80, i);
    g.setFont(fnt2);

    i = zaehlen(i, 50);
    g.drawString(startframe.Texte.elementAt(47).toString(), 100, i);
    g.drawString(analyse.analysenNummer, 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(31).toString(), 100, i);
    g.drawString(aufbereitung, 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(139).toString(), 100, i);
    g.drawString(Datum, 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(111).toString(), 100, i);
    g.drawString(analyse.kunde, 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(112).toString(), 100, i);
    g.drawString(analyse.projekt, 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(113).toString(), 100, i);
    g.drawString(analyse.bearbeiter, 300, i);
    i = zaehlen(i, 30);
    //
    g.drawString(startframe.Texte.elementAt(190).toString(), 100, i);
    g.drawString(zahltostring(analyse.verSchnitt), 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(191).toString(), 100, i);
    g.drawString(zahltostring(analyse.eindickung), 300, i);
    i = zaehlen(i, 30);
    //
    g.drawString(startframe.Texte.elementAt(192).toString(), 100, i);
    g.drawString(zahltostring(analyse.tKT) + " °C", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(193).toString(), 100, i);
    g.drawString(zahltostring(analyse.tW) + " °C", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(194).toString(), 100, i);
    g.drawString(zahltostring(analyse.lF) + " µS/cm", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(195).toString(), 100, i);
    g.drawString(zahltostring(analyse.ca) + " g/l Ca", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(196).toString(), 100, i);
    g.drawString(zahltostring(analyse.mg) + " g/l Mg", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(197).toString(), 100, i);
    g.drawString(zahltostring(analyse.na) + " g/l Na", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(198).toString(), 100, i);
    g.drawString(zahltostring(analyse.ks) + " mmol/l", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(199).toString(), 100, i);
    g.drawString(zahltostring(analyse.cl) + " mg/l Cl", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(200).toString(), 100, i);
    g.drawString(zahltostring(analyse.so4) + " mg/l SO4", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(201).toString(), 100, i);
    g.drawString(zahltostring(analyse.no3) + " mg/l NO3", 300, i);
    i = zaehlen(i, 30);
    //
    g.drawString(startframe.Texte.elementAt(202).toString(), 100, i);
    g.drawString(zahltostring(analyse.hco3) + " mg/l HCO3", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(203).toString(), 100, i);
    g.drawString(zahltostring(analyse.co3) + " mg/l CO3", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(204).toString(), 100, i);
    g.drawString(zahltostring(analyse.h2co3) + " mg/l H2CO3", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(205).toString(), 100, i);
    g.drawString(zahltostring(analyse.ionen * 1000) + " mmol/l", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(206).toString(), 100, i);
    g.drawString(zahltostring(analyse.salz * 1000) + " mmol/l", 300, i);
    i = zaehlen(i, 30);
    //
    g.drawString(startframe.Texte.elementAt(207).toString(), 100, i);
    g.drawString(zahltostring(analyse.pHKTnV), 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(208).toString(), 100, i);
    g.drawString(zahltostring(analyse.pHTKT), 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(209).toString(), 100, i);
    g.drawString(zahltostring(analyse.siTKT, 4), 300, i);
    g.drawString(startframe.Texte.elementAt(210).toString(), 100, i);
    g.drawString(zahltostring(analyse.pHggWW), 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(211).toString(), 100, i);
    g.drawString(zahltostring(analyse.sIW, 4), 300, i);

    g.setColor(Color.blue);
    g.setFont(fnt3);
    g.drawString("Copyright © 1999-2013  Dr. H. Kacirek, N. Kacirek",
                 100, 700);

  }
}
