package com.example.sprint03.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint03.databinding.ListItemFeedbackBinding
import com.example.sprint03.model.Feedback

class FeedbackAdapter : ListAdapter<Feedback, FeedbackAdapter.MyViewHolder>(AsyncCallback()) {

    var onClick: (feedback: Feedback) -> Unit = {}

    inner class MyViewHolder(val binding: ListItemFeedbackBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(feedback: Feedback) {
            binding.textViewLead.text = feedback.lead
            binding.textViewFeedback.text = feedback.feedback

            binding.root.setOnClickListener {
                onClick(feedback)
            }
        }
    }

    class AsyncCallback : DiffUtil.ItemCallback<Feedback>() {
        override fun areItemsTheSame(oldItem: Feedback, newItem: Feedback): Boolean {
            return oldItem.lead == newItem.lead && oldItem.feedback == newItem.feedback
        }

        override fun areContentsTheSame(oldItem: Feedback, newItem: Feedback): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemFeedbackBinding = ListItemFeedbackBinding.inflate(layoutInflater, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun setData(feedbacks: List<Feedback>) {
        submitList(feedbacks)
    }
}
