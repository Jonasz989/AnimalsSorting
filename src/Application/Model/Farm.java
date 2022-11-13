package Application.Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Farm {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //VARIABLES
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final Integer ID;
    private Map<Integer, Integer> foodInFarm = new HashMap<>();
    private Map<Integer, Integer> currentFoodInFarm = new HashMap<>();
    private int sumOfAllFood = 0;

    private ArrayList<Integer> assignedAnimals = new ArrayList<>();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //CLASS
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Farm(int ID) {
        this.ID = ID;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //GETTERS AND SETTERS
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int getID() {
        return ID;
    }
    public Map<Integer, Integer> getFoodInFarm() {
        return foodInFarm;
    }
    public int getSumOfAllFood() {
        return sumOfAllFood;
    }
    public void setSumOfAllFood(int sumOfAllFood) {
        this.sumOfAllFood = sumOfAllFood;
    }
    public Map<Integer, Integer> getCurrentFoodInFarm() {
        return currentFoodInFarm;
    }
    public void setCurrentFoodInFarm(Map<Integer, Integer> currentFoodInFarm) {
        this.currentFoodInFarm = currentFoodInFarm;
    }
    public ArrayList<Integer> getAssignedAnimals() {
        return assignedAnimals;
    }
}
