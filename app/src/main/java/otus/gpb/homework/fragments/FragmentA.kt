package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment


class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        val btnOpenFragmentAA = view.findViewById<Button>(R.id.btn_open_FragmentAA)

        // Реализуйте обработку нажатия на кнопку “Назад”, используя OnBackPressedDispatcher,
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // таким образом, что
                    if (childFragmentManager.backStackEntryCount == 1) {
                        // После того как размер стека = 1, закрывайте активити.
                        requireActivity().finish()
                    } else {
                        //по нажатию из стека фрагментов удаляется один фрагмент
                        childFragmentManager.popBackStack()
                    }
                }
            }
        )

        //В FragmentA добавьте кнопку, которая открывает фрагмент FragmentAA,
        // при этом он должен быть child фрагментом для FragmentA.
        btnOpenFragmentAA.setOnClickListener {
            // проверяем стек транзакций
            if (childFragmentManager.backStackEntryCount == 0) {
                // стек пустой - создадим FragmentAA
                val fragmentAa = FragmentAA()
                val args = Bundle()
                // При открытии FragmentAA, передайте в него цвет, полученный из рандомайзера ColorGenerator
                args.putInt("color", ColorGenerator.generateColor())
                fragmentAa.arguments = args
                childFragmentManager.beginTransaction()
                    .add(R.id.layout_FragmentA, fragmentAa)
                    .addToBackStack(null)
                    .commit()
            }
        }

        return view
    }
}
