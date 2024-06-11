package  src.metier;

public class Joueur {
	
	private String nom;
	private int numJoueur;
	private String type;

	public Joueur(String nom, int numJoueur , String type)
	{
		this.nom = nom;
		this.numJoueur = numJoueur;
		this.type = type;
	}

	public String getNom() { return this.nom;}
	public int getNumeroJoueur() { return this.numJoueur;}
	public String getType() { return this.type;}
}
