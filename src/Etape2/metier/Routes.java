package Etape2.metier;

import Etape2.metier.Mine;

public class Routes
{
	private int nbTroncon;
	private Mine villeDep;
	private Mine villeArriv;

	public Routes(int nbTroncon, Mine villeDep, Mine villeArriv)
	{
		if (this.nbTroncon < 1)
		{
			this.nbTroncon = 1;
		}
		else
		{
			if(this.nbTroncon > 2)
			{
				this.nbTroncon = 2;
			}
			else
			{
				this.nbTroncon = nbTroncon;
			}
		}

		this.villeDep = villeDep;
		this.villeArriv = villeArriv;
	}

	public int getNbTroncon()
	{
		return this.nbTroncon;
	}

	public Mine getVilleDep()
	{
		return this.villeDep;
	}

	public Mine getVilleArriv()
	{
		return this.villeArriv;
	}

}