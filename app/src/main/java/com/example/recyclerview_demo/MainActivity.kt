package com.example.recyclerview_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_demo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = MyAdapter(this, ListData.data)
        binding.recyclerView.adapter = adapter

        val tabList = ListData.data.map { it.noData }

        binding.tabLayout.tabMode = TabLayout.MODE_SCROLLABLE

        tabList.forEachIndexed { index, value ->

            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(value).setTag(index))
        }

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                
                layoutManager.scrollToPositionWithOffset(tab!!.position, 0)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        binding.recyclerView.layoutManager = layoutManager

        binding.recyclerView.setOnScrollChangeListener { view, y, x, oldx, oldy ->

            binding.tabLayout.setScrollPosition(
                layoutManager.findFirstVisibleItemPosition(),
                0F,
                true
            )

            binding.tabLayout.isSmoothScrollingEnabled = true
        }
    }
}