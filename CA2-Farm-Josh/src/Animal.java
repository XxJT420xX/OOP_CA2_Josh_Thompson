public class Animal {

    private int id;
    private double weight;
    private String type;
    private int age;
    private boolean pedigree;
    private IdGenerator idGenerator=  IdGenerator.getInstance("newID.txt");
    private boolean isAlive;
    private double value;




    public Animal(double weight, String type, int age, boolean pedigree, boolean isAlive,double value) {
        this.id = idGenerator.getNextId();
        this.weight = weight;
        this.type = type;
        this.age = age;
        this.pedigree = pedigree;
        this.isAlive = isAlive;
        this.value = value;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public boolean isPedigree() {
        return pedigree;
    }

    public String getType() {
        return type;
    }

    public double getValue() {
       return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPedigree(boolean pedigree) {
        this.pedigree = pedigree;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", pedigree=" + pedigree +
                ", idGenerator=" + idGenerator +
                ", isAlive=" + isAlive +
                '}';
    }
}
