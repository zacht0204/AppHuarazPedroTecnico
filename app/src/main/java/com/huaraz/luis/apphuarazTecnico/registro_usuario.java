package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.huaraz.luis.apphuarazTecnico.Model.UserResponse;
import com.huaraz.luis.apphuarazTecnico.Servicio.APIService;
import com.huaraz.luis.apphuarazTecnico.Servicio.ApiUtils;
import com.huaraz.luis.apphuarazTecnico.Servicio.Peticion;
import com.huaraz.luis.apphuarazTecnico.Servicio.User;
import com.huaraz.luis.apphuarazTecnico.Servicio.ValidationUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registro_usuario extends AppCompatActivity {

    TextInputLayout tilUser, tilPass, tilPassConfirm, tilTelefono;
    private APIService mAPIService;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);


        tilUser = (TextInputLayout) findViewById(R.id.tilUser);
        tilPass = (TextInputLayout) findViewById(R.id.tilPass);
        tilPassConfirm = (TextInputLayout) findViewById(R.id.tilPassConfirm);
        tilTelefono = (TextInputLayout) findViewById(R.id.tilEmail);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        mAPIService = ApiUtils.getAPIService();

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();

            }
        });
    }

    private void signUp() {

        if(!ValidationUtils.isEmpty(tilUser, tilPass, tilPassConfirm, tilTelefono)) {

            String pass = tilPass.getEditText().getText().toString().trim();
            String passConfirm = tilPassConfirm.getEditText().getText().toString().trim();

            if (!pass.equals(passConfirm)) {
                tilPass.setError("Contraseña no coinciden");
                tilPassConfirm.setError("Contraseña no coinciden");
                tilPass.setErrorEnabled(true);
                tilPassConfirm.setErrorEnabled(true);
                return;
            }

            String user = tilUser.getEditText().getText().toString().trim();
            String email = tilTelefono.getEditText().getText().toString().trim();

            Peticion peticion = new Peticion();
            User registro = new User();
            registro.setUsername(user);
            registro.setPassword(pass);
            registro.setPasswordConfirmation(passConfirm);
            registro.setEmail(email);

            peticion.setUser(registro);

            System.out.println("entreo" +user+pass+passConfirm+email);
            mAPIService.Registrousuario(peticion).enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {



                    if(response.isSuccessful()) {


                            Toast.makeText(getApplicationContext(), "Se registro el Usuario Correcto "+ ":)",
                                    Toast.LENGTH_LONG).show();
                            Intent i = new Intent(registro_usuario.this,loginPet.class);
                            startActivity(i);





                    }else {
                        int statusCode  = response.code();
                        System.out.println("codigoError"+statusCode);
                        // handle request errors depending on status code
                    }

                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {

                }
            });


        }

    }
}
