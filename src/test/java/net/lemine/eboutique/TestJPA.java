package net.lemine.eboutique;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.lemine.eboutique.entities.*;
import net.lemine.eboutique.metier.*;

public class TestJPA {
	ClassPathXmlApplicationContext app;

	@Before
	public void setUp() throws Exception {
		app = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
	}

	@Test
	public void test1() {
		try {

			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) app.getBean("metier");
			List<Categorie> cts1 = metier.listCategories();
			metier.ajouterCategorie(new Categorie("Ordinateurs", null, "Ordddddddddd", "image1.jpg"));
			metier.ajouterCategorie(new Categorie("Imprimentes", null, "impppppppppp", "image2.jpg"));
			metier.ajouterCategorie(new Categorie("Imprimentes2222", null, "impppppppppp", "image3.jpg"));
			// metier.supprimerCategorie(3L);
			List<Categorie> cts2 = metier.listCategories();
			assertTrue(cts1.size() + 3 == cts2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}

	}

	@Test
	public void test2() {
		try {

			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) app.getBean("metier");
			List<Produit> prods1 = metier.listproduits();
			metier.ajouterProduit(new Produit("HP44ERT", "HP7890", 6000, 10, true, "image1.jpg"), 1L);
			metier.ajouterProduit(new Produit("AZERTY", "HP7890", 6000, 10, true, "image2.jpg"), 1L);
			List<Produit> prods2 = metier.listproduits();

			Categorie c = new Categorie("Ordinateurs", null, "Ordddddddddd", "image1.jpg");
			Produit p = new Produit("HP44ERT", "HP7890", 6000, 10, true, "image1.jpg");
			p.setCategorie(c);
			assertTrue(prods1.size() + 2 == prods2.size() & p.getCategorie() != null);

		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}

	}

}
