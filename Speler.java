package Spel;

import java.util.ArrayList;
import java.util.Scanner;

public class Speler
{
	public Kaart[] stok = new Kaart[26];
	private int aantalKaarten = 0;
	
	public void krijgKaart(Kaart kaart)
	{
		if (aantalKaarten <26)
		{
			stok[aantalKaarten]=kaart;
			aantalKaarten++;
		}
	}
}