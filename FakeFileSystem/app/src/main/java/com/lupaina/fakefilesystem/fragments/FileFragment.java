package com.lupaina.fakefilesystem.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.lupaina.fakefilesystem.databinding.FragmentFileBinding;
import com.lupaina.fakefilesystem.di.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class FileFragment extends DaggerFragment {


    private FragmentActivity fragmentActivity;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentActivity = getActivity();


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FolderViewModel viewModel = new ViewModelProvider(fragmentActivity, providerFactory).get(FolderViewModel.class);
        FragmentFileBinding binding = FragmentFileBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        ((AppCompatActivity) fragmentActivity).setSupportActionBar(binding.toolbarFile);
        binding.toolbarFile.setNavigationOnClickListener(view -> {
            Navigation.findNavController(view).popBackStack();
        });
        binding.toolbarFile.setTitle(viewModel.getFileTitle().getValue());
        return binding.getRoot();

    }
}
