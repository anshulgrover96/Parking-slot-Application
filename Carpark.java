/**
 * This is a Carpark class, which is very simple representation of a whole Carpark which contains
 * attribute slots for the list of Parking slots and differnt methods for adding slot, removing slot, finding slot 
 * and, getting list of parking slots.
 * @author Anshul Grover, 102616674
 * @version 11.8, 13/09/2020
 */
 
import java.util.ArrayList; // Importing array List from java utilities.

public class Carpark {
	private ArrayList<Parkingslot> slots; 
	
	/** Constructor for objects of the Class Carpark.
	*
	* @param Slots is array list of different Parking slot.
	*/
	
	public Carpark()
	{
		slots=new ArrayList<Parkingslot>();
	}
	
	/**
	* The addparkingslot method used for adding the new parking slot.
	*
	* @param nslots for new slot information
	*/
	
	public void addparkingslot(Parkingslot aslots)
	{
		slots.add(aslots);
	}

	/**
	* The removeparkingslot method used for removing the existing parking slot.
	*
	* @param id for slot id which needs to be removed. 
	*/
	
	public boolean removeparkingslot(String id)
	{
		for(Parkingslot aslots : slots)
		{
			if (aslots.getSLOT().equalsIgnoreCase(id))
			{
				slots.remove(aslots);
				return true;
			}
		}
		return false;
	}
	
	/**
	* The findcar method used for finding the car parked information with slot id and given registeration.
	*
	* @param regis for registeration of car which needs to be searched.
	* @return slot information of searched car with given registeration.
	*/
	
	
	public ArrayList<Parkingslot> findcar(String regis)
    {
		ArrayList<Parkingslot> foundslots=new ArrayList<Parkingslot>();
        for(Parkingslot nslots : slots)
        {
            if(nslots.getCarinfo()!=null)
			{
                if(nslots.getCarinfo().getRegisteration().equals(regis))
                {
                    foundslots.add(nslots);
                    
                }    
            }
        }   
            return foundslots;
    
    }
	
	/**
	* The findslot method used for finding the existing parking slot.
	*
	* @param id for slot id which needs to be searched.
	* @return slot information of searched slot id.
	*/
	
	public Parkingslot findslot(String id)
	{
		Parkingslot foundslot=new Parkingslot("-1",false);
		for (Parkingslot aslots : slots)
		{
			if(aslots.getSLOT().equals(id))
			{
				foundslot=aslots;
				break;
			}
		}
		return foundslot;
	}
	
	/**
	* The getOccupiedspots method used for finding the occupied slots with car.
	*
	* @return slots information occupied with car
	*/
	
	public ArrayList<Parkingslot> getOccupiedSpots()
    {
        ArrayList<Parkingslot> occupiedSpots = new ArrayList<Parkingslot>();
        for(Parkingslot aSlot : slots)
        {
            if(aSlot.getCarinfo()!=null)
                {occupiedSpots.add(aSlot);}
        }
        return occupiedSpots;
    }

	/** 
	 * Getter method for slots Attribute
	 * 
	 *@return Parking slots information.
	 */
	
	public ArrayList<Parkingslot> getAllslots()
	{
		return slots;
	}
	

	
	
}
	
				