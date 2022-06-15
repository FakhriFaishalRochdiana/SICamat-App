package com.bandungwetan.sicamat.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bandungwetan.sicamat.R

class RecyleviewAdapter : RecyclerView.Adapter<RecyleviewAdapter.ViewHolder>() {

    private var titles = arrayOf("Chapter One","Chapter Two","Chapter Three","Chapter Four","Chapter Five","Chapter Six","Chapter Seven","Chapter Eight")
    private var details = arrayOf("Item one details","Item two details","Item three details","Item four details",
    "Item five details","Item six details","Item seven details","Item eight details")
    private val images = intArrayOf(R.drawable.adzan,R.drawable.adzan,R.drawable.adzan,R.drawable.adzan,R.drawable.adzan,
        R.drawable.adzan,R.drawable.adzan,R.drawable.adzan)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyleviewAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.news_data,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyleviewAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemTitle : TextView
        var itemDetail : TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)
        }
    }

}