package com.example.sharedpreferenceusers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.sharedpreferenceusers.databinding.ItemUserAltBinding

class UserAdapter (private val users: MutableList<User>, private val listener: OnClickListener)
    :RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_user_alt, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        val positionfinal = position+1
        with(holder){
            setListener(user,positionfinal)
            binding.tvOrder.text = (positionfinal).toString()
            binding.tvName.text = user.getfullName()
            Glide.with(context)
                .load(user.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop()
                .into(binding.imgCard)
        }

    }
    fun remove(position: Int) {
            users.removeAt(position)
        notifyItemRemoved(position)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
    val binding = ItemUserAltBinding.bind(view)

    fun setListener(user: User,position: Int){
        binding.root.setOnClickListener { listener.onClick(user, position) }
    }

    }

}