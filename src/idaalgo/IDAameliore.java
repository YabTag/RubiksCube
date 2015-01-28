package idaalgo;

import javax.swing.JFrame;

import rubikscube.*;
import affichage.*;


public class IDAameliore {
	Rubiks rc;
	int t;
	Rubiks rcOrdonne; // un rubiks cube ordonne pour faire nos comparaisons directement..
	List_Rubiks resultat;
	
	public IDAameliore (Rubiks r, int j, Rubiks r1, List_Rubiks res){
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
							MinCoup m = new MinCoup(rcAux);
							int min = m.minCoupGlobal(m);
							if ((n + min) <= t ) ida(rcAux, l1, n+1);
					}
						
						
					}
				}
				
			if (quitter == -1) break;
			}
		}
		return resultat;
		
		}
		
	
	public List_Rubiks idA(Rubiks rc) {
		while(!resultat.head.equals(rcOrdonne)){
			t ++;
			ida(rc, new List_Rubiks(rc, null), 0);
		}
		return resultat;
	}
		
}


		


