package com.example.projetmobile4a.Controller;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.projetmobile4a.Model.API;
import com.example.projetmobile4a.View.Fragment1;
import com.example.projetmobile4a.Model.MyList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {

    private final Fragment1 frag1;
    private SharedPreferences sharedPreferences;
    private static Controller controller = null;
    public List<MyList> listItems;



    public Controller(Fragment1 frag1, SharedPreferences sharedPreferences){
            this.frag1 = frag1;
            this.sharedPreferences = sharedPreferences;
    }


    public static Controller getActivity(Fragment1 mainFrag, SharedPreferences sharedPreferences){

        if(controller==null){
            controller = new Controller(mainFrag, sharedPreferences);
        }
        return controller;

    }


    public void onCreate(){
        if(sharedPreferences.contains("myCacheList")){

            String myCacheList = sharedPreferences.getString("myCacheList","no data found");
            Type type = new TypeToken<List<MyList>>(){}.getType();
            List<MyList> listItems = new Gson().fromJson(myCacheList,type);
            frag1.showList(listItems);

            for(MyList A: listItems){
                Log.d("CACHE: Nom", A.getName()); //Permet d'afficher le nom et l'url de l'image dans RUN pour pouvoir verifier
                Log.d("CACHE: ImageURL",A.getImage());// si ça ne fonctionne pas sur un téléphone
                Log.d("CACHE: Status",A.getStatus());
                Log.d("CACHE: Race",A.getRace());
                Log.d("CACHE: Planete",A.getPlanete());
            }

        }else{


            // on utilise retrofit pour l'appel API
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API api = retrofit.create(API.class);

            Call<List<MyList>> call = api.getItem();

            call.enqueue(new Callback<List<MyList>>() {
                @Override
                public void onResponse(Call<List<MyList>> call, Response<List<MyList>> response) {


                    listItems = response.body();
                    for(MyList A: listItems){
                        Log.d("API: Nom", A.getName()); //Permet d'afficher le nom et l'url de l'image dans RUN pour pouvoir verifier
                        Log.d("API: ImageURL",A.getImage());// si ça ne fonctionne pas sur un téléphone
                        Log.d("API: Status",A.getStatus());
                        Log.d("API: Race",A.getRace());
                        Log.d("API: Planete",A.getPlanete());
                        //Log.d("API: Univers",A.getUnivers());
                    }
                    Gson gson = new GsonBuilder()
                            .setLenient()
                            .create();

                    String myCacheList = gson.toJson(listItems);

                    sharedPreferences.edit()
                            .putString("myCacheList", myCacheList)
                            .apply();

                    frag1.showList(listItems);
                }

                @Override
                public void onFailure(Call<List<MyList>> call, Throwable throwable) {
                    //On renvoie un message en cas d'erreur

                }
            });



        }
    }

}
