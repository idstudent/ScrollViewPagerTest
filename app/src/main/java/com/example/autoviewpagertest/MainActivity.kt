package com.example.autoviewpagertest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import pl.pzienowicz.autoscrollviewpager.AutoScrollViewPager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = ArrayList<String>()

        data.add("https://wallpaperaccess.com/full/51607.jpg")
        data.add("https://wallpaperaccess.com/full/51616.jpg")
        data.add("https://wallpaperaccess.com/full/51621.jpg")
        data.add("https://wallpaperaccess.com/full/11810.jpg")

        val scrollAdapter = ImagesAdapter(this, data)
        viewPager.adapter = scrollAdapter //Auto Viewpager에 Adapter 장착
        viewPager.setInterval(2000) // 페이지 넘어갈 시간 간격 설정
        viewPager.startAutoScroll() //Auto Scroll 시작
        scrollAdapter.moveListener(moveListener)
        indicator.setViewPager(viewPager)
    }
    val moveListener = object : MoveListener{
        var intent : Intent ?= null
        override fun onClick(position: Int) {
            when(position){
                0 -> {
                    intent = Intent(applicationContext, OneActivity::class.java)
                    startActivity(intent)
                }
                1 -> {
                    intent = Intent(applicationContext, TwoActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
