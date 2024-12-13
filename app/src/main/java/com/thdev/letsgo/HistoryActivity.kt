package com.thdev.letsgo

import Driver
import History
import Ride
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.thdev.letsgo.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.historyList.layoutManager = LinearLayoutManager(this)
        binding.historyList.setHasFixedSize(true)
        binding.historyList.adapter = AdapterHistory(getList())
    }

    private fun getList(): ArrayList<History> {
        return arrayListOf(
            History(
                "CT01",
                Ride(
                    61,
                    "2024-12-20T07:18:25",
                    "46904 Mann Islands, 628, Robertsfield, 57234-2011",
                    "43439 Wolff Divide, 178, Gerlachfort, 16704-2935",
                    89.95301375395289,
                    "40:00",
                    Driver(3, "Homer Simpson"),
                    698.0069914063693
                )
            )
        )
    }
}