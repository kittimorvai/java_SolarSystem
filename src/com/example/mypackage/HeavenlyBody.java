package com.example.mypackage;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody{
    private final String name;
    private final double orbitalPeriod;
    private final BodyTypes bodyType;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        STAR,
        PLANET,
        MOON,
        ASTEROID
    }


    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public BodyTypes getBodyType() {
        return bodyType;
    }

    //adding a moon to a planet, and only to a planet
    public boolean addMoon (HeavenlyBody moon){
        if(this.bodyType.equals(BodyTypes.PLANET) && moon.getBodyType().equals(BodyTypes.MOON)){
            return this.satellites.add(moon);
        } else {
            System.out.println("You are trying to add a heavenly body to a planet that is not a moon. Try again.");
            return false;
        }
    }

    //adding any kind of heavenly body to another heavenly body, except to a planet as planets can only have moons
    public boolean addBody (HeavenlyBody body){
        if(!(this.bodyType.equals(BodyTypes.PLANET))){
            return this.satellites.add(body);
        } else {
            System.out.println("You are either trying to add a star or asteroid to a planet or your are using a wrong type fo heavenly body.");
            return false;
        }
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        if(this.name.equals(objName) && this.bodyType != ((HeavenlyBody) obj).getBodyType()){             //two bodies can be added to the set with the same name if their bodyType is different
            return false;
        }
        return true;

    }

    @Override
    public final int hashCode() {
        return this.name.hashCode() + 12 + this.bodyType.hashCode();
    }

    @Override
    public String toString() {
        return this.name + " " + this.orbitalPeriod + " " + this.bodyType;
    }
}
