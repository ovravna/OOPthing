package Train;

//import java.util.*;

public class CargoCar extends TrainCar{
    private int cargoWeight;

    public CargoCar(int deadWeight, int cargoWeight) {
        super(deadWeight);
        this.cargoWeight = cargoWeight;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    @Override
    public int getTotalWeight() {
        return super.deadWeight+cargoWeight;
    }
}
