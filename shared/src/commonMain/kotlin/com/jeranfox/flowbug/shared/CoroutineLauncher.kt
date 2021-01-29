package com.jeranfox.flowbug.shared

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CoroutineLauncher(
    private val flow: AbstractUnitFlow,
) {
    private val scope = MainScope()

    init {
        scope.launch {
            flow.collect {
                println("Collecting")
            }
        }
    }

    fun cancelScope() {
        println("Canceling scope")
        scope.cancel()
    }
}
