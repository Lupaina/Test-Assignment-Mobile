package com.lupaina.fakefilesystemmvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.lupaina.fakefilesystemmvp.MainPresenterInterface;
import com.lupaina.fakefilesystemmvp.R;
import com.lupaina.fakefilesystemmvp.helpClass.FindFileExtension;
import com.lupaina.fakefilesystemmvp.models.FileModel;
import com.lupaina.fakefilesystemmvp.models.FolderModel;
import com.lupaina.fakefilesystemmvp.models.MainModel;

import java.util.List;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.FolderViewHolder> {


    private List<MainModel> listFolders;
    private MainPresenterInterface presenter;

    public FolderAdapter(List<MainModel> listFolders, MainPresenterInterface presenter) {
        this.listFolders = listFolders;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public FolderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_item, parent, false);

        return new FolderViewHolder(view,presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull FolderViewHolder holder, int position) {
        holder.bind(listFolders.get(position));
    }

    @Override
    public int getItemCount() {
        return listFolders.size();
    }


    static class FolderViewHolder extends RecyclerView.ViewHolder {
        private final String fakeSize = "fake size kb";
        private final String objects = " objects";
        private final String object = " object";
        private ImageView imageView;
        private TextView tvName;
        private TextView tvCount;
        private CardView cardView;
        private MainPresenterInterface presenter;

         FolderViewHolder(@NonNull View itemView, MainPresenterInterface presenter) {
            super(itemView);
            this.presenter = presenter;
            imageView = itemView.findViewById(R.id.imageView);
            tvName = itemView.findViewById(R.id.textViewName);
            tvCount = itemView.findViewById(R.id.textViewCount);
            cardView = itemView.findViewById(R.id.cardView);

        }

        void bind(MainModel mainModel) {

            if (mainModel instanceof FileModel) {
                FileModel fileModel = (FileModel) mainModel;
                String fileName = fileModel.getName();
                int icon = FindFileExtension.getFileIcon(fileName);
                imageView.setImageResource(icon);
                tvName.setText(fileName);
                tvCount.setText(fakeSize);

                cardView.setOnClickListener(view -> {
                        presenter.openFile(fileModel);
                });

            } else if (mainModel instanceof FolderModel) {
                FolderModel folderModel = (FolderModel) mainModel;
                String folderName = folderModel.getName();
                int count = folderModel.getItems().size();
                String countElements = count + (count > 1 ? objects : object);

                imageView.setImageResource(R.drawable.ic_folder);
                tvName.setText(folderName);
                tvCount.setText(countElements);

                cardView.setOnClickListener(view -> {
                    presenter.openFolder(folderModel);
                });

            } else
                throw new RuntimeException("Could not find class");


        }
    }


}
