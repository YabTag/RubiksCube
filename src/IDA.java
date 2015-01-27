import javax.swing.JFrame;

import rubikscube.*;
import affichage.*;



public class IDA {
	Rubiks rc;
	int t;
	Rubiks rcOrdonne; // un rubiks cube ordonne pour faire nos comparaisons directement..
	List_Rubiks resultat;
	
	public IDA (Rubiks r, int j, Rubiks r1, List_Rubiks res){
		rc = r;
		t = j;
		rcOrdonne = r1;
		resultat = res;
	}
	public List_Rubiks ida(Rubiks rc, List_Rubiks l, int n) {
		// n désigne la longueur de la liste
		if (n < t ) {
			int quitter = 1;
			for(int k = 0; k <= 5; k++){
				for(int j = 1; j <= 3; j++){
					Rubiks rcAux = new Rubiks();
					rcAux.copier(rc);
					rcAux.turnFace(k, j);
					List_Rubiks l1 = new List_Rubiks(rcAux, l);
					if (rcAux.equals(rcOrdonne)) 
					{quitter = -1;
					resultat = l1;
					break;
					}
					else {
						if (!(l.is_there(l,rcAux))) {
							ida(rcAux, l1, n+1);
					}
						
						
					}
				}
				
			if (quitter == -1) break;
			}
		}
		return resultat;
		
		}
		
		
}


