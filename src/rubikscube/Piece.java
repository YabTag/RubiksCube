package rubikscube;

import java.awt.Color;



public class Piece {
	public final static Color[] COULEURS ={Color.RED,Color.ORANGE,Color.BLUE,Color.GREEN,Color.YELLOW,Color.WHITE};
	
	
	

}

//class Interieur extends Piece{
//	
//}


class Centre extends Piece{
	private Color couleur;
	
	public Centre(int n){
		this.couleur=COULEURS[n];
	}
	public Color getCouleurCentre(){
		return couleur;
	}
}

