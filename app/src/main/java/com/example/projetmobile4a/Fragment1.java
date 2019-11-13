package com.example.projetmobile4a;

import android.database.Cursor;
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
    SQLiteDatabase db;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        view = inflater.inflate(R.layout.fragment_layout1, container, false); //On suit le style de fragment_layout1
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        db=getActivity().openOrCreateDatabase("MyDatabase", MODE_PRIVATE, null);
        //db.execSQL("Create table if not exists MyTable (li);");

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
                //db.execSQL("Insert into MyTable values (" + listItems + ");");

                showList(listItems);





                for(MyList A: listItems){
                    Log.d("name", A.getName()); //Permet d'afficher le nom et l'url de l'image dans RUN pour pouvoir verifier
                    Log.d("imgUrl",A.getImage());// si ça ne fonctionne pas sur un téléphone
                }
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
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerViewAdapter(listItems, getContext());
        recyclerView.setAdapter(adapter);
    }


}