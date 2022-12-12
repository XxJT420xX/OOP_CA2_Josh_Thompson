import java.util.Comparator;

public class AnimalValueComparator implements Comparator<Animal> {


    // got from https://www.baeldung.com/java-comparator-comparable
    @Override
    public int compare(Animal firstAnimal ,Animal secondAnimal)
    {
        return Double.compare(firstAnimal.getValue(),secondAnimal.getValue());
    }
}
