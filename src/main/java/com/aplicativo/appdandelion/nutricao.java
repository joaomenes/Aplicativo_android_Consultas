package com.aplicativo.appdandelion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class nutricao extends AppCompatActivity implements View.OnClickListener {

    Button  buttonPresencial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutricao);

        buttonPresencial = (Button) findViewById(R.id.buttonPresencial);

        buttonPresencial.setOnClickListener(this);
    }

        public void onClick (View view){
    Intent tela = new Intent(this, agendamento.class);
    startActivity(tela);
    }
}
