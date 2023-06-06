import java.util.Comparator;

public class Card implements Comparator<Object> {
	
	String Name;
	int Cost;
	int Power;
	int Counter;
	String type;
	String effect;
	// Public Constructor
	public Card() {
		this.Name = "";
		this.Cost = 0;
		this.Power = 0;
		this.Counter = 0;
		this.type = "";
		this.effect = "";
	}
	
	public Card(String Name, int Cost, int Power, int Counter, String type, String effect) {
		this.Name = Name;
		this.Cost = Cost;
		this.Power = Power;
		this.Counter = Counter;
		this.type = type;
		this.effect = effect;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public void setCost(int Cost) {
		this.Cost = Cost;
	}
	
	public void setPower(int Power) {
		this.Power = Power;
	}
	
	public void setCounter(int Counter) {
		this.Counter = Counter;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setEffect(String effect) {
		this.effect = effect;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public String toString() {
		return this.Name + "\t" + Integer.toString(this.Cost) + "\t" + Integer.toString(this.Power) + "\t" +
				Integer.toString(this.Counter) + "\t" + this.type + "\t" + this.effect;
	}

	@Override
	public int compare(Object o1, Object o2) {
		return ((Card) o1).getName().compareTo(((Card) o2).getName());
	}
}
