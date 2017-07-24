package br.com.luizlindner.quaddro100h.lab07.domain.model;

import java.io.Serializable;

/**
 * Created by Mobile on 21/07/2017.
 */

public class Specie implements Serializable{
    private String _id;
    private String name;
    private String classification;
    private String designation;
    private String averageHeight;
    private String skinColors;
    private String hairColors;
    private String eyeColors;
    private String averageLifespan;
    private String homeWorld;
    private String language;

    private Specie() {
        super();
    }

    public static Specie getInstance(){
        return new Specie();
    }

    public static Specie of(String _id, String name, String classification, String designation, String averageHeight, String skinColors, String hairColors, String eyeColors, String averageLifespan, String language){
        Specie s = Specie.getInstance();
        s.set_id(_id);
        s.setName(name);
        s.setClassification(classification);
        s.setDesignation(designation);
        s.setAverageHeight(averageHeight);
        s.setSkinColors(skinColors);
        s.setHairColors(hairColors);
        s.setEyeColors(eyeColors);
        s.setAverageLifespan(averageLifespan);
        s.setLanguage(language);
        return s;
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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAverageHeight() {
        return averageHeight;
    }

    public void setAverageHeight(String averageHeight) {
        this.averageHeight = averageHeight;
    }

    public String getSkinColors() {
        return skinColors;
    }

    public void setSkinColors(String skinColors) {
        this.skinColors = skinColors;
    }

    public String getHairColors() {
        return hairColors;
    }

    public void setHairColors(String hairColors) {
        this.hairColors = hairColors;
    }

    public String getEyeColors() {
        return eyeColors;
    }

    public void setEyeColors(String eyeColors) {
        this.eyeColors = eyeColors;
    }

    public String getAverageLifespan() {
        return averageLifespan;
    }

    public void setAverageLifespan(String averageLifespan) {
        this.averageLifespan = averageLifespan;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public void setHomeWorld(String homeWorld) {
        this.homeWorld = homeWorld;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Specie{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", classification='" + classification + '\'' +
                ", designation='" + designation + '\'' +
                ", averageHeight='" + averageHeight + '\'' +
                ", skinColors='" + skinColors + '\'' +
                ", hairColors='" + hairColors + '\'' +
                ", eyeColors='" + eyeColors + '\'' +
                ", averageLifespan='" + averageLifespan + '\'' +
                ", homeWorld='" + homeWorld + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specie specie = (Specie) o;

        if (get_id() != null ? !get_id().equals(specie.get_id()) : specie.get_id() != null)
            return false;
        if (getName() != null ? !getName().equals(specie.getName()) : specie.getName() != null)
            return false;
        if (getClassification() != null ? !getClassification().equals(specie.getClassification()) : specie.getClassification() != null)
            return false;
        if (getDesignation() != null ? !getDesignation().equals(specie.getDesignation()) : specie.getDesignation() != null)
            return false;
        if (getAverageHeight() != null ? !getAverageHeight().equals(specie.getAverageHeight()) : specie.getAverageHeight() != null)
            return false;
        if (getSkinColors() != null ? !getSkinColors().equals(specie.getSkinColors()) : specie.getSkinColors() != null)
            return false;
        if (getHairColors() != null ? !getHairColors().equals(specie.getHairColors()) : specie.getHairColors() != null)
            return false;
        if (getEyeColors() != null ? !getEyeColors().equals(specie.getEyeColors()) : specie.getEyeColors() != null)
            return false;
        if (getAverageLifespan() != null ? !getAverageLifespan().equals(specie.getAverageLifespan()) : specie.getAverageLifespan() != null)
            return false;
        if (getHomeWorld() != null ? !getHomeWorld().equals(specie.getHomeWorld()) : specie.getHomeWorld() != null)
            return false;
        return getLanguage() != null ? getLanguage().equals(specie.getLanguage()) : specie.getLanguage() == null;

    }

    @Override
    public int hashCode() {
        int result = get_id() != null ? get_id().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getClassification() != null ? getClassification().hashCode() : 0);
        result = 31 * result + (getDesignation() != null ? getDesignation().hashCode() : 0);
        result = 31 * result + (getAverageHeight() != null ? getAverageHeight().hashCode() : 0);
        result = 31 * result + (getSkinColors() != null ? getSkinColors().hashCode() : 0);
        result = 31 * result + (getHairColors() != null ? getHairColors().hashCode() : 0);
        result = 31 * result + (getEyeColors() != null ? getEyeColors().hashCode() : 0);
        result = 31 * result + (getAverageLifespan() != null ? getAverageLifespan().hashCode() : 0);
        result = 31 * result + (getHomeWorld() != null ? getHomeWorld().hashCode() : 0);
        result = 31 * result + (getLanguage() != null ? getLanguage().hashCode() : 0);
        return result;
    }
}
