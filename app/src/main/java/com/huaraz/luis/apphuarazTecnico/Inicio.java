package com.huaraz.luis.apphuarazTecnico;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.huaraz.luis.apphuarazTecnico.Adaptador.NoticiaAdapter;
import com.huaraz.luis.apphuarazTecnico.Adaptador.PetLostAdapter;
import com.huaraz.luis.apphuarazTecnico.Adaptador.StoreAdapter;
import com.huaraz.luis.apphuarazTecnico.Model.Noticias;
import com.huaraz.luis.apphuarazTecnico.Model.Pet;
import com.huaraz.luis.apphuarazTecnico.Model.PetLost;
import com.huaraz.luis.apphuarazTecnico.Servicio.APIService;
import com.huaraz.luis.apphuarazTecnico.Servicio.ApiUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Inicio extends Fragment {

    private APIService mAPIService;
    //Inovacaion del servicio rest

    NoticiaAdapter LostPet;

    ListView lv;

    //valores de envio
    private LinearLayout llSearchLostPets;
   // private RecyclerView.LayoutManager lManager;
    private Spinner spnDistrict;
    private Spinner spnPetType;
    private Button btnSearchLostPets,ocultar;


    ///////////
    public Inicio() {
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
        View root = inflater.inflate(R.layout.fragment_inicio, container, false);
    //    llSearchLostPets = (LinearLayout) root.findViewById(R.id.llSearchLostPets);
      //  llSearchLostPets.setVisibility(View.GONE);

  //      spnDistrict = (Spinner) root.findViewById(R.id.district_spinner);
  //      spnPetType = (Spinner) root.findViewById(R.id.petType_spinner);
        ///bUSQIEDA DE LOS SPINER
//        btnSearchLostPets = (Button) root.findViewById(R.id.btnSearchLostPets);
  //      ocultar = (Button)root.findViewById(R.id.ocultar);
        String[] Distritos = {"LINCE","SAN MIGUEL","INDEPENDENCIA","SURCO","SAN ISIDRO","LA MOLINA","SAN MARTIN DE PORRES","LOS OLIVOS","MIRAFLORES","MIRAFLORES","SAN MIGUEL","COMAS"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item,Distritos);
      //  arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
//        spnDistrict.setAdapter(arrayAdapter);
        ////Busquieda de tipos de mascostas
        String[] Tipos = {"PERRO","GATO"};
      //  ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item,Tipos);
       // arrayAdapter2.setDropDownViewResource(R.layout.spinner_dropdown_item);
//        spnPetType.setAdapter(arrayAdapter2);
        ///
        /*
        ocultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llSearchLostPets.setVisibility(llSearchLostPets.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });*/

//       // mAPIService = ApiUtils.getAPIService();
       // loadLostPets();

        //Boton para poder filtrar un valor
    //    btnSearchLostPets = (Button) root.findViewById(R.id.btnSearchLostPets);

/*
        btnSearchLostPets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String distrito = spnDistrict.getSelectedItem().toString();
                if(distrito.equals("LINCE")){
                    distrito="1";
                }else if(distrito.equals("SAN MIGUEL")) {
                    distrito="2";
                }else if(distrito.equals("INDEPENDENCIA")){
                    distrito="3";
                }else if(distrito.equals("SURCO")){
                    distrito="4";
                }else if(distrito.equals("SAN ISIDRO")){
                    distrito="5";
                }else if(distrito.equals("LA MOLINA")){
                    distrito="6";
                }else if(distrito.equals("SAN MARTIN DE PORRES")){
                    distrito="7";
                }
                else if(distrito.equals("LOS OLIVOS")){
                    distrito="8";
                }
                else if(distrito.equals("MIRAFLORES")){
                    distrito="9";
                }
                else if(distrito.equals("MIRAFLORES")){
                    distrito="10";
                }else if(distrito.equals("SAN MIGUEL")){
                    distrito="11";
                }
                else if(distrito.equals("COMAS")){
                    distrito="12";
                }
                String tipo = spnPetType.getSelectedItem().toString();
                if(tipo.equals("PERRO")){
                    tipo="1";
                }else if (tipo.equals("GATO")){
                    tipo="2";
                }

                System.out.println("filtro"+tipo+distrito);
                filtro(tipo,distrito);
            }
        });





        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                PetLost lista = LostPet.getItem(position);
                Intent in  = new Intent(getActivity(),Main_info_PetLost.class);
                /////////////Envio de id de mascota Perdida
                in.putExtra("idLost",lista.getId());
                //////////
                in.putExtra("picture",lista.getPet().getPicture());
                in.putExtra("id",lista.getPet().getId());
                in.putExtra("photo",lista.getPet().getPhotoFileName());
                in.putExtra("name",lista.getPet().getName());
                in.putExtra("sex",lista.getPet().getSex());
                in.putExtra("type",lista.getPet().getPetTypeId());
                in.putExtra("race",lista.getPet().getRaceId());
                in.putExtra("age",lista.getPet().getAge());
                in.putExtra("vaccinated",lista.getPet().getVaccinated());
                in.putExtra("information",lista.getPet().getInformation());
                in.putExtra("informationLost",lista.getInfo());
                in.putExtra("longitude",lista.getLongitude());
                in.putExtra("latitude",lista.getLatitude());

                startActivity(in);
            }
        });
*/       Noticias no = new Noticias();
        Noticias n1 = new Noticias();
        Noticias n2 = new Noticias();
        Noticias n3 = new Noticias();
        Noticias n4 = new Noticias();

          no.setNoticia("CARHUAZ");
          no.setCaracteristica("Venta de Productos");
          no.setFecha("25/11/2019");

        n1.setNoticia("MANCOS");
        n1.setCaracteristica("Capacitacion");
        n1.setFecha("30/11/2019");

        n2.setNoticia("YUNGAY");
        n2.setCaracteristica("Venta de Productos");
        n2.setFecha("01/01/2020");

        n3.setNoticia("LIMA");
        n3.setCaracteristica("Ganaderia");
        n3.setFecha("02/03/2020");

        n4.setNoticia("RECUAY");
        n4.setCaracteristica("Injetos");
        n4.setFecha("03/04/2020");

        final List<Noticias> itemsPets = new ArrayList<>();
        itemsPets.add(no);
        itemsPets.add(n1);
        itemsPets.add(n2);
        itemsPets.add(n3);
        itemsPets.add(n4);

        lv = (ListView) root.findViewById(R.id.lista_noticia);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),"Evento Proximo a Informarle ",Toast.LENGTH_SHORT).show();

            }
        });
        LostPet = new NoticiaAdapter(getActivity(),itemsPets);
        lv.setAdapter(LostPet);


        return  root;

  }
    public void loadLostPets(){

        final List<PetLost> itemsLostPets = new ArrayList<>();
        // final List<Pet> itemsPet = new ArrayList<>();
        mAPIService.getPetLost().enqueue(new Callback<List<PetLost>>() {
            @Override
            public void onResponse(Call<List<PetLost>> call, Response<List<PetLost>> response) {


                if(response.isSuccessful()) {
                    for(int i=0;i<response.body().size();i++){
                        itemsLostPets.add(response.body().get(i));
                        // itemsPet.add(response.body().get(i).getPet());
                        // System.out.println("Demo Demo"+itemsLostPets.get(i).getPet().getName());
                        // System.out.println("array ++"+itemsLostPets.get(i).getInfo()+"Name"+itemsPet.get(i).getName());


                    }

                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
                if (getActivity()!=null){
                   /*
                LostPet = new PetLostAdapter(getActivity(),itemsLostPets);
                lv.setAdapter(LostPet);
                */
                }//codigo importante
            }

            @Override
            public void onFailure(Call<List<PetLost>> call, Throwable t) {
                t.printStackTrace();
            }
        });



    }


    //realizar filtros

    public void  filtro(String tipo, String distrito ){

        final List<PetLost> itemsLostPets2 = new ArrayList<>();

        mAPIService.addPetSearch(distrito,tipo).enqueue(new Callback<List<PetLost>>() {
            @Override
            public void onResponse(Call<List<PetLost>> call, Response<List<PetLost>> response) {

                if(response.isSuccessful()) {

                    for(int i=0;i<response.body().size();i++){
                        itemsLostPets2.clear();
                        itemsLostPets2.add(response.body().get(i));
                        // itemsPet.add(response.body().get(i).getPet());
                        // System.out.println("Demo Demo"+itemsLostPets.get(i).getPet().getName());
                        // System.out.println("array ++"+itemsLostPets.get(i).getInfo()+"Name"+itemsPet.get(i).getName());


                    }

                }else {
                    int statusCode  = response.code();
                    // handle request errors depending on status code
                }
                if (getActivity()!=null){
                    /*
                    LostPet = new PetLostAdapter(getActivity(),itemsLostPets2);
                    lv.setAdapter(LostPet);
                    */
                }//codigo importante

            }

            @Override
            public void onFailure(Call<List<PetLost>> call, Throwable t) {

            }
        });


    }



}
