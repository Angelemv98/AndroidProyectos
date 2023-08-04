package com.example.ciclodevida

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ciclodevida.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var mediaPlayer: MediaPlayer? = null
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i("Lifecycle", "Metodo Oncreate")

        binding.BtnDialog.setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }


    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this, R.raw.jam)
        Log.i("Lifecycle", "Metodo OnStart")
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
        Log.i("Lifecycle", "Metodo OnResume")
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onPause() {
        super.onPause()
        finish()
        mediaPlayer?.pause()
        if (mediaPlayer != null)
        position = mediaPlayer!!.currentPosition
        Log.i("Lifecycle", "Metodo onPause")
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        Log.i("Lifecycle", "Metodo OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "Metodo OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle", "Metodo OnDestroy")

    }
}