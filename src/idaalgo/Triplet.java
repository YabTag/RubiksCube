package idaalgo;

public class Triplet {
	int i;
	int j;
	int k;
	
	public Triplet(int a, int b , int c){
		i = a;
		j = b;
		k = c;
	}
	
	public int diff(Triplet t1, Triplet t2){
		int res = 0;
		if (t1.i != t2.i) res = res + 1;
		if (t1.j != t2.j) res = res + 1;
		if (t1.k != t2.k) res = res + 1;
		return res;
	}
	
	public boolean estSommet(Triplet t){
		return (t.i != 0 && t.j != 0 && t.k!= 0);
	}
	
	public boolean estPiece(Triplet t){
		return ((t.i == 0 && t.j == 0) || (t.j == 0 && t.k == 0) || (t.k == 0 && t.i == 0));
	}
	
	public Triplet somme(Triplet t1, Triplet t2){
		Triplet s = new Triplet(0,0,0);
		s.i = t1.i + t2.i;
		s.j = t1.j + t2.j;
		s.k = t1.k + t2.k;
		return s;
		
	}

}
