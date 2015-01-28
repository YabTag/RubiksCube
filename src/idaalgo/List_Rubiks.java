package idaalgo;

import javax.swing.JFrame;

import rubikscube.*;
import affichage.*;



public class List_Rubiks {
	public Rubiks head;
	public List_Rubiks tail;
	
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
	
	public List_Rubiks inverser(List_Rubiks l){
		List_Rubiks l1 = l;
		List_Rubiks l2 = null;
		while(l1 != null){
			l2 = new List_Rubiks(l1.head, l2);
			l1 = l1.tail;
		}
		return l2;
	}
	
	public int taille() {
		int acc = 0;
		List_Rubiks l = inverser(new List_Rubiks(head, tail));
		while(l != null){
			acc++;
			l = l.tail;
		}
		return acc;
	}

}
