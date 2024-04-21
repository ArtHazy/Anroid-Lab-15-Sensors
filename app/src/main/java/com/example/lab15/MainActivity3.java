package com.example.lab15;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity3 extends AppCompatActivity implements SensorEventListener {
    private ImageView HeaderImage;
    private float RotateDegree = 0f;
    private SensorManager mSensorManager;
    TextView CompOrient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        HeaderImage = (ImageView) findViewById(R.id.CompassView);
        CompOrient = (TextView) findViewById(R.id.Header);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_GAME);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {

        float degree = Math.round(event.values[0]);
        CompOrient.setText("Offset: " + Float.toString(degree) + "°");

        RotateAnimation rotateAnimation = new RotateAnimation(RotateDegree, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(200);
        rotateAnimation.setFillAfter(true);
        HeaderImage.startAnimation(rotateAnimation);
        RotateDegree = -degree;
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
