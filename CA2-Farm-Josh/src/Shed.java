import java.util.ArrayList;
import java.util.List;

public class Shed {
    private int id;
    private ArrayList<Animal> animals= new ArrayList<>();
    private boolean isMilker;
    private MilkTank milktank;
    private MilkingMachines milkingMachine1;
    private IdGenerator idGenerator = IdGenerator.getInstance("newID.txt");

    public Shed(ArrayList<Animal> animals, boolean isMilker, MilkTank milktank, MilkingMachines milkingMachine1, IdGenerator idGenerator) {
        this.id = idGenerator.getNextId();
        this.animals = animals;
        this.isMilker = isMilker;
        this.milktank = milktank;
        this.milkingMachine1 = milkingMachine1;

    }

    public Shed(MilkTank tank)
    {
        this.milktank = tank;
    }

    public MilkTank getMilktank() {
        return milktank;
    }

    private void installMilkingMachine(MilkingMachines milkingMachine)
    {
        isMilker = true;
        milkingMachine.setMilktank(milktank);
        MilkTank milktank2;
    }

    public void milkAnimal(Animal animal)
    {

        try {
            if (animal.getType() == "Dairy Cow" || animal.getType() == "Goat") {
                if (animal.getType() == "Dairy Cow") {
                    DairyCow cow = new DairyCow("Dave", animal.getWeight(), animal.getType(), animal.getAge(), animal.isPedigree(),animal.isAlive(), animal.getValue());
                    milkingMachine1.milkCow(cow);
                } else if (animal.getType() == "Goat") {
                    Goat goat = new Goat(animal.getWeight(), animal.getType(), animal.getAge(), animal.isPedigree(), "Bob",animal.isAlive(), animal.getValue());
                    milkingMachine1.milkGoat(goat);
                }
            }
        }
        catch(IllegalStateException ie)
        {
            isMilker = false;
            System.out.println("There is no milking machine installed");
        }
    }



    public void milkAnimals(List<Animal> animals)
    {
        try {

            for(int i = 0; i<animals.size(); i++)
            {
                if (animals.get(i).getId() == 1 || animals.get(i).getId() == 2) {
                    if (animals.get(i).getId() == 1) {
                        DairyCow cow = new DairyCow("Dave", animals.get(i).getWeight(), animals.get(i).getType(), animals.get(i).getAge(), animals.get(i).isPedigree(),
                                animals.get(i).isAlive(),animals.get(i).getValue());
                        milkingMachine1.milkCow(cow);
                    } else if (animals.get(i).getId() == 2) {
                        Goat goat = new Goat(animals.get(i).getWeight(), animals.get(i).getType(), animals.get(i).getAge(),
                                animals.get(i).isPedigree(), "Bob", animals.get(i).isAlive(),animals.get(i).getValue());
                        milkingMachine1.milkGoat(goat);
                    }
                }
            }

        }
        catch(IllegalStateException ie)
        {
            isMilker = false;
            System.out.println("There is no milking machine installed");
        }
    }

    public void die(List<Animal>herd,Animal animal)
    {
        for(Animal a : herd){
            if(herd.contains(animal)) {
                herd.remove(animal);
                animal.setAlive(false);
                System.out.println("That animal has died and is gone from the herd");
            }

            else
            {
                System.out.println("That animal is not in the herd");
            }
        }
    }

    @Override
    public String toString() {
        return "Shed{" +
                "id=" + id +
                ", animals=" + animals +
                ", isMilker=" + isMilker +
                ", milktank=" + milktank +
                ", milkingMachine1=" + milkingMachine1 +
                '}';
    }
}

