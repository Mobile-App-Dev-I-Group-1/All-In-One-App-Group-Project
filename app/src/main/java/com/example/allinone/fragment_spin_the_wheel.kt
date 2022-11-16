package com.example.allinone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_spin_the_wheel.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_spin_the_wheel : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_spin_the_wheel, container, false)
        val button_spin = view.findViewById<Button>(R.id.button_spin_the_wheel)
        val button_add = view.findViewById<Button>(R.id.button_add_item)
        val editText_item = view.findViewById<EditText>(R.id.editText_addItem)
        val imageView_wheel = view.findViewById<ImageView>(R.id.imageView_wheel)
        val textView_title = view.findViewById<TextView>(R.id.textView_wheel_title)
        var item = ""
        var itemArray = Array(20) {""}
        var itemArrayIndex = 0
        var rotation = 293
        button_spin.setOnClickListener {
            imageView_wheel.animate().rotation(rotation.toFloat()).setDuration(2000).start()
            rotation = rotation + 330
            var random_number = (0..itemArrayIndex - 1).random()
//            Toast.makeText(context, itemArray.get(random_number), Toast.LENGTH_SHORT).show()
            textView_title.text = itemArray.get(random_number)
        }
        button_add.setOnClickListener{
            item = editText_item.text.toString()
            editText_item.setText("")
            itemArray.set(itemArrayIndex, item)
//            Toast.makeText(context, itemArray.get(itemArrayIndex), Toast.LENGTH_SHORT).show()
            itemArrayIndex = itemArrayIndex + 1
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_spin_the_wheel.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_spin_the_wheel().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}