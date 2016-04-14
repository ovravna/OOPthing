package Train;

//import java.util.*;

public class PassengerCar extends TrainCar {
    private int passengerCount;

    public PassengerCar(int deadWeight, int passengerCount) {
        super(deadWeight);
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public int getTotalWeight() {
        return super.deadWeight + passengerCount*80;
    }
}
