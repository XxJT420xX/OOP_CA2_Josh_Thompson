import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {


    private FarmManager farmManager;
    private ShedManager shedManager;
    private AnimalManager animalManager;
    private MilkTankManager tankManager;
    private MilkingMachineManager milkingManager;

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    public void start() {
        farmManager = new FarmManager(shedManager, tankManager, milkingManager, animalManager);
        animalManager = new AnimalManager();
        milkingManager = new MilkingMachineManager();
        tankManager = new MilkTankManager();
        shedManager = new ShedManager();

        try {
            farmingMenu();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        System.out.println("The App is closing");

    }

    private void farmingMenu() throws IOException {
        final String menuOptions = "\n*** Welcome to the Main Menu***\n"
                + "1. Farm Menu\n"
                + "2. Animal Menu\n"
                + "3. Shed Menu\n"
                + "4. MilkTank Menu\n"
                + "5. MilkingMachine Menu\n"
                + "6. Exit the Menu\n"
                + "Enter Options 1-5 or 6 to quit the App";

        final int farm = 1;
        final int animal = 2;
        final int shed = 3;
        final int milktank = 4;
        final int milkmachine = 5;
        final int exit = 6;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + menuOptions);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case farm:
                        System.out.println("Passengers option chosen");
                        displayFarmMenu();
                        break;
                    case animal:
                        System.out.println("Vehicles option chosen");
                        displayAnimalMenu();
                        break;
                    case shed:
                        System.out.println("Bookings option chosen");
                        displayShedMenu();
                        break;
                    case milktank:
                        System.out.println("Bookings option chosen");
                        displayMilkTankMenu();
                        break;
                    case milkmachine:
                        System.out.println("Bookings option chosen");
                        displayMilkMachineMenu();
                        break;
                    case exit:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != exit);

        System.out.println("\nExiting Main Menu, goodbye.");

    }

    private void displayFarmMenu() {
        final String menuOptions = "\n*** Welcome to the Farm Menu***\n"
                + "1. To Create a new Farm\n"
                + "1. To Display the details of the Farm\n"
                + "3. To show all Sheds\n"
                + "4. To show all Animals\n"
                + "5. To show all MilkTanks\n"
                + "6. To show all Milking Machines\n"
                + "7. Exit the Menu\n"
                + "Enter Options 1-6 or 7 to quit the App";

        final int createFarm = 1;
        final int displayFarm = 2;
        final int showSheds = 3;
        final int showAnimals = 4;
        final int showTanks = 5;
        final int showMilkers = 6;
        final int exit = 7;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println(menuOptions);
            try {
                String input = keyboard.nextLine();
                option = Integer.parseInt(input);
                switch (option) {
                    case createFarm:
                        System.out.println("Please enter the details of the farm.\nYou only need to create an ID and select an owner");
                        System.out.println("Please enter the id of the farm");
                        int id = keyboard.nextInt();
                        System.out.println("Please enter the owner of the farm");
                        String owner = keyboard.nextLine();

                        Farm newFarm = new Farm(id, owner);
                        System.out.println("That farm has been added");
                        break;


                    case displayFarm:
                        System.out.println("Please enter the id of the farm you want to search for");
                        int searchID = keyboard.nextInt();
                        farmManager.displayDetails(searchID);
                        break;


                    case showSheds:
                        System.out.println("Please enter the id of the farm");
                        int searchShedID = keyboard.nextInt();
                        farmManager.displayAllSheds(searchShedID);
                        break;

                    case showAnimals:
                        System.out.println("Please enter the id of the farm");
                        int searchAnimalID = keyboard.nextInt();
                        farmManager.displayAllSheds(searchAnimalID);
                        break;

                    case showTanks:
                        System.out.println("Please enter the id of the farm");
                        int searchTankID = keyboard.nextInt();
                        farmManager.displayAllSheds(searchTankID);

                        break;

                    case showMilkers:
                        System.out.println("Please enter the id of the farm");
                        int searchMilkerID = keyboard.nextInt();
                        farmManager.displayAllSheds(searchMilkerID);
                        break;


                    case exit:
                        System.out.println("Now exiting this menu");
                        break;

                    default:
                        System.out.println("That is not a correct option.\nPlease enter a number between 1-7");
                        break;

                }

            }
            //got from https://rollbar.com/blog/java-numberformatexception/
            catch (InputMismatchException | NumberFormatException n) {
                System.out.println("Please enter a number within the range");
            }
        } while (option != exit);


    }

    private void displayAnimalMenu() {
        final String menuOptions = "\n*** Welcome to the Animal Menu***\n"
                + "1. Show all Animals\n"
                + "2. Add a new Animal to a herd\n"
                + "3. Remove an Animal from the herd if it has died by id\n"
                + "4. Find an Animal by id and print it\n"
                + "5. Display the herd sorted by value\n"
                + "6. Exit\n"
                + "Enter Option [1,6]";


        final int showAll = 1;
        final int add = 2;
        final int die = 3;
        final int find = 4;
        final int findType = 5;
        final int compare = 6;
        final int exit = 7;

        Scanner keyboard = new Scanner(System.in);
        String choice = keyboard.nextLine();
        int option = 0;
        ArrayList<Animal> herd;

        do {
            System.out.println(menuOptions);

            try {
                herd = new ArrayList<Animal>();
                String input = keyboard.nextLine();
                option = Integer.parseInt(input);

                switch (option) {
                    case showAll:
                        System.out.println("Display the herd");
                        animalManager.displayAllAnimals();
                        break;
                    case add:
                        System.out.println("Adding an animal to the herd");
                        System.out.println("Please enter the weight of the animal");
                        double weight = keyboard.nextDouble();
                        System.out.println("Please enter the type of Animal. Write down one of the following options.\nDairy Cow, Goat ,Beef Cow or Sheep");
                        String type = keyboard.nextLine();
                        System.out.println("Please enter the age of the Animal");
                        int age = keyboard.nextInt();
                        System.out.println("Please enter whether the animal is Pedigree.\nNote that valid answers are True or False");
                        boolean ifPedigree = keyboard.nextBoolean();
                        boolean isAlive = true;

                        Animal newAnimal = animalManager.addAnimal(weight, type, age, ifPedigree, isAlive);

                        if (newAnimal == null) {

                            System.out.println("This animal is already in the herd");
                        } else {

                            System.out.println("The animal has been added");
                        }
                        break;
                    case die:
                        System.out.println("Removing an animal");
                        System.out.println("Please enter the Id of the animal that has died");
                        int deathID = keyboard.nextInt();
                        if (animalManager.removeAnimal(deathID) != null) {
                            System.out.println("That animals death has been registered");
                        }
                        break;

                    case find:
                        System.out.println("Finding an animal");
                        System.out.println("Please enter the id of the animal that you wish to find");
                        int findID = keyboard.nextInt();
                        animalManager.findAnimal(findID);
                        break;

                    case findType:
                        System.out.println("Finding all animals of the specific type");
                        System.out.println("Please enter the type of animal. Write down one of the following options.\nDairy Cow, Goat ,Beef Cow or Sheep");
                        String findAType = keyboard.nextLine();
                        animalManager.findAnimalByType(findAType);
                        break;

                    case compare:
                        System.out.println("Sorting the herd by value.");
                        animalManager.compareByValue(herd);
                        break;


                    case exit:

                        System.out.println("Exiting this Animal Menu ");
                        break;

                    default:
                        System.out.println("That is not a correct option.\nPlease enter a number between 1-7");
                        break;

                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != exit);

    }

    private void displayShedMenu() {
        final String menuOptions = "\n*** Shed MENU ***\n"
                + "1. Show all Sheds\n"
                + "2. Add new Shed\n"
                + "3. Remove Shed\n"
                + "4. Install a milking Machine\n"
                + "5. Milk an animal \n"
                + "6. Milk a herd of Animals\n"
                + "7. Exit\n"
                + "Enter Option [1,7]";

        final int showAll = 1;
        final int addShed = 2;
        final int removeShed = 3;
        final int installMachine = 4;
        final int milkOneAnimal = 5;
        final int milkHerd = 6;
        final int exit = 7;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        ArrayList<Animal> herd;
        do {

            System.out.println(menuOptions);
            try {
                String input = keyboard.nextLine();
                option = Integer.parseInt(input);
                herd = new ArrayList<>();
                switch (option) {
                    case showAll:
                        System.out.println("Displayin all Sheds");
                        shedManager.displayAllShed();
                        break;
                    case addShed:
                        System.out.println("Adding a new Shed");
                        System.out.println("Please enter the name of the Shed");
                        String name = keyboard.nextLine();
                        System.out.println("Please enter whether there is a Milking Machine in the Shed ");
                        boolean isMilker = keyboard.nextBoolean();
                        System.out.println("Please enter whether there is a Milk Tank in the Shed");
                        boolean isTank = keyboard.nextBoolean();

                        Shed newShed = shedManager.addShed(name, isMilker, isTank);
                        if (newShed == null) {
                            System.out.println("This Shed already exists");
                        } else {
                            System.out.println("Shed added");
                        }
                        break;
                    case removeShed:
                        System.out.println("Removing the Shed");
                        System.out.println("Please enter the id of the Shed you wish to remove");
                        int deleteID = keyboard.nextInt();

                        if (shedManager.removeShed(deleteID) != null) {
                            System.out.println("Shed has been removed");
                        }
                        break;

                    case installMachine:
                        System.out.println("Installing a machine");
                        System.out.println("Please enter the ID of the Shed you want to add the Machine to");
                        int shedMachineID = keyboard.nextInt();
                        System.out.println("Please enter the ID of the Milking Machine you want to add");
                        int MilkerId = keyboard.nextInt();
                        shedManager.installMilkingMachine(shedMachineID, MilkerId);
                        break;

                    case milkOneAnimal:
                        System.out.println("Milking an Animal");
                        System.out.println("Please enter the ID of the Shed you want to add the Machine to");
                        int shedMilkingID = keyboard.nextInt();
                        System.out.println("Please enter the ID of the Animal you wish to milk");
                        int animalMilkId = keyboard.nextInt();
                        shedManager.milkAnimal(shedMilkingID, animalMilkId);
                        break;

                    case milkHerd:
                        System.out.println("Milking the herd");
                        System.out.println("Please enter the ID of the Shed you want to add the Machine to");
                        int shedMilkerHerdID = keyboard.nextInt();
                        shedManager.milkAnimals(shedMilkerHerdID, herd);
                        break;

                    case exit:
                        System.out.println("Exiting the Shed Menu now");
                        break;

                    default:
                        System.out.println("That is not a correct option.\nPlease enter a number between 1-7");
                        break;


                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }

        } while (option != exit);
    }

    private void displayMilkTankMenu() {
        final String menuOptions = "\n*** MilkTank MENU ***\n"
                + "1. Show all MilkTanks\n"
                + "2. Add new MilkTank\n"
                + "3.Remove MilkTank\n"
                + "4. Find MilkTank ny ID\n"
                + "5. Get milk from the Tank\n"
                + "6. Free Space in the Tank\n"
                + "7. Add Milk to the Tank\n"
                + "8. Exit\n"
                + "Enter Option [1,8]";

        final int showAll = 1;
        final int addTank = 2;
        final int removeTank = 3;
        final int findByID = 4;
        final int getMilk = 5;
        final int freeSpace = 6;
        final int addMilk = 7;
        final int exit = 8;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println(menuOptions);
            try {
                String input = keyboard.nextLine();
                option = Integer.parseInt(input);
                switch (option) {
                    case showAll:

                        System.out.println("Showing all MilkTanks available");
                        tankManager.displayAllTanks();

                        break;

                    case addTank:
                        System.out.println("Adding a new MilkTank");
                        System.out.println("Please enter the name of the MilkTank");
                        String name = keyboard.nextLine();
                        System.out.println("Please enter the capacity of the MilkTank.\nIf the tank is at standard capacity just press 0");
                        double capacity = keyboard.nextDouble();
                        System.out.println("Please enter the amount of Milk in the tank.\nIf the tank is empty just press 0");
                        double milkStored = keyboard.nextDouble();
                        MilkTank milktank = tankManager.addMilkTank(name, capacity, milkStored);
                        if (milktank == null) {
                            System.out.println("That milk Tank is already recorded");
                        } else {
                            System.out.println("MilkTank has been added");
                        }
                        break;

                    case removeTank:
                        System.out.println("Removing Milk Tank");
                        System.out.println("Please enter the ID of the Tank you wish to remove");
                        int deleteTankID = keyboard.nextInt();
                        if (tankManager.removeTank(deleteTankID) != null) {
                            System.out.println("MilkTank removed");
                        }
                        break;
                    case findByID:
                        System.out.println("Finding MilkTank by ID");
                        System.out.println("Please enter the ID of the Tank you wish to find");
                        int findIDTank = keyboard.nextInt();
                        tankManager.findMilkTankByID(findIDTank);
                        break;

                    case getMilk:
                        System.out.println("Getting Milk from the Tank");
                        System.out.println("Please enter the ID of the Tank you wish to get milk from");
                        int getMilkID = keyboard.nextInt();
                        System.out.println("Please enter the amount of Milk you wish to get");
                        double amount = keyboard.nextDouble();
                        tankManager.getFromTank(getMilkID, amount);
                        break;

                    case freeSpace:
                        System.out.println("Freeing Space from the Tank");
                        System.out.println("Please enter the ID of the Tank you wish to get milk from");
                        int freeSpaceID = keyboard.nextInt();
                        System.out.println("Please enter the amount of Milk you wish to get");
                        double amountfreed = keyboard.nextDouble();
                        tankManager.freeSpace(freeSpaceID, amountfreed);

                        break;

                    case addMilk:
                        System.out.println("Adding Milk wothe Tank");
                        System.out.println("Please enter the ID of the Tank you wish to add milk to");
                        int addMilkID = keyboard.nextInt();
                        System.out.println("Please enter the amount of Milk you wish to add");
                        double amountadded = keyboard.nextDouble();
                        tankManager.addToTank(addMilkID, amountadded);
                        break;
                    case exit:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.println("That is not a correct option.\nPlease enter a number between 1-7");
                        break;


                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != exit);

    }


    private void displayMilkMachineMenu() {
        final String menuOptions = "\n*** MilkMachine menu ***\n"
                + "1. Show all Milking Machines\n"
                + "2. Add new Milking Machine\n"
                + "3.Remove Milking Machine\n"
                + "4. Find Milking Machine by ID\n"
                + "5. Get connected tank if there is one\n"
                + "6. Set a tank to be connected\n"
                + "7. Exit\n"
                + "Enter Option [1,7]";

        final int showAll = 1;
        final int addMachine = 2;
        final int removeMachine = 3;
        final int findByID = 4;
        final int getTank = 5;
        final int setTank = 6;
        final int exit = 7;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println(menuOptions);
            try {
                String input = keyboard.nextLine();
                option = Integer.parseInt(input);
                switch (option) {
                    case showAll:
                        System.out.println("Display all Milking Machines");
                        milkingManager.displayAllMilkingMachines();
                        break;
                    case addMachine:
                        System.out.println("Adding a Milking Machine");
                        System.out.println("Please enter the name of the Milking Machine");
                        String name = keyboard.nextLine();
                        System.out.println("Please enter the details of the milkTank\nIf you do not know them leave this blank");
                        System.out.println("Please enter the name of the MilkTank");
                        String tankname = keyboard.nextLine();
                        System.out.println("Please enter the capacity of the MilkTank.\nIf the tank is at standard capacity just press 0");
                        double capacity = keyboard.nextDouble();
                        System.out.println("Please enter the amount of Milk in the tank.\nIf the tank is empty just press 0");
                        double milkStored = keyboard.nextDouble();
                        MilkTank newTank = new MilkTank(tankname, capacity, milkStored);
                        MilkingMachines newMachine = milkingManager.addMilkingMachine(name, newTank);
                        if (newMachine == null) {
                            System.out.println("That Milking Machine has already been added ");
                        } else {
                            System.out.println("Machine added");
                        }
                        break;
                    case removeMachine:
                        System.out.println("Removing Machine");
                        System.out.println("Please enter the ID of the Machine");
                        int deleteID = keyboard.nextInt();
                        milkingManager.removeMilkingMachine(deleteID);
                        break;
                    case findByID:
                        System.out.println("Finding Machine by id");
                        System.out.println("Please enter the ID of the Machine you wish to find");
                        int findMachineID = keyboard.nextInt();
                        milkingManager.findmilkingMachineById(findMachineID);
                        break;

                    case getTank:
                        System.out.println("Getting the Details of a milktank if one is connected");
                        System.out.println("Please enter the ID of the Milking Machine to see if there is an adjacent Milk Tank");
                        int machineTankID = keyboard.nextInt();
                        milkingManager.getMilkTank(machineTankID);
                        break;

                    case setTank:
                        System.out.println("Joining a Milking Machine to a Milk Tank");
                        System.out.println("Please enter the Id of the Milking Machine you wish to join");
                        int machineJoin = keyboard.nextInt();
                        System.out.println("Please enter the ID of the Tank you wish to join");
                        int tankJoin = keyboard.nextInt();
                        milkingManager.setMilktank(machineJoin, tankJoin);


                    case exit:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.println("That is not a correct option.\nPlease enter a number between 1-7");
                        break;


                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != exit);


    }
}



