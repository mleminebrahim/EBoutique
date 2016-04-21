package net.lemine.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.lemine.eboutique.entities.*;
import net.lemine.eboutique.metier.*;

@Controller
@RequestMapping(value = "/adminProd")
public class AdminProduitsController {
	@Autowired
	private IAdminProduitsMetier metier;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "produits";
	}

	@RequestMapping(value = "/saveProd")
	public String saveProd(@Valid Produit p, BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException {

		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", metier.listCategories());
			model.addAttribute("produits", metier.listproduits());
			return ("produits");
		}

		if (!file.isEmpty()) {
			// BufferedImage bi = ImageIO.read(file.getInputStream());
			String path = System.getProperty("java.io.tmpdir");
			p.setPhoto(file.getOriginalFilename());
			Long idP;
			if (p.getIdProduit() == null) {
				idP = metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
			} else {
				metier.modifierProduit(p);
				idP = p.getIdProduit();
			}

			file.transferTo(new File(path + "/" + "PROD_" + idP + "_" + file.getOriginalFilename()));
		} else {
			if (p.getIdProduit() == null) {
				metier.ajouterProduit(p, p.getCategorie().getIdCategorie());
			} else {
				metier.modifierProduit(p);
			}
		}

		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "produits";
	}

	@RequestMapping(value = "/suppProd")
	public String suppProd(Long idProd, Model model) {
		metier.supprimerProduit(idProd);
		model.addAttribute("produit", new Produit());
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("produits", metier.listproduits());
		return "produits";
	}

	@RequestMapping(value = "/editProd")
	public String editCat(Long idProd, Model model) {
		Produit p = metier.getProduit(idProd);
		// model.addAttribute("editedCat", c);
		model.addAttribute("produit", p);
		model.addAttribute("categories", metier.listCategories());
		model.addAttribute("produits", metier.listproduits());
		return "produits";
	}

	@RequestMapping(value = "photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoProd(Long idProd) throws IOException {
		Produit p = metier.getProduit(idProd);
		String path = System.getProperty("java.io.tmpdir") + "/" + "PROD_" + idProd + "_" + p.getPhoto();
		File f = new File(path);
		return IOUtils.toByteArray(new FileInputStream(f));
	}

}
