package com.epicodus.sharedchores.ui.api;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.sharedchores.R;
import com.epicodus.sharedchores.models.CleaningService;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CleaningServiceDetailFragment extends Fragment implements View.OnClickListener {
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;

    @Bind(R.id.cleaningServiceImageView)
    ImageView mImageLabel;
    @Bind(R.id.reviewsTextView)
    TextView mReviewsLabel;
    @Bind(R.id.cleaningServiceNameTextView)
    TextView mNameLabel;
    @Bind(R.id.ratingTextView)
    TextView mRatingLabel;
    @Bind(R.id.websiteTextView)
    TextView mWebsiteLabel;
    @Bind(R.id.phoneTextView)
    TextView mPhoneLabel;
    @Bind(R.id.addressTextView)
    TextView mAddressLabel;

    private CleaningService mCleaningService;

    public static CleaningServiceDetailFragment newInstance(CleaningService cleaningService) {
        CleaningServiceDetailFragment cleaningServiceDetailFragment = new CleaningServiceDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("cleaningService", Parcels.wrap(cleaningService));
        cleaningServiceDetailFragment.setArguments(args);
        return cleaningServiceDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCleaningService = Parcels.unwrap(getArguments().getParcelable("cleaningService"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cleaning_service_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext())
                .load(mCleaningService.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mImageLabel);

        mNameLabel.setText(mCleaningService.getName());
        mReviewsLabel.setText("Reviews: " + Integer.toString(mCleaningService.getReviews()));
        mRatingLabel.setText(Double.toString(mCleaningService.getRating()) + "/5");
        mPhoneLabel.setText(mCleaningService.getPhone());
        mAddressLabel.setText(android.text.TextUtils.join(", ", mCleaningService.getAddress()));

        mWebsiteLabel.setOnClickListener(this);
        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mCleaningService.getWebsite()));
            startActivity(webIntent);
        }
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + mCleaningService.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + mCleaningService.getLatitude()
                            + "," + mCleaningService.getLongitude()
                            + "?q=(" + mCleaningService.getName() + ")"));
            startActivity(mapIntent);
        }

    }
}
