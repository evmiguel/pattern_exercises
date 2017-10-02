public class Friend implements Observer{
	private Observable carService;

	public Friend(Observable carService){
		this.carService = carService;
		this.carService.addObserver(this);
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
		System.out.printf("Your friend's car service is %d minutes away.\n", status);
		if (status == 0){
			System.out.println("Your friend is in the car!");
			this.unsubscribe();
		}
	}
}
