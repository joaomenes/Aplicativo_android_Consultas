package com.aplicativo.appdandelion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class home extends AppCompatActivity {

    private ImageView imageNutricao;
    private ImageView imageHolistica;
    private ImageView imageMusicoterapia;
    private ImageView imageFonoaudiologia;
    private ImageView imagePsicologia;
    private ImageView imagePsicopedagogia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageNutricao = findViewById(R.id.imageNutricao);
        imageNutricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), nutricao.class);
                startActivity(intent);
            }
        });
        imageHolistica = findViewById(R.id.imageHolistica);
        imageHolistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), holistica.class);
                startActivity(intent);
            }
        });
        imageMusicoterapia = findViewById(R.id.imageMusicoterapia);
        imageMusicoterapia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), musicoterapia.class);
                startActivity(intent);
            }
        });
        imageFonoaudiologia = findViewById(R.id.imageFonoaudiologia);
        imageFonoaudiologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), fonoaudiologia.class);
                startActivity(intent);
            }
        });
        imagePsicologia = findViewById(R.id.imagePsicologia);
        imagePsicologia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), psicologia.class);
                startActivity(intent);
            }
        });
        imagePsicopedagogia = findViewById(R.id.imagePsicopedagogia);
        imagePsicopedagogia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), psicopedagogia.class);
                startActivity(intent);
            }
        });


    }
}
