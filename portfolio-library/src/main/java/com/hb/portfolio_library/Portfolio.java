package com.hb.portfolio_library;

import android.content.Context;
import android.content.Intent;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hemba on 10/2/2017.
 */

public class Portfolio {
    private Context mContext;
    private String mDeveloperName;
    private List<DeveloperProfile> mDeveloperProfileList;
    private List<Project> mProjectList;
    Portfolio(Builder builder){
        mContext=builder.mContext;
        mDeveloperProfileList=builder.mDeveloperProfiles;
        mProjectList=builder.mProjects;
        mDeveloperName=builder.mDeveloperName;

    }

    public static class Builder {
        private Context mContext;
        private List<DeveloperProfile> mDeveloperProfiles;
        private List<Project> mProjects;
        private String mDeveloperName;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder withProfiles(List<DeveloperProfile> developerProfiles) {
            this.mDeveloperProfiles = developerProfiles;
            return this;
        }
        public Builder withProjects(List<Project> projects){
            this.mProjects=projects;
            return this;
        }
        public Builder withDeveloperName(String developerName){
            mDeveloperName=developerName;
            return this;
        }
        public Portfolio build(){
            return new Portfolio(this);
        }
    }
    public void start(){
        Intent i=new Intent(mContext,MainActivity.class);
        i.putExtra(ConstantUtils.PROJECTS,(Serializable)mProjectList);
        i.putExtra(ConstantUtils.PROFILES,(Serializable)mDeveloperProfileList);
        i.putExtra(ConstantUtils.DEVELOPER_NAME,mDeveloperName);
        mContext.startActivity(i);

    }
}
