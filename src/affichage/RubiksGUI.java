package affichage;



import rubikscube.*;
import idaalgo.* ;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;


public class RubiksGUI extends JFrame{
	
	private int winX;
	private int winY;
	private int originX;
	private int originY;
	 
	private Rubiks rc;
	
	private List_Rubiks l;
	
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
		ButtonsRotation buttons = new ButtonsRotation(rc);
		JSplitPane splitPaneRight = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, draw, buttons);
		splitPaneRight.setDividerLocation(winX - 120);
		container.add(splitPaneRight);
		
		validate();
		setVisible(true);
		boolean exit = false;
		while (!exit) {
			repaint();
		}	
		
	}
	public RubiksGUI(Rubiks rc, List_Rubiks l){
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
		ButtonsIDA buttons = new ButtonsIDA(rc,l);
		JSplitPane splitPaneRight = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, draw, buttons);
		splitPaneRight.setDividerLocation(winX - 120);
		container.add(splitPaneRight);
		
		validate();
		setVisible(true);
		boolean exit = false;
		while (!exit) {
			repaint();
		}	
	}
	

	
	
	
}

class ButtonsIDA extends JPanel implements ActionListener {
	
	private JFormattedTextField coup = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JLabel label = new JLabel("coups");
	private JButton mix;
	private JButton reset;
	
	
	List_Rubiks l;
	Rubiks rc;
	
	public ButtonsIDA(Rubiks rc, List_Rubiks l){
		this.rc=rc;
		this.l=l;
		this.setLayout(null);
		
		Font police = new Font("Arial", Font.BOLD, 14);
		coup.setFont(police);
		coup.setForeground(Color.BLUE);
		
		label.setBounds(5, 10, 40, 15);
		coup.setBounds(50, 10, 40, 15);
		
		add(label);
		add(coup);
		
		mix = new JButton("mix");
		mix.setBounds(5, 35, 80, 15);
		add(mix);
		mix.addActionListener(this);
		
		reset = new JButton("reset");
		reset.setBounds(5,60,80,15);
		add(reset);
		reset.addActionListener(this);
	}
	public void actionPerformed(ActionEvent evt){
		
		if(evt.getSource() == mix){
			int i = Integer.parseInt(coup.getText());
			rc.mix(i);
		}
		
		if(evt.getSource() == reset) {
			rc.setRubiks();
		}
		
	}
	
}

class ButtonsRotation extends JPanel implements ActionListener {
	
	
	private JButton red;
	private JButton orange;
	private JButton blue;
	private JButton green;
	private JButton white;
	private JButton yellow;
	private JButton mix;
	private JFormattedTextField coup = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JLabel label = new JLabel("coups");
	private JButton reset;
	
	private JButton ida;
	private List_Rubiks l;
	
	private JButton next;
	
	
	Rubiks rc;
	
	
	public ButtonsRotation(Rubiks rc){
		this.rc=rc;
		this.setLayout(null);
		red = new JButton("red");
		red.setBounds(5,10,80,15);
		add(red);
		red.addActionListener(this);
		
		
		orange = new JButton("orange");
		orange.setBounds(5,35,80,15);
		add(orange);
		orange.addActionListener(this);
		
		
		blue = new JButton("blue");
		blue.setBounds(5,60,80,15);
		add(blue);
		blue.addActionListener(this);
		
		green = new JButton("green");
		green.setBounds(5,85,80,15);
		add(green);
		green.addActionListener(this);
		
		white = new JButton("white");
		white.setBounds(5,110,80,15);
		add(white);
		white.addActionListener(this);
		
		yellow = new JButton("yellow");
		yellow.setBounds(5,135,80,15);
		add(yellow);
		yellow.addActionListener(this);
		
		Font police = new Font("Arial", Font.BOLD, 14);
		coup.setFont(police);
		coup.setForeground(Color.BLUE);
		label.setBounds(5, 170, 40, 15);
		coup.setBounds(50, 170, 40, 15);
		
		add(label);
		add(coup);
		
		mix = new JButton("mix");
		mix.setBounds(5, 200, 80, 15);
		add(mix);
		mix.addActionListener(this);
		
		
		reset = new JButton("reset");
		reset.setBounds(5,225,80,15);
		add(reset);
		reset.addActionListener(this);
		
		ida = new JButton("IDA");
		ida.setBounds(5,250,80,20);
		add(ida);
		ida.addActionListener(this);
		
		next = new JButton("next");
		next.setBounds(5,300,80,20);
		add(next);
		next.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == red) {
			rc.turnFace(0,1);
		}
		if(evt.getSource() == orange) {
			rc.turnFace(1,1);
		}
		if(evt.getSource() == blue) {
			rc.turnFace(2,1);
		}
		if(evt.getSource() == green) {
			rc.turnFace(3,1);
		}
		if(evt.getSource() == white) {
			rc.turnFace(4,1);
		}
		if(evt.getSource() == yellow) {
			rc.turnFace(5,1);
		}
		
		if(evt.getSource() == mix){
			int i = Integer.parseInt(coup.getText());
			rc.mix(i);
		}
		
		if(evt.getSource() == reset) {
			rc.setRubiks();
		}
		
		
		if(evt.getSource() == ida) {
			
			long startTime = System.nanoTime();
			IDA f=new IDA(rc,1,new Rubiks(),new List_Rubiks(rc,null));
			
			List_Rubiks l1=f.idA(rc);
			
			long endTime = System.nanoTime();
			l=l1.inverser(l1);
			System.out.println("Time : "+ (endTime-startTime)/1000000+"ms");
			System.out.println("Nombre de coups : "+ (l.taille()-1) );
			
			
		}
		if(evt.getSource() == next){
			if(l!=null){
				rc.copier(l.head);
				l= l.tail;
			}
			
		}
		
		
	}
	
	
}

class drawRC extends JPanel{
	public Rubiks rc ;
	public drawRC(Rubiks rc) {
		this.rc=rc;
	}
	
	public int optimaleTaille(){
		int x= getWidth();
		int y = getHeight();
		if(4*x/6 >y){
			return y/15;
		}else{
			return x/18;
		}
	}

	public void paintComponent(Graphics _g) {
		Graphics2D g = (Graphics2D) _g;
		int x = getWidth();
		int y = getHeight();
		
		Font police=new Font("Courier",Font.BOLD,20);
		g.setFont(police);
		g.drawString("Affichage du Rubik's Cube complet", x/6, 30);
		int dx=optimaleTaille()+2;
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
		g.fillRect(x, y, optimaleTaille(), optimaleTaille());

	}

}
