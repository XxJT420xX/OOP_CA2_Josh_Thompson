import java.util.ArrayList;
import java.util.List;

public class ShedManager {


    private final ArrayList<Shed> shedList;
    private final ArrayList<Animal> herd;
    private final ArrayList<MilkingMachines> milkerList;
    private MilkingMachineManager milkMachineManager;


    public ShedManager() {
        this.shedList = new ArrayList<>();
        herd = new ArrayList<>();
        milkerList = new ArrayList<>();
    }


    public void displayAllShed()
    {
        for(Shed s : this.shedList)
        {
            System.out.println(s.toString());
        }
    }

    public Shed addShed(String name, boolean isMilker,boolean isTank)
    {
        Shed newShed= new Shed(name,isMilker,isTank);
        for(Shed s : shedList)
        {
            if(s.equals(newShed))
            {
                return null;
            }
        }
        shedList.add(newShed);
        return newShed;
    }

    public Shed removeShed(int shedID)
    {
        for(Shed s : shedList)
        {
            if(shedID == s.getId())
            {
                shedList.remove(s);
                return s;
            }
        }
        return null;
    }

    public void installMilkingMachine(int shedId, int milkerID)
    {
        for(Shed s : shedList)
        {
            if(shedId == s.getId())
            {
                for(MilkingMachines milkingMachine:milkerList)
                {
                    if(milkerID == milkingMachine.getId())
                    {
                        s.setMilker(true);
                        milkMachineManager.setMilktank(milkingMachine.getId(), s.getMilktank().getId());
                    }
                }

            }
        }


    }

    public void milkAnimal(int shedID,int animalId)
    {
        for(Shed shed: shedList)
        {
            if(shedID == shed.getId())
            {
                for(Animal animal : herd)
                {
                    if(animalId == animal.getId())
                    {
                        boolean b = shed.isMilker();
                        try {
                            if (animal.getType() == "Dairy Cow" || animal.getType() == "Goat") {
                                if (animal.getType() == "Dairy Cow") {
                                    DairyCow cow = new DairyCow("Dave", animal.getWeight(), animal.getType(), animal.getAge(), animal.isPedigree(),animal.isAlive(), animal.getValue());
                                    milkMachineManager.milkCow(cow);
                                } else if (animal.getType() == "Goat") {
                                    Goat goat = new Goat(animal.getWeight(), animal.getType(), animal.getAge(), animal.isPedigree(), "Bob",animal.isAlive(), animal.getValue());
                                    milkMachineManager.milkGoat(goat);
                                }
                            }
                        }
                        catch(IllegalStateException ise)
                        {

                            b = false;

                            System.out.println("There is no milking machine installed");
                        }
                    }
                }

            }
        }

    }


    public void milkAnimals(int shedID ,List<Animal> animals)
    {

        for(Shed shed: shedList) {
            if (shedID == shed.getId()) {
                boolean b = shed.isMilker();
                try {

                    for(int i = 0; i<animals.size(); i++)
                    {
                        if (animals.get(i).getId() == 1 || animals.get(i).getId() == 2) {
                            if (animals.get(i).getId() == 1) {
                                DairyCow cow = new DairyCow("Dave", animals.get(i).getWeight(), animals.get(i).getType(), animals.get(i).getAge(), animals.get(i).isPedigree(),
                                        animals.get(i).isAlive(),animals.get(i).getValue());
                                milkMachineManager.milkCow(cow);
                            } else if (animals.get(i).getId() == 2) {
                                Goat goat = new Goat(animals.get(i).getWeight(), animals.get(i).getType(), animals.get(i).getAge(),
                                        animals.get(i).isPedigree(), "Bob", animals.get(i).isAlive(),animals.get(i).getValue());
                                milkMachineManager.milkGoat(goat);
                            }
                            else

                            {
                                System.out.println("That herd cannot be milked");
                            }
                        }
                    }

                }
                catch(IllegalStateException ie)
                {
                    b = false;
                    System.out.println("There is no milking machine installed");
                }
            }
        }

    }


}
