package com.SamuelGaultney;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
	// Sets cannot contain duplicates, that's the difference from Maps and Lists
        //has add, remove, clear, size, contains, and isEmpty
        //you can not get a certain element of a Set, you would have to iterate through
        //just like Maps, a Set cannot contain an element of itself
        //HashSet is the most performance, very similar to HashMap

        HeavenlyBody temp = new Planet("Mercury", 88);  //Creates an object
        solarSystem.put(temp.getKey(), temp); //adds to HashMap
        planets.add(temp);  //adds to Set

        temp = new Planet("Venus", 225);  //Creates an object
        solarSystem.put(temp.getKey(), temp); //adds to HashMap
        planets.add(temp);  //adds to Set

        temp = new Planet("Earth", 365);  //Creates an object
        solarSystem.put(temp.getKey(), temp); //adds to HashMap
        planets.add(temp);  //adds to Set

        HeavenlyBody tempMoon = new Moon("Moon", 27);  //Creates an object
        solarSystem.put(tempMoon.getKey(), tempMoon); //adds to HashMap
        temp.addSatellite(tempMoon);  // want tp add to Earth because it is a moon

        temp = new Planet("Mars", 687);  //Creates an object
        solarSystem.put(temp.getKey(), temp); //adds to HashMap
        planets.add(temp);  //adds to Set

        tempMoon = new Moon("Deimos", 1.3);  //Creates an object
        solarSystem.put(tempMoon.getKey(), tempMoon); //adds to HashMap
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos", 0.3);  //Creates an object
        solarSystem.put(tempMoon.getKey(), tempMoon); //adds to HashMap
        temp.addSatellite(tempMoon);

        temp = new Planet("Jupiter", 4332);  //Creates an object
        solarSystem.put(temp.getKey(), temp); //adds to HashMap
        planets.add(temp);  //adds to Set

        tempMoon = new Moon("Io", 1.8);  //Creates an object
        solarSystem.put(tempMoon.getKey(), tempMoon); //adds to HashMap
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Europa", 3.5);  //Creates an object
        solarSystem.put(tempMoon.getKey(), tempMoon); //adds to HashMap
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);  //Creates an object
        solarSystem.put(tempMoon.getKey(), tempMoon); //adds to HashMap
        temp.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);  //Creates an object
        solarSystem.put(tempMoon.getKey(), tempMoon); //adds to HashMap
        temp.addSatellite(tempMoon);

        temp = new Planet("Saturn", 10759);  //Creates an object
        solarSystem.put(temp.getKey(), temp); //adds to HashMap
        planets.add(temp);  //adds to Set

        temp = new Planet("Uranus", 30660);  //Creates an object
        solarSystem.put(temp.getKey(), temp); //adds to HashMap
        planets.add(temp);  //adds to Set

        temp = new Planet("Neptune", 165);  //Creates an object
        solarSystem.put(temp.getKey(), temp); //adds to HashMap
        planets.add(temp);  //adds to Set

        temp = new DwarfPlanet("Pluto", 248);  //Creates an object
        solarSystem.put(temp.getKey(), temp); //adds to HashMap
        planets.add(temp);  //adds to Set

        System.out.println("Planets");
        for(HeavenlyBody planet : planets) { //all objects from class Heavenlybody from field Planets
            System.out.println("\t" + planet.getKey()); // \t provides a tab
        }

        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET));  //change name here for other planets, was Jupiter
        System.out.println("Moon of " + body.getKey());
        for(HeavenlyBody jupiterMoon: body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getKey());  //temp is still jupiter at this point, so its moons
        }

        //Creating a Set Union with the addAll method of the Set to print all the moons. Advantage of a collection with
        //no duplicates
        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getKey());
        }

        //Sets do not compareEquals classes. Because of this, the below code will add another Pluto with a different
        //amount of days. It uses referential equality instead  (==), where if both objects point to the same place,
        //they are equal.
        //HeavenlyBody pluto = new HeavenlyBody("Pluto", 842, HeavenlyBody.BodyTypes.DWARF_PLANET);
        //above is another way to name types, but if HeavenlyBody is made Abstract, you must use the other method below
        HeavenlyBody pluto = new Planet("Pluto", 842);
        planets.add(pluto);

        for(HeavenlyBody planet : planets) {
            System.out.println(planet);
//            System.out.println(planet.getKey() + ": " + planet.getOrbitalPeriod());
        }

        //by overriding the hashcode, the second pluto is removed


        System.out.println();
        System.out.println("The Solar System Contains: ");
        for(HeavenlyBody heavenlyBody: solarSystem.values()) {
            System.out.println(heavenlyBody);
        }
    }
}
