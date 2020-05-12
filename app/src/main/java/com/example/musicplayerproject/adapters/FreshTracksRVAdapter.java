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

import com.bumptech.glide.Glide;
import com.example.musicplayerproject.R;

import java.util.ArrayList;

public class FreshTracksRVAdapter extends RecyclerView.Adapter<FreshTracksRVAdapter.MyViewHolder> {

    private static final String TAG = "FreshTracksRVAdapter";
    private Context mContext;
    private ArrayList<String> mFTNames = new ArrayList<>();
    private ArrayList<String> mFTImageUrls = new ArrayList<>();

    public FreshTracksRVAdapter(Context mContext, ArrayList<String> mFTNames, ArrayList<String> mFTImageUrls) {
        this.mContext = mContext;
        this.mFTNames = mFTNames;
        this.mFTImageUrls = mFTImageUrls;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.fresh_tracks_carditem, parent, false);
        return new MyViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(mContext).asBitmap().load(mFTImageUrls.get(position)).into(holder.ft_fomImage);
        holder.ft_fomNames.setText(mFTNames.get(position));
        holder.ft_fomImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on image at pos: "+mFTNames.get(position));
                Toast.makeText(mContext,mFTNames.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFTNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ft_fomImage;
        TextView ft_fomNames;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ft_fomImage = (ImageView)itemView.findViewById(R.id.ft_img);
            ft_fomNames = (TextView)itemView.findViewById(R.id.ft_text);
        }
    }
}
