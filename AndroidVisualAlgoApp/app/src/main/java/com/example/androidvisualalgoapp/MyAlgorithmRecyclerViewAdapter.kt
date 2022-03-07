package com.example.androidvisualalgoapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.androidvisualalgoapp.placeholder.PlaceholderContent.PlaceholderItem
import com.example.androidvisualalgoapp.databinding.FragmentAlgorithmBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyAlgorithmRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyAlgorithmRecyclerViewAdapter.ViewHolder>() {

    val viewModel = AlgorithmViewModel()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentAlgorithmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        if (position == 0){
            holder.contentView.text = ""
        }
        holder.idView.text = item.id
        holder.contentView.text = item.content
        holder.itemView.setOnClickListener {
            viewModel.navigateToDetails()
        }
        //TODO: Нужно устанавливать слушатель кликов во фрагменте, а не в адаптере, чтобы не держать в памяти ViewModel.
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentAlgorithmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}