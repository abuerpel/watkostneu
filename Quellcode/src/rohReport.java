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

public class rohReport
    extends SimplePrint {
  private rohanalyse analyse;
  public rohReport() {

  }

  //
  public void setAnalyse(rohanalyse ra) {
    analyse = ra;
  }

  //

  public void paint(Graphics g, int pageIndex)

  {
    int i;
    i = 0;
    g.setFont(fnt);
    g.setColor(Color.black);
    //g.drawString("Page " + (pageIndex+1), 100, 100);
    i = zaehlen(i, 150);
    g.drawString(startframe.Texte.elementAt(20).toString(), 80, i);
    g.setFont(fnt2);
    i = zaehlen(i, 50);
    g.drawString(startframe.Texte.elementAt(47).toString(), 100, i);
    g.drawString(analyse.analysenNummer, 300, i);
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
    g.drawString(startframe.Texte.elementAt(252).toString(), 100, i);
    g.drawString(analyse.tE + " °C", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(253).toString(), 100, i);
    g.drawString(zahltostring(analyse.pHtE, 4), 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(194).toString(), 100, i);
    g.drawString(zahltostring( (analyse.lF), 5) + " µS/cm", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(195).toString(), 100, i);
    g.drawString(analyse.ca + " mg/l Ca", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(196).toString(), 100, i);
    g.drawString(analyse.mg + " mg/l Mg", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(197).toString(), 100, i);
    g.drawString(zahltostring( (analyse.na), 5) + " mg/l Na", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(198).toString(), 100, i);
    g.drawString(analyse.ks + " mmol/l", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(199).toString(), 100, i);
    g.drawString(analyse.cl + " mg/l Cl", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(200).toString(), 100, i);
    g.drawString(analyse.so4 + " mg/l SO4", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(201).toString(), 100, i);
    g.drawString(zahltostring(analyse.no3, 5) + " mg/l NO3", 300, i);
    i = zaehlen(i, 30);
    //
    g.drawString(startframe.Texte.elementAt(202).toString(), 100, i);
    g.drawString(zahltostring( (analyse.hco3), 5) + " mg/l HCO3", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(203).toString(), 100, i);
    g.drawString(zahltostring( (analyse.co3), 5) + " mg/l CO3", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(204).toString(), 100, i);
    g.drawString(zahltostring( (analyse.h2co3), 5) + " mg/l CO2", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(205).toString(), 100, i);
    g.drawString(zahltostring( (analyse.suA * 1000), 5) + " mmol/l", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(206).toString(), 100, i);
    g.drawString(zahltostring( (analyse.i * 1000), 5) + " mmol/l", 300, i);
    i = zaehlen(i, 30);

    g.drawString(startframe.Texte.elementAt(254).toString(), 100, i);
    g.drawString(zahltostring(analyse.pHggW, 4), 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(255).toString(), 100, i);
    g.drawString(zahltostring(analyse.sitE, 5), 300, i);
    g.setColor(Color.blue);
    g.setFont(fnt3);
   g.drawString("Copyright © 1999-2013  Dr. H. Kacirek, N. Kacirek",80, 700);

  }
}
