package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import java.util.Objects

private const val KEY_COLOR = "key_color"

class FragmentBA: Fragment() {

    private var color: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?, ): View? {
        val view = inflater.inflate(R.layout.fragment_ba, container, false)

        // Покрасте фон FragmentBA в полученный цвет.
        parentFragmentManager.setFragmentResultListener(KEY_COLOR, this) { _, bundle ->
            color = bundle.getInt(KEY_COLOR)
            view.setBackgroundColor(color)
        }

        val btnOpenFragmentBB = view.findViewById<Button>(R.id.btn_open_FragmentBB)

        // Если девайс находится в portrait ориентации, добавьте в FragmentBA кнопку,
        // в данном случае кнопку скрываем / показываем
        btnOpenFragmentBB.visibility = when (isPortrait()) {
            true -> View.VISIBLE
            false -> View.GONE
        }
        // по нажатию на которой будет открываться FragmentBB, на том же уровне иерархии, что и FragmentBA.
        btnOpenFragmentBB.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout_ba, FragmentBB(), "FragmentBB")
                .commit()
        }
        return view
    }
    // ориентация экрана
    private fun isPortrait(): Boolean =
        Objects.equals(Configuration.ORIENTATION_PORTRAIT, resources.configuration.orientation)

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COLOR, color)
    }

}