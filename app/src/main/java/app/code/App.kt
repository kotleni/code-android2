package app.code

import android.app.Application
import app.code.di.AppComponent
import app.code.di.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .factory()
            .create(applicationContext)
    }
}