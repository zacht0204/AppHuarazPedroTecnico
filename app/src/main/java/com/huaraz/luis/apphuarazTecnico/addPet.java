package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.huaraz.luis.apphuarazTecnico.Servicio.APIService;
import com.huaraz.luis.apphuarazTecnico.Model.Pet;

import com.huaraz.luis.apphuarazTecnico.Servicio.ApiUtils;
import com.huaraz.luis.apphuarazTecnico.Servicio.ValidationUtils;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class addPet extends AppCompatActivity {

    private ImageView imgPetPhoto;
    private TextInputLayout tilPetName, tilPetAge, tilPetInformation;
    private RadioGroup rbgPetSex, rbgPetVaccionated;
    private RadioButton rbtnPetSex, rbtnPetVaccionated;
    private Spinner spnPetType, spnPetRace;
    private FloatingActionButton fabSave;
    int edad=0;
    int tipo=0;
    int race=0;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    private APIService mAPIService;

    String Tipo[] ={"PERRO","GATO"};

    String Raza[] ={"SHITZU","DOVERMAN","DALMATA","SIVERIANO","BULL DOG","SAN BERNARDO","SAN BERNARDO","CHINO","PEQUINES","PEQUINES","ROFFWAILER","BOXER","PERSIAN",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pet);

        spnPetType = (Spinner) findViewById(R.id.spnTipo);
        spnPetRace = (Spinner) findViewById(R.id.spnRaza);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this.getApplicationContext(),R.layout.spinner_item,Tipo);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spnPetType.setAdapter(arrayAdapter);


        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this.getApplicationContext(),R.layout.spinner_item,Raza);
        arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spnPetRace.setAdapter(arrayAdapter2);

        imgPetPhoto = (ImageView) findViewById(R.id.imgPetPhoto);
        tilPetName = (TextInputLayout) findViewById(R.id.tilPetName);
        tilPetAge = (TextInputLayout) findViewById(R.id.tilPetAge);
        tilPetInformation = (TextInputLayout) findViewById(R.id.tilPetInformation);
        rbgPetSex = (RadioGroup) findViewById(R.id.rbgSex);
        rbgPetVaccionated = (RadioGroup) findViewById(R.id.rbgPetVaccionated);



        fabSave = (FloatingActionButton) findViewById(R.id.fabSavePet);

        imgPetPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPhoto();
            }
        });

        mAPIService = ApiUtils.getAPIService();








        fabSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!ValidationUtils.isEmpty(tilPetName, tilPetAge,tilPetInformation)) {
                    addPet();
                    Toast.makeText(getApplicationContext(), "Se Registro Su Mascota!!",
                            Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Ingrese la informacion faltante",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //Codigo para tomar foto y enviarlo al servidor

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE) {

            if (data != null) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imgPetPhoto.setImageBitmap(imageBitmap);
            }
        }

    }

    private void getPhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(this.getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void addPet(){

        String tipopet = spnPetType.getSelectedItem().toString();
        if(tipopet.equals("PERRO")){
            tipo=1;

        }else if (tipopet.equals("GATO")){
            tipo=2;
        }

        String razapet = spnPetRace.getSelectedItem().toString();
        if(razapet.equals("")){

        }else if (razapet.equals("SHITZU")){
            race=1;
        }
        else if (razapet.equals("DOVERMAN")){
            race=2;
        }
        else if (razapet.equals("DALMATA")){
            race=3;
        }
        else if (razapet.equals("SIVERIANO")){
            race=4;
        }
        else if (razapet.equals("BULL DOG")){
            race=5;
        }else if (razapet.equals("SAN BERNARDO")){
            race=6;

        }else if (razapet.equals("SAN BERNARDO")){
            race=7;
        }
        else if (razapet.equals("CHINO")){
            race=8;
        }
        else if (razapet.equals("PEQUINES")){
            race=9;
        }
        else if (razapet.equals("PEQUINES")){
            race=10;
        }
        else if (razapet.equals("ROFFWAILER")){
            race=11;
        }
        else if (razapet.equals("BOXER")){
            race=12;
        }
        else if (razapet.equals("PERSIAN")){
            race=13;
        }

        int sexSelectedId = rbgPetSex.getCheckedRadioButtonId();
        int vaccionatedSelectedId = rbgPetVaccionated.getCheckedRadioButtonId();

        rbtnPetSex = (RadioButton) this.findViewById(sexSelectedId);
        rbtnPetVaccionated = (RadioButton) this.findViewById(vaccionatedSelectedId);


        String edadPet=tilPetAge.getEditText().getText().toString().trim();

        edad= Integer.parseInt(edadPet);

        Pet pet = new Pet();
        pet.setName(tilPetName.getEditText().getText().toString().trim());
        pet.setAge(edad);

        BitmapDrawable drawable = (BitmapDrawable) imgPetPhoto.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 75, bos);
        byte[] bb = bos.toByteArray();
        String petPhoto64 = Base64.encodeToString(bb, 0);

        pet.setPicture(petPhoto64);

        pet.setInformation(tilPetInformation.getEditText().getText().toString().trim());
        pet.setSex(rbtnPetSex.getText().toString().trim());
        pet.setVaccinated(rbtnPetVaccionated.getText().toString().trim());

        int user=loginPet.id_user;


        pet.setPetTypeId(tipo);
        pet.setRaceId(race);
        pet.setState("P");
        pet.setUserId(user);


        String usuario="49";
        mAPIService.addPet(usuario,pet).enqueue(new Callback<Pet>() {
            @Override
            public void onResponse(Call<Pet> call, Response<Pet> response) {

                System.out.println("ingreso"+response.body());
                if(response.isSuccessful()) {

                    System.out.println("perfil"+response.code());
                    int statusCode  = response.code();
                }else {
                    int statusCode  = response.code();
                    System.out.println("codigoError"+statusCode);
                    // handle request errors depending on status code
                }


            }

            @Override
            public void onFailure(Call<Pet> call, Throwable t) {

            }
        });
    }
}
