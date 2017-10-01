package com.hb.portfolio_library;

import android.content.Intent;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DeveloperProfileRecyclerView.ProfileClickListener, ProjectsRecyclerView.ProjectClickListener {

    private RecyclerView mProfileRecycler;
    private RecyclerView mProjectsRecycler;
    private CardView mProfilesContainer;
    private FrameLayout mProjectContainer;
    private List<DeveloperProfile> mDeveloperProfiles;
    private List<Project> mProjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getDeveloperName();
        getProfiles();
        getProjects();
    }

    private void getDeveloperName(){
        Intent i=getIntent();
        String name=i.getStringExtra(ConstantUtils.DEVELOPER_NAME);
        if(name!=null){
            setTitle(name);
        }
    }
    private void getProjects() {
        Intent i = getIntent();
        mProjects = (List<Project>) i.getSerializableExtra(ConstantUtils.PROJECTS);
        if ((mProjects == null) || (mProjects.size() < 0)) {
            mProjectContainer.setVisibility(View.INVISIBLE);
        } else {
            ProjectsRecyclerView projectsRecyclerView=new ProjectsRecyclerView(MainActivity.this, mProjects);
            projectsRecyclerView.setOnProjectClickListener(this);
            mProjectsRecycler.setAdapter(projectsRecyclerView);
        }


    }

    private void getProfiles() {
        Intent i = getIntent();
        mDeveloperProfiles = (List<DeveloperProfile>) i.getSerializableExtra(ConstantUtils.PROFILES);
        if ((mDeveloperProfiles == null) || (mDeveloperProfiles.size() < 0)) {
            mProfilesContainer.setVisibility(View.INVISIBLE);
        } else {
            DeveloperProfileRecyclerView developerProfileRecyclerView=new DeveloperProfileRecyclerView(mDeveloperProfiles, MainActivity.this);
            developerProfileRecyclerView.setProfileClickListener(this);
            mProfileRecycler.setAdapter(developerProfileRecyclerView);
        }


    }

    private void init() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mProfilesContainer = (CardView) findViewById(R.id.profiles_container);
        mProjectContainer=(FrameLayout)findViewById(R.id.project_container);
        mProfileRecycler = (RecyclerView) findViewById(R.id.developer_profiles_recycler_view);
        mProjectsRecycler = (RecyclerView) findViewById(R.id.projects_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        mProfileRecycler.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManagerV = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        mProjectsRecycler.setLayoutManager(linearLayoutManagerV);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void openLink(String s){
        if ((s!=null)&&(s.length()>0)){
            CustomTabsIntent.Builder builder=new CustomTabsIntent.Builder();
            builder.setToolbarColor(ContextCompat.getColor(MainActivity.this,R.color.cardview_dark_background));
            CustomTabsIntent customTabsIntent=builder.build();
            customTabsIntent.launchUrl(MainActivity.this, Uri.parse(s));
        }
    }

    @Override
    public void OnProfileClicked(String s) {
        openLink(s);
    }

    @Override
    public void projectClicked(String url) {
        openLink(url);
    }
}
