package affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Face extends JFrame{
	
	
	
	public Face(){
		this.setTitle("GridBagLayout");
	    this.setSize(400, 400);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);

	    //On crée nos différents conteneurs de couleur différente
	    JPanel cell1 = new JPanel();
	    cell1.setBackground(Color.YELLOW);
	    cell1.setPreferredSize(new Dimension(40, 40));		
	    JPanel cell2 = new JPanel();
	    cell2.setBackground(Color.red);
	    cell2.setPreferredSize(new Dimension(40, 40));
	    JPanel cell3 = new JPanel();
	    cell3.setBackground(Color.green);
	    cell3.setPreferredSize(new Dimension(40, 40));
	    JPanel cell4 = new JPanel();
	    cell4.setBackground(Color.ORANGE);
	    cell4.setPreferredSize(new Dimension(40, 40));
	    JPanel cell5 = new JPanel();
	    cell5.setBackground(Color.blue);
	    cell5.setPreferredSize(new Dimension(40, 40));
	    JPanel cell6 = new JPanel();
	    cell6.setBackground(Color.white);
	    cell6.setPreferredSize(new Dimension(40, 40));
	    
			
	    //Le conteneur principal
	    JPanel content = new JPanel();
	    content.setPreferredSize(new Dimension(300, 300));
	    content.setBackground(Color.gray);
	    //On définit le layout manager
	    content.setLayout(new GridBagLayout());
			
	    //L'objet servant à positionner les composants
	    GridBagConstraints gbc = new GridBagConstraints();
			
	    //On positionne la case de départ du composant
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    //La taille en hauteur et en largeur
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    content.add(cell1, gbc);
	    //---------------------------------------------
	    gbc.gridx = 1;
	    content.add(cell2, gbc);
	    //---------------------------------------------
	    
	    gbc.gridx = 2;		
	    content.add(cell3, gbc);		
	    //---------------------------------------------
	    
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    content.add(cell4, gbc);
	    //---------------------------------------------
	    gbc.gridx=1;
	    
	    
	    content.add(cell5, gbc);
	    //---------------------------------------------
	    gbc.gridx = 2;
	    content.add(cell6, gbc);
	    //---------------------------------------------
	    
	    //On ajoute le conteneur
	    this.setContentPane(content);
	    this.setVisible(true);		
	    
	}
	
}

