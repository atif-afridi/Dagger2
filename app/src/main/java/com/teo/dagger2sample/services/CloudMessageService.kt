package com.teo.dagger2sample.services

import com.teo.dagger2sample.components.IMessageService
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject


// TODO why cant we set default value to objects...
class CloudMessageService  @AssistedInject constructor(@Assisted var _message: String) : IMessageService {

    override fun getMessage(): String {
//        return "Cloud message service called."
        return _message
    }

    @AssistedFactory
    interface MyCloudMessageServiceFactory {
        fun create(dynamicInput: String): CloudMessageService
    }
}