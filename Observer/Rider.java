public class Rider implements Observer {
	private Observable carService;

	public Rider(Observable carService){
		this.carService = carService;
		carService.addObserver(this);
	}

	@Override
	public void update(){
		this.printStatus();
	}

	@Override
	public void unsubscribe(){
		this.carService.removeObserver(this);
	}
	
	private void printStatus(){
		int status = this.carService.getStatus();
		System.out.printf("Car is %d minutes away\n", status);
		if(status == 0){
			System.out.println("Car is here!");
			this.unsubscribe();
		}
	}
}

