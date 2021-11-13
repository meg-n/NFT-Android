package com.example.nftapp;

import java.util.ArrayList;

public class AssetModel {
    private ArrayList<Asset> assets;

    public AssetModel(ArrayList<Asset> assets) {
        this.assets = assets;
    }

    public ArrayList<Asset> getAssets() {
        return assets;
    }

    public void setAssets(ArrayList<Asset> assets) {
        this.assets = assets;
    }
}
