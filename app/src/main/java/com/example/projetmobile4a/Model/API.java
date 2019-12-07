package com.example.projetmobile4a.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//Si api finit par .json ça marche pas

public interface API {

    String BASE_URL = "https://raw.githubusercontent.com/IssamMlk/DBdex/master/";

    @GET("TSAPI3")
    Call<List<MyList>> getItem();

}
