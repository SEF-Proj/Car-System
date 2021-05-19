package Login.controllers;

//import Accessories_Details_Controllers.CustomerController;
import Accessories_Details_Controllers.Item;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class CustomerClass {
    private String username;
    private String password;

    public ArrayList<Item> itemc = new ArrayList<>();
    public ArrayList<Item> itemOrdered = new ArrayList<>();
    //public  ArrayList<Item> itbyPrice = new ArrayList<>();


    public CustomerClass(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public boolean equals(Object o)
    {

        if((o instanceof CustomerClass) && ((CustomerClass)o).username.equals(username))
            return true;
        return false;

    }

    public  String getPass()
    {
        return this.password;
    }

    public  String getUser()
    {
        return this.username;
    }


    public Object searchForItembyCategory(String s, int j, int k)
    {
       // for(int j = 0; j < AccountVerification.arrayM.size(); j++)
        //{


           // for(int k = 0; k < AccountVerification.arrayM.get(j).ite.size(); k++){

                if(s.equals(AccountVerification.arrayM.get(j).ite.get(k).getCategory()))
                    return AccountVerification.arrayM.get(j).ite.get(k);

               // break;
            //}

       // }
        return null;

    }


    public Object searchForItembyPrice(String s, int j, int k)
    {
        if(s.equals(AccountVerification.arrayM.get(j).ite.get(k).getPrice()))
            return AccountVerification.arrayM.get(j).ite.get(k);
        return null;
    }

   public boolean AddITEM(Item i)
   {
       if(itemOrdered.size() > 0)
       {
           for(int j = 0; j < itemOrdered.size(); j++)
               if(i.equals(itemOrdered.get(j)))
                   return true;
       }
       return false;
   }

   public boolean Contain(ObservableList<Item> a)
   {
       for(int i = 0; i < itemc.size(); i++)
           if(a.contains(itemc.get(i)))
               return false;
           return true;
   }

}
