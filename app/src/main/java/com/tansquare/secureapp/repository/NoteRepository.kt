package com.tansquare.secureapp.repository

import androidx.lifecycle.LiveData
import com.tansquare.secureapp.roomdb.Note
import com.tansquare.secureapp.roomdb.NoteDao

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class NoteRepository(private val noteDao: NoteDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Note>> = noteDao.getNotesListAphabetically()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

}
