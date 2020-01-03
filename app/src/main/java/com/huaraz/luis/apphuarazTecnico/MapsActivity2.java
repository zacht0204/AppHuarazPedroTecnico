package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/*
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.huaraz.luis.apphuaraz.Model.Pet;
import com.huaraz.luis.apphuaraz.Model.PetLost;
import com.huaraz.luis.apphuaraz.Servicio.APIService;
import com.huaraz.luis.apphuaraz.Servicio.ApiUtils;
*/
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/*
public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    //Valor de llegada de valores para registro
    String name,photo,sex,information, createdAt,updated_at,photo_content_type,photo_updated_at,vaccinated,State,informacion,picture;
    int id , type,race,age,userId,photo_file_size;


    ////
    private APIService mAPIService;


    private GoogleMap mMap;
    double log=0.0 ,lat=0.0;
    private Toolbar toolbar;
    Button perdido;

   public Double latitud= 0.0;
   public Double longitud=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);




        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        perdido = (Button)findViewById(R.id.btnperdido);

        //valor de llega
        Intent intent=getIntent();
        Bundle extras =intent.getExtras();

        //pet
        id= (int) extras.get("id");
        name = (String)extras.get("name");
        sex = (String) extras.get("sex");
        age= (int) extras.get("age");
        vaccinated= (String) extras.get("vaccinated");
        information =(String)extras.get("information");
        State=(String)extras.get("state");
        type= (int) extras.get("type");
        userId=(int)extras.get("user_id");
        race= (int) extras.get("race");
        createdAt=(String)extras.get("created_at");
        updated_at=(String)extras.get("updated_at");
        photo= (String) extras.get("photo");
        photo_content_type=(String)extras.get("photo_content_type");
       // photo_file_size =(int)extras.get("photo_file_size");
        photo_updated_at =(String) extras.get("photo_updated_at");
        picture =(String)extras.get("picture");
        //
        informacion =(String)extras.get("informacion");

        //
        lat= (double) extras.get("lat");
        log = (double)extras.get("log");

        mAPIService = ApiUtils.getAPIService();
        //
        perdido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lostPets();
                Toast.makeText(getApplicationContext(), "Se Reporto su Mascota!!",
                        Toast.LENGTH_LONG).show();
                Intent in  = new Intent(getApplication(),MainActivity.class);
                startActivity(in);

            }
        });
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(lat, log);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Mi Ubicacion"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));

        //Poder atrapa una ubicacion de la mascota
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                MarkerOptions options = new MarkerOptions().position( latLng );

                options.title( getAddressFromLatLng( latLng ) );

                mMap.clear();


                options.icon( BitmapDescriptorFactory.fromBitmap(
                        BitmapFactory.decodeResource( getResources(),
                                R.drawable.petbusqueda ) ) );
                mMap.addMarker( options );
            }
        });
    }

    private String getAddressFromLatLng(LatLng latLng ) {
        Geocoder geocoder = new Geocoder( MapsActivity2.this.getApplication() );

        String address = "";
        try {
               /* address = geocoder
                        .getFromLocation( latLng.latitude, latLng.longitude, 1 )
                        .get( 0 ).getAddressLine( 0 );*/

        /*
            latitud  = latLng.latitude;
            longitud = latLng.longitude;
            address = geocoder
                    .getFromLocation( latLng.latitude, latLng.longitude, 1 )
                    .get( 0 ).getAddressLine( 0 );

            String[] dir=address.split(",");
            address=dir[0]+dir[1]+dir[2];

        } catch (IOException e ) {
        }

        return address;
    }


    public void lostPets(){
        int usuario=49;

        Pet pet = new Pet();

        pet.setId(id);
        pet.setName(name);
        pet.setSex(sex);
        pet.setAge(age);
        pet.setVaccinated(vaccinated);
        pet.setInformation(information);
        pet.setState(State);
        pet.setPetTypeId(type);
        pet.setUserId(49);
        pet.setRaceId(race);
        pet.setCreatedAt(createdAt);
        pet.setUpdatedAt(updated_at);
        pet.setPhotoFileName(photo);
        pet.setPhotoContentType(photo_content_type);
    //    pet.setPhotoFileSize(photo_file_size);
        pet.setUpdatedAt(updated_at);
        pet.setPicture(picture);


        PetLost petLost = new PetLost();
        petLost.setStatus("1");
        petLost.setInfo(informacion);
        petLost.setReportDate("2017-11-07");
        petLost.setLatitude("");
        petLost.setLongitude("");
        petLost.setFoundDate(null);
        petLost.setLongitude(longitud.toString());
        petLost.setLatitude(latitud.toString());
        petLost.setPetId(id);
        petLost.setUserId(usuario);
        petLost.setDistrictId(1);
        petLost.setCreatedAt("2017-11-07T14:12:13.000Z");
        petLost.setUpdatedAt("2017-11-07T14:12:13.000Z");
        petLost.setPet(pet);


        mAPIService.LostPet(petLost).enqueue(new Callback<Pet>() {
            @Override
            public void onResponse(Call<Pet> call, Response<Pet> response) {
                if(response.isSuccessful()){
                    System.out.println("se envio correctamente");
                    int statusCode  = response.code();
                    System.out.println("valor de reporte"+statusCode);

                }

            }

            @Override
            public void onFailure(Call<Pet> call, Throwable t) {

            }
        });

    }
}
*/
