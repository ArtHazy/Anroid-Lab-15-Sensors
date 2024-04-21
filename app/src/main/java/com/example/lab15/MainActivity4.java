package com.example.lab15;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity4 extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor mLight;
    TextView myText, textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        myText=findViewById(R.id.mytext);
        textView = findViewById(R.id.textView);
        sensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }
    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    @Override
    public final void onSensorChanged(SensorEvent event) {
        float lux = event.values[0];
        textView.setText("Lightness: " + Float.toString(lux));
        myText.append(Float.toString(lux)+"\n");
    }
    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, mLight,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
