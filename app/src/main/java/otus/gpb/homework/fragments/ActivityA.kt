package otus.gpb.homework.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityA : AppCompatActivity() {

    //private lateinit var fragmentA: FragmentA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        // По клику на кнопку запустите фрагмент транзакцию которая открывает FragmentA.
        // в нашем случае "По клику на кнопку" === "при запуске Actity A"
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_FragmentA, FragmentA())
            .addToBackStack(null)
            .commit()
    }
}