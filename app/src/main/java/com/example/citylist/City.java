package com.example.citylist;

/**
 * This is a class for implement city and province name
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    /**
     * This is a constructor to set the city and province name
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * This is a getter function to get the city name
     * @return city
     */
    String getCityName(){
        return this.city;
    }

    /**
     * This is a getter function to get the province name
     * @return province
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compare Between cities
     */
    @Override
    public int compareTo(City city) {
        return this.city.compareTo(city.getCityName());
    }
}