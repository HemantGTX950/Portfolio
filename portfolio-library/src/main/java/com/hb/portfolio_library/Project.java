package com.hb.portfolio_library;

import java.io.Serializable;

/**
 * Created by hemba on 10/2/2017.
 */
public class Project implements Serializable {
    private String ProjectName;
    private String ProjectDesc;
    private String ProjectLink;

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getProjectDesc() {
        return ProjectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        ProjectDesc = projectDesc;
    }

    public String getProjectLink() {
        return ProjectLink;
    }

    public void setProjectLink(String projectLink) {
        ProjectLink = projectLink;
    }
}
