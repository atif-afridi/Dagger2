package com.teo.dagger2sample.dagger

import com.teo.dagger2sample.MainActivity
import com.teo.dagger2sample.dagger.modules.AppModule
import com.teo.dagger2sample.dagger.modules.ViewModelModule
import com.teo.dagger2sample.viewmodels.MainViewModel
import com.teo.dagger2sample.viewmodels.MainViewModelFactory
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class/*, MainViewModelFactory::class*/])
interface AppComponent {

    fun injectIntoMainActivity(target: MainActivity)

    // inject your view models
//    fun inject(mainViewModel: MainViewModel)

}

/*
* You’ve told Dagger that AppComponent is a singleton component interface for the app.
* The @Component annotation takes a list of modules as an input.
* You’re using the literal array syntax available in Kotlin, [AppModule::class].
* */

/*
* The component is used to connect objects to their dependencies, typically by use of overridden inject() methods.
* In order to use the component, it must be accessible from the parts of the app that need injection.
* Typically, that will happen from the app Application subclass, as follows.
* */