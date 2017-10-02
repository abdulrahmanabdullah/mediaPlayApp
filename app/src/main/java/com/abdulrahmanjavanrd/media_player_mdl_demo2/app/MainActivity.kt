package com.abdulrahmanjavanrd.media_player_mdl_demo2.app

import adapter.MusicAdapter
import adapter.NavAdapter
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.abdulrahmanjavanrd.media_player_mdl_demo2.R
import kotlinx.android.synthetic.main.activity_main.*
import model.Music
import model.NavDrawer
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE = 123
    var toolbar:Toolbar?=null
    var drawer:DrawerLayout?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //toolbar!!.setNavigationIcon(R.drawable.arrow_back)
        setToolBar()

        // call checkPermission method ..
        checkPermission()


    }

    private fun setToolBar() {
        // set toolbar ..
        toolbar = toolbar_id as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.title = "Home page"
        supportActionBar!!.subtitle = "media player"
        supportActionBar!!.setLogo(R.drawable.ic_nav)
    }


    /**** menu fun  *************************************/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.navtxt->{}
        }

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var msg = ""

        when(item!!.itemId){

            R.id.search->{
                longToast("search button .. ")
            }


            R.id.edit->{longToast("edit")}
            // exit app ..
            R.id.exit->{
                toast("exit app .. good bye ")
//                Thread.sleep(1000)
                finish()

            }
            else->{longToast("wrong press")}
        }

        return true
    }
    /** End menu func  **/






    // checkPermission Before launch app ..
    fun checkPermission( ):Boolean{

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),REQUEST_CODE)
                return true
            }
        }

        recyclerView()
        return true

    }



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            REQUEST_CODE->{
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // call recycler view ... fun
                    recyclerView()
                }else {
                    //TODO: ask user again for permission ..
                    longToast("permission denied ..")}
            }
            else->super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }

    /** recycler view method ...  **/
    fun recyclerView(){

        // TODO: create thread here ..

        recycler.layoutManager = LinearLayoutManager(this)
        val adapter =MusicAdapter(Music.setData())

        recycler.adapter = adapter


    }

     fun navRecyclerView() {
        val navigationSubClass = NavigationDrawerFragement()
        drawer = findViewById<DrawerLayout>(R.id.drawe_layout) as DrawerLayout
        navigationSubClass.setUpDrawer(R.id.nav_drawer_fragement,drawer!!,toolbar!!)
    }
}

