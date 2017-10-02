/**
	@author 	Erika Miguel
	@date 		September 20, 2017
	@pattern	Composite

	This class extends the AbstractFamilyInterface to
	illustrate that this class can contain multiple
	types of family members, both single members and
	other families.
*/

import java.util.Arrays;

public class Family implements AbstractFamilyInterface {
	private String name;
	private String[] members;

	public Family(String name){
		this.name = name;
	}

	public void sayNames(String tabs){
		System.out.println(tabs + "Family name: " + this.name);
		if(this.members != null){
			Arrays.stream(members).forEach(member -> System.out.println(member.sayNames()));
		}
	}

}
