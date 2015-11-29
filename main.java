package aufgabeSpiel;
/**
* @author Lino Otolski
*/
import java.util.Scanner;//importiere Java Klassen
import java.lang.*;
public class MeineMain {
public static void main(String[] args) {
System.out.println("Mit wie vielen Streichhölzern möchten Sie spielen?");
Scanner sc = new Scanner(System.in); //Nutzereingabe über die Anzahl der Streichhölzer
int eingabe = sc.nextInt(); //Übertragen der Eingabe in die Variable "eingabe"
Spiellogik a = new Spiellogik(eingabe); //Erstellen des Objekts "Spiellogik"
a.spielLogik();
// a.ausgabe();
System.out.println("Sie haben " + eingabe + " Streichhölzer im Spiel");
int nehmen;
int tmp = eingabe;
/**
* Starten der do schleife für den Spielablauf
*/
do {
System.out.println("Wie viele Streichhölzer möchten Sie wegnehmen?");
nehmen = sc.nextInt();
while (nehmen > 3) { //Prüfen, ob der Spieler mehr als die erlaubten 3 Streichhölzer nimmt
System.out.println("Sie dürfen nur maximal 3 Streichhölzer ziehen");
nehmen = sc.nextInt();
}
/**
* Abfrage, ob nach dem Zug des Spielers nur noch 1 Streichholz vorhanden ist. Wenn ja, Spiel
gewonnen.
*/
if (tmp == 1) {
System.out.println("Spielende - Sie haben gewonnen");
break;
}
/**
* Abfrage, ob nach dem Zug des Spielers kein Streichholz mehr vorhanden ist. Wenn ja, Spiel
verloren.
*/
if (tmp == 0) {
System.out.println("Verloren");
break;
}
/**
* Reduzieren der Streichhölzer um die Eingabe
*/
tmp -= nehmen;
a = new Spiellogik(tmp);
a.spielLogik();
// a.ausgabe();
/**
* Zug des Computers
*/
int computernehmen = 0;
if (a.getStreichhoelzer()[tmp - 1] == false) { //Prüfen, ob der Computer eine Gewinnstrategie hat
System.out.println("Guter Zug!");
int spielzugAnzahl = (int) (Math.random() * 3 + 1); //Wenn der Computer keine
Gewinnstrategie hat, Random aus 3
computernehmen = spielzugAnzahl;
if (tmp == 1) {
System.out.println("Spielende - Sie haben gewonnen1");
break;
}
} else { //Wenn der Computer eine Gewinnstrategie hat, wird das Array bis zum nächsten false
reduziert
for (int j = a.size() - 1; a.getStreichhoelzer()[j] == true; j--) {
computernehmen++;
}
}
tmp -= computernehmen;
a = new Spiellogik(tmp);//Aktualisieren des Arrays mit der Anzahl der Streichhölzer
a.spielLogik();
System.out.println("Computer nimmt " + computernehmen
+ " Streichhölzer");
// a.ausgabe();
if (tmp == 1) {
System.out.println("Spielende - Sie haben verloren");
break;
}
System.out.println("Es sind nur noch " + tmp
+ " Streichhölzer vorhanden");
} while (tmp > 0);
sc.close();
}
}

