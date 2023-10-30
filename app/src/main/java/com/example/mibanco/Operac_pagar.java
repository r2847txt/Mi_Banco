package com.example.mibanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Operac_pagar extends AppCompatActivity {
    Cuenta cuenta;
    EditText pago;
    TextView saldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operac_pagar);
        cuenta = (Cuenta) getIntent().getExtras().getSerializable("cuenta");
        pago = findViewById(R.id.et_pago);
        saldo = findViewById(R.id.tv_saldo);
        saldo.setText("Tu saldo: $" + cuenta.getSaldo());
    }
    public void realizar_pago(View view) {
        try {
            if(cuenta.girar(Integer.parseInt(pago.getText().toString()))){
                Toast.makeText(this, "Pago realizado",
                        Toast.LENGTH_SHORT).show();
            }
        }catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void verHistorialPago(View view) {
        try {
            Intent i = new Intent(this, Historial_pagos.class);
            startActivity(i);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void volverDesdePago(View view) {
        try {
            Intent i = new Intent(this, Operaciones.class);
            i.putExtra("cuenta", cuenta);
            startActivity(i);
        }catch (Exception ex) {
            Toast.makeText(this, "Excepcion " + ex.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }
}