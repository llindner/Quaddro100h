package br.com.luizlindner.quaddro100h.lab07.domain.model;

import java.io.Serializable;

/**
 * Created by Mobile on 21/07/2017.
 */

public class Starship implements Serializable {
    private String name;
    private String model;
    private String manufacturer;
    private String costInCredits;
    private String length;
    private String maxAtmosphericSpeed;
    private String crew;
    private String passengers;
    private String cargoCapacity;
    private String consumables;
    private String hyperdriveRating;
    private String mglt;
    private String starshipClass;

    private Starship() {
        super();
    }

    public static Starship getInstance(){
        return new Starship();
    }

    public static Starship of(String name, String model, String manufacturer, String costInCredits, String length, String maxAtmosphericSpeed, String crew, String passengers, String cargoCapacity, String consumables, String hyperdriveRating, String mglt, String starshipClass){
        Starship s = Starship.getInstance();
        s.setName(name);
        s.setModel(model);
        s.setManufacturer(manufacturer);
        s.setCostInCredits(costInCredits);
        s.setLength(length);
        s.setMaxAtmosphericSpeed(maxAtmosphericSpeed);
        s.setCrew(crew);
        s.setPassengers(passengers);
        s.setCargoCapacity(cargoCapacity);
        s.setConsumables(consumables);
        s.setHyperdriveRating(hyperdriveRating);
        s.setMglt(mglt);
        s.setStarshipClass(starshipClass);
        return s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMaxAtmosphericSpeed() {
        return maxAtmosphericSpeed;
    }

    public void setMaxAtmosphericSpeed(String maxAtmosphericSpeed) {
        this.maxAtmosphericSpeed = maxAtmosphericSpeed;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdriveRating() {
        return hyperdriveRating;
    }

    public void setHyperdriveRating(String hyperdriveRating) {
        this.hyperdriveRating = hyperdriveRating;
    }

    public String getMglt() {
        return mglt;
    }

    public void setMglt(String mglt) {
        this.mglt = mglt;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    @Override
    public String toString() {
        return "Starship{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", costInCredits='" + costInCredits + '\'' +
                ", length='" + length + '\'' +
                ", maxAtmosphericSpeed='" + maxAtmosphericSpeed + '\'' +
                ", crew='" + crew + '\'' +
                ", passengers='" + passengers + '\'' +
                ", cargoCapacity='" + cargoCapacity + '\'' +
                ", consumables='" + consumables + '\'' +
                ", hyperdriveRating='" + hyperdriveRating + '\'' +
                ", mglt='" + mglt + '\'' +
                ", starshipClass='" + starshipClass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Starship starship = (Starship) o;

        if (getName() != null ? !getName().equals(starship.getName()) : starship.getName() != null)
            return false;
        if (getModel() != null ? !getModel().equals(starship.getModel()) : starship.getModel() != null)
            return false;
        if (getManufacturer() != null ? !getManufacturer().equals(starship.getManufacturer()) : starship.getManufacturer() != null)
            return false;
        if (getCostInCredits() != null ? !getCostInCredits().equals(starship.getCostInCredits()) : starship.getCostInCredits() != null)
            return false;
        if (getLength() != null ? !getLength().equals(starship.getLength()) : starship.getLength() != null)
            return false;
        if (getMaxAtmosphericSpeed() != null ? !getMaxAtmosphericSpeed().equals(starship.getMaxAtmosphericSpeed()) : starship.getMaxAtmosphericSpeed() != null)
            return false;
        if (getCrew() != null ? !getCrew().equals(starship.getCrew()) : starship.getCrew() != null)
            return false;
        if (getPassengers() != null ? !getPassengers().equals(starship.getPassengers()) : starship.getPassengers() != null)
            return false;
        if (getCargoCapacity() != null ? !getCargoCapacity().equals(starship.getCargoCapacity()) : starship.getCargoCapacity() != null)
            return false;
        if (getConsumables() != null ? !getConsumables().equals(starship.getConsumables()) : starship.getConsumables() != null)
            return false;
        if (getHyperdriveRating() != null ? !getHyperdriveRating().equals(starship.getHyperdriveRating()) : starship.getHyperdriveRating() != null)
            return false;
        if (getMglt() != null ? !getMglt().equals(starship.getMglt()) : starship.getMglt() != null)
            return false;
        return getStarshipClass() != null ? getStarshipClass().equals(starship.getStarshipClass()) : starship.getStarshipClass() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getCostInCredits() != null ? getCostInCredits().hashCode() : 0);
        result = 31 * result + (getLength() != null ? getLength().hashCode() : 0);
        result = 31 * result + (getMaxAtmosphericSpeed() != null ? getMaxAtmosphericSpeed().hashCode() : 0);
        result = 31 * result + (getCrew() != null ? getCrew().hashCode() : 0);
        result = 31 * result + (getPassengers() != null ? getPassengers().hashCode() : 0);
        result = 31 * result + (getCargoCapacity() != null ? getCargoCapacity().hashCode() : 0);
        result = 31 * result + (getConsumables() != null ? getConsumables().hashCode() : 0);
        result = 31 * result + (getHyperdriveRating() != null ? getHyperdriveRating().hashCode() : 0);
        result = 31 * result + (getMglt() != null ? getMglt().hashCode() : 0);
        result = 31 * result + (getStarshipClass() != null ? getStarshipClass().hashCode() : 0);
        return result;
    }
}
