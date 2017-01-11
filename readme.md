# Jerman - Java in German

Würdest du gerne Programmieren in Java lernen aber du bist in deinem letzten Englischkurs durchgefallen? Jetzt kann auch dir endlich geholfen werden, mit Jerman - Java in German `:-)`

### Wie verwende ich Jerman?

Jerman ist als sbt Plugin implementiert. Du musst also nur die folgende Zeile in deinem sbt Projekt in $PROJECT_ROOT/project/plugins.sbt eintragen und kannst dann mit Jerman loslegen

```
addSbtPlugin("de.jerman" % "jerman" % "2.4")
```
Erstelle eine Jerman-Datei unter src/main/jerman, z.B. Hauptprogramm.jerman mit dem Inhalt

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
sbt ~run
```


### FAQ
* **Kann ich Jerman produktiv einsetzen?**
Es spricht nichts dagegen. Bisher hat allerdings noch niemand gewagt, ein Projekt in Jerman zu schreiben `;-)`

* **Läuft Jerman in meiner IDE?**
Für IntelliJ und Eclipse gibt es ein sbt Plugin. Sobald dies installiert ist, kannst du Jerman in deiner IDE verwenden. Syntax-Highlighting wird allerdings noch nicht unterstützt.

* **Ich habe mein Englisch verbessert. Kann ich statt der Jerman-Keywords die entsprechenden Java-Keywords verwenden?**
Du kannst Jerman und Java beliebig mischen

* **Hat Jerman eine Standard-Bibliothek?**
Nein, du solltest die Java Standard-Bibliothek verwenden.

### Keywords
Alle Keywords sind äquivalent zu Java aber auf deutsch. Einige Keywords können in meheren Varianten verwendet werden, so kann das Keyword "neu" (in der Tabelle angegeben als neu/e/s/r) in den Varianten neu, neue, neues oder neuer verwendet werden.

| | | | ||
|-|-|-|-|-|
| abstrakt/e/s/r| weiter | für | neu/e/s/r | schalte
|Bool| Packet | synchronisiert/e/s/r | tue | wenn
|breche| dann | privat/e/s/r | dies | Dopppelt 
|implementiert | geschützt | werfe | Fall | dann 
|instanzvon | gibzurück | vorübergehend | fange 
| erweitert | Ganzzahl | kurz | versuche | Zeichen 
|final/e/s/r| Schnittstelle | statisch/e/s/r | Leere
|Klasse | endlich | Lang | flüchtig | Gleitkommazahl
| super | während | neu/e/s/r

