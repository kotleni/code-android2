package app.code

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import app.code.di.AppComponent

fun Fragment.getAppComponent(): AppComponent =
    (requireContext().applicationContext as App).appComponent
fun Activity.getAppComponent(): AppComponent =
    (applicationContext as App).appComponent

private const val safeLetters = "qwertyuiopasdfghjklzxcvbnm"
private const val safeChars = "=;'_"
private const val safeNumbers = "0123456789"
fun String.removeAllUnsafe(allowSafeChars: Boolean = false, allowSafeNumbers: Boolean = false): String {
    val builder = StringBuilder()
    this.forEach {
        if(it in safeLetters)
            builder.append(it)
        else if(it in safeChars && allowSafeChars)
            builder.append(it)
        else if (it in safeNumbers && allowSafeNumbers)
            builder.append(it)
    }
    return builder.toString()
}

fun String?.forceEmpty(): String {
    if(this == null) return ""
    return this
}