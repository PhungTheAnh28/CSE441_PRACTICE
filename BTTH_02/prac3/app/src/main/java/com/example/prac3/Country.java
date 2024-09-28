package com.example.prac3;

public class Country {
    private String name;
    private String capital;
    private int flagResource;
    private int population;
    private int area;
    private int density;

    public Country(String name, String capital, int flagResource, int population, int area) {
        this.name = name;
        this.capital = capital;
        this.flagResource = flagResource;
        this.population = population;
        this.area = area;
        this.density = population / area;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getFlagResource() {
        return flagResource;
    }

    public int getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }

    public int getDensity() {
        return density;
    }
}