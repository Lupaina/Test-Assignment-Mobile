package com.lupaina.fakefilesystemmvp.folderActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lupaina.fakefilesystemmvp.R;
import com.lupaina.fakefilesystemmvp.adapter.FolderAdapter;
import com.lupaina.fakefilesystemmvp.fileActivity.FileActivity;
import com.lupaina.fakefilesystemmvp.models.FileModel;
import com.lupaina.fakefilesystemmvp.models.FolderModel;
import com.lupaina.fakefilesystemmvp.models.MainModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class FolderActivity extends DaggerAppCompatActivity implements FolderContract.View {

    private List<MainModel> listModels;

    @Inject
    FolderContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);

        listModels = new ArrayList<>();

        FolderModel folderModel = getIntent().getParcelableExtra("folderModel");
        if (folderModel != null)
            listModels.addAll(folderModel.getItems());

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            if (folderModel != null)
                actionBar.setTitle(folderModel.getName());
        }

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewFolder);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FolderAdapter adapter = new FolderAdapter(listModels, presenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void openFolder(FolderModel folderModel) {
        Intent intent = new Intent(this, FolderActivity.class);
        intent.putExtra("folderModel", folderModel);
        startActivity(intent);
    }

    @Override
    public void openFile(FileModel fileModel) {
        Intent intent = new Intent(this, FileActivity.class);
        intent.putExtra("fileModel", fileModel);
        startActivity(intent);

    }
}
