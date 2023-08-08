package com.example.sharedpreferenceusers

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedpreferenceusers.databinding.ActivityMainBinding
import com.example.sharedpreferenceusers.databinding.DialogRegisterBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)
        Log.i("SP ", "${getString(R.string.sp_first_time)} = $isFirstTime")

        if (isFirstTime) {
            val dialogView = layoutInflater.inflate(R.layout.dialog_register, null)
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.dialog_tittle)
                .setView(dialogView)
                .setCancelable(false)
                .setPositiveButton(R.string.dialog_confirm) { _, _ ->
                    val username =
                        dialogView.findViewById<TextInputEditText>(R.id.etUserName).text.toString()
                    with(preferences.edit()) {
                        putBoolean(getString(R.string.sp_first_time), false)
                        putString(getString(R.string.sp_username), username)
                            .apply()
                    }
                }.show()
        }


        userAdapter = UserAdapter(getUsers(), this)

        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }
    }

    private fun getUsers(): MutableList<User> {
        val users = mutableListOf<User>()
        val angel = User(
            1,
            "Angel",
            "Morales",
            "https://pps.whatsapp.net/v/t61.24694-24/351768735_1920967164947713_5010933823476641218_n.jpg?ccb=11-4&oh=01_AdRBCkRQhVYZ3L8g61LwRmvd6thgpaYU-fT2bD6gaKZcgQ&oe=64DE9472"
        )
        val tania = User(
            2,
            "Tania",
            "Bravo",
            "https://pps.whatsapp.net/v/t61.24694-24/364345217_193571447039321_6993894243008930771_n.jpg?ccb=11-4&oh=01_AdS4w-f6NkRfy3WjmYC2T91ACa9S2ZvXT28B2u9j8dSlSw&oe=64DE9B33"
        )
        val derian = User(
            3,
            "Derian",
            "Sanchez",
            "https://pps.whatsapp.net/v/t61.24694-24/364523210_1194927488024163_977849617897376648_n.jpg?ccb=11-4&oh=01_AdRsDN5N0trOf8eBZ2zG3re8Ks1l3aFD03JvsIEnkSnouw&oe=64DE94DC"
        )
        val elizabeth = User(
            4,
            "Elizabeth",
            "Morales",
            "https://pps.whatsapp.net/v/t61.24694-24/365513550_3217350028487359_2458713393100270545_n.jpg?ccb=11-4&oh=01_AdRwmhesjbA53QksN6K6MJ8obRPNsWe7Xx0KGFlqWjJk1g&oe=64DEA54B"
        )
        users.add(angel)
        users.add(tania)
        users.add(derian)
        users.add(elizabeth)
        users.add(tania)
        users.add(derian)
        users.add(elizabeth)
        users.add(tania)
        users.add(derian)
        users.add(elizabeth)
        users.add(tania)
        users.add(derian)
        users.add(elizabeth)
        users.add(tania)
        users.add(derian)
        users.add(elizabeth)
        users.add(tania)
        users.add(derian)
        users.add(elizabeth)

        return users
    }

    override fun onClick(user: User, position: Int) {
        Toast.makeText(this, "$position : ${user.getfullName()} ", Toast.LENGTH_SHORT).show()
    }
}