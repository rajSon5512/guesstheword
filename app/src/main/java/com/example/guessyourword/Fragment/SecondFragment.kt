package com.example.guessyourword.Fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.guessyourword.R
import kotlinx.android.synthetic.main.fragment_second.view.*

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    private var navController:NavController?=null;
    private val word_list=ArrayList<String>()
    private var i:Int=0
    private var final_score:Int=0
    private var skip_question:Int=0;
    private var next:Int=0
    private var skip:Int=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        add_word_in_list()
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    private fun add_word_in_list() {
        word_list.add("world")
        word_list.add("war")
        word_list.add("working_man")
        word_list.add("hello world")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)

        if(i==0){

            view.word.text= word_list.get(0)
        }

        view.next_button.setOnClickListener(View.OnClickListener {
            next=next+1;

            i=i+1

            if(i>=word_list.size){

                val bundle:Bundle= Bundle()
                bundle.putString("finalscore",final_score.toString())
                navController!!.navigate(R.id.action_secondFragment_to_thirdFragment,bundle)

            }else{
                final_score=final_score+10;
                view.score_show.text=(final_score).toString()
                view.word.text=word_list.get(i)
            }
        })

        view.skip_button.setOnClickListener(View.OnClickListener {
            skip=i

            if(skip>=word_list.size){
                val bundle:Bundle= Bundle()
                bundle.putString("finalscore",final_score.toString())
                navController!!.navigate(R.id.action_secondFragment_to_thirdFragment,bundle)

            }else{

                i=i+1;
                final_score=final_score-10;
                view.score_show.text=(final_score).toString()
                view.word.text=word_list.get(i)
            }

        })
    }

}
