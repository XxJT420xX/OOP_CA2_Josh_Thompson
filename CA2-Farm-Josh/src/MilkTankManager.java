
import java.util.ArrayList;

public class MilkTankManager {

    private  ArrayList<MilkTank> milkTankList;

    public MilkTankManager(ArrayList<MilkTank> milkTankList) {
        this.milkTankList = milkTankList;
    }


    public void displayAllTanks()
    {
        for(MilkTank m : milkTankList)
        {
            System.out.println(m.toString());
        }
    }


    public MilkTank findMilkTankByID(int id)
    {
        for (MilkTank m : milkTankList)
        {
            if (id == m.getId())
            {
                return m;
            }
        }
        return null;
    }

    public double getFromTank(MilkTank milktank,double amount)
    {
        double remaining;

        if(milktank.getMilkStored() <0)
        {
            if(milktank.getMilkStored() > amount)
            {
                milktank.setMilkStored(milktank.getMilkStored() - amount);
                return milktank.getMilkStored();
            }
            else
            {
                remaining = amount - milktank.getMilkStored();
                milktank.setMilkStored(0);
                System.out.println("You requested more milk than we currently have in this milk tank we emptied the tank but you are still in need of "
                        +remaining+"litres");
                return remaining;
            }

        }
        else
        {
            System.out.println("There is no milk in this tank you will have to try another one");
            return 0.00;
        }

    }

    public double freeSpace(MilkTank milktank, double spaceFreed)
    {
        if(milktank.getCapacity() > 0 && spaceFreed < milktank.getCapacity())
        {
            return milktank.setCapacity(milktank.getCapacity() - spaceFreed);
        }

        else
        {
            System.out.println("There is no milk in the tank to take out ");
            return 0.00;
        }
    }

    public void addToTank(MilkTank milktank,double amount)
    {
        double remaining;
        if(milktank.getMilkStored() != milktank.getCapacity())
        {
            if((milktank.getMilkStored()+amount) > milktank.getCapacity())
            {
                remaining = (milktank.getMilkStored() + amount) - milktank.getCapacity();
                milktank.setMilkStored(milktank.getCapacity());
                System.out.println("There was too much milk in the amount you wanted to add. So we filled to capacity and you have "
                        + remaining + "litres remaining");
            }
            else
            {
                milktank.setMilkStored(milktank.getMilkStored()+amount);
            }
        }
        else
        {
            System.out.println("The milk tank is at capacity and you cannot add anymore");
        }
    }
}
