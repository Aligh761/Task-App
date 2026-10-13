package ali.ghanbariyan.taskapp.mvp.ext

import ali.ghanbariyan.taskapp.db.entity.TaskEntity

interface OnBindData {

    fun saveData(taskEntity: TaskEntity) {}

    fun editData(taskEntity: TaskEntity) {}

    fun getData(taskEntity: List<TaskEntity>) {}

    fun requestData(state: Boolean) {}

    fun deleteData(taskEntity: TaskEntity) {}
}