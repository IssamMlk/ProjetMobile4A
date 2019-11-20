package com.example.projetmobile4a.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetmobile4a.Controller.Controller;
import com.example.projetmobile4a.Model.MyList;
import com.example.projetmobile4a.R;
import com.example.projetmobile4a.View.RecyclerViewAdapter;

import java.util.List;


public class Fragment1 extends Fragment {

    public View view;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    String key = "myCacheList";

    private Controller controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        view = inflater.inflate(R.layout.fragment_layout1, container, false); //On suit le style de fragment_layout1
        recyclerView = view.findViewById(R.id.RecyclerView);

        controller = new Controller(this, getActivity().getSharedPreferences(key, Context.MODE_PRIVATE));
        controller.onCreate();
        return view;
    }

    //Permet d'afficher la recyclerView + API à l'écran
    public void showList(List<MyList> listItems)
    {
        recyclerView = view.findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new RecyclerViewAdapter(listItems, getActivity());
        recyclerView.setAdapter(adapter);
    }


}