package ali.ghanbariyan.taskapp.adapter

import ali.ghanbariyan.taskapp.db.entity.TaskEntity
import androidx.recyclerview.widget.DiffUtil

class RecyclerDiffUtils(
    private val oldList: List<TaskEntity>,
    private val newList: List<TaskEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}
