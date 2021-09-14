package edu.commandes.models;

public class Produit {
	private float pu;
	private String ref;

	public Produit(String ref, float pu) {
		this.ref = ref;
		this.pu = pu;
	}

	public float getPu() {
		return this.pu;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}
}
