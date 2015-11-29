package Streichholz;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[] logik = new boolean[17];
		logik[0] = false;
		logik[1] = true;
		logik[2] = true;

		int i = 2;
		do {
			i = i + 1;
			if (logik[i - 3] == true && logik[i - 2] == true
					&& logik[i - 1] == true) {
				logik[i] = false;
			} else {
				logik[i] = true;
			}
		} while (i < 16);

		//Ausgabe Array
		for (int j = 0; j < 17; j++)
			System.out.println("Stelle " + j + " :" + logik[j]);

	}

}
