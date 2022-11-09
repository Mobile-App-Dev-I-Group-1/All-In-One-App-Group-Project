package com.example.allinone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlin.math.roundToInt
import kotlin.math.roundToLong

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_rng.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_rng : Fragment() {
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
        val view =  inflater.inflate(R.layout.fragment_rng, container, false)
        val button_rng = view.findViewById<Button>(R.id.button_rng)
        var editText = view.findViewById<EditText>(R.id.editText_rng)
        var imageView_rng = view.findViewById<ImageView>(R.id.imageView_rng)
        var textView_rng_number = view.findViewById<TextView>(R.id.textView_rng_number)
        var textView_chance = view.findViewById<TextView>(R.id.textView_chance)
        var random_number = 0
        var chance = 0.00
        var holder2 = ""
        button_rng.setOnClickListener{
            if (editText.getText().toString().trim().isNotEmpty()) {
            var number = editText.text.toString().toInt()
//            Toast.makeText(context, number, Toast.LENGTH_SHORT).show()
//            textView_rng_number.text = number
            random_number = (1..number).random()
            chance = 1.toDouble()/number
            chance = (chance * 1000).roundToInt() / 10.00
            holder2 = chance.toString() + "%"
            textView_chance.text = holder2
            textView_rng_number.text = random_number.toString()
            }
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
         * @return A new instance of fragment fragment_rng.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_rng().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}