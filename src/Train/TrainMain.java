package Train;

//import java.util.*;

public class TrainMain {
    Train train;
    TrainCar t0, t1;

    public TrainMain() {
        train = new Train();
        t0 = new PassengerCar(100, 10);
        t1 = new CargoCar(120, 80);
        train.addTrainCar(t0);
        train.addTrainCar(t1);
        System.out.println(train);
    }

    public static void main(String[] args) {
        new TrainMain();
    }


}
