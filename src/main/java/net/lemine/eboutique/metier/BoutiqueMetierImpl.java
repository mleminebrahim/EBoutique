package net.lemine.eboutique.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import net.lemine.eboutique.dao.IBoutiqueDao;
import net.lemine.eboutique.entities.Categorie;
import net.lemine.eboutique.entities.Client;
import net.lemine.eboutique.entities.Commande;
import net.lemine.eboutique.entities.Panier;
import net.lemine.eboutique.entities.Produit;
import net.lemine.eboutique.entities.Role;
import net.lemine.eboutique.entities.User;

@Transactional
public class BoutiqueMetierImpl implements IAdminCategoriesMetier{
	
	private IBoutiqueDao dao;
	
	

	public void setDao(IBoutiqueDao dao) {
		this.dao = dao;
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {
		dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produit p) {
		dao.modifierProduit(p);
	}

	@Override
	public List<Categorie> listCategories() {
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listproduits() {
		
		return dao.listproduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCatergorie(Long idCat) {
		
		return dao.produitsParCatergorie(idCat);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idP) {
		
		return dao.getProduit(idP);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategorie(Long idCat) {
		dao.supprimerCategorie(idCat);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);
	}

	@Override
	public void ajouterUser(User u) {
		dao.ajouterUser(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		dao.attribuerRole(r, userID);
	}

}
