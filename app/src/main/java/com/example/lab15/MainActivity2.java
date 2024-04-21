package com.example.lab15;
import android.app.ListActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
public class MainActivity2 extends ListActivity {
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors =
                sensorManager.getSensorList(Sensor.TYPE_ALL);
        List<String> deviceSensorTypes = new ArrayList<>();
        for (int i = 0; i < deviceSensors.size(); i++) {
            deviceSensorTypes.add("Name: "+deviceSensors.get(i).getName()+"\nType: "+deviceSensors.get(i).getStringType());
        }
        setListAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, deviceSensorTypes));
        getListView().setTextFilterEnabled(true);
    }
}
