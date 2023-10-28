package com.example.mibanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Operac_girar extends AppCompatActivity {
    Cuenta cuenta;
    EditText giro;
    TextView saldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operac_girar);
        cuenta = (Cuenta) getIntent().getExtras().getSerializable("cuenta");
        giro = findViewById(R.id.et_giro);
        saldo = findViewById(R.id.tv_saldo);
        saldo.setText("Tu saldo: $" + cuenta.getSaldo());
    }
    public void realizar_giro(View view) {
        try {
            if(cuenta.girar(Integer.parseInt(giro.getText().toString()))){
                Toast.makeText(this, "Giro realizado",
                        Toast.LENGTH_SHORT).show();
            }
        }catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void volverDesdeGiro(View view) {
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