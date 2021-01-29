package com.jeranfox.flowbug.androidApp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.jeranfox.flowbug.shared.CoroutineLauncher

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flow = ConcreteUnitFlow()
        val coroutineLauncher = CoroutineLauncher(flow)

        findViewById<View>(R.id.cancel_scope).setOnClickListener {
            coroutineLauncher.cancelScope()
        }

        findViewById<View>(R.id.emit).setOnClickListener {
            flow.emit()
        }
    }
}
