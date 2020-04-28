package com.example.autoviewpagertest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import android.content.Context.LAYOUT_INFLATER_SERVICE

class ImagesAdapter(private val context: Context, private var images: ArrayList<String>) : PagerAdapter() {

    private var moveListener : MoveListener ?= null

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var inflater : LayoutInflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var v = inflater.inflate(R.layout.auto_viewpager, null)
        var image = v.findViewById<ImageView>(R.id.image_container)
        Glide.with(context).load(images[position]).into(image)
        container.addView(v)

        v.setOnClickListener {
            moveListener?.onClick(position)
        }
        return  v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    fun moveListener(moveListener: MoveListener){
        this.moveListener = moveListener
    }

}