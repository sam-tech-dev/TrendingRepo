package com.gojek.trendingrepo.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gojek.trendingrepo.R
import com.gojek.trendingrepo.data.models.db.Repository
import com.gojek.trendingrepo.databinding.LayoutRepositoryBinding

class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit  var listOfRepos:List<Repository>
     var clickedCardPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context=parent.context
        val binding : LayoutRepositoryBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.layout_repository, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if(::listOfRepos.isInitialized) listOfRepos.size else 0
    }

    fun updateRepoList(repoList:List<Repository>){
        this.listOfRepos = repoList
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(listOfRepos.get(position))

        if(clickedCardPosition != position){
            holder.binding.cvRepositoryExtraDetails.visibility= View.GONE
        }else{
            holder.binding.cvRepositoryExtraDetails.visibility= View.VISIBLE
        }

        holder.binding.cvRepository.setOnClickListener {

            var lastClicked= clickedCardPosition
            clickedCardPosition = position

            if(lastClicked!=clickedCardPosition){
                notifyItemChanged(lastClicked)
            }

            if(holder.binding.cvRepositoryExtraDetails.visibility == View.VISIBLE){
                holder.binding.cvRepositoryExtraDetails.visibility = View.GONE
                clickedCardPosition = -1
            }else{
                holder.binding.cvRepositoryExtraDetails.visibility = View.VISIBLE
            }
        }
    }

    class ViewHolder(val binding : LayoutRepositoryBinding) :RecyclerView.ViewHolder(binding.root){
        private var viewModel = RepositoryItemViewModel()

        fun bind(repository: Repository){
            viewModel.bind(repository)
            binding.viewModel = this.viewModel
        }
    }
}