package com.lupaina.fakefilesystemmvp.mainActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lupaina.fakefilesystemmvp.R;
import com.lupaina.fakefilesystemmvp.adapter.FolderAdapter;
import com.lupaina.fakefilesystemmvp.fileActivity.FileActivity;
import com.lupaina.fakefilesystemmvp.folderActivity.FolderActivity;
import com.lupaina.fakefilesystemmvp.models.FileModel;
import com.lupaina.fakefilesystemmvp.models.FolderModel;
import com.lupaina.fakefilesystemmvp.models.MainModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements MainContract.View {

    private List<MainModel> listModels;
    private FolderAdapter adapter;

    @Inject
    MainContract.Presenter presenter;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listModels = new ArrayList<>();

        initRecyclerView();

        presenter.initData();

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FolderAdapter(listModels, presenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void getData(List<MainModel> mainModels) {
        listModels.addAll(mainModels);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openFolder(FolderModel folderModel) {
        Intent intent = new Intent(this, FolderActivity.class);
        intent.putExtra("folderModel", folderModel);
        startActivity(intent);
        /** Модель передаю через intent за допомогою Parcelable.
         Нового для мене, але старого для світу:)
         */

    }

    @Override
    public void openFile(FileModel fileModel) {
        Intent intent = new Intent(this, FileActivity.class);
        intent.putExtra("fileModel", fileModel);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
