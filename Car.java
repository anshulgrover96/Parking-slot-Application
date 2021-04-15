/**
 * This is a Car class, which is very simple representation of a car which contains
 * attributes for the car registeration, car owner name and information whether petrson is staff member or visitor.
 * @author Anshul Grover, 102616674
 * @version 11.8, 13/09/2020
 */
 
 public class Car {
	String registeration, oname;
	private boolean isstaff;

/** Constructor for objects of the Class Car.
 * 	@param registeration is Car's registeration.
 *  @param oname is Car's oname.
 *  @param isstaff is staff information.
 */
	
	public Car (String regnum, String ownername, boolean isstaff)
	{
		this.oname=ownername;
		this.registeration=regnum;
		this.isstaff=isstaff;
	}
	
	 
	 /** 
	 * Setter method for registeration Attribute
	 * 
	 *@param regnum for Car's new Registeration number
	 */
	 
	
	public void setRegisteration(String regnum)
	{
		this.registeration=regnum;
	}
	
	 /** 
	 * Setter method for oname Attribute
	 * 
	 *@param ownername for Car's new Owner name
	 */
	 
	public void setowner(String ownername)
	{
		this.oname=ownername;
	}

	/** 
	 * Getter method for registeration Attribute
	 * 
	 *@return Car's Registeration
	 */
	

	public String getRegisteration()
	{
		return registeration;
	}

	/** 
	 * Getter method for oname Attribute
	 * 
	 *@return Car's Owner name
	 */
	 
	public String getowner()
	{
		return oname;
	}
	
	/** 
	 * Setter method for isstaff Attribute
	 * 
	 *@param isstaff for Car's Staff information.
	 */
	 
	public void setstaffinfo(boolean isstaff)
	{
		this.isstaff=isstaff;
	}
	
	/** 
	 * Getter method for isstaff Attribute
	 * 
	 *@return Car's Staff information
	 */
	 
	public boolean getstaffinfo()
	{
		return isstaff;
	}
}

		
	
	