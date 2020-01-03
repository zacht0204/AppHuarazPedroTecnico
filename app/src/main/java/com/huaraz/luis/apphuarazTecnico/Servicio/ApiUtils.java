package com.huaraz.luis.apphuarazTecnico.Servicio;

/**
 * Created by pc on 31/10/2017.
 */

public class ApiUtils {

    private ApiUtils(){}


    public static final String BASE_URL="http://appluis.cosmop.co/rest/";
    public static APIService getAPIService(){

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
