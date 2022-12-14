
import java.util.ArrayList;

public class MilkTankManager {

    private  ArrayList<MilkTank> milkTankList;

    public MilkTankManager() {
        this.milkTankList = new ArrayList<>();
    }


    public void displayAllTanks()
    {
        for(MilkTank m : milkTankList)
        {
            System.out.println(m.toString());
        }
    }

    public MilkTank addMilkTank(String name, double capacity,double milkStored)
    {
        if(capacity == 0)
        {
            MilkTank newTanker = new MilkTank();
            for (MilkTank m : milkTankList)
            {
                if(m.equals(newTanker))
                {
                    return null;
                }

            }
            return newTanker;
        }
        MilkTank newTank = new MilkTank(name,capacity,milkStored);
        for (MilkTank m : milkTankList)
        {
            if(m.equals(newTank))
            {
                return null;
            }

        }

        milkTankList.add(newTank);
        return newTank;
    }


    public MilkTank removeTank(int milkTankID)
    {
        for(MilkTank m : milkTankList)
        {
            if(milkTankID == m.getId())
            {
                milkTankList.remove(m);
                return m;
            }
        }
        return null;
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

    public double getFromTank(int tankID,double amount)
    {
        for(MilkTank milktank : milkTankList)
        {
            if(tankID == milktank.getId())
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

            }
        }
        System.out.println("There is no milk in the Tank");
       return 0.00;

    }

    public double freeSpace(int tankID, double spaceFreed)
    {
        for(MilkTank milktank : milkTankList) {
            if (tankID == milktank.getId()) {
                if(milktank.getCapacity() > 0 && spaceFreed < milktank.getCapacity())
                {
                    return milktank.setCapacity(milktank.getCapacity() - spaceFreed);
                }

            }
        }
        System.out.println("There is no milk in the tank to take out ");
        return 0.00;
    }

    public double addToTank(int tankID,double amount)
    {
        for(MilkTank milktank : milkTankList) {
            if (tankID == milktank.getId()) {
                double remaining;
                if(milktank.getMilkStored() != milktank.getCapacity())
                {
                    if((milktank.getMilkStored()+amount) > milktank.getCapacity())
                    {
                        remaining = (milktank.getMilkStored() + amount) - milktank.getCapacity();
                        milktank.setMilkStored(milktank.getCapacity());
                        System.out.println("There was too much milk in the amount you wanted to add. So we filled to capacity and you have "
                                + remaining + "litres remaining");
                        return remaining;
                    }
                    else
                    {
                        milktank.setMilkStored(milktank.getMilkStored()+amount);
                        return milktank.getMilkStored();
                    }
                }
            }
        }
            System.out.println("The milk tank is at capacity and you cannot add anymore");
        return 0.00;

    }
}
