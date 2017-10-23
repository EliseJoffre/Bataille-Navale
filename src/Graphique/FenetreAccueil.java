package Graphique;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import metier.TextIhm;

public class FenetreAccueil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jl_bienvenue = new JLabel("Bienvenue sur le jeu de la bataille navale !");
	private JLabel jl_image_accueil = new JLabel(new ImageIcon("./img/image_accueil.png"));
	private JButton jb_demarrer = new JButton("Demarrer");
	private JButton jb_console = new JButton("Version console");
	private JButton jb_quitter = new JButton("Quitter");
	private JPanel panel_accueil = new JPanel();

	// Constructeur de la fenêtre d'accueil

	public FenetreAccueil() {
		this.setTitle("Bataille Navale");
		this.setSize(400, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().add(panel_accueil);

		// Bienvenue
		this.jl_bienvenue.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		this.jl_bienvenue.setHorizontalAlignment(JLabel.CENTER);
		this.jl_bienvenue.setVerticalAlignment(JLabel.TOP);

		// Demarrer
		this.jb_demarrer.setPreferredSize(new Dimension(200, 60));
		this.jb_demarrer.addActionListener(new ActionListenerDemarrer());
		this.jb_demarrer.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		
		this.jb_console.setPreferredSize(new Dimension(200, 60));
		this.jb_console.addActionListener(new ActionListenerConsole());
		this.jb_console.setFont(new Font("Bookman Old Style", Font.BOLD, 15));

		// Quitter
		this.jb_quitter.setPreferredSize(new Dimension(200, 60));
		this.jb_quitter.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		this.jb_quitter.addActionListener(new ActionListenerQuitter());

		// Ajout des composants au panel
		this.add(panel_accueil);
		panel_accueil.add(this.jl_bienvenue);
		panel_accueil.add(this.jl_image_accueil);
		panel_accueil.add(this.jb_demarrer);
		panel_accueil.add(this.jb_console);
		panel_accueil.add(this.jb_quitter);

		//Visibilite de la fenetre
		this.setVisible(true);
	}

	// Evenement sur le bouton demarrer
	class ActionListenerDemarrer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Masque la fenetre
			dispose();
			// Ouvre une fenetre de jeu
			new FenetreJeu();
		}
	}
	
	class ActionListenerConsole implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Masque la fenetre
			dispose();
			// Ouvre une fenetre de jeu
			new TextIhm();
		}
	}

	// Evenement sur le bouton quitter
	class ActionListenerQuitter implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Arrete definitivement le jeu
			System.exit(0);
		}
	}
}