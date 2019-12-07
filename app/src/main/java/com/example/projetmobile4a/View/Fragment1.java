package com.example.projetmobile4a.View;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetmobile4a.Model.MyList;
import com.example.projetmobile4a.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;


public class Fragment1 extends Fragment {

    public View view;
    private RecyclerView recyclerView;
    public static TabTransformationAdapter tabTransformationAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        view = inflater.inflate(R.layout.fragment_layout1, container, false); //On suit le style de fragment_layout1
        recyclerView = view.findViewById(R.id.RecyclerView);
        addInformation();
        return view;
    }


    private void addInformation() {
            //String Nom = getActivity().getIntent().getStringExtra("Nom");

            String JSONkey = getActivity().getIntent().getStringExtra("JSONkey");
            Gson gson = new Gson();
            MyList JSONlist = gson.fromJson(JSONkey, MyList.class);


            Log.d("Detail: ImageURL",JSONlist.getImage());
            Log.d("Detail: Nom",JSONlist.getName());
            Log.d("Detail: Transformation",String.valueOf(JSONlist.getTransformation()));


            setInfo(JSONlist);

            CollapsingToolbarLayout collapsingToolbarLayout = view.findViewById(R.id.CollapsingToolBar);
            collapsingToolbarLayout.setTitle(JSONlist.getName());
            collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.collapsedappbar);
            collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);

    }

    private void setInfo(MyList JSONlist){

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        tabTransformationAdapter = new TabTransformationAdapter(JSONlist.getTransformation(),getActivity().getApplicationContext());

        recyclerView.setAdapter(tabTransformationAdapter);

        TextView DetailNom = view.findViewById((R.id.DetailName));
        DetailNom.setText(JSONlist.getName());

        TextView DetailStatus = view.findViewById((R.id.DetailStatus));
        DetailStatus.setText(JSONlist.getStatus());

        TextView DetailRace = view.findViewById((R.id.DetailRace));
        DetailRace.setText(JSONlist.getRace());

        ImageView DetailImage = view.findViewById(R.id.DetailImage);
        Picasso.get().load(JSONlist.getImage()).into(DetailImage);
    }

}