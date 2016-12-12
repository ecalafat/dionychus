package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Utilisateur;

public class UtilisateurMapper implements RowMapper<Utilisateur> {

	@Override
	public Utilisateur mapRow(ResultSet rs, int intRow) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdActeur(rs.getInt("id_acteur"));
		utilisateur.setDateNaissance(rs.getDate("date_naissance"));
		utilisateur.setOptin(rs.getBoolean("optin"));
		utilisateur.setLogin(rs.getString("login"));
		utilisateur.setPassword(rs.getString("password"));
		// TODO RECUPERER LE TYPE ACCES, DONC MODIFIER LES BOUTS DE REQUETES EN RAJOUTANT LES ALIAS
		utilisateur.setAdresseMail(rs.getString("adresse_mail"));
		return null;
	}

}
