public class MilkingMachines {
private int id;
private String name;
private MilkTankManager milktankManager;
private MilkTank milktank;
private boolean ifMilktank;
private IdGenerator idGenerator = IdGenerator.getInstance("newID.txt");

    public MilkingMachines(String name,MilkTank milktank) {
        this.id = idGenerator.getNextId();
        this.milktank = milktank;
    }

    public MilkingMachines(String name){
        this.name = name;
        this.id = idGenerator.getNextId();

    }
    public MilkingMachines(){
        this.name = "Unnamed Machine";
        this.id = idGenerator.getNextId();

    }

    public int getId() {
        return id;
    }

    public MilkTank getMilktank() {
        return milktank;
    }

    public boolean isIfMilktank() {
        return ifMilktank;
    }

    public void setIfMilktank(boolean ifMilktank) {
        this.ifMilktank = ifMilktank;
    }


    @Override
    public String toString() {
        return "MilkingMachines{" +
                "id=" + id +
                ", milktank=" + milktank +
                ", ifMilktank=" + ifMilktank +
                '}';
    }
}
