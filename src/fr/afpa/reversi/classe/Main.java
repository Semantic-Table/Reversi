package fr.afpa.reversi.classe;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		var s = new Scanner(System.in);
		int choixMenu;

		// menu

		System.out.println("Bienvenue dans le jeu du Reversi");
		System.out.println("1-Jouer contre l'ordinateur");
		System.out.println("2-Jouer contre un ami");
		System.out.println("3-Regarder deux ordinateur");
		choixMenu = s.nextInt();

		// mise en place du jeu.
		var plateau = new PlateauDeJeu();
		int x;
		int y;
		if (choixMenu == 1) {

			var joueur1 = new Joueur(plateau);
			int[] posj1 = new int[2];
			var ordinateur1 = new Ordinateur(plateau);
			int[] poso1 = new int[2];

			while (plateau.getNbTours() > 0 || plateau.getBlanc() == 0 || plateau.getNoir() == 0) {
				plateau.afficherScore();
				plateau.afficherPlateau();
				if (plateau.isTour()) {
					posj1 = joueur1.jouer();
					x = posj1[0];
					y = posj1[1];
				} else {
					poso1 = ordinateur1.jouer();
					x = poso1[0];
					y = poso1[1];
				}

				try {
					plateau.setPlateau(x - 1, y - 1);
					plateau.setNbTours(plateau.getNbTours() - 1);
					plateau.autrePion();
				} catch (MissposeException e) {
					System.err.println(e.getMessage());
					plateau.correction(x - 1, y - 1);
				} catch (OccupiedException e) {
					System.out.println(e.getMessage());
				}

			}
		} else if (choixMenu == 2) {

			var joueur1 = new Joueur(plateau);
			int[] posj1 = new int[2];
			var joueur2 = new Joueur(plateau);
			int[] posj2 = new int[2];

			while (plateau.getNbTours() > 0 || plateau.getBlanc() == 0 || plateau.getNoir() == 0) {
				plateau.afficherScore();
				plateau.afficherPlateau();
				if (plateau.isTour()) {
					posj1 = joueur1.jouer();
					x = posj1[0];
					y = posj1[1];
				} else {
					posj2 = joueur2.jouer();
					x = posj2[0];
					y = posj2[1];
				}
				try {
					plateau.setPlateau(x - 1, y - 1);
					plateau.setNbTours(plateau.getNbTours() - 1);
					plateau.autrePion();
				} catch (MissposeException e) {
					System.err.println(e.getMessage());
					plateau.correction(x - 1, y - 1);
				} catch (OccupiedException e) {
					System.out.println(e.getMessage());
				}

			}
		} else if (choixMenu == 3) {
			var ordinateur2 = new Ordinateur(plateau);
			int[] poso2 = new int[2];
			var ordinateur1 = new Ordinateur(plateau);
			int[] poso1 = new int[2];

			while (plateau.getNbTours() > 0 || plateau.getBlanc() == 0 || plateau.getNoir() == 0) {
				plateau.afficherScore();
				plateau.afficherPlateau();
				if (plateau.isTour()) {
					poso2 = ordinateur2.jouer();
					x = poso2[0];
					y = poso2[1];
				} else {
					poso1 = ordinateur1.jouer();
					x = poso1[0];
					y = poso1[1];
				}

				try {
					plateau.setPlateau(x - 1, y - 1);
					plateau.setNbTours(plateau.getNbTours() - 1);
					plateau.autrePion();
				} catch (MissposeException e) {
					System.err.println(e.getMessage());
					plateau.correction(x - 1, y - 1);
				} catch (OccupiedException e) {
					System.out.println(e.getMessage());
				}

			}
		}
		if (plateau.getNoir() == plateau.getBlanc()) {
			System.out.println("égalité !");
		} else if (plateau.getNoir() > plateau.getBlanc()) {
			System.out.println("les noirs ont gagné !");
		} else {
			System.out.println("les blancs ont gagné !");
		}
	}

}
