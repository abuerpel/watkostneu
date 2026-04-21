 import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class infodialog
    extends Dialog {
  JLabel labeltext = new JLabel();
  JPanel panel1 = new JPanel();
  BorderLayout gridLayout1 = new BorderLayout();
  GridLayout GridLayout2 = new GridLayout();
  JLabel label3 = new JLabel();
  JButton button1 = new JButton();
  Image Bild;
  String version = startframe.Texte.elementAt(157).toString()+startframe.version;
  String pwdDate;

  public infodialog(Frame AufrufVonFenster, String text, boolean modal) {
    //
    super(AufrufVonFenster, "Über Watkost", true);
    this.addWindowListener(new fensterZu());
    passwd PaWd = new passwd();
    pwdDate = PaWd.datumauslesen();
    GridLayout2.setRows(1);
    GridLayout2.setColumns(3);
    panel1.setLayout(GridLayout2);
    this.setBackground(new Color(55, 71, 100));
   // Bild = getToolkit().getImage(startframe.homeDir + "/../bin/splash.gif");
    //getToolkit().prepareImage(Bild,this);
    //this.setComponentOrientation(null);
    labeltext.setFont(new java.awt.Font("Dialog", 1, 10));
    labeltext.setForeground(Color.red);
    button1.setBackground(Color.lightGray);
    button1.setForeground(new Color(0, 0, 128));
    button1.setText("ok");
    button1.addMouseListener(new java.awt.event.MouseAdapter() {

      public void mouseClicked(MouseEvent e) {
        button1_mouseClicked(e);
      }
    });
    //Graphics g = getGraphics();
    //paint(g);
    panel1.add(labeltext);
    //panel1.add(button1);
    //panel1.add(new Label(""));
    this.add(panel1, BorderLayout.SOUTH);
  }

  void button1_mouseClicked(MouseEvent e) {
    this.dispose();
  }

  public void meldung(String Meldung) {
    this.labeltext.setText(Meldung);
  }

  public void paint(Graphics g) {
    Font infoschrift = new Font("Dialog", Font.BOLD, 32);
    Font copyrights = new Font("Dialog", Font.PLAIN, 16);
    Font urlFont = new Font("Dialog", Font.PLAIN, 12);

    //Bild = getToolkit().getImage("c:/javawork/Opener.gif");
    //g.drawImage(Bild,0,10,this.getWidth(),this.getHeight(),this);
    g.setColor(new Color(72, 157, 255));
    //g.fillOval(20, 35, 360, 220);
    g.setColor(Color.darkGray);
    g.setFont(startframe.fntTriline);
    g.setFont(copyrights);
    g.setColor(Color.lightGray);
    g.drawString(version, 65, 120);
    g.setFont(copyrights);
    g.setColor(Color.lightGray);
    g.drawString(startframe.Texte.elementAt(176).toString()+pwdDate,65,140);
    g.setFont(urlFont);
    g.drawString("© 1999-2013 Dr. Hartmut Kacirek, Nils Kacirek",
                 65, 170);
    g.drawString("",
                 65, 190);
    g.setColor(Color.red);
    g.setFont(urlFont);
    g.drawString("", 150, 230);
  }
}
