package br.com.luizlindner.quaddro100h.lab11.app.controller;

import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.luizlindner.quaddro100h.R;
import br.com.luizlindner.quaddro100h.lab01.app.controller.QuaddroActivity;

/**
 * Created by Mobile on 01/08/2017.
 */

public class SensorActivity extends QuaddroActivity {

    SensorManager sm;
    List<Sensor> list;
    TextView detalhes;
    int idSensorSelecionado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_view);

        detalhes = getViewById(R.id.sensor_detalhe);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        list = sm.getSensorList(Sensor.TYPE_ALL);
        Log.i(TIPO_DE_LOG, "Sensores:" + list.toString());

        List<String> nomes = new ArrayList<>();
        for(Sensor i : list){
            nomes.add(i.getName());
        }

        Collections.sort(nomes);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nomes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner s = getViewById(R.id.sensor);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idSensorSelecionado = position;
                sm.unregisterListener(sensorEvent);
                sm.registerListener(sensorEvent, list.get(position), SensorManager.SENSOR_DELAY_FASTEST);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    private SensorEventListener sensorEvent = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            String msg = "Valores do sensor:\n";
            for(int i = 0; i < sensorEvent.values.length; i++){
                msg += "valor: [" + i + "] = " + sensorEvent.values[i] + "\n";
            }
            detalhes.setText(msg);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
            Toast.makeText(getApplicationContext(), "Mudou o valor da accuracy do sensor [" + sensor.getName() + "] = " + String.valueOf(i), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(sensorEvent, list.get(idSensorSelecionado), SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(sensorEvent);
    }
}
