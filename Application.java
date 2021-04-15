import java.util.Scanner; // Importing Scanner from Java Utilities.
import java.util.ArrayList; //Importing ArrayList from Java Utilities.

/**
 * This is a Application class, which contains main functions displaying the menu for Car Parking System. 
 * And other Methods for adding, removing and finding the car and as well as slots. 
 * Which is used in executing the menu options in the main class.
 * @author Anshul Grover, 102616674
 * @version 11.8, 13/09/2020
 */

public class Application {
    
    /** 
    * This is main method used for Car Parking System.
    */
    
    public static void main(String[] args) {
        int visnum, stafnum; // Declaring the variables for the staff member and visitors.
        
        Scanner sc=new Scanner(System.in); //Creating New Scanner Object.
        
        /* 
         * Asking for slots for staff members and for visitors.
         * and then adding the slots for visitors and staff with unique slot id.
         * for example "V001" ("V" and other three integers representing slot number") and 
         * "S001" ("S" and other three integers representing slot number").
         */
         
        System.out.println("Start to establish a car parking with Slots for staff and Visitors");  //printing the line
        System.out.println("Please enter the number of Slots for Staff:");  //printing the line
        stafnum=sc.nextInt(); //Taking input from user and storing it in stafnum variable.
        System.out.println("Please enter the number of slots for visitors:");  //printing the line
        visnum=sc.nextInt(); //Taking input from user and storing it in visnum variable.
        System.out.println("The "+stafnum + " slots for staff are created successfully.");  //printing the line
        System.out.println("The "+visnum + " slots for visitors are created successfully.");  //printing the line
        Carpark carpk=new Carpark(); // new Carpark object
        
        for (int j=1; j<=stafnum; j++)
        {
            String Slotid="S0"+String.format("%02d", j);
            Parkingslot slot=new Parkingslot(Slotid,true);
            carpk.addparkingslot(slot);
        }
        for (int i=1; i<=visnum; i++)
        {
            String Slotid="V0"+String.format("%02d", i);
            Parkingslot slot=new Parkingslot(Slotid,false);
            carpk.addparkingslot(slot);
        }
    
        /*
         * Using While loop to run the options asked from user, again and again.
         * And Using Switch method to choose between the different options getting from the user.
         */
         
        
        int option = 0; // Declaring the option variable as integer and initialize it as 0.

        while (option != 7) 
        {
            displayMenu(); //Calling the displayMenu method
            option = sc.nextInt(); // Getting input from user and storing in the options variable.
            sc.nextLine(); //skip ‘\n’

            // switch statement that invokes the various methods of the class based on the option
            // selected by the user
            switch (option) 
            {
                case 1:
                listall(carpk); // Calling listall method.
                break;
                
                case 2:
                addvehicle(carpk); // Calling addvehicle method.
                break;  
                
                case 3:
                findvehicle(carpk); // Calling findvehicle method.          
                break;
                
                case 4:
                removevehicle(carpk); // Calling removevehicle method.
                break;
                
                case 5:
                addcarslot(carpk); // Calling addcarslot method.
                break;
                
                case 6:
                removecarslot(carpk); // Calling removecarslot method.
                break;
                
                case 7: 
                System.exit(0); // Exiting the menu.
                break;
                
                default:
                System.out.println();
                System.out.println("Please enter a valid option 1 to 7.");  //printing the line     
                
            }

        } //end while
    }
        
    /**
    * The displayMenu method used for printing the display of the menu.
    *
    * printing the the seven different options.
    */
    
    public static void displayMenu() 
    {
        System.out.println("1: List all car slots"); //printing the option 1
        System.out.println("2: Park a car"); //printing the option 2
        System.out.println("3: Find a car"); //printing the option 3
        System.out.println("4: Remove a car"); //printing the option 4
        System.out.println("5: Add a car slot"); //printing the option 5
        System.out.println("6: Delete a car slot"); //printing the option 6
        System.out.println("7: Exit "); //printing the option 7
        System.out.println("Please select an option (1-7): "); //printing the line
        }
        
    /**
    * The listall method used for printing the list of parking slots.
    *
    * @param carpk, object of Carpark.
    */
    
    public static void listall(Carpark carpk)
    {
        for(Parkingslot slot : carpk.getAllslots())
        {
            System.out.println(slot.toString()); //printing the Slot information from Class Parkinglsot.
        }   
    }
    

    /**
    * The addvehicle method used for parking the car to the slot.
    *
    * @param carpk, object of Carpark.
    */
    
    public static void addvehicle(Carpark carpk)
    {
        Scanner sc=new Scanner(System.in); //Creating object for scanner
        
        /* Decaring all the Variables
         * like flag, slotid, regnum, mem, owner and samereg.
         * 
         */
         
        boolean flag; 
        String slotid,regnum, mem, owner;
        boolean samereg=false;
        do  // Do-while loop.
        {
            System.out.print("Enter the Slot ID that you want to park at (e.g.S001):");  //printing the line
            slotid=sc.next(); //Taking input from user and storing it in slotid variable.
        }while(slotid.length()!=4);         //Do -while loop ends here  
        do // Do-while loop starts here
        {
            System.out.print("Enter the Car registeration number (such as D12345): ");  //printing the line
            regnum=sc.next(); //Taking input from user and storing it in regnum variable.
        }while(regnum.length()!=6);
            
        System.out.print("IS the car registered for a Staff Member(yes/no):");  //printing the line
        mem=sc.next(); //Taking input from user and storing it in mem variable.
        if (mem.equals("yes"))
        {
            flag=true;
        }
        else
        {
            flag=false;
        }
        System.out.print("Who is the owner of the car:");  //printing the line
        owner=sc.next(); //Taking input from user and storing it in owner variable.
        
        Car car1=new Car(regnum,owner,flag); //New Car object.
        for (Parkingslot slots:carpk.getAllslots())
        {
            if (slots.getCarinfo()!=null)
            {
                if (slots.getCarinfo().getRegisteration().equals(regnum))
                {
                    samereg=true;
                    System.out.println("car with same registeration is already Parked"); //printing the line
                    System.out.println("Sorry! we Can't park your car."); //printing the line
                    break;
                }
            } 
        }
        if(!samereg)
        {
            if(carpk.findslot(slotid).getSLOT().equals(slotid) && carpk.findslot(slotid).getstaff()==flag) 
            {
                if (carpk.findslot(slotid).getCarinfo()==null)
                {
                    carpk.findslot(slotid).addcar(car1);
                    System.out.println("Car parked Successfully"); //printing the line
                }
                else
                {
                    if (carpk.findslot(slotid).getCarinfo()!=null)
                    {
                    System.out.println("Slot is already occupied, Please choose another slot"); //printing the line
                    }
                }
            }
            else
            {
                System.out.println("Wrong Slot id or Staff Information! Please Check"); //printing the line
            } 
        }           
    }           
    
    /**
    * The findvehicle method used for finding the parked vehicle.
    *
    * @param carpk, object of Carpark.
    */
    
    public static void findvehicle(Carpark carpk)
    {   
        String regnum; //Decaring the cariable regnum
        Scanner sc=new Scanner(System.in);//Creating object for scanner
        
        do //Do-while loop start here
        {
            System.out.print("Enter the Car registeration number (such as D12345): ");  //printing the line
            regnum=sc.next(); //Taking input from user and storing it in regnum variable.
        }while(regnum.length()!=6); //Ends here
        ArrayList<Parkingslot> found=new ArrayList<Parkingslot>(); // new object for the Arraylist of Parkingslot type
        found=carpk.findcar(regnum);
        if (found.isEmpty())
        {
            System.out.println("No vehicle found with this Registeration.");
        }
        else
        {
            for (Parkingslot nslots:found)
            {
                System.out.println("The Car with reg= "+regnum + " is parked on the slot="+nslots.getSLOT()+" and the owner is "+nslots.getCarinfo().getowner()); //printing the line
            }
        }
    }   
    
    /**
    * The removevehicle method used for removing the parked vehicle.
    *
    * @param carpk, object of Carpark.
    */
    
    public static void removevehicle(Carpark carpk)
    {
        Scanner sc=new Scanner(System.in); // new objecct for Scanner
        String regnum; //Decalaring the varaible regnum.
		boolean gotreg=false; // Decalaring the gotreg variable.
        do // Do-while loop starts here
        {
            System.out.print("Enter the Car registeration number (such as D12345): ");  //printing the line
            regnum=sc.next(); //Taking input from user and storing it in regnum variable.
        }while(regnum.length()!=6);
        for (Parkingslot slots:carpk.getOccupiedSpots())
        {
            if (slots.getCarinfo().getRegisteration().equals(regnum))
            {
                Car ncar=new Car("-1","-1",true); // new Car object.
                ncar=slots.removecar();
                System.out.println("The car with reg="+regnum+ " has been removed."); //printing the line
				gotreg=true;
			}
        }
		if (gotreg==false)
		{
			System.out.println("No Vehicle parked with this Registeration");
		}
    }
    
    /**
    * The addcarslot method used for adding the new slot for parking.
    *
    * @param carpk, object of Carpark.
    */
    
    public static void addcarslot(Carpark carpk)
    {   
        
        /* Decaring all the Variables
         * like flag, isoccupiedd.
         * 
         */
        String id, mem;
        boolean flag;
        boolean isoccupied=false;
        Scanner sc=new Scanner(System.in); //new object for Scanner.
        do  // Do-while loop starts here
        {
        System.out.print("Enter the Slot ID that you want to add (e.g.S001):"); //printing the line
        id=sc.next(); //Taking input from user and storing it in regnum variable.
        }while(id.length()!=4);
        
        System.out.println("IS the car registered for a Staff Member(yes/no):"); //printing the line
        mem=sc.next(); //Taking input from user and storing it in mem variable.
        
        if (mem.equals("yes"))
        {
            flag=true;
        }
        else{
            flag=false;
        }
        
        for(Parkingslot slots:carpk.getAllslots())
        {
            if (slots.getSLOT().equals(id))
            {
                isoccupied=true;
                System.out.println("SLOT ID already exists"); //printing the line
                break;
            }
        }
        if(!isoccupied)
        {
            Parkingslot aslot=new Parkingslot(id, flag);
            carpk.addparkingslot(aslot); 
            System.out.println("The Slot is added Successfully"); //printing the line
        }
        
    }
    
    /**
    * The removecarslot method used for removing the new slot for parking.
    *
    * @param carpk, object of Carpark.
    */
    
    public static void removecarslot(Carpark carpk)
    {
        String id; // Decaring the Variable id.
        Scanner sc=new Scanner(System.in); // new object for Scanner.
        boolean isoccupied=false; // Decalaring the variable isoccupied and initialising it as false.
        do // Do-while loop starts here
        {
        System.out.print("Enter the Slot ID that you want to remove (e.g.S001):"); //printing the line
        id=sc.next(); //Taking input from user and storing it in id variable.
        }while(id.length()!=4);
        
        for(Parkingslot slots:carpk.getAllslots())
        {
            if (slots.getSLOT().equals(id) && slots.getCarinfo()!=null)
            {
                isoccupied=true;
                System.out.println("SLOT ID Occupied and Can't be Removed."); //printing the line
                break;
            }
        }
        if (!isoccupied)
        {
            if (carpk.removeparkingslot(id) )
            {
                System.out.println("Parking Slot Deleted Successfully."); //printing the line
            }
            else
            {
            System.out.println("Slot not found"); //printing the line
            }
        }
    }
            

}