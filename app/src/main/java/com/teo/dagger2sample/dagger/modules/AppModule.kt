package com.teo.dagger2sample.dagger.modules

import android.app.Application
import android.content.Context
import com.teo.dagger2sample.components.IMessageService
import com.teo.dagger2sample.services.MessageService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

// specify the main-component/module for DAG mapping
/* provide dependencies for app level
* It is normal to have multiple Dagger modules in a project,
* */
@Module
class AppModule(private val app: Application) {

    @Singleton
    /*The @Singleton annotation is not part of the Dagger API. It’s contained inside the javax package you added to your build.gradle at the beginning. It tells Dagger that there should only be a single instance of that dependency. So when generating the code Dagger will handle all the logic for you, and you won’t write all the boilerplate code to check if another instance of the object is already available.*/
    @Provides // The @Provides annotation tells Dagger that the method provides a certain type of dependency, in this case, a Context object.
    /*Note: The method names for the providers, such as provideContext(), are not important and can be named anything you like. Dagger only looks at the return type. Using provide as a prefix is a common convention.*/
    fun provideContext(): Context = app

    @Singleton
    @Provides
    fun provideMessageService(): IMessageService = MessageService()

    @Provides
    fun provideCloudMessage() : String = "Cloud message service called."

    // TODO check dynamic input for objects...

//    @Singleton
//    @Provides
//    fun provideCloudMessageService(): IMessageService = CloudMessageService(provideCloudMessage())


}