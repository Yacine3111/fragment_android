package com.example.fragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Operation {
    public int resultat;
    public OperationType type;
    public String heure;

    public Operation(int resultat, OperationType type){
        this.resultat=resultat;
        this.type=type;

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        this.heure = sdf.format(new Date());

    }
}

