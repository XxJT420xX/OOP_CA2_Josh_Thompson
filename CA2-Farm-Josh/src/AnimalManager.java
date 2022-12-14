import java.util.ArrayList;
import java.util.Collections;

public class AnimalManager {

    private final ArrayList<Animal> herd;


    public AnimalManager() {
        this.herd = new ArrayList<>();
    }

    public ArrayList<Animal> getHerd() {
        return this.herd;
    }

    public void displayAllAnimals() {
        for (Animal a : this.herd) {
            System.out.println(a.toString());
        }
    }

    public Animal addAnimal(double weight, String type, int age, boolean pedigree, boolean isAlive) {
        Animal newAnimal = new Animal(weight, type, age, pedigree, isAlive);
        for (Animal a : herd) {
            if (a.equals(newAnimal)) {
                return null;
            }
        }

        herd.add(newAnimal);
        return newAnimal;
    }

    public String findAnimal(int id)
    {
        for (Animal a : herd)
        {
            if(id == a.getId())
            {
                return a.toString();
            }
        }
        return null;
    }

    public ArrayList<Animal> findAnimalByType(String type)
    {
        ArrayList<Animal> match = new ArrayList<>();

        for(Animal a : herd)
        {
            if(type.equals(a.getType()))
            {
                match.add(a);
            }
        }

        return match;
    }
    public ArrayList<Animal> compareByValue(ArrayList<Animal>herd)
    {

        AnimalValueComparator animalComparator = new AnimalValueComparator();
        Collections.sort(herd,animalComparator);
        return herd;
    }

    public Animal removeAnimal(int animalID)
    {
        for(Animal a : herd)
        {
            if(animalID == a.getId())
            {
                herd.remove(a);
                return a;
            }
        }
        return null;
    }


}
