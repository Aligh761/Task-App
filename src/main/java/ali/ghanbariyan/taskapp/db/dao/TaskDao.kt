package ali.ghanbariyan.taskapp.db.dao

import ali.ghanbariyan.taskapp.db.DBHandler
import ali.ghanbariyan.taskapp.db.entity.TaskEntity
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert
    fun insertTask(vararg task: TaskEntity)

    @get:Query("SELECT * FROM ${DBHandler.DATABASE_TABLE}")
    val getTask: Flow<List<TaskEntity>>

    @Query("SELECT * FROM ${DBHandler.DATABASE_TABLE} WHERE state = :type")
    fun getTaskByColumn(type: Boolean): Flow<List<TaskEntity>>

    @Update
    fun updateTasks(vararg tasks: TaskEntity): Int

    @Delete
    fun deleteTasks(vararg tasks: TaskEntity): Int

    @Query("DELETE FROM ${DBHandler.DATABASE_TABLE}")
    fun deleteAllTasks()

}