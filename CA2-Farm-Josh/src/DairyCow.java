import java.util.Random;

public class DairyCow extends Animal{

    private String name;
    private double udderCapacity = Math.random() * (20 - 40);

    public DairyCow(String name, double weight, String type, int age, boolean male,boolean isAlive, double value) {
        super(weight, type, age, male,isAlive);
        this.name = name;
    }
    void DairyCow()
    {
    }

    public String getName() {
        return name;
    }

    public double getUdderCapacity() {
        return udderCapacity;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
public double getValue()
{
    setValue(getUdderCapacity()*1.5);

    return getValue();
}

    public void milkCow(DairyCow cow)
    {
        if(udderCapacity > 0) {
            cow.udderCapacity = 0;
            System.out.println("Cow has been milked");
            udderCapacity = Math.random() * (20 - 40);
        }
        else
        {
            System.out.println("The cow is out of milk");
        }
    }


    @Override
    public String toString() {
        return "DairyCow{" +
                "name='" + name + '\'' +
                ", udderCapacity=" + udderCapacity +
                '}';
    }
}
