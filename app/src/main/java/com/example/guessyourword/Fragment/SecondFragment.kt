package com.example.guessyourword.Fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.guessyourword.R
import com.example.guessyourword.ViewModels.SecondFragmentViewModel
import kotlinx.android.synthetic.main.fragment_second.view.*

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    private var navController:NavController?=null;
    private lateinit var secondFragmentViewModel:SecondFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        Log.d(SecondFragmentViewModel.TAG,"SecondFragment Created!!")
        secondFragmentViewModel= ViewModelProviders.of(this).get(SecondFragmentViewModel::class.java)

        return inflater.inflate(R.layout.fragment_second, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)

        if(secondFragmentViewModel.i==0){
            view.word.text=secondFragmentViewModel.word_list.get(0)
        }else{
            view.word.text=secondFragmentViewModel.word_list.get(secondFragmentViewModel.i)
            view.score_show.text=secondFragmentViewModel.final_score.toString()
        }

        view.next_button.setOnClickListener(View.OnClickListener {
            secondFragmentViewModel.buttonclick(SecondFragmentViewModel.nextButton,view)
        })

        view.skip_button.setOnClickListener(View.OnClickListener {
            secondFragmentViewModel.buttonclick(SecondFragmentViewModel.skipButton,view)
        })
    }

}
