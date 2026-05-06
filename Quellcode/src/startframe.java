//package watkost3;

import java.awt.*;
import java.util.*;
import java.sql.*;
import java.net.URL;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class startframe
    extends Frame {
  //Applet zum Laden und Abfragen der URl
  static startApplet sA;
  //Anwendung konstruieren
  static hauptframe anwendung;
  static data datenBank;
  public static String homeDir;
  public static String version = "5.0";
  public static Font fntTriline, fntAvantgarde;
  public static java.awt.Image logo;
  static int rowAna = 0; //Datensatz Rohanalysendatei
  public static Vector Texte = new Vector(); //hier werden sämtliche Labelnamen gespeichert
  public static int language;
  public static int sprachIndex;
  public static String prefs;
  public String filepath = new String();
  public URL url;

  public startframe() {
    //startframe startframe = new startframe();
    char bs = 92, fs = 47; //windows backslash durch ffwslash ersetzen
    homeDir = System.getProperty("user.dir").replace(bs, fs); // homePfad

    url = startframe.class.getResource("startframe.class");
    homeDir = url.getPath().trim();
    int l = homeDir.length();
    homeDir = homeDir.substring(0, (l - 16));

    //Schriften für Logoausdruck laden
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Font fonts[] = ge.getAllFonts();
    fntTriline = new Font("Pump TrilineITC-Normal", Font.PLAIN, 48);
    fntAvantgarde = new Font("Arial", Font.PLAIN, 18); //hier noch Avantgarde einfügen

    //preferences auslesen
    //laden
    startframe.sprachIndex = 0; //Voreinstellung Deutsch
    try {

      FileInputStream pwdFile = new FileInputStream(homeDir+"../prefs.ini");
      ObjectInputStream in = new ObjectInputStream(pwdFile);
      prefs = (String) in.readObject();
      sprachIndex =  Integer.parseInt(prefs.substring(19));
      //in.flush();
      in.close();
    }
    catch (java.io.IOException IOE) {
      System.out.println("IO Fehler" + IOE);
    }
    catch (ClassNotFoundException cne) {
      System.out.println("class Fehler" + cne);
    }


    watkoststart();

  }
  static void watkoststart() {

    anwendung = new hauptframe();
    //Größe festlegen
    anwendung.setSize(anwendung.getToolkit().getScreenSize());
    anwendung.setResizable(true);
    anwendung.setTitle("Watkost "+ version);
    datenBank = new data(anwendung);
    anwendung.setVisible(true);
  }

}
