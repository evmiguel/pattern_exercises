/**
	@author: 	Erika Miguel
	@date:		September 20, 2017
	@pattern: 	Composite

	This code illustrates a composite interface that
	can be implemented to access the names of family
	members and to add family members to a given family.

	We could have made this an abstract class, but it is
	mostly methods. So, we can define the basic set of
	methods in an interface instead.
*/

public interface AbstractFamilyInterface {

	public void sayNames();

	public void addFamily(Family family);

	public void addFamilyMember(Single single);
}
