/*This class creates a random ArrayList of Car objects and makes use of the setSearch, matchRange, and several
display methods*/
//Feel free to uncomment any method call in main to see execution of those calls

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleSearch 
{	
	static ArrayList<Car> carOptions = new ArrayList<Car>();
	static SearchCriteria criteria = new SearchCriteria();


	public static void main(String[] args) 
	{
		userOptions();
	}
	
	public static void userOptions()
	{
		int choice = -1;
		
		while(choice != 5)
		{
			Scanner entry = new Scanner(System.in);
			
			System.out.println("\nWhat would you like to do? Enter 0 to create a random car list, 1 to add a car to a list,"
					+ " 2 for removing a car from a list, " + "3 to list all cars, 4 to search for a car or 5 to quit:");
			choice = entry.nextInt();
			
			switch(choice)
			{
			case 0:
				createCarList();
				displayCarList
				();
				break;
			case 1:
				displayCarList();
				addUserCar();
				break;
			case 2:
				if(carOptions.isEmpty())
				{
					System.out.println("List is currently empty, why not add to it? ");
					break;
				}
				displayCarList();
				removeCar();
				break;
			case 3:
				if(carOptions.isEmpty())
				{
					System.out.println("List is currently empty, why not add to it? ");
					break;
				}
				displayCarList();
				break;
			case 4:
				if(carOptions.isEmpty())
				{
					System.out.println("List is currently empty, why not add to it? ");
					break;
				}
				displayCarList();
				Car.setSearch(criteria);
				displayCarMatches(criteria);
				break;
			case 5:
				System.out.println("See you next time!");
				choice = 5;
				break;
			default:
				// Do I really need this?
				break;
			}
		 }
	}
	
	public static void addUserCar()
	{
		Car user = new Car();
		user.setUserCar();
		carOptions.add(user);
		displayCarList();
	}
	
	public static void addRandomCar()
	{
		Car random = new Car();
		random.setRandom();
		carOptions.add(random);
		displayCarList();	
	}
	
	public static void removeCar()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\nPlease enter the index of the vehicle you want removed: ");
		int index = input.nextInt();
		System.out.println("You are removing index " + index + ", which is the following vehicle: ");
		carOptions.get(index).print();
		carOptions.remove(index);
		displayCarList();
	}

	public static void createCarList() 
	{
		Car newRandomCar;
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nHow many cars would you like to see listed? ");
		int howMany = input.nextInt();
		
		for (int carsAdded = 0; carsAdded < howMany; carsAdded++) 
		{
			newRandomCar = new Car();
			newRandomCar.setRandom();
			carOptions.add(newRandomCar);
		}
	}
	
	public static void displayCarList()
	{
		for (Car auto : carOptions)
		{
			System.out.println("\nThe index of the following vehicle is " + carOptions.indexOf(auto) + ".");
			auto.print();
		}
	}
	
	public static void displayCarMatches(SearchCriteria criteria)
	{
		boolean isMatch;
		int matches = 0;
	
		System.out.println("\nHere are your choices based on your search criteria. Happy shopping!");
		
		for (Car auto : carOptions) 
		{
			isMatch = auto.matchCriteria(criteria);
			if (isMatch == true) 
			{	
				matches++;
				System.out.println("\nThe index of the following vehicle is " + carOptions.indexOf(auto) + ".");
				auto.print();
			}
		}
		if (matches == 0)
		{
			System.out.println("\nSorry, no options in stock.  Check back soon!");
		}
		
	}
	
}