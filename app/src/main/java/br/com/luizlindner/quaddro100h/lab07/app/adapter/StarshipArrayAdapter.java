package br.com.luizlindner.quaddro100h.lab07.app.adapter;

import android.app.Activity;
import android.content.Context;
import android.nfc.Tag;
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
import br.com.luizlindner.quaddro100h.lab07.domain.model.Starship;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Vehicle;

/**
 * Created by Luiz on 23/07/2017.
 */

public class StarshipArrayAdapter extends ArrayAdapter<Starship> {

    private Context context;
    private List<Starship> starships;

    public StarshipArrayAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public StarshipArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public StarshipArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Starship[] objects) {
        super(context, resource, objects);
    }

    public StarshipArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Starship[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public StarshipArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Starship> objects) {
        super(context, resource, objects);
        this.context = context;
        this.starships = objects;
    }

    public StarshipArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Starship> objects) {
        super(context, resource, textViewResourceId, objects);
    }


    public View getView(int position, View convertView, ViewGroup parent){

        Starship starship = starships.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.linha_starship_view, null);

        TextView starshipNameView = (TextView) view.findViewById(R.id.linha_starship_name);
        Button b = (Button)view.findViewById(R.id.linha_starship_btn);

        starshipNameView.setText(starship.getName());
        b.setTag(starship);

        return view;
    }
}
