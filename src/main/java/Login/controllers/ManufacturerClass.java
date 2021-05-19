package Login.controllers;

import Accessories_Details_Controllers.Item;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ManufacturerClass {

    private String ID;
    private String username;
    private String password;

    public ArrayList<Item> ite = new ArrayList<>();
    public ArrayList<Item> iteOrdered = new ArrayList<>();
    public ArrayList<Item> itemAcceptReject = new ArrayList<>();


    /*public ManufacturerClass ma;

    public ManufacturerClass(ManufacturerClass m)
    {
        this.ma = m;

    }*/

    public ManufacturerClass(String ID, String username, String password)
    {
        this.ID = ID;
        this.username = username;
        this.password = password;
    }

    public boolean equals(Object o)
    {

        if((o instanceof ManufacturerClass) && ((ManufacturerClass)o).username.equals(username))
        {
            return true;
        }
            return false;

    }

    public  String getUser()
    {
        return this.username;
    }

    public String getPass()
    {
        return this.password;
    }

    public String getID()
    {
        return this.ID;
    }

    /*public String toString()
    {
        String s = "";
        return s + "ID : " + ID + "  username : "  + username + " ";

    }*/

    public ManufacturerClass retObj()
    {
        return this;
    }

    /*public void deleteFromArray(ObservableList<Item> i)
    {
        for(int j = 0; j < ite.size(); j++)
        {
            if(i.equals(ite.get(j)))
                ite.remove(ite.get(j));
        }

    }*/


    public Object searchForItembyID(String s)
    {
        for(int j = 0; j < ite.size(); j++)
        {
            if(s.equals(ite.get(j).getID()))
                return ite.get(j);

        }
        return null;
    }
}
