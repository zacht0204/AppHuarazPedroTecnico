package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class store_categoria extends AppCompatActivity {

    String Name ,Comida,Correas,Collares,Champus,Ropa ;
    Button champus,comida, ropa, accesorio;

    TextView numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_categoria);


        //Valor de llegada del detalle del pet
        Intent intent=getIntent();
        Bundle extras =intent.getExtras();

        Name= (String)extras.get("name");


        numero =(TextView)findViewById(R.id.numero);
        champus = (Button)findViewById(R.id.comida) ;
        comida = (Button)findViewById(R.id.ropa) ;
        ropa = (Button)findViewById(R.id.champu) ;
        accesorio = (Button)findViewById(R.id.accesorio) ;

        champus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in  = new Intent(getApplicationContext(),Tienda1.class);

                startActivity(in);
            }
        });

        comida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in  = new Intent(getApplicationContext(),Tienda2.class);

                startActivity(in);
            }
        });

        ropa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in  = new Intent(getApplicationContext(),Tienda3.class);

                startActivity(in);
            }
        });

        accesorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in  = new Intent(getApplicationContext(),Tienda4.class);

                startActivity(in);
            }
        });


        numero.setText("Nombre de la tienda:"+Name);

    }
}
