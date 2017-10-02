package adapter

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import android.os.AsyncTask
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.abdulrahmanjavanrd.media_player_mdl_demo2.R
import com.abdulrahmanjavanrd.media_player_mdl_demo2.R.mipmap.*
import model.Music
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/*
* TODO:
* create action for each btn .. done
*
* play song ... done
* stop song .. not yet
* next song .. not yet .
* back song .. not yet .
* delete song .. done
* set timer .. not yet .
* set seek bar .. not yet .
 *  copy song .. not yet .
 *  TODO::::: create thread .. Not yet .
 *  set permissions  .. Done on MainActivity .
 *  get data from local storage .. not yet
 *
* */
class MusicAdapter(val list: ArrayList<Music>) : RecyclerView.Adapter<MusicAdapter.MyViweo>() {
    val TAG: String = "MusicAdapter"

    // i need to init Media player class
    override fun onBindViewHolder(holder: MyViweo, position: Int) {
        Log.d(TAG, "onBindViewHolder $position")
        var current = list.get(position)
         holder.setData(current, position)


        // this action for delete card ...
        holder.btn_del.setOnClickListener(View.OnClickListener {
            deleteItem(position)
        })

        // add item ..
        holder.btn_copy.setOnClickListener(View.OnClickListener {
            addNewItem(current,position)
        })
//        notifyItemChanged(position)
    }


    // create instance of Music class and get all cards ... DONE
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViweo {
        Log.d(TAG, "onCreaterViewHolder")
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item_cardview, parent, false)
        return MyViweo(view)
    }

    // count list size ... Done .
    override fun getItemCount(): Int {
        return list.size
    }

    // delete card .. Done .
    fun deleteItem(p: Int){
        list.removeAt(p)
        notifyItemRemoved(p)
        notifyItemRangeChanged(p,list.size)
    }

    // Add new card .. Done .
    fun addNewItem(music:Music,p:Int){
        //TODO: crash app when adding new card . Done
        Log.d(TAG,"add new card .. $p ")

               list.add(p,music)

               notifyItemInserted(p)
        // add this line to solve crash app ..
               notifyItemRangeChanged(p,list.size)


        Log.d(TAG,"After adding cards .. $p ")
//        notifyDataSetChanged()
    }

    // create view holder .. Done .
    class MyViweo(view: View) : RecyclerView.ViewHolder(view) {
        // this lines for what i need to access form list_item_cards..
        var image: ImageView = view.findViewById(R.id.img_row)
        var title: TextView = view.findViewById(R.id.title)
        var replay: Button = view.findViewById(R.id.btn_restart)
        var play: Button = view.findViewById(R.id.btn_play)
        var forward:Button = view.findViewById(R.id.btn_forward)
        var btn_copy:Button = view.findViewById(R.id.btn_copy)
        var btn_del:Button = view.findViewById(R.id.btn_del)
        var timer: EditText = view.findViewById(R.id.timer)
        var seekBar: SeekBar = view.findViewById(R.id.seekbar)

        // create instance of MediaPlay()
        var media=MediaPlayer()


        /****
         *
         * TODO: Add main thread .. to play song after song ..
         * *****/
        // set properties items text, and set action for buttons
        fun setData(music: Music, p: Int) {
            // set title for every song in library
            title.text = music.titleSong

//            AsyncTask<param,progress,result>(){
//
//            }



            // set images for each song we have...
            image.setImageResource(music.pImage(p))


            // play button ... onClicked ...
            play.setOnClickListener(View.OnClickListener {
                //TODO:Play song and pause song .
                playSong(music)

          })



            // button for forward song .. onClicked ..
            forward.setOnClickListener(View.OnClickListener {
                //TODO: go to next song
                //TODO: check if media = null, and disable button ..
                media!!.release()

            })


            // button for replay song. .. onClicked ..
            replay.setOnClickListener(View.OnClickListener {
                //TODO:replay song .
                if(media == null ){
                    // do some thing
                    timer.setText("null list .")
                }else{

                    media!!.release()

                }
            })


            // show timer for each song ..
            timer.setText("00")


            // onClicked call copySong func ..
            btn_copy.setOnClickListener(View.OnClickListener {
                copySong()
            })


//            btn_del.setOnClickListener(View.OnClickListener {
//
//
//            })

        }



        private fun playSong(music: Music) {
            media = MediaPlayer()
            try {
//

//                media!!.prepareAsync() // using this if you want insert url
                // using this for device storage .
                // test what text of button .. if = stop than pause song
                if (play.text.equals("stop")) {
                    // media!!.pause()
                    play.setBackgroundResource(ic_play)
                    media!!.pause()
                    play.setText("play")
                }
                // if button = play than play song
                else {
                    media.setDataSource(music.songUrl)
                    media.prepare()
                    media.start()
                    play.setBackgroundResource(ic_pause)

//                    seekBar.max = media.duration

//                    doAsync {
//                        Thread.sleep(1000)
//                        timer.setText("timer.")
//                        if(media != null){
//                        uiThread {
//
//                        }}
//                    }
                    play.setText("stop")
//                    seekBar.max = media!!.currentPosition
                }

            } catch (e: Exception) {
                println("error to play song \t ${music.songUrl}")
            }
        }


        // This method for copy song ...
        private fun copySong() {
           timer.setText("coy song ... ")
        }

        // This method for delete a song ...
//        private fun deletSong(music:Music,p:Int)
//        {
//
//        }

    }
}




