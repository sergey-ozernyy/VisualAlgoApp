package com.example.androidvisualalgoapp

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.androidvisualalgoapp.placeholder.PlaceholderContent.PlaceholderItem
import com.example.androidvisualalgoapp.databinding.FragmentListAlgorithmsBinding


class MyAlgorithmRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyAlgorithmRecyclerViewAdapter.ViewHolder>() {

    val viewModel = AlgorithmViewModel()//TODO: Подключить вью модель по-человечески

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentListAlgorithmsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.algoName.text = item.content
        holder.algoPreview.setImageResource(R.mipmap.ic_launcher)
        holder.itemView.setOnClickListener {
            viewModel.navigateToDetails()
        }
        //TODO: Нужно устанавливать слушатель кликов во фрагменте, а не в адаптере, чтобы не держать в памяти ViewModel.
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentListAlgorithmsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val algoName: TextView = binding.algorithmName
        val algoPreview: ImageView = binding.algorithmPreview

//        override fun toString(): String {
//            return super.toString() + " '" + algoName.text + "'"
//        }
    }

}