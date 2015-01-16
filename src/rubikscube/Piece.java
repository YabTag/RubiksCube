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
	public int[] Orientation = new int[6];
	
	public Piece(int Up, int Down, int Right, int Left, int Back, int Front){
		Orientation[0]=Up;
		Orientation[1]=Down;
		Orientation[2]=Right;
		Orientation[3]=Left;
		Orientation[4]=Back;
		Orientation[5]=Front;
		
	}
	//Constructeur de copie
	public Piece(Piece piece){
		for(int i=0;i<6;++i){
			Orientation[i]=piece.Orientation[i];
		}
	}
	
	
	
	//redefinition de la méthode equals pour la classe Piece
	public boolean equals(Object piece){
		if(piece==null){
			return false;
		}else if( piece.getClass() != getClass()){
			return false;
		}else{
			Piece p=(Piece) piece;
			for(int i=0; i<6; ++i){
				if( Orientation[i] != p.Orientation[i] ) {
					return false;
				}
			}
			return true;
		}
	}
	public void copier(Piece piece){
		for(int i=0;i<6;++i){
			Orientation[i]=piece.Orientation[i];
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
	public void permuteColor(int i, int j, int k){
		int aux=Orientation[i];
		Orientation[i]=Orientation[k];
		Orientation[k]=Orientation[j];
		Orientation[j]=aux;
	}
	
	
	public String toString(){
		String x="";
		for(int i=0;i<6;++i){
			
			x+="couleur "+ i +"  "+getColor(i)+"  ";
		}
		
		return x;
	}
	
}