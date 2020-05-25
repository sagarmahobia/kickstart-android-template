package org.projectkickstart.templates.mvvmadapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.projectkickstart.templates.databinding.NameListItemBinding;

import java.util.List;

import javax.inject.Inject;

public class NameAdapter extends RecyclerView.Adapter<NameViewHolder> {

    private LayoutInflater inflater;
    private List<NameModel> nameModels;
    private OnItemClickListener clickListener;

    @Inject
    NameAdapter() {
    }

    public void setNameModels(List<NameModel> nameModels) {
        this.nameModels = nameModels;
        notifyDataSetChanged();
    }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        NameListItemBinding binding = NameListItemBinding.inflate(inflater, parent, false);

        return new NameViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        NameModel nameModel = nameModels.get(position);

        holder.getBinding().setModel(nameModel);
        holder.bindTo(nameModel);

    }

    @Override
    public int getItemCount() {
        return nameModels != null ? nameModels.size() : 0;
    }

    public interface OnItemClickListener {
        void onClick(NameModel nameModel);
    }
}

