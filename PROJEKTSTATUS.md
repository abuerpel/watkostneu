# Projektstatus: Watkost4

**Stand:** 2026-04-21 (aktualisiert)  
**Bearbeiter:** H. Kacirek

---

## Programmübersicht

Watkost4 ist ein Java-Berechnungsprogramm zur Kostenkalkulation von Wasseraufbereitungsanlagen. Es besteht aus 65 Java-Klassen und nutzt eine HyperSQL-Datenbank sowie JExcelAPI für Excel-Export.

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
├── Watkost4/
│   ├── bin/             ← JAR-Bibliotheken, Icons, Sprachdatei
│   ├── classes/         ← Kompilierte .class-Dateien
│   ├── db/              ← HyperSQL-Datenbankdateien
│   └── Watkost4.exe     ← Startprogramm
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
| JExcelAPI    | Watkost4/bin/jxl.jar     | ✅ vorhanden | Excel-Export/-Import |
| HyperSQL DB  | Watkost4/bin/hsqldb.jar  | ✅ vorhanden | Datenbankzugriff     |
| HyperSQL alt | Watkost4/bin/hsql.jar    | ✅ vorhanden | Legacy-Imports       |

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
- [x] `build.xml` für Apache Ant erstellt (Encoding: Cp1252, release=8)
- [x] `build.bat` erstellt (kein PATH-Setup nötig)
- [x] JDK 25.0.2 installiert
- [x] Apache Ant 1.10.17 installiert
- [x] Git-Repository initialisiert (3 Commits)
- [x] Kompilierung erfolgreich: `BUILD SUCCESSFUL`, 0 Fehler

## Offene Punkte

- [ ] Ressourcen-Dateien (`splash.GIF`, Icons, `WtkLg.xls`) auch im Quellcode-Ordner ablegen
- [ ] Veraltete Root-Dateien (`analysendialog.java`, `watkostberechnung.java`) entfernen

---

## Bekannte Warnungen beim Kompilieren

| Klasse           | Warnung                          | Kritisch? |
|------------------|----------------------------------|-----------|
| anlageapplet.java | JApplet veraltet (für Entfernung markiert) | Nein |
| startApplet.java  | JApplet veraltet                 | Nein |
| warnframe.java    | Applet veraltet                  | Nein |
| watkostapplet.java| Applet veraltet                  | Nein |

---

## Vorhandene Dokumentation

| Dokument                     | Ort                                       |
|------------------------------|-------------------------------------------|
| Programmbeschreibung (PDF)   | watkost-texte/InhaltWatkost Ver 4.pdf     |
| Englische Beschreibung       | watkost-texte/english/                    |
| Installationsanleitung       | Watkost4/Readme.txt                       |
| Fehlerprotokoll              | Watkost-Installation/Watkost4 Fehler.docx |
| Bereitstellungsplan          | Passwort4/Watkost4 Bereitstellung.xls     |
