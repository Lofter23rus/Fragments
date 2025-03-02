package otus.gpb.homework.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import java.util.Objects

private const val KEY_COLOR = "key_color"

class FragmentBB: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bb, container, false)

        // перерисуем fragmentBA с новым цветом
        view.findViewById<Button>(R.id.btn_SendColor)
            .setOnClickListener {
                val args = Bundle()
                args.putInt(KEY_COLOR, ColorGenerator.generateColor())
                if (isPortrait()) {
                    // Если девайс находится в portrait ориентации,
                    // В FragmentBB добавьте кнопку, которая получит цвет из рандомайзера ColorGenerator
                    // и вернет результат в FragmentBA. Как и в пункте 1, покрасте фон FragmentBA в полученный цвет.
                    val fragmentBA = FragmentBA()
                    fragmentBA.arguments = args
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.frameLayout_ba, fragmentBA).apply {
                            fragmentBA.arguments = args
                            parentFragmentManager.setFragmentResult(KEY_COLOR, args)
                        }
                        .commit()
                }
                else {
                    // Если девайс находится в landscape ориентации, то расположите фрагменты на одном уровне иерархии.
                    // В фрагмент FragmentBB добавьте кнопку, по нажатию на которую программа получит цвет из рандомайзера ColorGenerator
                    // и передаст его в FragmentBA, используя FragmentResultListener.
                    parentFragmentManager.setFragmentResult(KEY_COLOR, args)
                }
            }

        return view
    }
    // ориентация экрана
    private fun isPortrait(): Boolean =
        Objects.equals(Configuration.ORIENTATION_PORTRAIT, resources.configuration.orientation)
}