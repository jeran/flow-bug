package com.jeranfox.flowbug.shared

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CoroutineLauncher(
    private val flow: AbstractUnitFlow,
) {
    private val scope1 = MainScope()
    private val scope2 = MainScope()

    init {
        scope1.launch {
            flow.collect {
                println("Collecting on scope1")
            }
        }

        scope2.launch {
            flow.collect {
                println("Collecting on scope2")
            }
        }
    }

    fun cancelScope() {
        println("Canceling scope1")
        scope1.cancel()
    }
}
