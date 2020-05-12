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

public class AllRecyclerViewLanguageAdapter extends RecyclerView.Adapter<AllRecyclerViewLanguageAdapter.MyViewHolder2> {

    private static final String TAG ="AllRecyleViewAdapter";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageResources = new ArrayList<>();
    private Context mContext;

    public AllRecyclerViewLanguageAdapter(Context mContext, ArrayList<String> mNames, ArrayList<Integer> mImageResources) {
        this.mNames = mNames;
        this.mContext = mContext;
        this.mImageResources = mImageResources;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: called.");
        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.language_listitem, parent, false);
        return new MyViewHolder2(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull AllRecyclerViewLanguageAdapter.MyViewHolder2 holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.card_image.setImageResource(mImageResources.get(position));
        holder.txt.setText(mNames.get(position));
        holder.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on image at pos: "+mNames.get(position));
                Toast.makeText(mContext,mNames.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class MyViewHolder2 extends RecyclerView.ViewHolder{
        TextView txt;
        ImageView card_image;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.text);
            card_image = itemView.findViewById(R.id.lang_card);
        }
    }

}
