/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Dao.AddressDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Michail Sitmalidis
 */
public class AddressController {

    AddressDao addressDao;

    public AddressController() {
        addressDao = new AddressDao();
    }

    public HashMap<String, ArrayList> getDistrictsList() {
        HashMap<String, ArrayList> districtsList = addressDao.getDistrictList();
    
     
        return districtsList;
    }

    public ArrayList<String> getPostalCodes(String district) {
        ArrayList<String> codesList = addressDao.getPostalCodesList(district);
        return codesList;
    }

}
