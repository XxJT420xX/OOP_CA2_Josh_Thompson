import java.util.ArrayList;

public class MilkingMachineManager {

    private  ArrayList<MilkingMachines> milkingMachinesList;

    public MilkingMachineManager(ArrayList<MilkingMachines> milkingMachinesList) {
        this.milkingMachinesList = milkingMachinesList;
    }

    public void displayAllMilkingMachines() {
        for (MilkingMachines mm : milkingMachinesList)
            System.out.println(mm.toString());
    }

    public MilkingMachines findmilkingMachineById(int id)
    {
        for (MilkingMachines mm : milkingMachinesList)
        {
            if (id == mm.getId())
            {
                return mm;
            }
        }
        return null;
    }


}
