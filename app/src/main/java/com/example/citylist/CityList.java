package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * By default list is sorted according to city name
     * but if we want to sort list according to province then we use a logic
     * @param p = 1 or p!=1
     * @return
     *      (p = 1) -> Return the sorted list of cities according to name of cities
     *      (p != 0) -> Return the sorted list of cities according to name of province
     */
    public List<City> getCities(int p) {
        List<City> cityList = cities;
        if(p == 1)
        {
            Collections.sort(cityList);
        }
        else
        {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }
        return cityList;
    }

    /**
     * This is the method for if we want to delete a city from the CityList
     * if the city which we want to delete doesn't exist in the CityList than it throw an illegalArgumentException
     *      that means it doesn't exist.
     * On the other hand if it exists it simply delete the city from the CityList
     * @param city
     *      This is the city to delete
     */
    public void delete(City city)
    {
        if(!cities.contains(city))
            throw new IllegalArgumentException();
        else
            cities.remove(city);
    }

    /**
     * This counts number of cities we have in the CityList
     * @return
     *      Total number of the cities from the CityList
     */
    public int count()
    {
        return cities.size();
    }
}
