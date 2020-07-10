package com.example.recyclerviewwithintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerviewwithintent.Model.Item;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{

    public static final String TAG=PostAdapter.class.getSimpleName();
    private Context context;
    private List<Item> items;
    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
       void onListItemClick(int clickedItemIndex);
   }

    public PostAdapter(Context context, List<Item> items,ListItemClickListener listener) {
       this.mOnClickListener=listener;
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.post_item,parent,false);
        return new PostViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Item item=items.get(position);
        //TODO
        String url="http://image.tmdb.org/t/p/w500/"+item.getImage();


        //TODO GLIDE

        Glide.with(context).load(url).into(holder.postImage);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView postImage;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postImage=itemView.findViewById(R.id.postImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int clickedPosition=getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);

        }
    }
}
