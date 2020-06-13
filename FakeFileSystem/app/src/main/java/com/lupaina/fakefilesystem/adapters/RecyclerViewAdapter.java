package com.lupaina.fakefilesystem.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.lupaina.fakefilesystem.R;
import com.lupaina.fakefilesystem.databinding.RvItemBinding;
import com.lupaina.fakefilesystem.fragments.FolderViewModel;
import com.lupaina.fakefilesystem.helpClass.FindFileExtension;
import com.lupaina.fakefilesystem.models.FileModel;
import com.lupaina.fakefilesystem.models.FolderModel;
import com.lupaina.fakefilesystem.models.MainModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<MainModel> listFolders;
    private FolderViewModel viewModel;

    public RecyclerViewAdapter(List<MainModel> listFolders, FolderViewModel viewModel) {
        this.listFolders = listFolders;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RvItemBinding binding = RvItemBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if (listFolders.get(position) instanceof FileModel) {
            int icon = FindFileExtension.getFileIcon(((FileModel) listFolders.get(position)).getName());
            String fileName = ((FileModel) listFolders.get(position)).getName();
            holder.bind(icon, fileName, "fake size kb");

            holder.binding.cardView.setOnClickListener(view -> viewModel.openFile((FileModel) listFolders.get(position), view));

        } else if (listFolders.get(position) instanceof FolderModel) {
            String folderName = ((FolderModel) listFolders.get(position)).getName();
            String countElements = ((FolderModel) listFolders.get(position)).getItems().size() + " objects";
            holder.bind(R.drawable.ic_folder, folderName, countElements);

            holder.binding.cardView.setOnClickListener(view -> viewModel.openFolder((FolderModel) listFolders.get(position), view));
        }

    }

    @Override
    public int getItemCount() {
        return listFolders.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        RvItemBinding binding;

        MyViewHolder(RvItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(int image, String name, String count) {
            binding.setImage(image);
            binding.setFolderName(name);
            binding.setCount(count);
            binding.executePendingBindings();
        }
    }

    @BindingAdapter({"setImage"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}



