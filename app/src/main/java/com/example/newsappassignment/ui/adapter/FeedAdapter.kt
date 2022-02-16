package com.example.newsappassignment.ui.adapter


import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsappassignment.R
import com.example.newsappassignment.model.local.NewsEntity
import kotlinx.android.synthetic.main.recycler_item_layout.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FeedAdapter(private val newsList: ArrayList<NewsEntity>): RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout,parent,false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        val data = newsList[position]
        holder.getData(data,position+1)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class FeedViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        fun getData(article: NewsEntity, count:Int){
            itemView.titleText.text=article.Name
            val publishAt=article.date
            val format= SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val date=format.parse(publishAt)
            val currentDate= Date()
            val timeStamp=
                date?.time?.let { DateUtils.getRelativeTimeSpanString(it,currentDate.time,DateUtils.MINUTE_IN_MILLIS) }
            itemView.timeText.text = timeStamp
            itemView.descriptionText.text = article.desc
            itemView.sourceText.text =article.source
            itemView.countItem.text = count.toString()
            Glide.with(itemView.context).load(article.ImageUrl).into(itemView.imageView)
        }
    }

}

