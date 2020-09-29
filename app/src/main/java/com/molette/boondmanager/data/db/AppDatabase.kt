package com.molette.boondmanager.data.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.molette.boondmanager.data.db.dao.AuthorDao
import com.molette.boondmanager.data.db.dao.BookDao
import com.molette.boondmanager.data.db.models.AuthorDb
import com.molette.boondmanager.data.db.models.BookDb
import kotlinx.serialization.ImplicitReflectionSerializer

@OptIn(ImplicitReflectionSerializer::class)
@Database(entities = [BookDb::class, AuthorDb::class],
    version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract val bookDao: BookDao
    abstract val authorDao: AuthorDao

    companion object{
        private const val DB_NAME = "books_db"

        fun buildDb(context: Context): AppDatabase{
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .addCallback(object : Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Log.d("buildDb", "Db created")
                    }
                })
                .build()
        }
    }
}