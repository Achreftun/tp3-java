package org.eclipse.frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.eclipse.dao.UtilisateurDaoImpl;
import org.eclipse.model.Utilisateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ConnexionFrame extends JFrame implements ActionListener {
	private JTextField nomText = new JTextField();
	private JTextField prenomText = new JTextField();
	private JButton btnInscription = new JButton("Inscription");
	private JButton btnConnexion = new JButton("Connexion");
	private static int nbrConnexion = 0;

	public ConnexionFrame() {
		setVisible(true);
		setSize(500, 500);
		setTitle("Connexion");
		getContentPane().setLayout(null);

		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur");
		lblNomDutilisateur.setBounds(51, 74, 117, 14);
		getContentPane().add(lblNomDutilisateur);

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(51, 120, 103, 14);
		getContentPane().add(lblMotDePasse);

		nomText.setBounds(214, 71, 111, 20);
		getContentPane().add(nomText);
		nomText.setColumns(10);

		prenomText.setBounds(214, 117, 111, 20);
		getContentPane().add(prenomText);
		prenomText.setColumns(10);

		btnInscription.setBounds(51, 183, 117, 23);
		getContentPane().add(btnInscription);

		btnConnexion.setBounds(214, 183, 111, 23);
		getContentPane().add(btnConnexion);

		btnInscription.addActionListener(this);
		btnConnexion.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btnConnexion) {
			nbrConnexion++;
			String nom = nomText.getText();
			String prenom = prenomText.getText();
			UtilisateurDaoImpl utilisateurDaoImpl = new UtilisateurDaoImpl();
			Utilisateur utilisateur = utilisateurDaoImpl.findByNomAndPrenom(nom, prenom);
			System.out.println(nbrConnexion);
			if (utilisateur == null) {
				if (nbrConnexion == 3) {
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Identifiant(s) incorrect(s)");
				}
			} else {
				if (utilisateur.getType() == 'a') {
					System.out.println("vous êtes administrateur");
				} else {
					System.out.println("vous êtes simple");
				}
				this.dispose();
			}
		} else {
			InscriptionFrame inscriptionFrame = new InscriptionFrame();
			this.dispose();
		}
	}
}
