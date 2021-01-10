package com.example.ayuda_psicologica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button entrar, reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entrar = findViewById(R.id.login);
        reg = findViewById(R.id.reg);
        entrar.setOnClickListener(this);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == entrar)
        {
            Intent intent = new Intent(this, Registro_usuario.class);
            startActivity(intent);
        }
        else if(v == reg)
        {
            Intent intent1 = new Intent(this, Registro_usuario.class);
            startActivity(intent1);
        }

    }
}