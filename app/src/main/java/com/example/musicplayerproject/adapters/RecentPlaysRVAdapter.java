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

public class RecentPlaysRVAdapter extends RecyclerView.Adapter<RecentPlaysRVAdapter.MyViewHolder>{


    private static final String TAG = "RecentPlaysRVAdapter";
    Context mContext;
    private ArrayList<String> mRPlistNames = new ArrayList<>();
    private ArrayList<String> mRPImageRes = new ArrayList<>();
    private ArrayList<Integer> mRPGradResources = new ArrayList<>();

    public RecentPlaysRVAdapter(Context mContext, ArrayList<String> mRPlistNames, ArrayList<String> mRPImageRes, ArrayList<Integer> mRPGradResources) {
        this.mContext = mContext;
        this.mRPlistNames = mRPlistNames;
        this.mRPImageRes = mRPImageRes;
        this.mRPGradResources = mRPGradResources;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.recentplays_carditem, parent, false);
        return new MyViewHolder(view3);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        Glide.with(mContext).asBitmap().load(mRPImageRes.get(position)).into(holder.album_covers);
        holder.grad_image2.setImageResource(mRPGradResources.get(position));
        holder.rp_txt2.setText(mRPlistNames.get(position));
        holder.grad_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on image at pos: "+mRPlistNames.get(position));
                Toast.makeText(mContext,mRPlistNames.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRPlistNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView grad_image2, album_covers;
        TextView rp_txt2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            grad_image2 = (ImageView)itemView.findViewById(R.id.rec_grad);
            rp_txt2 = (TextView)itemView.findViewById(R.id.rp_title);
            album_covers = (ImageView)itemView.findViewById(R.id.rp_coverImg);
        }
    }
}
