/**
	@author		Erika Miguel
	@date		September 20, 2017
	@pattern	Composite

	Single class implementation. For the methods that 
	are not supported, throw an exception.
*/

public class Single implements AbstractFamilyInterface {
	private String name;

	public Single(String name){
		this.name = name;
	}

	public void sayNames(String tabs){
		System.out.println(tabs+ "My name is: "+this.name+". I am a single member.");
	}
}
