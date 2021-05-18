package Login.controllers;

import Accessories_Details_Controllers.ManufacturerController;

import java.util.ArrayList;

public class AccountVerification {

    public static ArrayList<ManufacturerClass> arrayM = new ArrayList<>();
    public static ArrayList<CustomerClass> arrayC = new ArrayList<>();


    public boolean AddM(ManufacturerClass m) {
        if (arrayM.size() != 0) {

            for (int i = 0; i < arrayM.size(); i++) {
                if (m.equals(arrayM.get(i))) {
                    return false;
                }
            }
        }

            arrayM.add(m);



        return true;
    }

    public boolean AddC(CustomerClass c)
    {
        if (arrayC.size() != 0) {

            for (int i = 0; i < arrayC.size(); i++) {
                if (c.equals(arrayC.get(i))) {
                    return false;
                }
            }
        }

            arrayC.add(c);
        return true;

    }


    public int isInCustomerList(CustomerClass c)
    {
        for(int i = 0; i < arrayC.size(); i++)

        {

            if(c.getUser().equals(arrayC.get(i).getUser()) && c.getPass().equals(arrayC.get(i).getPass()))
            {
                return i;
            }
        }
        return -1;
    }


    public int isInManufacturerList(ManufacturerClass m)
    {
        for(int i = 0; i < arrayM.size(); i++)
            if(m.getUser().equals(arrayM.get(i).getUser()) && m.getPass().equals(arrayM.get(i).getPass()) && m.getID().equals(arrayM.get(i).getID()))
            {

                return i;
            }
        return -1;
    }


}
