package com.example.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class CompteurFragment extends Fragment {

    public CompteurFragment() {
        super(R.layout.fragment_compteur);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        Button buttonHistorique = view.findViewById(R.id.btn_historique);

        buttonHistorique.setOnClickListener(v->{
            Navigation.findNavController(view).navigate(R.id.action_compteurFragment_to_historiqueFragment);
        });
    }

}

