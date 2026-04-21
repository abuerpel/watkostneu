import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.print.*;

public class SimplePrint
    implements Printable {

  public static Font fnt = new Font("Helvetica", Font.PLAIN, 14);
  public static Font fnt2 = new Font("Helvetica", Font.PLAIN, 12);
  public static Font fnt3 = new Font("Helvetica", Font.BOLD, 8);
  public static Font fnt4 = new Font("Helvetica", Font.PLAIN, 8);
  public static Font fnt5 = new Font("Helvetica", Font.PLAIN, 6);
  public static Font fnt6 = new Font("Helvetica", Font.PLAIN, 10);
  public DateFormat DatumsFormat = DateFormat.getDateInstance(DateFormat.FULL,
      Locale.GERMAN);
  public Date DatumDate = new Date();
  public String Datum = DatumsFormat.format(DatumDate).toString();

  private PageFormat format = new PageFormat();

  public SimplePrint() {

    /*
     GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
     Font fonts[] = ge.getAllFonts();
     int i;
     for (i = 0; i< fonts.length; i++)

     {
      System.out.println(fonts[i].getName());
      String f =fonts[i].getName() ;
      if( fonts[i].getName().equalsIgnoreCase("Pump TrilineITC-Normal"))
      {
       fnt6 = new Font(fonts[i].getName(),Font.PLAIN,40);
      }
     }*/
  }

//
  public int zaehlen(int k, int l) {
    k = k + l;
    return k;
  }

//
  public void drucken() {
    // Get a PrinterJob
    PrinterJob job = PrinterJob.getPrinterJob();
    //SeitenFormat
    //pageFormat initialisieren
    format = job.defaultPage();
    format.setOrientation(PageFormat.PORTRAIT);
    // Set up a book
    Book bk = new Book();
    bk.append(SimplePrint.this, format, 1);
    // Pass the book to the PrinterJob
    job.setPageable(bk);
    //job.setPrintable(SimplePrint.this);
    // Specify the Printable is an instance of SimplePrint
    //job.setPrintable(SimplePrint.this);
    // Put up the dialog box
    // boolean tPrint = true;String tOSName = System.getProperty("os.name");
    //if (!tOSName.equals("Windows 95"))    tPrint = job.printDialog();
    if (job.printDialog()) {
      //Trick
      format.setOrientation(PageFormat.PORTRAIT);
      // Print the job if the user didn't cancel printing
      try {
        job.print();
      }
      catch (Exception e) {
          System.out.print(e);
      /* handle exception */}
    }

  }

//

  public int print(Graphics g, PageFormat pf, int pageIndex) throws
      PrinterException {
    // pageIndex 0 to 4 corresponds to page numbers 1 to 5.
    if (pageIndex >= 1) {
      return Printable.NO_SUCH_PAGE;
    }
    //Graphics2D g2 = (Graphics2D)g;
    paint(g, pageIndex);
    return Printable.PAGE_EXISTS;
  }

  public void paint(Graphics g, int pageIndex)

  {
    g.setFont(fnt);
    g.setColor(Color.green);
    g.drawString("Page " + (pageIndex + 1), 100, 100);
  }

  //
  public String zahltostring(double zahl) {
    String zeichen;
    if (zahl > 0.0 || zahl < -0.009) {
      zeichen = ( (Double.toString(zahl)).substring(0, 3));
    }
    else {
      zeichen = "0.0";
    }
    return zeichen;
  }

  public String zahltostring(String zahl) {
    String zeichen;
    //Überladen der Funktion falls ein String reingegeben wird

    try {
      zeichen = zahl.substring(0, 3);
    }

    catch (StringIndexOutOfBoundsException e) {
      zeichen = zahl;
    }
    return zeichen;
  }

  //
  //
  public String zahltostring(int zahl) {
    String zeichen;
    try {
      zeichen = ( (Integer.toString(zahl)).substring(0, 3));
    }
    catch (StringIndexOutOfBoundsException e) {
      zeichen = Integer.toString(zahl);
    }

    return zeichen;
  }

  //
  public String zahltostring(double zahl, int i) {
    String zeichen;
    if (zahl >= 0.001 || zahl <= -0.001) {
      try {
        zeichen = ( (Double.toString(zahl)).substring(0, i));
      }
      catch (StringIndexOutOfBoundsException e) {
        zeichen = (Double.toString(zahl));
      }
    }
    else {
      zeichen = "0.000";
    }
    return zeichen;
  }

  public String zahltostring(String zahl, int i) {
    String zeichen;
    //Überladen der Funktion falls ein String reingegeben wird
    try {
      zeichen = zahl.substring(0, i);
    }

    catch (StringIndexOutOfBoundsException e) {
      zeichen = zahl;
    }

    return zeichen;
  }

  public String zahltostring(int zahl, int i) {
    String zeichen;
    //Überladen der Funktion falls ein String reingegeben wird
    try {
      zeichen = Integer.toString(zahl).substring(0, i);
    }
    catch (StringIndexOutOfBoundsException e) {
      zeichen = Integer.toString(zahl);
    }
    catch (NumberFormatException e) {
      System.out.print(e);
      zeichen = "null";
    }
    return zeichen;
  }

}
