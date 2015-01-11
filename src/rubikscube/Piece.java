package rubikscube;

import java.awt.Color;



public class Piece {
	public final static Color[] COULEURS ={Color.RED,Color.ORANGE,Color.BLUE,Color.GREEN,Color.WHITE,Color.YELLOW};
	
//	private int Up;
//	
//	private int Down;
//	
//	private int Right;
//	
//	private int Left;
//	
//	private int Front;
//	
//	private int Back;
	
	//tableau à 6 entrées représentant les orientation d'une piece de RubiksCube {Up,Down,Right,Left,Back,Front}
	private int[] Orientation = new int[6];
	
	public Piece(int Up, int Down, int Right, int Left, int Back, int Front){
		Orientation[0]=Up;
		Orientation[1]=Down;
		Orientation[2]=Right;
		Orientation[3]=Left;
		Orientation[4]=Back;
		Orientation[5]=Front;
		
	}
	
	public boolean equals(Object piece){
		if(piece==null){
			return false;
		}else if( piece.getClass() != getClass()){
			return false;
		}else{
			Piece p=(Piece) piece;
			for(int i=0; i<6; ++i){
				if( (Orientation[i] ==-1 && !p.getColor(i).equals(null) ) || !COULEURS[Orientation[i]].equals(p.getColor(i)) ) {
					return false;
				}
			}
			return true;
		}
	}
	
	public Color getColor(int i){
		int o= Orientation[i];
		if(o==-1){
			return null;
		}else{
			return COULEURS[o];
		}
	}
	
	public void permuteColor(int i,int j){
		int aux=Orientation[i];
		Orientation[i]=Orientation[j];
		Orientation[j]=aux;
	}
	
	
}