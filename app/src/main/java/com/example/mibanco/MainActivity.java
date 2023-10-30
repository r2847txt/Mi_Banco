package com.example.mibanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        cargarPreferences();
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
                guardarPreferences();
                Intent i = new Intent(this, Operaciones.class);
                i.putExtra("cuenta", cuenta);
                startActivity(i);
            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception ex) {
            Toast.makeText(this, "Excepcion: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void guardarPreferences() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String rutx = rut.getText().toString();
        String nombresx = nombres.getText().toString();
        String apellidosx = apellidos.getText().toString();
        int saldox = Integer.parseInt(saldo.getText().toString());
        String numSecretox = pass1.getText().toString();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("rut", rutx);
        editor.putString("nombres", nombresx);
        editor.putString("apellidos", apellidosx);
        editor.putInt("saldo", saldox);
        editor.putString("numSecreto", numSecretox);
        editor.apply();
    }

    private void cargarPreferences() {
        SharedPreferences preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);

        String rutx = preferences.getString("rut","");
        String nombresx = preferences.getString("nombres", "");
        String apellidosx = preferences.getString("apellidos", "");
        int saldox = preferences.getInt("saldo", 0);
        String numSecretox = preferences.getString("numSecreto", "");

        nombres.setText(nombresx);
        apellidos.setText(apellidosx);
        rut.setText(rutx);
        pass1.setText(numSecretox);
        pass2.setText(numSecretox);
        saldo.setText(String.valueOf(saldox));
    }
}