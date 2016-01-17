/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataGenerator;

import entity.data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author bechw
 */
public class DataGenerator {

    String[] fNameList = {"bo", "Jan", "dan", "john", "jane", "sarah"};
    String[] lNameList = {"Lbo", "LJan", "Ldan", "Ljohn", "Ljane", "Lsarah"};
    String[] streetList = {"street1", "street2", "street3", "street4", "street5", "street6"};
    String[] cityArray = {"city1", "city2", "city3", "city4", "city5"};
    Random rand = new Random();

    public List<data> getData(int amount, String parameters) {
        List<data> dataList = new ArrayList();
        String[] paramLis = parameters.split(",");
        
        for (int i = 0; i < amount; i++) {
            data d = new data();
            for (String param : paramLis) {              
                if (param.equalsIgnoreCase("fname")) {
                    d.setFname(randFName());
                }
                if (param.equalsIgnoreCase("lname")) {
                    d.setLname(randLName());
                }
                if (param.equalsIgnoreCase("street")) {
                    d.setStreet(randStreet());
                }
                if (param.equalsIgnoreCase("city")) {
                    d.setCity(randCity());
                }
            }
            dataList.add(d);
        }
        return dataList;
    }

    public String randFName() {
        int num = rand.nextInt(fNameList.length);
        return fNameList[num];
    }

    public String randLName() {
        int num = rand.nextInt(lNameList.length);
        return lNameList[num];
    }

    public String randStreet() {
        int num = rand.nextInt(streetList.length);
        return streetList[num];
    }

    public String randCity() {
        int num = rand.nextInt(cityArray.length);
        return cityArray[num];
    }

}
