/**
 * Title:        kosten
 * Description:  klasse zum speichern der betriebskostengrundlagen
 * Copyright:    Copyright (c) nils kacirek
 * Company:      wat<p>
 * @author nils kacirek
 * @version 1.0
 */


public class kosten
    implements java.io.Serializable {
  double stadtWasser, abWasser, regenWasser, energie, leistung, leistung2,
      auslastung, dosierMittel, dosierMenge;
  double salzTabletten, salzSaeure, schwefelSaeure, ro, roMenge;
  //neu 220106
  String dosierMittelName;
  public kosten() {
  }
}
