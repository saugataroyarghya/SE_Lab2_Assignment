package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testdelete(){
        CityList cityList = new CityList();
        City city = new City("Gazipur","Dhaka");
        City city1 = new City("Jessore","Khulna");
        cityList.add(city);
        cityList.add(city1);

        cityList.delete(city);
        assertTrue(!cityList.getCities().contains(city));
        assertEquals(1,cityList.getCities().size());
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city = new City("Jessore","Khulna");
        cityList.add(city);
        cityList.delete(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }
    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = new City("Jessore","Khulna");
        City city1 = new City("Gazipur","Dhaka");
        City city2 = new City("Tokyo","Kanto");

        cityList.add(city);
        cityList.add(city1);
        cityList.delete(city);
        assertEquals(1,cityList.count());
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    public void testSortCities() {
        CityList cityList = new CityList();
        City city = new City("ABB","LLM");
        City city1 = new City("CDDD","EFFF");
        cityList.add(city);
        cityList.add(city1);

        assertEquals(0,city.compareTo(cityList.sortCities(1).get(0)));
        assertEquals(0,city1.compareTo(cityList.sortCities(1).get(1)));
    }
}
