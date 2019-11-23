package work.prgrm.yz

import android.content.Intent
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.AdapterView





class MainActivity : AppCompatActivity() {
    data class Buttons(val button: String,val sound: Int,val image: Int)
    private val soundPool = SoundPool.Builder().setMaxStreams(2).build()
    private val yz = listOf(
        Buttons("こ↑こ↓",R.raw.koko,R.drawable.koko),
        Buttons("多少はね",R.raw.tashouhane,R.drawable.koko)
        //Buttons(R.id.button3,R.raw.tashouhane,R.drawable.yarimasune),
        //Buttons(R.id.button4,R.raw.yarimasune,R.drawable.yarimasune)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.ListView)
        val adapter = CustomAdapter(this,LayoutInflater.from(applicationContext), R.layout.row,soundPool,yz)
        listView.setAdapter(adapter)
//        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
//           override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
//               if(view.id == R.id.button) {
//                   val soundId = soundPool.load(applicationContext, yz[position].sound, 1)
//                   soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f)
//               }
//            }
//        }


        button6.setOnClickListener{
            val intent = Intent(application,SubActivity::class.java)
            startActivity(intent)
        }

    }
}
