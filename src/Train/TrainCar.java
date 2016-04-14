package Train;

//import java.util.*;

public class TrainCar {
    protected int deadWeight;

    public TrainCar(int deadWeight) {
        this.deadWeight = deadWeight;
    }

    public int getTotalWeight() {
        return deadWeight ;
    }

    public int getDeadWeight() {
        return deadWeight;
    }

    public void setDeadWeight(int deadWeight) {
        this.deadWeight = deadWeight;
    }


}
