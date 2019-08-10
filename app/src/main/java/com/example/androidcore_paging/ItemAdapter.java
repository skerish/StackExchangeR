package com.example.androidcore_paging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ItemAdapter extends PagedListAdapter<Items, ItemAdapter.ItemViewHolder> {

    private Context context;

    /**
     *  DiffCallback is use to check where 2 items in a list are same or not.
     */
    private static DiffUtil.ItemCallback<Items> diffCallback = new DiffUtil.ItemCallback<Items>() {
        @Override
        public boolean areItemsTheSame(@NonNull Items oldItem, @NonNull Items newItem) {
            return oldItem.answer_id == newItem.answer_id;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Items oldItem, @NonNull Items newItem) {
            return oldItem.equals(newItem);
        }
    };

    protected ItemAdapter(Context context) {
        super(diffCallback);
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_items, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Items items = getItem(position);
        if (items != null){
            Glide.with(context).load(items.owner.profile_image).into(holder.imageView);
            holder.textView.setText(items.owner.display_name);
        }
        else{
            Toast.makeText(context, "Item is null", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     *  Our ViewHolder Class.
     */
    public class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageID);
            textView = itemView.findViewById(R.id.textID);
        }

    }
}
