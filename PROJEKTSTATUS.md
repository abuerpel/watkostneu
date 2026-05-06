# Projektstatus: Watkost5

**Stand:** 2026-04-27  
**Bearbeiter:** H. Kacirek

---

## Programmübersicht

Watkost5 ist ein Java-Berechnungsprogramm zur Kostenkalkulation von Wasseraufbereitungsanlagen. Es besteht aus 65 Java-Klassen und nutzt eine HyperSQL-Datenbank sowie JExcelAPI für Excel-Export.

- **Sprache:** Java (Swing/AWT)
- **Datenbank:** HyperSQL (hsqldb)
- **Excel-Bibliothek:** JExcelAPI (jxl.jar)
- **Zielplattform:** Windows
- **JDK:** 25.0.2 (installiert unter `C:\Program Files\jdk-25.0.2+10`)
- **Versionskontrolle:** Git (initialisiert, Branch: master)

---

## Ordnerstruktur

```
C:\watkostneu\
├── Quellcode/src/       ← 65 Java-Quelldateien (maßgebliche Version)
├── Watkost5/
│   ├── bin/             ← JAR-Bibliotheken, Icons, Sprachdatei
│   ├── classes/         ← Kompilierte .class-Dateien
│   ├── db/              ← HyperSQL-Datenbankdateien
│   └── Watkost5.exe     ← Startprogramm
├── Passwort4/           ← Passwort-Generator (separates Tool)
├── Watkost-Installation/← Installationspaket
├── watkost-texte/       ← Dokumentation
├── build.xml            ← Ant-Build-Datei
├── build.bat            ← Windows-Startskript (kein PATH nötig)
└── .gitignore
```

---

## Abhängigkeiten (JAR-Bibliotheken)

| Bibliothek   | Datei                    | Status       | Verwendung           |
|--------------|--------------------------|--------------|----------------------|
| JExcelAPI    | Watkost5/bin/jxl.jar     | ✅ vorhanden | Excel-Export/-Import |
| HyperSQL DB  | Watkost5/bin/hsqldb.jar  | ✅ vorhanden | Datenbankzugriff     |
| HyperSQL alt | Watkost5/bin/hsql.jar    | ✅ vorhanden | Legacy-Imports       |

---

## Kompilierung

**Status: ✅ Erfolgreich** (getestet mit JDK 25.0.2, 2026-04-21)

```
build.bat          ← kompilieren (Standard)
build.bat clean    ← .class-Dateien löschen
build.bat run      ← kompilieren und starten
```

- **Fehler:** 0
- **Warnungen:** 3 (JDK 25 weist darauf hin, dass Java-8-Ziel künftig entfernt wird — unkritisch)

---

## Erledigte Schritte

- [x] Compile-Fehler behoben: `import sun.jdbc.odbc.*;` aus `data.java` entfernt
- [x] `build.xml` für Apache Ant erstellt (Encoding: UTF-8, release=8)
- [x] `build.bat` erstellt (kein PATH-Setup nötig)
- [x] JDK 25.0.2 installiert
- [x] Apache Ant 1.10.17 installiert
- [x] Git-Repository initialisiert (9 Commits)
- [x] Kompilierung erfolgreich: `BUILD SUCCESSFUL`, 0 Fehler
- [x] Bugfix: `NullPointerException` in `anlageReport` — `wz3` in `anlagekosten.nullen()` ergänzt
- [x] Quelldateien von Windows-1252 auf UTF-8 konvertiert (38 von 64 Dateien)
- [x] Zeilenenden-Fix: `\r\r\n` → `\r\n` in 7 Quelldateien nach Konvertierung
- [x] Encoding-Fix: `-Dfile.encoding=Cp1252` im JVM-Start (JExcelAPI / WtkLg.xls)
- [x] UI: Nachkommastellen für Chlorid, Sulfat, Magnesium im Hauptfenster auf 1 reduziert
- [x] Bugfix: Drucken Umlaufwasseranalyse (Kühlturmkreislauf) — `umReport.java` elementAt(1200) → elementAt(200) (Tippfehler, ArrayIndexOutOfBoundsException)
- [x] Installationsanleitung erstellt: `Watkost5/Installationsanleitung.txt`

## Offene Punkte

- [ ] Ressourcen-Dateien (`splash.GIF`, Icons, `WtkLg.xls`) auch im Quellcode-Ordner ablegen
- [ ] Veraltete Root-Dateien (`analysendialog.java`, `watkostberechnung.java`) entfernen

---

## Behobene Fehler

| Datum      | Datei              | Problem                                      |
|------------|--------------------|----------------------------------------------|
| 2026-04-21 | `data.java`        | `import sun.jdbc.odbc.*` entfernt (JDK 8+ nicht vorhanden) |
| 2026-04-21 | `anlagekosten.java`| `wz3 = ""` in `nullen()` ergänzt → NullPointerException in `anlageReport` |
| 2026-04-21 | 38 Quelldateien    | Encoding Windows-1252 → UTF-8 konvertiert    |
| 2026-04-21 | `build.xml`        | `-Dfile.encoding=Cp1252` für JVM-Start (JExcelAPI / JDK 18+) |
| 2026-04-21 | 7 Quelldateien     | Zeilenenden `\r\r\n` → `\r\n` bereinigt (Fehler aus Cp1252→UTF-8-Konvertierung) |
| 2026-04-21 | `hauptframe.java`  | Nachkommastellen Chlorid/Sulfat/Magnesium im Hauptfenster auf 1 (`String.format("%.1f")`) |
| 2026-04-27 | `umReport.java`    | `elementAt(1200)` → `elementAt(200)` — Drucken Umlaufwasseranalyse (Kühlturmkreislauf) schlug fehl |

## Bekannte Warnungen beim Kompilieren

| Klasse            | Warnung                                    | Kritisch? |
|-------------------|--------------------------------------------|-----------|
| anlageapplet.java | JApplet veraltet (für Entfernung markiert) | Nein      |
| startApplet.java  | JApplet veraltet                           | Nein      |
| warnframe.java    | Applet veraltet                            | Nein      |
| watkostapplet.java| Applet veraltet                            | Nein      |

---

## Vorhandene Dokumentation

| Dokument                     | Ort                                       |
|------------------------------|-------------------------------------------|
| Programmbeschreibung (PDF)   | watkost-texte/InhaltWatkost Ver 4.pdf     |
| Englische Beschreibung       | watkost-texte/english/                    |
| Installationsanleitung       | Watkost5/Installationsanleitung.txt       |
| Fehlerprotokoll              | Watkost-Installation/Watkost5 Fehler.docx |
| Bereitstellungsplan          | Passwort4/Watkost5 Bereitstellung.xls     |
