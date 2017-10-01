package com.hb.portfolio_library;

import java.io.Serializable;

/**
 * Created by hemba on 10/2/2017.
 */

public class DeveloperProfile implements Serializable {
    private String profileLink;
    private int mIcon;

    public String getProfileLink() {
        return profileLink;
    }

    public void setProfileLink(String profileLink) {
        this.profileLink = profileLink;
    }

    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int icon) {
        mIcon = icon;
    }
}
