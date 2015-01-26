import javax.swing.JFrame;

import rubikscube.*;
import affichage.*;



public class List_Rubiks {
	Rubiks head;
	List_Rubiks tail;
	
	public List_Rubiks(Rubiks h, List_Rubiks l){
		head = h;
		tail = l;
	}
	
	public boolean is_there(List_Rubiks l, Rubiks rubiks) {
		if (l == null) return false;
		else {
			if (rubiks.equals(l.head)) return true;
			else is_there(l.tail, rubiks);
		}
		return false;
	}

}
