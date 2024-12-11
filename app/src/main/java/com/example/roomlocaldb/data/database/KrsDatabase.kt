package com.example.roomlocaldb.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomlocaldb.data.dao.MahasiswaDao
import com.example.roomlocaldb.data.entity.Mahasiswa

//definisikan db dengan tabel Mahasiswa
@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {
    //definisikan fungsi untuk akses data mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object {
        @Volatile //memastikan bahwa nilai variabel instance selalu sama disemua thread
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java, //Class database
                    "KrsDatabase" //NamaDatabase
                )
                    .build().also { Instance = it }
            })
        }
    }
}