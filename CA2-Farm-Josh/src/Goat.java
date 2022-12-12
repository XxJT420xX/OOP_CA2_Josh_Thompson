public class Goat extends Animal{

    private String name;
    private double milkCapacity = Math.random()* (2 - 3);

    public Goat(double weight, String type, int age, boolean male, String name, boolean isAlive,double value) {
        super( weight, type, age, male,isAlive,value);
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public double getMilkCapacity() {
        return milkCapacity;
    }

    @Override
    public double getValue()
    {
        setValue(getMilkCapacity()*0.8);
        return getValue();
    }

    public void milkGoat(Goat goat)
    {
        if(milkCapacity > 0) {
            goat.milkCapacity = 0;
            System.out.println("Goat has been milked");
            milkCapacity = Math.random()* (2 - 3);
        }
        else
        {
            System.out.println("The goat is out of milk");
        }
    }



}
