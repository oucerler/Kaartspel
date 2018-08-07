package Spel;

import java.util.ArrayList;

public class Kaartspel
{//eerst nadenken: hoe ga je de stok kaarten an sich maken? individuele kaarten? aparte klasse maken
	
	//spelers gedeclareerd en geinitialiseerd

	public static void main(String[] args)
	{
		Speler speler1 = new Speler();
		Speler speler2 = new Speler();
		StokKaarten deStok = new StokKaarten();
		boolean oorlogje;
		deStok.schudden();
		System.out.println("Kaarten zijn geschud zie beneden");
		System.out.println(deStok);
		System.out.println("Verdeel de kaarten");
//		deStok.delen(speler1, speler2);
		
		for (int i =0; i<52; ) {
			if (i<52) speler1.krijgKaart(deStok.geefkaart(i++));
			if (i<52) speler2.krijgKaart(deStok.geefkaart(i++));
		}
		
		StringBuilder sb = new StringBuilder();
		for (Kaart kaart : speler1.stok) {

			sb.append(kaart.toString()+"\n");
		}
		System.out.println("Speler1 heeft de volgende kaarten" + "\n" + sb.toString());

		sb = new StringBuilder();
		for (Kaart kaart : speler2.stok) {

			sb.append(kaart.toString()+"\n");
		}
		System.out.println("Speler2 heeft de volgende kaarten" + "\n" + sb.toString());
		
//		void spelen()
//		{
//		oorlogje = false;
//		
//		}

	}
	
	
}
