package com.example.mypackage;

public class Asteroid extends HeavenlyBody {
    public Asteroid(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.ASTEROID);
    }
}
