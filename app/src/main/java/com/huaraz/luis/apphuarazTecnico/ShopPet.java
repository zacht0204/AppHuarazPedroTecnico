package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.huaraz.luis.apphuarazTecnico.Adaptador.StoreAdapter;
import com.huaraz.luis.apphuarazTecnico.Model.Store;
import com.huaraz.luis.apphuarazTecnico.Servicio.APIService;
import com.huaraz.luis.apphuarazTecnico.Servicio.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopPet extends Fragment {

    private APIService mAPIService;

    StoreAdapter LostPet;

    ListView lv;

    public ShopPet() {
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
        View root = inflater.inflate(R.layout.fragment_shop, container, false);

        lv = (ListView) root.findViewById(R.id.lista_store1);

        mAPIService = ApiUtils.getAPIService();
        //codigoSocio = WebServiceValidarUsuario.codigoSocio;

        tiendas();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent in  = new Intent(getActivity(),store_categoria.class);
                /////////////Envio de id de mascota Perdida

                Store lista = LostPet.getItem(position);
                in.putExtra("name",lista.getName());
                //////////


                in.putExtra("Comida",lista.getLatitude());
                in.putExtra("Correas",lista.getLongitude());
                in.putExtra("Collares",lista.getLongitude());
                in.putExtra("Champus",lista.getLatitude());
                in.putExtra("Ropa",lista.getLongitude());

                startActivity(in);

            }
        });
        // lv = (ListView) root.findViewById(R.id.lista_lost_pet);
        // AsyncCallWS task = new AsyncCallWS();
        //task.execute();
        //Evento de pruebas

        return  root;

    }

    public  void tiendas (){


        final List<Store> itemsPets = new ArrayList<>();
        mAPIService.getStore().enqueue(new Callback<List<Store>>() {
            @Override
            public void onResponse(Call<List<Store>> call, Response<List<Store>> response) {

                if(response.isSuccessful()) {
                    for(int i=0;i<response.body().size();i++){
                        itemsPets.add(response.body().get(i));


                    }

                }else {
                    int statusCode  = response.code();

                    // handle request errors depending on status code
                }
                if (getActivity()!=null){
                    LostPet = new StoreAdapter(getActivity(),itemsPets);
                    lv.setAdapter(LostPet);
                }//codigo importante

            }

            @Override
            public void onFailure(Call<List<Store>> call, Throwable t) {

            }
        });



    }


}
