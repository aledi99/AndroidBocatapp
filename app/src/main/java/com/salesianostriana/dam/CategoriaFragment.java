package com.salesianostriana.dam;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salesianostriana.dam.data.viewModel.CategoriaViewModel;
import com.salesianostriana.dam.dummy.DummyContent.DummyItem;
import com.salesianostriana.dam.retrofit.service.AppService;

import java.util.ArrayList;
import java.util.List;


public class CategoriaFragment extends Fragment {

    private int mColumnCount = 1;
    private ICategoriaListener mListener;
    private CategoriaViewModel categoriaViewModel;
    private List<String> categoriaList;
    private MyCategoriaRecyclerViewAdapter adapter;
    private Context context;


    public CategoriaFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoriaList = new ArrayList<>();
        categoriaViewModel = ViewModelProviders.of(getActivity()).get(CategoriaViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categoria_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
             context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            adapter = new MyCategoriaRecyclerViewAdapter(categoriaList, mListener, context);
            recyclerView.setAdapter(adapter);

            loadCategories();

        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ICategoriaListener) {
            mListener = (ICategoriaListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ICategoriaListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void loadCategories() {
        categoriaViewModel.getCategories().observe(getActivity(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                categoriaList = strings;
                //Falta comparar por distancias
                adapter.setData(categoriaList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public interface ICategoriaListener {
        void onCategoriaClick(DummyItem item);
    }

}
