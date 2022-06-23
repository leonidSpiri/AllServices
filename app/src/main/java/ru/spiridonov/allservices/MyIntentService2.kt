package ru.spiridonov.allservices

import android.app.IntentService
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.delay

class MyIntentService2 : IntentService(NAME) {
    override fun onCreate() {
        super.onCreate()
        log("onCreate")
        setIntentRedelivery(true)
    }

    override fun onHandleIntent(p0: Intent?) {
        log("onHandleIntent")
        val page = p0?.getIntExtra(PAGE, 0) ?: 0
        for (i in 0 until 5) {
            Thread.sleep(1000)
            log("Timer: $i; page = $page")
        }
    }

    private fun log(msg: String) {
        Log.d("SERVICE_TAG", "MyIntentService2: $msg")
    }



    companion object {
        private const val NAME = "MyIntentService"
        private const val PAGE = "page"
        fun newIntent(context: Context, page:Int) =
             Intent(context, MyIntentService2::class.java).apply {
                    putExtra(PAGE, page)
             }

    }
}