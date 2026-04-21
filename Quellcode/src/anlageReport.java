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
import java.applet.*;
import java.net.URL;
import java.awt.image.*;

public class anlageReport
    extends SimplePrint {
  private anlagekosten anlKost;
  private umlaufanalyse analyse;
  private String verfahren,verfahrenAnzeige; //Anlageart,Anlageart zum Anzeigen in Landesprache
  private Image logo;
  private Frame pf;

  public anlageReport(){}
  public anlageReport(Frame f) {
    pf = f; //referenz auf das aufrufende Frame
    //logo = l;
    Toolkit g = f.getToolkit();
    //logo = g.getImage(startframe.homeDir + "/bin/watkost/logowat.gif");
    //logo = g.getImage("c:/JavaWork/watkostapp/img/beide.gif");
    //logo = g.getImage("c:/Watkosttest/img/beide.gif");
    //MediaTracker mt = new MediaTracker(f);
    //mt.addImage(logo, 0);
    /*try
         {
      mt.waitForAll();
         }
         catch( Exception e)
         {
      System.out.print(e);
      System.exit(-1);
         }*/
  }

  //
  public void setAnalyse(anlagekosten ak, umlaufanalyse ra, String ab, String ac) {
    anlKost = ak;
    verfahren = ab;
    analyse = ra;
    verfahrenAnzeige = ac;
  }

  //

  public void paint(Graphics g, int pageIndex)

  {
    Graphics2D g2 = (Graphics2D) g;
    int i;
    i = 0;
    //g2.drawImage(logo,75,80,pf);
    //g2.drawRect(100, 75, 110, 45);
    //g2.drawRect(210, 75, 317, 45);
    g2.setFont(startframe.fntTriline);
    g2.drawString("", 105, 115);
    g2.setFont(startframe.fntAvantgarde);
    g2.drawString(",", 220, 95);
    g2.drawString("", 220, 115);
    g2.setFont(fnt);
    g2.setColor(Color.blue);
    g2.drawString("", 383, 140);
    //ic.paintIcon(pf,g,100,100);
    //g.drawString("Page " + (pageIndex+1), 100, 100);
    i = zaehlen(i, 160);
    g2.setColor(Color.black);
    if (verfahren.equalsIgnoreCase("Umkehrosmose m. v. Enthaertung")) {
      verfahren = "Umkehrosmose m. v. Eht.";
    }
    g2.drawString(startframe.Texte.elementAt(136).toString() + verfahrenAnzeige, 100,
                  i);
    g.setFont(fnt2);
    i = zaehlen(i, 35);
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
    i = zaehlen(i, 25);

    //hier den if Block einbauen

    if (verfahren == "Enthärtung" || verfahren == "Entcarbonisierung" ||
        verfahren == "Umkehrosmose m. v. Eht.") {
      g.drawString("Anlage, Typ ", 100, i);
      g.drawString(anlKost.typ1, 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(141).toString(), 100, i);
      g.drawString(zahltostring(anlKost.kap1, 7) + " mol", 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(142).toString(), 100, i);
      g.drawString(anlKost.nennweite1, 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(143).toString(), 100, i);
      g.drawString(anlKost.ws1, 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(144).toString(), 100, i);
      g.drawString(anlKost.st1, 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(145).toString(), 100, i);
      g.drawString(anlKost.wz1, 300, i);

      if (verfahren == "Entcarbonisierung") { //neutralfilter kommt dazu
        i = zaehlen(i, 15);
        g.drawString(startframe.Texte.elementAt(156).toString(), 100, i);
        g.drawString(anlKost.nf, 300, i);
      }

      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(146).toString(), 100, i);
      g.drawString(zahltostring(anlKost.aP1, 7) + ".- € ¹", 300, i);
      i = zaehlen(i, 25);
    }

    //
    if (verfahren == "Umkehrosmose m. v. Eht." ||
        verfahren == "Umkehrosmose o. v. Enthärtung") {
      g.drawString(startframe.Texte.elementAt(140).toString(), 100, i);
      g.drawString(anlKost.typ2, 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(147).toString(), 100, i);
      g.drawString(zahltostring(anlKost.kap2, 7) + " l/h", 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(142).toString(), 100, i);
      g.drawString(zahltostring(anlKost.ws2, 7), 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(144).toString(), 100, i);
      g.drawString(anlKost.st2, 300, i);
      if (verfahren == "Umkehrosmose o.v. Enthärtung") {
        ;
      }
      {
        i = zaehlen(i, 15);
        g.drawString(startframe.Texte.elementAt(148).toString(), 100, i);
        g.drawString(startframe.Texte.elementAt(137).toString(), 300, i);
      }
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(146).toString(), 100, i);
      g.drawString(zahltostring(anlKost.aP2, 7) + ".- € ¹", 300, i);
      i = zaehlen(i, 25);
    }
    //
    if (verfahren == "Schwefelsäuredosierung") {
      g.drawString(startframe.Texte.elementAt(140).toString(), 100, i);
      g.drawString(anlKost.typ1, 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(148).toString(), 100, i);
      g.drawString("1", 230, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(149).toString(), 100, i);
      g.drawString("V " + zahltostring(anlKost.kap1, 7), 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(143).toString(), 100, i);
      g.drawString(anlKost.ws1, 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(144).toString(), 100, i);
      g.drawString(anlKost.st1, 300, i);
      i = zaehlen(i, 15);
      g.drawString(startframe.Texte.elementAt(146).toString(), 100, i);
      g.drawString(zahltostring(anlKost.aP1, 7) + ".- € ¹", 300, i);
      i = zaehlen(i, 25);
    }
    //
    //threshold stabilisierungsblock taucht immer auf
    g.drawString(startframe.Texte.elementAt(140).toString(), 100, i);
    g.drawString(anlKost.typ3, 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(148).toString(), 100, i);
    g.drawString("2", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(149).toString(), 100, i);
    g.drawString("V " + zahltostring(anlKost.kap3, 7), 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(143).toString(), 100, i);
    g.drawString(anlKost.ws3, 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(144).toString(), 100, i);
    g.drawString(anlKost.st3, 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(145).toString(), 100, i);
    g.drawString(anlKost.wz3, 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(146).toString(), 100, i);
    g.drawString(zahltostring(anlKost.aP3, 7) + ".- € ¹", 300, i); //³²³¹¹¹
    i = zaehlen(i, 30);
    g.drawString(startframe.Texte.elementAt(150).toString(), 100, i);
    g.drawString(zahltostring(anlKost.stffP, 7) + ".- € ¹", 300, i);
    i = zaehlen(i, 15);
    g.drawString(startframe.Texte.elementAt(151).toString(), 100, i);
    g.drawString(zahltostring(anlKost.summe, 7) + ".- € ¹", 300, i);
    i = zaehlen(i, 30);
    g.drawString(startframe.Texte.elementAt(152).toString(), 100, i);
    g.drawString(zahltostring(anlKost.jahresBetrag, 7) + ".- € ²", 300, i);
    //
    g.setFont(fnt4);
    i = zaehlen(i, 20);
    g.drawString(startframe.Texte.elementAt(153).toString(), 150, i);
    i = zaehlen(i, 12);
    g.drawString(startframe.Texte.elementAt(154).toString()+startframe.Texte.elementAt(155).toString(),
                 150, i);
    g.setColor(Color.blue);
    g.setFont(fnt3);
    g.drawString("Copyright © 1999-2013 Dr. H. Kacirek, N. Kacirek",300,700);
    g.dispose();
  }
}
