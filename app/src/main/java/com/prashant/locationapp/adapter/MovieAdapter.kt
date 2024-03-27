package com.prashant.locationapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.prashant.locationapp.R
import com.prashant.locationapp.model.MovieResponse
import com.squareup.picasso.Picasso


class MovieAdapter(private val context: Context, private var movieList: ArrayList<MovieResponse>) :
    RecyclerView.Adapter<MovieAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cl_movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val movie = movieList[position]
        
        Picasso.get().load(movie.imdb_url).into(holder.movieImage)
        holder.movieName.text = movie.movie
        holder.movieRating.text = movie.rating.toString()

        holder.imdbBtn.setOnClickListener {
            val url = movie.imdb_url
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
           it.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int = movieList.size
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val movieName: TextView = itemView.findViewById(R.id.movieName)
        val movieRating: TextView = itemView.findViewById(R.id.movieRating)
        val imdbBtn: ImageView = itemView.findViewById(R.id.imdbBtn)
    }

    fun setData(movieList: ArrayList<MovieResponse>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }
}