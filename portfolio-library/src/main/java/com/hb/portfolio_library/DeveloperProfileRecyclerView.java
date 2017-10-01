package com.hb.portfolio_library;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by hemba on 10/2/2017.
 */

public class DeveloperProfileRecyclerView extends RecyclerView.Adapter<DeveloperProfileRecyclerView.ProfileHolder> {
    private List<DeveloperProfile> mDeveloperProfiles;
    private Context mContext;
    private ProfileClickListener mProfileClickListener;

    public DeveloperProfileRecyclerView(List<DeveloperProfile> developerProfiles, Context context) {
        mDeveloperProfiles = developerProfiles;
        mContext = context;
    }

    @Override
    public ProfileHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_profile_layout, parent, false);
        return new ProfileHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileHolder holder, int position) {
        holder.profileIcon.setImageResource(mDeveloperProfiles.get(position).getIcon());

    }

    @Override
    public int getItemCount() {
        return mDeveloperProfiles.size();
    }

    protected class ProfileHolder extends RecyclerView.ViewHolder {
        private ImageView profileIcon;

        public ProfileHolder(View itemView) {
            super(itemView);
            profileIcon = (ImageView) itemView.findViewById(R.id.profile_icon);
            profileIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mProfileClickListener != null) {
                        mProfileClickListener.OnProfileClicked(mDeveloperProfiles.get(getAdapterPosition()).getProfileLink());
                    }
                }
            });
        }
    }

    public void setProfileClickListener(ProfileClickListener profileClickListener) {
        mProfileClickListener = profileClickListener;

    }

    interface ProfileClickListener {
        void OnProfileClicked(String s);
    }
}
