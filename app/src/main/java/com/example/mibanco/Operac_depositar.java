package com.example.mibanco;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Operac_depositar extends AppCompatActivity {
    Cuenta cuenta;
    EditText deposito;
    TextView saldo;

    private ArrayList h_depositos;
    private ArrayAdapter adaptador1;
    private ListView lv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operac_depositar);
        deposito = findViewById(R.id.et_deposito);
        saldo = findViewById(R.id.tv_saldo);
        cuenta = (Cuenta) getIntent().getExtras().getSerializable("cuenta");
        saldo.setText("Tu saldo: $" + cuenta.getSaldo());
    }

    public void realizar_deposito(View view) {
        try {
            if (cuenta.depositar(Integer.parseInt(deposito.getText().toString()))) {
                saldo.setText("Tu saldo: $" + cuenta.getSaldo());
                Toast.makeText(this, "Deposito realizado", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void verHistorialDeposito(View view) {
        try {
            Intent i = new Intent(this, Historial_depositos.class);
            i.putExtra("cuenta", cuenta);
            startActivity(i);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void volverDesdeDeposito(View view) {
        try {
            Intent i = new Intent(this, Operaciones.class);
            i.putExtra("cuenta", cuenta);
            startActivity(i);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}