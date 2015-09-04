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
Run As -> Maven build... -> Goals: package

## TODO
* Version.java raus? (steht ja in pom.xml)
* Bug: Packaging includes the pdf only if it already exits. Need to run package 2 times
* To reproduce: mvn clean && mvn package -> docs missing 

* Deploy:

https://maven.apache.org/plugins/maven-assembly-plugin/advanced-module-set-topics.html

  * Skript um branch zu wechseln und ant aufzurufen
  * Ergebnisse dann nach gh-pages kopieren
  * Index der Dateien bauem (mit jekyll?) - https://github.com/recurser/jekyll-plugins/blob/master/generate_projects.rb

## Requirements for deploying
* gimli ruby gem
