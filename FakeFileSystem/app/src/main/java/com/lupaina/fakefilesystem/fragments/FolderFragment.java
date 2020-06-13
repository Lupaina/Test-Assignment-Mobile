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
import androidx.recyclerview.widget.LinearLayoutManager;

import com.lupaina.fakefilesystem.adapters.RecyclerViewAdapter;
import com.lupaina.fakefilesystem.databinding.FragmentFolderBinding;
import com.lupaina.fakefilesystem.di.ViewModelProviderFactory;
import com.lupaina.fakefilesystem.models.MainModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class FolderFragment extends DaggerFragment {

    private RecyclerViewAdapter adapter;
    private FolderViewModel viewModel;
    private FragmentActivity fragmentActivity;
    private String title;
    private boolean showTitle;
    @Inject
    ViewModelProviderFactory providerFactory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentActivity = getActivity();
        List<MainModel> listFiles = new ArrayList<>();
        viewModel = new ViewModelProvider(fragmentActivity, providerFactory).get(FolderViewModel.class);
        adapter = new RecyclerViewAdapter(listFiles, viewModel);


        if (viewModel.getCurrentFolderList().getValue() != null) {
            listFiles.addAll(viewModel.getCurrentFolderList().getValue().getItems());  // set selected folder to list
            title = viewModel.getCurrentFolderList().getValue().getName();  // write value in a variable of a fragment because in ViewModel it will change, and the current value is need at transition back

        }

        if (viewModel.getNoFilesTitleVisible().getValue() != null)
            showTitle = viewModel.getNoFilesTitleVisible().getValue();// the same thing with transition back

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFolderBinding binding = FragmentFolderBinding.inflate(inflater, container, false);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(fragmentActivity));
        binding.recyclerView.setAdapter(adapter);

        binding.textViewTitle.setVisibility(showTitle ? View.VISIBLE : View.GONE);
        ((AppCompatActivity) fragmentActivity).setSupportActionBar(binding.toolbarFolder);
        binding.toolbarFolder.setTitle(title);
        binding.toolbarFolder.setNavigationOnClickListener(view -> {
            Navigation.findNavController(view).popBackStack();
        });

        return binding.getRoot();
    }


}
