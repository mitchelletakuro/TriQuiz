package com.mitchelletakuro.triquiz.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.mitchelletakuro.triquiz.R
import com.mitchelletakuro.triquiz.onboarding.screens.OnboardingScreen1
import com.mitchelletakuro.triquiz.onboarding.screens.OnboardingScreen2
import com.mitchelletakuro.triquiz.onboarding.screens.OnboardingScreen3
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator


class OnboardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboarding, container, false)


        val fragmentList = arrayListOf(
            OnboardingScreen1(),
            OnboardingScreen2(),
            OnboardingScreen3()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager2)
        viewPager.adapter = adapter
        val indicator = view.findViewById<DotsIndicator>(R.id.dots_indicator)

        indicator.attachTo(viewPager)

        //        // Automatic sliding of onboarding screens
//        val handler = Handler(Looper.getMainLooper())
//        val timer = Timer()
//
//        timer.schedule(object : TimerTask() {
//            override fun run() {
//                handler.post {
//                    viewPager.currentItem = currentPage
//                    currentPage = (currentPage + 1) % adapter.itemCount
//                }
//            }
//        }, 3000, 3000)

        return view
    }


}