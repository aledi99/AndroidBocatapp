package com.salesianostriana.dam;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.salesianostriana.dam.CategoriaFragment.ICategoriaListener;
import com.salesianostriana.dam.dummy.DummyContent.DummyItem;

import java.util.List;

public class MyCategoriaRecyclerViewAdapter extends RecyclerView.Adapter<MyCategoriaRecyclerViewAdapter.ViewHolder> {

    private List<String> mValues;
    private ICategoriaListener mListener;
    private Context ctx;

    public MyCategoriaRecyclerViewAdapter(List<String> items, ICategoriaListener listener, Context context) {
        mValues = items;
        mListener = listener;
        this.ctx = context;
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
        holder.tvName.setText(holder.mItem);

        switch (holder.mItem) {
            case "Bocateria":
                Glide.with(ctx).load("https://www.asesorexcelente.com/Imagenes/BlogNoticias/bocateria.jpg").into(holder.ivPhoto);
                break;

        }


    }

    public void setData(List<String> result) {
        this.mValues = result;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvName;
        public final TextView tvResults;
        public final ImageView ivPhoto;
        public String mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;

            tvName = view.findViewById(R.id.textViewName);
            tvResults = view.findViewById(R.id.textViewResults);
            ivPhoto = view.findViewById(R.id.imageViewCatName);
        }

    }
}
