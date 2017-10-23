package Graphique;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreAide extends JFrame {

	private static final long serialVersionUID = 1L;

	// Declaratin des composants
	private JPanel panel_aide = new JPanel();
	private JLabel jl_aide = new JLabel(new ImageIcon("./img/aide.png"));

	public FenetreAide() {
		this.setTitle("Aide - Bataille Navale");
		this.setSize(900, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().add(panel_aide);

		// Ajout du jlabel au panel
		panel_aide.add(jl_aide);

		//Visibilite de la fenetre
		this.setVisible(true);
	}

}