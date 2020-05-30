package org.projectkickstart.templates.mvvmadapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.projectkickstart.templates.databinding.NameListItemBinding;

import java.util.List;

import javax.inject.Inject;

import lombok.Setter;

/**
 * Generated using Android KickStart Template.
 * visit https://github.com/sagarmahobia/kickstart-android-template to learn more.
 */

public class NameAdapter extends RecyclerView.Adapter<NameViewHolder> {

    private LayoutInflater inflater;
    private List<NameModel> nameModels;

    @Setter
    private OnItemClickListener clickListener;

    @Setter
    private NameHandler handler;

    @Inject
    public NameAdapter() {
    }

    public void setNameModels(List<NameModel> nameModels) {
        this.nameModels = nameModels;
        notifyDataSetChanged();
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


        holder.bindTo(nameModel);
        holder.handleWith(handler);

        holder.itemView.setOnClickListener(v -> {
            if (clickListener != null) {
                clickListener.onClick(nameModel);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nameModels != null ? nameModels.size() : 0;
    }

    public interface OnItemClickListener {
        void onClick(NameModel nameModel);
    }

    /*

    TODO scope
    @Provides
    NameAdapter provideNameAdapter(){
        return new NameAdapter();
    }

    */
}

