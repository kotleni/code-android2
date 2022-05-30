package app.code.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import app.code.R
import app.code.databinding.ActivityMainBinding
import app.code.databinding.FragmentProjectsBinding
import app.code.model.ProjectsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get view binding
        viewBinding = ActivityMainBinding.inflate(layoutInflater)

        // transit to projects fragment
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<ProjectsFragment>(R.id.container)
        }
    }
}

class ProjectsFragment: Fragment() {
    private lateinit var viewBinding: FragmentProjectsBinding
    private val model: ProjectsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewBinding = FragmentProjectsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}