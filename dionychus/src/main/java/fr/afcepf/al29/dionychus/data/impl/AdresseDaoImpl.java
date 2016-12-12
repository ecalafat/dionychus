package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.AdresseDaoItf;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.mapper.AdresseMapper;

public class AdresseDaoImpl implements AdresseDaoItf {
	
	JdbcTemplate jdbcTemplate;
	DataSource dataSource;
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Adresse> getAll() {
		String SQL = "SELECT a.id_adresse, a.libelle, a.complement,a.adresse_facturation,a.adresse_livraison, v.id_ville,v.libelle,v.code_postal,p.id_pays,p.libelle FROM adresse a INNER JOIN ville v INNER JOIN pays p WHERE a.id_ville = v.id_ville AND v.id_pays = p.id_pays ORDER BY a.libelle";
		return jdbcTemplate.query(SQL, new AdresseMapper());
	}

	@Override
	public Adresse getById(Integer paramIdAdresse) {
		String SQL = "SELECT a.id_adresse, a.libelle, a.complement,a.adresse_facturation,a.adresse_livraison, v.id_ville,v.libelle,v.code_postal,p.id_pays,p.libelle FROM adresse a INNER JOIN ville v INNER JOIN pays p WHERE a.id_ville = v.id_ville AND v.id_pays = p.id_pays AND a.id_adresse = ? ORDER BY a.libelle";
		return jdbcTemplate.queryForObject(SQL, new Object[] {paramIdAdresse}, new AdresseMapper());
	}

	@Override
	public List<Adresse> getAdresseByIdActeur(Integer paramIdActeur) {
		// TODO Auto-generated method stub
		return null;
	}

}
