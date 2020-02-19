package com.example.guessyourword.ViewModels

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.guessyourword.R
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragmentViewModel:ViewModel(){

    public val word_list=ArrayList<String>()
    public  var i:Int=0
    public var final_score:Int=0
    public var skip_question:Int=0;
    public var next:Int=0
    public var skip:Int=0


    companion object Test{

        val TAG:String="SecondFragment"
        val nextButton:Int=1
        val skipButton:Int=2
    }

    init {
        Log.d(SecondFragmentViewModel.TAG,"SecondFragmentViewModel Created!!")
        add_word_in_list()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(SecondFragmentViewModel.TAG,"SecondFragmentViewModel Destroyed.")
    }

    private fun add_word_in_list() {
        word_list.add("world")
        word_list.add("war")
        word_list.add("working_man")
        word_list.add("hello world")
    }

    public fun buttonclick(button:Int,view: View){

        if(button==SecondFragmentViewModel.nextButton){

            next=next+1;

            i=i+1

            if(i>=word_list.size){

                val bundle:Bundle= Bundle()
                bundle.putString("finalscore",final_score.toString())
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment)

            }else{
                final_score=final_score+10;
                view.score_show.text=(final_score).toString()
                view.word.text=word_list.get(i)
            }

        }else if (button==SecondFragmentViewModel.skipButton){

            skip=i

            if(skip>=word_list.size){
                val bundle:Bundle= Bundle()
                bundle.putString("finalscore",final_score.toString())
                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment)

            }else{

                i=i+1;
                final_score=final_score-10;
                view.score_show.text=(final_score).toString()
                view.word.text=word_list.get(i)
            }

        }

    }

}