package net.lemine.eboutique.dao;

import java.util.List;

import net.lemine.eboutique.entities.*;

public interface IBoutiqueDao {
	public Long ajouterCategorie(Categorie c);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);
	
	
	public Long ajouterProduit(Produit p, Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCatergorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit p);
	
	public void ajouterUser(User u);
	public void attribuerRole(Role r, Long userID);
	public Commande enregistrerCommande(Panier p, Client c);

}
