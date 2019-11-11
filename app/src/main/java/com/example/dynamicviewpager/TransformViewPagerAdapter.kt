package com.example.dynamicviewpager

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.danteandroid.transformviewpager.Transformable
import com.danteandroid.transformviewpager.TransformableAdapter

/**
 * @author Dante
 * 2019-11-11
 */

class TransformViewPagerAdapter(fragmentManager: FragmentManager, val images: List<Image>) :
    FragmentPagerAdapter(fragmentManager), TransformableAdapter {

    override fun getTransformableItems(): List<Transformable> {
        return images
    }

    private val fragments: ArrayList<SimpleImageFragment> = arrayListOf()

    init {
        for (image in images) {
            fragments.add(SimpleImageFragment.newInstance(image))
        }
    }

    override fun getItem(index: Int): Fragment = fragments[index]

    override fun getCount(): Int = images.size

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        super.setPrimaryItem(container, position, `object`)
    }

}
