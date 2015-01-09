package rubikscube;




public class Rubiks {
	
	private Piece[][][] matrice = new Piece[3][3][3];
	
	public void setRubiks(){
		//Interieur*1
		matrice[0][0][0]= new Piece();
		//6 Centres qui restent invariables
		matrice[1][0][0]= new Centre(0);
		matrice[2][0][0]= new Centre(1);
		matrice[0][1][0]= new Centre(2);
		matrice[0][2][0]= new Centre(3);
		matrice[0][0][1]= new Centre(4);
		matrice[0][0][2]= new Centre(5);
		// Arete * 12
		matrice[1][1][0]= new Arete(0,2);
		matrice[1][2][0]= new Arete(0,3);
		matrice[2][1][0]= new Arete(1,2);
		matrice[2][2][0]= new Arete(1,3);
		matrice[0][1][1]= new Arete(2,4);
		matrice[0][1][2]= new Arete(2,5);
		matrice[0][2][1]= new Arete(3,4);
		matrice[0][2][2]= new Arete(3,5);
		matrice[1][0][1]= new Arete(0,4);
		matrice[1][0][2]= new Arete(0,5);
		matrice[2][0][1]= new Arete(1,4);
		matrice[2][0][2]= new Arete(1,5);
		// Coin * 8
		matrice[1][1][1]= new Coin(0,2,4);
		matrice[1][1][2]= new Coin(0,2,5);
		matrice[1][2][1]= new Coin(0,3,4);
		matrice[1][2][2]= new Coin(0,3,5);
		matrice[2][1][1]= new Coin(1,2,4);
		matrice[2][1][2]= new Coin(1,2,5);
		matrice[2][2][1]= new Coin(1,3,4);
		matrice[2][2][2]= new Coin(1,3,5);
	}
	
	public Piece[][][] getRubiks(){
		return matrice;
	}
	
	
	
}
