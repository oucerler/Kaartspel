package Spel;


public class Kaartspel
{//eerst nadenken: hoe ga je de stok kaarten an sich maken? individuele kaarten? aparte klasse maken
	
	//spelers gedeclareerd en geinitialiseerd

	public static void main(String[] args)
	{
		StokKaarten deStok = new StokKaarten();
		deStok.vulStok();
		deStok.schudden();
				
		StokKaarten speler1 = new StokKaarten();
		StokKaarten speler2 = new StokKaarten();
		
		while (deStok.vulgrens > 0)
		{
			if (deStok.vulgrens > 0)
				{
				Kaart kaart = deStok.geefkaart();
				speler1.voegKaartToe(kaart);
				}
			if (deStok.vulgrens > 0) 
				{
				Kaart kaart = deStok.geefkaart();
				speler2.voegKaartToe(kaart);
				}
		}
		

		StokKaarten stapel = new StokKaarten();
		
		while (speler1.vulgrens > 0 && speler2.vulgrens > 0)
			{
				Kaart kaart1 = speler1.geefkaart();
				Kaart kaart2 = speler2.geefkaart();
				if (kaart1.getKaartWaarde() == kaart2.getKaartWaarde())
					{
					System.out.println("Oorlogje! Leg nog een kaart neer");
					stapel.voegKaartToe(kaart1);
					stapel.voegKaartToe(kaart2);
					continue;
					}
				else if (kaart1.getKaartWaarde() < kaart2.getKaartWaarde())
					{
					System.out.println("Speler 2 wint en krijgt de kaarten");
					speler2.voegKaartToe(kaart1);
					speler2.voegKaartToe(kaart2);
					while (stapel.vulgrens > 0)
						{
						Kaart kaart3 = stapel.geefkaart();
						speler2.voegKaartToe(kaart3);
						}
					}
				else if (kaart1.getKaartWaarde() > kaart2.getKaartWaarde())
					{
					System.out.println("Speler 1 wint en krijgt de kaarten");
					speler1.voegKaartToe(kaart1);
					speler1.voegKaartToe(kaart2);
					while (stapel.vulgrens > 0)
						{
						Kaart kaart3 = stapel.geefkaart();
						speler1.voegKaartToe(kaart3);
						}
					}
			}
}
	
	
	//		Speler speler1 = new Speler();
//	Speler speler2 = new Speler();
	
//	spelen(speler1, speler2);
//	
//	boolean oorlogje;
//	deStok.schudden();
//	System.out.println("Kaarten zijn geschud zie beneden");
//	System.out.println(deStok);
//	System.out.println("Verdeel de kaarten");
////	deStok.delen(speler1, speler2);
//	
//	StringBuilder sb = new StringBuilder();
//	for (Kaart kaart : speler1.stok)
//	{
//		sb.append(kaart.toString()+"\n");
//	}
//	System.out.println("Speler1 heeft de volgende kaarten" + "\n" + sb.toString());
//
//	sb = new StringBuilder();
//	for (Kaart kaart : speler2.stok)
//	{
//		sb.append(kaart.toString()+"\n");
//	}
//	System.out.println("Speler2 heeft de volgende kaarten" + "\n" + sb.toString());	
//}


}


