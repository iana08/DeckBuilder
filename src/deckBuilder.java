import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;


public class deckBuilder {
	public static boolean addDeck(HashMap<String, Integer> map, Card card) {
		if (map.containsKey(card.getName())) {
			if (map.get(card.getName()) < 3) {
				int num = map.get(card.getName()) + 1;
				map.replace(card.getName(), num);
				return true;
			} else {
				return false;
			}
		} else {
			map.put(card.getName(), 1);
			return true;
		}
	}
	public static ArrayList<Card> BuildDeck(ArrayList<Card> tCards) {
		ArrayList<Card> Deck = new ArrayList<Card>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Random ran = new Random();
		int num = ran.nextInt(2);
		Deck.add(tCards.get(num));
		for (int idx = 0; idx < 50; idx += 1) {
			int size = tCards.size();
			num = ran.nextInt(size);
			while (num < 2) {
				num = ran.nextInt(size);
			}
			Card card = tCards.get(num);
			while (!addDeck(map, card)) {
				num = ran.nextInt(size);
				while (num < 2) {
					num = ran.nextInt(size);
				}
				card = tCards.get(num);
			}
			Deck.add(card);
			
		}
		System.out.println("Returning Deck:");
		return Deck;
	}
	public static void main(String[] args) {
		String filename = args[0];
		System.out.println("Reading: "+filename+" to build your deck");
		ArrayList<Card> tCards = new ArrayList<Card>();
		ReadFile.Readfile(filename, tCards);
		ArrayList<Card> Deck = BuildDeck(tCards);
		Collections.sort(Deck, new Card());
		printDeck(Deck);
	}
	
	public static void printDeck(ArrayList<Card> Deck) {
		for (Card card : Deck) {
			System.out.println(card.toString());
		}
	}
}
