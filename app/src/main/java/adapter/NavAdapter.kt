package adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.abdulrahmanjavanrd.media_player_mdl_demo2.R
import model.NavDrawer

/**
 * Created by nfs05 on 04/09/2017.
 */
class NavAdapter(val listNav:ArrayList<NavDrawer>) : RecyclerView.Adapter<MyHolder>() {


    private val mainList= ArrayList<NavDrawer>()



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        var view:View = LayoutInflater.from(parent!!.context).inflate(R.layout.nav_drawer_list_item,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var current= listNav.get(position)
        holder.setDate(current,position)

    }

    override fun getItemCount(): Int {
        return listNav.size
    }



}
// class viewHolder
class MyHolder(v:View):RecyclerView.ViewHolder(v){

    var title:TextView = v.findViewById(R.id.navtxt)
    var image:ImageView = v.findViewById(R.id.imgIcon)

    fun setDate(nav:NavDrawer , p:Int){
        title.text = nav.title
        image.setImageResource(nav.getImageId(p))

    }
}