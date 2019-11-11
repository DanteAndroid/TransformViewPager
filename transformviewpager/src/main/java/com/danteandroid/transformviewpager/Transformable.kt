package com.danteandroid.transformviewpager

/**
 * @author Dante
 * 2019-11-11
 */
interface Transformable {

    fun getOriginalWidth(): Float
    fun getOrignalHeight(): Float

}

interface TransformableAdapter {

    fun getTransformableItems(): List<Transformable>

}