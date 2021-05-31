package com.example.touristy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder>
{
    // Declaring variables.
    String destinationData[];
    int imageData[];
    Context context;
    private OnColClickListener listener;

    public VerticalAdapter(Context contxt, String destinations[], int images[], OnColClickListener clickListener)
    {
        context = contxt;
        destinationData = destinations;
        imageData = images;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.vertical_column, parent, false);
        return new VerticalViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position)
    {
        holder.text1.setText(destinationData[position]);
        holder.pictures.setImageResource(imageData[position]);

    }

    @Override
    public int getItemCount()
    {
        return destinationData.length;
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        // Declaring variables.
        TextView text1;
        ImageView pictures;
        OnColClickListener onColClickListener;

        public VerticalViewHolder(@NonNull View itemView, OnColClickListener onColClickListener)
        {
            super(itemView);
            // Initialising variables.
            text1 = itemView.findViewById(R.id.destinationName);
            pictures = itemView.findViewById(R.id.destinationImageView);

            this.onColClickListener = onColClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            onColClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnColClickListener
    {
        void onItemClick (int position);
    }
}
