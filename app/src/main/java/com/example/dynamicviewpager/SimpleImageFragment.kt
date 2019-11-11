package com.example.dynamicviewpager


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_simple_image.*

/**
 * A simple [Fragment] subclass.
 */
class SimpleImageFragment : Fragment() {

    companion object {
        const val ARG_IMAGE = "image"
        fun newInstance(image: Image): SimpleImageFragment {
            return SimpleImageFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_IMAGE, image)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_simple_image, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = arguments!!.getSerializable(ARG_IMAGE) as Image
        Glide.with(this).load(image.url).fitCenter().into(imageView)
    }
}
