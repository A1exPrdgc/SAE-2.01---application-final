 package metier;

public class Route 
{
	private int nbTroncons;
	private Mine MineDep;
	private Mine MineArr;

	public Route(int nbTroncons ,Mine MineDep, Mine MineArr)
	{
		if(this.nbTroncons < 0)
		{
			this.nbTroncons = 0;
		}
		else
		{
			if(this.nbTroncons > 10)
			{
				this.nbTroncons = 10;
			}
			else
			{
				this.nbTroncons = nbTroncons;
			}
		}
		this.MineDep = MineDep;
		this.MineArr = MineArr;
	}

	public int getNbTroncons()
	{
		return this.nbTroncons;
	}

	public Mine getMineDep()
	{
		return this.MineDep;
	}

	public Mine getMineArr()
	{
		return this.MineArr;
	}
}