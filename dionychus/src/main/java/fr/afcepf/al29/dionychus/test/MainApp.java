package fr.afcepf.al29.dionychus.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al29.dionychus.data.itf.AccessoireDaoItf;
import fr.afcepf.al29.dionychus.data.itf.AdresseDaoItf;
import fr.afcepf.al29.dionychus.data.itf.AppelationDaoItf;
import fr.afcepf.al29.dionychus.data.itf.AromeDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CepageDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CommandeClientDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CommandeStockDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CommentaireDaoItf;
import fr.afcepf.al29.dionychus.data.itf.FournisseurDaoItf;
import fr.afcepf.al29.dionychus.data.itf.LigneCommandeDaoItf;
import fr.afcepf.al29.dionychus.data.itf.LivraisonDaoItf;
import fr.afcepf.al29.dionychus.data.itf.PaysDaoItf;
import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.data.itf.StatutCommandeDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeAccesDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeAccessoireDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeLivraisonDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeVinDaoItf;
import fr.afcepf.al29.dionychus.data.itf.UtilisateurDaoItf;
import fr.afcepf.al29.dionychus.data.itf.VilleDaoItf;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Appelation;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Article;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.CommandeStock;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.entity.Fournisseur;
import fr.afcepf.al29.dionychus.entity.LigneCommande;
import fr.afcepf.al29.dionychus.entity.Livraison;
import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.StatutCommande;
import fr.afcepf.al29.dionychus.entity.TypeAcces;
import fr.afcepf.al29.dionychus.entity.TypeAccessoire;
import fr.afcepf.al29.dionychus.entity.TypeLivraison;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.entity.Utilisateur;
import fr.afcepf.al29.dionychus.entity.Ville;
import fr.afcepf.al29.dionychus.entity.Vin;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Beans.xml");

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
		UtilisateurDaoItf uDao = (UtilisateurDaoItf) context.getBean("utilisateurJDBCtemplate");
		CommandeClientDaoItf ccDao = (CommandeClientDaoItf) context.getBean("commandeClientJDBCtemplate");
		CommandeStockDaoItf csDao = (CommandeStockDaoItf) context.getBean("commandeStockJDBCtemplate");
		VilleDaoItf vDao = (VilleDaoItf) context.getBean("villeJDBCtemplate");
		CommentaireDaoItf comDao = (CommentaireDaoItf) context.getBean("commentaireJDBCtemplate");
		FournisseurDaoItf fDao = (FournisseurDaoItf) context.getBean("fournisseurJDBCtemplate");
		LigneCommandeDaoItf lcDao = (LigneCommandeDaoItf) context.getBean("ligneCommandeJDBCtemplate");
		LivraisonDaoItf livDao = (LivraisonDaoItf) context.getBean("livraisonJDBCtemplate");
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
			System.out.println("Ville : " + adresse.getVille().getLibelle());
			System.out.println("Pays : " + adresse.getVille().getPays().getLibelle());
		}

		System.out.println("Adresse d'id = 1");
		System.out.println((adDao.getById(1)).getLibelle());

		List<Utilisateur> utilisateurs = uDao.getAll();
		System.out.println("Liste des utilisateurs");
		for (Utilisateur utilisateur : utilisateurs) {
			System.out.printf("Nom : %s | Prenom : %s | Type d'accès : %s\n", utilisateur.getNom(),
					utilisateur.getPrenom(), utilisateur.getTypeAcces().getLibelle());
		}

		// TypeAcces typeAccesTest = new TypeAcces(3, "Multipass");
		// Utilisateur user = new Utilisateur(null, "toto", "titi",
		// "04917891191", "toto@toto.titi", "Monsieur", null);
		// user.setLogin("unLogin");
		// user.setTypeAcces(typeAccesTest);
		// user.setPassword("unPassword");
		//
		// uDao.addUtilisateur(user);
		//
		//
		// user = uDao.getById(11);
		// System.out.println("Utilisateur d'id "+ user.getIdActeur() + " " +
		// user.getNom() + " " + user.getPrenom());
		//
		// user.setPrenom("unAutrePrenom");
		// uDao.updateUtilisateur(user);
		// user = uDao.getById(11);
		// System.out.println("Utilisateur d'id "+ user.getIdActeur() + " " +
		// user.getNom() + " " + user.getPrenom());
		//
		// uDao.deleteUtilisateur(11);

		List<CommandeClient> commandesClients = ccDao.getAll();
		System.out.println("Liste des commandes client");
		System.out.println(commandesClients.size());
		for (CommandeClient commandeClient : commandesClients) {
			System.out.println(commandeClient.getNumeroReference() + " " + commandeClient.getIdCommande());
		}

		StatutCommande statutCommandeTest = new StatutCommande(1, "panier");
		Utilisateur utilisateurCommandeClient = new Utilisateur();
		utilisateurCommandeClient.setIdActeur(3);
		List<LigneCommande> lignesCommandes = new ArrayList<>();
		Promotion promotionCommandeClient = new Promotion();
		promotionCommandeClient.setIdPromotion(1);
		CommandeClient commandeClient = new CommandeClient(null, new Date(0), "oifzhorzrrgf", statutCommandeTest,
				lignesCommandes, new Date(0), utilisateurCommandeClient, promotionCommandeClient);

		// ccDao.addCommandeClient(commandeClient);
		// commandeClient.setIdCommande(9);
		// commandeClient.setNumeroReference("nouveauNumRef2");
		// ccDao.updateCommandeClient(commandeClient);

		System.out.println("Liste des commandes stocks");
		List<CommandeStock> commandesStock = csDao.getAll();
		for (CommandeStock commandeStock : commandesStock) {
			System.out.println(commandeStock.getNumeroReference() + " " + commandeStock.getStatutCommande() + " "
					+ commandeStock.getIdCommande());
		}

		System.out.println("Liste des villes de la DB");
		List<Ville> villes = vDao.getAll();
		for (Ville ville : villes) {
			System.out.println(ville);
		}
		System.out.println("Liste des villes de France");
		villes = vDao.getAllByIdPays(1);
		for (Ville ville : villes) {
			System.out.println(ville);
		}

		System.out.println("Liste des commentaires");
		// Commentaire commentaireTest = new Commentaire(null, 4.2, "Commentaire
		// de qualite");
		// comDao.addCommentaire(commentaireTest, 1, 3);
		// commentaireTest.setIdCommentaire(8);
		// commentaireTest.setDescription("Commentaire update de qualite");
		// comDao.updateCommentaire(commentaireTest);
		List<Commentaire> commentaires = comDao.getAllByUtilisateur(3);
		for (Commentaire commentaire : commentaires) {
			System.out.println(commentaire);
		}
		// comDao.deleteCommentaire(8);

		System.out.println("Liste des fournisseurs");
		List<Fournisseur> fournisseurs = fDao.getAll();
		// Fournisseur fournisseurTest = new
		// Fournisseur(null,"nom","prenom","numtel","email","civilite",null);
		// fDao.addFournisseur(fournisseurTest);
		// fournisseurTest.setIdActeur(4);
		// fournisseurTest.setNom("nouveauNom");
		// fDao.updateFournisseur(fournisseurTest);
		for (Fournisseur fournisseur : fournisseurs) {
			System.out.println(fournisseur);
		}
		// fournisseurTest = fDao.getById(4);
		// System.out.println("ID 1 : " + fournisseurTest);
		// fDao.deleteFournisseur(4);

		System.out.println("Liste des lignes de commandes");

		Accessoire accessoireTestLc = new Accessoire(4, "ththththt", "testAccessoire", "Un super test accessoire",
				1000.0, 50, 5, "toto.jpg", "Accessoire", null);
		LigneCommande ligneCommandeTest = new LigneCommande(null, 10, accessoireTestLc);
		lcDao.addLigneCommande(ligneCommandeTest, 1);
		ligneCommandeTest.setQuantite(1337);
		ligneCommandeTest.setIdLigneCommande(11);
		lcDao.updateLigneCommande(ligneCommandeTest);
		List<LigneCommande> lignesCommande = lcDao.getAllByIdCommande(1);
		System.out.println("Taille de la liste " + lignesCommande.size());
		for (LigneCommande ligneCommande : lignesCommande) {
			System.out.println(
					"Quantite : " + ligneCommande.getQuantite() + " ID : " + ligneCommande.getIdLigneCommande());
			if (ligneCommande.getArticle().getTypeArticle().equals("Accessoire")) {
				System.out.println(acDao.getById(ligneCommande.getArticle().getIdArticle()));
			} else {
				System.out.println("Plus tard");
			}
		}
		// lcDao.deleteLigneCommande(10);
		
		System.out.println("Liste des livraisons");
		
		TypeLivraison typeLivraisonTest = new TypeLivraison(1, "toto");
		Utilisateur utilisateurTestLivraison = new Utilisateur(1, "livraisonNom", "livraisonPrenom", "livraisonTel", "livraisonMail", "", null, new Date(0), null, true, null, "loginLivraison", "pwLivraison", null);
		CommandeClient commandeClientTest = new CommandeClient(new Date(0), utilisateurTestLivraison, null);
		commandeClientTest.setIdCommande(1);
		Livraison livraisonTest = new Livraison(null, 50.50,typeLivraisonTest, commandeClientTest);
		livDao.addLivraison(livraisonTest);
		livraisonTest.setTarification(70.50);
		livraisonTest.setIdLivraison(4);
		livDao.updateLivraison(livraisonTest);
		List<Livraison> livraisons = livDao.getAll();
		for (Livraison livraison : livraisons) {
			System.out.println(livraison);
		}

		System.out.println("Fin test JDBC");

	}
}
