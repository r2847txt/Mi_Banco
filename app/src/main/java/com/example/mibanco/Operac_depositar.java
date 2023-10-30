package com.example.mibanco;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Operac_depositar extends AppCompatActivity {
    Cuenta cuenta;
    EditText deposito;
    TextView saldo;

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