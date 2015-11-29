package Streichholz;

public class computer {
	int streichhoelzer;
	int spielzugComputer;
	
	public computer(int streichhoelzer, int spielzugcomputer){
		this.streichhoelzer = streichhoelzer;
		this.spielzugComputer = spielzugComputer;
	}

	public int getStreichhoelzer() {
		return streichhoelzer;
	}

	public int getSpielzugComputer() {
		return spielzugComputer;
	}

	public void setStreichhoelzer(int streichhoelzer) {
		this.streichhoelzer = streichhoelzer;
	}

	public void setSpielzugComputer(int spielzugComputer) {
		this.spielzugComputer = spielzugComputer;
	}
}
