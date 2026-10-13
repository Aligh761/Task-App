package ali.ghanbariyan.taskapp.adapter

import ali.ghanbariyan.taskapp.databinding.ItemListRecyclerBinding
import ali.ghanbariyan.taskapp.db.entity.TaskEntity
import ali.ghanbariyan.taskapp.mvp.ext.OnBindData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class RecyclerTaskAdapter(
    private val tasks: ArrayList<TaskEntity>,
    private val onBindData: OnBindData
) : RecyclerView.Adapter<RecyclerTaskAdapter.TaskViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder =
        TaskViewHolder(
            ItemListRecyclerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(
        holder: TaskViewHolder,
        position: Int
    ) {
        holder.setData(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size


    fun dataUpdate(newList: List<TaskEntity>) {
        val diffResult = DiffUtil.calculateDiff(RecyclerDiffUtils(tasks, newList))
        tasks.clear()
        tasks.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }


    inner class TaskViewHolder(private val binding: ItemListRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(data: TaskEntity) {
            binding.txtTask.text = data.title
            binding.checkbox.isChecked = data.state

            binding.checkbox.setOnClickListener {
                onBindData.editData(data.copy(state = binding.checkbox.isChecked))
            }
            binding.imgDelete.setOnClickListener {

                onBindData.deleteData(data)

            }

        }

    }
}