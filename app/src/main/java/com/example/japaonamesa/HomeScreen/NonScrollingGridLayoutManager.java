package com.example.japaonamesa.HomeScreen;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;

public class NonScrollingGridLayoutManager extends GridLayoutManager {

    public NonScrollingGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    @Override
    public boolean canScrollVertically() {
        return false; // Desativa o scroll vertical
    }

    @Override
    public boolean canScrollHorizontally() {
        return false; // Desativa o scroll horizontal
    }
}
