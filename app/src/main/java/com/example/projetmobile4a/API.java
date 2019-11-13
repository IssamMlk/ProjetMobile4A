package com.example.projetmobile4a;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//Si api finit par .json ça marche pas

public interface API {

    String BASE_URL = "https://dofapi2.herokuapp.com/";

    @GET("weapons")
    Call<List<MyList>> getItem();

}
