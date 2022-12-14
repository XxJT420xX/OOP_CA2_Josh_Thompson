import java.util.ArrayList;

public class Farm {

    private int id;
    private String owner;
    private ArrayList <Animal> herd;
    private ShedManager shedManager;
    private MilkTankManager tankManager;
    private MilkingMachineManager milkingMachineManager;
    private AnimalManager animalManager;
    private IdGenerator idGenerator = IdGenerator.getInstance("newID.txt");

    public Farm(int id, String owner, ArrayList<Animal> herd, ShedManager shedManager, MilkTankManager tankManager, MilkingMachineManager milkingMachineManager) {
        this.id = id;
        this.owner = owner;
        this.herd = new ArrayList<>();
        this.shedManager = shedManager;
        this.tankManager = tankManager;
        this.milkingMachineManager = milkingMachineManager;
    }
    public Farm(int id,String owner)
    {

        this.id = id;
        this.owner = owner;
        this.herd = new ArrayList<>();
        this.shedManager = new ShedManager();
        this.tankManager = new MilkTankManager();
        this.milkingMachineManager = new MilkingMachineManager();
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public ArrayList<Animal> getHerd() {
        return herd;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", herd=" + herd +
                '}';
    }
}
