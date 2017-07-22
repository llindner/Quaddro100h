package br.com.luizlindner.quaddro100h.lab07.domain.model;

import java.io.Serializable;

/**
 * Created by Mobile on 21/07/2017.
 */

public class Planet implements Serializable{
    private String name;
    private String rotationPeriod;
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surfaceWater;
    private String population;

    private Planet() {
    }

    public static Planet getInstance(){
        return new Planet();
    }

    public static Planet of(String name, String rotationPeriod, String orbitalPeriod, String diameter, String climate, String gravity, String terrain, String surfaceWater, String population){
        Planet p = Planet.getInstance();
        p.setName(name);
        p.setRotationPeriod(rotationPeriod);
        p.setOrbitalPeriod(orbitalPeriod);
        p.setDiameter(diameter);
        p.setClimate(climate);
        p.setGravity(gravity);
        p.setTerrain(terrain);
        p.setSurfaceWater(surfaceWater);
        p.setPopulation(population);
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(String orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(String surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", rotationPeriod='" + rotationPeriod + '\'' +
                ", orbitalPeriod='" + orbitalPeriod + '\'' +
                ", diameter='" + diameter + '\'' +
                ", climate='" + climate + '\'' +
                ", gravity='" + gravity + '\'' +
                ", terrain='" + terrain + '\'' +
                ", surfaceWater='" + surfaceWater + '\'' +
                ", population='" + population + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Planet planet = (Planet) o;

        if (getName() != null ? !getName().equals(planet.getName()) : planet.getName() != null)
            return false;
        if (getRotationPeriod() != null ? !getRotationPeriod().equals(planet.getRotationPeriod()) : planet.getRotationPeriod() != null)
            return false;
        if (getOrbitalPeriod() != null ? !getOrbitalPeriod().equals(planet.getOrbitalPeriod()) : planet.getOrbitalPeriod() != null)
            return false;
        if (getDiameter() != null ? !getDiameter().equals(planet.getDiameter()) : planet.getDiameter() != null)
            return false;
        if (getClimate() != null ? !getClimate().equals(planet.getClimate()) : planet.getClimate() != null)
            return false;
        if (getGravity() != null ? !getGravity().equals(planet.getGravity()) : planet.getGravity() != null)
            return false;
        if (getTerrain() != null ? !getTerrain().equals(planet.getTerrain()) : planet.getTerrain() != null)
            return false;
        if (getSurfaceWater() != null ? !getSurfaceWater().equals(planet.getSurfaceWater()) : planet.getSurfaceWater() != null)
            return false;
        return getPopulation() != null ? getPopulation().equals(planet.getPopulation()) : planet.getPopulation() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getRotationPeriod() != null ? getRotationPeriod().hashCode() : 0);
        result = 31 * result + (getOrbitalPeriod() != null ? getOrbitalPeriod().hashCode() : 0);
        result = 31 * result + (getDiameter() != null ? getDiameter().hashCode() : 0);
        result = 31 * result + (getClimate() != null ? getClimate().hashCode() : 0);
        result = 31 * result + (getGravity() != null ? getGravity().hashCode() : 0);
        result = 31 * result + (getTerrain() != null ? getTerrain().hashCode() : 0);
        result = 31 * result + (getSurfaceWater() != null ? getSurfaceWater().hashCode() : 0);
        result = 31 * result + (getPopulation() != null ? getPopulation().hashCode() : 0);
        return result;
    }
}
