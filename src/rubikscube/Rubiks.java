package rubikscube;




public class Rubiks {
	
	private Piece[][][] matrice = new Piece[3][3][3];
	
	public void setRubiks(){
		//Interieur*1
		matrice[0][0][0]= new Piece(-1,-1,-1,-1,-1,-1);
		//6 Centres qui restent invariables
		matrice[1][0][0]= new Piece(0,-1,-1,-1,-1,-1);
		matrice[2][0][0]= new Piece(-1,1,-1,-1,-1,-1);
		matrice[0][1][0]= new Piece(-1,-1,2,-1,-1,-1);
		matrice[0][2][0]= new Piece(-1,-1,-1,3,-1,-1);
		matrice[0][0][1]= new Piece(-1,-1,-1,-1,4,-1);
		matrice[0][0][2]= new Piece(-1,-1,-1,-1,-1,5);
		// Arete * 12
		matrice[1][1][0]= new Piece(0,-1,2,-1,-1,-1);
		matrice[1][2][0]= new Piece(0,-1,-1,3,-1,-1);
		matrice[2][1][0]= new Piece(-1,1,2,-1,-1,-1);
		matrice[2][2][0]= new Piece(-1,1,-1,3,-1,-1);
		matrice[0][1][1]= new Piece(-1,-1,2,-1,4,-1);
		matrice[0][1][2]= new Piece(-1,-1,2,-1,-1,5);
		matrice[0][2][1]= new Piece(-1,-1,-1,3,4,-1);
		matrice[0][2][2]= new Piece(-1,-1,-1,3,-1,5);
		matrice[1][0][1]= new Piece(0,-1,-1,-1,4,-1);
		matrice[1][0][2]= new Piece(0,-1,-1,-1,-1,5);
		matrice[2][0][1]= new Piece(-1,1,-1,-1,4,-1);
		matrice[2][0][2]= new Piece(-1,1,-1,-1,-1,5);
		// Coin * 8
		matrice[1][1][1]= new Piece(0,-1,2,-1,4,-1);
		matrice[1][1][2]= new Piece(0,-1,2,-1,-1,5);
		matrice[1][2][1]= new Piece(0,-1,-1,3,4,-1);
		matrice[1][2][2]= new Piece(0,-1,-1,3,-1,5);
		matrice[2][1][1]= new Piece(-1,1,2,-1,4,-1);
		matrice[2][1][2]= new Piece(-1,1,2,-1,-1,5);
		matrice[2][2][1]= new Piece(-1,1,-1,3,4,-1);
		matrice[2][2][2]= new Piece(-1,1,-1,3,-1,5);
	}
	
	
	public Rubiks(){
		setRubiks();
	}
	
	
	public Piece[][][] getRubiks(){
		return matrice;
	}
	
	public Piece[][] getFace(int i){
		int p= i-i%2;
		Piece[][] face=new Piece[3][3];
		for(int j=0;j<3;++j){
			for(int k=0;k<3;++k){
				if(p==0){
					face[j][k]=matrice[i%2+1][j][k];
				}else if(p==2){
					face[j][k]=matrice[k][i%2+1][j];
				}else{
					face[j][k]=matrice[j][k][i%2+1];
				}
			}
		}
		
		return face;
		
		
	}
	
	public void turnFace(int i,int degree){
		
		if(degree==1){
			
			int p = i-i%2; // prendre le nombre pair le plus proche de i inferieurement.
			//définir les axes pour les quels la couleur doit permutter
			int axe1= (p+2)%6 ;
			int axe2= (p+4)%6 ;
			
			if(p==0){
				
				
				matrice[i%2+1][1][1].permuteColor(2,4,3);
				matrice[i%2+1][2][1].permuteColor(4,3,5);
				matrice[i%2+1][2][2].permuteColor(3,5,2);
				matrice[i%2+1][1][2].permuteColor(5,2,4);
				Piece aux= matrice[i%2+1][1][1];
				
				matrice[i%2+1][1][1]=matrice[i%2+1][1][2];
				matrice[i%2+1][1][2]=matrice[i%2+1][2][2];
				matrice[i%2+1][2][2]=matrice[i%2+1][2][1];
				matrice[i%2+1][2][1]=aux;
				
				
				
				matrice[i%2+1][1][0].permuteColor(2,4);
				matrice[i%2+1][0][1].permuteColor(4,3);
				matrice[i%2+1][2][0].permuteColor(3,5);
				matrice[i%2+1][0][2].permuteColor(5,2);
				aux=matrice[i%2+1][1][0];
				matrice[i%2+1][1][0]=matrice[i%2+1][0][2];
				matrice[i%2+1][0][2]=matrice[i%2+1][2][0];
				matrice[i%2+1][2][0]=matrice[i%2+1][0][1];
				matrice[i%2+1][0][1]=aux;
				
				
			}else if(p==2){
				
				
				matrice[1][i%2+1][1].permuteColor(0,4,1);
				matrice[2][i%2+1][1].permuteColor(4,1,5);
				matrice[1][i%2+1][2].permuteColor(5,0,4);
				matrice[2][i%2+1][2].permuteColor(1,5,0);
				Piece aux= matrice[1][i%2+1][1];
				
				matrice[1][i%2+1][1]=matrice[1][i%2+1][2];
				matrice[1][i%2+1][2]=matrice[2][i%2+1][2];
				matrice[2][i%2+1][2]=matrice[2][i%2+1][1];
				matrice[2][i%2+1][1]=aux;
				
				
				
				matrice[1][i%2+1][0].permuteColor(0,4);
				matrice[i%2+1][i%2+1][1].permuteColor(4,3);
				matrice[i%2+1][i%2+1][0].permuteColor(3,5);
				matrice[i%2+1][i%2+1][2].permuteColor(5,2);
				aux=matrice[1][i%2+1][0];
				matrice[1][i%2+1][0]=matrice[0][i%2+1][2];
				matrice[0][i%2+1][2]=matrice[2][i%2+1][0];
				matrice[2][i%2+1][0]=matrice[0][i%2+1][1];
				matrice[0][i%2+1][1]=aux;
				
			}else{
				
				
				matrice[i%2+1][i%2+1][i%2+1].permuteColor(2,4,3);
				matrice[i%2+1][2][i%2+1].permuteColor(4,3,5);
				matrice[i%2+1][2][i%2+1].permuteColor(3,5,2);
				matrice[i%2+1][1][i%2+1].permuteColor(5,2,4);
				Piece aux= matrice[i%2+1][1][i%2+1];
				
				matrice[i%2+1][1][i%2+1]=matrice[i%2+1][1][i%2+1];
				matrice[i%2+1][1][i%2+1]=matrice[i%2+1][2][i%2+1];
				matrice[i%2+1][2][i%2+1]=matrice[i%2+1][2][i%2+1];
				matrice[i%2+1][2][i%2+1]=aux;
				
				
				
				matrice[i%2+1][1][i%2+1].permuteColor(2,4);
				matrice[i%2+1][0][i%2+1].permuteColor(4,3);
				matrice[i%2+1][2][i%2+1].permuteColor(3,5);
				matrice[i%2+1][0][i%2+1].permuteColor(5,2);
				aux=matrice[i%2+1][1][i%2+1];
				matrice[i%2+1][1][i%2+1]=matrice[i%2+1][0][i%2+1];
				matrice[i%2+1][0][i%2+1]=matrice[i%2+1][2][i%2+1];
				matrice[i%2+1][2][i%2+1]=matrice[i%2+1][0][i%2+1];
				matrice[i%2+1][0][i%2+1]=aux;
				
			}
			
			
		}else if(degree==2){
			turnFace(i,1);
			turnFace(i,1);
		}else if(degree==3){
			turnFace(i,2);
			turnFace(i,1);
		}
		
		
	}
	
}
