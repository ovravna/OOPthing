package MobileUsage;

import MobileUsage.MobileUsage;

public class MobileSubscription {
    private double callCost, callMinuteCost, massageCost, recivedMBytesCost, sentMBytesCost;

    public MobileSubscription(double callCost, double
            callMinuteCost, double massageCost,
            double recivedMBytesCost, double sentMBytesCost) {

        this.callCost = callCost;
        this.callMinuteCost = callMinuteCost;
        this.massageCost = massageCost;
        this.recivedMBytesCost = recivedMBytesCost;
        this.sentMBytesCost = sentMBytesCost;

    }





    public static int computeTotalCost(MobileUsage usage) {


        return 0; //temp
    }







    //=========== Getters & Setters ==========
    public double getCallCost() {
        return callCost;
    }

    public double getCallMinuteCost() {
        return callMinuteCost;
    }

    public double getMassageCost() {
        return massageCost;
    }

    public double getRecivedMBytesCost() {
        return recivedMBytesCost;
    }

    public double getSentMBytesCost() {
        return sentMBytesCost;
    }

    public void setCallCost(double callCost) {
        this.callCost = callCost;
    }

    public void setCallMinuteCost(double callMinuteCost) {
        this.callMinuteCost = callMinuteCost;
    }

    public void setMassageCost(double massageCost) {
        this.massageCost = massageCost;
    }

    public void setRecivedMBytesCost(double recivedMBytesCost) {
        this.recivedMBytesCost = recivedMBytesCost;
    }

    public void setSentMBytesCost(double sentMBytesCost) {
        this.sentMBytesCost = sentMBytesCost;
    }
}
