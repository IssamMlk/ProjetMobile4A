package com.example.projetmobile4a;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;


public class Fragment1 extends Fragment {

    public View view;
    private RecyclerView recyclerView;
    public List<MyList> listItems;
    private RecyclerView.Adapter adapter;
    private SharedPreferences sharedPreferences;
    List<MyList> myCacheList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        view = inflater.inflate(R.layout.fragment_layout1, container, false); //On suit le style de fragment_layout1
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        myCacheList = new ArrayList<>();

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
                myCacheList= response.body();

                StringBuilder stringBuilder = new StringBuilder();
                for (MyList s : myCacheList){
                    stringBuilder.append(s);
                    stringBuilder.append(",");
                }
                sharedPreferences = getActivity().getSharedPreferences("myPreference", 0);
                SharedPreferences.Editor myPrefEditor = sharedPreferences.edit();
                myPrefEditor.putString("myCacheList", stringBuilder.toString());
                myPrefEditor.commit();

                String loadData = sharedPreferences.getString("myCacheList","no data found");
                String[] item = loadData.split(",");
                List<String> items = new ArrayList<String>();
                for(int i=0; i<item.length; i++){
                    items.add(item[i]);
                }

                for(int i=0; i<items.size(); i++){
                    Log.d("listItem", items.get(i));
                }

                showList(myCacheList);
            }

            @Override
            public void onFailure(Call<List<MyList>> call, Throwable throwable) {
                Toast.makeText(getActivity(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                //On renvoie un message en cas d'erreur

            }
        });

    }

    //Permet d'afficher la recyclerView + API à l'écran
    public void showList(List<MyList> listItems)
    {
        recyclerView = view.findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerViewAdapter(listItems, getActivity());
        recyclerView.setAdapter(adapter);
    }


}