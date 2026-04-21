import java.applet.Applet;

import java.awt.*;
import java.awt.event.MouseEvent;

public class warnframe
    extends Applet {
  boolean isStandalone = false;
  Label labeltext = new Label();
  GridLayout gridLayout1 = new GridLayout();
  Label label2 = new Label();
  Label label3 = new Label();
  Button button1 = new Button();

  //Get a parameter value
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
        (getParameter(key) != null ? getParameter(key) : def);
  }

  //Construct the applet
  public warnframe() {
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
    this.setLayout(gridLayout1);
    this.setBackground(new Color(55, 71, 100));
    this.setComponentOrientation(null);
    gridLayout1.setHgap(4);
    gridLayout1.setRows(4);
    gridLayout1.setVgap(4);
    labeltext.setFont(new java.awt.Font("Dialog", 1, 10));
    labeltext.setForeground(Color.red);
    button1.setBackground(Color.lightGray);
    button1.setForeground(new Color(55, 71, 100));
    button1.setLabel("ok");
    button1.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mouseClicked(MouseEvent e) {
        button1_mouseClicked(e);
      }
    });
    this.add(label2, null);
    this.add(labeltext, null);
    this.add(label3, null);
    this.add(button1, null);
  }

  //Get Applet information
  public String getAppletInfo() {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo() {
    return null;
  }

  void button1_mouseClicked(MouseEvent e) {

  }
}
