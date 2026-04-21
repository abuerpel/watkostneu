/**
 * Title:        Watkost<p>
 * Description:  <p>
 * Copyright:    Copyright (c) nils kacirek/H. Kacirek<p>
 * Company:
 * @author nils kacirek/H. Kacirek
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class anlagenframe
    extends JFrame {
  public hauptframe hf;
  BrowserLauncher bl;
  public anlagenframe(hauptframe f) {

    hf = f; //Referenz auf hauptfenster
    setMenuBar(new anlagenmenue(this));
    //größe und Position setzen
    int x = (int)this.getToolkit().getScreenSize().getWidth();
    int y = (int)this.getToolkit().getScreenSize().getHeight();
    this.setSize(x / 2 + 100, y - 50);
    this.setLocation( (y / 4), (0));
    //this.setSize(this.getToolkit().getScreenSize());

    this.addWindowListener(new java.awt.event.WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        fenster_Zu(e);
        dispose();
      }
    });
    this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
        if (e.getX() > 383 && e.getX() < 550 && e.getY() > 130 &&
            e.getY() < 150) {
          cursor();
        }
        else {
          cursorReset();
        }
      }
    });
    this.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getX() > 383 && e.getX() < 550 && e.getY() > 130 &&
            e.getY() < 150) {
          internet();
        }
      }

    });
  }

  public void paint(Graphics g) {
    super.paint(g);
    anlageReport ar = new anlageReport(this);
    ar.setAnalyse(hf.anlkost, hf.anauml, hf.aufbereitung, hf.aufbereitungAnzeige);
    ar.paint(g, 1);

  }

  //Fenster schliessen Routine
  public void fenster_Zu(WindowEvent e) {
    this.setVisible(false);
    this.dispose();
  }

  public anlagenframe() {
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void jbInit() throws Exception {
  }

  void jbdruckenclicked() {
    //paint(this.getGraphics());
    anlageReport anlInfo = new anlageReport(hf);
    anlInfo.setAnalyse(hf.anlkost, hf.anauml, hf.aufbereitung, hf.aufbereitungAnzeige);
    anlInfo.drucken();
  }

  //
  void jbschliessenclicked() {
    dispose();
  }

  //
  void cursor() {
    this.setCursor(HAND_CURSOR);
  }

  //
  void cursorReset() {
    this.setCursor(DEFAULT_CURSOR);
  }

  //
  void internet() {
    try {
      bl.openURL("");
    }
    catch (java.io.IOException e) {
      System.out.print(e);
    }

  }
}
