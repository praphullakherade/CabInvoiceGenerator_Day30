package day30;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class TestCaseForProject {
    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void testCalculateFare() {
        new CabInvoiceGenerator();
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double distance = 10;
        int time = 60;
        double getFare = CabInvoiceGenerator.calculateFare(distance, time);
        assertEquals(160, getFare);
    }

    @Test
    void testAgainCalculateFare() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double getFare = CabInvoiceGenerator.calculateFare(0, 2);
        assertEquals(5, getFare);
    }

    @Test
    void totalFareForMultipleRides() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        Ride[] rides = { new Ride(1.0, 20), new Ride(50, 52), new Ride(85, 100) };

        double totalFare = generator.calculateFare(rides);
        assertEquals(1532, totalFare);
    }

    @Test
    void EnhancedInvoice() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        Ride[] rides = { new Ride(1.0, 20), new Ride(50, 52), new Ride(85, 100) };

        CabInvoiceSummery invoiceSummery = generator.generateInvoiceForMultipleRides(rides);
        assertEquals(1532, invoiceSummery.totalFare);
        assertEquals(3, invoiceSummery.noOFRides);
        assertEquals(510, (int) invoiceSummery.averageFarePerRide);
    }

    @Test
    void InvoiceService() {
        CabInvoiceGenerator generator=new CabInvoiceGenerator();
        Map<Integer,CabInvoiceSummery> map= new HashMap<Integer, CabInvoiceSummery>();

        Ride[] rides = { new Ride(1.0, 20), new Ride(50, 52), new Ride(85, 100) };
        CabInvoiceSummery invoiceSummery = generator.generateInvoiceForMultipleRides(rides);
        map.put(1, invoiceSummery);

        CabInvoiceSummery invoiceSummery1 = generator.generateInvoiceForMultipleRides(rides);
        map.put(1, invoiceSummery1);

        CabInvoiceSummery invoiceSummery2 = generator.generateInvoiceForMultipleRides(rides);
        map.put(1, invoiceSummery2);
        CabInvoiceSummery invoiceSummery3=map.get(1);
        assertEquals(4596, invoiceSummery3.totalFare);
        assertEquals(3, invoiceSummery3.noOFRides);
        assertEquals(1532, (int)invoiceSummery3.averageFarePerRide);
    }

    @Test
    void calculateFareForRides() {
        CabInvoiceGenerator generator = new CabInvoiceGenerator();
        double distance = 10;
        int time = 60;
        double getFareForNormalRide = CabInvoiceGenerator.calculateFare(distance, time, "normal");
        assertEquals(160, getFareForNormalRide);
        double getFareForPremiumRide= CabInvoiceGenerator.calculateFare(distance, time, "premium");
        assertEquals(270, getFareForPremiumRide);
    }


}