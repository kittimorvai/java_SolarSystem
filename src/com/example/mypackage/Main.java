package com.example.mypackage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String,HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

        public static void main(String[] args) {
            HeavenlyBody temp = new Planet("Mercury", 88);
            solarSystem.put(temp.getName(), temp);
            planets.add(temp);

            temp = new Planet("Venus", 225);
            solarSystem.put(temp.getName(), temp);
            planets.add(temp);

            temp = new Planet("Earth", 365);
            solarSystem.put(temp.getName(), temp);
            planets.add(temp);

            HeavenlyBody tempMoon = new Moon("Moon", 27);
            solarSystem.put(tempMoon.getName(), tempMoon);
            temp.addMoon(tempMoon);

            temp = new Planet("Mars", 687);
            solarSystem.put(temp.getName(), temp);
            planets.add(temp);

            HeavenlyBody tempStar = new Star("RandomStar", 456);
            solarSystem.put(tempStar.getName(), tempStar);

            HeavenlyBody tempAsteroid = new Asteroid("RandomStar", 12);
            solarSystem.put(tempAsteroid.getName(), tempAsteroid);

            tempMoon = new Moon("RandomMoon", 23);
            solarSystem.put(tempMoon.getName(), tempMoon);
            tempMoon.addBody(tempAsteroid);
            tempMoon.addBody(tempStar);

            tempMoon = new Moon("Deimos", 1.3);
            solarSystem.put(tempMoon.getName(), tempMoon);
            temp.addMoon(tempMoon);

            tempMoon = new Moon("Phobos", 0.3);
            solarSystem.put(tempMoon.getName(), tempMoon);
            temp.addMoon(tempMoon);

            temp = new Planet("Jupiter", 4332);
            solarSystem.put(temp.getName(), temp);
            planets.add(temp);

            tempMoon = new Moon("Io", 1.8);
            solarSystem.put(tempMoon.getName(), tempMoon);
            temp.addMoon(tempMoon);

            tempMoon = new Moon("Europa", 3.5);
            solarSystem.put(tempMoon.getName(), tempMoon);
            temp.addMoon(tempMoon);

            temp = new Planet("Saturn", 10759);
            solarSystem.put(temp.getName(), temp);
            planets.add(temp);

            temp = new Planet("Uranus", 30660);
            solarSystem.put(temp.getName(), temp);
            planets.add(temp);

            temp = new Planet("Neptune", 165);
            solarSystem.put(temp.getName(), temp);
            planets.add(temp);

            temp = new Planet("Pluto", 248);
            solarSystem.put(temp.getName(), temp);
            planets.add(temp);

            temp = new Planet("Mars", 12);
            solarSystem.put(temp.getName(), temp);

            for (String objectName : solarSystem.keySet()) {
                System.out.println(objectName + " " + solarSystem.get(objectName).getOrbitalPeriod());
            }

            HeavenlyBody body = solarSystem.get("Mars");
            System.out.println("Moons of " + body.getName());
            for(HeavenlyBody marsMoon: body.getSatellites()) {
                System.out.println("\t" + marsMoon.getName());
            }

            body = solarSystem.get("RandomMoon");
            System.out.println("Satellites of " + body.getName());
            for (HeavenlyBody satellite : body.getSatellites()){
                System.out.println("\t" + satellite.getName() + " " + satellite.getBodyType());
            }

            Set<HeavenlyBody> moons = new HashSet<>();
            for(HeavenlyBody planet : planets) {
                moons.addAll(planet.getSatellites());
            }

            System.out.println("All Moons");
            for(HeavenlyBody moon : moons) {
                System.out.println("\t" + moon.getName());
            }


            HeavenlyBody pluto = new HeavenlyBody("Pluto", 842, HeavenlyBody.BodyTypes.PLANET);
            planets.add(pluto);






        }
    }
