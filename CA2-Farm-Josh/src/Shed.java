import java.util.ArrayList;
import java.util.List;

public class Shed {
    private int id;
    private String name;
    private ArrayList<Animal> animals= new ArrayList<>();
    private boolean isMilker;
    private boolean isTank;
    private MilkTank milktank;
    private MilkingMachines milkingMachine1;
    private MilkingMachineManager milkMachineManager;
    private MilkTankManager tankManager;
    private IdGenerator idGenerator = IdGenerator.getInstance("newID.txt");


    public Shed(String name ,boolean isMilker, boolean isTank)
    {
        this.id = idGenerator.getNextId();
        this.name = name;
        this.animals = new ArrayList<>();
        this.isMilker = isMilker;
        this.isTank = isTank;
        this.milktank = new MilkTank();
        this.milkingMachine1 = new MilkingMachines();
    }


    public int getId() {
        return id;
    }

    public Shed(MilkTank tank)
    {
        this.milktank = tank;
    }

    public MilkTank getMilktank() {
        return milktank;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public boolean isMilker() {
        return isMilker;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMilker(boolean milker) {
        isMilker = milker;
    }

    public void setMilktank(MilkTank milktank) {
        this.milktank = milktank;
    }

    public void setMilkingMachine1(MilkingMachines milkingMachine1) {
        this.milkingMachine1 = milkingMachine1;
    }

    public void setMilkMachineManager(MilkingMachineManager milkMachineManager) {
        this.milkMachineManager = milkMachineManager;
    }

    public void setTankManager(MilkTankManager tankManager) {
        this.tankManager = tankManager;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
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

