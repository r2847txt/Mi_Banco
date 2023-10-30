package com.example.mibanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Operaciones extends AppCompatActivity {
    Cuenta cuenta;
    TextView nombre, saldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones);
        nombre = findViewById(R.id.tv_nombre);
        saldo = findViewById(R.id.tv_saldo);
        // recibir el objeto desde Main u operacionessecundarias
        cuenta = (Cuenta) getIntent().getExtras().getSerializable("cuenta");
        nombre.setText("Hola " + cuenta.getNombres());
        saldo.setText("Tu saldo: $" + cuenta.getSaldo());
    }
    public void girar(View view) {
        try {
            Intent i = new Intent(this, Operac_girar.class);
            i.putExtra("cuenta", cuenta);
            startActivity(i);
        }catch (Exception ex) {
            Toast.makeText(this, "Excepcion " + ex.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void depositar(View view) {
        try {
            Intent i = new Intent(this, Operac_depositar.class);
            i.putExtra("cuenta", cuenta);
            startActivity(i);
        }catch (Exception ex) {
            Toast.makeText(this, "Excepcion " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void pagar(View view) {
        try {
            Intent i = new Intent(this, Operac_pagar.class);
            i.putExtra("cuenta", cuenta);
            startActivity(i);
        }catch (Exception ex) {
            Toast.makeText(this, "Excepcion " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}