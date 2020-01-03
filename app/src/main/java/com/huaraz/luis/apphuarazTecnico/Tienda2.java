package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tienda2 extends AppCompatActivity {

    Button comprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda2);

        comprar =(Button)findViewById(R.id.comprar);

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in  = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(in);
                Toast.makeText(getApplicationContext(), "Se envio el pedido realizado a su correo, para su confirmacion",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
