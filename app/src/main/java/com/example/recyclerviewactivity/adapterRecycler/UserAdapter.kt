package com.example.recyclerviewactivity.adapterRecycler

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewactivity.R
import com.example.recyclerviewactivity.data.model.UserModel
import kotlinx.android.synthetic.main.item_user_layout.view.*

class UserAdapter(private val context: Context): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {


    //create null list
    private var userList = emptyList<UserModel>()


    class UserViewHolder(view: View):RecyclerView.ViewHolder(view)//оптимизация ресурсов

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        //show RecyclerView layout (item_layout)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_layout, parent, false)
        return UserViewHolder(view)//return view on ViewHolder
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.tv_last_name.text = userList[position].lastName
        holder.itemView.tv_first_name.text = userList[position].firtName
        holder.itemView.setOnClickListener {
        Toast.makeText(context, "${userList[position].lastName}", Toast.LENGTH_LONG).show()
        }
    }
    //return count
    override fun getItemCount(): Int {
        return userList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<UserModel>){
        userList = list
        //new change for adapter
        notifyDataSetChanged()
    }
}