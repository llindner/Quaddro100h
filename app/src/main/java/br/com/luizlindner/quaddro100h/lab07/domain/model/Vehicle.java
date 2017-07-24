package br.com.luizlindner.quaddro100h.lab07.domain.model;

import java.io.Serializable;

/**
 * Created by Mobile on 21/07/2017.
 */

public class Vehicle implements Serializable{
    private String _id;
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
    private String vehicleClass;

    private Vehicle() {
        super();
    }

    public static Vehicle getInstance(){
        return new Vehicle();
    }

    public static Vehicle of(String _id, String name, String model, String manufacturer, String costInCredits, String length, String maxAtmosphericSpeed, String crew, String passengers, String cargoCapacity, String consumables, String vehicleClass){
        Vehicle v = Vehicle.getInstance();
        v.set_id(_id);
        v.setName(name);
        v.setModel(model);
        v.setManufacturer(manufacturer);
        v.setCostInCredits(costInCredits);
        v.setLength(length);
        v.setMaxAtmosphericSpeed(maxAtmosphericSpeed);
        v.setCrew(crew);
        v.setPassengers(passengers);
        v.setCargoCapacity(cargoCapacity);
        v.setConsumables(consumables);
        v.setVehicleClass(vehicleClass);
        return v;
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

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", costInCredits='" + costInCredits + '\'' +
                ", length='" + length + '\'' +
                ", maxAtmosphericSpeed='" + maxAtmosphericSpeed + '\'' +
                ", crew='" + crew + '\'' +
                ", passengers='" + passengers + '\'' +
                ", cargoCapacity='" + cargoCapacity + '\'' +
                ", consumables='" + consumables + '\'' +
                ", vehicleClass='" + vehicleClass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (get_id() != null ? !get_id().equals(vehicle.get_id()) : vehicle.get_id() != null)
            return false;
        if (getName() != null ? !getName().equals(vehicle.getName()) : vehicle.getName() != null)
            return false;
        if (getModel() != null ? !getModel().equals(vehicle.getModel()) : vehicle.getModel() != null)
            return false;
        if (getManufacturer() != null ? !getManufacturer().equals(vehicle.getManufacturer()) : vehicle.getManufacturer() != null)
            return false;
        if (getCostInCredits() != null ? !getCostInCredits().equals(vehicle.getCostInCredits()) : vehicle.getCostInCredits() != null)
            return false;
        if (getLength() != null ? !getLength().equals(vehicle.getLength()) : vehicle.getLength() != null)
            return false;
        if (getMaxAtmosphericSpeed() != null ? !getMaxAtmosphericSpeed().equals(vehicle.getMaxAtmosphericSpeed()) : vehicle.getMaxAtmosphericSpeed() != null)
            return false;
        if (getCrew() != null ? !getCrew().equals(vehicle.getCrew()) : vehicle.getCrew() != null)
            return false;
        if (getPassengers() != null ? !getPassengers().equals(vehicle.getPassengers()) : vehicle.getPassengers() != null)
            return false;
        if (getCargoCapacity() != null ? !getCargoCapacity().equals(vehicle.getCargoCapacity()) : vehicle.getCargoCapacity() != null)
            return false;
        if (getConsumables() != null ? !getConsumables().equals(vehicle.getConsumables()) : vehicle.getConsumables() != null)
            return false;
        return getVehicleClass() != null ? getVehicleClass().equals(vehicle.getVehicleClass()) : vehicle.getVehicleClass() == null;

    }

    @Override
    public int hashCode() {
        int result = get_id() != null ? get_id().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        result = 31 * result + (getManufacturer() != null ? getManufacturer().hashCode() : 0);
        result = 31 * result + (getCostInCredits() != null ? getCostInCredits().hashCode() : 0);
        result = 31 * result + (getLength() != null ? getLength().hashCode() : 0);
        result = 31 * result + (getMaxAtmosphericSpeed() != null ? getMaxAtmosphericSpeed().hashCode() : 0);
        result = 31 * result + (getCrew() != null ? getCrew().hashCode() : 0);
        result = 31 * result + (getPassengers() != null ? getPassengers().hashCode() : 0);
        result = 31 * result + (getCargoCapacity() != null ? getCargoCapacity().hashCode() : 0);
        result = 31 * result + (getConsumables() != null ? getConsumables().hashCode() : 0);
        result = 31 * result + (getVehicleClass() != null ? getVehicleClass().hashCode() : 0);
        return result;
    }
}
