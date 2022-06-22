package fr.afpa.reversi.classe;

import java.util.Random;
import java.util.Scanner;

public class Ordinateur implements Jouable{
	private PlateauDeJeu plateau;
	
	public Ordinateur(PlateauDeJeu plateau) {
		super();
		this.plateau = plateau;
	}

	@Override
	public int[] jouer() {
		var rand = new Random();
		int x;
		int y;
		int[] pos = new int[2];
		System.out.println("ligne ");
		x = rand.nextInt(plateau.getPlateau().length ) + 1;
		System.out.println("colonne ");
		y = rand.nextInt(plateau.getPlateau().length) + 1;
		pos[0] = x;
		pos[1] = y;
		return pos;
		
	}

}
