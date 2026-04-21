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

public class umlwReport
    extends SimplePrint

{

  public umlwReport() {
  }

  private umlaufanalyse analyse;
  private String aufbereitung;

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
    i = zaehlen(i, 150);
    g.drawString(startframe.Texte.elementAt(258).toString(), 80, i);
    g.setFont(fnt2);

    i = zaehlen(i, 50);
    g.drawString(startframe.Texte.elementAt(47).toString(), 100, i);
    g.drawString(analyse.analysenNummer, 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(31).toString(), 100, i);
    g.drawString(aufbereitung, 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(39).toString(), 100, i);
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
    g.drawString(Integer.toString( (int) (analyse.verSchnitt * 100)) + " %",
                 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(191).toString(), 100, i);
    g.drawString(zahltostring(analyse.eindickung, 4), 300, i);
    i = zaehlen(i, 30);
    //
    g.drawString(startframe.Texte.elementAt(260).toString(), 100, i);
    g.drawString(zahltostring(analyse.tKT, 4) + " °C", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(194).toString(), 100, i);
    g.drawString(zahltostring( (analyse.lF), 5) + " µS/cm", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(195).toString(), 100, i);
    g.drawString(zahltostring( (analyse.ca), 5) + " mg/l Ca", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(196).toString(), 100, i);
    g.drawString(zahltostring( (analyse.mg), 5) + " mg/l Mg", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(197).toString(), 100, i);
    g.drawString(zahltostring( (analyse.na), 5) + " mg/l Na", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(198).toString(), 100, i);
    g.drawString(zahltostring( (analyse.ks), 5) + " mmol/l", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(199).toString(), 100, i);
    g.drawString(zahltostring( (analyse.cl), 5) + " mg/l Cl", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(200).toString(), 100, i);
    g.drawString(zahltostring( (analyse.so4), 5) + " mg/l SO4", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(201).toString(), 100, i);
    g.drawString(zahltostring( (analyse.no3), 5) + " mg/l NO3", 300, i);
    i = zaehlen(i, 30);
    //
    g.drawString(startframe.Texte.elementAt(202).toString(), 100, i);
    g.drawString(zahltostring( (analyse.hco3), 5) + " mg/l HCO3", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(203).toString(), 100, i);
    g.drawString(zahltostring( (analyse.co3), 5) + " mg/l CO3", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(204).toString(), 100, i);
    g.drawString(zahltostring( (analyse.h2co3), 5) + " mg/l H2CO3", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(205).toString(), 100, i);
    g.drawString(zahltostring( (analyse.salz), 5) + " mmol/l", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(206).toString(), 100, i);
    g.drawString(zahltostring( (analyse.ionen), 5) + " mmol/l", 300, i);
    i = zaehlen(i, 30);
    //
    g.drawString(startframe.Texte.elementAt(261).toString(), 100, i);
    g.drawString(zahltostring(analyse.pHKTnV, 4), 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(262).toString(), 100, i);
    g.drawString(zahltostring(analyse.pHTKT, 4), 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(263).toString(), 100, i);
    g.drawString(zahltostring(analyse.siTKT, 5), 300, i);

    g.setColor(Color.blue);
    g.setFont(fnt3);
   g.drawString("Copyright © 1999-2013  Dr. H. Kacirek, N. Kacirek",80, 700);

  }
}
