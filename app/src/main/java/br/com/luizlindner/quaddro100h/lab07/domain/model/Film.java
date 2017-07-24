package br.com.luizlindner.quaddro100h.lab07.domain.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mobile on 21/07/2017.
 */

public class Film implements Serializable {
    private String _id;
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

    public static Film of(String _id, String title, String episodeId, String openinCrawl, String director, String producer, String releaseDate){
        Film f = Film.getInstance();
        f.set_id(_id);
        f.setTitle(title);
        f.setEpisodeId(episodeId);
        f.setOpeninCrawl(openinCrawl);
        f.setDirector(director);
        f.setProducer(producer);
        f.setReleaseDate(releaseDate);
        return f;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
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
                "_id='" + _id + '\'' +
                ", title='" + title + '\'' +
                ", episodeId='" + episodeId + '\'' +
                ", openinCrawl='" + openinCrawl + '\'' +
                ", director='" + director + '\'' +
                ", producer='" + producer + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (_id != null ? !_id.equals(film._id) : film._id != null) return false;
        if (title != null ? !title.equals(film.title) : film.title != null) return false;
        if (episodeId != null ? !episodeId.equals(film.episodeId) : film.episodeId != null)
            return false;
        if (openinCrawl != null ? !openinCrawl.equals(film.openinCrawl) : film.openinCrawl != null)
            return false;
        if (director != null ? !director.equals(film.director) : film.director != null)
            return false;
        if (producer != null ? !producer.equals(film.producer) : film.producer != null)
            return false;
        return releaseDate != null ? releaseDate.equals(film.releaseDate) : film.releaseDate == null;

    }

    @Override
    public int hashCode() {
        int result = _id != null ? _id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (episodeId != null ? episodeId.hashCode() : 0);
        result = 31 * result + (openinCrawl != null ? openinCrawl.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        return result;
    }
}
