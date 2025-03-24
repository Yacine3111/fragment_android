package com.example.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

public class HistoriqueFragment extends Fragment {
    public HistoriqueFragment() {
        super(R.layout.fragment_historique);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        CompteurViewModel compteurViewModel = new ViewModelProvider(requireActivity()).get(CompteurViewModel.class);

        TextView valeurActuelTV = view.findViewById(R.id.tv_compteur_valeur);
        ListView historiqueLV = view.findViewById(R.id.lv_historique);



        compteurViewModel.getCompteur().observe(getViewLifecycleOwner(),compteur->{
            valeurActuelTV.setText(String.valueOf(compteur));
        });

        compteurViewModel.getHistorique().observe(getViewLifecycleOwner(),operations->{
            List<String> operationsStr = new ArrayList<>();

            for(Operation operation : operations){
                operationsStr.add(
                        operation.heure+" - "
                        +getString(compteurViewModel.getOperationResId(operation.type))
                        +" ➔ "+operation.resultat);
            }

            ArrayAdapter<String> operationsAdapter=new ArrayAdapter<>(
                    requireContext(),android.R.layout.simple_list_item_1
                    ,operationsStr);

            historiqueLV.setAdapter(operationsAdapter);

        });
    }
}