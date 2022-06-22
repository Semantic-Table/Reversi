package fr.afpa.reversi.classe;

import java.util.Arrays;
import java.util.Iterator;

import fr.afpa.reversi.enumeration.Etat;

public class PlateauDeJeu {
	private char[][] plateau = new char[8][8];
	private int nbTours;
	private int blanc;
	private int noir;
	private boolean tour;

	public PlateauDeJeu() {
		nbTours = 59;
		for (char[] cs : plateau) {
			Arrays.fill(cs, '·');
		}
		plateau[3][4] = '•';
		plateau[4][3] = '•';
		plateau[3][3] = '◦';
		plateau[4][4] = '◦';
	}

	public void afficherPlateau() {
		System.out.print("  ");
		for (int i = 0; i < plateau.length; i++) {
			System.out.print(i + 1 + " ");

		}
		System.out.println();
		for (int i = 0; i < plateau.length; i++) {
			System.out.print(i + 1 + " ");
			for (int j = 0; j < plateau.length; j++) {
				System.out.print(plateau[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void afficherScore() {
		this.noir = 0;
		this.blanc = 0;
		for (char[] cs : plateau) {
			for (char c : cs) {
				if (c == '•')
					this.noir++;
				if (c == '◦')
					this.blanc++;
			}
		}
		System.out.println(this.noir + " •");
		System.out.println(this.blanc + " ◦");
	}

	public void setPlateau(int x, int y) throws MissposeException, OccupiedException {
		char couleur;
		if (this.tour) {
			couleur = '◦';
		} else {
			couleur = '•';
		}
		if (plateau[y][x] == '·') {
			plateau[y][x] = couleur;
			this.miseAJour(x, y);
		} else {
			throw new OccupiedException("La place est deja prise !");
		}
		
		
	}
	
	public void correction(int x,int y) {
		plateau[y][x] = '·';
	}

	public void autrePion() {
		tour = !tour;
	}

	public void miseAJour(int x, int y) throws MissposeException {
		
		boolean trou = false;
		boolean ami = false;
		boolean reussite = false;
		int xi = x;
		int yi = y;
		int cptnmy=0;
		// droite
		try {
			while (!trou && !ami) {
				xi++;
				if (this.plateau[yi][xi] == '·') {
					trou = true;
				} else if (this.plateau[yi][xi] == this.plateau[y][x]) {
					ami = true;
				} else {
					cptnmy++;
				}

			}
			if (ami == true && trou == false && cptnmy > 0) {
				reussite = true;
				for (int i = x; i < xi; i++) {
					this.plateau[y][i] = this.plateau[y][x];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}

		// gauche

		trou = false;
		ami = false;
		xi = x;
		yi = y;
		cptnmy=0;
		try {
			while (!trou && !ami) {
				xi--;
				if (this.plateau[yi][xi] == '·') {
					trou = true;
				} else if (this.plateau[yi][xi] == this.plateau[y][x]) {
					ami = true;
				}else {
					cptnmy++;
				}

			}
			if (ami == true && trou == false && cptnmy > 0) {
				reussite = true;
				for (int i = x; i > xi; i--) {
					this.plateau[y][i] = this.plateau[y][x];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		// bas
		trou = false;
		ami = false;
		xi = x;
		yi = y;
		cptnmy=0;
		try {
			while (!trou && !ami) {
				yi++;
				if (this.plateau[yi][xi] == '·') {
					trou = true;
				} else if (this.plateau[yi][xi] == this.plateau[y][x]) {
					ami = true;
				}else {
					cptnmy++;
				}

			}
			if (ami == true && trou == false && cptnmy > 0) {
				reussite = true;
				for (int i = y; i < yi; i++) {
					this.plateau[i][x] = this.plateau[y][x];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		// haut
		trou = false;
		ami = false;
		xi = x;
		yi = y;
		cptnmy=0;
		try {
			while (!trou && !ami) {
				yi--;
				if (this.plateau[yi][xi] == '·') {
					trou = true;
				} else if (this.plateau[yi][xi] == this.plateau[y][x]) {
					ami = true;
				}else {
					cptnmy++;
				}

			}
			if (ami == true && trou == false && cptnmy > 0) {
				reussite = true;
				for (int i = y; i > yi; i--) {
					this.plateau[i][x] = this.plateau[y][x];
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		// haut-gauche
		trou = false;
		ami = false;
		xi = x;
		yi = y;
		int cpt = 0;
		cptnmy=0;
		try {
			while (!trou && !ami) {
				yi--;
				xi--;
				if (this.plateau[yi][xi] == '·') {
					trou = true;
				} else if (this.plateau[yi][xi] == this.plateau[y][x]) {
					ami = true;
				}else {
					cptnmy++;
				}

			}
			if (ami == true && trou == false && cptnmy > 0) {
				reussite = true;
				for (int i = y; i > yi; i--) {
					this.plateau[i][x + cpt] = this.plateau[yi][xi];
					cpt--;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		// haut-droite
		trou = false;
		ami = false;
		xi = x;
		yi = y;
		cpt = 0;
		cptnmy=0;
		try {
			while (!trou && !ami) {
				yi--;
				xi++;
				if (this.plateau[yi][xi] == '·') {
					trou = true;
				} else if (this.plateau[yi][xi] == this.plateau[y][x]) {
					ami = true;
				}else {
					cptnmy++;
				}

			}
			if (ami == true && trou == false && cptnmy > 0) {
				reussite = true;
				for (int i = y; i > yi; i--) {
					this.plateau[i][x + cpt] = this.plateau[y][x];
					cpt++;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		// bas-droit
		trou = false;
		ami = false;
		xi = x;
		yi = y;
		cpt = 0;
		cptnmy=0;
		try {
			while (!trou && !ami) {
				yi++;
				xi++;
				if (this.plateau[yi][xi] == '·') {
					trou = true;
				} else if (this.plateau[yi][xi] == this.plateau[y][x]) {
					ami = true;
				}else {
					cptnmy++;
				}

			}
			if (ami == true && trou == false && cptnmy > 0) {
				reussite = true;
				for (int i = y; i < yi; i++) {
					this.plateau[i][x + cpt] = this.plateau[y][x];
					cpt++;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		// bas-gauche
		trou = false;
		ami = false;
		xi = x;
		yi = y;
		cpt = 0;
		cptnmy=0;
		try {
			while (!trou && !ami) {
				yi++;
				xi--;
				if (this.plateau[yi][xi] == '·') {
					trou = true;
				} else if (this.plateau[yi][xi] == this.plateau[y][x]) {
					ami = true;
				}else {
					cptnmy++;
				}

			}
			if (ami == true && trou == false && cptnmy > 0) {
				reussite = true;
				for (int i = y; i < yi; i++) {
					this.plateau[i][x + cpt] = this.plateau[y][x];
					cpt--;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		if (!reussite) {
			throw new MissposeException("La case n'est pas valide, réessayez.");
		}

	}

	// getter/setter
	public char[][] getPlateau() {
		return plateau;
	}

	public void setPlateau(char[][] plateau) {
		this.plateau = plateau;
	}

	public int getNbTours() {
		return nbTours;
	}

	public void setNbTours(int nbTours) {
		this.nbTours = nbTours;
	}

	public int getBlanc() {
		return blanc;
	}

	public void setBlanc(int blanc) {
		this.blanc = blanc;
	}

	public int getNoir() {
		return noir;
	}

	public void setNoir(int noir) {
		this.noir = noir;
	}

	public boolean isTour() {
		return tour;
	}

	public void setTour(boolean tour) {
		this.tour = tour;
	}

}
