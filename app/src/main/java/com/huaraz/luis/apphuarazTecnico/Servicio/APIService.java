package com.huaraz.luis.apphuarazTecnico.Servicio;

//import com.petcacop.pc.myapplication.example3.*;

import com.huaraz.luis.apphuarazTecnico.Model.Demo;
import com.huaraz.luis.apphuarazTecnico.Model.Districts;
import com.huaraz.luis.apphuarazTecnico.Model.Pet;
import com.huaraz.luis.apphuarazTecnico.Model.PetLost;
import com.huaraz.luis.apphuarazTecnico.Model.Search;
import com.huaraz.luis.apphuarazTecnico.Model.Store;
import com.huaraz.luis.apphuarazTecnico.Model.UserResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by pc on 31/10/2017.
 */

public interface APIService {

   //Consultar Pedidos lost
   @GET("/lost_pets.json")
   Call<List<PetLost>> getPetLost();

   ////////////////////////////////
   //consultar foto con get
   @GET("post.php")
   Call<List<Demo>> getFoto();

   //Registrar foto
   @FormUrlEncoded
   @POST("post.php")
   Call<Demo> addFoto(@Field("id_foto1") String id_foto1,
                      @Field("id_foto2") String id_foto2,
                      @Field("id_foto3") String id_foto3,
                      @Field("id_distrito") String id_distrito,
                      @Field("id_provincia") String id_provincia);

   //////////////////////////////////
   //Consultar  Pedidos for Users
    @GET("/users/{user}/pets.json")
   Call<List<Pet>> getMyPets(@Path("user") String user);


   //consutar profie for user
   @GET("/users/{user}/profiles.json")
   Call<Demo> getMyProfile(@Path("user") String user);

   //Register a pet

   @POST("/users/{user}/pets.json")
   Call<Pet> addPet(@Path("user") String user, @Body Pet pet);

   //Registrar pet perdido
   //registro de usuario

   @POST("/users.json")
   Call<UserResponse> addUsuario(@Body UserResponse user);

   //agregar amis busquedas pet
   @GET("/add_lostpet/{lostpet}")
   Call<Pet> addPetLostSearch(@Path("lostpet") String idPet, @Query("?user_id") String id_user);

   @POST("/lost_pets.json")
   Call<Pet> LostPet(@Body PetLost petLost);

   //Lamada de  los distritos
   @GET("/districts.json")
   Call<Districts> getDistritos();

   //Registrar a mis mis busquedas
   //Call<Pet> LostPet(@Body PetLost petLost);
   @GET("/lost_pets.json?")
   Call<List<PetLost>> addPetSearch(@Query("pet_type_id") String tipo, @Query("&district_id") String distrito);
   ///Listar mis registro de busquedas
   //Consultar mis busqyuedas-------------->
   @GET("/users/{user}/my_searches.json")
   Call<List<Search>> getMySearch(@Path("user") String user);


   //Llamada de la tienda

   //Lamada de  los distritos
   @GET("/stores.json")
   Call<List<Store>> getStore();



   //Login de usuario
   @Headers({
           "Content-Type: application/json",
           "Accept: application/json"

   })
    @POST("/login.json")
    Call<UserResponse> getIngreso(@Body Peticion peticion);
//registrar Usuario

   @Headers({
           "Content-Type: application/json",
           "Accept: application/json"

   })
   @POST("/users.json")
   Call<UserResponse> Registrousuario(@Body Peticion peticion);
  //Actualizar sus datos









   @PUT("/users/{user}/profiles.json")
   Call<UserResponse> ActualizarUsuario(@Path("user") String user, @Body Demo pet);


}
