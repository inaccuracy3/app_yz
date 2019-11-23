package work.prgrm.yz

import android.content.Context
import android.media.SoundPool
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.*
import android.widget.BaseAdapter


class CustomAdapter(
    private val context: Context,
    private var inflater: LayoutInflater,
    private var layoutId: Int,

    private val soundPool:SoundPool,
    private var yz: List<MainActivity.Buttons>
                    ) : BaseAdapter()  {
    internal data class ViewHolder(val button:Button,val image:ImageView)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val viewHolder : ViewHolder
        if (convertView == null) {
            view = inflater.inflate(layoutId,parent,false)
            viewHolder = ViewHolder(view.findViewById(R.id.button),view.findViewById(R.id.imageView))
            view.tag = viewHolder
        } else {
            viewHolder = view!!.tag as ViewHolder
        }
        viewHolder.button.setText(yz[position].button)
        val soundId = soundPool.load(context, yz[position].sound, 1)
        viewHolder.image.setImageResource(yz[position].image)
        fadeout(viewHolder.image,0)
        viewHolder.button.setOnClickListener() {
            soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f)

            fadeout(viewHolder.image,3000)
        }
        return view!!
    }

    override fun getCount(): Int {
        return yz.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int):Long {
        return position.toLong()
    }

}
private fun fadeout(imageView:ImageView,Duration:Long){
    val alphaFadeOut = AlphaAnimation(1.0f,0.0f)
    alphaFadeOut.setDuration(Duration)
    alphaFadeOut.setFillAfter(true)
    imageView.startAnimation(alphaFadeOut)
}