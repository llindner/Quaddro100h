package br.com.luizlindner.quaddro100h.lab14.app.controller;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;
import br.com.luizlindner.quaddro100h.lab14.design.pattern.LocationAdapter;

/**
 * Created by Mobile on 03/08/2017.
 */

public class GPSActivity extends QuaddroActivity {

    TextView latitudeView, longitudeView, enderecoView;
    String provedor;
    LocationManager lm;
    LocationAdapter la;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gps_view);
        latitudeView = getViewById(R.id.lab14_latitude);
        longitudeView = getViewById(R.id.lab14_longitude);
        enderecoView = getViewById(R.id.lab14_endereco);

        lm = (LocationManager) getSystemService(LOCATION_SERVICE);

        la = new LocationAdapter() {
            @Override
            public void onLocationChanged(Location location) {
                super.onLocationChanged(location);
                localizar(location);
            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 1000);

            return;
        }

        Criteria c = new Criteria();
        provedor = lm.getBestProvider(c, false);
        lm.requestLocationUpdates(provedor, 5000, 0, la);
    }

    private void localizar(Location location) {
        if (location != null) {
            double latitude, longitude;

            latitude = location.getLatitude();
            longitude = location.getLongitude();
            latitudeView.setText("Latitude: " + latitude);
            longitudeView.setText("Longitude: " + longitude);

            //TODO Pegar o endereço
            Geocoder gc = new Geocoder(this);
            try {
                gc.getFromLocation(latitude, longitude, 1);
                List<Address> list = gc.getFromLocation(latitude, longitude, 1);
                Address a = list.get(0);

                enderecoView.setText(String.format(Locale.getDefault(), "%s, %s, %s, %s, %s", a.getThoroughfare(), a.getSubThoroughfare(), a.getSubLocality(), a.getLocality(), a.getCountryName()));
            } catch (IOException e) {
                Log.e(TIPO_DE_LOG, "Ops...", e);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 2000);

            return;
        }
        localizar(lm.getLastKnownLocation(provedor));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        try {
            boolean ok = false;
            for (int i : grantResults){
                if(i != PackageManager.PERMISSION_GRANTED){
                    ok = false;
                    break;
                }else{
                    ok = true;
                }
            }
            if(!ok){
                Toast.makeText(this, "Você não tem permissão", Toast.LENGTH_LONG).show();
                return;
            }

            Criteria c = new Criteria();
            provedor = lm.getBestProvider(c, false);
            switch (requestCode) {
                case 1000:
                    lm.requestLocationUpdates(provedor, 5000, 0, la);
                    break;
                case 2000:
                    localizar(lm.getLastKnownLocation(provedor));
                    break;
            }
        } catch (SecurityException se) {
            Log.e(TIPO_DE_LOG, "Ops...", se);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        lm.removeUpdates(la);
    }
}
