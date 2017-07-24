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
import br.com.luizlindner.quaddro100h.lab07.domain.model.Specie;
import br.com.luizlindner.quaddro100h.lab07.domain.model.Vehicle;

/**
 * Created by Luiz on 23/07/2017.
 */

public class VehiclesArrayAdapter extends ArrayAdapter<Vehicle> {

    private Context context;
    private List<Vehicle> vehicles;

    public VehiclesArrayAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public VehiclesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public VehiclesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull Vehicle[] objects) {
        super(context, resource, objects);
    }

    public VehiclesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull Vehicle[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public VehiclesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Vehicle> objects) {
        super(context, resource, objects);
        this.context = context;
        this.vehicles = objects;
    }

    public VehiclesArrayAdapter(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<Vehicle> objects) {
        super(context, resource, textViewResourceId, objects);
    }


    public View getView(int position, View convertView, ViewGroup parent){

        Vehicle vehicle = vehicles.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.linha_vehicles_view, null);

        TextView vehicleNameView = (TextView) view.findViewById(R.id.linha_vehicle_name);
        Button b = (Button)view.findViewById(R.id.linha_vehicle_btn);

        vehicleNameView.setText(vehicle.getName());
        b.setTag(vehicle);

        return view;
    }
}
