package otus.gpb.homework.fragments

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Реализуйте кнопки перехода в активити с фрагментами в MainActivity.
        findViewById<Button>(R.id.btn_open_ActivityA).setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }

        // Реализуйте кнопки перехода в активити с фрагментами в MainActivity.
        findViewById<Button>(R.id.btn_open_ActivityB).setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }
    }
}