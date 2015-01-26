
import javax.swing.JFrame;

import rubikscube.*;
import affichage.*;


public class Solution {

	public static void main(String[] args) {
		
	
		
		
		Rubiks rc = new Rubiks();
		Rubiks r = new Rubiks();
		
		rc.turnFace(4, 2);
		rc.turnFace(5, 1);
	    
	    IDA id = new IDA(rc, 2, r , new List_Rubiks(rc, null));
		List_Rubiks l = new List_Rubiks(rc, null);
		List_Rubiks l1 = id.ida(rc, l, 1);
		Rubiks a = l1.head;
		
		
		RubiksGUI graphe = new RubiksGUI( a);

		
		
		
		
	}

}