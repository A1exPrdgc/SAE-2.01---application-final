package code.metier;

import java.util.ArrayList;
import java.util.ResourceBundle.Control;

import code.metier.*;
import code.Controleur;

public class Main {

	private ArrayList<Jeton> jetonsRessources;
	private Equipe equipe;
	private Controleur ctrl;

	public Main() 
	{
		this.jetonsRessources = new ArrayList<Jeton>();
		initList();
		this.equipe = new Equipe(ctrl, "egbev");

		while (true)
		{
			Jeton jeton = tirerJeton(this.jetonsRessources);
			if (jeton == null)
				break;

			boolean added = equipe.ajouterRessource(jeton);
			System.out.println(
					(jeton.getType() instanceof Minerai ? "Minerai " : "Mine ") + jeton.getType() + " : " + added);
		}
	}
	
	public static Jeton tirerJeton(ArrayList <Jeton> jetonsRessources)
	{
		// Vérifier si la pioche n'est pas vide
		if (!jetonsRessources.isEmpty())
		{
			// Sauvegarder le premier élément avant de le retirer
			Jeton premierJeton = jetonsRessources.get(0);
			jetonsRessources.remove(0);
			return premierJeton;
		}
		else
		{
			return null;
		}
	}

	public void initList()
	{
		this.jetonsRessources.add(new Jeton(Minerai.AL));
		this.jetonsRessources.add(new Jeton(Minerai.AG));
		this.jetonsRessources.add(new Jeton(Minerai.AU));
		this.jetonsRessources.add(new Jeton(Minerai.CO));
		this.jetonsRessources.add(new Jeton(Minerai.FE));
		this.jetonsRessources.add(new Jeton(Minerai.NI));
		this.jetonsRessources.add(new Jeton(Minerai.PT));
		this.jetonsRessources.add(new Jeton(Minerai.TI));
		this.jetonsRessources.add(new Jeton(Minerai.AL));
		this.jetonsRessources.add(new Jeton(Minerai.AG));
	}
	
	public static void main (String[] args) {
		new Main();
	}
 }
