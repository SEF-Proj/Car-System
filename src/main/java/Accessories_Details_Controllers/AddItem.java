package Accessories_Details_Controllers;

import java.util.ArrayList;

public class AddItem {
    public static  ArrayList<Item> item = new ArrayList<>();

    public  boolean AddItem(Item i)
    {
        if(item.size() != 0)
        {
            for(int j = 0; j < item.size(); j++)
            {
                if(i.getID().equals(item.get(j).getID()))
                    return false;
            }
        }
        item.add(i);
        return true;
    }

    /*public void deleteFromArray(Item i)
    {
        for(int j = 0; j < item.size(); j++)
        {
            if(i.equals(item.get(j)))
                item.remove(item.get(j));
        }

    }*/

    /*public Object searchForItembyID(String s)
    {
        for(int j = 0; j < item.size(); j++)
        {
            if(s.equals(item.get(j).getID()))
                return item.get(j);

        }
        return null;
    }*/

}
