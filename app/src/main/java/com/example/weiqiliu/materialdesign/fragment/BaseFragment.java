package com.example.weiqiliu.materialdesign.fragment;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

public class BaseFragment extends Fragment{
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
