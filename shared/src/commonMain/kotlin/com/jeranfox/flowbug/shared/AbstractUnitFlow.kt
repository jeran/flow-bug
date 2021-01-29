package com.jeranfox.flowbug.shared

import kotlinx.coroutines.flow.*

interface UnitFlow : Flow<Unit>

abstract class AbstractUnitFlow : AbstractFlow<Unit>() {

    private val sharedFlow = MutableSharedFlow<Unit>(extraBufferCapacity = 1)

    override suspend fun collectSafely(collector: FlowCollector<Unit>) {
        collector.emitAll(sharedFlow)
    }

    fun emit() {
        sharedFlow.tryEmit(Unit)
    }
}
