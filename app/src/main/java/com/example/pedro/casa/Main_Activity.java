package com.example.pedro.casa;

import android.app.Activity;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main_Activity extends Activity implements SensorEventListener {
    TextView tempData;
    TextView tempLabel;
    TextView centigrade;
    TextView humData;
    TextView humLabel;
    TextView percentage;
    TextView updateLabel;
    TextView updateData;
    TextView lumData;
    TextView lumLabel;
    TextView lux;

    Sensor s;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        lumData = (TextView) findViewById(R.id.dataLum);
        lumLabel = (TextView) findViewById(R.id.labelLum);
        lux = (TextView) findViewById(R.id.lux);


        tempData = (TextView) findViewById(R.id.dataTemp);
        tempLabel = (TextView) findViewById(R.id.labelTemp);
        centigrade = (TextView) findViewById(R.id.centigrade);

        humData = (TextView) findViewById(R.id.dataHum);
        humLabel = (TextView) findViewById(R.id.labelHum);
        percentage = (TextView) findViewById(R.id.percent);

        updateData = (TextView) findViewById(R.id.updateData);
        updateLabel = (TextView) findViewById(R.id.updateLabel);

        Typeface robotoThin = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Thin.ttf");
        Typeface robotoLight = Typeface.createFromAsset(getAssets(),"fonts/Roboto-Light.ttf");

        lumLabel.setTypeface(robotoThin);
        lumData.setTypeface(robotoLight);
        lux.setTypeface(robotoLight);

        tempLabel.setTypeface(robotoThin);
        tempData.setTypeface(robotoLight);
        centigrade.setTypeface(robotoLight);

        humLabel.setTypeface(robotoThin);
        humData.setTypeface(robotoLight);
        percentage.setTypeface(robotoLight);

        updateLabel.setTypeface(robotoThin);
        updateData.setTypeface(robotoLight);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        //Choosing Sensor Type
        s = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        //Activating The Sensor Listener
        sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);

        String currentTimeString = new SimpleDateFormat("HH:mm:ss").format(new Date());
        updateData.setText(currentTimeString);


    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent){

            lumData.setText(""+sensorEvent.values[0]);
            String currentTimeString = new SimpleDateFormat("HH:mm a").format(new Date());
            updateData.setText(currentTimeString);

        }



    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}
