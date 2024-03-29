package com.example.projetmobile4a.Controller;

import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.projetmobile4a.Model.API;
import com.example.projetmobile4a.Model.MyList;
import com.example.projetmobile4a.View.MainActivity;
import com.example.projetmobile4a.View.RecyclerViewAdapter;
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

    private final MainActivity mainactivity;
    private SharedPreferences sharedPreferences;
    private static Controller controller = null;
    public List<MyList> listItems;





    public Controller(MainActivity mainActivity, SharedPreferences sharedPreferences){
            this.mainactivity = mainActivity;
            this.sharedPreferences = sharedPreferences;
    }


    public static Controller getActivity(MainActivity mainactivity, SharedPreferences sharedPreferences){

        if(controller==null){
            controller = new Controller(mainactivity, sharedPreferences);
        }
        return controller;

    }


    public void onCreate(){
        if(sharedPreferences.contains("myCacheList")) {
            String myCache = sharedPreferences.getString("myCacheList", "no data found");
            Type type = new TypeToken<List<MyList>>() {
            }.getType();
            List<MyList> listItems = new Gson().fromJson(myCache, type);
            mainactivity.showList(listItems);

            for (MyList A : listItems) {
                //Log.d("CACHE: Nom", A.getName()); //Permet d'afficher le nom et l'url de l'image dans RUN pour pouvoir verifier
                //Log.d("CACHE: ImageURL", A.getImage());// si ça ne fonctionne pas sur un téléphone
                Log.d("Taille du tableau: ", String.valueOf(A.getTransformation().size()));


                for(int i=0;i!=A.getTransformation().size();i++){
                    if (A.getTransformation().get(i) != null){
                      Log.d("CACHE: Transformation", A.getTransformation().get(i).getStade());
                    }
                }

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
                        Log.d("API: Transformation", A.getTransformation().get(0).getStade());
                        //Log.d("API: Transformation", A.getTransformation().get(1).getStade());
                        //Log.d("API: Transformation", A.getTransformation().get(2).getStade());

                    }
                    Gson gson = new GsonBuilder()
                            .setLenient()
                            .create();

                    String myCache = gson.toJson(listItems);

                    sharedPreferences.edit()
                            .putString("myCacheList", myCache)
                            .apply();

                    mainactivity.showList(listItems);
                }

                @Override
                public void onFailure(Call<List<MyList>> call, Throwable throwable) {
                    //On renvoie un message en cas d'erreur

                }
            });



        }
    }

}
