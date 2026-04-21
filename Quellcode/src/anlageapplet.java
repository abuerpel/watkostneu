import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;

public class anlageapplet
    extends JApplet {
  boolean isStandalone = false;

  //Get a parameter value
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
        (getParameter(key) != null ? getParameter(key) : def);
  }

  //Construct the applet
  public anlageapplet() {
  }

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
    this.setSize(new Dimension(400, 300));
  }

  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }

  //static initializer for setting look & feel
  static {
    try {
      //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch (Exception e) {
    }
  }

  public void paint(Graphics g) {
    anlageReport ar = new anlageReport();
    ar.paint(g, 1);
  }
}
