package com.example.onlineexhibitionplatform;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PoemAdapter extends RecyclerView.Adapter<PoemAdapter.ViewHolder> {

    private ArrayList<UserData> userList;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView tvTitle;
        protected TextView tvAuthor;


        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            this.tvTitle = (TextView) view.findViewById(R.id.tv_title);
            this.tvAuthor = (TextView) view.findViewById(R.id.tv_author);
        }

    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet ArrayList<UserData> containing the data to populate views to be used
     * by RecyclerView.
     */
    public PoemAdapter(ArrayList<UserData> dataSet) {
        this.userList = dataSet;
    }



    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycle_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.tvTitle.setText(userList.get(position).getTitle());
        viewHolder.tvAuthor.setText(userList.get(position).getAuthor());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return (null != userList ? userList.size() : 0);
    }



}
