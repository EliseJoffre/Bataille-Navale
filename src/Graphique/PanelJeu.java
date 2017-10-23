package Graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import metier.Case;

public class PanelJeu extends JPanel {

	private static final long serialVersionUID = 1L;
	private FenetreJeu fen;

	// Declaration des panels utilis�s
	private PanelAffichage panelAffichage = new PanelAffichage();
	private PanelJoueur panelJoueur = new PanelJoueur();
	private PanelAdversaire panelAdversaire = new PanelAdversaire();

	// Declaration des elements du panel
	private JButton[] jbCasesJoueur = new JButton[121];
	private JButton[] jbCasesAdversaire = new JButton[121];
	private List<Integer> casesJouees = new ArrayList<Integer>();
	private JButton[] jbCasesJouees = new JButton[121];
	private List<Integer> colonne = new ArrayList<Integer>();
	private List<Integer> ligne = new ArrayList<Integer>();
	private List<Case> bateauTouchesJoueur = new ArrayList<Case>();
	private List<Case> bateauTouchesAdversaire = new ArrayList<Case>();
	private int nbBateauxCoulesJoueur = 0;
	private int nbBateauxCoulesAdversaire = 0;
	public int score_joueur = 0;
	public int score_adversaire = 0;

	// Sous-marin
	private int touche_sous_marin_adversaire = 0;
	private int touche_sous_marin_joueur = 0;

	// Sous-marin de l'adversaire
	private int touche1_sous_marin_adv = 0;
	private int touche2_sous_marin_adv = 0;

	// Sous-marin du joueur
	private int touche1_sous_marin_jou = 0;
	private int touche2_sous_marin_jou = 0;

	// Porte-avion
	private int touche_porte_avion_adversaire = 0;
	private int touche_porte_avion_joueur = 0;

	// Porte-avion de l'adversaire
	private int touche1_porte_avion_adv = 0;
	private int touche2_porte_avion_adv = 0;
	private int touche3_porte_avion_adv = 0;
	private int touche4_porte_avion_adv = 0;

	// Porte-avion du joueur
	private int touche1_porte_avion_jou = 0;
	private int touche2_porte_avion_jou = 0;
	private int touche3_porte_avion_jou = 0;
	private int touche4_porte_avion_jou = 0;

	// Croiseur
	private int touche_croiseur_adversaire = 0;
	private int touche_croiseur_joueur = 0;

	// Croiseur de l'adversaire
	private int touche1_croiseur_adv = 0;
	private int touche2_croiseur_adv = 0;
	private int touche3_croiseur_adv = 0;

	// Croiseur du joueur
	private int touche1_croiseur_jou = 0;
	private int touche2_croiseur_jou = 0;
	private int touche3_croiseur_jou = 0;

	// Torpilleur
	private int touche_torpilleur_adversaire = 0;
	private int touche_torpilleur_joueur = 0;

	// Torpilleur de l'adversaire
	private int touche1_torpilleur_adv = 0;
	private int touche2_torpilleur_adv = 0;

	// Torpilleur du joueur
	private int touche1_torpilleur_jou = 0;

	// Contre-torpilleur
	private int touche_contre_torpilleur_adversaire = 0;
	private int touche_contre_torpilleur_joueur = 0;

	// Contre-torpilleur de l'adversaire
	private int touche1_contre_torpilleur_adv = 0;
	private int touche2_torpilleur_jou = 0;

	// Contre-torpilleur du joueur
	private int touche1_contre_torpilleur_jou = 0;

	// Bateau
	private int touche_bateau_adversaire = 0;
	private int touche_bateau_joueur = 0;

	// Bateau de l'adversaire
	private int touche1_bateau_adv = 0;

	// Bateau du joueur
	private int touche1_bateau_jou = 0;

	public PanelJeu(FenetreJeu fen) {

		this.fen = fen;

		// Declaration du layout du panel
		this.setLayout(new GridLayout(1, 3));

		// Ajout des composants au panel
		this.add(this.panelJoueur);
		this.add(this.panelAffichage);
		this.add(this.panelAdversaire);

		int taille = 0;
		int lettre = 65;
		int numero = 0;

		this.jbCasesJouees[taille] = new JButton("");

		Case c = new Case(0, 0);

		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				jbCasesJoueur[taille] = new JButton("");
				jbCasesAdversaire[taille] = new JButton("");
				jbCasesJoueur[taille].setPreferredSize(new Dimension(40, 40));
				jbCasesAdversaire[taille].setPreferredSize(new Dimension(40, 40));

				if (i == 0 && j == 0) {
					jbCasesJoueur[taille].setIcon(new ImageIcon("./img/palmier.png"));
					jbCasesAdversaire[taille].setIcon(new ImageIcon("./img/palmier.png"));
				}
				if (i == 0 && j != 0) {
					jbCasesJoueur[taille].setText("" + (char) lettre);
					jbCasesAdversaire[taille].setText("" + (char) lettre);
					jbCasesJoueur[taille].setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));
					jbCasesAdversaire[taille].setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));
					colonne.add(taille);
					lettre++;
				}
				if (j == 0 && i != 0) {
					numero++;
					jbCasesJoueur[taille].setText("" + numero);
					jbCasesAdversaire[taille].setText("" + numero);
					jbCasesJoueur[taille].setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));
					jbCasesAdversaire[taille].setBorder(BorderFactory.createEtchedBorder(Color.BLUE, Color.BLUE));
					ligne.add(taille);
				}
				if (i > 0 && j > 0) {

					c = new Case(i, j);

					// JOUEUR
					if (this.panelJoueur.getPlateauJoueur().getCasesOccupees().contains(c)) {
						if (panelJoueur.getJeuJoueur().getPorte_avions().getCases().contains(c)) {
							jbCasesJoueur[taille].setIcon(new ImageIcon("./img/porte_avion.png"));
						} else {
							if (panelJoueur.getJeuJoueur().getSous_marin().getCases().contains(c)) {
								jbCasesJoueur[taille].setIcon(new ImageIcon("./img/sous_marin.png"));
							} else {
								if (panelJoueur.getJeuJoueur().getCroiseur().getCases().contains(c)) {
									jbCasesJoueur[taille].setIcon(new ImageIcon("./img/croiseur.png"));
								} else {
									if (panelJoueur.getJeuJoueur().getTorpilleur().getCases().contains(c)) {
										jbCasesJoueur[taille].setIcon(new ImageIcon("./img/torpilleur.png"));
									} else {
										if (panelJoueur.getJeuJoueur().getContre_torpilleur().getCases().contains(c)) {
											jbCasesJoueur[taille].setIcon(new ImageIcon("./img/contre_torpilleur.png"));
										} else {
											jbCasesJoueur[taille].setIcon(new ImageIcon("./img/bateau.png"));
										}
									}
								}
							}
						}
					} else {
						this.jbCasesJoueur[taille].setIcon(new ImageIcon("./img/eau.png"));
					}

					// ADVERSAIRE
					jbCasesAdversaire[taille].setIcon(new ImageIcon("./img/eau.png"));

					final int taille_bouton_coule = taille;
					final Case caseBateau = c;

					// Ecouteurs des cases de la grille de l'adversaire
					this.jbCasesAdversaire[taille].addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							// JOUEUR
							Integer randomTaille;
							do {
								randomTaille = (int) (Math.random() * 121);
							} while (randomTaille == 0 || colonne.contains(randomTaille) || ligne.contains(randomTaille)
									|| casesJouees.contains(randomTaille));
							casesJouees.add(randomTaille);
							Case caseBateauJoueur = new Case(randomTaille / 11, randomTaille % 11);

							if (panelJoueur.getPlateauJoueur().getCasesOccupees().contains(caseBateauJoueur)) {
								caseBateauJoueur.setEstTouche(true);
								bateauTouchesJoueur.add(caseBateauJoueur);
								panelJoueur.getJeuJoueur().setCaseTouchee(bateauTouchesJoueur);
								nbBateauxCoulesJoueur = nbBateauxCoulesJoueur + 1;

								if (panelJoueur.getJeuJoueur().getPorte_avions().getCases()
										.contains(caseBateauJoueur)) {
									jbCasesJoueur[randomTaille].setIcon(new ImageIcon("./img/porte_avion_coule.png"));
									touche_porte_avion_joueur = touche_porte_avion_joueur + 1;
									if (touche_porte_avion_joueur == 1) {

										panelAffichage.getJl_commentaire_adversaire()
												.setText("Touche!Votre porte avion prend l'eau ");
										panelAffichage.getJl_commentaire_emotion_adversaire()
												.setIcon(new ImageIcon("./img/touche.png"));
										touche1_porte_avion_jou = randomTaille;
										score_adversaire = score_adversaire + 2;
										panelAffichage.getJl_score_adversaire().setText("" + score_adversaire);
									} else {
										if (touche_porte_avion_joueur == 2) {

											panelAffichage.getJl_commentaire_adversaire()
													.setText("Touche!Votre porte avion prend l'eau ");
											panelAffichage.getJl_commentaire_emotion_adversaire()
													.setIcon(new ImageIcon("./img/touche.png"));
											touche2_porte_avion_jou = randomTaille;
											score_adversaire = score_adversaire + 2;
											panelAffichage.getJl_score_adversaire().setText("" + score_adversaire);
										} else {
											if (touche_porte_avion_joueur == 3) {

												panelAffichage.getJl_commentaire_adversaire()
														.setText("Touche!Votre porte avion prend l'eau ");
												panelAffichage.getJl_commentaire_emotion_adversaire()
														.setIcon(new ImageIcon("./img/touche.png"));
												touche3_porte_avion_jou = randomTaille;
												score_adversaire = score_adversaire + 2;
												panelAffichage.getJl_score_adversaire().setText("" + score_adversaire);
											} else {
												if (touche_porte_avion_joueur == 4) {

													panelAffichage.getJl_commentaire_adversaire()
															.setText("Touche!Votre porte avion va couler ");
													panelAffichage.getJl_commentaire_emotion_adversaire()
															.setIcon(new ImageIcon("./img/touche.png"));
													touche4_porte_avion_jou = randomTaille;
													score_adversaire = score_adversaire + 2;
													panelAffichage.getJl_score_adversaire()
															.setText("" + score_adversaire);
												} else {
													panelAffichage.getJl_commentaire_adversaire()
															.setText("Coule ! Votre porte avion coule ");
													panelAffichage.getJl_commentaire_emotion_adversaire()
															.setIcon(new ImageIcon("./img/coule.png"));
													jbCasesJoueur[randomTaille].setIcon(
															new ImageIcon("./img/porte_avion_qui_coule_mer.png"));
													jbCasesJoueur[touche1_porte_avion_jou].setIcon(
															new ImageIcon("./img/porte_avion_qui_coule_mer.png"));
													jbCasesJoueur[touche2_porte_avion_jou].setIcon(
															new ImageIcon("./img/porte_avion_qui_coule_mer.png"));
													jbCasesJoueur[touche3_porte_avion_jou].setIcon(
															new ImageIcon("./img/porte_avion_qui_coule_mer.png"));
													jbCasesJoueur[touche4_porte_avion_jou].setIcon(
															new ImageIcon("./img/porte_avion_qui_coule_mer.png"));
													score_adversaire = score_adversaire + 5;
													panelAffichage.getJl_score_adversaire()
															.setText("" + score_adversaire);
												}
											}
										}
									}

								} else {

									// touche du sous marin

									if (panelJoueur.getJeuJoueur().getSous_marin().getCases()
											.contains(caseBateauJoueur)) {
										jbCasesJoueur[randomTaille]
												.setIcon(new ImageIcon("./img/sous_marin_coule.png"));
										touche_sous_marin_joueur = touche_sous_marin_joueur + 1;

										if (touche_sous_marin_joueur == 1) {

											panelAffichage.getJl_commentaire_adversaire()
													.setText("Touche ! Votre sous marin prend l'eau ");
											panelAffichage.getJl_commentaire_emotion_adversaire()
													.setIcon(new ImageIcon("./img/touche.png"));
											touche1_sous_marin_jou = randomTaille;
											score_adversaire = score_adversaire + 1;
											panelAffichage.getJl_score_adversaire().setText("" + score_adversaire);
										} else {

											if (touche_sous_marin_joueur == 2) {
												panelAffichage.getJl_commentaire_adversaire()
														.setText("Touche ! Votre sous marin va couler ");
												panelAffichage.getJl_commentaire_emotion_adversaire()
														.setIcon(new ImageIcon("./img/touche.png"));
												touche2_sous_marin_jou = randomTaille;
												score_adversaire = score_adversaire + 1;
												panelAffichage.getJl_score_adversaire().setText("" + score_adversaire);
											} else {

												panelAffichage.getJl_commentaire_adversaire()
														.setText("Coule ! Votre sous marin coule ");
												panelAffichage.getJl_commentaire_emotion_adversaire()
														.setIcon(new ImageIcon("./img/coule.png"));
												jbCasesJoueur[randomTaille]
														.setIcon(new ImageIcon("./img/sous_marin_qui_coule_mer.png"));
												jbCasesJoueur[touche1_sous_marin_jou]
														.setIcon(new ImageIcon("./img/sous_marin_qui_coule_mer.png"));
												jbCasesJoueur[touche2_sous_marin_jou]
														.setIcon(new ImageIcon("./img/sous_marin_qui_coule_mer.png"));
												score_adversaire = score_adversaire + 3;
												panelAffichage.getJl_score_adversaire().setText("" + score_adversaire);
											}
										}

									} else {
										if (panelJoueur.getJeuJoueur().getCroiseur().getCases()
												.contains(caseBateauJoueur)) {
											jbCasesJoueur[randomTaille]
													.setIcon(new ImageIcon("./img/croiseur_coule.png"));
											touche_croiseur_joueur = touche_croiseur_joueur + 1;
											if (touche_croiseur_joueur == 1) {
												panelAffichage.getJl_commentaire_adversaire()
														.setText("Touche ! Votre croiseur prend l'eau ");
												panelAffichage.getJl_commentaire_emotion_adversaire()
														.setIcon(new ImageIcon("./img/touche.png"));
												touche1_croiseur_jou = randomTaille;
												score_adversaire = score_adversaire + 2;
												panelAffichage.getJl_score_adversaire().setText("" + score_adversaire);
											}
											if (touche_croiseur_joueur == 2) {
												panelAffichage.getJl_commentaire_adversaire()
														.setText("Touche ! Votre croiseur prend l'eau ");
												panelAffichage.getJl_commentaire_emotion_adversaire()
														.setIcon(new ImageIcon("./img/touche.png"));
												touche2_croiseur_jou = randomTaille;
												score_adversaire = score_adversaire + 2;
												panelAffichage.getJl_score_adversaire().setText("" + score_adversaire);
											}
											if (touche_croiseur_joueur == 3) {
												panelAffichage.getJl_commentaire_adversaire()
														.setText("Touche ! Votre croiseur va couler ");
												panelAffichage.getJl_commentaire_emotion_adversaire()
														.setIcon(new ImageIcon("./img/touche.png"));
												touche3_croiseur_jou = randomTaille;
												score_adversaire = score_adversaire + 2;
												panelAffichage.getJl_score_adversaire().setText("" + score_adversaire);
											}
											if (touche_croiseur_joueur == 4) {
												panelAffichage.getJl_commentaire_adversaire()
														.setText("Touche ! Votre croiseur coule ");
												panelAffichage.getJl_commentaire_emotion_adversaire()
														.setIcon(new ImageIcon("./img/coule.png"));
												jbCasesJoueur[randomTaille]
														.setIcon(new ImageIcon("./img/croiseur_qui_coule_mer.png"));
												jbCasesJoueur[touche1_croiseur_jou]
														.setIcon(new ImageIcon("./img/croiseur_qui_coule_mer.png"));
												jbCasesJoueur[touche2_croiseur_jou]
														.setIcon(new ImageIcon("./img/croiseur_qui_coule_mer.png"));
												jbCasesJoueur[touche3_croiseur_jou]
														.setIcon(new ImageIcon("./img/croiseur_qui_coule_mer.png"));
												score_adversaire = score_adversaire + 4;
												panelAffichage.getJl_score_adversaire().setText("" + score_adversaire);

											}

										} else {
											if (panelJoueur.getJeuJoueur().getTorpilleur().getCases()
													.contains(caseBateauJoueur)) {
												jbCasesJoueur[randomTaille]
														.setIcon(new ImageIcon("./img/torpilleur_coule.png"));
												touche_torpilleur_joueur = touche_torpilleur_joueur + 1;

												if (touche_torpilleur_joueur == 1) {
													panelAffichage.getJl_commentaire_adversaire()
															.setText("Touche ! Votre torpilleur prend l'eau ");
													panelAffichage.getJl_commentaire_emotion_adversaire()
															.setIcon(new ImageIcon("./img/touche.png"));
													touche1_torpilleur_jou = randomTaille;
													score_adversaire = score_adversaire + 1;
													panelAffichage.getJl_score_adversaire()
															.setText("" + score_adversaire);
												}
												if (touche_torpilleur_joueur == 2) {
													panelAffichage.getJl_commentaire_adversaire()
															.setText("Touche ! Votre torpilleur prend l'eau ");
													panelAffichage.getJl_commentaire_emotion_adversaire()
															.setIcon(new ImageIcon("./img/touche.png"));
													touche2_torpilleur_jou = randomTaille;
													score_adversaire = score_adversaire + 1;
													panelAffichage.getJl_score_adversaire()
															.setText("" + score_adversaire);
												}
												if (touche_torpilleur_joueur == 3) {
													panelAffichage.getJl_commentaire_adversaire()
															.setText("Coule ! Votre torpilleur coule ");
													panelAffichage.getJl_commentaire_emotion_adversaire()
															.setIcon(new ImageIcon("./img/coule.png"));
													jbCasesJoueur[randomTaille].setIcon(
															new ImageIcon("./img/torpilleur_qui_coule_mer.png"));
													jbCasesJoueur[touche1_torpilleur_jou].setIcon(
															new ImageIcon("./img/torpilleur_qui_coule_mer.png"));
													jbCasesJoueur[touche2_torpilleur_jou].setIcon(
															new ImageIcon("./img/torpilleur_qui_coule_mer.png"));
													score_adversaire = score_adversaire + 3;
													panelAffichage.getJl_score_adversaire()
															.setText("" + score_adversaire);

												}

											} else {
												if (panelJoueur.getJeuJoueur().getContre_torpilleur().getCases()
														.contains(caseBateauJoueur)) {
													jbCasesJoueur[randomTaille].setIcon(
															new ImageIcon("./img/contre_torpilleur_coule.png"));
													touche_contre_torpilleur_joueur = touche_contre_torpilleur_joueur
															+ 1;

													if (touche_contre_torpilleur_joueur == 1) {
														panelAffichage.getJl_commentaire_adversaire()
																.setText("Touche!Votre contre torpilleur prend l'eau ");
														panelAffichage.getJl_commentaire_emotion_adversaire()
																.setIcon(new ImageIcon("./img/touche.png"));
														touche1_contre_torpilleur_jou = randomTaille;
														score_adversaire = score_adversaire + 1;
														panelAffichage.getJl_score_adversaire()
																.setText("" + score_adversaire);
													}

													if (touche_contre_torpilleur_joueur == 2) {
														panelAffichage.getJl_commentaire_adversaire()
																.setText("Coule!Votre contre torpilleur coule");
														panelAffichage.getJl_commentaire_emotion_adversaire()
																.setIcon(new ImageIcon("./img/coule.png"));
														jbCasesJoueur[randomTaille].setIcon(new ImageIcon(
																"./img/contre_torpilleur_qui_coule_mer.png"));
														jbCasesJoueur[touche1_contre_torpilleur_jou]
																.setIcon(new ImageIcon(
																		"./img/contre_torpilleur_qui_coule_mer.png"));
														score_adversaire = score_adversaire + 2;
														panelAffichage.getJl_score_adversaire()
																.setText("" + score_adversaire);

													}

												} else {
													jbCasesJoueur[randomTaille]
															.setIcon(new ImageIcon("./img/bateau_coule.png"));
													touche_bateau_joueur = touche_bateau_joueur + 1;

													if (touche_bateau_joueur == 1) {
														panelAffichage.getJl_commentaire_adversaire()
																.setText("Touche ! Votre bateau prend l'eau ");
														panelAffichage.getJl_commentaire_emotion_adversaire()
																.setIcon(new ImageIcon("./img/touche.png"));
														touche1_bateau_jou = randomTaille;
														score_adversaire = score_adversaire + 1;
														panelAffichage.getJl_score_adversaire()
																.setText("" + score_adversaire);
													}

													if (touche_bateau_joueur == 2) {
														panelAffichage.getJl_commentaire_adversaire()
																.setText("Coule ! Votre bateau coule ");
														panelAffichage.getJl_commentaire_emotion_adversaire()
																.setIcon(new ImageIcon("./img/coule.png"));
														jbCasesJoueur[randomTaille].setIcon(
																new ImageIcon("./img/bateau_qui_coule_mer.png"));
														jbCasesJoueur[touche1_bateau_jou].setIcon(
																new ImageIcon("./img/bateau_qui_coule_mer.png"));
														score_adversaire = score_adversaire + 2;
														panelAffichage.getJl_score_adversaire()
																.setText("" + score_adversaire);
													}

												}
											}
										}
									}
								}

							} else {
								jbCasesJoueur[randomTaille].setIcon(new ImageIcon("./img/rate.png"));
								panelAffichage.getJl_commentaire_emotion_adversaire()
										.setIcon(new ImageIcon("./img/joueur_rate.png"));
								panelAffichage.getJl_commentaire_adversaire().setText("Rate ! Dans l'eau ");

							}

							// ADVERSAIRE
							if (panelAdversaire.getPlateauAdversaire().getCasesOccupees().contains(caseBateau)) {
								jbCasesAdversaire[taille_bouton_coule].setIcon(new ImageIcon("./img/eau.png"));
								caseBateau.setEstTouche(true);
								bateauTouchesAdversaire.add(caseBateau);
								panelAdversaire.getJeuAdversaire().setCaseTouchee(bateauTouchesAdversaire);
								nbBateauxCoulesAdversaire = nbBateauxCoulesAdversaire + 1;

								if (panelAdversaire.getJeuAdversaire().getPorte_avions().getCases()
										.contains(caseBateau)) {
									jbCasesAdversaire[taille_bouton_coule].setEnabled(false);
									jbCasesAdversaire[taille_bouton_coule]
											.setDisabledIcon(new ImageIcon("./img/porte_avion_coule.png"));
									touche_porte_avion_adversaire = touche_porte_avion_adversaire + 1;

									if (touche_porte_avion_adversaire == 1) {
										panelAffichage.getJl_commentaire_center()
												.setIcon(new ImageIcon("./img/porte_avion_milieu.png"));
										panelAffichage.getJl_commentaire_joueur()
												.setText("Touche ! Le porte avion prend l'eau !");
										panelAffichage.getJl_commentaire_emotion_joueur()
												.setIcon(new ImageIcon("./img/touche.png"));
										touche1_porte_avion_adv = taille_bouton_coule;
										score_joueur = score_joueur + 3;
										panelAffichage.getJl_score_joueur().setText("" + score_joueur);
									}
									if (touche_porte_avion_adversaire == 2) {
										panelAffichage.getJl_commentaire_center()
												.setIcon(new ImageIcon("./img/porte_avion_milieu.png"));
										panelAffichage.getJl_commentaire_joueur()
												.setText("Touche ! Le porte avion prend l'eau !");
										panelAffichage.getJl_commentaire_emotion_joueur()
												.setIcon(new ImageIcon("./img/touche.png"));
										touche2_porte_avion_adv = taille_bouton_coule;
										score_joueur = score_joueur + 3;
										panelAffichage.getJl_score_joueur().setText("" + score_joueur);
									}
									if (touche_porte_avion_adversaire == 3) {
										panelAffichage.getJl_commentaire_center()
												.setIcon(new ImageIcon("./img/porte_avion_milieu.png"));
										panelAffichage.getJl_commentaire_joueur()
												.setText("Touche ! Le porte avion prend l'eau !");
										panelAffichage.getJl_commentaire_emotion_joueur()
												.setIcon(new ImageIcon("./img/touche.png"));
										touche3_porte_avion_adv = taille_bouton_coule;
										score_joueur = score_joueur + 3;
										panelAffichage.getJl_score_joueur().setText("" + score_joueur);
									}
									if (touche_porte_avion_adversaire == 4) {
										panelAffichage.getJl_commentaire_center()
												.setIcon(new ImageIcon("./img/porte_avion_milieu.png"));
										panelAffichage.getJl_commentaire_joueur()
												.setText("Touche ! Le porte avion va couler !");
										panelAffichage.getJl_commentaire_emotion_joueur()
												.setIcon(new ImageIcon("./img/touche.png"));
										touche4_porte_avion_adv = taille_bouton_coule;
										score_joueur = score_joueur + 3;
										panelAffichage.getJl_score_joueur().setText("" + score_joueur);
									}
									if (touche_porte_avion_adversaire == 5) {
										panelAffichage.getJl_commentaire_center()
												.setIcon(new ImageIcon("./img/porte_avion_qui_coule.png"));
										panelAffichage.getJl_commentaire_joueur()
												.setText("Coule ! Le porte avion coule !");
										panelAffichage.getJl_commentaire_emotion_joueur()
												.setIcon(new ImageIcon("./img/coule.png"));
										jbCasesAdversaire[taille_bouton_coule]
												.setDisabledIcon(new ImageIcon("./img/porte_avion_qui_coule_mer.png"));
										jbCasesAdversaire[touche1_porte_avion_adv]
												.setDisabledIcon(new ImageIcon("./img/porte_avion_qui_coule_mer.png"));
										jbCasesAdversaire[touche2_porte_avion_adv]
												.setDisabledIcon(new ImageIcon("./img/porte_avion_qui_coule_mer.png"));
										jbCasesAdversaire[touche3_porte_avion_adv]
												.setDisabledIcon(new ImageIcon("./img/porte_avion_qui_coule_mer.png"));
										jbCasesAdversaire[touche4_porte_avion_adv]
												.setDisabledIcon(new ImageIcon("./img/porte_avion_qui_coule_mer.png"));
										score_joueur = score_joueur + 5;
										panelAffichage.getJl_score_joueur().setText("" + score_joueur);

									}

								} else {
									if (panelAdversaire.getJeuAdversaire().getSous_marin().getCases()
											.contains(caseBateau)) {
										jbCasesAdversaire[taille_bouton_coule].setEnabled(false);
										jbCasesAdversaire[taille_bouton_coule]
												.setDisabledIcon(new ImageIcon("./img/sous_marin_coule.png"));
										touche_sous_marin_adversaire = touche_sous_marin_adversaire + 1;

										if (touche_sous_marin_adversaire == 1) {
											panelAffichage.getJl_commentaire_center()
													.setIcon(new ImageIcon("./img/sous_marin_milieu.png"));
											panelAffichage.getJl_commentaire_joueur()
													.setText("Touche ! Le sous marin prend l'eau !");
											panelAffichage.getJl_commentaire_emotion_joueur()
													.setIcon(new ImageIcon("./img/touche.png"));
											touche1_sous_marin_adv = taille_bouton_coule;
											score_joueur = score_joueur + 1;
											panelAffichage.getJl_score_joueur().setText("" + score_joueur);
										}
										if (touche_sous_marin_adversaire == 2) {
											panelAffichage.getJl_commentaire_center()
													.setIcon(new ImageIcon("./img/sous_marin_milieu.png"));
											panelAffichage.getJl_commentaire_joueur()
													.setText("Touche ! Le sous marin va couler !");
											panelAffichage.getJl_commentaire_emotion_joueur()
													.setIcon(new ImageIcon("./img/touche.png"));
											touche2_sous_marin_adv = taille_bouton_coule;
											score_joueur = score_joueur + 1;
											panelAffichage.getJl_score_joueur().setText("" + score_joueur);
										}
										if (touche_sous_marin_adversaire == 3) {
											panelAffichage.getJl_commentaire_center()
													.setIcon(new ImageIcon("./img/sous_marin_qui_coule.png"));
											panelAffichage.getJl_commentaire_joueur()
													.setText("Coule ! Le sous marin coule !");
											panelAffichage.getJl_commentaire_emotion_joueur()
													.setIcon(new ImageIcon("./img/coule.png"));
											jbCasesAdversaire[taille_bouton_coule].setDisabledIcon(
													new ImageIcon("./img/sous_marin_qui_coule_mer.png"));
											jbCasesAdversaire[touche1_sous_marin_adv].setDisabledIcon(
													new ImageIcon("./img/sous_marin_qui_coule_mer.png"));
											jbCasesAdversaire[touche2_sous_marin_adv].setDisabledIcon(
													new ImageIcon("./img/sous_marin_qui_coule_mer.png"));
											score_joueur = score_joueur + 3;
											panelAffichage.getJl_score_joueur().setText("" + score_joueur);

										}

									} else {
										if (panelAdversaire.getJeuAdversaire().getCroiseur().getCases()
												.contains(caseBateau)) {
											jbCasesAdversaire[taille_bouton_coule].setEnabled(false);
											jbCasesAdversaire[taille_bouton_coule]
													.setDisabledIcon(new ImageIcon("./img/croiseur_coule.png"));
											touche_croiseur_adversaire = touche_croiseur_adversaire + 1;

											if (touche_croiseur_adversaire == 1) {
												panelAffichage.getJl_commentaire_center()
														.setIcon(new ImageIcon("./img/croiseur_milieu.png"));
												panelAffichage.getJl_commentaire_joueur()
														.setText("Touche ! Le croiseur prend l'eau !");
												panelAffichage.getJl_commentaire_emotion_joueur()
														.setIcon(new ImageIcon("./img/touche.png"));
												touche1_croiseur_adv = taille_bouton_coule;
												score_joueur = score_joueur + 2;
												panelAffichage.getJl_score_joueur().setText("" + score_joueur);
											}
											if (touche_croiseur_adversaire == 2) {
												panelAffichage.getJl_commentaire_center()
														.setIcon(new ImageIcon("./img/croiseur_milieu.png"));
												panelAffichage.getJl_commentaire_joueur()
														.setText("Touche ! Le croiseur prend l'eau !");
												panelAffichage.getJl_commentaire_emotion_joueur()
														.setIcon(new ImageIcon("./img/touche.png"));
												touche2_croiseur_adv = taille_bouton_coule;
												score_joueur = score_joueur + 2;
												panelAffichage.getJl_score_joueur().setText("" + score_joueur);
											}
											if (touche_croiseur_adversaire == 3) {
												panelAffichage.getJl_commentaire_center()
														.setIcon(new ImageIcon("./img/croiseur_milieu.png"));
												panelAffichage.getJl_commentaire_joueur()
														.setText("Touche ! Le croiseur va couler !");
												panelAffichage.getJl_commentaire_emotion_joueur()
														.setIcon(new ImageIcon("./img/touche.png"));
												touche3_croiseur_adv = taille_bouton_coule;
												score_joueur = score_joueur + 2;
												panelAffichage.getJl_score_joueur().setText("" + score_joueur);
											}
											if (touche_croiseur_adversaire == 4) {
												panelAffichage.getJl_commentaire_center()
														.setIcon(new ImageIcon("./img/croiseur_qui_coule.png"));
												panelAffichage.getJl_commentaire_joueur()
														.setText("Coule ! Le croiseur coule !");
												panelAffichage.getJl_commentaire_emotion_joueur()
														.setIcon(new ImageIcon("./img/coule.png"));
												jbCasesAdversaire[taille_bouton_coule].setDisabledIcon(
														new ImageIcon("./img/croiseur_qui_coule_mer.png"));
												jbCasesAdversaire[touche1_croiseur_adv].setDisabledIcon(
														new ImageIcon("./img/croiseur_qui_coule_mer.png"));
												jbCasesAdversaire[touche2_croiseur_adv].setDisabledIcon(
														new ImageIcon("./img/croiseur_qui_coule_mer.png"));
												jbCasesAdversaire[touche3_croiseur_adv].setDisabledIcon(
														new ImageIcon("./img/croiseur_qui_coule_mer.png"));
												score_joueur = score_joueur + 2;
												panelAffichage.getJl_score_joueur().setText("" + score_joueur);

											}

										} else {
											if (panelAdversaire.getJeuAdversaire().getTorpilleur().getCases()
													.contains(caseBateau)) {
												jbCasesAdversaire[taille_bouton_coule].setEnabled(false);
												jbCasesAdversaire[taille_bouton_coule]
														.setDisabledIcon(new ImageIcon("./img/torpilleur_coule.png"));
												touche_torpilleur_adversaire = touche_torpilleur_adversaire + 1;

												if (touche_torpilleur_adversaire == 1) {
													panelAffichage.getJl_commentaire_center()
															.setIcon(new ImageIcon("./img/torpilleur_milieu.png"));
													panelAffichage.getJl_commentaire_joueur()
															.setText("Touche ! Le torpilleur prend l'eau !");
													panelAffichage.getJl_commentaire_emotion_joueur()
															.setIcon(new ImageIcon("./img/touche.png"));
													touche1_torpilleur_adv = taille_bouton_coule;
													score_joueur = score_joueur + 1;
													panelAffichage.getJl_score_joueur().setText("" + score_joueur);
												}

												if (touche_torpilleur_adversaire == 2) {
													panelAffichage.getJl_commentaire_center()
															.setIcon(new ImageIcon("./img/torpilleur_milieu.png"));
													panelAffichage.getJl_commentaire_joueur()
															.setText("Touche ! Le torpilleur prend l'eau !");
													panelAffichage.getJl_commentaire_emotion_joueur()
															.setIcon(new ImageIcon("./img/touche.png"));
													touche2_torpilleur_adv = taille_bouton_coule;
													score_joueur = score_joueur + 1;
													panelAffichage.getJl_score_joueur().setText("" + score_joueur);
												}

												if (touche_torpilleur_adversaire == 3) {
													panelAffichage.getJl_commentaire_center()
															.setIcon(new ImageIcon("./img/torpilleur_qui_coule.png"));
													panelAffichage.getJl_commentaire_joueur()
															.setText("Coule ! Le torpilleur coule !");
													panelAffichage.getJl_commentaire_emotion_joueur()
															.setIcon(new ImageIcon("./img/coule.png"));
													jbCasesAdversaire[taille_bouton_coule].setDisabledIcon(
															new ImageIcon("./img/torpilleur_qui_coule_mer.png"));
													jbCasesAdversaire[touche1_torpilleur_adv].setDisabledIcon(
															new ImageIcon("./img/torpilleur_qui_coule_mer.png"));
													jbCasesAdversaire[touche2_torpilleur_adv].setDisabledIcon(
															new ImageIcon("./img/torpilleur_qui_coule_mer.png"));
													score_joueur = score_joueur + 3;
													panelAffichage.getJl_score_joueur().setText("" + score_joueur);

												}

											} else {
												if (panelAdversaire.getJeuAdversaire().getContre_torpilleur().getCases()
														.contains(caseBateau)) {
													jbCasesAdversaire[taille_bouton_coule].setEnabled(false);
													jbCasesAdversaire[taille_bouton_coule].setDisabledIcon(
															new ImageIcon("./img/contre_torpilleur_coule.png"));
													touche_contre_torpilleur_adversaire = touche_contre_torpilleur_adversaire
															+ 1;

													if (touche_contre_torpilleur_adversaire == 1) {
														panelAffichage.getJl_commentaire_center().setIcon(
																new ImageIcon("./img/contre_torpilleur_milieu.png"));
														panelAffichage.getJl_commentaire_joueur()
																.setText("Touche ! Le contre torpilleur prend l'eau !");
														panelAffichage.getJl_commentaire_emotion_joueur()
																.setIcon(new ImageIcon("./img/touche.png"));
														touche1_contre_torpilleur_adv = taille_bouton_coule;
														score_joueur = score_joueur + 1;
														panelAffichage.getJl_score_joueur().setText("" + score_joueur);
													}

													if (touche_contre_torpilleur_adversaire == 2) {
														panelAffichage.getJl_commentaire_center().setIcon(
																new ImageIcon("./img/contre_torpilleur_qui_coule.png"));
														panelAffichage.getJl_commentaire_joueur()
																.setText("Coule ! Le contre torpilleur coule !");
														panelAffichage.getJl_commentaire_emotion_joueur()
																.setIcon(new ImageIcon("./img/coule.png"));
														jbCasesAdversaire[taille_bouton_coule]
																.setDisabledIcon(new ImageIcon(
																		"./img/contre_torpilleur_qui_coule_mer.png"));
														jbCasesAdversaire[touche1_contre_torpilleur_adv]
																.setDisabledIcon(new ImageIcon(
																		"./img/contre_torpilleur_qui_coule_mer.png"));
														score_joueur = score_joueur + 2;
														panelAffichage.getJl_score_joueur().setText("" + score_joueur);

													}

												} else {
													jbCasesAdversaire[taille_bouton_coule].setEnabled(false);
													jbCasesAdversaire[taille_bouton_coule]
															.setDisabledIcon(new ImageIcon("./img/bateau_coule.png"));
													touche_bateau_adversaire = touche_bateau_adversaire + 1;

													if (touche_bateau_adversaire == 1) {
														panelAffichage.getJl_commentaire_center()
																.setIcon(new ImageIcon("./img/bateau_milieu.png"));
														panelAffichage.getJl_commentaire_joueur()
																.setText("Touche ! Le bateau prend l'eau !");
														panelAffichage.getJl_commentaire_emotion_joueur()
																.setIcon(new ImageIcon("./img/touche.png"));
														touche1_bateau_adv = taille_bouton_coule;
														score_joueur = score_joueur + 1;
														panelAffichage.getJl_score_joueur().setText("" + score_joueur);
													}

													if (touche_bateau_adversaire == 2) {
														panelAffichage.getJl_commentaire_center()
																.setIcon(new ImageIcon("./img/bateau_qui_coule.png"));
														panelAffichage.getJl_commentaire_joueur()
																.setText("Coule ! Le bateau coule !");
														panelAffichage.getJl_commentaire_emotion_joueur()
																.setIcon(new ImageIcon("./img/coule.png"));
														jbCasesAdversaire[taille_bouton_coule].setDisabledIcon(
																new ImageIcon("./img/bateau_qui_coule_mer.png"));
														jbCasesAdversaire[touche1_bateau_adv].setDisabledIcon(
																new ImageIcon("./img/bateau_qui_coule_mer.png"));
														score_joueur = score_joueur + 2;
														panelAffichage.getJl_score_joueur().setText("" + score_joueur);

													}
												}
											}
										}
									}
								}
							} else {
								jbCasesAdversaire[taille_bouton_coule].setEnabled(false);
								jbCasesAdversaire[taille_bouton_coule].setDisabledIcon(new ImageIcon("./img/rate.png"));
								panelAffichage.getJl_commentaire_center()
										.setIcon(new ImageIcon("./img/rate_milieu.png"));
								panelAffichage.getJl_commentaire_joueur().setText("Rate ! Dans l'eau !");
								panelAffichage.getJl_commentaire_emotion_joueur()
										.setIcon(new ImageIcon("./img/joueur_rate.png"));

							}

							// FIN DE JEU

							// Si le joueur a gagne
							if (nbBateauxCoulesAdversaire == 19) {
								System.out.println("Bravo vous avez gagne !");
								new FenetreFinGagne(fen);
							}

							// Si le joueur a perdu
							if (nbBateauxCoulesJoueur == 19) {
								System.out.println("Dommage vous avez perdu !");
								new FenetreFinPerdu(fen);
							}

						}
					});
				}
				this.panelJoueur.getGrilleJoueur().add(this.jbCasesJoueur[taille]);
				this.panelAdversaire.getGrilleAdversaire().add(this.jbCasesAdversaire[taille]);
				taille++;
			}
		}

	}

}