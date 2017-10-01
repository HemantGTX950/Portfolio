package com.hb.portfolio_library;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hemba on 10/2/2017.
 */

public class ProjectsRecyclerView extends RecyclerView.Adapter<ProjectsRecyclerView.ProjectHolder> {
    private Context mContext;
    private List<Project> mProjects;
    private ProjectClickListener mProjectClickListener;

    public ProjectsRecyclerView(Context context, List<Project> projects) {
        mContext = context;
        mProjects = projects;
    }

    @Override
    public ProjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_project_layout, parent, false);
        return new ProjectHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectHolder holder, int position) {
        holder.title.setText(mProjects.get(position).getProjectName());
        holder.desc.setText(mProjects.get(position).getProjectDesc());
    }

    @Override
    public int getItemCount() {
        return (mProjects != null) ? mProjects.size() : 0;
    }

    public void setOnProjectClickListener(ProjectClickListener ProjectClickListener) {
        mProjectClickListener = ProjectClickListener;
    }

    class ProjectHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView desc;
        private CardView projectContainer;

        public ProjectHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.project_name_text_view);
            desc = (TextView) itemView.findViewById(R.id.project_desc_text_view);
            projectContainer = (CardView) itemView.findViewById(R.id.project_container);
            projectContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mProjectClickListener!=null){
                        mProjectClickListener.projectClicked(mProjects.get(getAdapterPosition()).getProjectLink());
                    }
                }
            });

        }
    }

    interface ProjectClickListener {
        void projectClicked(String url);
    }

}
