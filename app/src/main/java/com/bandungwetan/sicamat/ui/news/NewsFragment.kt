package com.bandungwetan.sicamat.ui.news

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bandungwetan.sicamat.R
import com.bandungwetan.sicamat.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var dots: ArrayList<TextView>
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var newsAdapter : NewsRecyleviewAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handler = Handler(Looper.getMainLooper())
        runnable = object : Runnable {
            var index = 0
            override fun run() {
                if (index == list.size)
                    index = 0
                Log.e("Runnable,", "$index")
//                binding.viewPager.setCurrentItem(index)
                index++
                handler.postDelayed(this,2000)
            }
        }
        list.add(
            ImageData(
                "https://source.unsplash.com/ym0THh5L-fg"
            )
        )

        list.add(
            ImageData(
                "https://source.unsplash.com/C-rpFvlSUNg"
            )
        )

        list.add(
            ImageData(
                "https://source.unsplash.com/rJvD7EsB4Jg"
            )
        )
        newsAdapter = NewsRecyleviewAdapter()
        adapter = ImageSliderAdapter(list)
        binding.recyclerview.adapter = newsAdapter
        binding.viewPager.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })

        handler.post(runnable)
    }

    private fun selectedDot(position: Int) {
        for (i in 0 until list.size){
            if(i == position)
                dots[i].setTextColor(ContextCompat.getColor(requireContext(),
                    R.color.black))
            else
                dots[i].setTextColor(ContextCompat.getColor(requireContext(),
                    R.color.grey))
        }
    }

    private fun setIndicator(){
        for(i in 0 until list.size){
            dots.add(TextView(requireContext()))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dots[i].text=Html.fromHtml("&#9679",Html.FROM_HTML_MODE_LEGACY).toString()
            }else {
                dots[1].text = Html.fromHtml("&#9679")
            }
            dots[i].textSize = 18f
            binding.dotsIndicator.addView(dots[i])

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}