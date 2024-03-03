package org.example.entities;

import java.util.Objects;

public class Bogie
{
    private String stationName;
    public Bogie(String stationName)
    {
        this.stationName = stationName;
    }    

    public String getStationName()
    {
        return stationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bogie bogie = (Bogie) o;
        return Objects.equals(stationName, bogie.stationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationName);
    }
}