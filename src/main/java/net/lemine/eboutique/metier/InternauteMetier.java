package net.lemine.eboutique.metier;

import java.util.List;

import net.lemine.eboutique.entities.Categorie;
import net.lemine.eboutique.entities.Client;
import net.lemine.eboutique.entities.Commande;
import net.lemine.eboutique.entities.Panier;
import net.lemine.eboutique.entities.Produit;
import net.lemine.eboutique.entities.Role;
import net.lemine.eboutique.entities.User;

public interface InternauteMetier {
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCatergorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public Commande enregistrerCommande(Panier p, Client c);

}
