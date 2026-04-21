# Projektstatus: Watkost4

**Stand:** 2026-04-21  
**Bearbeiter:** H. Kacirek

---

## Programmübersicht

Watkost4 ist ein Java-Berechnungsprogramm zur Kostenkalkulation von Wasseraufbereitungsanlagen. Es besteht aus ca. 65 Java-Klassen und nutzt eine HyperSQL-Datenbank sowie JExcelAPI für Excel-Export.

- **Sprache:** Java (Swing/AWT)
- **Datenbank:** HyperSQL (hsqldb)
- **Excel-Bibliothek:** JExcelAPI (jxl.jar)
- **Zielplattform:** Windows

---

## Ordnerstruktur

```
C:\watkostneu\
├── Quellcode/src/       ← 65 Java-Quelldateien (aktuell, Swing-Version)
├── Watkost4/
│   ├── bin/             ← JAR-Bibliotheken, Icons, Sprachdatei
│   ├── classes/         ← Kompilierte .class-Dateien
│   ├── db/              ← HyperSQL-Datenbankdateien
│   └── Watkost4.exe     ← Startprogramm
├── Passwort4/           ← Passwort-Generator (separates Tool)
├── Watkost-Installation/← Installationspaket
└── watkost-texte/       ← Dokumentation
```

---

## Abhängigkeiten (JAR-Bibliotheken)

| Bibliothek   | Datei                    | Status        | Verwendung              |
|--------------|--------------------------|---------------|-------------------------|
| JExcelAPI    | Watkost4/bin/jxl.jar     | ✅ vorhanden  | Excel-Export/-Import    |
| HyperSQL DB  | Watkost4/bin/hsqldb.jar  | ✅ vorhanden  | Datenbankzugriff        |
| HyperSQL alt | Watkost4/bin/hsql.jar    | ⚠️ leer/unused | nicht benötigt          |

---

## Bekannte Probleme / Offene Punkte

### 1. JDK fehlt (kritisch)
- **Problem:** Nur JRE 1.8.0_241 installiert, kein JDK. `javac` ist nicht verfügbar.
- **Auswirkung:** Quellcode kann nicht neu kompiliert werden.
- **Lösung:** JDK 8 installieren (empfohlen: Adoptium Temurin 8).

### 2. Build-Datei fehlt (wichtig)
- **Problem:** Kein `build.xml` (Ant), `pom.xml` (Maven) oder Gradle-Datei vorhanden.
- **Hintergrund:** Originalprojekt war vermutlich JBuilder (erkennbar an `.dep2`-Dateien).
- **Lösung:** `build.xml` für Apache Ant erstellen mit Classpath für `jxl.jar` und `hsqldb.jar`.

### 3. Ungültiger Import in `data.java` (kritisch für Kompilierung)
- **Datei:** `Quellcode/src/data.java`, Zeile 12
- **Problem:** `import sun.jdbc.odbc.*;` — dieses Paket wurde in Java 8 entfernt.
- **Auswirkung:** Compile-Fehler mit jedem modernen JDK.
- **Lösung:** Zeile 12 in `data.java` entfernen (Import wird im Code nicht genutzt).

### 4. Doppelte Quelldateien im Root-Ordner
- **Dateien:** `analysendialog.java` und `watkostberechnung.java` im Root `C:\watkostneu\`
- **Problem:** Diese sind **ältere AWT-Versionen** und weichen von den Dateien in `Quellcode/src/` ab.
- **Lösung:** Nur `Quellcode/src/` als maßgeblichen Quellcode verwenden; Root-Dateien sind veraltet.

### 5. Ressourcen nicht im Quellcode-Ordner
- **Problem:** `splash.GIF`, Icons und `WtkLg.xls` liegen nur in `Watkost4/bin/`, nicht in `Quellcode/src/`.
- **Auswirkung:** Bei Neuaufbau des Projekts müssen Ressourcen manuell kopiert werden.

---

## Nächste Schritte (priorisiert)

- [ ] JDK 8 (Adoptium Temurin 8) installieren
- [ ] `import sun.jdbc.odbc.*;` aus `Quellcode/src/data.java` Zeile 12 entfernen
- [ ] `build.xml` für Apache Ant erstellen
- [ ] Ressourcen-Dateien in Quellcode-Ordner aufnehmen
- [ ] Veraltete Root-Dateien (`analysendialog.java`, `watkostberechnung.java`) entfernen oder archivieren
- [ ] Git-Repository anlegen für Versionskontrolle

---

## Vorhandene Dokumentation

| Dokument                          | Ort                                      |
|-----------------------------------|------------------------------------------|
| Programmbeschreibung (PDF)        | watkost-texte/InhaltWatkost Ver 4.pdf    |
| Englische Beschreibung            | watkost-texte/english/                   |
| Installationsanleitung            | Watkost4/Readme.txt                      |
| Fehlerprotokoll                   | Watkost-Installation/Watkost4 Fehler.docx|
| Bereitstellungsplan               | Passwort4/Watkost4 Bereitstellung.xls    |
