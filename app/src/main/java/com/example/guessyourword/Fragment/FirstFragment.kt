package com.example.guessyourword.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.guessyourword.R
import kotlinx.android.synthetic.main.fragment_first.view.*

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    private var navController:NavController?=null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view);

        view.button.setOnClickListener(View.OnClickListener {
            navController!!.navigate(R.id.action_firstFragment_to_secondFragment)
        })
    }


}
