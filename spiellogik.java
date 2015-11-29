package aufgabeSpiel;
/**
* @author Lino Otolski
*/
public class Spiellogik {
int anzahl;
boolean[] streichhoelzer;
public Spiellogik(int anz) {
this.anzahl = anz;
this.streichhoelzer = new boolean[anzahl];
}
boolean[] spielLogik() {
for (int i = 0; i < streichhoelzer.length; i++) {
streichhoelzer[i] = true;
}
for (int i = 0; i < streichhoelzer.length; i = i + 4) {
streichhoelzer[i] = false;
}
return streichhoelzer;
}
/**
* Getter für Anzahl der Streichhölzer im Array
* @return
*/
public int getAnzahl() {
return anzahl;
}
public boolean[] getStreichhoelzer() {
return streichhoelzer;
}
public void setAnzahl(int anzahl) {
this.anzahl = anzahl;
}
public void setStreichhoelzer(boolean[] streichhoelzer) {
this.streichhoelzer = streichhoelzer;
}
public boolean[] ausgabe() {
for (int j = 0; j < anzahl; j++)
System.out.println("Stelle " + j + " :" + streichhoelzer[j]);
return streichhoelzer;
}
public int size() {
return streichhoelzer.length;
}
}