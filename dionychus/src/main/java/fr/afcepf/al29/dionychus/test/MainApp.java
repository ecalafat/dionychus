package fr.afcepf.al29.dionychus.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al29.dionychus.data.itf.AccessoireDaoItf;
import fr.afcepf.al29.dionychus.data.itf.AdresseDaoItf;
import fr.afcepf.al29.dionychus.data.itf.AppelationDaoItf;
import fr.afcepf.al29.dionychus.data.itf.AromeDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CepageDaoItf;
import fr.afcepf.al29.dionychus.data.itf.PaysDaoItf;
import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.data.itf.StatutCommandeDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeAccesDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeAccessoireDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeLivraisonDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeVinDaoItf;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Appelation;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.StatutCommande;
import fr.afcepf.al29.dionychus.entity.TypeAcces;
import fr.afcepf.al29.dionychus.entity.TypeAccessoire;
import fr.afcepf.al29.dionychus.entity.TypeLivraison;
import fr.afcepf.al29.dionychus.entity.TypeVin;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:Beans.xml");

		RegionDaoItf rDao = (RegionDaoItf) context.getBean("regionJDBCtemplate");
		CepageDaoItf cDao = (CepageDaoItf) context.getBean("cepageJDBCtemplate");
		AppelationDaoItf aDao = (AppelationDaoItf) context.getBean("appelationJDBCtemplate");
		AromeDaoItf arDao = (AromeDaoItf) context.getBean("aromeJDBCtemplate");
		PaysDaoItf pDao = (PaysDaoItf) context.getBean("paysJDBCtemplate");
		TypeAccesDaoItf taDao = (TypeAccesDaoItf) context.getBean("typeAccesJDBCtemplate");
		TypeAccessoireDaoItf tacDao = (TypeAccessoireDaoItf) context.getBean("typeAccessoireJDBCtemplate");
		TypeLivraisonDaoItf tlDao = (TypeLivraisonDaoItf) context.getBean("typeLivraisonJDBCtemplate");
		TypeVinDaoItf tvDao = (TypeVinDaoItf) context.getBean("typeVinJDBCtemplate");
		StatutCommandeDaoItf scDao = (StatutCommandeDaoItf) context.getBean("statutCommandeJDBCtemplate");
		AccessoireDaoItf acDao = (AccessoireDaoItf) context.getBean("accessoireJDBCtemplate");
		AdresseDaoItf adDao = (AdresseDaoItf) context.getBean("adresseJDBCtemplate");
		System.out.println("Test Spring JDBC");


		
		List<Region> regions = rDao.getAll();

		for (Region region2 : regions) {
			System.out.printf("ID : %d\nNom région : %s\n_________\n", region2.getIdRegion(), region2.getLibelle());
		}
		
		List<Cepage> cepages = cDao.getAll();
		
		for (Cepage cepage : cepages) {
			System.out.println(cepage);
		}
		List<Appelation> appelations = aDao.getAll();
		
		for (Appelation appelation : appelations) {
			System.out.println(appelation);
		}
		List<Arome> aromes = arDao.getAll();
		
		for (Arome arome : aromes) {
			System.out.println(arome);
		}
		
		List<Pays> pays = pDao.getAll();
		
		for (Pays pays2 : pays) {
			System.out.println(pays2);
		}
		
		List<TypeAcces> typeAcces = taDao.getAll();
		
		for (TypeAcces typeAcces2 : typeAcces) {
			System.out.println(typeAcces2);
		}
		
		List<TypeAccessoire> typesAccessoire = tacDao.getAll();
		
		for (TypeAccessoire typeAccessoire : typesAccessoire) {
			System.out.println(typeAccessoire);
		}
		
		System.out.println(tacDao.getById(1));
		
		List<TypeLivraison> typesLivraison = tlDao.getAll();
		
		for (TypeLivraison typeLivraison : typesLivraison) {
			System.out.println(typeLivraison);
		}
		
		List<TypeVin> typesVin = tvDao.getAll();
		
		for (TypeVin typeVin : typesVin) {
			System.out.println(typeVin);
		}
		List<StatutCommande> statutsCommande = scDao.getAll();
		
		for (StatutCommande statutCommande : statutsCommande) {
			System.out.println(statutCommande);
		}
		
		System.out.println(scDao.getById(5));
		
		List<Accessoire> accessoires = acDao.getAll();
		for (Accessoire accessoire : accessoires) {
			System.out.println("Libelle : " + accessoire.getLibelle());
			System.out.println("Description : " + accessoire.getDescription());
			System.out.println(accessoire.getTypeAccessoire().getLibelle());
		}
		System.out.println("Requête by ID : " + (acDao.getById(1)).getLibelle());
		
		List<Adresse> adresses = adDao.getAll();
		System.out.println("Liste des adresses");
		for (Adresse adresse : adresses) {
			System.out.println("Libelle : " + adresse.getLibelle());
			System.out.println("Ville : " +  adresse.getVille().getLibelle());
			System.out.println("Pays : " + adresse.getVille().getPays().getLibelle());
		}
		
		System.out.println("Adresse d'id = 1");
		System.out.println((adDao.getById(1)).getLibelle());
		
		System.out.println("Fin test JDBC");

	}
}
