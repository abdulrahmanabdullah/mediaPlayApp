package model

import com.abdulrahmanjavanrd.media_player_mdl_demo2.R

/**
 * Created by nfs05 on 04/09/2017.
 */
class NavDrawer {

    var title:String?= null
    var img:Int?=null



    // fun to set title return string
    fun getTitle(title:String):String{
        return title
    }

    companion object {
        val listNav=ArrayList<NavDrawer>()

        // fun to set image retrun intArray ..
        fun getImageId():IntArray{

            var images:IntArray = intArrayOf(

                    R.drawable.ic_beach_ball,R.drawable.ic_android_1,R.drawable.ic_android_2,
                    R.drawable.ic_robot,R.drawable.ic_mobile_phone,R.drawable.ic_maps_and_flags
 )

            return images
        }

        fun getTitle():Array<String>{
            var titles = arrayOf<String>("beach","android1","android2","robot","mobile","maps")
            return titles
        }

        fun getData():ArrayList<NavDrawer>{
            var imaID = getImageId()
            var titleID = getTitle()

            for (i in imaID.indices){
                var o = NavDrawer()
                 o.title = titleID[i]
                 o.img = imaID[i]
                listNav.add(o)

            }

            return listNav
        }
    }

    fun getImageId(p:Int):Int{

        var images:IntArray = intArrayOf(

                R.drawable.ic_beach_ball,R.drawable.ic_android_1,R.drawable.ic_android_2,
                R.drawable.ic_robot,R.drawable.ic_mobile_phone,R.drawable.ic_maps_and_flags
        )

        return images[p]
    }

    fun getTitle():Array<String>{
        var titles = arrayOf<String>("beach","android1","android2","robot","mobile","maps")
        return titles
    }

}