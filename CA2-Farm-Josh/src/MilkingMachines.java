public class MilkingMachines {
private int id;
private MilkTankManager milktankManager;
private MilkTank milktank;
private boolean ifMilktank;

    public MilkingMachines(int id, MilkTank milktank) {
        this.id = id;
        this.milktank = milktank;
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

    MilkTank getMilkTank()
    {
        if(ifMilktank)
        {
            return milktank;
        }
        else
        {
            System.out.println("There is no Milktank connected");
            return null;
        }
    }

    void setMilktank(MilkTank tank)
    {
        if(ifMilktank= true)
        {
            System.out.println("There is already a milkTank connected");
        }
        else
        {
            ifMilktank=true;
            System.out.println("The new milktank "+tank.getName() + "is connected");
        }
    }

    void milkCow(DairyCow cow)
    {
        milktankManager.addToTank(milktank,cow.getUdderCapacity());
        System.out.println(milktank.getMilkStored());
    }

    void milkGoat(Goat goat)
    {
        milktankManager.addToTank(milktank,goat.getMilkCapacity());
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
