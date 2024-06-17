package code;

import java.util.Scanner;

import code.Controleur;
import code.metier.Equipe;
import code.metier.Mine;
import java.io.FileInputStream;

public class scenario_1
{
	private Controleur ctrl;

	public scenario_1(Controleur ctrl)
	{
		this.ctrl = ctrl;
		int numero=0;
		String type;

		try 
		{
			Scanner sc = new Scanner(new FileInputStream("scenario_1.run"));

			while (sc.hasNextLine()) 
			{
				type = sc.nextLine();
				numero = sc.nextLine();

				int x = ctrl.getX();
				int y = ctrl.getY();


				switch (type) {
					case "M" -> new Mine(x, y, numero, ctrl.getRegion());
					case "T" -> new Controleur();
					case "JS" -> new Equipe(ctrl, "Syndicat Astral");
					case "JC" -> new Equipe(ctrl, "Corporation Solaire");
					//case "NP" -> 
					//case "FT" -> ;

				}
				
			}
		} 
		
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		
	}
}