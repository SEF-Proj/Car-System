package Login.controllers;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccountVerificationTest {

    @Test
    void isInCustomerList() {

        ArrayList<CustomerClass> a = new ArrayList<>();
        a.add(new CustomerClass( "Andrei", "123"));
        a.add(new CustomerClass( "Maria", "124"));
        CustomerClass cus1 = new CustomerClass("Manu", "123");
        Assert.assertEquals(cus1.equals(a.get(1)), false);

    }

    @Test
    void isInManufacturerList() {

        ArrayList<ManufacturerClass> a = new ArrayList<>();
        a.add(new ManufacturerClass("2", "Opel", "123"));
        a.add(new ManufacturerClass("1", "Renault", "124"));
        ManufacturerClass man1 = new ManufacturerClass("1", "BMW", "123");
        Assert.assertNotEquals(man1.equals(a.get(1)), false);
    }
}