package affichage;



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



public class RubiksGUI extends JFrame{
	
	private int winX;
	private int winY;
	private int originX;
	private int originY;
	 
	private Rubiks rc;
	
	public RubiksGUI(Rubiks rc){
		super("RubiksGUI");
		
		this.rc = rc;
		winX = 600;
		originX = winX / 2;
		winY = 600;
		originY = winY / 2;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(winX, winY);
		setLocation(0, 0);
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
		int x = getWidth() / 2;
		int y = 15;
		g.drawString("Affichage du Rubik's Cube complet", x, y);

		int cubeX = 100;
		int cubeY = 100;
		
		
		//Face Blanche Back
		drawSqr(g, cubeX + 36, cubeY, rc.matrice[2][2][1].getColor(4));
		drawSqr(g, cubeX + 48, cubeY, rc.matrice[2][0][1].getColor(4));
		drawSqr(g, cubeX + 60, cubeY, rc.matrice[2][1][1].getColor(4));
		drawSqr(g, cubeX + 36, cubeY + 12, rc.matrice[0][2][1].getColor(4));
		drawSqr(g, cubeX + 48, cubeY + 12, rc.matrice[0][0][1].getColor(4));
		drawSqr(g, cubeX + 60, cubeY + 12, rc.matrice[0][1][1].getColor(4));
		drawSqr(g, cubeX + 36, cubeY + 24, rc.matrice[1][2][1].getColor(4));
		drawSqr(g, cubeX + 48, cubeY + 24, rc.matrice[1][0][1].getColor(4));
		drawSqr(g, cubeX + 60, cubeY + 24, rc.matrice[1][1][1].getColor(4));
		
		
		//Face Verte Left
		drawSqr(g, cubeX, cubeY + 36, rc.matrice[2][2][1].getColor(3));
		drawSqr(g, cubeX + 12, cubeY + 36, rc.matrice[0][2][1].getColor(3));
		drawSqr(g, cubeX + 24, cubeY + 36, rc.matrice[1][2][1].getColor(3));
		drawSqr(g, cubeX, cubeY + 48, rc.matrice[2][2][0].getColor(3));
		drawSqr(g, cubeX + 12, cubeY + 48, rc.matrice[0][2][0].getColor(3));
		drawSqr(g, cubeX + 24, cubeY + 48, rc.matrice[1][2][1].getColor(3));
		drawSqr(g, cubeX, cubeY + 60, rc.matrice[2][2][2].getColor(3));
		drawSqr(g, cubeX + 12, cubeY + 60, rc.matrice[0][2][2].getColor(3));
		drawSqr(g, cubeX + 24, cubeY + 60, rc.matrice[1][2][2].getColor(3));
		
		
		//Face Rouge Up
		drawSqr(g, cubeX + 36, cubeY + 36, rc.matrice[1][2][1].getColor(0));
		drawSqr(g, cubeX + 48, cubeY + 36, rc.matrice[1][0][1].getColor(0));
		drawSqr(g, cubeX + 60, cubeY + 36, rc.matrice[1][1][1].getColor(0));
		drawSqr(g, cubeX + 36, cubeY + 48, rc.matrice[1][2][0].getColor(0));
		drawSqr(g, cubeX + 48, cubeY + 48, rc.matrice[1][0][0].getColor(0));
		drawSqr(g, cubeX + 60, cubeY + 48, rc.matrice[1][1][0].getColor(0));
		drawSqr(g, cubeX + 36, cubeY + 60, rc.matrice[1][2][2].getColor(0));
		drawSqr(g, cubeX + 48, cubeY + 60, rc.matrice[1][0][2].getColor(0));
		drawSqr(g, cubeX + 60, cubeY + 60, rc.matrice[1][1][2].getColor(0));

		
		//Face Bleue Right
		drawSqr(g, cubeX + 72, cubeY + 36, rc.matrice[1][1][1].getColor(2));
		drawSqr(g, cubeX + 84, cubeY + 36, rc.matrice[0][1][1].getColor(2));
		drawSqr(g, cubeX + 96, cubeY + 36, rc.matrice[2][1][1].getColor(2));
		drawSqr(g, cubeX + 72, cubeY + 48, rc.matrice[1][1][0].getColor(2));
		drawSqr(g, cubeX + 84, cubeY + 48, rc.matrice[0][1][0].getColor(2));
		drawSqr(g, cubeX + 96, cubeY + 48, rc.matrice[2][1][0].getColor(2));
		drawSqr(g, cubeX + 72, cubeY + 60, rc.matrice[1][1][2].getColor(2));
		drawSqr(g, cubeX + 84, cubeY + 60, rc.matrice[0][1][2].getColor(2));
		drawSqr(g, cubeX + 96, cubeY + 60, rc.matrice[2][1][2].getColor(2));

		drawSqr(g, cubeX + 108, cubeY + 36, rc.matrice[2][1][1].getColor(1));
		drawSqr(g, cubeX + 120, cubeY + 36, rc.matrice[2][0][1].getColor(1));
		drawSqr(g, cubeX + 132, cubeY + 36, rc.matrice[2][2][1].getColor(1));
		drawSqr(g, cubeX + 108, cubeY + 48, rc.matrice[2][1][0].getColor(1));
		drawSqr(g, cubeX + 120, cubeY + 48, rc.matrice[2][0][0].getColor(1));
		drawSqr(g, cubeX + 132, cubeY + 48, rc.matrice[2][2][0].getColor(1));
		drawSqr(g, cubeX + 108, cubeY + 60, rc.matrice[2][1][2].getColor(1));
		drawSqr(g, cubeX + 120, cubeY + 60, rc.matrice[2][0][2].getColor(1));
		drawSqr(g, cubeX + 132, cubeY + 60, rc.matrice[2][2][2].getColor(1));

		drawSqr(g, cubeX + 36, cubeY + 72, rc.matrice[1][2][2].getColor(5));
		drawSqr(g, cubeX + 48, cubeY + 72, rc.matrice[1][0][2].getColor(5));
		drawSqr(g, cubeX + 60, cubeY + 72, rc.matrice[1][1][2].getColor(5));
		drawSqr(g, cubeX + 36, cubeY + 84, rc.matrice[0][2][2].getColor(5));
		drawSqr(g, cubeX + 48, cubeY + 84, rc.matrice[0][0][2].getColor(5));
		drawSqr(g, cubeX + 60, cubeY + 84, rc.matrice[0][1][2].getColor(5));
		drawSqr(g, cubeX + 36, cubeY + 96, rc.matrice[2][2][2].getColor(5));
		drawSqr(g, cubeX + 48, cubeY + 96, rc.matrice[2][0][2].getColor(5));
		drawSqr(g, cubeX + 60, cubeY + 96, rc.matrice[2][1][2].getColor(5));

	}

	public void drawSqr(Graphics2D g, int x, int y, Color couleur) {

		g.setColor(couleur);
		g.fillRect(x, y, 10, 10);

	}

}
