public class BeefCow extends Animal {

    private String name;
    private double amountOfBeef;


    public BeefCow( double weight, String type, int age, boolean male, String name, double amountOfBeef,boolean isAlive,double value) {
        super(weight, type, age, male,isAlive,value);
        this.name = name;
        this.amountOfBeef = amountOfBeef;

    }

    public String getName() {
        return name;
    }


    public double getAmountOfBeef() {
        return amountOfBeef;
    }

    @Override
    public double getValue()
    {
        setValue(0);
        if(getWeight() > 280 && getWeight() < 380 && isPedigree() == true && getAge() <10) {
             setValue(getWeight() *2);
        }
        else if(getWeight() > 280 && getWeight() < 380 && isPedigree() == true && getAge() >10)
        {
            setValue(getWeight() *1.5);
        }
        else if(getWeight() > 280 && getWeight() < 380 && isPedigree() == false && getAge() <10)
        {
            setValue(getWeight() *1);
        }

        else if(getWeight() < 280 || getWeight() > 380 && isPedigree() == true && getAge() <10)
        {
            setValue(getWeight() *0.5);
        }

        else if(getWeight() < 280 || getWeight() > 380 && isPedigree() == false && getAge() <10)
        {
            setValue(getWeight() *0.5);
        }

        else if(getWeight() < 280 || getWeight() > 380 && isPedigree() == true && getAge() >10)
        {
            setValue(getWeight() *0.7);
        }
        else if(getWeight() > 280 && getWeight() < 380 && isPedigree() == false && getAge()>10)
        {
            setValue(getWeight() *0.4);
        }

        else if(getWeight() < 280 || getWeight() > 380 && isPedigree() == false && getAge() >10)
        {
            setValue(getWeight() *0.2);
        }

       return getValue();
    }

    @Override
    public String toString() {
        return "BeefCow{" +
                "name='" + name + '\'' +
                ", amountOfBeef=" + amountOfBeef +
                '}';
    }
}
