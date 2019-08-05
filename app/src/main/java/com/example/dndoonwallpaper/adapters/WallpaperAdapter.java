package com.example.dndoonwallpaper.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.dndoonwallpaper.R;
import com.example.dndoonwallpaper.model.Wallpaper;

import java.util.List;

public class WallpaperAdapter extends RecyclerView.Adapter<WallpaperAdapter.WallpaperHolder> {

    List<Wallpaper> wallpapers;
    @Nullable
    private WallpaperAdapter.ClickListener listener;

    public WallpaperAdapter(List<Wallpaper> wallpapers) {
        this.wallpapers = wallpapers;
    }


    public void setListener(@NonNull ClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public WallpaperHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_wallpaper, viewGroup, false);
        return new WallpaperHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallpaperHolder holder, int position) {
        holder.bindTo(wallpapers.get(position));
    }

    @Override
    public int getItemCount() {
        return wallpapers.size();
    }

     class WallpaperHolder extends RecyclerView.ViewHolder{
        TextView titleTextView, ownerTextView;
        ImageView thumbnailImageView;
        ImageButton heartImageButton;

         WallpaperHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title);
            ownerTextView = itemView.findViewById(R.id.owner);
            thumbnailImageView = itemView.findViewById(R.id.thumbnail);
            heartImageButton = itemView.findViewById(R.id.heart);
        }

        void bindTo(Wallpaper wallpaper) {
            Glide.with(itemView)
                    .load(wallpaper.getThumbnail())
                    .apply(RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.AUTOMATIC))
                    .apply(RequestOptions.centerCropTransform())
                    .into(thumbnailImageView);
            titleTextView.setText(wallpaper.getTitle());
            ownerTextView.setText(wallpaper.getOwner());
            // TODO heartImageView
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface ClickListener{
        void onItemClick(int position);
    }
}
