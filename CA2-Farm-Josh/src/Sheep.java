public class Sheep extends Animal{


    private String name;
    private double averageWool;


    public Sheep(double weight, String type, int age, boolean male,  String name,double averageWool,double value,boolean isAlive) {
        super(weight, type, age, male,isAlive,value);
        this.name = name;
        this.averageWool = averageWool;

    }

    public String getName() {
        return name;
    }

    public double getAverageWool() {
        return averageWool;
    }

    @Override
    public double getValue() {
        setValue(0);
        if (getWeight() > 150 && getWeight() < 250 && isPedigree() == true && getAge() < 10) {
            setValue(getWeight() * 2);
        } else if (getWeight() > 150 && getWeight() < 250 && isPedigree() == true && getAge() > 10) {
            setValue(getWeight() * 1.5);
        } else if (getWeight() > 150 && getWeight() < 250 && isPedigree() == false && getAge() < 10) {
            setValue(getWeight() * 1);
        } else if (getWeight() < 150 || getWeight() > 250 && isPedigree() == true && getAge() < 10) {
            setValue(getWeight() * 0.5);
        } else if (getWeight() < 150 || getWeight() > 250 && isPedigree() == false && getAge() < 10) {
            setValue(getWeight() * 0.5);
        } else if (getWeight() < 150 || getWeight() > 250 && isPedigree() == true && getAge() > 10) {
            setValue(getWeight() * 0.7);
        } else if (getWeight() > 150 && getWeight() < 250 && isPedigree() == false && getAge() > 10) {
            setValue(getWeight() * 0.4);
        } else if (getWeight() < 150 || getWeight() > 250 && isPedigree() == false && getAge() > 10) {
            setValue(getWeight() * 0.2);
        }

        return getValue();
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", averageWool=" + averageWool +
                '}';
    }
}
