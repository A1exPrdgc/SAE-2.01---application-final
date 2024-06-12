package Etape2.metier;

import Etape2.metier.Mine;

public class Routes
{
	private int nbTroncon;
	private Mine mineDep;
	private Mine mineArriv;

	public Routes(int nbTroncon, Mine mineDep, Mine mineArriv)
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

		this.mineDep = mineDep;
		this.mineArriv = mineArriv;
	}

	public int getNbTroncon()
	{
		return this.nbTroncon;
	}

	public Mine getMineDep()
	{
		return this.mineDep;
	}

	public Mine getMineArriv()
	{
		return this.mineArriv;
	}

}