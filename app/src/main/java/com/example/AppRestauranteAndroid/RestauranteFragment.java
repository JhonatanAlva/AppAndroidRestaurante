package com.example.AppRestauranteAndroid;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tareaandroidrestaurante.R;

import java.util.ArrayList;
import java.util.List;


public class RestauranteFragment extends Fragment {
    RecyclerView recyclerView;
    MyRestauranteRecyclerViewAdapter adapterRestaurante;
    List<Restaurante> restauranteList;
    OnListFragmentInteractionListener mlistener = null;

    private static final String ARG_COLUMN_COUNT = "column-count";

    private int mColumnCount = 1;

    public RestauranteFragment() {
    }

    public static RestauranteFragment newInstance(int columnCount) {
        RestauranteFragment fragment = new RestauranteFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Polleria la polla", "https://th.bing.com/th/id/OIP.arvQ0B_HPx8TbuwPiXvemwHaE8?pid=ImgDet&rs=1", 4.0f, "Guatemala, Guatemala"));
            restauranteList.add(new Restaurante("Pizzeria Lupe", "https://res.cloudinary.com/glovoapp/w_1200,f_auto,q_auto/Stores/t6tx0haplavotfhixk1h", 5.0f, "Jalapa"));
            restauranteList.add(new Restaurante("Pupuseria la joya", "https://th.bing.com/th/id/OIP.-2WO9MhnrcbjQkUoO9xRoQHaE4?pid=ImgDet&rs=1", 3.50f, "Jutiapa"));
            restauranteList.add(new Restaurante("Pastelería La Concha", "https://th.bing.com/th/id/R.af16918fb5c432f2a263ca332a6ba1a6?rik=HsVEJdbLP67pTg&pid=ImgRaw&r=0", 3.50f, "Jutiapa"));

            adapterRestaurante = new MyRestauranteRecyclerViewAdapter(getContext(),restauranteList, mlistener);

            recyclerView.setAdapter(adapterRestaurante);
        }
        return view;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Restaurante item);

    }
}