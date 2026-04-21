
//Title:       Watkost
//Version:     1.0
//Copyright:   Copyright (c) nils kacirek/H. Kacirek
//Author:      nils kacirek/H. Kacirek
//Company:     bitwerker
//Description:
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.net.URL;
public class startApplet extends JApplet
{
  boolean isStandalone = false;

  //Get a parameter value
  public String getParameter(String key, String def)
  {
    return isStandalone ? System.getProperty(key, def) :
      (getParameter(key) != null ? getParameter(key) : def);
  }

  //Construct the applet
  public startApplet()
  {
   /* URL url = getCodeBase();
   startframe.homeDir = url.toString();
   startframe.logo = getImage(url,"logo.bmp");*/
  }

  //Initialize the applet
  public void init()
  {
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  //Component initialization
  private void jbInit() throws Exception
  {
    this.setSize(new Dimension(400,300));

  }

  //Start the applet
  public void start()
  {

  }

  //Stop the applet
  public void stop()
  {
  }

  //Destroy the applet
  public void destroy()
  {
  }

  //Get Applet information
  public String getAppletInfo()
  {
    return "Applet Information";
  }

  //Get parameter info
  public String[][] getParameterInfo()
  {
    return null;
  }

  //Main method
  public static void main(String[] args)
  {
    startApplet applet = new startApplet();
    applet.isStandalone = true;
    JFrame frame = new JFrame();
    //EXIT_ON_CLOSE == 3
    frame.setDefaultCloseOperation(3);
    frame.setTitle("Applet Frame");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
    frame.setVisible(true);
  }

  //static initializer for setting look & feel
  static
  {
    try
    {
      //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      //UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    }
    catch(Exception e)
    {
    }
  }
}
