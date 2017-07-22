package br.com.luizlindner.quaddro100h.lab07.domain.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mobile on 21/07/2017.
 */

public class Film implements Serializable {
    private String title;
    private String episodeId;
    private String openinCrawl;
    private String director;
    private String producer;
    private String releaseDate;

    private Film() {
        super();
    }

    public static Film getInstance(){
        return new Film();
    }

    public static Film of(String title, String episodeId, String openinCrawl, String director, String producer, String releaseDate){
        Film f = Film.getInstance();
        f.setTitle(title);
        f.setEpisodeId(episodeId);
        f.setOpeninCrawl(openinCrawl);
        f.setDirector(director);
        f.setProducer(producer);
        f.setReleaseDate(releaseDate);
        return f;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }

    public String getOpeninCrawl() {
        return openinCrawl;
    }

    public void setOpeninCrawl(String openinCrawl) {
        this.openinCrawl = openinCrawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", episodeId='" + episodeId + '\'' +
                ", openinCrawl='" + openinCrawl + '\'' +
                ", director='" + director + '\'' +
                ", producer='" + producer + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (getTitle() != null ? !getTitle().equals(film.getTitle()) : film.getTitle() != null)
            return false;
        if (getEpisodeId() != null ? !getEpisodeId().equals(film.getEpisodeId()) : film.getEpisodeId() != null)
            return false;
        if (getOpeninCrawl() != null ? !getOpeninCrawl().equals(film.getOpeninCrawl()) : film.getOpeninCrawl() != null)
            return false;
        if (getDirector() != null ? !getDirector().equals(film.getDirector()) : film.getDirector() != null)
            return false;
        if (getProducer() != null ? !getProducer().equals(film.getProducer()) : film.getProducer() != null)
            return false;
        return getReleaseDate() != null ? getReleaseDate().equals(film.getReleaseDate()) : film.getReleaseDate() == null;

    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getEpisodeId() != null ? getEpisodeId().hashCode() : 0);
        result = 31 * result + (getOpeninCrawl() != null ? getOpeninCrawl().hashCode() : 0);
        result = 31 * result + (getDirector() != null ? getDirector().hashCode() : 0);
        result = 31 * result + (getProducer() != null ? getProducer().hashCode() : 0);
        result = 31 * result + (getReleaseDate() != null ? getReleaseDate().hashCode() : 0);
        return result;
    }
}
