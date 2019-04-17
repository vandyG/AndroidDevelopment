package com.example.newsapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*

class ArticleAdapter (private val arrayList: ArrayList<Article>) : RecyclerView.Adapter<ArticleAdapter.ArticleHolder>() {

    inner class ArticleHolder(itemView : View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(view: ViewGroup, p1: Int): ArticleHolder {
        val li = LayoutInflater.from(view.context)
        val inflatedView = li.inflate(R.layout.item_row, view, false)
        return ArticleHolder(inflatedView)
    }

    override fun getItemCount() = arrayList.size

    override fun onBindViewHolder(holder: ArticleHolder, p1: Int) {
        val currArticle : Article = arrayList[p1]
        holder.itemView.tvHeading.text = currArticle.title
        holder.itemView.tvDate.text = currArticle.publishedAt
        holder.itemView.tvDescription.text = currArticle.description
        holder.itemView.tvSource.text = currArticle.source.name

        Picasso.get().load(currArticle.urlToImage).into(holder.itemView.ivArticle)
    }

}