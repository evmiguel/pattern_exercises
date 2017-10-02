public class Main {
	public static void main(String args[]){
		CarService cs 	= new CarService();
		Rider rider1	= new Rider(cs);
		Friend friend	= new Friend(cs);
		cs.setMinutesAway(10);
		cs.setMinutesAway(5);
		cs.setMinutesAway(0);
	}
}
