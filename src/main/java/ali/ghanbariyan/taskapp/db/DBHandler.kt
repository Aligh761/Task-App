package ali.ghanbariyan.taskapp.db

import ali.ghanbariyan.taskapp.db.dao.TaskDao
import ali.ghanbariyan.taskapp.db.entity.TaskEntity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [TaskEntity::class],
    version = DBHandler.DATABASE_VERSION
)

abstract class DBHandler : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {

        const val DATABASE_NAME = "taskApp_database"
        const val DATABASE_VERSION = 1
        const val DATABASE_TABLE = "TaskTable"

        @Volatile private var Instance: DBHandler? = null

        fun getDatabase(context: Context): DBHandler =
            Instance ?: synchronized(this) {
                Instance ?: Room.databaseBuilder(
                    context.applicationContext, DBHandler::class.java, DATABASE_NAME
                ).fallbackToDestructiveMigration().build().also { Instance = it }
            }


    }
}