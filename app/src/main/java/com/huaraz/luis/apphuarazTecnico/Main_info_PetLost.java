package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.huaraz.luis.apphuarazTecnico.Model.Pet;
import com.huaraz.luis.apphuarazTecnico.Servicio.APIService;
import com.huaraz.luis.apphuarazTecnico.Servicio.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main_info_PetLost extends AppCompatActivity {

    String name,photo,sex,information, informationLost,longitude,latitude,vaccinated,picture;
    int id , type,race,age, idLost;

    private TextView txvPetName, txvPetSex, txvPetType, txvPetRace, txvPetAge, txvPetVaccinated, txvPetLostInfo, txvPetInfo;
    private Button btnLastLocation;
    private FloatingActionButton fabAddSearch;
    private ImageView imgPetPhotopet;
    private APIService mAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_info__pet_lost);

        txvPetName = (TextView) findViewById(R.id.txvPetName);
        txvPetSex = (TextView) findViewById(R.id.txvPetSex);
        txvPetType = (TextView) findViewById(R.id.txvPetType);
        txvPetRace = (TextView) findViewById(R.id.txvPetRace);
        txvPetAge = (TextView) findViewById(R.id.txvPetAge);
        txvPetVaccinated = (TextView) findViewById(R.id.txvPetVaccinated);
        txvPetLostInfo = (TextView) findViewById(R.id.txvPetLostInfo);
        txvPetInfo = (TextView) findViewById(R.id.txvPetInfo);
        btnLastLocation = (Button) findViewById(R.id.btnlastLocation);
        fabAddSearch = (FloatingActionButton) findViewById(R.id.fabAddSearch);
        imgPetPhotopet = (ImageView) findViewById(R.id.petPhoto);

        //boton


        //Valor de llegada del detalle del pet
        Intent intent=getIntent();
        Bundle extras =intent.getExtras();

        idLost= (int)extras.get("idLost");
        id= (int) extras.get("id");
        photo= (String) extras.get("photo");
        name = (String)extras.get("name");
        sex = (String) extras.get("sex");
        type= (int) extras.get("type");
        race= (int) extras.get("race");
        age= (int) extras.get("age");
        vaccinated= (String) extras.get("vaccinated");
        information =(String)extras.get("information");
        informationLost=(String)extras.get("informationLost");
        longitude=(String)extras.get("longitude");
        latitude=(String)extras.get("latitude");
        picture=(String)extras.get("picture");
        ////////////////////////////////////////////
        //Agregar a mis busquedas
        fabAddSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddSearchPetLost(idLost,49);
            }
        });


        //////////////////////////////////
        btnLastLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMapLastLocation(name,longitude,latitude);

            }
        });
        //Seteado de valor de pets

        txvPetName.setText(name);
        txvPetSex.setText(sex);
        txvPetAge.setText(String.valueOf(age));
        String foto=picture;

        if(foto!=null){

            // Receiving side
            byte[] data1 = Base64.decode(foto, Base64.DEFAULT);
            String text1 = null;
            try {
                Bitmap bitmap = BitmapFactory.decodeByteArray(data1, 0, data1.length);
                imgPetPhotopet.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


        txvPetType.setText(String.valueOf(type));
        txvPetRace.setText(String.valueOf(race));


        if(type==1){
            txvPetType.setText("Perro");
        }else if (type==2){
            txvPetType.setText("Gato");

        }
        if(race==1){
            txvPetRace.setText("shitzu");
        }else if(race==2) {
            txvPetRace.setText("DOVERMAN");
        }else if(race==3) {
            txvPetRace.setText("DALMATA");
        }else if(race==4) {
            txvPetRace.setText("SIVERIANO");
        }else if(race==5) {
            txvPetRace.setText("BULL DOG");
        }else if(race==6) {
            txvPetRace.setText("SAN BERNARDO");
        }else if(race==7) {
            txvPetRace.setText("SAN BERNARDO");
        }else if(race==8) {
            txvPetRace.setText("CHINO");
        }else if(race==9) {
            txvPetRace.setText("PEQUINES");
        }else if(race==10) {
            txvPetRace.setText("PEQUINES");
        }else if(race==11) {
            txvPetRace.setText("ROFFWAILER");
        }else if(race==12) {
            txvPetRace.setText("BOXER");
        }else if(race==13) {
            txvPetRace.setText("persian");
        }


        txvPetVaccinated.setText(vaccinated);
        txvPetInfo.setText(information);
        txvPetLostInfo.setText(informationLost);
        //Image
        /*
        Picasso.with(this)
                .load("http://findmewebapp-eberttoribioupc.c9.io/system/pets/photos/000/000/0"+id+"/thumb/"+photo)
                .resize(120, 120)
                .into( imgPetPhoto);*/



    }
    private void goToMapLastLocation(String name, String longitude , String latitude) {
/*
        Intent intent = new Intent(this, MapsActivity3.class);
       intent.putExtra("name",name);
        intent.putExtra("longitude",longitude);
        intent.putExtra("latitude",latitude);
        startActivity(intent);

        */

    }
     public void AddSearchPetLost(int idPetLost, int id_user){
        String idPetlost= String.valueOf(idPetLost).trim();
        String id_userLost= String.valueOf(id_user).trim();


         mAPIService = ApiUtils.getAPIService();

         mAPIService.addPetLostSearch(idPetlost,id_userLost).enqueue(new Callback<Pet>() {
             @Override
             public void onResponse(Call<Pet> call, Response<Pet> response) {
                 if(response.isSuccessful()) {


                 }else{
                     int statusCode  = response.code();
                     Toast.makeText(getApplicationContext(), "Codigo de Error= " +statusCode,
                             Toast.LENGTH_LONG).show();
                 }
             }

             @Override
             public void onFailure(Call<Pet> call, Throwable t) {

             }
         });

     }
}
