package com.example.musicplayerproject.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.musicplayerproject.R;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class AllRecyclerViewAdapterforCircle extends RecyclerView.Adapter<AllRecyclerViewAdapterforCircle.MyViewHolder> {

    private static final String TAG ="AllRecyclerViewAdapterC";

    private ArrayList<String> mNames2 = new ArrayList<>();
    private ArrayList<String> mImageUrls2 = new ArrayList<>();
    private Context mContext2;

    public AllRecyclerViewAdapterforCircle(Context mContext, ArrayList<String> mNames, ArrayList<String> mImageUrls) {
        this.mNames2 = mNames;
        this.mImageUrls2 = mImageUrls;
        this.mContext2 = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: createed.");
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_listitem_circle, parent, false);
        return new MyViewHolder(view2);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext2).asBitmap().load(mImageUrls2.get(position)).into(holder.circleImageView);
        holder.ctxt.setText(mNames2.get(position));
        holder.circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on image at pos: "+mNames2.get(position));
                Toast.makeText(mContext2,mNames2.get(position),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mNames2.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ctxt;
        CircleImageView circleImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.cimg);
            ctxt = itemView.findViewById(R.id.ctext);

        }
    }
}
