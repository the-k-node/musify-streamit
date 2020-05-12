package com.example.musicplayerproject.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayerproject.R;

import java.util.ArrayList;

public class PlayListRVAdapter extends RecyclerView.Adapter<PlayListRVAdapter.MyViewHolder> {

    private static final String TAG = "PlayListRVAdapter";
    Context mContext;
    private ArrayList<String> mPlaylistNames = new ArrayList<>();
    private ArrayList<Integer> mImageResources = new ArrayList<>();

    public PlayListRVAdapter(Context mContext, ArrayList<String> mPlaylistNames, ArrayList<Integer> mImageResources) {
        this.mContext = mContext;
        this.mPlaylistNames = mPlaylistNames;
        this.mImageResources = mImageResources;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Playlist onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlists_carditem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.grad_image.setImageResource(mImageResources.get(position));
        holder.pl_txt.setText(mPlaylistNames.get(position));
        holder.grad_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on image at pos: "+mPlaylistNames.get(position));
                Toast.makeText(mContext,mPlaylistNames.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPlaylistNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView grad_image;
        TextView pl_txt;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            grad_image = (ImageView)itemView.findViewById(R.id.play_card);
            pl_txt = (TextView)itemView.findViewById(R.id.playlist_txt);
        }
    }
}
