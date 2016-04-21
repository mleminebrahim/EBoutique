package net.lemine.eboutique.metier;

import net.lemine.eboutique.entities.*;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier{
	
	public Long ajouterCategorie(Categorie c);
	public void supprimerCategorie(Long idCat);
	public void modifierCategorie(Categorie c);
	public void ajouterUser(User u);
	public void attribuerRole(Role r, Long userID);
	
}
