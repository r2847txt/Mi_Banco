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

        h_depositos = new ArrayList();
        adaptador1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, h_depositos);
        lv1 = findViewById(R.id.list1);
        lv1.setAdapter(adaptador1);

        deposito = findViewById(R.id.et_deposito);
        saldo = findViewById(R.id.tv_saldo);
        cuenta = (Cuenta) getIntent().getExtras().getSerializable("cuenta");
        saldo.setText("Tu saldo: $" + cuenta.getSaldo());

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                final int posicion = i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Operac_depositar.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Elimina este teléfono ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        h_depositos.remove(posicion);
                        adaptador1.notifyDataSetChanged();
                    }
                });

                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });
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