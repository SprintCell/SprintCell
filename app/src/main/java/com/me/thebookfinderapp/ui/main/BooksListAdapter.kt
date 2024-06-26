package com.me.thebookfinderapp.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.me.thebookfinderapp.R
import com.me.thebookfinderapp.data.model.Item
import com.me.thebookfinderapp.utils.GlideApp
import kotlinx.android.synthetic.main.book_item.view.*

class BooksListAdapter(val books:List<Item>): RecyclerView.Adapter<BooksListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.textBookName.text = books[position].volumeInfo.title
        holder.view.textAuthors.text = books[position].volumeInfo.authors?.joinToString()

        GlideApp.with(holder.view).load(books[position].volumeInfo.imageLinks.thumbnail).into(holder.view.imageBookCover)
    }

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)
}