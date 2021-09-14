package edu.commandes.models;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commande {
	private Date date;
	private Client leClient;
	private Map<String, DetailCommande> lesDetails;

	public Commande(Client client) {
		this.leClient = client;
		lesDetails = new HashMap<>();
		date = new Date();
	}

	public void addProduit(Produit produit, int quantite) {
		if (lesDetails.containsKey(produit.getRef())) {
			incProduit(produit.getRef(), quantite);
		} else {
			this.lesDetails.put(produit.getRef(), new DetailCommande(produit, quantite));
		}
	}

	public void incProduit(String ref, int quantite) {
		int index = lesDetails.indexOf(DetailCommande.getRef(ref));
		if (index != -1) {
			lesDetails.get(index).incQuantite(quantite);
		}
	}

	public float getMontant() {
		float montant = 0;
		for (DetailCommande ligneDetail : this.lesDetails) {
			montant += ligneDetail.getQuantite() * ligneDetail.getLeProduit().getPu();
		}
		return montant;
	}

	public int getQuantiteProduits() {
		int quantite = 0;
		for (DetailCommande ligneDetail : this.lesDetails) {
			quantite += ligneDetail.getQuantite();
		}
		return quantite;
	}

	public boolean retireLigneDetail(String ref) {
		/*
		 * for (DetailCommande ligneDetail : this.lesDetails) { if
		 * (ref.equals(ligneDetail.getLeProduit().getRef())) { return
		 * this.lesDetails.remove(ligneDetail); } } return false;
		 */
		return lesDetails.remove(new DetailCommande(new Produit(ref, 0), 0));
	}

	public List<DetailCommande> getLesDetails() {
		return lesDetails;
	}
}
