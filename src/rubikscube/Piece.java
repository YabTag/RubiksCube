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

class facette extends Piece{
	private Color couleur;
	private Centre centre;
	public Color getCouleur(){
		return couleur;
	}
	public void changerCouleur(int i){
		couleur= COULEURS[i];
	}
}
class Arete {
	private facette[] facettes= new facette[2];
	
	public Color[] getCouleursArete(){
		return couleurs;
	}
}


class Coin extends Piece{
	private Color[] couleurs = new Color[3];
	public Coin(int i,int j,int k){
		couleurs[1]=COULEURS[i];
		couleurs[2]=COULEURS[j];
		couleurs[3]=COULEURS[k];
	}
	public Color[] getCouleursCoin(){
		return couleurs;
	}
}

