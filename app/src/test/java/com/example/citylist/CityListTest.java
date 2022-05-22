package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is a class for the tests where different types test performed with CityList
 */
public class CityListTest {

    /**
     * This is a method for creating a default or a new city and add it to the CityList
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * This returns a name of a city and province name which will add in the CityList through the function.
     * @return
     *      new City = city:"Edmonton, province:"AB'
     */
    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    /**
     * This is a method or function for add a city and check actually add or not
     */
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    /**
     * This is a method or function for delete a city and check actually delete or not
     */
    @Test
    public void testDelete()
    {
        CityList cityList = new CityList();
        City city1 = new City("Birampur", "Dinajpur");
        City city2 = new City("Motijheel", "Dhaka");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);

        assertTrue(!cityList.getCities(1).contains(city1));
    }

    /**
     * This is a method or function where we can confirm that the city we are just added, is actually deleted or not
     */
    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * This is a method or a function where it test or decide that which city we want to delete from the CityList is already exist or not, if not than it throw an illegalArgumentException
     */
    @Test
    public void testDeleteException()
    {
        CityList cityList = new CityList();
        City city1 = new City("Birampur", "Dinajpur");
        City city2 = new City("Motijheel", "Dhaka");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertEquals(1, cityList.count());
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });
    }

    /**
     This is a method or function where we add more cities to the CityList and compare them to each other and sort them according to city name or province name
     */
    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City city1 = new City("Fulbai", "Khulna");
        cityList.add(city1);
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));

        City city2 = new City("Charlottetown", "Prince");
        cityList.add(city2);
        assertEquals(0, city2.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(1)));
    }
}
