package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.huaraz.luis.apphuarazTecnico.Adaptador.DemoAdapter;
import com.huaraz.luis.apphuarazTecnico.Adaptador.PetAdapter;
import com.huaraz.luis.apphuarazTecnico.Model.Demo;
import com.huaraz.luis.apphuarazTecnico.Model.Pet;
import com.huaraz.luis.apphuarazTecnico.Servicio.APIService;
import com.huaraz.luis.apphuarazTecnico.Servicio.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pedidos extends Fragment {
    private APIService mAPIService;
    DemoAdapter pet;
    private FloatingActionButton fabAddPet;
    ListView lv;

    public Pedidos() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_pets, container, false);

        lv = (ListView) root.findViewById(R.id.lista_demos);






      //   fabAddPet = (FloatingActionButton)root.findViewById(R.id.AddPet);



        //codigoSocio = WebServiceValidarUsuario.codigoSocio;

        // lv = (ListView) root.findViewById(R.id.lista_lost_pet);
        // AsyncCallWS task = new AsyncCallWS();
        //task.execute();
        //Evento de pruebas
        mAPIService = ApiUtils.getAPIService();
        loadProfile();



        return  root;

    }

    public  void  loadProfile(){
        final List<Demo> itemsLostPets = new ArrayList<>();
        // final List<Pet> itemsPet = new ArrayList<>();
        System.out.println("Demo Demo");
        mAPIService.getFoto().enqueue(new Callback<List<Demo>>() {
            @Override
            public void onResponse(Call<List<Demo>> call, Response<List<Demo>> response) {


                if(response.isSuccessful()) {
                    for(int i=0;i<response.body().size();i++){
                        itemsLostPets.add(response.body().get(i));
                        // itemsPet.add(response.body().get(i).getPet());
                        System.out.println("Luis"+itemsLostPets.get(i).getId_distrito().toString());
                        // System.out.println("array ++"+itemsLostPets.get(i).getInfo()+"Name"+itemsPet.get(i).getName());


                    }

                }else {
                    int statusCode  = response.code();
                    System.out.println("2"+statusCode);
                    // handle request errors depending on status code
                }
                if (getActivity()!=null){

                    pet = new DemoAdapter (getActivity(),itemsLostPets);
                    lv.setAdapter(pet);

                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            Toast.makeText(getActivity(),"Evento Proximo a Informarle ",Toast.LENGTH_SHORT).show();

                            Intent in  = new Intent(getActivity(),DetallePedido.class);
                            startActivity(in);


                        }
                    });

                    System.out.println("3");
                }////codigo importante



            }

            @Override
            public void onFailure(Call<List<Demo>> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }


    public  void pets(){
        int user=loginPet.id_user;
        String usuario= String.valueOf(user);
        //idi de usuario mientras realizo el login fijo 49

        final List<Pet> itemsPets = new ArrayList<>();
        mAPIService.getMyPets(usuario).enqueue(new Callback<List<Pet>>() {
            @Override
            public void onResponse(Call<List<Pet>> call, Response<List<Pet>> response) {

                if(response.isSuccessful()) {
                    System.out.println("Ingresa el valor"+response.body());
                    for(int i=0;i<response.body().size();i++){
                        itemsPets.add(response.body().get(i));

                    }

                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
                if (getActivity()!=null){

                    /*
                pet = new PetAdapter(getActivity(),itemsPets);
                lv.setAdapter(pet);*/
                }
            }

            @Override
            public void onFailure(Call<List<Pet>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }


}
