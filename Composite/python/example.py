"""
Author:  Erika Miguel
Date:    9/17/2017
Pattern: Composite

This code illustrates the composite pattern in Python by simulating
a family. A family can be a single individual or have a family within
it as well.

If the family has a single member it should not be able to get children.
If the family has a sub-family, it should be able to get children.

This does not take into account relationships between family member 
child nodes.
"""

#####################################################################
# Abstract Family Class
#####################################################################
class AbstractFamily(object):
	'''
		This is the Abstract Family class. Defines API methods only.
	'''
#--------------------------------------------------------------------
# Built-in Methods
#--------------------------------------------------------------------
	def __init__(self, name):
		msg = '{} must be implemented by a sublass!' \
			.format(self.__class__.__name__)
		raise NotImplementedError(msg)

#--------------------------------------------------------------------
# Public Methods
#--------------------------------------------------------------------

	def addFamilyMember(self, member):
		msg = '{}.{} must be implemented by a sublass!' \
                        .format(self.__class__.__name__, "addFamilyMember")
		raise NotImplementedError(msg)

	def sayNames(self, tabs):
		msg = '{}.{} must be implemented by a sublass!' \
                        .format(self.__class__.__name__, "sayNames")
		raise NotImplementedError(msg)

#####################################################################
# Single Implementation
#####################################################################
class Single(AbstractFamily):
	'''
		This is the case of a family with one person.
	'''
#--------------------------------------------------------------------
# Built-in Methods
#--------------------------------------------------------------------
	def __init__(self, name):
		self.name = name

#--------------------------------------------------------------------
# Public Methods
#--------------------------------------------------------------------
	def sayNames(self, tabs=''):
		msg = '{}My name is {}. I am a single member.' \
			.format(tabs, self.name)
		print(msg)

#####################################################################
# Family Implementation
#####################################################################
class Family(AbstractFamily):
	'''
		This is the case of a family with more than one member.
	'''
#--------------------------------------------------------------------
# Built-in Methods
#--------------------------------------------------------------------
	def __init__(self, name):
		self.name 	= name
		self.members 	= []

	def __sayFamily(self, tabs):
		msg = '{}This is the {} family.' \
			.format(tabs, self.name)
		print(msg)
		for member in self.members:
			member.sayNames(tabs=tabs*2)

#--------------------------------------------------------------------
# Public Methods
#--------------------------------------------------------------------
	def addFamilyMember(self, member):
		msg = 'Adding {} to the {} family.' \
			.format(member.name,self.name)
		print(msg)
		self.members.append(member)

	def sayNames(self, tabs='	'):
		self.__sayFamily(tabs)
	
def main():
	aFamily = Family('aFamily')
	aSingle = Single('aSingle')
	aFamily.addFamilyMember(aSingle)

	bFamily = Family('bFamily')
	bSingle1 = Single('bSingleMember1')
	bSingle2 = Single('bSingleMember2')
	bFamily.addFamilyMember(bSingle1)
	bFamily.addFamilyMember(bSingle2)
	aFamily.addFamilyMember(bFamily)

	cSingle = Single('cSingle')
	aFamily.addFamilyMember(cSingle)

	aFamily.sayNames()

if __name__ == "__main__":
	main()
