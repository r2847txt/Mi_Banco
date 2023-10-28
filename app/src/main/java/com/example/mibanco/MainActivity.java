package com.example.mibanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombres, apellidos, rut, saldo, pass1, pass2;
    Cuenta cuenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombres = findViewById(R.id.et_nombres);
        apellidos = findViewById(R.id.et_apellidos);
        rut = findViewById(R.id.et_rut);
        pass1 = findViewById(R.id.et_pass1);
        pass2 = findViewById(R.id.et_pass2);
        saldo = findViewById(R.id.et_saldo);
    }
    public void crear(View view) {
        try {
            cuenta = new Cuenta();
            cuenta.setRut(rut.getText().toString());
            cuenta.setNombres(nombres.getText().toString());
            cuenta.setApellidos(apellidos.getText().toString());
            cuenta.setSaldo(Integer.parseInt(saldo.getText().toString()));
            cuenta.setNumSecreto(pass1.getText().toString());

            if(cuenta.validar()) {
                Intent i = new Intent(this, Operaciones.class);
                i.putExtra("cuenta", cuenta);
                startActivity(i);
                //Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            Toast.makeText(this, "Excepcion: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}