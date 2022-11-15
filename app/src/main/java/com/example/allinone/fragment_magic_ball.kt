package com.example.allinone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_magic_ball.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_magic_ball : Fragment() {
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
        val view =  inflater.inflate(R.layout.fragment_magic_ball, container, false)
        val button_ask = view.findViewById<Button>(R.id.button_magic_ball)
        val imageView_ball = view.findViewById<ImageView>(R.id.imageView_magic_ball)
        var random = 0
        button_ask.setOnClickListener {
            random = (1..5).random()
            if (random == 1){
                imageView_ball.setImageResource(R.drawable.img_magic_ball_2)
            }
            else if (random == 2){
                imageView_ball.setImageResource(R.drawable.img_magic_ball_3)
            }
            else if (random == 3){
                imageView_ball.setImageResource(R.drawable.img_magic_ball_4)
            }
            else if (random == 4){
                imageView_ball.setImageResource(R.drawable.img_magic_ball_5)
            }
            else if (random == 5){
                imageView_ball.setImageResource(R.drawable.img_magic_ball_6)
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
         * @return A new instance of fragment fragment_magic_ball.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_magic_ball().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}