package Spel;

import java.security.SecureRandom;

public class StokKaarten
{
	//we gaan een array maken
	private Kaart[] stok;//hier is dus een Has A relatie, onze StokKaarten 'has a' array van Kaart
	private int huidigeKaart;	//index voor de vgd kaart die wordt gegeven
	
	//ok laten we eerst de constructor bouwen
	public StokKaarten() //nieuwe instantiering van StokKaarten
	{
		//eerst 2 arrays maken om alles door te komen
		String[] namen = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Boer", "Koningin", "Koning", "Aas"};
		String[] soorten = {"Ruiten", "Harten", "Schoppen", "Klaveren"};
		
		stok = new Kaart[52];//dus 52 instantieringen van Kaart objecten
		huidigeKaart = 0;
		
		final int rijen = 4;
		final int columns = 13;
		
		//ik ga hetzelfde voor alle kaarten doen, in de array, dus we gaan twee for loops maken
		//eentje voor de rijen
		//en eentje voor de columns
		
		for (int soort =0; soort < 4; soort++)
		{
			for (int plaatje =0; plaatje < 13; plaatje++)
			{
				//we hebben nu dus soort begint bij 0 en plaatje begint bij 0
				//dus een nieuwe instance van onze kaart maken
				stok[(plaatje + (soort*13))] = new Kaart(
				soorten[soort],//deze roept dus de soort array op om de naam van de soort te krijgen
				//wat het plaatje is plus soort * 13, maar bij mij begint 0 dus bij 2 in mijn kaartenreeks
				namen[plaatje],//roept de namen array op om het plaatje zn naam te krijgen
				plaatje+2);//waarde vd kaart als een int
				//als we nu dus een instance ve kaart creeren krijgen we dr 52
			}
		}//einde vd constructor
	}
	
	public String toString()//deze method print de stok kaarten
	{
		StringBuilder sb = new StringBuilder();
		for (Kaart kaart : stok) {

			sb.append(kaart.toString());
//			System.out.println(kaart);
		}
		return sb.toString();
	}
	
	//nu de kaarten schudden
	public void schudden()
	{
		huidigeKaart = 0;//opnieuw eerste kaart op 0 zetten om opnieuw te delen vanaf de stapel, instance variable die naar de vgd kaart wijst
		//voor elke willekeurige kaart wisselen met een andere kaart
		
		SecureRandom randomNumber = new SecureRandom();
		
		for (int eerste = 0; eerste < stok.length; eerste++)
		{
			int tweede = randomNumber.nextInt(52);//willekeurige kaart selecteren
			
			//nu de kaarten wisselen cq schudden
			Kaart temp = stok[eerste];
			stok[eerste] = stok[tweede];
			stok[tweede] = temp;
		}
	}


	void delen(Speler speler1, Speler speler2)
	{
		for (int eerste = 0; eerste < stok.length;)
		{
			speler1.krijgKaart(stok[eerste++]);
			speler2.krijgKaart(stok[eerste++]);
		}


		StringBuilder sb = new StringBuilder();
		for (Kaart kaart : speler1.stok) {

			sb.append(kaart.toString()+"\n" );
//			System.out.println(kaart);
		}
		System.out.println("Speler1 heeft de volgende kaarten" + "\n" + sb.toString());

		sb = new StringBuilder();
		for (Kaart kaart : speler2.stok) {

			sb.append(kaart.toString()+"\n" );
//			System.out.println(kaart);
		}
		System.out.println("Speler2 heeft de volgende kaarten" + "\n" + sb.toString());

	}
		//ik moet een check uitvoeren, want voor we delen wijst ie naar de eerste kaart, daarna tweede, etc.
		//kan enkel voor de complete stok kaarten
		//dus de instance huidigeKaart loopt de hele tijd door
//		if (huidigeKaart < stok.length)
//			return stok [huidigeKaart++];
//		else
//			return null;

	public Kaart geefkaart(int i) {
		if (i < 52) {
			return stok[i];
		}
		return null;
	}
}//einde vd class