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
import br.com.luizlindner.quaddro100h.lab07.domain.model.Specie;

/**
 * Created by Luiz on 23/07/2017.
 */

public class SpeciesArrayAdapter extends ArrayAdapter<Specie> {

    private Context context;
    private List<Specie> species;

    public SpeciesArrayAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public SpeciesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public SpeciesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Specie[] objects) {
        super(context, resource, objects);
    }

    public SpeciesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Specie[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public SpeciesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Specie> objects) {
        super(context, resource, objects);
        this.context = context;
        this.species = objects;
    }

    public SpeciesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Specie> objects) {
        super(context, resource, textViewResourceId, objects);
    }


    public View getView(int position, View convertView, ViewGroup parent){

        Specie specie = species.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.linha_species_view, null);

        TextView specieNameView = (TextView) view.findViewById(R.id.linha_species_name);
        Button b = (Button)view.findViewById(R.id.linha_species_btn);

        specieNameView.setText(specie.getName());
        b.setTag(specie);

        return view;
    }
}
