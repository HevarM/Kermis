package kermisPackage;

import java.util.*;

public class Kermis {
	static ArrayList<Attractie> al = new ArrayList<Attractie>();
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.start(al);
			
	}
}
class Kassa {
	public void omzet(ArrayList<Attractie> al) {
		double sumOmzet = 0;
		for(Attractie a: al) {
			sumOmzet += a.omzet;
		}
		System.out.println("Totale omzet is €" +sumOmzet);
	}
	
	public void aantalKaartjes(ArrayList<Attractie> al) {
		int totaleKaartjes = 0;
		for(Attractie a: al) {
			totaleKaartjes += a.aantalKaartjes;
		}
		System.out.println("Totaal verkochtte kaarten " +totaleKaartjes);
	}	
}
class Menu {
	void start(ArrayList<Attractie> al) {
	BotsAuto botsauto = new BotsAuto("Botsauto", 0, 2.50, 0);
	Spin spin = new Spin("spin", 0, 2.25, 0);
	SpiegelPaleis spiegelpaleis = new SpiegelPaleis("SpiegelPaleis", 0, 2.75, 0);
	Spookhuis spookhuis = new Spookhuis("Spookhuis", 0, 3.20, 0);
	Hawaii hawaii = new Hawaii("Hawaii", 0, 2.90, 0);
	LadderKlimmen ladderklimmen = new LadderKlimmen("Ladderklimmen", 0, 5.00, 0);
	boolean quit = false;
	Scanner scanner = new Scanner(System.in);
	String KeuzeMaken;
	
	al.add(botsauto);
	al.add(spin);
	al.add(spiegelpaleis);
	al.add(spookhuis);
	al.add(hawaii);
	al.add(ladderklimmen);
	
	do {
		System.out.print("Welkom bij de Kermis! \n" +
				"Kies 1 voor botsauto's. \n" +
				"Kies 2 voor spin. \n" + 
				"Kies 3 voor spiegelpaleis. \n" + 
				"Kies 4 voor spookhuis. \n" + 
				"Kies 5 voor hawaii. \n" + 
				"Kies 6 voor ladderklimmen.\n" + 
				"");
        KeuzeMaken = scanner.nextLine();

        switch (KeuzeMaken) {

        case "1": botsauto.draaien();
              break;
              
        case "2": spin.draaien();
              break;
              
        case "3": spiegelpaleis.draaien();
              break;
              
        case "4": spookhuis.draaien();
              break;
              
        case "5": hawaii.draaien();
              break;
              
        case "6": ladderklimmen.draaien();
        	  break;
              
        case "o": System.out.println("Attractienaam\tTotale Omzet\n================================\n" 
				+ botsauto.naam + "\t" + (botsauto.omzet) + "\n"
				+ spin.naam+ "\t\t" + (spin.omzet) + "\n"+ spookhuis.naam+ "\t" + (spookhuis.omzet) + "\n"
				+ spiegelpaleis.naam+ "\t" + (spiegelpaleis.omzet) + "\n"+ hawaii.naam+ "\t\t" + (hawaii.omzet) + "\n"
				+ ladderklimmen.naam+ "\t" + (ladderklimmen.omzet)+"\n");
          	  break;
          	  
        case "k": System.out.println("Attractienaam\tKaartjes Verkocht\n================================\n" 
				+ botsauto.naam + "\t" + (botsauto.aantalKaartjes) + "\n"
				+ spin.naam+ "\t\t" + (spin.aantalKaartjes) + "\n"+ spookhuis.naam+ "\t" + (spookhuis.aantalKaartjes) + "\n"
				+ spiegelpaleis.naam+ "\t" + (spiegelpaleis.aantalKaartjes) + "\n"+ hawaii.naam+ "\t\t" + (hawaii.aantalKaartjes) + "\n"
				+ ladderklimmen.naam+ "\t" + (ladderklimmen.aantalKaartjes)+"\n");
  			  break;
  			  
        case "s": spin.monteur();
  			  break;
  			  
        case "h": hawaii.monteur();
  			  break;
  			  
        case "b": ladderklimmen.reserverenBelasting();
  			  break;
  				
        default: System.out.println("Invalid input!");
        	}
		} while (!quit);
	}
}	
class Attractie {
	double prijs;
	double omzet;
	public String naam;
	double oppervlakte;
	int aantalKaartjes;
	int totaleKaartjes;
	public Attractie (String naam, double oppervlakte, double prijs, int aantalKaartjes) {
	this.naam = naam;
	this.oppervlakte = oppervlakte;
	this.prijs = prijs;
	this.aantalKaartjes = aantalKaartjes;
	}
	
	void draaien() {
		aantalKaartjes++;
		System.out.println(naam+ " draait voor €" +prijs);
		omzet += prijs;
		totaleKaartjes += aantalKaartjes;
	}
}

class BotsAuto extends Attractie {
	public BotsAuto (String naam, double oppervlakte, double prijs, int aantalKaartjes)
	{
		super (naam, oppervlakte, prijs, aantalKaartjes);
	}
}

class Spin extends RisicoRijkeAttracties {
	public Spin (String naam, double oppervlakte, double prijs, int aantalKaartjes)
	{	
		super (naam, oppervlakte, prijs, aantalKaartjes);
		limiet = 5 ;
	}
}

class SpiegelPaleis extends Attractie {
	public SpiegelPaleis (String naam, double oppervlakte, double prijs, int aantalKaartjes)
	{
		super (naam, oppervlakte, prijs, aantalKaartjes);
	}
}

class Spookhuis extends Attractie {
	public Spookhuis (String naam, double oppervlakte, double prijs, int aantalKaartjes)
	{
		super (naam, oppervlakte, prijs, aantalKaartjes);
	}
}

class Hawaii extends RisicoRijkeAttracties {
	public Hawaii (String naam, double oppervlakte, double prijs, int aantalKaartjes)
	{
		super (naam, oppervlakte, prijs, aantalKaartjes);
		limiet = 10;
	}
}

class LadderKlimmen extends GokAttracties implements kansSpelBelasting {
	public LadderKlimmen (String naam, double oppervlakte, double prijs, int aantalKaartjes)
	{
		super (naam, oppervlakte, prijs, aantalKaartjes);
	}
	
	public void reserverenBelasting() {
		System.out.println("Er is €"+(omzet*belasting)+" belasting over de omzet gereserveerd.");	
	}
}

class GokAttracties extends Attractie {
	public GokAttracties(String naam, double oppervlakte, double prijs, int aantalKaartjes) 
	{
		super(naam, oppervlakte, prijs, aantalKaartjes);
	}
}

interface kansSpelBelasting {
	double belasting = 0.30;
	void reserverenBelasting();
}

abstract class RisicoRijkeAttracties extends Attractie{
	int limiet;
	int aantalTotLimiet;
	public RisicoRijkeAttracties(String naam, double oppervlakte, double prijs, int aantalKaartjes) 
	{
		super(naam, oppervlakte, prijs, aantalKaartjes);
	}
	@Override
	public void draaien() {
		if (aantalTotLimiet == limiet) {
			System.out.println("Er is onderhoud nodig! Bel de Monteur!");
		}	else {
			aantalKaartjes++;
			System.out.println(naam+ " draait voor €" +prijs);
			omzet += prijs;
			totaleKaartjes += aantalKaartjes;
			this.aantalTotLimiet++;
		}
	}
	public void monteur() {
		System.out.println("De attractie is gemaakt, hij kan weer draaien!");
		aantalTotLimiet = 0;
	}
}