package idaalgo;

import affichage.*;

import rubikscube.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MinCoup {
	Rubiks rubiks;
	
	public MinCoup(Rubiks rc){
		rubiks = rc;
	}
	
	public int max(int i, int j){
		if (i < j) return j;
		else return i;
	}
	
	public Triplet conversion(int n){
		Triplet t = new Triplet(0,0,0);
		switch(n){
		case -1:
			break;
		case 0:
			t.i = 1;
			break;
		case 1:
			t.i = 2;
			break;
		case 2:
			t.j = 1;
			break;
		case 3:
			t.j = 2;
			break;
		case 4:
			t.k = 1;
			break;
		case 5:
			t.k = 2;
			break;
		
		}
		return t;
	}
	
	public int pointFixe(int [] tab){
		int [] fin = {-1, -1, -1, -1, -1, -1};
		for (int k = 0; k <= 5; k++){
			if(tab[k] != -1) fin[k] = k;
		}
		int k = 0;
		for (int i = 0; i <=5; i++){
			if ((tab[i] == fin[i]) && (tab[i] != -1) && (fin[i] != -1)) k++;
		}
		return k;
	}
	
	public boolean uneBonneCouleur(int [] tab) {
		int [] fin = {-1, -1, -1, -1, -1, -1};
		for (int k = 0; k <= 5; k++){
			if(tab[k] != -1) fin[k] = k;
		}
		boolean b = false;
		for (int k = 0; k<= 5; k++){
			b = b || ((tab[k] != - 1) && (fin[k] != -1) && (tab[k] == fin[k]));
		}
		return b;
	}
	
	public boolean couleurOppose(int [] tab){
		int [] fin = {-1, -1, -1, -1, -1, -1};
		for (int k = 0; k <= 5; k++){
			if(tab[k] != -1) fin[k] = k;
		}
		boolean b = false;
		for(int k = 0; k <=4; k++){
			b = b || (tab[k] == fin[k+1]);
		}
		return b;
		
	}
	
	public Triplet placeActuel(int [] tab){
		int i, j, k;
		i = j = k = -1;
		for(int p = 0; p<= 5; p = p + 2){
			if(p == 0) { if (tab[p] > tab[p + 1]) i = p;
						 else if (tab[p+1] > tab[p]) i = p+1;}
			if(p == 2) { if (tab[p] > tab[p + 1]) j = p;
			 else if (tab[p+1] > tab[p]) j = p+1;}
			if(p == 4) { if (tab[p] > tab[p + 1]) k = p;
			 else if (tab[p+1] > tab[p]) k = p+1;}
		}
		Triplet t1,t2,t3;
		t1 = conversion(i);
		t2 = conversion(j);
		t3 = conversion(k);
		Triplet tact = new Triplet(0,0,0);
		tact.i = t1.i + t2.i + t3.i;
		tact.j =  t1.j + t2.j + t3.j;
		tact.k = t1.k + t2.k + t3.k;
		return tact;
		
	}
	
	public Triplet placeFinale(int [] tab){
		int i1, k1, j1 ;
		int i2, j2, k2 ;
		i1 = i2 = j1 = j2 = k1 = k2 = 0;
		for(int k = 0; k<= 5; k = k +2){
			if (k == 0) i1 = max(tab[k], tab[k+1]);
			if( k == 2) j1 = max(tab[k], tab[k+1]);
			if (k == 4) k1 = max(tab[k], tab[k+1]);
		}
		Triplet t1,t2,t3;
		t1 = new Triplet(0,0,0);
		t2 = new Triplet(0,0,0);
		t3 = new Triplet(0,0,0);
		if (i1 != -1) t1 = conversion(i1);
		if( j1 != -1) t2 = conversion(j1);
		if( k1 != -1) t3 = conversion(k1);
		i2 = t1.i + t2.i + t3.i;
		j2 =  t1.j + t2.j + t3.j;
		k2 = t1.k + t2.k + t3.k;
		Triplet tfinal = new Triplet(i2, j2, k2);
		return tfinal;
	}
	
	
	
	public int mincoup(Piece p){
		
		Triplet tactuel = placeActuel(p.Orientation);
		Triplet tfinal = placeFinale(p.Orientation);
		
		if (tactuel.estPiece(tactuel)) return 0;
		
		else {
		
			if(tactuel.estSommet(tactuel)) {
				int diff = tactuel.diff(tactuel, tfinal);
				if (diff >= 2) return 2;
				if (diff == 0) {
					int k = pointFixe(p.Orientation);
					if(k >= 3) return 0;
					else return 2;
								}
				else {
					int k = pointFixe(p.Orientation);
					if (k == 1) return 1;
					else return 3;
					}
											}
			else {
				int diff = tactuel.diff(tactuel, tfinal);
				if (diff == 0){ int k = pointFixe(p.Orientation);
								if (k >= 1) return 0;
								else return 3;}
				if(diff == 1) {
					if(pointFixe(p.Orientation) >=1) return 1;
					else return 3;
				}
				if (diff == 2){
					if (uneBonneCouleur(p.Orientation)) return 1;
					else if( !couleurOppose(p.Orientation)) return 3;
					else return 2;
					
				}
				else return 2;
			}
		}
	}
		
		public int minCoupGlobal(MinCoup mc){
			int acc = 0;
			for( int i = 0; i <= 2; i++){
				for( int j = 0; j <= 2; j++){
					for( int k = 0; k <= 2; k++){
						acc = max(acc , mincoup(mc.rubiks.matrice[i][j][k]));
					}
				}
			}
			return acc;
			
		}

}