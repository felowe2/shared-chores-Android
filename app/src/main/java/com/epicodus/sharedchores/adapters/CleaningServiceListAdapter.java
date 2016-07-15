package com.epicodus.sharedchores.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.CleaningService;
import com.epicodus.sharedchores.ui.CleaningServiceDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 7/14/16.
 */
public class CleaningServiceListAdapter extends RecyclerView.Adapter<CleaningServiceListAdapter.CleaningServiceViewHolder> {
    private ArrayList<CleaningService> mCleaningServices = new ArrayList<>();
    private Context mContext;
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    public CleaningServiceListAdapter(Context context, ArrayList<CleaningService> cleaningServices) {
        mContext = context;
        mCleaningServices = cleaningServices;
    }

    @Override
    public CleaningServiceListAdapter.CleaningServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cleaning_service_list, parent, false);

        CleaningServiceViewHolder viewHolder = new CleaningServiceViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CleaningServiceListAdapter.CleaningServiceViewHolder holder, int position) {
        holder.bindCleaningService(mCleaningServices.get(position));
    }

    @Override
    public int getItemCount() {
        return mCleaningServices.size();
    }

    public class CleaningServiceViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.cleaningServiceImageView) ImageView mCleaningServiceImageView;
        @Bind(R.id.cleaningServiceNameTextView) TextView mCleaningServiceNameTextView;
        @Bind(R.id.ratingTextView) TextView mRatingTextView;
        @Bind(R.id.reviewsTextView) TextView mReviewsTextView;
        private Context mContext;

        public CleaningServiceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(mContext, CleaningServiceDetailActivity.class);
                    intent.putExtra("position", itemPosition + "");
                    intent.putExtra("cleaningServices", Parcels.wrap(mCleaningServices));
                    mContext.startActivity(intent);

                }
            });
        }

        public void bindCleaningService(CleaningService cleaningService) {

            Picasso.with(mContext)
                    .load(cleaningService.getImageUrl())
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mCleaningServiceImageView);

            mCleaningServiceNameTextView.setText(cleaningService.getName());
            mReviewsTextView.setText("Reviews: " + cleaningService.getReviews());
            mRatingTextView.setText("Rating: " + cleaningService.getRating() + "/5");
        }

    }
}

