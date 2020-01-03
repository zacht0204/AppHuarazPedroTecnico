package com.huaraz.luis.apphuarazTecnico;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.huaraz.luis.apphuarazTecnico.Servicio.APIService;
import com.huaraz.luis.apphuarazTecnico.Servicio.ApiUtils;
import com.huaraz.luis.apphuarazTecnico.Servicio.Peticion;
import com.huaraz.luis.apphuarazTecnico.Servicio.User;

public class loginPet extends AppCompatActivity {
    private Toolbar toolbar;
    private Button ingresar ,crear;
    private FloatingActionButton fab;
    private EditText input_usuario;
    private EditText input_contrasena;
    private Context context = this;
    private String usuario;
    Dialog customDialog = null;
    private APIService mAPIService;
    FragmentManager fragmentManager = getSupportFragmentManager();
    private String contrasena;

    public static  int id_user=0;
    public  static String correo_user=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_pet);


        toolbar = (Toolbar) findViewById(R.id.activity_my_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_launcher);

        getSupportActionBar().setTitle("Doctor Verde Tecnico");


        ingresar= (Button)findViewById(R.id.boton_iniciar_sesion);
        crear =(Button)findViewById(R.id.boton_crear_cuenta);

       // fab=(FloatingActionButton)findViewById(R.id.fab);
        input_usuario = (EditText)findViewById(R.id.usuario);
        input_contrasena  = (EditText)findViewById(R.id.contrasena);

      //  mAPIService = ApiUtils.getAPIService();
        // fab=(Button)findViewById(R.id.fab);
    /*
        if(isOnlineNet()==false){
            Toast toast = new Toast(getApplicationContext());

            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.toast_layout,
                    (ViewGroup) findViewById(R.id.lytLayout));

            TextView txtMsg = (TextView)layout.findViewById(R.id.txtMensaje);
            txtMsg.setText("¡Activar su Servicio de Internet! ");

            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
        }*/
        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginPet.this,registro_usuario.class);
                startActivity(i);
            }
        });
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input_usuario.getText().length()!=0 && input_usuario.getText().toString()!=""){
                    //Ingreso de al menu de datos
                    if(input_contrasena.getText().length()!=0 && input_contrasena.getText().toString()!=""){
                        usuario = input_usuario.getText().toString();
                        contrasena = input_contrasena.getText().toString();

                        //getIngreso(usuario,contrasena);
                        getIngreso(usuario,contrasena);
                        input_usuario.setText("");
                        input_contrasena.setText("");



                    }else{


                    }
                }else {

                }
            }
        });

        //metodo de login


        //Codigo para realizar llamada telefonica
/*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Codigo personalizado para un mensaje personalizado
              /*  customDialog = new Dialog(context);
                customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                customDialog.setContentView(R.layout.confirmacion);
                customDialog.setCancelable(false);
              //  customDialog = new Dialog(this,R.style.Theme_Dialog_Translucent);
                //deshabilitamos el título por defecto


                TextView titulo = (TextView) customDialog.findViewById(R.id.titulo);
                titulo.setText("COOPERATIVA CACOP");
                TextView texto = (TextView) customDialog.findViewById(R.id.texto);
                texto.setText("¿Llamar a la Cooperativa Cacop?");
                //ImageView dialogImage = (ImageView)openDialog.findViewById(R.id.dialog_image);
                Button dialogCloseButton = (Button)customDialog.findViewById(R.id.aceptar);
                dialogCloseButton.setOnClickListener(new OnClickListener(){
                    @Override
                    public void onClick(View view)
                    {
                        customDialog.dismiss();
                        llamar("(01)4247133");


                    }
                });
                ((Button) customDialog.findViewById(R.id.cancelar)).setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View view)
                    {
                        customDialog.dismiss();


                    }
                });
                customDialog.show();*/

             //   customDialog = new Dialog(context);
                //deshabilitamos el título por defecto
               // customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                //obligamos al usuario a pulsar los botones para cerrarlo
           //     customDialog.setCancelable(false);
                //establecemos el contenido de nuestro dialog

                /*
                customDialog.setContentView(R.layout.confirmacion);
                TextView titulo = (TextView) customDialog.findViewById(R.id.titulo);
                titulo.setText("COOPERATIVA CACOP");

                TextView contenido = (TextView) customDialog.findViewById(R.id.contenido);
                contenido.setText("¿Llamar a la Cooperativa Cacop?");

                ((Button) customDialog.findViewById(R.id.aceptar)).setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view)
                    {
                        customDialog.dismiss();
                        //Evento para matar la aplicacion
                        llamar("(01)4247133");
                        //  MainActivity.this.finish();
                    }///



                });

                ((Button) customDialog.findViewById(R.id.cancelar)).setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view)
                    {
                        customDialog.dismiss();


                    }
                });

                customDialog.show();
                */
          //  }*/

       // });*/



    }

        //metoo de login
    public void getIngreso(String usuario , String contrasena){

        Peticion peticion = new Peticion();
        /*
        User user = new User();
      //  usuario="admin";
      //  contrasena="admin";
        user.setUsername(usuario);
        user.setPassword(contrasena);
        peticion.setUser(user);
        */


         if(usuario.equalsIgnoreCase("admin") && contrasena.equalsIgnoreCase("admin")){

             Intent in = new Intent(loginPet.this,MainActivity.class);

             startActivity(in);

         }else{

             Toast.makeText(getApplicationContext(),"Usuario Incorrecto ",Toast.LENGTH_SHORT).show();
         }

      /*

        mAPIService.getIngreso(peticion).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {


                if(response.isSuccessful()) {
                    String nombre=response.body().getUsername();
                   if (nombre!=null){

                        Toast.makeText(getApplicationContext(), "Bienvenido "+response.body().getUsername()+" :)",
                                Toast.LENGTH_LONG).show();
                       id_user=response.body().getId();
                       correo_user=response.body().getEmail();
                        Intent in = new Intent(loginPet.this,MainActivity.class);

                        startActivity(in);

                    }else{

                       Toast.makeText(getApplicationContext(), "Ingreso la informacion Correcta",
                               Toast.LENGTH_LONG).show();
                    }



                }else {
                    int statusCode  = response.code();
                    System.out.println("codigoError"+statusCode);
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });*/

    }

    ///Verificar si cuenta con internet
    public Boolean isOnlineNet() {

        try {
            Process p = Runtime.getRuntime().exec("ping -c 1 www.google.es");

            int val           = p.waitFor();
            boolean reachable = (val == 0);
            return reachable;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public void llamar(String tel){
        try{
       //     startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+tel)));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
