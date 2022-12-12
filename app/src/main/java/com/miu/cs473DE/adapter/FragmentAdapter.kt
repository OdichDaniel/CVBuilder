package com.miu.cs473DE.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.miu.cs473DE.data.Work
import com.miu.cs473DE.ui.fragments.AboutFragment
import com.miu.cs473DE.ui.fragments.ContactFragment
import com.miu.cs473DE.ui.fragments.HomeFragment
import com.miu.cs473DE.ui.fragments.WorkFragment

class FragmentAdapter(fragmentManager:FragmentManager, lifeCycle:Lifecycle) : FragmentStateAdapter(fragmentManager, lifeCycle) {

    val workFragment = WorkFragment()

    override fun createFragment(position: Int): Fragment {
        return   when(position){
            0-> HomeFragment()
            1-> AboutFragment()
            2-> workFragment
            3-> ContactFragment()
            else-> Fragment()
        }
    }

    override fun getItemCount(): Int = 4

    fun addWork(work: Work){
        workFragment.onAddWOrk(work)
    }
}

