package com.bayusurapati.recycleview_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardTF2Adapter(private val cardHero: ArrayList<TF2CLASS>) :
    RecyclerView.Adapter<CardTF2Adapter.CardViewHolder>() {
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_from)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CardViewHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.card_tf2, viewGroup, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val (name, from, photo) = cardHero[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvFrom.text = from

        holder.btnFavorite.setOnClickListener()
        {
            Toast.makeText(
                holder.itemView.context,
                "Favorite " + cardHero[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
        }

        holder.btnShare.setOnClickListener()
        {
            Toast.makeText(
                holder.itemView.context,
                "Share " + cardHero[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.itemView.setOnClickListener()
        {
            Toast.makeText(
                holder.itemView.context,
                "Kamu memilih " + cardHero[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    override fun getItemCount(): Int {
        return cardHero.size
    }
}