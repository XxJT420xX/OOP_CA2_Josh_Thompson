import java.util.ArrayList;

public class MilkingMachineManager {

    private  ArrayList<MilkingMachines> milkingMachinesList;
    private ArrayList<MilkTank> tanks;
    private MilkTank milktank;
    private MilkTankManager tankManager;


    public MilkingMachineManager() {

        this.tanks = new ArrayList<>();
        this.milkingMachinesList = new ArrayList<>();
    }

    public void displayAllMilkingMachines() {
        for (MilkingMachines mm : milkingMachinesList)
            System.out.println(mm.toString());
    }


    public MilkingMachines addMilkingMachine(String name ,MilkTank milktank)
    {
        if(milktank == null)
        {

            MilkingMachines newMachine = new MilkingMachines(name);
            for(MilkingMachines mm : milkingMachinesList)
            {
                if(mm.equals(newMachine))
                {
                    return null;
                }
            }
            milkingMachinesList.add(newMachine);
            return newMachine;
        }
        MilkingMachines newMachine = new MilkingMachines(name , milktank);
        for(MilkingMachines mm : milkingMachinesList)
        {
            if(mm.equals(newMachine))
            {
                return null;
            }
        }
        milkingMachinesList.add(newMachine);
        return newMachine;
    }

    public MilkingMachines removeMilkingMachine(int milkerID)
    {
            for(MilkingMachines mm : milkingMachinesList)
        {
            if(milkerID == mm.getId())
            {
                milkingMachinesList.remove(mm);
                return mm;
            }
        }
        return null;
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

   public MilkTank getMilkTank(int milkingMachineId)
    {
        for(MilkingMachines milkingMachine : milkingMachinesList) {
            if(milkingMachineId == milkingMachine.getId())
            {
                if (milkingMachinesList.contains(milkingMachine)) {
                    if (milkingMachine.isIfMilktank()) {
                        return milktank;
                    } else {
                        System.out.println("There is no Milktank connected");
                        return null;
                    }
                } else {
                    System.out.println("There is no Milking Machine matching those requirements");
                    return null;
                }
            }


        }
        return null;
    }

    void setMilktank(int milkerID, int tankid)
    {
        for(MilkingMachines milkingMachine : milkingMachinesList)

        {
            if(milkerID == milkingMachine.getId())
            {
                for(MilkTank tank : tanks)
                {
                    if(tankid == tank.getId())
                    {
                        if(milkingMachine.isIfMilktank()== true)
                        {
                            System.out.println("There is already a milkTank connected");
                        }
                        else
                        {
                            milkingMachine.setIfMilktank(true);
                            System.out.println("The new milktank "+tank.getName() + "is connected");
                        }

                    }
                }
            }
        }

    }

    void milkCow(DairyCow cow)
    {
        tankManager.addToTank(milktank.getId(),cow.getUdderCapacity());
        System.out.println(milktank.getMilkStored());
    }

    void milkGoat(Goat goat)
    {
        tankManager.addToTank(milktank.getId(),goat.getMilkCapacity());
    }




}
