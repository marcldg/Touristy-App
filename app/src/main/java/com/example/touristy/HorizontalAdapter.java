package com.example.touristy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder>
{
    // Declaring variables.
    String destinationData[], descriptionData[];
    int imageData[];
    Context context;
    private OnRowClickListener listener;

    public HorizontalAdapter(Context contxt, String destinations[], String description[], int images[], OnRowClickListener clickListener)
    {
        context = contxt;
        destinationData = destinations;
        descriptionData = description;
        imageData = images;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.horizontal_row, parent, false);
        return new HorizontalAdapter.HorizontalViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position)
    {
        holder.text1.setText(destinationData[position]);
        holder.text2.setText(descriptionData[position]);
        holder.pictures.setImageResource(imageData[position]);
    }

    @Override
    public int getItemCount()
    {
        return descriptionData.length;
    }

    public class HorizontalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        // Declaring variables.
        TextView text1, text2;
        ImageView pictures;
        OnRowClickListener onRowClickListener;

        public HorizontalViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener)
        {
            super(itemView);

            // Initialising variables.
            text1 = itemView.findViewById(R.id.destinationName);
            text2 = itemView.findViewById(R.id.description);
            pictures = itemView.findViewById(R.id.destinationImageView);

            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            onRowClickListener.onDestinationClick(getAdapterPosition());
        }
    }

    public interface OnRowClickListener
    {
        void onDestinationClick (int position);
    }
}
