package com.example.prayertime.ui.calendar

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColor
import androidx.databinding.DataBindingUtil
import com.example.prayertime.R
import com.example.prayertime.databinding.FragmentCalendarBinding
import net.alhazmy13.hijridatepicker.time.CircleView


class CalendarFragment : Fragment() {
    private lateinit var binding:FragmentCalendarBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
       binding=DataBindingUtil.inflate(inflater,R.layout.fragment_calendar, container, false)
        binding.btnCalendar.setOnClickListener {
            if (binding.btnCalendar.text=="Hijri")
            {  binding.calendarGregorian.visibility=View.GONE
            binding.calendarHijri.visibility=View.VISIBLE
            binding.btnCalendar.text="Gregorian"
            binding.calendarText.text="Hijri"
            }
            else{
                binding.calendarGregorian.visibility=View.VISIBLE
                binding.calendarHijri.visibility=View.GONE
                binding.btnCalendar.text="Hijri"
                binding.calendarText.text="Gregorian"
            }
        }

        return binding.root
    }



}