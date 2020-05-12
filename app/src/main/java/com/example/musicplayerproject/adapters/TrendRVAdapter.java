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

public class TrendRVAdapter extends RecyclerView.Adapter<TrendRVAdapter.MyViewHolder> {

    private static final String TAG = "TrendRVAdapter";
    private ArrayList<Integer> mNumbers = new ArrayList<>();
    private ArrayList<String> mImageResources = new ArrayList<>();
    private ArrayList<Integer> mGradRes = new ArrayList<>();
    private Context mContext;

    public TrendRVAdapter(Context mContext, ArrayList<Integer> mNumbers, ArrayList<String> mImageResources, ArrayList<Integer> mGradRes) {
        this.mNumbers = mNumbers;
        this.mImageResources = mImageResources;
        this.mGradRes = mGradRes;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called");
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_carditem, parent, false);
        return new MyViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Glide.with(mContext).asBitmap().load(mImageResources.get(position)).into(holder.image);
        holder.gradient.setImageResource(mGradRes.get(position));
        holder.number.setText(String.valueOf(mNumbers.get(position)));
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on image at pos: "+mNumbers.get(position));
                Toast.makeText(mContext,String.valueOf(mNumbers.get(position)),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNumbers.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image, gradient;
        TextView number;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.trend_img);
            gradient = itemView.findViewById(R.id.trend_grad);
            number = itemView.findViewById(R.id.trend_no);
        }
    }


}
