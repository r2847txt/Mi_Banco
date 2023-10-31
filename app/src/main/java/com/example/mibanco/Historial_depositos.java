package com.example.mibanco;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Historial_depositos extends AppCompatActivity{
    private ArrayList h_depositos;
    private ArrayAdapter adaptador1;
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operac_depositar);

        h_depositos = new ArrayList();
        adaptador1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, h_depositos);
        lv1 = findViewById(R.id.lv_hdepositos);
        lv1.setAdapter(adaptador1);

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                final int posicion = i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Historial_depositos.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("xxxxxxx");
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

    public void volverDesdeHistorialDeposito(View view) {
        try {
            Intent i = new Intent(this, Operac_depositar.class);
            startActivity(i);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
