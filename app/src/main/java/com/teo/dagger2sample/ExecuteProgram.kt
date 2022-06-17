package com.teo.dagger2sample

import android.util.Log
import com.teo.dagger2sample.components.IMessageService

class ExecuteProgram(private var iMessageService: IMessageService) {

    fun displayMessage() {
        val message = iMessageService.getMessage()
        Log.d("TAG", "result is : $message")
    }
    
}