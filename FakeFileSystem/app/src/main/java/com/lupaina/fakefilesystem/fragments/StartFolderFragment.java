package com.lupaina.fakefilesystem.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.lupaina.fakefilesystem.adapters.RecyclerViewAdapter;
import com.lupaina.fakefilesystem.databinding.FragmentStartFolderBinding;
import com.lupaina.fakefilesystem.di.ViewModelProviderFactory;
import com.lupaina.fakefilesystem.models.MainModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class StartFolderFragment extends DaggerFragment {

    private FragmentActivity fragmentActivity;
    private RecyclerViewAdapter adapter;
    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentActivity = getActivity();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FolderViewModel viewModel = new ViewModelProvider(fragmentActivity, providerFactory).get(FolderViewModel.class);
        List<MainModel> listFiles = new ArrayList<>();
        adapter = new RecyclerViewAdapter(listFiles, viewModel);

        viewModel.getMainFolderList().observe(this, listFiles::addAll);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentStartFolderBinding binding = FragmentStartFolderBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        binding.recyclerViewStartFolder.setLayoutManager(new LinearLayoutManager(fragmentActivity));
        binding.recyclerViewStartFolder.setAdapter(adapter);

        return binding.getRoot();
    }


}
