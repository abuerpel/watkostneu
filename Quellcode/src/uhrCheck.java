/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */

import java.util.*;
import java.text.*;
import java.io.*;

public class uhrCheck {

  DateFormat datumformat2 = DateFormat.getDateInstance(DateFormat.SHORT,
      Locale.GERMAN);
  Date heute2 = new Date();
  public uhrCheck() {
    boolean test = true;
    test = testen(auslesen());
    if (test) {
      einlesen(heute2.getTime());
    }
    else {
      abbruch();
    }

  }

  long auslesen() {
    long dateTest;
    try {
      FileInputStream pwdFile = new FileInputStream("c:/Windows/wtkdate.ini");
      DataInputStream in = new DataInputStream(pwdFile);
      dateTest = in.readLong();
      //in.flush();
      in.close();
    }
    catch (java.io.IOException IOE) {
      //System.out.println("IO Fehler"+IOE);
      return heute2.getTime();
    }

    return dateTest;
  }

  boolean testen(long testDatum) {
    if (testDatum > heute2.getTime()) {
      return false;
    }
    return true;
  }

  void einlesen(long neuDate) {
    try {
      FileOutputStream file = new FileOutputStream("c:/Windows/wtkdate.ini");
      DataOutputStream in = new DataOutputStream(file);
      in.writeLong(neuDate);
      in.flush();
      file.close();

    }
    catch (java.io.IOException IOE) {
      System.out.println("IO Fehler" + IOE);
    }

  }

  void abbruch() {
    dialogframe meinDialog = new dialogframe();
    warndialog2 passWort = new warndialog2(meinDialog, "Achtung", true);
    passWort.setSize(300, 150);
    passWort.setLocation(300, 200);
    //keineZahl.setLocation((int)this.getX()+this.getWidth()/2 - 150,(int)this.getY()+this.getHeight()/2 - 75);
    passWort.meldung("Sie haben das Datum zurückgestellt.");
    passWort.meldung2("Das Programm wird abgebrochen");
    passWort.setVisible(true);
    meinDialog.dispose();
    System.exit( -1);
  }
}