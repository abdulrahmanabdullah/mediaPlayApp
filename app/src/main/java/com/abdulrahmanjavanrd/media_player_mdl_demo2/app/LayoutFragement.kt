package com.abdulrahmanjavanrd.media_player_mdl_demo2.app

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.abdulrahmanjavanrd.media_player_mdl_demo2.R

import adapter.NavAdapter
import model.NavDrawer

/**
 * Created by nfs05 on 06/09/2017.
 */

class LayoutFragement {

    fun onCreateView(infla: LayoutInflater, v: ViewGroup, bundle: Bundle): View {

        val view = infla.inflate(R.layout.fragment_navigation_drawer, v, false)

        setRecyclerView(view)
        return view
    }

    @SuppressLint("ResourceType")
    private fun setRecyclerView(view: View) {
        val r = view.findViewById<View>(R.layout.fragment_navigation_drawer) as RecyclerView

        val adapter = NavAdapter(NavDrawer.getData())

        r.adapter = adapter
        r.layoutManager = LinearLayoutManager(view.context)

    }


}
