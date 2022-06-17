package com.teo.dagger2sample

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.teo.dagger2sample.components.IMessageService
import com.teo.dagger2sample.databinding.ActivityMainBinding
import com.teo.dagger2sample.services.CloudMessageService
import com.teo.dagger2sample.services.MessageService
import com.teo.dagger2sample.viewmodels.MainViewModel
import com.teo.dagger2sample.viewmodels.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    lateinit var mainViewModel: MainViewModel
    @Inject lateinit var viewModelFactory: MainViewModel.MainViewModelFactory

    /*private val viewModel: MainViewModel by viewModels {
        MainViewModel.providesFactory(
            assistedFactory = viewModelFactory,
            updateMsg = "hello devs"
        )
    }*/

//    @Inject
//    lateinit var mainViewModelFactory: MainViewModel.MainViewModelFactory
//    private val identifier: String = "hello devs."
//    private val mainViewModelManager: MainViewModel by lazy { mainViewModelFactory.create(identifier) }


    // First injecting our
    // viewmodel's factory interface
//    @Inject
//    lateinit var mainViewModelManager: MainViewModel.MainViewModelFactory


    @Inject lateinit var cloudFactory: CloudMessageService.MyCloudMessageServiceFactory
    @Inject lateinit var messageService: MessageService

    // TODO this cant state/data when kill or rotation.
    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory("Hello devs.")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // di
        (application as Dagger2Application).appComponent.injectIntoMainActivity(this)

//        val viewModelFactory = MainViewModel.providesFactory(viewModelFactory,"hello devs.")
//        val factoryMainViewModel  = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        // TODO to be fixed later
        val viewModelFactory = MainViewModel.providesFactory(viewModelFactory,"hello devs.")
        val factoryVModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        // TODO cant pass values with this solution.
        // with ViewModel Injection Framework
       /* mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        Log.d("TAG", "viewmodel data : ${mainViewModel.hello}")
        binding.messageTextView.text = mainViewModel.hello*/

        /* Viewmodel object creation with custom ViewModelFactory */
//        val viewModelFactory = MainViewModelFactory(MainViewModel(/* can pass parameters now */))
        // TODO View model injector
//        val viewModelFactory = MainViewModelFactory("hello devs runtime.")
//        val factoryMainViewModel  = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
//        Log.d("TAG", "factoryMainViewModel data : ${factoryMainViewModel.myMessage()}")
//        binding.messageTextView.text = factoryMainViewModel.updateMsg

//        val viewmodel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
//        binding.messageTextView.text = viewmodel.updateMsg

//        binding.messageTextView.text = mainViewModel.updateMsg
        binding.messageTextView.text = factoryVModel.myMessage()

    }

    fun setupService(config: String): IMessageService {
        return cloudFactory.create(config)
    }

}