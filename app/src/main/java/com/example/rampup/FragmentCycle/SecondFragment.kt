package com.example.rampup.FragmentCycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rampup.R
/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    private var TAG=SecondFragment::class.java.simpleName
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i(TAG, " secondFragment onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, " Second Fragment onCreate: ")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View{
        return inflater.inflate(R.layout.fragment_second, container, false)
        Log.i(TAG, " secondFragment onCreateView: ")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "  secondFragment onViewCreated: ")
    }
    override fun onStart() {
        super.onStart()
        Log.i(TAG, " SecondFragment onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, " SecondFragment onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "SecondFragment onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, " SecondFragment onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i(TAG, " Secondragment onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "SecondFragment onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i(TAG, "SecondFragment onDetach: ")
    }
}