//package watkost;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

//import hauptframe;

public class watkostapplet
    extends Applet {
  //Anwendung kontruieren
  hauptframe anwendung;

  //Initialize the applet
  public void init() {
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception {
    anwendung = new hauptframe();
    anwendung.setSize(800, 550);
    anwendung.setResizable(true);
    anwendung.setTitle("Watkost 2.7 le");
  }

  public void start() {
    anwendung.setVisible(true);
  }

  public void stop() {
    anwendung.dispose();
  }
}
