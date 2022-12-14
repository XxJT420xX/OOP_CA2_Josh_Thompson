import java.util.ArrayList;
import java.util.List;

public class FarmManager {
private final ArrayList<Farm> farmList;
private ShedManager shedManager;
private AnimalManager animalManager;
private MilkTankManager tankManager;
private MilkingMachineManager milkingManager;

    public FarmManager(ShedManager shedManager , MilkTankManager tankManager , MilkingMachineManager milkingManager, AnimalManager
                        animalManager) {
        this.farmList = new ArrayList<>();
        this.shedManager = shedManager;
        this.animalManager = animalManager;
        this.tankManager = tankManager;
        this.milkingManager = milkingManager;

    }

    public String displayDetails(int ID)
    {
        for(Farm f : farmList)
        {
            if(ID == f.getId())
            {
                return f.toString();
            }
        }
        return null;
    }





    public void displayAllSheds(int id)
    {
        for(Farm f : farmList) {
            if (id == f.getId()) {
                shedManager.displayAllShed();
            }

        }

    }
    public void displayAllAnimals(int id)
    {
        for(Farm f : farmList) {
            if (id == f.getId()) {
                animalManager.displayAllAnimals();
            }
        }
    }
    public void displayAllMilkTanks(int id)
    {
        for(Farm f : farmList) {
            if (id == f.getId()) {
                tankManager.displayAllTanks();
            }
        }
    }
    public void displayAllMilkingMachines(int id)
    {
        for(Farm f : farmList) {
            if (id == f.getId()) {
                milkingManager.displayAllMilkingMachines();
            }
        }
    }




}
