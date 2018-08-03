package Spel;

public class Kaart
//hiermee zorg ik ervoor dat ik een blueprint voor alle kaarten maak
{
	private String kaartNaam, soort;//deze soort is algemeen
	private int kaartWaarde;
	//maak het private omdat ik niet wil dat iets erbuiten het kan beinvloeden
	//ok hoe gaan we deze waardes setten? We gaan een speciale method genaamd constructor maken
	
	public Kaart(String soort, String kaart, int waarde)
	//ik geef argumenten mee om de class informatie mee te geven
	{
		this.soort = soort; //hier geef ik dus de soort door, dus klaveren harten etc
		//deze variabele is LOCAL, nu voeg ik 'this.' toe om
		this.kaartNaam = kaart;//hier hoef ik geen 'this.' te doen omdat ze verschillende namen hebben
		this.kaartWaarde = waarde;
	}
	
	public String toString()
	{
		return soort + " " + kaartNaam;
	}
	
	public int getKaartWaarde()
	{
		return kaartWaarde;
	}
	
	public static void main(String [] args)
	{
		Kaart schoppenAas = new Kaart("Schoppen", "Aas", 14);
		Kaart hartenKoningin = new Kaart ("Harten", "Koningin", 12);
		//nu hebben we een object, deze hebben we geinstantieerd
		//gaan we dit 52 keer doen?
		System.out.println(schoppenAas);
		//nu krijg je dus Spl.Kaart@987bhfoblabla dus het vertelt me nog niks over de kaart dus zetten we boven een toString
		System.out.println("De schoppen aas heeft een waarde van " + schoppenAas.getKaartWaarde());
		System.out.println("De harten koningin heeft een waarde van " + hartenKoningin.getKaartWaarde());
	}
}
