package app.code.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import app.code.databinding.ItemProjectBinding
import app.code.item.Project

class ProjectsListAdapter: RecyclerView.Adapter<ProjectsListAdapter.MyViewHolder>() {
    class MyViewHolder(val viewBinding: ItemProjectBinding): RecyclerView.ViewHolder(viewBinding.root) {
    }

    private var projectsList: List<Project> = listOf()

    fun update(projects: List<Project>) {
        projectsList = projects
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewBinding = ItemProjectBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return projectsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewBinding.name.text = projectsList[position].name
    }
}