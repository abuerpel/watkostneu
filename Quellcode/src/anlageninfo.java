/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class anlageninfo
    extends JDialog {
  Container c = new Container();
  JPanel jPanel0 = new JPanel();
  JPanel jPanel1 = new JPanel();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  GridLayout gridLayout1 = new GridLayout();
  GridLayout gridLayout2 = new GridLayout();
  JLabel jLabelAnlage = new JLabel(startframe.Texte.elementAt(267).toString(), 2);
  JLabel jLabelStrassenkapazitaet = new JLabel(startframe.Texte.elementAt(268).toString(), 2);
  JLabel jLabelNennweite = new JLabel(startframe.Texte.elementAt(269).toString(), 2); //Nenweite wird bei UO + eh zu UO Anlagenversion
  JLabel jLabelWerkstoff = new JLabel(startframe.Texte.elementAt(270).toString(), 2);
  JLabel jLabelZusatz1 = new JLabel(startframe.Texte.elementAt(271).toString(), 2);
  JLabel jLabelZusatz2 = new JLabel(startframe.Texte.elementAt(272).toString(), 2);
  JLabel jLabelUO = new JLabel(startframe.Texte.elementAt(273).toString(), 2);
  JLabel jLabelZusatzName1 = new JLabel(startframe.Texte.elementAt(274).toString(), 2);
  JLabel jLabelOption1 = new JLabel(startframe.Texte.elementAt(275).toString(), 2);
  JLabel jLabelOption2 = new JLabel(startframe.Texte.elementAt(276).toString(), 2);
  JLabel jLabelDosierstation = new JLabel(startframe.Texte.elementAt(277).toString(), 2);
  JLabel jLabelSumme = new JLabel(startframe.Texte.elementAt(278).toString(), 2);
  //zweite Spalte
  JLabel jLabelAnlageW = new JLabel();
  JLabel jLabelStrassenkapazitaetW = new JLabel();
  JLabel jLabelNennweiteW = new JLabel();
  JLabel jLabelWerkstoffW = new JLabel(startframe.Texte.elementAt(279).toString(), 2);
  JLabel jLabelZusatz1W = new JLabel();
  JLabel jLabelZusatz2W = new JLabel();
  JLabel jLabelUOW = new JLabel();
  JLabel jLabelZusatzName1W = new JLabel();
  JLabel jLabelOption1W = new JLabel();
  JLabel jLabelOption2W = new JLabel();
  JLabel jLabelDosierstationW = new JLabel();
  //dritte Spalte
  JLabel jLabelAnlageP = new JLabel("", 2);
  JLabel jLabelStrassenkapazitaetP = new JLabel("", 2);
  JLabel jLabelNennweiteP = new JLabel("", 2);
  JLabel jLabelWerkstoffP = new JLabel("", 2);
  JLabel jLabelZusatz1P = new JLabel("", 2);
  JLabel jLabelZusatz2P = new JLabel("", 2);
  JLabel jLabelUOP = new JLabel("", 2);
  JLabel jLabelZusatzName1P = new JLabel("", 2);
  JLabel jLabelOption1P = new JLabel("", 2);
  JLabel jLabelOption2P = new JLabel("", 2);
  JLabel jLabelDosierstationP = new JLabel("", 2);
  JLabel jLabelSummeP = new JLabel("", 2);
  //dritte Spalte
  JLabel jLabelPreis = new JLabel("", 2);
  JLabel jLabel1 = new JLabel();

  public anlageninfo(String aufbereitung, anlagekosten kosten, JFrame f) {
    this.setTitle(startframe.Texte.elementAt(266).toString() + aufbereitung);
    //jPanel1.setBorder(new LineBorder(Color.darkGray,2));
    jPanel1.setBorder(new EtchedBorder(1));
    jPanel2.setBorder(new EtchedBorder(1));
    jPanel3.setBorder(new EtchedBorder(1));
    jPanel4.setBorder(new EtchedBorder(1));
    gridLayout1.setRows(12);
    gridLayout1.setColumns(2);
    gridLayout2.setRows(1);
    gridLayout2.setColumns(3);
    gridLayout2.setHgap(2);
    c = this.getContentPane();
    c.setLayout(gridLayout2);
    c.add(jPanel1, gridLayout2);
    c.add(jPanel2, gridLayout2);
    c.add(jPanel3, gridLayout2);
    //c.add(jPanel4, gridLayout2);
    //erste Spalte
    jPanel1.setLayout(gridLayout1);
    jPanel1.add(jLabelAnlage, null);
    jPanel1.add(jLabelStrassenkapazitaet, null);
    jPanel1.add(jLabelNennweite, null);
    jPanel1.add(jLabelWerkstoff, null);
    jPanel1.add(jLabelZusatz1, null);
    jPanel1.add(jLabelZusatz2, null);
    jPanel1.add(jLabelOption1, null);
    // wenn aufbereitung Umkehrosmose + Enthärtung Feld hinzufügen
    if (aufbereitung == "Umkehrosmose m. v. Enthaertung") {
      jPanel1.add(jLabelUO, null);
      jPanel1.add(jLabelZusatzName1, null);
    }

    jPanel1.add(jLabelOption2, null);
    jPanel1.add(jLabelDosierstation, null);
    jPanel1.add(jLabelSumme, null);
    //zweite Spalte
    jPanel2.setLayout(gridLayout1);
    jPanel2.add(jLabelAnlageW, null);
    jPanel2.add(jLabelStrassenkapazitaetW, null);
    jPanel2.add(jLabelNennweiteW, null);
    jPanel2.add(jLabelWerkstoffW, null);
    jPanel2.add(jLabelZusatz1W, null);
    jPanel2.add(jLabelZusatz2W, null);
    jPanel2.add(jLabelOption1W, null);
    // wenn aufbereitung Umkehrosmose + Enthärtung Feld hinzufügen
    if (aufbereitung == "Umkehrosmose m. v. Enthaertung") {
      jPanel2.add(jLabelUOW, null);
      jPanel2.add(jLabelZusatzName1W, null);
    }

    jPanel2.add(jLabelOption2W, null);
    jPanel2.add(jLabelDosierstationW, null);
    //dritte Spalte
    jPanel3.setLayout(gridLayout1);
    jPanel3.add(jLabelAnlageP, null);
    jPanel3.add(jLabelStrassenkapazitaetP, null);
    jPanel3.add(jLabelNennweiteP, null);
    jPanel3.add(jLabelWerkstoffP, null);
    jPanel3.add(jLabelZusatz1P, null);
    jPanel3.add(jLabelZusatz2P, null);
    jPanel3.add(jLabelOption1P, null);
    // wenn aufbereitung Umkehrosmose + Enthärtung Feld hinzufügen
    if (aufbereitung == "Umkehrosmose m. v. Enthaertung") {
      jPanel3.add(jLabelUOP, null);
      jPanel3.add(jLabelZusatzName1P, null);
    }
    jPanel3.add(jLabelOption2P, null);
    jPanel3.add(jLabelDosierstationP, null);
    jPanel3.add(jLabelSummeP, null);
    //Werte anzeigen
    anzeigen(aufbereitung, kosten);

  }

  void anzeigen(String aufbereitung, anlagekosten kosten) {
    if (aufbereitung == "threshold Stabilisierung") {
      jLabelAnlageW.setText(" ");
      jLabelStrassenkapazitaet.setVisible(false);
      jLabelNennweite.setVisible(false);
      jLabelZusatz1.setVisible(false);
      jLabelOption2.setVisible(false);
      jLabelZusatz2.setVisible(false);
      jLabelOption1.setVisible(false);
      //Preise
      jLabelDosierstationP.setText(" " + Integer.toString(kosten.dosierstation) +
                                   ".- €");
      jLabelSummeP.setText(" " + Integer.toString(kosten.summe) + ".- €");
    }

    if (aufbereitung == "Enthärtung") {
      jLabelAnlageW.setText( kosten.verfahren + "-" + kosten.model);
      jLabelStrassenkapazitaetW.setText(" " + kosten.model);
      jLabelNennweiteW.setText(" " + kosten.rohr);
      jLabelZusatz1W.setText(startframe.Texte.elementAt(286).toString());
      jLabelOption2W.setText(" " + kosten.rohr);
      //nicht gebrauchte Löschen
      jLabelZusatz2.setVisible(false);
      jLabelOption1.setVisible(false);
      //Preise
      //jLabelAnlageP.setText(Integer.toString(kosten.preis));
      jLabelStrassenkapazitaetP.setText(" " + Integer.toString(kosten.preis) +
                                        ".- €");
      jLabelNennweiteP.setText(" " + Integer.toString(kosten.rohrpreis) +
                               ".- €");
      jLabelZusatz1P.setText(" " + Integer.toString(kosten.zusatz1) + ".- €");
      jLabelOption2P.setText(" " + Integer.toString(kosten.option1) + ".- €");
      jLabelDosierstationP.setText(" " + Integer.toString(kosten.dosierstation) +
                                   ".- €");
      jLabelSummeP.setText(" " + Integer.toString(kosten.summe) + ".- €");
    }
    //
    if (aufbereitung == "Entcarbonisierung") {
      jLabelAnlageW.setText(kosten.verfahren + "-" + kosten.model);
      jLabelStrassenkapazitaetW.setText(" " + kosten.model);
      jLabelNennweiteW.setText(" " + kosten.rohr);
      jLabelZusatz1W.setText(startframe.Texte.elementAt(280).toString());
      jLabelOption1W.setText(" " + kosten.rohr);
      jLabelOption2W.setText(" " + kosten.rohr); //hier Zumesseinrichtung
      jLabelZusatz2W.setText("");

      //Text ändern
      jLabelOption2.setText(startframe.Texte.elementAt(281).toString());

      //Preise
      //jLabelAnlageP.setText(Integer.toString(kosten.preis));
      jLabelStrassenkapazitaetP.setText(" " + Integer.toString(kosten.preis) +
                                        ".- €");
      jLabelNennweiteP.setText(" " + Integer.toString(kosten.rohrpreis) +
                               ".- €");
      jLabelZusatz1P.setText(" " + Integer.toString(kosten.zusatz1) + ".- €");
      jLabelOption1P.setText(" " + Integer.toString(kosten.zusatz2) + ".- €");
      jLabelOption2P.setText(" " + kosten.option1 + ".- €"); //hier Zumesseinrichtung
      jLabelZusatz2P.setText(" " + Integer.toString(kosten.option2) + ".- €");
      jLabelDosierstationP.setText(" " + Integer.toString(kosten.dosierstation) +
                                   ".- €");
      jLabelSummeP.setText(" " + Integer.toString(kosten.summe) + ".- €");
    }
    //
    if (aufbereitung == "Umkehrosmose m. v. Enthaertung") {
      // eh
      jLabelAnlageW.setText(kosten.verfahren + "-" + kosten.model);
      jLabelStrassenkapazitaetW.setText(" " + kosten.model);
      jLabelNennweiteW.setText(" " + kosten.rohr);
      jLabelZusatz1W.setText(startframe.Texte.elementAt(286).toString());
      jLabelZusatz2.setText(startframe.Texte.elementAt(276).toString());
      jLabelZusatz2W.setText(" " + kosten.rohr);
      jLabelOption1.setText(startframe.Texte.elementAt(277).toString());

      //uo
      jLabelUO.setText(startframe.Texte.elementAt(267).toString());
      jLabelUOW.setText(kosten.uomodel);
      jLabelZusatzName1W.setText(" " + kosten.zusatzName1);
      jLabelOption2W.setText(" " + kosten.uomodel);
      jLabelDosierstation.setText(startframe.Texte.elementAt(271).toString());
      jLabelDosierstationW.setText(startframe.Texte.elementAt(283).toString());

      //Preise
      //jLabelAnlageP.setText(Integer.toString(kosten.preis));
      jLabelStrassenkapazitaetP.setText(" " + Integer.toString(kosten.preis) +
                                        ".- €");
      jLabelNennweiteP.setText(" " + Integer.toString(kosten.rohrpreis) +
                               ".- €");
      jLabelZusatz1P.setText(" " + Integer.toString(kosten.zusatz1) + ".- €"); //Steuerung
      jLabelZusatz2P.setText(" " + Integer.toString(kosten.option1) + ".- €"); //Wasserzähler
      jLabelOption1P.setText(" " + Integer.toString(kosten.dosierstation) +
                             ".- €"); //Dosierstation

      jLabelSummeP.setText(" " + Integer.toString(kosten.summe) + ".- €");

      jLabelUOP.setText(" " + Integer.toString(kosten.uopreis) + ".- €");
      jLabelOption2P.setText(" " + Integer.toString(kosten.option2) + ".- €");
      jLabelDosierstationP.setText(" " + Integer.toString(kosten.zusatz2) +
                                   ".- €");

    }
    //
    if (aufbereitung == "Umkehrosmose o. v. Enthärtung") {
      jLabelAnlageW.setText(kosten.verfahren + "-" + kosten.model);
      jLabelStrassenkapazitaetW.setText(" " + kosten.model);
      //jLabelStrassenkapazitaet.setText("Bauart:"); //Bauart
      jLabelNennweite.setVisible(false);
      jLabelZusatz1W.setText(startframe.Texte.elementAt(283).toString());
      jLabelOption1W.setText(" " + kosten.model);
      jLabelZusatz2.setText(startframe.Texte.elementAt(284).toString());
      jLabelOption2.setVisible(false);

      //Preise
      //jLabelAnlageP.setText(Integer.toString(kosten.preis));
      jLabelStrassenkapazitaetP.setText(" " + Integer.toString(kosten.preis) +
                                        ".- €");
      //jLabelNennweiteP.setText(Integer.toString(kosten.rohrpreis)+".- €") ;
      jLabelZusatz1P.setText(" " + Integer.toString(kosten.zusatz1) + ".- €");
      jLabelZusatz2P.setText(" " + Integer.toString(kosten.zusatz2) + ".- €");
      jLabelOption1P.setText(" " + Integer.toString(kosten.option1) + ".- €");
      jLabelDosierstationP.setText(" " + Integer.toString(kosten.dosierstation) +
                                   ".- €");
      jLabelSummeP.setText(" " + Integer.toString(kosten.summe) + ".- €");
    }
    //
    if (aufbereitung == "Schwefelsäuredosierung") {
      jLabelAnlageW.setText(startframe.Texte.elementAt(285).toString());
      jLabelAnlageP.setText(" " + kosten.preis + ".- €");
      jLabelStrassenkapazitaet.setVisible(false);
      jLabelNennweite.setVisible(false);
      jLabelZusatz1.setVisible(false);
      jLabelOption2.setVisible(false);
      jLabelZusatz2.setVisible(false);
      jLabelOption1.setVisible(false);
      //Preise
      jLabelDosierstationP.setText(" " + Integer.toString(kosten.dosierstation) +
                                   ".- €");
      jLabelSummeP.setText(" " + Integer.toString(kosten.summe) + ".- €");
    }

  }
}
