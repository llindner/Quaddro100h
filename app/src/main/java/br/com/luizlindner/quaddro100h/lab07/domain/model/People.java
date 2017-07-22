package br.com.luizlindner.quaddro100h.lab07.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luiz on 21/07/2017.
 */

public class People implements Serializable {
    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private Planet homeworld;

    private List<Film> films;
    private List<Specie> species;
    private List<Vehicle> vehicles;
    private List<Starship> starships;

    private People() {
        super();
        this.homeworld = Planet.getInstance();
        this.films = new ArrayList<Film>();
        this.species = new ArrayList<Specie>();
        this.vehicles = new ArrayList<Vehicle>();
        this.starships = new ArrayList<Starship>();
    }

    public static People getInstance(){
        return new People();
    }

    public static People of(String name, String height, String mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, Planet homeworld, List<Film> films, List<Specie> species, List<Vehicle> vehicles, List<Starship> starships){
        People p = People.getInstance();
        p.setName(name);
        p.setHeight(height);
        p.setMass(mass);
        p.setHairColor(hairColor);
        p.setSkinColor(skinColor);
        p.setEyeColor(eyeColor);
        p.setBirthYear(birthYear);
        p.setGender(gender);
        p.setHomeworld(homeworld);
        p.setFilms(films);
        p.setSpecies(species);
        p.setVehicles(vehicles);
        p.setStarships(starships);
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Planet getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(Planet homeworld) {
        this.homeworld = homeworld;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public List<Specie> getSpecies() {
        return species;
    }

    public void setSpecies(List<Specie> species) {
        this.species = species;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Starship> getStarships() {
        return starships;
    }

    public void setStarships(List<Starship> starships) {
        this.starships = starships;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", hairColor='" + hairColor + '\'' +
                ", skinColor='" + skinColor + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld=" + homeworld +
                ", films=" + films +
                ", species=" + species +
                ", vehicles=" + vehicles +
                ", starships=" + starships +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        People people = (People) o;

        if (getName() != null ? !getName().equals(people.getName()) : people.getName() != null)
            return false;
        if (getHeight() != null ? !getHeight().equals(people.getHeight()) : people.getHeight() != null)
            return false;
        if (getMass() != null ? !getMass().equals(people.getMass()) : people.getMass() != null)
            return false;
        if (getHairColor() != null ? !getHairColor().equals(people.getHairColor()) : people.getHairColor() != null)
            return false;
        if (getSkinColor() != null ? !getSkinColor().equals(people.getSkinColor()) : people.getSkinColor() != null)
            return false;
        if (getEyeColor() != null ? !getEyeColor().equals(people.getEyeColor()) : people.getEyeColor() != null)
            return false;
        if (getBirthYear() != null ? !getBirthYear().equals(people.getBirthYear()) : people.getBirthYear() != null)
            return false;
        if (getGender() != null ? !getGender().equals(people.getGender()) : people.getGender() != null)
            return false;
        if (getHomeworld() != null ? !getHomeworld().equals(people.getHomeworld()) : people.getHomeworld() != null)
            return false;
        if (getFilms() != null ? !getFilms().equals(people.getFilms()) : people.getFilms() != null)
            return false;
        if (getSpecies() != null ? !getSpecies().equals(people.getSpecies()) : people.getSpecies() != null)
            return false;
        if (getVehicles() != null ? !getVehicles().equals(people.getVehicles()) : people.getVehicles() != null)
            return false;
        return getStarships() != null ? getStarships().equals(people.getStarships()) : people.getStarships() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getHeight() != null ? getHeight().hashCode() : 0);
        result = 31 * result + (getMass() != null ? getMass().hashCode() : 0);
        result = 31 * result + (getHairColor() != null ? getHairColor().hashCode() : 0);
        result = 31 * result + (getSkinColor() != null ? getSkinColor().hashCode() : 0);
        result = 31 * result + (getEyeColor() != null ? getEyeColor().hashCode() : 0);
        result = 31 * result + (getBirthYear() != null ? getBirthYear().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getHomeworld() != null ? getHomeworld().hashCode() : 0);
        result = 31 * result + (getFilms() != null ? getFilms().hashCode() : 0);
        result = 31 * result + (getSpecies() != null ? getSpecies().hashCode() : 0);
        result = 31 * result + (getVehicles() != null ? getVehicles().hashCode() : 0);
        result = 31 * result + (getStarships() != null ? getStarships().hashCode() : 0);
        return result;
    }
}
