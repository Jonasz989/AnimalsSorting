package Application.Tools;

import Application.Model.Animal;
import Application.Model.Farm;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

public class ReadFiles {

    /**
     * Method for reading farms.txt input
     */
    public static void readFileFarm() {
        try {
            File myFile = new File("src/Application/farms.txt");
            Scanner myReader = new Scanner(myFile.getAbsoluteFile());
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] stringFromData = data.split(";");
                if (Solver.getFARMS().containsKey(Integer.valueOf(stringFromData[0].trim()))) { //sprawdzamy czy farma o takim id sie nie znajduje juz
                    int allFoodInFarm = 0;
                    for (int i = 1; i < stringFromData.length; i++) {
                        Solver.getFARMS().get(Integer.valueOf(stringFromData[0].trim())).getFoodInFarm().put(i, Integer.valueOf(stringFromData[i].trim()));
                        allFoodInFarm+= Integer.parseInt(stringFromData[i].trim());
                    }
                    Solver.getFARMS().get(Integer.valueOf(stringFromData[0].trim())).setSumOfAllFood(allFoodInFarm);
                    Solver.getFARMS().get(Integer.valueOf(stringFromData[0].trim())).setCurrentFoodInFarm(Solver.getFARMS().get(Integer.valueOf(stringFromData[0].trim())).getFoodInFarm());
                    Solver.getFoodInFarms().put(Integer.valueOf(stringFromData[0].trim()), Solver.getFARMS().get(Integer.valueOf(stringFromData[0].trim())).getSumOfAllFood());
                } else { //jesli sie nie znajduje to
                    int allFoodInFarm = 0;
                    Solver.getFARMS().put(Integer.valueOf(stringFromData[0].trim()), new Farm(Integer.parseInt(stringFromData[0].trim()))); //tworzymy nowa farme
                    for (int i = 1; i < stringFromData.length; i++) { //dodajemy do niej wartosci, ktore sa w dokumencie
                        Solver.getFARMS().get(Integer.valueOf(stringFromData[0].trim())).getFoodInFarm().put(i, Integer.valueOf(stringFromData[i].trim()));
                        allFoodInFarm += Integer.parseInt(stringFromData[i].trim());
                    }
                    Solver.getFARMS().get(Integer.valueOf(stringFromData[0].trim())).setSumOfAllFood(allFoodInFarm); //na koniec ustalamy ilosc calego jedzenia w danej farme
                    Solver.getFARMS().get(Integer.valueOf(stringFromData[0].trim())).setCurrentFoodInFarm(Solver.getFARMS().get(Integer.valueOf(stringFromData[0].trim())).getFoodInFarm()); //aktualne jedzenie jako calkowite
                    Solver.getFoodInFarms().put(Integer.valueOf(stringFromData[0].trim()), Solver.getFARMS().get(Integer.valueOf(stringFromData[0].trim())).getSumOfAllFood());

                }
                Solver.setHowManyFoodTypes(stringFromData.length - 1);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error in reading \"farms.txt\".");
            e.printStackTrace();
        }
    }

    /**
     * Method for reading types.txt input
     */
    public static void readFileTypes() {
        try {
            File myFile = new File("src/Application/types.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] stringFromData = data.split(";");
                Integer currentAnimalType = Integer.valueOf(stringFromData[0].trim());

                if (Solver.getFoodWithAmount().containsKey(currentAnimalType)) {
                    Solver.getFoodWithAmount().get(currentAnimalType).put(Integer.valueOf(stringFromData[1].trim()), Integer.valueOf(stringFromData[2].trim()));
                } else {
                    Solver.getFoodWithAmount().put(currentAnimalType, new HashMap<>());
                    Solver.getFoodWithAmount().get(currentAnimalType).put(Integer.valueOf(stringFromData[1].trim()), Integer.valueOf(stringFromData[2].trim()));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error in reading \"types.txt\".");
            e.printStackTrace();
        }
    }

    /**
     * Method for reading animals.txt input to Map
     */
    public static void readFileAnimals() {
        try {
            File myFile = new File("src/Application/animals.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine(); //wczytanie linijki
                String[] stringFromData = data.split(";"); //podzielenie jej na wartosci

                Animal animal = new Animal(Integer.valueOf(stringFromData[0].trim()), Integer.valueOf(stringFromData[1].trim())); //dodanie do obiektu animal wartosci id i type

                Solver.getANIMALS().put(Integer.valueOf(stringFromData[0].trim()), animal); //przypisanie do mapy id i klasy animal zwierzecia

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error in reading \"types.txt\".");
            e.printStackTrace();
        }
    }



}
