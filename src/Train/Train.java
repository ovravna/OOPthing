package Train;

//import java.util.*;

import java.util.ArrayList;
import java.util.List;

public class Train {
    List<TrainCar> trainCars = new ArrayList<>();


    public void addTrainCar(TrainCar car) {
        trainCars.add(car);
    }

    public boolean contains(TrainCar car) {
        return trainCars.contains(car);
    }

    public int getTotalWeight() {
        return trainCars.stream().mapToInt(TrainCar::getTotalWeight).sum();
    }

    public int getPassengerCount() {
        return trainCars.stream().mapToInt(n -> n instanceof PassengerCar ? ((PassengerCar) n).getPassengerCount():0).sum();
    }

    public int getCargoWeight() {
        return trainCars.stream().mapToInt(n -> n instanceof CargoCar ? ((CargoCar) n).getCargoWeight():0).sum();
    }

    @Override
    public String toString() {
        String r = "";
        String s = "";

        for (TrainCar car : trainCars) {

            if (car instanceof PassengerCar) {
                s = "Passengers:   "+((PassengerCar) car).getPassengerCount();
            } else if (car instanceof CargoCar) {
                s = "Cargo weight: "+((CargoCar) car).getCargoWeight();
            }
            r += String.format("Type: %-12s Weight:%4d %s", car.getClass().getSimpleName(), car.deadWeight, s);

            r += "\n";
        }


        return r;
    }
}
