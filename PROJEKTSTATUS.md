# Projektstatus: Watkost4

**Stand:** 2026-04-21  
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
javac -encoding Cp1252 -cp "Watkost4/bin/jxl.jar;Watkost4/bin/hsqldb.jar;Watkost4/bin/hsql.jar"
      -d Watkost4/classes Quellcode/src/*.java
```

- **Fehler:** 0
- **Warnungen:** 4 (veraltete Applet-APIs — nicht kritisch, da Applets im Hauptprogramm nicht aktiv genutzt werden)

**Mit Apache Ant** (sobald installiert):
```
ant compile   ← kompilieren
ant clean     ← .class-Dateien löschen
ant run       ← kompilieren und starten
```

---

## Erledigte Schritte

- [x] Compile-Fehler behoben: `import sun.jdbc.odbc.*;` aus `data.java` entfernt
- [x] `build.xml` für Apache Ant erstellt (Encoding: Cp1252)
- [x] Git-Repository initialisiert, erster Commit
- [x] Kompilierung erfolgreich getestet (JDK 25, 0 Fehler)

## Offene Punkte

- [ ] Apache Ant installieren (für bequeme Nutzung von `ant compile`)
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
