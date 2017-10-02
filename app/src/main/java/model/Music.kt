package model

import android.content.ContentProvider
import android.media.MediaPlayer
import android.provider.MediaStore
import com.abdulrahmanjavanrd.media_player_mdl_demo2.R

/**
 * Created by nfs05 on 02/09/2017.
 */
class Music {
    var backImag:Int?=null
    lateinit var titleSong: String
//    var replay:Int?=null
//    var play:Int?=null
//    var forward:Int?=null
    var timer:String?=null
//    var seekBar:Int?=null

    var songUrl:String?=null





    companion object {
        val list = ArrayList<Music>()
        fun setData():ArrayList<Music>{



            // fisrt i need to declared variable to get image and put it in my class ..
            var imagesID:IntArray = getImage()

            for(item in imagesID.indices){
                var o = Music()
                o.titleSong = "Song " + item
                o.backImag = imagesID[item]
                o.songUrl="http://server11.mp3quran.net/yasser/002.mp3"
                list.add(o)
            }
            return list
        }

        // set images for every music ..
        fun getImage():IntArray{
            // here insert all images for music ..
            var img:IntArray = intArrayOf(
                    R.drawable.music_1,R.drawable.music_2,R.drawable.music_3,R.drawable.music_4,
                    R.drawable.music_5,R.drawable.music_6,R.drawable.music_7)


            return img
        }

        // load song ...
        fun loadSong():ArrayList<Music>{
            val list=ArrayList<Music>()
            val getAllSong= MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
            val selection =MediaStore.Audio.Media.IS_MUSIC + "!=0"

            var cursor =
            // create new object of music class and insert it new values ..

            return list
        }
    }

    // here the same above fun but here i need to passing arg ...

    fun pImage(p:Int):Int{
        // this array can't be extend to acespt more values ...
        var allImages:IntArray = intArrayOf(
                R.drawable.music_1,R.drawable.music_2,R.drawable.music_3,R.drawable.music_4,
                R.drawable.music_5,R.drawable.music_6,R.drawable.music_7
        )

        return allImages[p]
    }

    fun getListSize():Int{
        return list.size
    }

}