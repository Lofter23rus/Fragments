package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import java.util.Objects

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        // ландшафтный режим - отобразить оба фрагмента одновременно
        if (Objects.equals(Configuration.ORIENTATION_LANDSCAPE, resources.configuration.orientation)) {
            findViewById<FrameLayout>(R.id.frameLayout_bb).visibility = View.VISIBLE
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout_ba, FragmentBA())
                .replace(R.id.frameLayout_bb, FragmentBB())
                .commit()
        }
        else {
            // портретный режим режим - отобразить только один фрагмент
            findViewById<FrameLayout>(R.id.frameLayout_bb).visibility = View.GONE
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout_ba, FragmentBA())
                .commit()
        }
    }

    private fun isLandscape() =
        Objects.equals(Configuration.ORIENTATION_LANDSCAPE, resources.configuration.orientation)
}