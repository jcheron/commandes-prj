package edu.commandes.models;

public class DetailCommande {
	private int quantite;
	private Produit leProduit;

	public DetailCommande(Produit p, int quantite) {
		this.leProduit = p;
		this.quantite = quantite;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Produit getLeProduit() {
		return leProduit;
	}

	public void setLeProduit(Produit leProduit) {
		this.leProduit = leProduit;
	}
}
