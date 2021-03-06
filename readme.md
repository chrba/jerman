# Jerman - Java in German

Würdest du gerne Programmieren in Java lernen aber du bist in deinem letzten Englischkurs durchgefallen? Jetzt kann auch dir endlich geholfen werden, mit Jerman - Java in German `:-)`

### Wie verwende ich Jerman?

Jerman ist als sbt Plugin implementiert. Um ein Jerman-Programm zu starten, muss auf deinem System sbt in der Version >= 0.13.5 installiert sein.
Du musst nur die folgende zwei Zeilen in deinem sbt Projekt in $PROJECT_ROOT/project/plugins.sbt eintragen und kannst dann mit Jerman loslegen

```
addSbtPlugin("de.jerman" % "jerman" % "1.0.1")
resolvers += Resolver.bintrayRepo("chrba","maven")
```

### Beispiel 

Erstelle eine Beispiel-Jerman-Datei mit der Endung ".jerman" unter src/main/jerman, z.B. Hauptprogramm.jerman mit dem Inhalt

```
öffentliche Klasse Hauptprogramm {
     öffentlich statische Leere haupt(finale Zeichenkette... z) {
           System.aus.druckzl("Hallo, Welt!");

 	       Katze katze = neue Katze();
	       System.aus.druckzl(katze.miau());
     }
}

Klasse Katze {
	 öffentliche Zeichenkette miau() { gibzurück "miau";}
}
```
Starte das Programm mit
```
sbt run
```

Ein Demo Programm in Jerman findest du auch unter https://github.com/chrba/jerman-demo

Das Jerman Programm wird nun zunächst nach Java transpiliert und mit dem Java-Compiler compiliert und dann ausgeführt.



### Jerman Keywords
Alle Keywords sind äquivalent zu Java aber auf deutsch. Einige Keywords können in meheren Varianten verwendet werden, so kann das Keyword "neu" (in der Tabelle angegeben als neu/e/s/r) in den Varianten neu, neue, neues oder neuer verwendet werden.


<table>
<tr><td> abstrakt/e/s/r</td><td> weiter</td><td> für</td><td> neu/e/s/r</td><td> schalte</td></tr>
<tr><td>Bool</td><td> Packet</td><td> synchronisiert/e/s/r</td><td> tue</td><td> wenn</td></tr>
<tr><td>breche</td><td> dann</td><td> privat/e/s/r</td><td> dies</td><td> Dopppelt </td></tr>
<tr><td>implementiert</td><td> geschützt</td><td> werfe</td><td> Fall</td><td> dann </td></tr>
<tr><td>instanzvon</td><td> gibzurück</td><td> vorübergehend</td><td> fang </td><td>neu/e/s/r</td></tr>
<tr><td> erweitert</td><td> Ganzzahl</td><td> kurz</td><td> versuch</td><td> Zeichen </td></tr>
<tr><td>final/e/s/r</td><td> Schnittstelle</td><td> statisch/e/s/r</td><td> Leere</td><td>während</td></tr>
<tr><td>Klasse</td><td> endlich</td><td> Lang</td><td> flüchtig</td><td> Gleitkommazahl</td></tr>
<tr><td>Zeichenkette</td><td>wirf</td><td></td><td></td><td></td></tr>
</table>

### FAQ
* **Kann ich Jerman produktiv einsetzen?**
Es spricht nichts dagegen. Bisher hat allerdings noch niemand gewagt, ein Projekt in Jerman zu schreiben `;-)`

* **Läuft Jerman in meiner IDE?**
Für IntelliJ und Eclipse gibt es ein sbt Plugin. Sobald dies installiert ist, kannst du Jerman in deiner IDE verwenden. Syntax-Highlighting wird allerdings noch nicht unterstützt.

* **Ich habe mein Englisch verbessert. Kann ich statt der Jerman-Keywords die entsprechenden Java-Keywords verwenden?**
Du kannst Jerman und Java beliebig mischen

* **Hat Jerman eine Standard-Bibliothek?**
Nein, du solltest die Java Standard-Bibliothek verwenden.


Viel Spaß beim Programmieren mit Jerman `:-)`
