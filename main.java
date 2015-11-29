package aufgabeSpiel;
/**
* @author Lino Otolski
*/
import java.util.Scanner;//importiere Java Klassen
import java.lang.*;
public class MeineMain {
public static void main(String[] args) {
System.out.println("Mit wie vielen Streichh�lzern m�chten Sie spielen?");
Scanner sc = new Scanner(System.in); //Nutzereingabe �ber die Anzahl der Streichh�lzer
int eingabe = sc.nextInt(); //�bertragen der Eingabe in die Variable "eingabe"
Spiellogik a = new Spiellogik(eingabe); //Erstellen des Objekts "Spiellogik"
a.spielLogik();
// a.ausgabe();
System.out.println("Sie haben " + eingabe + " Streichh�lzer im Spiel");
int nehmen;
int tmp = eingabe;
/**
* Starten der do schleife f�r den Spielablauf
*/
do {
System.out.println("Wie viele Streichh�lzer m�chten Sie wegnehmen?");
nehmen = sc.nextInt();
while (nehmen > 3) { //Pr�fen, ob der Spieler mehr als die erlaubten 3 Streichh�lzer nimmt
System.out.println("Sie d�rfen nur maximal 3 Streichh�lzer ziehen");
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
* Reduzieren der Streichh�lzer um die Eingabe
*/
tmp -= nehmen;
a = new Spiellogik(tmp);
a.spielLogik();
// a.ausgabe();
/**
* Zug des Computers
*/
int computernehmen = 0;
if (a.getStreichhoelzer()[tmp - 1] == false) { //Pr�fen, ob der Computer eine Gewinnstrategie hat
System.out.println("Guter Zug!");
int spielzugAnzahl = (int) (Math.random() * 3 + 1); //Wenn der Computer keine
Gewinnstrategie hat, Random aus 3
computernehmen = spielzugAnzahl;
if (tmp == 1) {
System.out.println("Spielende - Sie haben gewonnen1");
break;
}
} else { //Wenn der Computer eine Gewinnstrategie hat, wird das Array bis zum n�chsten false
reduziert
for (int j = a.size() - 1; a.getStreichhoelzer()[j] == true; j--) {
computernehmen++;
}
}
tmp -= computernehmen;
a = new Spiellogik(tmp);//Aktualisieren des Arrays mit der Anzahl der Streichh�lzer
a.spielLogik();
System.out.println("Computer nimmt " + computernehmen
+ " Streichh�lzer");
// a.ausgabe();
if (tmp == 1) {
System.out.println("Spielende - Sie haben verloren");
break;
}
System.out.println("Es sind nur noch " + tmp
+ " Streichh�lzer vorhanden");
} while (tmp > 0);
sc.close();
}
}

