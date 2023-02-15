package com.bayusurapati.recycleview_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListTF2Adapter(private val listHero: ArrayList<TF2CLASS>): RecyclerView.Adapter<ListTF2Adapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvFrom: TextView = itemView.findViewById(R.id.tv_item_from)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

        fun bindView(tfclass: TF2CLASS, listener: (TF2CLASS) -> Unit){
            tfclass.photo?.let { imgPhoto.setImageResource(it) }
            tvName.text = tfclass.name
            tvFrom.text = tfclass.from
            itemView.setOnClickListener{listener(tfclass)}
        }
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_tf2,viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, from, photo) = listHero[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvFrom.text = from
    }

    override fun getItemCount(): Int {
        return listHero.size
    }
}
