package fr.afpa.reversi.classe;

import java.util.Scanner;

public class Joueur implements Jouable{
	
	private PlateauDeJeu plateau;
	

	public Joueur(PlateauDeJeu plateau) {
		super();
		this.plateau = plateau;
	}


	@Override
	public int[] jouer() {
		var s = new Scanner(System.in);
		int x;
		int y;
		int[] pos = new int[2];
		System.out.println("ligne ");
		x = s.nextInt();
		System.out.println("colonne ");
		y = s.nextInt();
		pos[0] = x;
		pos[1] = y;
		return pos;
		
		
	}

}
