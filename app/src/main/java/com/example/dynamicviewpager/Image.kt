package com.example.dynamicviewpager

import com.danteandroid.transformviewpager.Transformable
import java.io.Serializable

/**
 * @author Dante
 * 2019-11-07
 */
data class Image(
    val width: Int,
    val height: Int,
    val format: String,
    val size: Int,
    val url: String
) : Serializable, Transformable {
    override fun getOriginalWidth(): Float {
        return width.toFloat()
    }

    override fun getOrignalHeight(): Float {
        return height.toFloat()
    }
}

const val JSON_DATA: String = "[\n" +
        "{\n" +
        "    \"width\": 1000,\n" +
        "    \"height\": 700,\n" +
        "    \"format\": \"jpeg\",\n" +
        "    \"size\": 28340,\n" +
        "    \"url\": \"https://picsum.photos/id/100/1000/700\"\n" +
        "},\n" +
        "{\n" +
        "    \"width\": 1920,\n" +
        "    \"height\": 1080,\n" +
        "    \"format\": \"jpeg\",\n" +
        "    \"size\": 33663,\n" +
        "    \"url\": \"https://picsum.photos/id/99/1920/1080\"\n" +
        "},\n" +
        "{\n" +
        "    \"width\": 720,\n" +
        "    \"height\": 1080,\n" +
        "    \"format\": \"jpeg\",\n" +
        "    \"size\": 704200,\n" +
        "    \"url\": \"https://picsum.photos/id/199/720/1080\"\n" +
        "},\n" +
        "{\n" +
        "    \"width\": 1080,\n" +
        "    \"height\": 1080,\n" +
        "    \"format\": \"jpeg\",\n" +
        "    \"size\": 30155,\n" +
        "    \"url\": \"https://picsum.photos/id/191/1080/1080\"\n" +
        "}\n" +
        "]"