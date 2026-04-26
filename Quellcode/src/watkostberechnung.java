/**
 * Title:        Watkostberechnungen
 * Description:  algorythmen zur Berechning
 * Copyright:    Copyright (c) H. Kacirek/Nils Kacirek<p>
 * Company:      wat gesellschaft fuer wasseraufbereitung und chemietechnik mbH
 *               werkstrasse 2b, 22844 Norderstedt, Germany
 *               ++49 40 526 84 00, info@wat-nord.de
 * @author       Dr. H. Kacirek
 * @version 1.0
 */
//import watklassen.*;


public class watkostberechnung {
  //Variablen deklarieren
  ////deklarieren der Speichervariablen für Anarech
  static double cT0 = 298.16;
  static double cTK = 273.16; //Temperaturnullpunkt
  static double dVerschnitt; //Verschnitt
  static double dEF; //maximaler Eindickungsfaktor
  static double dpHE, dLf; //pH-Wert, Leitfähigkeit.
  static double dCa, dMg, dKs43, dCl, dSo4, dNo3, dNa; //Analysenwerte
  static double dCaM, dMgM, dKs43M, dClM, dNo3M, dSo4M; //molare Größen
  static double dSuA, dSuK, dNaM, dI, dNaNo3M, dCo2M;
  static double dElfCa, dElfMg, dElfNa, dElfKs, dElfCl, dElfSo, dElfNo, dElfCo3;
  static double dElfNaNo, dElfNaNo3M, dLfBer, dLfDiff;
  static double dE; //Eindickungsfaktor
  static double dLGF1, dLGKCE, dLGK1E, dLGK2E, dLGKWE;
  static double dLGKCKT, dLGK1KT, dLGK2KT, dLGKWKT;
  static double dLGKCW, dLGK1W, dLGK2W, dLGKWW;
  static double dL2E;
  static double dTK, dTKKT, dTKW, dTE, dTKT, dTW, dTKE; //Temperaturen
  static double dpHGlE, dSiE;
  static double dCaCo3, dCo3K, dCo2, dCo3, dHCo3;
  static double dlgCo2, dlgC, dCo2KT, dpHKTNV, dlgCo3, dCo3NV, dHCo3NV;
  static double dL2KT, dpHGlKT, dSiKT, dL2W, dpHGlW, dSiW;
  static double dlgK4, dlgK4K, dlgK5, dlgK5K, dA, dB, dCaSo4, dCaMK, dSo4K,
      dLfBerk;
  static double dClMax, dSoMax, dSiMax, dRoMax; //Grenzwerte Kuehlturm
  static double dDhMin, dDhMax, dLfMax, dAlkMin, dTLW; //Grenzwerte Luftwaescher
  //


  //Auslesen der Rohwasseranalyse
  static void auslesen(rohanalyse anaAus, grenzwerte grenzw) {
    //anaroh.analysenNummer
    dTE = anaAus.tE;
    //dEF = anaAus.
    dLf = anaAus.lF;
    dCa = anaAus.ca;
    dMg = anaAus.mg;
    dNa = anaAus.na;
    dKs43 = anaAus.ks;
    dCl = anaAus.cl;
    dSo4 = anaAus.so4;
    dNo3 = anaAus.no3;
    dLfBer = anaAus.lFBer;
    //Grenzwerte auslesen
    dEF = grenzw.EF;
    dSiMax = grenzw.siMax;
    dClMax = grenzw.clMax;
    dSoMax = grenzw.so4Max;
    dRoMax = grenzw.roMax;
    dDhMin = grenzw.dhMin / 5.6;
    dDhMax = grenzw.dhMax / 5.6;
    dAlkMin = grenzw.alkMin;
    dTW = grenzw.tW;
    dTKT = grenzw.tKT;
    dTLW = grenzw.tLW;
    dLfMax = grenzw.lF;
    dE = 1; //AnfangsE

  }

  //einlesen der Ergebnisse in umlaufwasseranalyse
  static umlaufanalyse einlesen() { //in Variable einlesen
    umlaufanalyse umlaufAus = new umlaufanalyse();
    umlaufAus.verSchnitt = dVerschnitt;
    if (dVerschnitt > 1.00) {
      umlaufAus.verSchnitt = 1.00;
    } //Korrektur
    umlaufAus.eindickung = dE;
    umlaufAus.tKT = dTKT;
    umlaufAus.tW = dTW;
    umlaufAus.tLW = dTLW;
    umlaufAus.lF = dLfBerk;
    umlaufAus.ca = dCa;
    umlaufAus.mg = dMg;
    umlaufAus.na = dNa;
    umlaufAus.ks = dKs43;
    umlaufAus.cl = dCl;
    umlaufAus.so4 = dSo4;
    umlaufAus.no3 = dNo3;
    umlaufAus.pHggWtE = dE;
    umlaufAus.pHKTnV = dpHKTNV;
    umlaufAus.pHTKT = dpHGlKT;
    umlaufAus.siTKT = dSiKT;
    umlaufAus.pHggWW = dpHGlW;
    umlaufAus.sIW = dSiW;
    umlaufAus.salz = dSuA * 1000;
    umlaufAus.suK = dSuK;
    umlaufAus.ionen = dI * 1000;
    umlaufAus.h2co3 = dCo2KT * 44000; //in mg
    umlaufAus.hco3 = dHCo3NV * 61000; // in mg
    umlaufAus.co3 = dCo3NV * 60000; //in mg

    return umlaufAus;

  }

  //threshold
  //****************************************************************
   //**							       *****						**
    //**THRESHHOLD					      ******						**
     //**							      ******							**
      //****************************************************************
       static boolean threchL(rohanalyse anaAus, grenzwerte grenzw,String aufbereitung) {
         //rohanalyse aus Klasseauslesen
         auslesen(anaAus, grenzw);
         double y, z; //Zählervariable
         //default Werte
         dEF = 5;
         dSiW = 0.00;
         //Temperatur einsetzen um Funktionalitaet der dbase Algorythmen zu gewaehrleisten,
         dTKT = dTLW;
         dTW = dTKT;
         z = 1;
         dLGF1 = 0;

         //Pr?fen, ob eine Eindickug ?berhaupt m”glich ist, wenn nicht, abbbrechen
         if (dLf > dLfMax) {
           warnfenster(startframe.Texte.elementAt(174).toString() + aufbereitung + startframe.Texte.elementAt(171).toString()); //warnung
           return false;
         }
         if ( (dCa / 40.08 + dMg / 24.3) > dDhMax) {
           warnfenster(startframe.Texte.elementAt(174).toString() + aufbereitung + startframe.Texte.elementAt(173).toString());
           return false;
         }
         //Beginn Schleife
         while ( (dSiW < dSiMax) && ( (dCa / 40.08 + dMg / 24.3) < dDhMax) &&
                (dLfBer < dLfMax && dE < dEF)) {
           y = z;
           z = z + 0.01;
           dVerschnitt = 1;
           dE = dE * z / y;
           dCa = dCa * z / y;
           dMg = dMg * z / y;
           dNa = dNa * z / y;
           dKs43 = dKs43 * z / y;
           dCl = dCl * z / y;
           dNo3 = dNo3 * z / y;
           dSo4 = dSo4 * z / y;
           dLfBer = dLfBer * z / y;

           //Berechnung der für die weitere Berechnung benötigten Größen
           //Berechnung der molaren Größen
           dCaM = dCa / (40.08 * 1000);
           dMgM = dMg / (24.3 * 1000);
           dKs43M = dKs43 / 1000;
           dNaM = dNa / 23008;
           dClM = dCl / (35.45 * 1000);
           dNo3M = dNo3 / (62 * 1000);
           dSo4M = dSo4 / (96 * 1000);
           dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);

           dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));

           temperaturkorrektur(); //Temperaturkorrektur in Kelvin
           konstantekorrektur(); //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste
           //Wandtemperatur
           kohlensaeure(); //Berechnung Kohlensäure im K?hlturm nach Verrieselung
           phundkarbonatkonz(); //Berechnung pH-Wert und Karbonatkonz. nach Kohlens„ureverrieselung
           sikt(); //Berechnung SI bei K?hlturmtemp.
           siw(); //Berechnung SI bei Wandtemperatur
         } //Ende der while Schleife

         dho(); //erneute Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)
         ionensumme(); //Berechnung Summe Anionen/Kationen
         calciumkorrektur1(); //1. Calciumsulfatkorrektur, gilt f?r Speisewasser und Umlaufwasser
         calciumkorrektur2(); //2. Calciumcarbonatkorrektur, gilt nur f?r Umlaufwasser nach Verrieselun
         return true;
       }

  //
  static boolean threch(rohanalyse anaAus, grenzwerte grenzw,String aufbereitung) {
    //rohanalyse aus Klasseauslesen
    auslesen(anaAus, grenzw);
    double y, z; //Zählervariable
    dSiW = 0.00;
    z = 1;
    dE = 1;
    while (dSiW < dSiMax && dCl < dClMax && dSo4 < dSoMax && dE < dEF) {
      y = z;
      z = z + 0.01;
      dVerschnitt = 1;
      dE = dE * z / y;
      dCa = dCa * z / y;
      dMg = dMg * z / y;
      dNa = dNa * z / y;
      dKs43 = dKs43 * z / y;
      dCl = dCl * z / y;
      dNo3 = dNo3 * z / y;
      dSo4 = dSo4 * z / y;

      //Berechnung der für die weitere Berechnung benötigten Größen
      //Berechnung der molaren Größen
      dCaM = dCa / (40.08 * 1000);
      dMgM = dMg / (24.3 * 1000);
      dKs43M = dKs43 / 1000;
      dNaM = dNa / 23008;
      dClM = dCl / (35.45 * 1000);
      dNo3M = dNo3 / (62 * 1000);
      dSo4M = dSo4 / (96 * 1000);
      dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);
      dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));

      temperaturkorrektur(); //Temperaturkorrektur in Kelvin
      konstantekorrektur(); //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste
      //Wandtemperatur
      kohlensaeure(); //Berechnung Kohlensäure im K?hlturm nach Verrieselung
      phundkarbonatkonz(); //Berechnung pH-Wert und Karbonatkonz. nach Kohlens„ureverrieselung
      sikt(); //Berechnung SI bei K?hlturmtemp.
      siw(); //Berechnung SI bei Wandtemperatur
    } //Ende der while Schleife

    dho(); //erneute Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)
    //Korrektur nach Dbye-Hückel-Onsager
    ionensumme(); //Berechnung Summe Anionen/Kationen
    calciumkorrektur1(); //1. Calciumsulfatkorrektur, gilt f?r Speisewasser und
    calciumkorrektur2(); //2. Calciumcarbonatkorrektur, gilt nur f?r Umlaufwasser nach Verrieselung
    // f?r anaroh nicht ausf?hren
    return true;
  }

  //****************************************************************
   //**															**
    //**ENTHÄRTUNG													**
     //**															**
      //****************************************************************

       //enthaertung
       static boolean ehrechL(rohanalyse anaAus, grenzwerte grenzw,String aufbereitung) {

         //rohanalyse aus Klasseauslesen
         auslesen(anaAus, grenzw);
         double dCaNEH, dMgNEH, dGH, y, z;
         dLGF1 = 0;
         //maximale Eindickung
           dEF = 5;
         //immer Resthaerte vorhanden
         if (dDhMin < 0.1) {
           dDhMin = 0.1;
         }
         //Temperatur einsetzen um Funktionalitaet der dbase Algorythmen zu gewaehrleisten,
         dTKT = dTLW;
         dTW = dTKT;
         //pr?fen, ob Enth„rtung ?berhaupt sinnvoll und Verschneidung berechnen
         dGH = dCa / 40.08 + dMg / 24.3;
         dVerschnitt = dDhMin / dGH;
         if (dGH > dDhMin) {
           dCaNEH = dCa * dVerschnitt;
           dMgNEH = dMg * dVerschnitt;
           dCa = dCaNEH;
           dMg = dMgNEH;
         }
         else {
           warnfenster(startframe.Texte.elementAt(170).toString()); //warnung
           dVerschnitt = 1.0;
           return true;
         }
         //Pr?fen, ob eine Eindickug ?berhaupt m”glich ist, wenn nicht, abbbrechen
         if (dLf > dLfMax) {
           warnfenster(startframe.Texte.elementAt(174).toString() + aufbereitung + startframe.Texte.elementAt(171).toString()); //warnung
           return false;
         }
         //Berechnung der molaren Größen
         dCaM = dCa / (40.08 * 1000);
         dMgM = dMg / (24.3 * 1000);
         dKs43M = dKs43 / 1000;
         dClM = dCl / (35.45 * 1000);
         dNo3M = dNo3 / (62 * 1000);
         dSo4M = dSo4 / (96 * 1000);
         dSuA = dKs43M + dClM + 2 * dSo4M + dNo3M;
         dSuK = 2 * dCaM + 2 * dMgM;
         dNaM = dSuA - dSuK;
         dNa = dNaM * 23000;
         dSuK = dSuK + dNaM;
         dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);

         dho(); //Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)
         //Korrektur nach Dbye-Hückel-Onsager

         dSiW = 0.00;
         z = 1;
         dE = 1;
         while (dSiW < dSiMax && ( (dCaM + dMgM) * 1000) < dDhMax &&
                dLfBer < dLfMax && dE < dEF ) {
           y = z;
           z = z + 0.01;
           dE = dE * z / y;
           dCa = dCa * z / y;
           dMg = dMg * z / y;
           dNa = dNa * z / y;
           dKs43 = dKs43 * z / y;
           dCl = dCl * z / y;
           dNo3 = dNo3 * z / y;
           dSo4 = dSo4 * z / y;
           dLfBer = dLfBer * z / y;
           //Berechnung der für die weitere Berechnung benötigten Größen
           //Berechnung der molaren Größen
           dCaM = dCa / (40.08 * 1000);
           dMgM = dMg / (24.3 * 1000);
           dNaM = dNa / 23008;
           dKs43M = dKs43 / 1000;
           dClM = dCl / (35.45 * 1000);
           dNo3M = dNo3 / (62 * 1000);
           dSo4M = dSo4 / (96 * 1000);
           dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);
           dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));

           temperaturkorrektur(); //Temperaturkorrektur in Kelvin
           konstantekorrektur(); //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste
           //Wandtemperatur
           kohlensaeure(); //Berechnung Kohlensäure im K?hlturm nach Verrieselung
           phundkarbonatkonz(); //Berechnung pH-Wert und Karbonatkonz. nach Kohlens„ureverrieselung
           sikt(); //Berechnung SI bei K?hlturmtemp.
           siw(); //Berechnung SI bei Wandtemperatur
         } //Ende der while Schleife

         dho(); //erneute Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)
         //Korrektur nach Dbye-Hückel-Ohrensauger
         ionensumme(); //Berechnung Summe Anionen/Kationen
         calciumkorrektur1(); //1. Calciumsulfatkorrektur, gilt f?r Speisewasser und Umlaufwasser
         calciumkorrektur2(); //2. Calciumcarbonatkorrektur, gilt nur f?r Umlaufwasser nach Verrieselung
         return true;
       }

  //
  static boolean ehrech(rohanalyse anaAus, grenzwerte grenzw,String aufbereitung) {
    //Programm zur Berechnung von Emax und Umlaufwasser-
    //analyenwerte bei Enth„rtung
    //1. Algorithmus f?r Berechnung von S„ttigungsindex 2,30 bei
    //Wandtemperatur und Eindickungsfaktor Emax ausRohwasseranalyse
    //und Teilenth„rtung auf 0,5 mmol/l Ca
    //Zugriff auf kost1.dbf
    //rohanalyse aus Klasseauslesen
    auslesen(anaAus, grenzw);
    //spezialvariablen deklarieren
    double dCaNEH, dMgNEH, y, z;
    //pr?fen, ob Enth„rtung ?berhaupt sinnvoll und Verschneidung berechnen
    if (dCa > 20.04) {
      dCaNEH = grenzw.caMax*40.08; //auslesen des maximalen Calciumwertes und wandeln in mmol/l
      dVerschnitt = dCaNEH / dCa;
      dMgNEH = dMg * dVerschnitt;
      dCa = dCaNEH;
      dMg = dMgNEH;
    }
    else {
      warnfenster(startframe.Texte.elementAt(170).toString()); //warnung
      return false;
    }
    //Berechnung der molaren Größen
    dCaM = dCa / (40.08 * 1000);
    dMgM = dMg / (24.3 * 1000);
    dKs43M = dKs43 / 1000;
    dClM = dCl / (35.45 * 1000);
    dNo3M = dNo3 / (62 * 1000);
    dSo4M = dSo4 / (96 * 1000);
    dSuA = dKs43M + dClM + 2 * dSo4M + dNo3M;
    dSuK = 2 * dCaM + 2 * dMgM;
    dNaM = dSuA - dSuK;
    dNa = dNaM * 23000;
    dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);

    dSiW = 0.00;
    z = 1;
    dE = 1;
    while (dSiW < dSiMax && dCl < dClMax && dSo4 < dSoMax && dE < dEF) {
      y = z;
      z = z + 0.01;
      dE = dE * z / y;
      dCa = dCa * z / y;
      dMg = dMg * z / y;
      dNa = dNa * z / y;
      dKs43 = dKs43 * z / y;
      dCl = dCl * z / y;
      dNo3 = dNo3 * z / y;
      dSo4 = dSo4 * z / y;

      //Berechnung der für die weitere Berechnung benötigten Größen
      //Berechnung der molaren Größen
      dCaM = dCa / (40.8 * 1000);
      dMgM = dMg / (24.3 * 1000);
      dNaM = dNa / 23008;
      dKs43M = dKs43 / 1000;
      dClM = dCl / (35.45 * 1000);
      dNo3M = dNo3 / (62 * 1000);
      dSo4M = dSo4 / (96 * 1000);
      dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);

      dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));

      temperaturkorrektur(); //Temperaturkorrektur in Kelvin
      konstantekorrektur(); //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste
      //Wandtemperatur
      kohlensaeure(); //Berechnung Kohlensäure im K?hlturm nach Verrieselung
      phundkarbonatkonz(); //Berechnung pH-Wert und Karbonatkonz. nach Kohlens„ureverrieselung
      sikt(); //Berechnung SI bei K?hlturmtemp.
      siw(); //Berechnung SI bei Wandtemperatur

    } //Ende der while Schleife

    dho(); //erneute Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)
    //Korrektur nach Dbye-Hückel-Onsager
    ionensumme(); //Berechnung Summe Anionen/Kationen

    calciumkorrektur1(); //1. Calciumsulfatkorrektur, gilt f?r Speisewasser und Umlaufwasser
    calciumkorrektur2(); //2. Calciumcarbonatkorrektur, gilt nur f?r Umlaufwasser nach Verrieselung
    return true;
  }

//
  //****************************************************************
   //**															**
    //**ENTCARBONISIERUNG											**
     //**															**
      //****************************************************************
       //Entcarbonisierung
       static boolean ecrechL(rohanalyse anaAus, grenzwerte grenzw,String aufbereitung) {
         //Werte aus Klasse auslesen
         auslesen(anaAus, grenzw);

         //kost3l.prg Stand 02.11.00
         //1. Algorithmus f?r Berechnung von Verschneidung und Eindickungsfaktor E
         //bei Entcarbonisierung und anschlieáender Verschneidung; die Grenzbedingungen
         //sind: LF<LFMAX, GH<GH
         //Zugriff auf anaroh.dbf

         //spezialvariablen deklarieren
         double dKs43NEC, dErdALM, dErdNEC, dCaNEC, dMgNEC, dECl, dESo4;
         double dCaK, dMgK, dKs43K, dCaV = 0.0, dMgV = 0.0, dKs43V = 0.0;
         double dV, dV1, dE1, dV2, dE2;
         dSiW = 0.00;
         //Temperatur einsetzen um Funktionalitaet der dbase Algorythmen zu gewaehrleisten,
         dTKT = dTLW;
         dTW = dTKT;

         //Berechnung der für die weitere Berechnung benötigten Größen
         //Berechnung der molaren Größen
         dCaM = dCa / (40.08 * 1000);
         dMgM = dMg / (24.3 * 1000);
         dKs43M = dKs43 / 1000;
         dNaM = dNa / 23008;
         dClM = dCl / (35.45 * 1000);
         dNo3M = dNo3 / (62 * 1000);
         dSo4M = dSo4 / (96 * 1000);
         dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);

         //Berechnung Erdalkalien nach Entcarbonisierung
         dKs43NEC = 0.0;
         dErdALM = dCaM + dMgM;
         dErdNEC = dErdALM - dKs43 / 2000;

         //Erdalkalien auf Null setzen, wenn negativ
         if (dErdNEC < 0) {
           dNaM = dNaM - dErdNEC * 2;
           dNa = dNaM * 23000;
           dErdNEC = 0.0;
         }

         dCaNEC = dCaM * dErdNEC / dErdALM;
         dMgNEC = dMgM * dErdNEC / dErdALM;

         dE = 1.0;

         dho(); // Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)

         dLfBer = (dCaNEC * dElfCa * 2 + dMgNEC * dElfMg * 2 + dNaM * dElfNa +
                   dKs43NEC * dElfKs
                   + dClM * dElfCl + dSo4M * dElfSo * 2 + dNo3M * dElfNo) *
             1000; //LfBer ueberschreiben

         // Eindickungsfaktor festlegen; LFMAX ist Funktion von E und V

         // 1. Begrenzung durch LFMAX
         // Bedingung: Alkalit„t im Umlaufwasser muss ALK mmol/l betragen
         dV1 = dLfBer * dAlkMin /
             (dLfMax * dKs43 - dLf * dAlkMin + dLfBer * dAlkMin);
         dE1 = dAlkMin / (dV1 * dKs43);

         // Begrenzung durch dDhMax
         // Bedingung: Gesamth„rte darf dDhMax nicht ?berschreiten
         dV2 = dErdNEC * dAlkMin /
             (dDhMax * dKs43 / 1000 - dErdALM * dAlkMin + dErdNEC * dAlkMin);
         dE2 = dAlkMin / (dV2 * dKs43);

         if (dE1 < dE2) {
           dE = dE1;
           dVerschnitt = dV1;
         }
         else {
           dE = dE2;
           dVerschnitt = dV2;
         }

         if (dE < 1 || dVerschnitt > 1) {
           warnfenster(startframe.Texte.elementAt(174).toString() + aufbereitung + startframe.Texte.elementAt(169).toString()); //Warnung
           dE = 1;
           dVerschnitt = 1;
           return true;
         }
         //Eindickungsfaktor liegt jetzt fest, falls SI<SIMAX
         //alle Inhaltsstoffe mit E multiplizieren
         dV = dVerschnitt;
         dCa = (dCaM * dV + dCaNEC * (1 - dV)) * dE * 40080;
         dMg = (dMgM * dV + dMgNEC * (1 - dV)) * dE * 24300;
         dKs43 = dKs43 * dV * dE;
         dNa = dNa * dE;
         dCl = dCl * dE;
         dSo4 = dSo4 * dE;
         dNo3 = dNo3 * dE;

         dCaM = (dCaM * dV + dCaNEC * (1 - dV)) * dE;
         dMgM = (dMgM * dV + dMgNEC * (1 - dV)) * dE;
         dKs43M = dKs43M * dV * dE;
         dClM = dClM * dE;
         dNo3M = dNo3M * dE;
         dSo4M = dSo4M * dE;
         dNaM = dNaM * dE;
         dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);

         dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));

         temperaturkorrektur(); //Temperaturkorrektur in Kelvin
         konstantekorrektur(); //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste
         //Wandtemperatur
         kohlensaeure(); //Berechnung Kohlensäure im K?hlturm nach Verrieselung
         phundkarbonatkonz(); //Berechnung pH-Wert und Karbonatkonz. nach Kohlens„ureverrieselung
         sikt(); //Berechnung SI bei K?hlturmtemp.
         siw(); //Berechnung SI bei Wandtemperatur
         //falls SI zu hoch
         if (dSiW > dSiMax) {
           warnfenster(startframe.Texte.elementAt(174).toString() + aufbereitung + startframe.Texte.elementAt(168).toString()); //Warnung
           return false;
         }

         dho(); //Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)
         //Korrektur nach Dbye-Hückel-Onsager
         ionensumme(); //Berechnung Summe Anionen/Kationen
         calciumkorrektur1(); //1. Calciumsulfatkorrektur, gilt f?r Speisewasser und Umlaufwasser
         calciumkorrektur2(); //2. Calciumcarbonatkorrektur, gilt nur f?r Umlaufwasser nach Verrieselung
         // f?r anaroh nicht ausf?hren
         //Ergebnisse in Klasse einlesen und zurueckgeben
         return true;
       }

  static boolean ecrech(rohanalyse anaAus, grenzwerte grenzw, String aufbereitung) {
    //Werte aus Klasse auslesen
    auslesen(anaAus, grenzw);

    //Programm zur Berechnung von Emax und Umlaufwasser-
    //analyenwerte bei Entcarbonisierung
    //kost3.prg
    //1. Algorithmus f?r Berechnung von Verschneidung und Eindickungsfaktor E
    //bei S„ttigungsindex SIW=2,30 aus Rohwasseranalyse anaroh bei vollst.
    //Entcarbonisierung und anschlieáender Verschneidung; die Grenzbedingungen
    //sind: Cl<250 mg/l, SO4<400 mg/l, SIW< simax

    //spezialvariablen
    double dKs43NEC, dErdALM, dErdNEC, dCaNEC, dMgNEC, dECl, dESo4;
    double dCaK, dMgK, dKs43K, dCaV = 0.0, dMgV = 0.0, dKs43V = 0.0;

    // Pr?fen, ob eine Eindickug ?berhaupt m”glich ist, wenn nicht,
    if (dCl > dClMax || dSo4 > dSoMax) {
      warnfenster(startframe.Texte.elementAt(174).toString() + aufbereitung + startframe.Texte.elementAt(167).toString()); //warnung
      return false;
    }
    dSiW = 0.00; //SIW auf 0 setzen

    //Berechnung der für die weitere Berechnung benötigten Größen
    //Berechnung der molaren Größen
    dCaM = dCa / (40.08 * 1000);
    dMgM = dMg / (24.3 * 1000);
    dKs43M = dKs43 / 1000;
    dNaM = dNa / 23008;
    dClM = dCl / (35.45 * 1000);
    dNo3M = dNo3 / (62 * 1000);
    dSo4M = dSo4 / (96 * 1000);
    dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);



    //Berechnung Erdalkalien nach Entcarbonisierung
    dKs43NEC = 0.0;
    dErdALM = dCaM + dMgM;
    dErdNEC = dErdALM - dKs43 / 2000;

    //Erdalkalien auf Null setzen, wenn negativ
    if (dErdNEC < 0) {
      dErdNEC = 0.0;
    }
    dCaNEC = dCa * dErdNEC / dErdALM;
    dMgNEC = dMg * dErdNEC / dErdALM;
    dE = dEF; //bei ec immer 5

    //erst mal kontrollieren, ob Chlorid oder Sulfat eindickungsbegrenzend sind
    dECl = dClMax / dCl;
    dESo4 = dSoMax / dSo4;
    if (dECl < 5 && dECl < dESo4) {
      dE = dECl;
    }
    else {
      if (dESo4 < 5) {
        dE = dESo4;
      }
    }
    //Eindickungsfaktor liegt jetzt fest
    //alle Inhaltsstoffe mit E multiplizieren
    dCaK = dCa;
    dCaK = dCaK * dE;
    dMgK = dMg;
    dMgK = dMgK * dE;
    dKs43K = dKs43;
    dKs43K = dKs43K * dE;
    dNa = dNa * dE;
    dCl = dCl * dE;
    dSo4 = dSo4 * dE;
    dNo3 = dNo3 * dE;
    dCaNEC = dCaNEC * dE;
    dMgNEC = dMgNEC * dE;

    //jetzt probieren,wie verschnitten werden muá!
    dVerschnitt = 0.00;
    while (dSiW <= dSiMax && dVerschnitt <= 1.00) {
      dVerschnitt = dVerschnitt + 0.01;
      dCaV = (dCaK * dVerschnitt + dCaNEC * (1 - dVerschnitt));
      dMgV = (dMgK * dVerschnitt + dMgNEC * (1 - dVerschnitt));
      dKs43V = dKs43K * dVerschnitt;

      //Berechnung der für die weitere Berechnung benötigten Größen
      //Berechnung der molaren Größen
      dCaM = dCaV / (40.8 * 1000);
      dMgM = dMgV / (24.3 * 1000);
      dNaM = dNa / 23008;
      dKs43M = dKs43V / 1000;
      dClM = dCl / (35.45 * 1000);
      dNo3M = dNo3 / (62 * 1000);
      dSo4M = dSo4 / (96 * 1000);
      dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);

      dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));

      temperaturkorrektur(); //Temperaturkorrektur in Kelvin
      konstantekorrektur(); //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste
      //Wandtemperatur
      kohlensaeure(); //Berechnung Kohlensäure im K?hlturm nach Verrieselung
      phundkarbonatkonz(); //Berechnung pH-Wert und Karbonatkonz. nach Kohlens„ureverrieselung
      sikt(); //Berechnung SI bei K?hlturmtemp.
      siw(); //Berechnung SI bei Wandtemperatur

      //spezial
      if (dVerschnitt > 0.99) {
        dCa = dCaV;
        dMg = dMgV;
        dKs43 = dKs43V;

      }

    } //Ende der while Schleife

    dCa = dCaV;
    dMg = dMgV;
    dKs43 = dKs43V;

    dho(); //Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)

    ionensumme(); //Berechnung Summe Anionen/Kationen

    calciumkorrektur1(); //1. Calciumsulfatkorrektur, gilt f?r Speisewasser und Umlaufwasser
    calciumkorrektur2(); //2. Calciumcarbonatkorrektur, gilt nur f?r Umlaufwasser nach Verrieselung
    // für anaroh nicht ausf?hren
    return true;
  }

  //****************************************************************
   //**															**
    //**UMKEHROSMOSE 											**
     //**															**
      //****************************************************************
       //umkehrosmose
       static boolean uorechL(rohanalyse anaAus, grenzwerte grenzw,String aufbereitung) {
         //Werte aus Klasse auslesen
         auslesen(anaAus, grenzw);
         //Temperatur einsetzen um Funktionalitaet der dbase Algorythmen zu gewaehrleisten,
         //maximale Eindickung
         dEF = 5;
         dTKT = dTLW;
         dTW = dTKT;
         double z, y;
         z = .01;
         dE = 1;
         dSiW = 0.0;
         dE = dE * z;
         dCa = dCa * z;
         dMg = dMg * z;
         dNa = dNa * z;
         dKs43 = dKs43 * z;
         dCl = dCl * z;
         dNo3 = dNo3 * z;
         dSo4 = dSo4 * z;
         dLfBer = dLfBer * z;
         dCaM = (dCa / (40.08 * 1000)) * z;
         dMgM = (dMg / (24.3 * 1000)) * z;
         dKs43M = (dKs43 / 1000) * z;

         while (dSiW < dSiMax && dLfBer < dLfMax &&
                (dCa / 40.08 + dMg / 24.3) < dDhMax && dE < dEF) {
           y = z;
           z = z + 0.01;
           dE = dE * z / y;
           dCa = dCa * z / y;
           dMg = dMg * z / y;
           dNa = dNa * z / y;
           dKs43 = dKs43 * z / y;
           dCl = dCl * z / y;
           dNo3 = dNo3 * z / y;
           dSo4 = dSo4 * z / y;
           dLfBer = dLfBer * z / y;

           //Berechnung der für die weitere Berechnung benötigten Größen
           //Berechnung der molaren Größen
           dCaM = dCa / (40.08 * 1000);
           dMgM = dMg / (24.3 * 1000);
           dKs43M = dKs43 / 1000;
           dNaM = dNa / 23008;
           dClM = dCl / (35.45 * 1000);
           dNo3M = dNo3 / (62 * 1000);
           dSo4M = dSo4 / (96 * 1000);
           dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);

           dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));

           temperaturkorrektur(); //Temperaturkorrektur in Kelvin
           konstantekorrektur(); //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste
           //Wandtemperatur
           kohlensaeure(); //Berechnung Kohlensäure im K?hlturm nach Verrieselung
           phundkarbonatkonz(); //Berechnung pH-Wert und Karbonatkonz. nach Kohlens„ureverrieselung
           sikt(); //Berechnung SI bei K?hlturmtemp.
           siw(); //Berechnung SI bei Wandtemperatur
         } //Ende der while Schleife

         //jetzt Verschneidung berechnen!
         dVerschnitt = dE / dEF; //hier auch?
         dE = dEF; //hierauch ?
         dho(); // Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)
         //Korrektur nach Dbye-Hückel-Onsager
         ionensumme(); //Berechnung Summe Anionen/Kationen
         calciumkorrektur1(); //1. Calciumsulfatkorrektur, gilt f?r Speisewasser und Umlaufwasser
         calciumkorrektur2(); //2. Calciumcarbonatkorrektur, gilt nur f?r Umlaufwasser nach Verrieselung
         // f?r anaroh nicht ausf?hren
         return true;
       }

  static boolean uorech(rohanalyse anaAus, grenzwerte grenzw,String aufbereitung) {
    //Werte aus Klasse auslesen
    auslesen(anaAus, grenzw);
    //Programm zur Berechnung von Emax und Umlaufwasser-
    //analyenwerte bei Umkehosmose
    //kost4.prg
    //1. Algorithmus f?r Berechnung von Verschneidung und Eindickungsfaktor E=5
    //bei S„ttigungsindex SIW=2,30 aus Rohwasseranalyse KOST1 bei vollst.
    //Entsalzung und anschlieáender Verschneidung.
    //Zugriff auf kost1.dbf
    //Das Programm ist identisch mit kost2.prg, auch die Inhaltsstoffe sind gleich!
    //Einziger Unterschied: Verschneidungsfaktor VERSCHN wird berechnet.

    double z, y;

    z = .01;
    dE = 1;
    dSiW = 0.0;
    dE = dE * z;
    dCa = dCa * z;
    dMg = dMg * z;
    dNa = dNa * z;
    dKs43 = dKs43 * z;
    dCl = dCl * z;
    dNo3 = dNo3 * z;
    dSo4 = dSo4 * z;

    while (dSiW < dSiMax && dCl < dClMax && dSo4 < dSoMax && dE < dEF) {
      y = z;
      z = z + 0.01;
      dE = dE * z / y;
      dCa = dCa * z / y;
      dMg = dMg * z / y;
      dNa = dNa * z / y;
      dKs43 = dKs43 * z / y;
      dCl = dCl * z / y;
      dNo3 = dNo3 * z / y;
      dSo4 = dSo4 * z / y;

      //Berechnung der für die weitere Berechnung benötigten Größen
      //Berechnung der molaren Größen
      dCaM = dCa / (40.08 * 1000);
      dMgM = dMg / (24.3 * 1000);
      dKs43M = dKs43 / 1000;
      dNaM = dNa / 23008;
      dClM = dCl / (35.45 * 1000);
      dNo3M = dNo3 / (62 * 1000);
      dSo4M = dSo4 / (96 * 1000);
      dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);

      dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));

      temperaturkorrektur(); //Temperaturkorrektur in Kelvin
      konstantekorrektur(); //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste
      //Wandtemperatur
      kohlensaeure(); //Berechnung Kohlensäure im K?hlturm nach Verrieselung
      phundkarbonatkonz(); //Berechnung pH-Wert und Karbonatkonz. nach Kohlens„ureverrieselung
      sikt(); //Berechnung SI bei K?hlturmtemp.
      siw(); //Berechnung SI bei Wandtemperatur
    } //Ende der while Schleife

//jetzt Verschneidung berechnen!
    dVerschnitt = dE / dEF; //hier auch ?
    dE = dEF; //hier auch ?
    dho(); // Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)
    //Korrektur nach Dbye-Hückel-Onsager
    ionensumme(); //Berechnung Summe Anionen/Kationen
    calciumkorrektur1(); //1. Calciumsulfatkorrektur, gilt f?r Speisewasser und Umlaufwasser
    calciumkorrektur2(); //2. Calciumcarbonatkorrektur, gilt nur f?r Umlaufwasser nach
    return true;
  }

//
  static boolean sdrech(rohanalyse anaAus, grenzwerte grenzw,String aufbereitung) {
    //Werte aus Klasse auslesen
    auslesen(anaAus, grenzw);
    //****************************************************************
     //**															**
      //**SCHWEFELSÄUREDOSIERUNG													**
       //**															**
        //****************************************************************
         //kost5.prg
         //1. Algorithmus f?r Berechnung von Eindickungsfaktor E
         //bei Restalkalit„t von 4 mmol/l im Umlaufwasser aus Rohwasseranalyse anaroh bei
         //innerer Entcarbonisierung mit Schwefels„uredosierung; die Grenzbedingungen
         //sind: Cl<CLMAX, SO4<SOMAX; SIW wird nicht angepasst
         //Zugriff auf anaroh.dbf
         double dECl, dESo4, dSo4NEU, dKs43K, dSo4K;
    dE = dEF;
    dVerschnitt = 1;
    // kontrollieren ob Saäuredos. unsinnig
    if ( (4 / dKs43) > (dSoMax + 192) / (dSo4 + dKs43 * 48)) {
      warnfenster(startframe.Texte.elementAt(166).toString()); //warnung
      return false;
    }
    //erst mal kontrollieren, ob Chlorid oder Sulfat eindickungsbegrenzend sind
    dECl = dClMax / dCl;
    dESo4 = (dSoMax + 192) / (dSo4 + dKs43 * 48);
    if (dECl < 5 && dECl < dESo4) {
      dE = dECl;
    }
    else {
      if (dESo4 < 5) {
        dE = dESo4;
      }
    } //Eindickungsfaktor liegt jetzt fest

    // jetzt KS43, SO4 und LF erseten
    dSo4NEU = dSo4 + dKs43 * 48 - 192 / dE;
    dSo4 = dSo4NEU;
    dKs43 = 4 / dE;

    //alle Inhaltsstoffe mit E multiplizieren
    dKs43K = dKs43;
    dKs43K = dKs43K * dE;
    dSo4K = dSo4;
    dSo4K = dSo4K * dE;

    dNa = dNa * dE;
    dCa = dCa * dE;
    dMg = dMg * dE;
    dKs43 = dKs43K;

    dCl = dCl * dE;
    dSo4 = dSo4 * dE;
    dNo3 = dNo3 * dE;

    //Berechnung der molaren Größen
    dCaM = dCa / (40.08 * 1000);
    dMgM = dMg / (24.3 * 1000);
    dKs43M = dKs43 / 1000;
    dNaM = dNa / 23008;
    dClM = dCl / (35.45 * 1000);
    dNo3M = dNo3 / (62 * 1000);
    dSo4M = dSo4 / (96 * 1000);
    dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);
    dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));

    temperaturkorrektur(); //Temperaturkorrektur in Kelvin
    konstantekorrektur(); //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste
    //Wandtemperatur
    kohlensaeure(); //Berechnung Kohlensäure im K?hlturm nach Verrieselung
    phundkarbonatkonz(); //Berechnung pH-Wert und Karbonatkonz. nach Kohlens„ureverrieselung
    phundkarbonatkonz(); //Berechnung pH-Wert und Karbonatkonz. nach Kohlens„ureverrieselung
    sikt(); //Berechnung SI bei K?hlturmtemp.
    siw(); //Berechnung SI bei Wandtemperatur

    dho(); //Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)
    //Korrektur nach Dbye-Hückel-Onsager
    ionensumme(); //Berechnung Summe Anionen/Kationen
    calciumkorrektur1(); //1. Calciumsulfatkorrektur, gilt f?r Speisewasser und Umlaufwasser
    calciumkorrektur2(); //2. Calciumcarbonatkorrektur, gilt nur f?r Umlaufwasser nach Verrieselung
    return true;
  }

  static double kostuo(rohanalyse anaAus, grenzwerte grenzw) {
    //Variablen deklarieren
    auslesen(anaAus, grenzw);
    double y, z;
    double dlgCK, dCo2M, dpHE; //extra Variable Kohlensaeure im Konzentrat
    dpHE = anaAus.pHtE; // eingabe pH auslesen
    //Berechnung Co2 molar
    dLGK1E = -6.356 + 483.2 * (1 / cT0 - 1 / dTKE) -
        17.2 * (Math.log(dTKE / cT0) + (cT0 / dTKE) - 1);
    //Berechnung Co2 im Speisewasser
    dlgCK = -dLGK1E - dpHE + meinMath.log10(dKs43M) + dLGF1;
    dSiW = 0;
    z = 1;
    while (dSiW < dRoMax && dE < 5.0) {
      y = z;
      z = z + 0.01;
      //dVerschnitt = 1;
      dE = dE * z / y;
      dCa = dCa * z / y;
      dMg = dMg * z / y;
      dNa = dNa * z / y;
      dKs43 = dKs43 * z / y;
      dCl = dCl * z / y;
      dNo3 = dNo3 * z / y;
      dSo4 = dSo4 * z / y;

      //Berechnung der für die weitere Berechnung benötigten Größen
      //Berechnung der molaren Größen
      dCaM = dCa / (40.08 * 1000);
      dMgM = dMg / (24.3 * 1000);
      dNaM = dNa / 23008;
      dKs43M = dKs43 / 1000;
      dClM = dCl / (35.45 * 1000);
      dNo3M = dNo3 / (62 * 1000);
      dSo4M = dSo4 / (96 * 1000);
      dI = 2 * (dCaM + dMgM + dSo4M) + 0.5 * (dKs43M + dClM + dNo3M + dNaM);

      dLGF1 = -0.5 * Math.pow(dI, 0.5) / (1 + 1.4 * Math.pow(dI, 0.5));

      //Temperaturkorrektur in Kelvin
      dTKE = dTE + cTK;
      dTKKT = dTKE;

      //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste
      //Wandtemperatur
      dLGKCKT = -8.481 - 522.3 * (1 / cT0 - 1 / dTKKT) -
          14.1 * (Math.log(dTKKT / cT0) + (cT0 / dTKKT) - 1);
      dLGK1KT = -6.356 + 483.2 * (1 / cT0 - 1 / dTKKT) -
          17.2 * (Math.log(dTKKT / cT0) + (cT0 / dTKKT) - 1);
      dLGK2KT = -10.329 + 780.9 * (1 / cT0 - 1 / dTKKT) -
          15.1 * (Math.log(dTKKT / cT0) + (cT0 / dTKKT) - 1);
      dLGKWKT = -13.996 + 2954 * (1 / cT0 - 1 / dTKKT) -
          10.4 * (Math.log(dTKKT / cT0) + (cT0 / dTKKT) - 1);

      //Kohlensaeure im Konzentrat wie im Permeat
      dCo2KT = Math.pow(10, dlgCK);
      dpHKTNV = -dLGK1KT - dlgCK + meinMath.log10(dKs43M) + dLGF1;
      dlgCo3 = dLGK2KT + meinMath.log10(dKs43M) - 3 * dLGF1 + dpHKTNV;
      dCo3NV = Math.pow(10, dlgCo3);
      dHCo3NV = dKs43M - 2 * dCo3NV;

      //Berechnung SI nach Eindickung
      dL2KT = dLGKCKT - dLGK2KT;
      dpHGlKT = dL2KT - 5 * dLGF1 - meinMath.log10(dCaM * dKs43M);
      dSiW = dpHKTNV - dpHGlKT;

    } //Ende der while Schleife
    //Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche Verdünnung)
    //Korrektur nach Dbye-Hückel-Onsager
    dElfCa = 59.2 - (0.229 * 59.2 + 30.1 * 2) * Math.pow(dI, 0.5);
    dElfMg = 53.2 - (0.229 * 53.2 + 30.1 * 2) * Math.pow(dI, 0.5);
    dElfNa = 50.1 - (0.229 * 50.1 + 30.1) * Math.pow(dI, 0.5);
    dElfKs = 44.5 - (0.229 * 44.5 + 30.1) * Math.pow(dI, 0.5);
    dElfCl = 76.4 - (0.229 * 76.4 + 30.1) * Math.pow(dI, 0.5);
    dElfSo = 80.2 - (0.229 * 80.2 + 30.1 * 2) * Math.pow(dI, 0.5);
    dElfNo = 71.5 - (0.229 * 71.5 + 30.1) * Math.pow(dI, 0.5);
    dElfCo3 = 80.2 - (0.229 * 80.2 + 30.1 * 2) * Math.pow(dI, 0.5);
    dLfBer = (dCaM * dElfCa * 2 + dMgM * dElfMg * 2 + dNaM * dElfNa +
              dKs43M * dElfKs
              + dClM * dElfCl + dSo4M * dElfSo * 2 + dNo3M * dElfNo) * 1000;

    //Berechnung Summe Anionen/Kationen
    dSuA = dKs43M + dClM + 2 * dSo4M + dNo3M;
    dSuK = 2 * dCaM + 2 * dMgM + dNaM;
    return dE; //Eindickung an uookostenberechnung zurueckgeben
  }

  //Ende Berechnungen

  //allgemeine Berechnungen
  static void dho() { //Berechnung von Leitfähigkeit bei realem Verhalten (nicht unendliche   ), Korrektur nach Dbye-Hückel-Onsager
    dElfCa = 59.2 - (0.229 * 59.2 + 30.1 * 2) * Math.pow(dI, 0.5);
    dElfMg = 53.2 - (0.229 * 53.2 + 30.1 * 2) * Math.pow(dI, 0.5);
    dElfNa = 50.1 - (0.229 * 50.1 + 30.1) * Math.pow(dI, 0.5);
    dElfKs = 44.5 - (0.229 * 44.5 + 30.1) * Math.pow(dI, 0.5);
    dElfCl = 76.4 - (0.229 * 76.4 + 30.1) * Math.pow(dI, 0.5);
    dElfSo = 80.2 - (0.229 * 80.2 + 30.1 * 2) * Math.pow(dI, 0.5);
    dElfNo = 71.5 - (0.229 * 71.5 + 30.1) * Math.pow(dI, 0.5);
    dElfCo3 = 66.5 - (0.229 * 66.5 + 30.1 * 2) * Math.pow(dI, 0.5);
    //alternativ zu 80.2 ist 59.0
    dLfBer = (dCaM * dElfCa * 2 + dMgM * dElfMg * 2 + dNaM * dElfNa +
              dKs43M * dElfKs
              + dClM * dElfCl + dSo4M * dElfSo * 2 + dNo3M * dElfNo) * 1000;
  }

//
  static void ionensumme() { //Berechnung Summe Anionen/Kationen
    dSuA = dKs43M + dClM + 2 * dSo4M + dNo3M;
    dSuK = 2 * dCaM + 2 * dMgM + dNaM;
  }

//
  static void calciumkorrektur1() { //1. Calciumsulfatkorrektur, gilt f?r Speisewasser und Umlaufwasser
    dlgK5 = -2.31;
    dlgK5K = dlgK5 - 8 * dLGF1;
    dA = ( -dCaM - dSo4M - Math.pow(10, dlgK5K));
    dB = dCaM * dSo4M;
    dCaSo4 = -0.5 * dA - Math.pow( (Math.pow( (0.5 * dA), 2) - dB), 0.5);
    dCaMK = dCaM - dCaSo4;
    dSo4K = dSo4M - dCaSo4;

    dLfBerk = (dCaMK * dElfCa * 2 + dMgM * dElfMg * 2 + dNaM * dElfNa +
               dHCo3NV * dElfKs + dCo3NV * dElfCo3 * 2
               + dClM * dElfCl + dSo4K * dElfSo * 2 + dNo3M * dElfNo) * 1000;
  }

//
  static void calciumkorrektur2() { //2. Calciumcarbonatkorrektur, gilt nur f?r Umlaufwasser nach Verrieselung,  f?r anaroh nicht ausf?hren
    dlgK4 = -3.20;
    dlgK4K = dlgK4 - 8 * dLGF1;
    dA = ( -dCaMK - dCo3NV - Math.pow(10, dlgK4K));
    dB = dCaMK * dCo3NV;
    dCaCo3 = -0.5 * dA - Math.pow( (Math.pow( (0.5 * dA), 2) - dB), 0.5);
    dCaMK = dCaMK - dCaCo3;
    dCo3K = dCo3NV - dCaCo3;

    dLfBerk = (dCaMK * dElfCa * 2 + dMgM * dElfMg * 2 + dNaM * dElfNa +
               dHCo3NV * dElfKs + dCo3K * dElfCo3 * 2
               + dClM * dElfCl + dSo4K * dElfSo * 2 + dNo3M * dElfNo) * 1000;
  }

//
  static void temperaturkorrektur() { //Temperaturkorrektur in Kelvin
    dTKE = dTE + cTK;
    dTKKT = dTKT + cTK;
    dTKW = dTW + cTK;
  }

//
  static void konstantekorrektur() { //Temperaturkorrektur der Dissoziationskonstanten, Entnahmetemperatur, K?hlturmtemperatur, h”chste,
    dLGKCKT = -8.481 - 522.3 * (1 / cT0 - 1 / dTKKT) -
        14.1 * (Math.log(dTKKT / cT0) + (cT0 / dTKKT) - 1);
    dLGK1KT = -6.356 + 483.2 * (1 / cT0 - 1 / dTKKT) -
        17.2 * (Math.log(dTKKT / cT0) + (cT0 / dTKKT) - 1);
    dLGK2KT = -10.329 + 780.9 * (1 / cT0 - 1 / dTKKT) -
        15.1 * (Math.log(dTKKT / cT0) + (cT0 / dTKKT) - 1);
    dLGKWKT = -13.996 + 2954 * (1 / cT0 - 1 / dTKKT) -
        10.4 * (Math.log(dTKKT / cT0) + (cT0 / dTKKT) - 1);

    dLGKCW = -8.481 - 522.3 * (1 / cT0 - 1 / dTKW) -
        14.1 * (Math.log(dTKW / cT0) + (cT0 / dTKW) - 1);
    dLGK1W = -6.356 + 483.2 * (1 / cT0 - 1 / dTKW) -
        17.2 * (Math.log(dTKW / cT0) + (cT0 / dTKW) - 1);
    dLGK2W = -10.329 + 780.9 * (1 / cT0 - 1 / dTKW) -
        15.1 * (Math.log(dTKW / cT0) + (cT0 / dTKW) - 1);
    dLGKWW = -13.996 + 2954 * (1 / cT0 - 1 / dTKW) -
        10.4 * (Math.log(dTKW / cT0) + (cT0 / dTKW) - 1);
  }

//
  static void kohlensaeure() { //Berechnung Kohlensäure im K?hlturm nach Verrieselung
    dlgC = (-5.311 + 1042 / dTKKT) - 3;
  }

//
  static void phundkarbonatkonz() { //Berechnung pH-Wert und Karbonatkonz. nach Kohlens„ureverrieselung
    dCo2KT = Math.pow(10, dlgC);
    dpHKTNV = -dLGK1KT - dlgC + meinMath.log10(dKs43M) + dLGF1;
    dlgCo3 = dLGK2KT + meinMath.log10(dKs43M) - 3 * dLGF1 + dpHKTNV;
    dCo3NV = Math.pow(10, dlgCo3);
    dHCo3NV = dKs43M - 2 * dCo3NV;





  }

//
  static void sikt() { //Berechnung SI bei Kuehlturm
    dL2KT = dLGKCKT - dLGK2KT;
    dpHGlKT = dL2KT - 5 * dLGF1 - meinMath.log10(dCaM * dKs43M); ///2.3026;
    dSiKT = dpHKTNV - dpHGlKT;
  }

//
  static void siw() { //Berechnung SI bei Wandtemperatur
    dL2W = dLGKCW - dLGK2W;
    dpHGlW = dL2W - 5 * dLGF1 - meinMath.log10(dCaM * dKs43M); ///2.3026;
    dSiW = dpHKTNV - dpHGlW;
  }

//

  public watkostberechnung() {

  }

  static void warnfenster(String Meldung) {
    dialogframe meinDialog = new dialogframe();
    warndialog keineZahl = new warndialog(meinDialog, startframe.Texte.elementAt(158).toString(), true);
    keineZahl.setSize(300, 150);
    keineZahl.setLocation(300, 200);
    //keineZahl.setLocation((int)this.getX()+this.getWidth()/2 - 150,(int)this.getY()+this.getHeight()/2 - 75);
    keineZahl.meldung(Meldung);
    keineZahl.setVisible(true);
    meinDialog.dispose();
  }

}
