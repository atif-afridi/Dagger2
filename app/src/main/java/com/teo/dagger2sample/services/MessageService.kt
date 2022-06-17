package com.teo.dagger2sample.services

import com.teo.dagger2sample.components.IMessageService
import javax.inject.Inject

class MessageService @Inject constructor() : IMessageService {
    override fun getMessage(): String {
        return "Message service called."
    }
}