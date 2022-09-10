package com.example.AppRestauranteAndroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tareaandroidrestaurante.R;

public class MainActivity extends AppCompatActivity implements RestauranteFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(Restaurante item) {

    }
}