package com.salesianostriana.dam;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.salesianostriana.dam.commons.MyApp;
import com.salesianostriana.dam.commons.SharedPreferencesManager;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class LocalCercaniaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private EstablecimientoListener mListener;
    private List listAllLocals;
    Context context;
    RecyclerView recyclerView;
    private EstablecimientoViewModel establecimientoViewModel;
    MyEstablecimientoRecyclerViewAdapter myEstablecimientoRecyclerViewAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public LocalCercaniaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static LocalCercaniaFragment newInstance(int columnCount) {
        LocalCercaniaFragment fragment = new LocalCercaniaFragment();
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

        establecimientoViewModel = ViewModelProviders.of(getActivity()).get(EstablecimientoViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_cercania_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            loadAlllocals();
        }
        return view;
    }

    public void loadAlllocals(){

        listAllLocals= new ArrayList<>();

        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(MyApp.getContext()));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }

            myEstablecimientoRecyclerViewAdapter = new MyEstablecimientoRecyclerViewAdapter(listAllLocals,establecimientoViewModel, MyApp.getContext());
            recyclerView.setAdapter(myEstablecimientoRecyclerViewAdapter);

            establecimientoViewModel.listAlllocals().observe(getActivity(), new Observer<List<EstablecimientoResponse>>() {
                @Override
                public void onChanged(List<EstablecimientoResponse> allLocals) {
                    listAllLocals.addAll(allLocals);
                    myEstablecimientoRecyclerViewAdapter.notifyDataSetChanged();
                }
            });


    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EstablecimientoListener) {
            mListener = (EstablecimientoListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction();
    }
}
