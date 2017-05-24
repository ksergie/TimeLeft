package com.example.android.timeleft;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float intSpeed;
    float intDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText left_Distance = (EditText)findViewById(R.id.leftDistance);
        final EditText current_Speed = (EditText)findViewById(R.id.currentSpeed);

        // This OnKeyListener takes a value EditText "Current Speed"
        current_Speed.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    intSpeed = Integer.parseInt(current_Speed.getText().toString());
                    calculate_time();
                    return true;
                }
                return false;
                }
            });

        // This OnKeyListener takes a value EditText "Left Distance"
        left_Distance.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                intDistance = Integer.parseInt(left_Distance.getText().toString());
                calculate_time();
                return true;
            }
            return false;
            }
        });
    }

    private void calculate_time() {
        // Calculate time = distance / speed
        // speed - in km/min
        float time = intDistance / (intSpeed / 60);
        int hour = (int) time / 60;
        int minutes = (int) time % 60;
        displayEstimatedTime(Integer.toString(hour), Integer.toString(minutes));
    }

    // Display a TextView "Estimated time"
    private void displayEstimatedTime(String hour, String minutes) {
        TextView estimate_time =(TextView) findViewById(R.id.estimatedTime);
        estimate_time.setText(hour + " hours " + minutes + " minutes");
    }

}
