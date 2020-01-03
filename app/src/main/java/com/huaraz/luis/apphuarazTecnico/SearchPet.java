package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.huaraz.luis.apphuarazTecnico.Adaptador.PetSearchAdapter;
import com.huaraz.luis.apphuarazTecnico.Model.Search;
import com.huaraz.luis.apphuarazTecnico.Servicio.APIService;
import com.huaraz.luis.apphuarazTecnico.Servicio.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPet extends Fragment {
    private APIService mAPIService;
    PetSearchAdapter pet;
    ListView lv;

    public SearchPet() {
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
        View root = inflater.inflate(R.layout.fragment_search, container, false);


        Intent i = new Intent(getContext(), loginPet.class);
        startActivity(i);
       /*
        lv = (ListView) root.findViewById(R.id.lista_search_pet);
        //codigoSocio = WebServiceValidarUsuario.codigoSocio;

        // lv = (ListView) root.findViewById(R.id.lista_lost_pet);
        // AsyncCallWS task = new AsyncCallWS();
        //task.execute();
        //Evento de pruebas
        mAPIService = ApiUtils.getAPIService();
        pets(); */
   /*
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Search lista = pet.getItem(position);

                Intent in  = new Intent(getActivity(),Main_search.class);
                /////////////Envio de id de mascota Perdida
                in.putExtra("idLost",lista.getId());
                //////////
                in.putExtra("picture",lista.getLostPet().getPet().getPicture());
                in.putExtra("id",lista.getLostPet().getPet().getId());
                in.putExtra("photo",lista.getLostPet().getPet().getPhotoFileName());
                in.putExtra("name",lista.getLostPet().getPet().getName());
                in.putExtra("sex",lista.getLostPet().getPet().getSex());
                in.putExtra("type",lista.getLostPet().getPet().getPetTypeId());
                in.putExtra("race",lista.getLostPet().getPet().getRaceId());
                in.putExtra("age",lista.getLostPet().getPet().getAge());
                in.putExtra("vaccinated",lista.getLostPet().getPet().getVaccinated());
                in.putExtra("information",lista.getLostPet().getPet().getInformation());
                in.putExtra("informationLost",lista.getLostPet().getInfo());
                in.putExtra("longitude",lista.getLostPet().getLongitude());
                in.putExtra("latitude",lista.getLostPet().getLatitude());

                startActivity(in);

            }
        }); */
        return  root;

    }
    public  void pets(){
        int user=loginPet.id_user;

        String usuario= String.valueOf(user);
        //idi de usuario mientras realizo el login fijo 49
        final List<Search> itemsPets = new ArrayList<>();
        mAPIService.getMySearch(usuario).enqueue(new Callback<List<Search>>() {
            @Override
            public void onResponse(Call<List<Search>> call, Response<List<Search>> response) {
                if(response.isSuccessful()) {
                    for(int i=0;i<response.body().size();i++){
                        itemsPets.add(response.body().get(i));
                    }

                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
                if (getActivity()!=null){
                    pet = new PetSearchAdapter(getActivity(),itemsPets);
                    lv.setAdapter(pet);
                }
            }


            @Override
            public void onFailure(Call<List<Search>> call, Throwable t) {

            }
        });


}
}
