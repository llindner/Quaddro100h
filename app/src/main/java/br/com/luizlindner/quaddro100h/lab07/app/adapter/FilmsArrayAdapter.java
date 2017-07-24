package br.com.luizlindner.quaddro100h.lab07.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Film;

/**
 * Created by Luiz on 23/07/2017.
 */

public class FilmsArrayAdapter extends ArrayAdapter<Film> {

    private Context context;
    private List<Film> films;

    public FilmsArrayAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public FilmsArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public FilmsArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Film[] objects) {
        super(context, resource, objects);
    }

    public FilmsArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Film[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public FilmsArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Film> objects) {
        super(context, resource, objects);
        this.context = context;
        this.films = objects;
    }

    public FilmsArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Film> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        Film film = films.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.linha_filmes_view, null);

        TextView episodeIdView = (TextView) view.findViewById(R.id.linha_film_episodeId);
        TextView episodeNameView = (TextView) view.findViewById(R.id.linha_film_episodeName);
        Button b = (Button)view.findViewById(R.id.linha_film_btn);

        String[] year = film.getReleaseDate().split("-");
        String episodeName = film.getTitle() + " (" + year[0] + ")";
        episodeIdView.setText(film.getEpisodeId());
        episodeNameView.setText(episodeName);
        b.setTag(film);

        return view;
    }
}
