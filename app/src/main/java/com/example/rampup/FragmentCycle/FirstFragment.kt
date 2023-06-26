package com.example.rampup.FragmentCycle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.rampup.MainActivity
import com.example.rampup.R
/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    private  val TAG = FirstFragment::class.java.simpleName

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, " firstFragment onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "firstFragment onCreate: ")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View{

        val view=inflater.inflate(R.layout.fragment_first, container, false)
        val button:Button=view.findViewById(R.id.firstButton)
        button.setOnClickListener{
            goToHomePge()
        }
        Log.i(TAG, "first fragment onCreateView: ")
        return view
    }
    /**
    Fragment does not have a direct reference to the Context or Activity . requireContext()
    method provided by the Fragment class is used to redirect with fragment
     * */
    private fun goToHomePge() {
        startActivity(Intent(requireContext(), MainActivity::class.java))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "onViewCreated: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, " firstFragment onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, " firstFragment onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "firstFragment onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, " firstFragment onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, " firstFragment onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "firstFragment onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "firstFragment onDetach: ")
    }

}