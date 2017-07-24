package br.com.luizlindner.quaddro100h.lab07.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luiz on 21/07/2017.
 */

public class People implements Serializable {
    private String _id;
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

    public static People of(String _id, String name, String height, String mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, Planet homeworld, List<Film> films, List<Specie> species, List<Vehicle> vehicles, List<Starship> starships){
        People p = People.getInstance();
        p.set_id(_id);
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

    public static People of(String _id, String name, String height, String mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, Planet homeworld){
        People p = People.getInstance();
        p.set_id(_id);
        p.setName(name);
        p.setHeight(height);
        p.setMass(mass);
        p.setHairColor(hairColor);
        p.setSkinColor(skinColor);
        p.setEyeColor(eyeColor);
        p.setBirthYear(birthYear);
        p.setGender(gender);
        p.setHomeworld(homeworld);
        return p;
    }

    public static People of(String _id, String name, String height, String mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender){
        People p = People.getInstance();
        p.set_id(_id);
        p.setName(name);
        p.setHeight(height);
        p.setMass(mass);
        p.setHairColor(hairColor);
        p.setSkinColor(skinColor);
        p.setEyeColor(eyeColor);
        p.setBirthYear(birthYear);
        p.setGender(gender);
        return p;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
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

        if (_id != null ? !_id.equals(people._id) : people._id != null) return false;
        if (name != null ? !name.equals(people.name) : people.name != null) return false;
        if (height != null ? !height.equals(people.height) : people.height != null) return false;
        if (mass != null ? !mass.equals(people.mass) : people.mass != null) return false;
        if (hairColor != null ? !hairColor.equals(people.hairColor) : people.hairColor != null)
            return false;
        if (skinColor != null ? !skinColor.equals(people.skinColor) : people.skinColor != null)
            return false;
        if (eyeColor != null ? !eyeColor.equals(people.eyeColor) : people.eyeColor != null)
            return false;
        if (birthYear != null ? !birthYear.equals(people.birthYear) : people.birthYear != null)
            return false;
        if (gender != null ? !gender.equals(people.gender) : people.gender != null) return false;
        if (homeworld != null ? !homeworld.equals(people.homeworld) : people.homeworld != null)
            return false;
        if (films != null ? !films.equals(people.films) : people.films != null) return false;
        if (species != null ? !species.equals(people.species) : people.species != null)
            return false;
        if (vehicles != null ? !vehicles.equals(people.vehicles) : people.vehicles != null)
            return false;
        return starships != null ? starships.equals(people.starships) : people.starships == null;

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (mass != null ? mass.hashCode() : 0);
        result = 31 * result + (hairColor != null ? hairColor.hashCode() : 0);
        result = 31 * result + (skinColor != null ? skinColor.hashCode() : 0);
        result = 31 * result + (eyeColor != null ? eyeColor.hashCode() : 0);
        result = 31 * result + (birthYear != null ? birthYear.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (homeworld != null ? homeworld.hashCode() : 0);
        result = 31 * result + (films != null ? films.hashCode() : 0);
        result = 31 * result + (species != null ? species.hashCode() : 0);
        result = 31 * result + (vehicles != null ? vehicles.hashCode() : 0);
        result = 31 * result + (starships != null ? starships.hashCode() : 0);
        return result;
    }
}
