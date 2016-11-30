# informatik-nrw-q1

Programme für den Informatik-Unterricht in NRW in der Oberstufe (Q1)

## Warum git?

* Code verändert - Mist, Programm kaputt. Gestern hat es doch noch funktioniert....
* Oh, morgen schon wieder ne Doppelstunde... Letztes Jahr hatte ich da doch was...
* So, den Schülern die Vorlage gegeben... Wie war noch mal meine Lösung...
* Hab das Arbeitsblatt von Kollege XY kopiert und leicht angepasst, aber er hat doch jetzt auch schon wieder was verändert...

## HOWTO

### In Eclipse importieren
Import -> Projects from git 

### Paketieren
$ mvn package

Oder in Eclipse: Run As -> Maven build... -> Goals: package

### Damit Arbeiten

Alles in master ändern!!

In den Endversionen steht im Code an den stellen, welche für die Schüler entfernt werden sollen //TODO.
Diese dann rausschmeissen und paketieren
oder halt in den schueler-vorlage branch committen

## TODO
* BlueJ-Projekte erstellen / vorgeben?
* Das PDF kommt nur in das ZIP-File bei 'mvn package', wenn es vorher existierte
Zum reproduzieren: mvn clean && mvn package -> pdfs fehlen 
Workaround: 2 mal 'mvn package' aufrufen
* pom.xml hat festen UNIX-Pfad /tmo/foo eingebaut
* Version.java raus? (steht ja in pom.xml)
* Skript um branch zu wechseln und ant aufzurufen
* Ergebnisse dann nach gh-pages kopieren
* Index der Dateien bauem (mit jekyll?) - https://github.com/recurser/jekyll-plugins/blob/master/generate_projects.rb

## Requirements for deploying
* Für das Erstellen der PDF-Dateien aus den MD-Dateien: gimli ruby gem
