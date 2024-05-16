package com.example.srodenas.example_with_catalogs.data.users.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.srodenas.example_with_catalogs.data.users.database.converters.DateConverter
import com.example.srodenas.example_with_catalogs.data.users.database.dao.AlertDao
import com.example.srodenas.example_with_catalogs.data.users.database.dao.UserDao
import com.example.srodenas.example_with_catalogs.data.users.database.entities.AlertEntity
import com.example.srodenas.example_with_catalogs.data.users.database.entities.UserEntity


@Database(
    entities = [UserEntity::class,
        AlertEntity::class],
    version = 2 ,
    exportSchema = false,
   /**         autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ]*/
)
@TypeConverters(DateConverter::class)
abstract class UserDataBase : RoomDatabase(){
 /**   var database = databaseBuilder(
        context,
        UserDataBase::class.java, "user"
    )
        .fallbackToDestructiveMigration()
        .build()*/
 /**companion object {
     private var INSTANCE: UserDataBase? = null
     fun getInstance(context: Context): UserDataBase? {
         if (INSTANCE == null) {
             INSTANCE = Room.databaseBuilder(
                 context.applicationContext, UserDataBase::class.java,
                 "user_db"
             ).fallbackToDestructiveMigration()
                 .allowMainThreadQueries().build()
         }
         return INSTANCE
     }
 }*/
 /**val MIGRATION_1_2 = object : Migration(1, 2) {
     override fun migrate(database: SupportSQLiteDatabase) {
         database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, `name` TEXT, " +
                 "PRIMARY KEY(`id`))")
     }
 }

    val MIGRATION_2_3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE Book ADD COLUMN pub_year INTEGER")
        }
    }

    Room.databaseBuilder(Context , UserDataBase::class.java, "user-database")
    .addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()*/
   /** val MIGRATION_1_2 = object : Migration(1, 2) {
     override fun migrate(database: SupportSQLiteDatabase) {

     }
 }
    var INSTANCE: UserDataBase?=null
    fun getUserDataBase(context: Context): UserDataBase?{
        if(INSTANCE==null){
            INSTANCE= Room.databaseBuilder(
                context.applicationContext,UserDataBase::class.java,"user_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
        return INSTANCE
    }
    fun cleanDbObject(){
        INSTANCE=null
    }*/
    abstract fun userDao(): UserDao
    abstract fun alertsDao(): AlertDao
    companion object {
        @Volatile
        private var INSTANCE: UserDataBase? = null

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Aquí colocas el código para realizar la migración de la versión 1 a la versión 2
                // Por ejemplo, si necesitas agregar una nueva columna:
                // database.execSQL("ALTER TABLE UserEntity ADD COLUMN new_column_name TEXT NOT NULL DEFAULT ''")
            }
        }

        fun getInstance(context: Context): UserDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDataBase::class.java,
                    "user_database"
                )
                    .addMigrations(MIGRATION_1_2) // Agregar la migración definida
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
