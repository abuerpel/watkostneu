/**
 * Title:        Watkost<p>
 * Description:  classe zum laden und handeln der Tabellen
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:      bitwerker<p>
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */
import javax.swing.UIManager;
import java.sql.Connection;
import java.sql.*;
import java.awt.*;
import java.util.Properties;
import java.util.*;
import org.hsql.*;
import org.hsqldb.*;
public class data {
  public data() {
    try {
      jbInit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  //Class.forName(org.hsql.jdbcDriver);
  private String treiber = "org.hsqldb.jdbcDriver";
  private String url = "jdbc:HypersonicSQL:watkost3db";
  private String url2 = "jdbc:hsqldb:file:" + startframe.homeDir +
      "/../db/watkost3db";
  private String query = "SELECT * FROM anaroh Where ID = 0";
  private Connection verbindung;
  private ResultSet rs;
  private Statement st;
  private Statement stAnl;
  private ResultSet rsAnl;
  private PreparedStatement ps;
  private ResultSetMetaData daten;
  public String datenSatzRA = "0";
  int rowCount;
  public data(hauptframe h) {
    //Data Connection
    Properties systemProperties = System.getProperties();
    systemProperties.put("jdbc.drivers", treiber);

    // Set up database connection
    try {
      Class.forName(treiber);
      verbindung = DriverManager.getConnection(url2, "sa", "");
    }
    catch (java.lang.ClassNotFoundException e) {
      System.out.print("Verbindung fehlgeschlagen ->  ");
      System.out.print(e.getMessage());
    }

    catch (java.sql.SQLException e) {
      System.out.print("Verbindung fehlgeschlagen2");
      System.out.print(e.getMessage());
      dialogframe meinDialog = new dialogframe();
      warndialog2 keineVerbindung = new warndialog2(meinDialog, (startframe.Texte.elementAt(158).toString()), true);
      keineVerbindung.setSize(300, 150);
      keineVerbindung.setLocation(h.positionX(300), h.positionY(150));
      keineVerbindung.meldung(
          (startframe.Texte.elementAt(179).toString()));
      keineVerbindung.meldung2
          ("");
      keineVerbindung.setVisible(true);
    }

    //get tableinformation and data
    try {
      st = verbindung.createStatement();
      stAnl = verbindung.createStatement();
      rs = st.executeQuery("SELECT * FROM anaroh WHERE ID =" + 1);
      rs.next();

    }
    catch (java.lang.NullPointerException e) {
      System.out.print(e.getMessage());
    }
    catch (java.sql.SQLException e) {
      System.out.print("SQL Fehler");
      System.out.print(e.getErrorCode());
      System.out.print(e.getSQLState());
      System.out.print(e.getMessage());
    }
  }

//
  public rohanalyse vor() {
    ResultSet rsbuffer = rs;
    try {
      int i;
      try {
        i = rs.getInt(1) + 1;


      }
      catch (java.lang.NullPointerException e) {
        i = 1;
      }

      rs = st.executeQuery("SELECT * FROM anaroh WHERE ID =" + i);
      boolean rowValid = rs.next();
      if (rowValid == false) {
        i--;
        rs = st.executeQuery("SELECT * FROM anaroh WHERE ID =" + i);
        rs.next();
      }

    }
    catch (java.lang.NullPointerException e) {
      System.out.print(e.getMessage());
      System.out.print("Tabellenende");
    }
    catch (java.sql.SQLException e) {
      System.out.print(e.getMessage());
    }
    return getData();
  }

//
  rohanalyse rueck() {
    ResultSet rsbuffer = rs;
    try {

      int i = rs.getInt(1) - 1;
      if (i == 0) {
        i = 1; //wenn Tabellenanfang dann erster Datensatz
      }
      rs = st.executeQuery("SELECT * FROM anaroh WHERE ID =" + i);
      rs.next();
    }
    catch (java.lang.NullPointerException e) {
      System.out.print(e.getMessage());
      System.out.print("Tabellenanfang");
      rs = rsbuffer;
      try {
        rs.next();
      }
      catch (java.sql.SQLException f) {}
    }
    catch (java.sql.SQLException e) {
      System.out.print(e.getMessage());
    }
    return getData();
  }

  public rohanalyse getData() {
    rohanalyse ra = new rohanalyse();
    try {
      datenSatzRA = String.valueOf(rs.getInt(1));
      ra.analysenNummer = rs.getString(2);
      ra.kunde = rs.getString(3);
      ra.stadt = rs.getString(4);
      ra.plz = rs.getString(5);
      ra.projekt = rs.getString(6);
      ra.bearbeiter = rs.getString(7);
      ra.ca = rs.getDouble(8);
      ra.mg = rs.getDouble(9);
      ra.ks = rs.getDouble(10);
      ra.cl = rs.getDouble(11);
      ra.so4 = rs.getDouble(12);
      ra.no3 = rs.getDouble(13);
      ra.pHtE = rs.getDouble(14);
      ra.tE = rs.getDouble(15);
      ra.lF = rs.getDouble(16);
    }
    catch (java.sql.SQLException e) {
      System.out.print(e.getMessage());
    }
    catch (java.lang.NullPointerException e) {
      System.out.print(e.getMessage());
    }
    return ra;
  }

//
  public rohanalyse loeschen() {
    try {
      int row = rs.getInt(1);
      rs = st.executeQuery("DELETE  FROM anaroh WHERE ID =" + row);
      reindex(row);
      rs = st.executeQuery("SELECT * FROM anaroh WHERE ID = " + (row - 1)); //auf vorhergehenden Datensatz springen
      if (row == 1) {
        rs = st.executeQuery("SELECT * FROM anaroh WHERE ID = 1"); //wenn erster Datensatz gel�scht, auf ersten Datensatz zeigen
      }
      rs.next();
      row = rs.getInt(1);
    }
    catch (java.sql.SQLException e) {
      System.out.print(e.getMessage());
      //return false;
    }

    //return true;
    return getData();
  }

//
  public boolean insert(rohanalyse ra) {
    for (int i = 1; i < 100; i++) { //begrenzt die Tabelle auf hundert Datens�tze, f�gt Datensatz an erster g�ltiger Position ein
      try {
        rs = st.executeQuery("INSERT INTO anaroh VALUES (" + i + ",'" + ra.analysenNummer +
                   "','" + ra.kunde + "',' ',' ','" + ra.projekt + "','" +
                   ra.bearbeiter + "'" +
                   "," + ra.ca + "," + ra.mg + "," + ra.ks + "," + ra.cl + "," +
                   ra.so4 + "," + ra.no3 + "," + ra.pHtE + "," + ra.tE + "," +
                   ra.lF + ")");
        rs = st.executeQuery("SELECT * FROM anaroh WHERE ID =" + i);
        rs.next();
        return true;
      }
      catch (java.sql.SQLException e) {
        System.out.print(e.getMessage());
      }
    }
    return false;
  }

  public boolean frisch() {

    return true;
  }

  public void reindex(int row) {
    rohanalyse ra;

    for (int j = row + 1; j < 1000; j++) {

      try {
        rs = st.executeQuery("SELECT * FROM anaroh WHERE ID =" + j); //datensatz zum auslesen hole
        rs.next();
        ra = getData(); //daten aus aktuellem datensatz auslesen
        if (ra.analysenNummer == null) {
          break;
        }
        st.execute("INSERT INTO anaroh VALUES (" + (j - 1) + ",'" +
                   ra.analysenNummer + "','" + ra.kunde + "',' ',' ','" +
                   ra.projekt + "','" + ra.bearbeiter + "'" +
                   "," + ra.ca + "," + ra.mg + "," + ra.ks + "," + ra.cl + "," +
                   ra.so4 + "," + ra.no3 + "," + ra.pHtE + "," + ra.tE + "," +
                   ra.lF + ")"); //Insert an vorher gel�schter stelle
        st.execute("DELETE  FROM anaroh WHERE ID =" + j);
      }
      catch (java.lang.NullPointerException e) {
        System.out.print("Tabellenende");
        break;
      }
      catch (java.sql.SQLException e) {
        System.out.print(e.getMessage());
        break;
      }
    } //Ende der for Schleife
  }

  public int merken() { //wenn Dialogfenster geschlossen wird, DatenSatzNummer zur�ckgeben
    int row;
    try {
      row = rs.getInt(1);
    }
    catch (java.sql.SQLException e) {
      row = 0;
    }
    catch (java.lang.NullPointerException e2) {
      row = 0;
    }
    return row;
  }

  public void setzen(int row) { // bei aufruf Datensatzzeiger setzen
    if (row > 0) {
      try {
        rs = st.executeQuery("SELECT * FROM anaroh WHERE ID =" + row);
      }
      catch (java.sql.SQLException e) {
        //
      }
      try {
        rs.next();
      }
      catch (java.sql.SQLException e) {
        System.out.print(e.getMessage());
      }
    }
  }

  public ResultSet getAnlData(String abfrage) {
    try {
      rsAnl = stAnl.executeQuery(abfrage);
      rsAnl.next();
    }
    catch (java.sql.SQLException e) {
      System.out.print(e.getMessage());
    }
    catch (java.lang.NullPointerException e) {
      //
    }
    return rsAnl;
  }

  private void jbInit() throws Exception {
  }

}
