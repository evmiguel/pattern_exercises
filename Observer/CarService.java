import java.util.ArrayList;

public class CarService implements Observable {

	private ArrayList<Observer> riders = new ArrayList<Observer>();
	private static final int DEFAULT_MINUTES_AWAY = 5;
	private int minutesAway;

	public CarService(){
		this.minutesAway = DEFAULT_MINUTES_AWAY;
	}

	public void setMinutesAway(int minutes){
		this.minutesAway = minutes;
		notifyObservers();
	}

	@Override
	public int getStatus(){
		return this.minutesAway;
	}

	@Override
	public void addObserver(Observer o){
		this.riders.add(o);
	}

	@Override
	public void removeObserver(Observer o){
		this.riders.remove(o);
	}

	@Override
	public void notifyObservers(){
		for(Observer rider: this.riders){
			rider.update();
		}
	}
}
