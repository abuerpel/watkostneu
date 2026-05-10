/**
 * Title:        Watkost<p>
 * Description:  passwortschutz
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */

import java.util.*;
import java.text.*;
import java.io.*;

public class passwd {

  DateFormat datumformat = DateFormat.getDateInstance(DateFormat.SHORT,
      Locale.GERMAN);
  Date heute = new Date();
  int datumpwd, datumheute;

  public passwd() {
    int Index = 0;
    String passWd;
    //boolean richtig;
    passWd = auslesen();
    if (auswertung(passWd) == false) {
      for (Index = 0; Index <= 3; Index++) {
        if (auswertung(passWd)) {
          einlesen(passWd);
          break;

        }
        else {
          passWd = passwdFalsch();
        }
      }
      if (Index >= 3) {
        dialogframe meinDialog = new dialogframe();
        warndialog passWortF = new warndialog(meinDialog, startframe.Texte.elementAt(158).toString(), true);
        passWortF.setSize(300, 150);
        passWortF.setLocation(300, 200);
        passWortF.meldung(startframe.Texte.elementAt(162).toString());
        passWortF.setVisible(true);
        meinDialog.dispose();
        System.exit( -1);
      }
    }
  }

  //
  public String auslesen() {
    String pwdString = "              ";
    //laden
    try {
      FileInputStream pwdFile = new FileInputStream(startframe.homeDir+"/../prefs.ini");
      ObjectInputStream in = new ObjectInputStream(pwdFile);
      pwdString = (String) in.readObject();
      //in.flush();
      in.close();
    }
    catch (java.io.IOException IOE) {
      System.out.println("IO Fehler" + IOE);
    }
    catch (ClassNotFoundException cne) {
      System.out.println("class Fehler" + cne);
    }
    return pwdString;
  }

  //
  String datumauslesen()
  {
    String pwd = auslesen();
    String datum = (pwd.substring(9, 11))
          + (pwd.substring(11, 13));
    return datum;

  }
  boolean auswertung(String pwd) {
    int kunde1, kunde2, codepwd, codepruef;
    try {
      kunde1 = Integer.parseInt(pwd.substring(6, 7));
      kunde2 = pwd.charAt(7);
      datumpwd = Integer.parseInt(pwd.substring(9, 11))
          + (Integer.parseInt(pwd.substring(11, 13)) * 12);
      codepwd = Integer.parseInt(pwd.substring(14,19));
      startframe.sprachIndex = Integer.parseInt(pwd.substring(19));
      // Monat und 2-stelliges Jahr direkt aus Calendar lesen, damit die Pruefung
      // nicht vom Locale-Datumsformat abhaengt. Im jpackage-EXE liefert
      // DateFormat.SHORT (Locale.GERMAN) "yyyy-MM-dd" statt "dd.MM.yy", weil
      // die de-Locale-Daten im gestrippten Runtime fehlen.
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.setTime(heute);
      int monatHeute = cal.get(java.util.Calendar.MONTH) + 1;
      int jahrHeute = cal.get(java.util.Calendar.YEAR) % 100;
      datumheute = monatHeute + (jahrHeute * 12);
      //codepruef = (kunde1 * datumpwd) + (kunde2 * (datumpwd>>1));

      codepruef = (int) Math.round((kunde1 * datumpwd) + ((kunde2 >> 1) *3) +  (Math.pow((datumpwd -50),2)));
    }
    catch (NumberFormatException e) {
      return false;
    }
    catch (StringIndexOutOfBoundsException e) {
      return false;
    }

    if (datumpwd < datumheute || codepwd != codepruef) {
      return false;
    }
    return true;
  }

  //
  void einlesen(String neupwd) {
    try {
      startframe.prefs = neupwd;
      FileOutputStream file = new FileOutputStream(startframe.homeDir+"/../prefs.ini");
      ObjectOutputStream in = new ObjectOutputStream(file);
      in.writeObject(neupwd);
      in.flush();
      file.close();

    }
    catch (java.io.IOException IOE) {
      System.out.println("IO Fehler" + IOE);
    }

  }

  //
  String passwdFalsch() {
    dialogframe meinDialog = new dialogframe();
    pwdDialog passWort = new pwdDialog(meinDialog, startframe.Texte.elementAt(158).toString(), true);
    passWort.setSize(300, 150);
    passWort.setLocation(300, 200);
    //keineZahl.setLocation((int)this.getX()+this.getWidth()/2 - 150,(int)this.getY()+this.getHeight()/2 - 75);
    passWort.meldung(startframe.Texte.elementAt(163).toString());
    try{
      passWort.setVisible(true);
    }
    catch (java.lang.NullPointerException e){
        System.out.println(e.getMessage());
    }
    String passWd = passWort.getPwd();
    meinDialog.dispose();
    return passWd;
  }

  void ablauf() {
    if (datumpwd == datumheute) {
      dialogframe meinDialog = new dialogframe();
      warndialog2 passWortEnde = new warndialog2(meinDialog, startframe.Texte.elementAt(158).toString(), true);
      passWortEnde.getContentPane().setSize(350, 150);
      passWortEnde.getContentPane().setLocation(275, 200);
      //keineZahl.setLocation((int)this.getX()+this.getWidth()/2 - 150,(int)this.getY()+this.getHeight()/2 - 75);
      passWortEnde.meldung(startframe.Texte.elementAt(164).toString());
      passWortEnde.meldung2(
          startframe.Texte.elementAt(165).toString());
      passWortEnde.getContentPane().setVisible(true);
      meinDialog.dispose();
    }
  }
}
