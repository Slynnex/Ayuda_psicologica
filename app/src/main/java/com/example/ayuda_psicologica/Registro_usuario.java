package com.example.ayuda_psicologica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
public class Registro_usuario extends AppCompatActivity implements View.OnClickListener{

    Button regresar, registrar;
    EditText nombre, direccion, email, telefono, contra, estado, municipio;

    public void enviarDatosGet(String URL)
    {
        String ema = email.getText().toString();
        String nom = nombre.getText().toString();
        String ape = direccion.getText().toString();
        String tel = telefono.getText().toString();
        String con = contra.getText().toString();
        String est = estado.getText().toString();
        String mun = municipio.getText().toString();
        //String URL = "http://apagafire.herokuapp.com/index.php?nombre="+nombre.getText().toString()+"& apellido="+apellido.getText().toString()+"& email="+email.getText().toString()+"& telefono="+telefono.getText().toString()+"& contra="+contra.getText().toString();


        if(!nom.isEmpty() && !ape.isEmpty() && !tel.isEmpty() && !ema.isEmpty() && !con.isEmpty() && !est.isEmpty() && !mun.isEmpty())
        {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), "Operacion exitosa", Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> parametros=new HashMap<String, String>();
                    parametros.put("email",email.getText().toString());
                    parametros.put("nombre",nombre.getText().toString());
                    parametros.put("direccion",direccion.getText().toString());
                    parametros.put("telefono",telefono.getText().toString());
                    parametros.put("contra",contra.getText().toString());
                    parametros.put("estado",estado.getText().toString());
                    parametros.put("municipio",municipio.getText().toString());
                    return parametros;
                }
            };
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
        }
        else
        {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        nombre =findViewById(R.id.editNombre);
        direccion = findViewById(R.id.editDom);
        email = findViewById(R.id.editEmail);
        telefono = findViewById(R.id.editTel);
        contra = findViewById(R.id.editContra);
        estado = findViewById(R.id.editEsta);
        municipio = findViewById(R.id.editMun);

        regresar = findViewById(R.id.regresar);
        registrar = findViewById(R.id.registrar);
        regresar.setOnClickListener(this);
        registrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == regresar)
        {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else if(v == registrar)
        {
            enviarDatosGet("https://prepa2021.herokuapp.com/index.php");

            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
        }
    }
}