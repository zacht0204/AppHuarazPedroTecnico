package com.huaraz.luis.apphuarazTecnico;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
/*
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;
*/
import com.huaraz.luis.apphuarazTecnico.Servicio.ValidationUtils;
/*
public class addpetReg extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener,
        GoogleApiClient.ConnectionCallbacks,
        com.google.android.gms.location.LocationListener {

    String name,photo,sex,information, createdAt,updated_at,photo_content_type,photo_updated_at,vaccinated,State,picture;
    int id , type,race,age,userId,photo_file_size;

    //Elementos
    private TextView txvPetName, txvPetSex, txvPetType, txvPetRace, txvPetAge, txvPetVaccinated, txvPetInfo;
    private TextInputLayout tilLostPetInfo;

    private FloatingActionButton fabReportar;
    private ImageView imgPetPhoto;

    private EditText informacion;


    //Variables para atrapar mi ubicacion
    double log=0.0 ,lat=0.0;

    private LocationRequest locRequest;
    private static final String LOGTAG = "android-localizacion";

    private GoogleApiClient apiClient;
    private static final int PETICION_PERMISO_LOCALIZACION = 101;
    private static final int PETICION_CONFIG_UBICACION = 201;

    //tolbar
    private Toolbar toolbar;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpet_reg);
        toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Registra Mascota Perdida");
        toolbar.setLogo(R.drawable.petbusqueda);

        //Valor de llegada del detalle del pet
        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
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
      //  photo_file_size =(int)extras.get("photo_file_size");
        picture =(String)extras.get("picture");

        photo_updated_at =(String) extras.get("photo_updated_at");
        ////////////////////////////////////////////

        txvPetName = (TextView) findViewById(R.id.txvPetName);
        txvPetSex = (TextView) findViewById(R.id.txvPetSex);
        txvPetType = (TextView)findViewById(R.id.txvPetType);
        txvPetRace = (TextView) findViewById(R.id.txvPetRace);
        txvPetAge = (TextView) findViewById(R.id.txvPetAge);
        txvPetVaccinated = (TextView) findViewById(R.id.txvPetVaccinated);
        txvPetInfo = (TextView) findViewById(R.id.txvPetInfo);
//        informacion = (EditText) findViewById(R.id.informacion);
        tilLostPetInfo = (TextInputLayout) findViewById(R.id.tilLostPetInfo);
        //envio al mapa para atrapa la ubicacion
        fabReportar = (FloatingActionButton) findViewById(R.id.fabReportPet);
        imgPetPhoto = (ImageView) findViewById(R.id.petPhoto);


        txvPetName.setText(name);
        txvPetSex.setText(sex);
        txvPetAge.setText(String.valueOf(age));

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

        String foto=picture;
        if(foto!=null){
            // Receiving side
            byte[] data1 = Base64.decode(foto, Base64.DEFAULT);
            String text1 = null;
            try {
                Bitmap bitmap = BitmapFactory.decodeByteArray(data1, 0, data1.length);
                imgPetPhoto.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*
        Picasso.with(this)
                .load("http://findmewebapp-eberttoribioupc.c9.io/system/pets/photos/000/000/0"+id+"/thumb/"+photo)
                .resize(120, 120)
                .into(imgPetPhoto);*/




/*
        apiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();

        toggleLocationUpdates(true);

        fabReportar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String valorInformacion=tilLostPetInfo.getEditText().getText().toString().trim();

                if(!ValidationUtils.isEmpty(tilLostPetInfo)){
                    if(lat!=0.0 && log != 0.0){
                        Intent in = new Intent(getApplicationContext(), MapsActivity2.class);
                        ///pet

                        in.putExtra("id",id);
                        in.putExtra("name",name);
                        in.putExtra("sex",sex);
                        in.putExtra("age",age);
                        in.putExtra("vaccinated",vaccinated);
                        in.putExtra("information",information);
                        in.putExtra("state",State);
                        in.putExtra("type",type);
                        in.putExtra("user_id",userId);
                        in.putExtra("race",race);
                        in.putExtra("created_at",createdAt);
                        in.putExtra("updated_at",updated_at);
                        in.putExtra("photo",photo);
                        in.putExtra("photo_content_type",photo_content_type);
                     //   in.putExtra("photo_file_size",photo_file_size);
                        in.putExtra("photo_updated_at",photo_updated_at);
                        ///
                        in.putExtra("picture",picture);
                        in.putExtra("informacion",valorInformacion);
                        ///

                        in.putExtra("lat",lat);
                        in.putExtra("log",log);
                        startActivity(in);
                    }else{
                        Toast.makeText(getApplicationContext(), "Su Servicio de Internet se esta restableciendo",
                                Toast.LENGTH_LONG).show();
                    }

                }else{

                    Toast.makeText(getApplicationContext(), "Ingrese la informacion de su mascota",
                            Toast.LENGTH_LONG).show();
                }



            }
        });
    }

    //Metodo para atrapa la ubicacion


    private void toggleLocationUpdates(boolean enable) {
        if (enable) {
            enableLocationUpdates();
        } else {
            disableLocationUpdates();
        }
    }

    private void enableLocationUpdates() {

        locRequest = new LocationRequest();
        locRequest.setInterval(2000);
        locRequest.setFastestInterval(1000);
        locRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest locSettingsRequest =
                new LocationSettingsRequest.Builder()
                        .addLocationRequest(locRequest)
                        .build();

        PendingResult<LocationSettingsResult> result =
                LocationServices.SettingsApi.checkLocationSettings(
                        apiClient, locSettingsRequest);

        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult locationSettingsResult) {
                final Status status = locationSettingsResult.getStatus();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:

                        Log.i(LOGTAG, "Configuración correcta");
                        startLocationUpdates();

                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        try {
                            Log.i(LOGTAG, "Se requiere actuación del usuario");
                            status.startResolutionForResult(addpetReg.this, PETICION_CONFIG_UBICACION);
                        } catch (IntentSender.SendIntentException e) {
                            //  btnActualizar.setChecked(false);
                            Log.i(LOGTAG, "Error al intentar solucionar configuración de ubicación");
                        }

                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        Log.i(LOGTAG, "No se puede cumplir la configuración de ubicación necesaria");
                        // btnActualizar.setChecked(false);
                        break;
                }
            }
        });
    }

    private void disableLocationUpdates() {

        LocationServices.FusedLocationApi.removeLocationUpdates(
                apiClient, this);

    }

    private void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(addpetReg.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            //Ojo: estamos suponiendo que ya tenemos concedido el permiso.
            //Sería recomendable implementar la posible petición en caso de no tenerlo.

            Log.i(LOGTAG, "Inicio de recepción de ubicaciones");

            LocationServices.FusedLocationApi.requestLocationUpdates(
                    apiClient, locRequest, addpetReg.this);
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        //Se ha producido un error que no se puede resolver automáticamente
        //y la conexión con los Google Play Services no se ha establecido.

        Log.e(LOGTAG, "Error grave al conectar con Google Play Services");
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        //Conectado correctamente a Google Play Services

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PETICION_PERMISO_LOCALIZACION);
        } else {

            Location lastLocation =
                    LocationServices.FusedLocationApi.getLastLocation(apiClient);

            updateUI(lastLocation);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        //Se ha interrumpido la conexión con Google Play Services

        Log.e(LOGTAG, "Se ha interrumpido la conexión con Google Play Services");
    }

    private void updateUI(Location loc) {
        if (loc != null) {
            lat=loc.getLatitude();
            log=loc.getLongitude();
            System.out.println("segundo"+loc.getLatitude()+loc.getLongitude());//si me muestra el valor

        } else {
           /* lblLatitud.setText("Latitud: (desconocida)");
            lblLongitud.setText("Longitud: (desconocida)");*/
/*
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PETICION_PERMISO_LOCALIZACION) {
            if (grantResults.length == 1
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                //Permiso concedido

                @SuppressWarnings("MissingPermission")
                Location lastLocation =
                        LocationServices.FusedLocationApi.getLastLocation(apiClient);

                updateUI(lastLocation);

            } else {
                //Permiso denegado:
                //Deberíamos deshabilitar toda la funcionalidad relativa a la localización.

                Log.e(LOGTAG, "Permiso denegado");
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PETICION_CONFIG_UBICACION:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        startLocationUpdates();
                        break;
                    case Activity.RESULT_CANCELED:
                        Log.i(LOGTAG, "El usuario no ha realizado los cambios de configuración necesarios");
                        //btnActualizar.setChecked(false);
                        break;
                }
                break;
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        Log.i(LOGTAG, "Recibida nueva ubicación!");

        //Mostramos la nueva ubicación recibida
        updateUI(location);
    }
    //Metodo para atrapa la ubicacion
}


*/