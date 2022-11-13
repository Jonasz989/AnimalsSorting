package Application.Tools;
import Application.Model.Animal;
import Application.Model.Farm;
import java.util.*;
import java.util.stream.Collectors;

public class Solver {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //VARIABLES
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static Map<Integer, Animal> ANIMALS = new HashMap<>();
    private static Map<Integer, Map> foodWithAmount = new HashMap<>();
    private static Map<Integer, Integer> sumOfFood = new HashMap<>();
    private static Set<Integer> sortedTypeByHighestToLowest = new LinkedHashSet<>();
    private static Map<Integer, Farm> FARMS = new HashMap<>();
    private static Map<Integer, Animal> sortedANIMALS = new HashMap<>();
    private static Map<Integer, Farm> sortedFARMS = new HashMap<>();
    private static Map<Integer, Integer> foodInFarms = new HashMap<>();
    private static int numberOfTypes = 0;
    private static int howManyFoodTypes = 0;


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CLASS
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void SolvTask() {
        prepareData();
//rozwiazanie
        for (int i = 1; i <= sortedANIMALS.size() ; i++) {
                for (int j = 1; j <= sortedFARMS.size(); j++) {
                    boolean FoodOkay = true;
                    int temp = 0;
                    //Pobieram pierwsze zwierze i sprawdzam czy miesci sie do farm od najmniejszej ilosci jedzenia do najwiekszej

                    for (int k = 1; k <= getHowManyFoodTypes(); k++) {
                        if (getSortedANIMALS().get(i).getFoodNeeded().containsKey(k)) {
                            if (getSortedANIMALS().get(i).getFoodNeeded().get(k) > getSortedFARMS().get(j).getCurrentFoodInFarm().get(k)) {
                                FoodOkay = false;
                                break;
                            }
                        } else {
                            getSortedANIMALS().get(i).getFoodNeeded().put(k, 0);
                            k--;
                        }
                        temp = k;
                    }
                    if (FoodOkay && temp == getHowManyFoodTypes() && !getSortedANIMALS().get(i).isAssigned()) {
                        getSortedFARMS().get(j).getAssignedAnimals().add(getSortedANIMALS().get(i).getID());
                        for (int z = 1; z <= getHowManyFoodTypes(); z++) {
                            int substractedFood = getSortedFARMS().get(j).getCurrentFoodInFarm().get(z) - getSortedANIMALS().get(i).getFoodNeeded().get(z);
                            getSortedFARMS().get(j).getCurrentFoodInFarm().replace(z, substractedFood);
                        }
                        getSortedANIMALS().get(i).setAssigned(true);
                    }
                }
        }


//wyswietlanie
        for (int i = 1; i <= getFARMS().size(); i++) {
            int unusedFarmPotential = 0;
            for (int j = 1; j <= getHowManyFoodTypes(); j++) {
                unusedFarmPotential += getSortedFARMS().get(i).getCurrentFoodInFarm().get(j);
            }
            System.out.println(getSortedFARMS().get(i).getID() + "; " + unusedFarmPotential + "; " + getSortedFARMS().get(i).getAssignedAnimals());
        }
    }


    public static void prepareData() {
        readingAllInputs();
        addingFoodToAnimals(); //adding map with food to every position in map ANIMALS
        setNumberOfTypes(foodWithAmount.size());
        sumingFood(); //suming food that types need
        setNumberOfTypes(getFoodWithAmount().size()); //setting number of all types
        creatingSetWithOrderedFoodFromHighestToLowest(); //set for sorting animals
        sortingAnimalsByDemandFromHighestToLowest(); //sorting animals by demand
        sortingFarmsByFoodFromLowestToHighest(); //sorting farms by demand
    }
    public static void sortingFarmsByFoodFromLowestToHighest() {
        int ID = 1;
        while (!getFoodInFarms().isEmpty()) {
            int tempForCreatingNumberedSet = 0;
            int minFood = Collections.min(getFoodInFarms().values());
            for (int i = 1; i <= getFARMS().size(); i++) {
                if (getFoodInFarms().containsKey(i)) {
                    if (getFoodInFarms().get(i) == minFood) {
                        tempForCreatingNumberedSet = i;
                    }
                }
            }
            getSortedFARMS().put(ID++, getFARMS().get(tempForCreatingNumberedSet));
            getFoodInFarms().remove(tempForCreatingNumberedSet, minFood);
        }
    }
    public static void sortingAnimalsByDemandFromHighestToLowest() {
        int counterForSortedMap = 1;
        for (int z : getSortedTypeByHighestToLowest()) {
            for (int i = 1; i <= getANIMALS().size() ; i++) {
                if (getANIMALS().get(i).getTYPE() == z) {
                    getSortedANIMALS().put(counterForSortedMap++, getANIMALS().get(i));
                }
            }
        }
    }
    public static void addingFoodToAnimals() {
        for (int i = 1; i <= getANIMALS().size(); i++) {
            getANIMALS().get(i).setFoodNeeded(getFoodWithAmount().get(getANIMALS().get(i).getTYPE()));
        }
    }
    public static void sumingFood() {
        for (int i = 1; i <= getNumberOfTypes(); i++) {
            Integer essa = (Integer) foodWithAmount.get(i).values().stream().collect(Collectors.summingInt(Integer::intValue));
            getSumOfFood().put(i, essa);
        }
    }
    public static void creatingSetWithOrderedFoodFromHighestToLowest() {
        while (!getSumOfFood().isEmpty()) {
            int tempForCreatingNumberedSet = 0;
            int maxFood = Collections.max(getSumOfFood().values());
            for (int i = 1; i <= getNumberOfTypes(); i++) {
                if (getSumOfFood().containsKey(i)) {
                    if (getSumOfFood().get(i) == maxFood) {
                        tempForCreatingNumberedSet = i;
                    }
                }
            }
            getSortedTypeByHighestToLowest().add(tempForCreatingNumberedSet);
            getSumOfFood().values().remove(Collections.max(getSumOfFood().values()));
        }
    }
    public static void readingAllInputs() {
        ReadFiles.readFileAnimals();

        ReadFiles.readFileTypes();

        //ReadFiles essa = new ReadFiles();
        ReadFiles.readFileFarm();
    }
    public static void showingAnimals() {
        for (int i = 1; i <= getANIMALS().size(); i++) {
            System.out.println("ID: " + getANIMALS().get(i).getID() + ", Type: " + getANIMALS().get(i).getTYPE() + " food: " + getSortedANIMALS().get(i).getFoodNeeded());
        }
    }
    public static void showingAnimalsSorted() {
        for (int i = 1; i <= getSortedANIMALS().size(); i++) {
            System.out.println("ID: " + getSortedANIMALS().get(i).getID() + ", Type: " + getSortedANIMALS().get(i).getTYPE() + " food: " + getSortedANIMALS().get(i).getFoodNeeded());
        }
    }
    public static void showFarms() {
        for (int i = 1; i <= getFARMS().size(); i++) {
            System.out.println("ID: " + getFARMS().get(i).getID() + " Food: " + getFARMS().get(i).getFoodInFarm() + " sum of food: " + getFARMS().get(i).getSumOfAllFood());
        }
    }
    public static void showFarmsWithCurrentFood() {
        for (int i = 1; i <= getFARMS().size(); i++) {
            System.out.println("ID: " + getFARMS().get(i).getID() + " Food: " + getFARMS().get(i).getCurrentFoodInFarm());
        }
    }
    public static void showSortedFarms() {
        for (int i = 1; i <= getSortedFARMS().size(); i++) {
            System.out.println("ID: " + getSortedFARMS().get(i).getID() + " Food: " + getSortedFARMS().get(i).getFoodInFarm() + " sum of food: " + getSortedFARMS().get(i).getSumOfAllFood());
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GETTERS AND SETTERS
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static Map<Integer, Animal> getANIMALS() {
        return ANIMALS;
    }
    public static int getNumberOfTypes() {
        return numberOfTypes;
    }
    public static void setNumberOfTypes(int numberOfTypes) {
        Solver.numberOfTypes = numberOfTypes;
    }
    public static Map<Integer, Integer> getSumOfFood() {
        return sumOfFood;
    }
    public static Map<Integer, Map> getFoodWithAmount() {
        return foodWithAmount;
    }
    public static Set<Integer> getSortedTypeByHighestToLowest() {
        return sortedTypeByHighestToLowest;
    }
    public static Map<Integer, Farm> getFARMS() {
        return FARMS;
    }
    public static Map<Integer, Animal> getSortedANIMALS() {
        return sortedANIMALS;
    }
    public static Map<Integer, Farm> getSortedFARMS() {
        return sortedFARMS;
    }
    public static Map<Integer, Integer> getFoodInFarms() {
        return foodInFarms;
    }
    public static int getHowManyFoodTypes() {
        return howManyFoodTypes;
    }
    public static void setHowManyFoodTypes(int howManyFoodTypes) {
        Solver.howManyFoodTypes = howManyFoodTypes;
    }

}
