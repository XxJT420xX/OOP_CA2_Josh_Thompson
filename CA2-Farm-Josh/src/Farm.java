import java.util.ArrayList;

public class Farm {

    private int id;
    private String owner;
    private ArrayList <Animal> herd;
    private Shed shed;
    private IdGenerator idGenerator = IdGenerator.getInstance("newID.txt");

    public Farm(String owner, ArrayList<Animal> herd, Shed shed, IdGenerator idGenerator) {
        this.id = idGenerator.getNextId();
        this.owner = owner;
        this.herd = herd;
        this.shed = shed;
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

    public Shed getShed() {
        return shed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setShed(Shed shed) {
        this.shed = shed;
    }

    public void addAnimal(Animal animal)
    {
        herd.add(animal);
        System.out.println("The animal has been added to the herd");
    }

    public void addShed(Shed shed)
    {
        setShed(shed);
    }

}
