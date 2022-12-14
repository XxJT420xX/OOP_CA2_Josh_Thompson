

public class MilkTank {
private int id;
private double capacity;
private double milkStored;
private static final int STANDARD_TANK_CAPACITY = 2000;
private String name;
private IdGenerator idGenerator = IdGenerator.getInstance("newID.txt");

     MilkTank() {
        this.name = "unamed tank";
        this.id = idGenerator.getNextId();
        this.capacity = STANDARD_TANK_CAPACITY;
        this.milkStored = 0;
    }

     MilkTank(String name, double capacity,double milkStored)
    {
        this.name = name;
        this.id = idGenerator.getNextId();
        this.capacity = capacity;
        this.milkStored =milkStored;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getMilkStored() {
        return milkStored;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double setCapacity(double capacity) {
        this.capacity = capacity;
        return capacity;
    }

    public double setMilkStored(double milkStored) {
        this.milkStored = milkStored;
        return milkStored;
    }

    public void setName(String name) {
        this.name = name;
    }






    @Override
    public String toString() {
        return "MilkTank{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", milkStored=" + milkStored +
                '}';
    }
}
