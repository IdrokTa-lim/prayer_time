package com.example.prayertime.ui.home

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.prayertime.R
import com.example.prayertime.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat


class HomeFragment : Fragment(), AdapterHome.RvItemListener {

    private lateinit var binding: FragmentHomeBinding
    var broadcastReceiver: BroadcastReceiver? = null
    @SuppressLint("SimpleDateFormat")
    var timeFormat: SimpleDateFormat = SimpleDateFormat("HH:mm")
    var dateFormat: SimpleDateFormat = SimpleDateFormat("dd.MM.YYYY")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val mChronometer : Chronometer = binding.chronometer
//        mChronometer.format = "HH:MM"
        mChronometer.base = SystemClock.elapsedRealtime()
        mChronometer.start()
        mChronometer.setOnChronometerTickListener {
            setTime()
        }

        binding.linear.setOnClickListener {
            findNavController().navigate(R.id.prayerTimeFragment)
        }
        setRv()
        return binding.root
    }

    private fun setTime() {
        val curentTime = System.currentTimeMillis()
        binding.chronometer.text = timeFormat.format(curentTime)
        binding.date.text = dateFormat.format(curentTime)


    }


    private fun getList(): List<Model> {
        return listOf(

            Model(
                1,
                "Tasbeh",
                requireContext().let { ContextCompat.getDrawable(it, R.drawable.ic_prayer_beads) }!!
            ),
            Model(
                2,
                "Duo",
                requireContext().let { ContextCompat.getDrawable(it, R.drawable.ic_dua_hands) }!!
            ),
            Model(
                3,
                "Qibla",
                requireContext().let { ContextCompat.getDrawable(it, R.drawable.ic_compass_ui) }!!
            ),
            Model(
                4,
                "Masjid",
                requireContext().let {
                    ContextCompat.getDrawable(
                        it,
                        R.drawable.ic_ramadan_crescent_moon
                    )
                }!!
            ),
            Model(
                5,
                "Ma'ruza",
                requireContext().let { ContextCompat.getDrawable(it, R.drawable.ic_cassette) }!!
            ),
            Model(
                6,
                "Kalendar",
                requireContext().let { ContextCompat.getDrawable(it, R.drawable.ic_calendar) }!!
            )
        )


    }

    private fun setRv() {
        val list = getList()
        val adapter = AdapterHome(this)
        adapter.setData(list)
        binding.rvMain.layoutManager = GridLayoutManager(activity, 3)
        binding.rvMain.adapter = adapter
    }

    override fun onClicked(model: Model) {
        when(model.id){
            1 -> findNavController().navigate(
                R.id.tasbeehFragment
            )
            2 -> findNavController().navigate(
                R.id.prayerFragment
            )
            3 -> findNavController().navigate(
                R.id.compassFragment
            )
            4 -> findNavController().navigate(
                R.id.mosqueFragment
            )
            5 -> findNavController().navigate(
                R.id.mediaFragment
            )
            6 -> findNavController().navigate(
                R.id.calendarFragment
            )
        }


    }


}