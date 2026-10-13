package ali.ghanbariyan.taskapp.db.entity

import ali.ghanbariyan.taskapp.db.DBHandler.Companion.DATABASE_TABLE
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(DATABASE_TABLE)
data class TaskEntity (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo val title : String,
    @ColumnInfo val state : Boolean

)