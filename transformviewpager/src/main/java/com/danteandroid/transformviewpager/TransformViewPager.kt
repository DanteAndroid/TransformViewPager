package com.danteandroid.transformviewpager

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

/**
 * @author Dante
 * 2019-11-06
 */
class TransformViewPager : ViewPager {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun setAdapter(adapter: PagerAdapter?) {
        super.setAdapter(adapter)
        check(adapter is TransformableAdapter) { "You should set adapter that implements `TransformableAdapter`" }
        // 初始高度为第一张图片的实际显示高度
        layoutParams.height = getRealHeight(0)

        addOnPageChangeListener(object : OnPageChangeListener {
            private var lastOffset = 0
            override fun onPageScrollStateChanged(position: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val scrollToLeft = positionOffsetPixels - lastOffset < 0
                lastOffset = positionOffsetPixels
                transform(position, positionOffset, scrollToLeft)
            }

            override fun onPageSelected(position: Int) {

            }
        })
    }

    // 注意，我要变形了！
    private fun transform(position: Int, positionOffset: Float, isLeft: Boolean) {
        if (positionOffset == 0f || positionOffset == 1f) return
        // 如果向左划，position 为左边那个，故需要 +1
        val currentPosition = if (isLeft) position + 1 else position
        // 计算目标高度与当前高度的差值
        // 然后乘以滑动offset（在屏幕宽度中）的比例
        val diff = (getDestHeight(currentPosition, isLeft) -
                getRealHeight(currentPosition)) * if (isLeft) 1 - positionOffset else positionOffset

        layoutParams.height = getRealHeight(currentPosition) + diff.toInt()
        requestLayout()

        println(
            "onScrollChanged position $currentPosition, getRealHeight ${
                getRealHeight(
                    position
                )
            }, " + "diffHeight $diff, layoutParams.height ${layoutParams.height}"
        )
    }

    private fun getDestHeight(position: Int, scrollToLeft: Boolean): Int {
        val nextImagePosition = if (scrollToLeft && position >= 1) {
            position - 1
        } else position + 1

        return getRealHeight(nextImagePosition)
    }

    private fun getRealHeight(position: Int): Int {
        val adapter = adapter as TransformableAdapter
        val image = adapter.getTransformableItems()[position]
        val width = getRealWidth(position)
        return (image.getOrignalHeight() / image.getOriginalWidth() * width).toInt()
    }

    private fun getRealWidth(position: Int): Int {
        val adapter = adapter as TransformableAdapter
        val image = adapter.getTransformableItems()[position]
        return when {
            layoutParams.width == ViewGroup.LayoutParams.WRAP_CONTENT -> {
                image.getOriginalWidth().toInt()
            }
            layoutParams.width == ViewGroup.LayoutParams.MATCH_PARENT -> {
                UiUtils.getScreenWidth(context)
            }
            else -> layoutParams.width
        }
    }
}
