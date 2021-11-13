package com.example.nftapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class AssetRVAdapter extends RecyclerView.Adapter<AssetRVAdapter.ViewHolder> {
    private ArrayList<Asset> assetList;
    private Context context;

    public AssetRVAdapter(ArrayList<Asset> assetList, Context context) {
        this.assetList = assetList;
        this.context = context;
    }

    @NonNull
    @Override
    public AssetRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.asset_item,parent,false);
        return new AssetRVAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(AssetRVAdapter.ViewHolder holder, int position) {
            Asset asset = assetList.get(position);
            holder.id.setText(asset.getId());
            holder.desc.setText(asset.getDescription());
            Picasso.get().load(asset.getImgUrl()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return assetList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView id,desc;
        private ImageView img;
        public ViewHolder(@NonNull View itemView){
            super(Objects.requireNonNull(itemView));
            id = itemView.findViewById(R.id.nftIDTxt);
            desc = itemView.findViewById(R.id.nftDescID);
            img = itemView.findViewById(R.id.nftImgID);
        }
    }
}
