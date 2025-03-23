package com.example.test.model.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import dagger.hilt.android.AndroidEntryPoint;

public abstract class ViewBindingFragment<B extends ViewBinding> extends Fragment {

    private B _binding;

    @NonNull
    protected abstract B inflateBinding(@NonNull LayoutInflater inflater, @Nullable ViewGroup container);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        _binding = inflateBinding(inflater, container);
        return getBinding().getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _binding = null;
    }

    @NonNull
    public B getBinding() {
        if (_binding == null) {
            throw new IllegalStateException("Binding is only valid between onCreateView and onDestroyView.");
        }
        return _binding;
    }
}