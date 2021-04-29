package com.example.ptitzalo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MessAdapter(
    var mutableList: MutableList<MessModel>,
    var callBack: CallBack
) : RecyclerView.Adapter<MessAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.mess_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return mutableList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val mess: MessModel = mutableList[position]
        holder.title.text = mess.title
        holder.content.text = mess.content
        holder.date.text = mess.date
        when (mess.image) {
            "1" -> {
                holder.image.setImageResource(R.drawable.avt)
            }
            "2" -> {
                holder.image.setImageResource(R.drawable.avt2)
            }
            "3" -> {
                holder.image.setImageResource(R.drawable.avt3)
            }
            "4" -> {
                holder.image.setImageResource(R.drawable.avt4)
            }
            "5" -> {
                holder.image.setImageResource(R.drawable.avt5)
            }
        }

        holder.constraintLayout.setOnClickListener {
            callBack.onClickMess(position, mess)
        }

    }

    interface CallBack {
        fun onClickMess(int: Int, messModel: MessModel)
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        var constraintLayout: ConstraintLayout = view.findViewById(R.id.layout)
        var title: TextView = view.findViewById(R.id.title)
        var content: TextView = view.findViewById(R.id.content)
        var date: TextView = view.findViewById(R.id.date)

        var image: ImageView = view.findViewById(R.id.near_user_image_2)
    }
}


