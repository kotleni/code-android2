package app.code

import android.app.Activity
import androidx.fragment.app.Fragment
import app.code.di.AppComponent

fun Fragment.getAppComponent(): AppComponent =
    (requireContext().applicationContext as App).appComponent
fun Activity.getAppComponent(): AppComponent =
    (applicationContext as App).appComponent