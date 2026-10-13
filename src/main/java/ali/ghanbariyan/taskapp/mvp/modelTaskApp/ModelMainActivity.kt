package ali.ghanbariyan.taskapp.mvp.modelTaskApp

import ali.ghanbariyan.taskapp.db.DBHandler
import ali.ghanbariyan.taskapp.db.entity.TaskEntity
import ali.ghanbariyan.taskapp.mvp.ext.OnBindData
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ModelMainActivity(private val activity: AppCompatActivity) {
    private val db = DBHandler.getDatabase(activity)
    private var tasksJob: Job? = null
    fun setData(taskEntity: TaskEntity) {

        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.taskDao().insertTask(taskEntity)

            }
        }
    }

    fun editData(taskEntity: TaskEntity) {

        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.taskDao().updateTasks(taskEntity)

            }
        }
    }

    fun deleteData(taskEntity: TaskEntity) {

        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.taskDao().deleteTasks(taskEntity)

            }
        }

    }

    fun closeDatabase() {
        db.close()

    }

    fun getTasks(state: Boolean, onBindData: OnBindData) {
        tasksJob?.cancel()
        tasksJob = activity.lifecycleScope.launch {
            db.taskDao().getTaskByColumn(state)
                .collect { onBindData.getData(it) }
        }
    }

}


