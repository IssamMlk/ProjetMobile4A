package com.example.projetmobile4a.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.projetmobile4a.R;

public class Fragment3 extends Fragment {
    private Button GoToFrag;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancesState){
        View view = inflater.inflate(R.layout.fragment_layout3, container, false);
        return view;
        }
    }