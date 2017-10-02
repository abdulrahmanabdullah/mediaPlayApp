package com.abdulrahmanjavanrd.media_player_mdl_demo2.app

import adapter.NavAdapter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.abdulrahmanjavanrd.media_player_mdl_demo2.R
import kotlinx.android.synthetic.main.activity_main.*
import model.NavDrawer

/**
 * Created by nfs05 on 06/09/2017.
 */
class NavigationDrawerFragement : Fragment() {

    var mDrawer:ActionBarDrawerToggle?=null
    val mDrawerLayout:DrawerLayout?=null



    fun onCreateView(cotainer:ViewGroup,saveInstance:Bundle):View{

        val v:View = LayoutInflater.from(cotainer!!.context).inflate(R.layout.fragment_navigation_drawer,cotainer,false)
        setRecyclerView(v)
        return v
    }

    fun setRecyclerView(view:View){
        val adapter = NavAdapter(NavDrawer.getData())
        recycler.layoutManager=LinearLayoutManager(view.context)
        recycler.adapter = adapter
    }

    fun setUpDrawer(fragementID:Int , drawerLayout: DrawerLayout,toolbar: Toolbar){
        mDrawer  = ActionBarDrawerToggle(activity,drawerLayout,R.string.drawer_open,R.string
                .drawer_close)


    }
}