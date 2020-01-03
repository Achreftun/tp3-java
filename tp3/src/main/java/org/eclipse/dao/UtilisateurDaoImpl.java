package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Utilisateur;

public class UtilisateurDaoImpl implements Dao<Utilisateur> { // ou PersonneDao {
	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"INSERT INTO utilisateur (nom,prenom, sexe,type) VALUES (?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, utilisateur.getNom());
				ps.setString(2, utilisateur.getPrenom());
				ps.setString(3, "" + utilisateur.getSexe());
				ps.setString(4, "" + utilisateur.getType());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					utilisateur.setNumero(resultat.getInt(1));
					return utilisateur;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Utilisateur findById(int id) {
		Connection c = MyConnection.getConnection();
		Utilisateur utilisateur = null;
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM utilisateur WHERE numero = ?; ");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					int num = result.getInt("numero");
					String nom = result.getString("nom");
					String prenom = result.getString("prenom");
					char sexe = result.getString("sexe").charAt(0);
					char type = result.getString("type").charAt(0);
					utilisateur = new Utilisateur(num, nom, prenom, sexe, type);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return utilisateur;
	}

	@Override
	public void remove(Utilisateur utilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM utilisateur WHERE numero= ?;");
				ps.setInt(1, utilisateur.getNumero());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Utilisateur update(Utilisateur utilisateur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"UPDATE utilisateur SET nom = ?, prenom = ?, sexe = ?, type = ?  WHERE numero = ?;");
				ps.setString(1, utilisateur.getNom());
				ps.setString(2, utilisateur.getPrenom());
				ps.setString(3, "" + utilisateur.getSexe());
				ps.setString(4, "" + utilisateur.getType());
				ps.setInt(5, utilisateur.getNumero());
				int r = ps.executeUpdate();
				if (r != -1)
					return utilisateur;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Utilisateur> getAll() {
		Connection c = MyConnection.getConnection();
		List<Utilisateur> utilisateurs = null;
		if (c != null) {
			try {
				utilisateurs = new ArrayList<Utilisateur>();
				PreparedStatement ps = c.prepareStatement("SELECT * FROM utilisateur");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int num = result.getInt("numero");
					String nom = result.getString("nom");
					String prenom = result.getString("prenom");
					char sexe = result.getString("sexe").charAt(0);
					char type = result.getString("type").charAt(0);
					Utilisateur utilisateur = new Utilisateur(num, nom, prenom, sexe, type);
					utilisateurs.add(utilisateur);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return utilisateurs;
	}
	public Utilisateur findByNomAndPrenom(String pnom, String pprenom) {
		Connection c = MyConnection.getConnection();
		Utilisateur utilisateur = null;
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM utilisateur WHERE nom = ? AND prenom = ?;");
				ps.setString(1, pnom);
				ps.setString(2, pprenom);
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					int num = result.getInt("numero");
					String nom = result.getString("nom");
					String prenom = result.getString("prenom");
					char sexe = result.getString("sexe").charAt(0);
					char type = result.getString("type").charAt(0);
					utilisateur = new Utilisateur(num, nom, prenom, sexe, type);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return utilisateur;
	}
}