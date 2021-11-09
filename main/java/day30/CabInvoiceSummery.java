package day30;

public class CabInvoiceSummery {
    public double totalFare;
    public int noOFRides;
    public double averageFarePerRide;

    public CabInvoiceSummery(double totalFare, int noOFRides, double averageFarePerRide) {
        this.totalFare=totalFare;
        this.noOFRides=noOFRides;
        this.averageFarePerRide=averageFarePerRide;
    }
}
