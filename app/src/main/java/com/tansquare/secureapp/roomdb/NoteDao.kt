package com.tansquare.secureapp.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {

    @Query("Select * from notes_table ORDER BY note ASC")
    fun getNotesListAphabetically(): LiveData<List<Note>>

    @Query("Select * from notes_table")
    fun getNotesList(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Note)

    @Query("DELETE FROM notes_table")
    suspend fun deleteAll()

}