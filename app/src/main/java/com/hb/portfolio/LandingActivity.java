package com.hb.portfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.hb.portfolio_library.DeveloperProfile;
import com.hb.portfolio_library.Portfolio;
import com.hb.portfolio_library.Project;

import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity {
    private Button portfolioBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        portfolioBtn=(Button)findViewById(R.id.portfolio_btn);
        portfolioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPortfolio();
            }
        });
    }

    private void startPortfolio(){

        List<Project> projectList = new ArrayList<>();

        Project pollstap = new Project();
        pollstap.setProjectName("EC2017");
        pollstap.setProjectDesc("Annual Fest app to register for various events and manage your tickets.");
        pollstap.setProjectLink("https://play.google.com/store/apps/details?id=dev.elementsculmyca.ec2017");

        Project popupBubble = new Project();
        popupBubble.setProjectName("JustTouch");
        popupBubble.setProjectDesc("Android app to read and write into an NFC tag.");
        popupBubble.setProjectLink("https://github.com/HemantGTX950/JustTouch");

        projectList.add(pollstap);
        projectList.add(popupBubble);

        List<DeveloperProfile> developerProfileList=new ArrayList<>();
        DeveloperProfile github=new DeveloperProfile();

        github.setIcon(R.drawable.github_logo);
        github.setProfileLink("https://github.com/HemantGTX950");

        DeveloperProfile linkedin=new DeveloperProfile();

        linkedin.setIcon(R.drawable.linkedin_logo);
        linkedin.setProfileLink("https://www.linkedin.com/in/hemantbansal950");
        developerProfileList.add(github);
        developerProfileList.add(linkedin);



        new Portfolio.Builder(LandingActivity.this)
                .withProfiles(developerProfileList)
                .withProjects(projectList)
                .build()
                .start();

    }
}
