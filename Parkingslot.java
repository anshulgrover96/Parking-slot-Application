/**
 * This is a Parkingslot class, which is very simple representation of a Parking slot which contains
 * attributes for the parking slot id , car information and information whether petrson is staff member or visitor.
 * @author Anshul Grover, 102616674
 * @version 11.8, 13/09/2020
 */
 
public class Parkingslot {
	private String SlotID; 
	private boolean isstaff=false;
	private Car car;
	String ans, ans2;
	
/** Constructor for objects of the Class Parkingslot.
 * 	@param SlotID is Parking slot unique identity.
 *  @param car is Car's information.
 *  @param isstaff is staff information.
 */
 
	public Parkingslot (String SlotID,boolean isstaff)
	{
		this.SlotID=SlotID;
		this.car=null;
		this.isstaff=isstaff;
	}	

	/** 
	 * Setter method for SlotID Attribute
	 * 
	 *@param newSlotID for new Parking slot.
	 */
	 
	public void setSLOT(String newSlotID)
	{
		this.SlotID=newSlotID;
	}

	/** 
	 * Getter method for SlotID Attribute
	 * 
	 *@return Parking slot id.
	 */
	
	public String getSLOT()
	{
		return SlotID;
	}


	/** 
	 * Setter method for car Attribute
	 * 
	 *@param car for new car information.
	 */
	 
	public void setCarinfo(Car car)
	{
        this.car = car;
	}
	
	/** 
	 * Getter method for car Attribute
	 * 
	 *@return Car's information
	 */
	 
	public Car getCarinfo()
	{
		return car;
	}
	
	/** 
	 * Getter method for isstaff Attribute
	 * 
	 *@return Staff member information
	 */
	 
	public boolean getstaff()
	{
		return isstaff;
	}
	
	/**
	* The addcar method used for adding the ncar.
	*
	* @param ncar for Car information
	*/
	
	public void addcar(Car ncar)
	{
		this.car=ncar;
	}

	/**
	* The removecar method used for removing the car.
	*
	* @return remove car information and initialise it to null.
	*/
	
	public Car removecar()
	{
		return this.car=null;
	}
	
	/** 
	 * Returns a String representation of the object.
	 *
	 *@return Returns a String object that contains the Parkingslot attributes.
	 */
	 
	public String toString()
	{
		if (this.getstaff())
		{
			ans="staff";
		}
		else 
		{
			ans="visitor";
		}
			
		if (this.getCarinfo()!=null)
		{
			ans2= "occupied by a car with reg: " + getCarinfo().getRegisteration();
		}
		else 
		{
			ans2="not Occupied";
		}
		
		String objstr="SLOT ID: " + this.getSLOT()+ " is for " + ans +" and is "+ ans2;
		
		return objstr;
	}
	
}
		