package com.example.repasoap2.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.repasoap2.data.DataBase
import com.example.repasoap2.data.local.entity.Ticket
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides

    fun appDataBase(@ApplicationContext appDataContect: Context): DataBase =
        Room.databaseBuilder(
            appDataContect,
            DataBase::class.java,
            "DataBase.db"
        ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun providesTicketDao(db: DataBase) = db.ticketDao()

    @Provides
    @Singleton
    fun providesPrestamoDao(db: DataBase) = db.prestamoDao()

    @Provides
    @Singleton
    fun providesPersonasDao(db: DataBase) = db.personasDao()

    @Provides
    @Singleton
    fun providesJugosDao(db: DataBase) = db.jugosDao()
    
}