package com.salesianostriana.dam;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import java.util.List;


public class MyCategoriaRecyclerViewAdapter2 extends RecyclerView.Adapter<MyCategoriaRecyclerViewAdapter2.ViewHolder> {

    private final List<Categoria> mValues;
    private final CategoriaListener mListener;

    public MyCategoriaRecyclerViewAdapter2(List<Categoria> items, CategoriaListener listener, Context context) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_categoria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onClickListener(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public Categoria mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
        }


    }
}
