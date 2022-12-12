package com.miu.cs473DE.ui.activity

import CVBuilderApp.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.miu.cs473DE.adapter.FragmentAdapter
import com.miu.cs473DE.data.Work
import com.miu.cs473DE.ui.dialog.WorkDialogCommunicator
import com.miu.cs473DE.utils.StorageUtils


class MainActivity : AppCompatActivity(), WorkDialogCommunicator {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FragmentAdapter
    private lateinit var storageUtils: StorageUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        storageUtils = StorageUtils(this)

        setUpFragments()

        val username = storageUtils.getUsername()
        username?.apply { binding.toolbar.title = "$username's CV" }
    }

    private fun setUpFragments() {
        adapter = FragmentAdapter(supportFragmentManager, lifecycle)
        binding.contentLayout.viewpager.adapter = adapter
        TabLayoutMediator(binding.contentLayout.tabLayout, binding.contentLayout.viewpager) { tab, position ->
            when (position) {
                0 -> tab.text = "Home"
                1 -> tab.text = "About Me"
                2 -> tab.text = "Work"
                3 -> tab.text = "Contact"
            }
        }.attach()
    }


    override fun onAddWOrk(work: Work) {
        if (::adapter.isInitialized) {
            adapter.addWork(work)
        } else {
            setUpFragments()
            adapter.addWork(work)
        }
    }

}