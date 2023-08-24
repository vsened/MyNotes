package com.vsened.mynotes.di

import android.app.Application
import androidx.room.Room
import com.vsened.mynotes.feature_note.data.data_source.NoteDatabase
import com.vsened.mynotes.feature_note.data.repository.NoteRepositoryImpl
import com.vsened.mynotes.feature_note.domain.repository.NoteRepository
import com.vsened.mynotes.feature_note.domain.use_case.AddNoteUseCase
import com.vsened.mynotes.feature_note.domain.use_case.DeleteNoteUseCase
import com.vsened.mynotes.feature_note.domain.use_case.GetNotesUseCase
import com.vsened.mynotes.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(application: Application): NoteDatabase {
        return Room.databaseBuilder(
            application,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            addNote = AddNoteUseCase(repository)
        )
    }

}