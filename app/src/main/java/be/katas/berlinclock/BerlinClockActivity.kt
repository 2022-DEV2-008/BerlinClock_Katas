package be.katas.berlinclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Single activity Of Berlin class which holds fragment using navigation controller
 */

class BerlinClockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berlin)
    }
}