package com.aplicativo.appdandelion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class agendamento extends AppCompatActivity {

    CalendarView calendarView;
    TextView dataConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendamento);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        dataConsulta = (TextView) findViewById(R.id.dataConsulta);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int i, int i1, int i2) {
                String date =  (i1 + 1) + "/"  + i2 + "/" + i;
                dataConsulta.setText(date);
            }
        });


    }
}
