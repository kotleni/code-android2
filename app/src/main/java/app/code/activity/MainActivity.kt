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
import androidx.lifecycle.Observer
import app.code.R
import app.code.databinding.ActivityMainBinding
import app.code.databinding.FragmentProjectsBinding
import app.code.fragment.ProjectsFragment
import app.code.item.Project
import app.code.model.ProjectsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog

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
