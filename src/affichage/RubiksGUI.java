package affichage;



import rubikscube.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;



public class RubiksGUI extends JFrame{
	
	private int winX;
	private int winY;
	private int originX;
	private int originY;
	 
	private Rubiks rc;
	
	public RubiksGUI(Rubiks rc){
		super("RubiksGUI");
		
		this.rc = rc;
		winX = 700;
		originX = winX;
		winY = winX*5/6;
		originY = winY;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(winX, winY);
		setLocation(100, 100);
		Container container = getContentPane();
		
		container.setBackground(Color.BLACK);
		
		drawRC draw = new drawRC(rc);
		container.add(draw);
		validate();
		setVisible(true);
		boolean exit = false;
		while (!exit) {
			repaint();
		}	
		
	}
	

	
	
	
}


class drawRC extends JPanel{
	public Rubiks rc ;
	public drawRC(Rubiks rc) {
		this.rc=rc;
	}

	public void paintComponent(Graphics _g) {
		Graphics2D g = (Graphics2D) _g;
		int x = getWidth();
		int y = getHeight();
		Font police=new Font("Courier",Font.BOLD,20);
		g.setFont(police);
		g.drawString("Affichage du Rubik's Cube complet", x/6, 30);
		int dx=x/18+2;
		int cubeX = x/6;
		int cubeY = y/5;
		
		
		//Face Blanche Back
		drawSqr(g, cubeX + 3*dx, cubeY + 0*dx, rc.matrice[2][2][1].getColor(4));
		drawSqr(g, cubeX + 4*dx, cubeY + 0*dx, rc.matrice[2][0][1].getColor(4));
		drawSqr(g, cubeX + 5*dx, cubeY + 0*dx, rc.matrice[2][1][1].getColor(4));
		drawSqr(g, cubeX + 3*dx, cubeY + 1*dx, rc.matrice[0][2][1].getColor(4));
		drawSqr(g, cubeX + 4*dx, cubeY + 1*dx, rc.matrice[0][0][1].getColor(4));
		drawSqr(g, cubeX + 5*dx, cubeY + 1*dx, rc.matrice[0][1][1].getColor(4));
		drawSqr(g, cubeX + 3*dx, cubeY + 2*dx, rc.matrice[1][2][1].getColor(4));
		drawSqr(g, cubeX + 4*dx, cubeY + 2*dx, rc.matrice[1][0][1].getColor(4));
		drawSqr(g, cubeX + 5*dx, cubeY + 2*dx, rc.matrice[1][1][1].getColor(4));
		
		
		//Face Verte Left
		drawSqr(g, cubeX + 0*dx, cubeY + 3*dx, rc.matrice[2][2][1].getColor(3));
		drawSqr(g, cubeX + 1*dx, cubeY + 3*dx, rc.matrice[0][2][1].getColor(3));
		drawSqr(g, cubeX + 2*dx, cubeY + 3*dx, rc.matrice[1][2][1].getColor(3));
		drawSqr(g, cubeX + 0*dx, cubeY + 4*dx, rc.matrice[2][2][0].getColor(3));
		drawSqr(g, cubeX + 1*dx, cubeY + 4*dx, rc.matrice[0][2][0].getColor(3));
		drawSqr(g, cubeX + 2*dx, cubeY + 4*dx, rc.matrice[1][2][0].getColor(3));
		drawSqr(g, cubeX + 0*dx, cubeY + 5*dx, rc.matrice[2][2][2].getColor(3));
		drawSqr(g, cubeX + 1*dx, cubeY + 5*dx, rc.matrice[0][2][2].getColor(3));
		drawSqr(g, cubeX + 2*dx, cubeY + 5*dx, rc.matrice[1][2][2].getColor(3));
		
		
		//Face Rouge Up
		drawSqr(g, cubeX + 3*dx, cubeY + 3*dx, rc.matrice[1][2][1].getColor(0));
		drawSqr(g, cubeX + 4*dx, cubeY + 3*dx, rc.matrice[1][0][1].getColor(0));
		drawSqr(g, cubeX + 5*dx, cubeY + 3*dx, rc.matrice[1][1][1].getColor(0));
		drawSqr(g, cubeX + 3*dx, cubeY + 4*dx, rc.matrice[1][2][0].getColor(0));
		drawSqr(g, cubeX + 4*dx, cubeY + 4*dx, rc.matrice[1][0][0].getColor(0));
		drawSqr(g, cubeX + 5*dx, cubeY + 4*dx, rc.matrice[1][1][0].getColor(0));
		drawSqr(g, cubeX + 3*dx, cubeY + 5*dx, rc.matrice[1][2][2].getColor(0));
		drawSqr(g, cubeX + 4*dx, cubeY + 5*dx, rc.matrice[1][0][2].getColor(0));
		drawSqr(g, cubeX + 5*dx, cubeY + 5*dx, rc.matrice[1][1][2].getColor(0));

		
		//Face Bleue Right
		drawSqr(g, cubeX + 6*dx, cubeY + 3*dx, rc.matrice[1][1][1].getColor(2));
		drawSqr(g, cubeX + 7*dx, cubeY + 3*dx, rc.matrice[0][1][1].getColor(2));
		drawSqr(g, cubeX + 8*dx, cubeY + 3*dx, rc.matrice[2][1][1].getColor(2));
		drawSqr(g, cubeX + 6*dx, cubeY + 4*dx, rc.matrice[1][1][0].getColor(2));
		drawSqr(g, cubeX + 7*dx, cubeY + 4*dx, rc.matrice[0][1][0].getColor(2));
		drawSqr(g, cubeX + 8*dx, cubeY + 4*dx, rc.matrice[2][1][0].getColor(2));
		drawSqr(g, cubeX + 6*dx, cubeY + 5*dx, rc.matrice[1][1][2].getColor(2));
		drawSqr(g, cubeX + 7*dx, cubeY + 5*dx, rc.matrice[0][1][2].getColor(2));
		drawSqr(g, cubeX + 8*dx, cubeY + 5*dx, rc.matrice[2][1][2].getColor(2));
		
		
		//Face Orange Down
		drawSqr(g, cubeX + 9*dx, cubeY + 3*dx, rc.matrice[2][1][1].getColor(1));
		drawSqr(g, cubeX + 10*dx, cubeY + 3*dx, rc.matrice[2][0][1].getColor(1));
		drawSqr(g, cubeX + 11*dx, cubeY + 3*dx, rc.matrice[2][2][1].getColor(1));
		drawSqr(g, cubeX + 9*dx, cubeY + 4*dx, rc.matrice[2][1][0].getColor(1));
		drawSqr(g, cubeX + 10*dx, cubeY + 4*dx, rc.matrice[2][0][0].getColor(1));
		drawSqr(g, cubeX + 11*dx, cubeY + 4*dx, rc.matrice[2][2][0].getColor(1));
		drawSqr(g, cubeX + 9*dx, cubeY + 5*dx, rc.matrice[2][1][2].getColor(1));
		drawSqr(g, cubeX + 10*dx, cubeY + 5*dx, rc.matrice[2][0][2].getColor(1));
		drawSqr(g, cubeX + 11*dx, cubeY + 5*dx, rc.matrice[2][2][2].getColor(1));
		
		
		//Face Jaune Front
		drawSqr(g, cubeX + 3*dx, cubeY + 6*dx, rc.matrice[1][2][2].getColor(5));
		drawSqr(g, cubeX + 4*dx, cubeY + 6*dx, rc.matrice[1][0][2].getColor(5));
		drawSqr(g, cubeX + 5*dx, cubeY + 6*dx, rc.matrice[1][1][2].getColor(5));
		drawSqr(g, cubeX + 3*dx, cubeY + 7*dx, rc.matrice[0][2][2].getColor(5));
		drawSqr(g, cubeX + 4*dx, cubeY + 7*dx, rc.matrice[0][0][2].getColor(5));
		drawSqr(g, cubeX + 5*dx, cubeY + 7*dx, rc.matrice[0][1][2].getColor(5));
		drawSqr(g, cubeX + 3*dx, cubeY + 8*dx, rc.matrice[2][2][2].getColor(5));
		drawSqr(g, cubeX + 4*dx, cubeY + 8*dx, rc.matrice[2][0][2].getColor(5));
		drawSqr(g, cubeX + 5*dx, cubeY + 8*dx, rc.matrice[2][1][2].getColor(5));

	}

	public void drawSqr(Graphics2D g, int x, int y, Color couleur) {

		g.setColor(couleur);
		g.fillRect(x, y, getWidth()/18, getWidth()/18);

	}

}
