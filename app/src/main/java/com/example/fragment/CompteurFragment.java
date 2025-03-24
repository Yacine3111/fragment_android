package com.example.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;



public class CompteurFragment extends Fragment {

    public CompteurFragment() {
        super(R.layout.fragment_compteur);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        CompteurViewModel compteurViewModel = new ViewModelProvider(requireActivity()).get(CompteurViewModel.class);


        Button buttonHistorique = view.findViewById(R.id.btn_historique);
        Button buttonIncrementer = view.findViewById(R.id.btn_incrementer);
        Button buttonDecrementer = view.findViewById(R.id.btn_decrementer);
        Button buttonReinitialiser = view.findViewById(R.id.btn_reinitialiser);
        TextView compteurTV = view.findViewById(R.id.tv_compteur);

        buttonIncrementer.setOnClickListener(v->{
            compteurViewModel.incrementerCompteur();
        });

        buttonDecrementer.setOnClickListener(v->{
            compteurViewModel.decrementerCompteur();
        });

        buttonReinitialiser.setOnClickListener(v->{
            compteurViewModel.reinitialiserCompteur();
        });

        buttonHistorique.setOnClickListener(v->{
            Navigation.findNavController(view).navigate(R.id.action_compteurFragment_to_historiqueFragment);
        });

        compteurViewModel.getCompteur().observe(requireActivity(),compteur->{
            compteurTV.setText(String.valueOf(compteur));
        });

    }


}

