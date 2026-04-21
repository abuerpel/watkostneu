/**
 * <p>Überschrift: Watkost </p>
 *
 * <p>Beschreibung: </p>
 *
 * <p>Copyright: Copyright (c) 2002-2007</p>
 *
 * <p>Organisation: WAT GmbH</p>
 *
 * @author H. Kacirek, N. Kacirek
 * @version 3.04
 */

import java.awt.*;
import java.awt.event.WindowEvent;

public class warndialogAutoClose extends warndialog {

    public warndialogAutoClose(Frame AufrufVonFenster, String text, boolean modal)

    {
        super(AufrufVonFenster, text, true);
        this.button1.setVisible(false);
        this.addWindowFocusListener(new java.awt.event.WindowAdapter(){

            public void windowGainedFocus(WindowEvent e) {
                long ct = java.lang.System.currentTimeMillis();
                long ctl = ct + 1500;
                while (ct < ctl) {
                    ct = java.lang.System.currentTimeMillis();

                }
                ;
                dispose();
            }
        });

    }

}
