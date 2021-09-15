package edu.commandes.models;

import java.util.Date;
import java.util.HashMap;
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
		if (lesDetails.containsKey(ref)) {
			lesDetails.get(ref).incQuantite(quantite);
		}
	}

	public float getMontant() {
		float montant = 0;
		for (Map.Entry<String, DetailCommande> entry : lesDetails.entrySet()) {
			DetailCommande dt = entry.getValue();
			montant += dt.getQuantite() * dt.getLeProduit().getPu();
		}
		;
		return montant;
	}

	public int getQuantiteProduits() {
		int quantite = 0;
		for (Map.Entry<String, DetailCommande> entry : lesDetails.entrySet()) {
			DetailCommande dt = entry.getValue();
			quantite += dt.getQuantite();
		}
		return quantite;
	}

	public boolean retireLigneDetail(String ref) {
		/*
		 * for (DetailCommande ligneDetail : this.lesDetails) { if
		 * (ref.equals(ligneDetail.getLeProduit().getRef())) { return
		 * this.lesDetails.remove(ligneDetail); } } return false;
		 */
		return lesDetails.remove(ref) != null;
	}

	public Map<String, DetailCommande> getLesDetails() {
		return lesDetails;
	}
}
