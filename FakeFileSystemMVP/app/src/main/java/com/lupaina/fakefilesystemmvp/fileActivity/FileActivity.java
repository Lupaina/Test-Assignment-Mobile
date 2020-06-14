package com.lupaina.fakefilesystemmvp.fileActivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.lupaina.fakefilesystemmvp.R;
import com.lupaina.fakefilesystemmvp.models.FileModel;

public class FileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        TextView tvDescription = findViewById(R.id.textViewDescription);

        FileModel fileModel = getIntent().getParcelableExtra("fileModel");
        if (fileModel != null)
            tvDescription.setText(fileModel.getContent());


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            if (fileModel != null)
                actionBar.setTitle(fileModel.getName());
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
