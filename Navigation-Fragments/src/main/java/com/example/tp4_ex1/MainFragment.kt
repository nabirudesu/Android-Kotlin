package com.example.tp4_ex1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp3.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)
        val adapter = ListAdapter(activity as Context, loaddata())

        val recyclerView = activity?.findViewById<RecyclerView>(R.id.ListLayout)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

    }
    fun loaddata(): MutableList<Element> {
        val data = mutableListOf<Element>()
        data.add(
    Element("Samsung S9 plus \n 112000 DA",
    2,
    R.drawable.pack,
    R.drawable.s9
    )
    )
    data.add(
    Element(
    "Huawei Nova7i \n 211000 DA",
    3,
    R.drawable.pack,
    R.drawable.nova7i
    )
    )
    data.add(
    Element(
    "Redmi note 9 \n 40000 DA",
    1,
    R.drawable.phone,
    R.drawable.note9
    )
    )
    data.add(
    Element(
    "Redmi 9 pro \n 51000 DA",
    1,
    R.drawable.phone,
    R.drawable.note9pro
    )
    )
    data.add(
    Element(
    "Redmi 8a \n23000 DA ",
    1,
    R.drawable.phone,
    R.drawable.redmi8a
    )
    )
    data.add(
    Element(
    "Redmi 9a \n 26000 DA",
    1,
    R.drawable.phone,
    R.drawable.redmi9a
    )
    )
    return data}
}
