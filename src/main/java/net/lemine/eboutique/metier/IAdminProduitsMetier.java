package net.lemine.eboutique.metier;

import net.lemine.eboutique.entities.*;

public interface IAdminProduitsMetier extends InternauteMetier{
	public Long ajouterProduit(Produit p, Long idCat);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit p);
}
