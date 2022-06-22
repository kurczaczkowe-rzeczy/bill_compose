package pl.kurczaczkowe.bills.db

import android.content.Context
import android.graphics.Color
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pl.kurczaczkowe.bills.R
import pl.kurczaczkowe.bills.db.dao.CategoryDao
import pl.kurczaczkowe.bills.db.entity.CategoryEntity
import kotlin.coroutines.EmptyCoroutineContext

@Database(
    version = 1,
    entities = [
        CategoryEntity::class,
    ],
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    private class DatabaseCallback(
        private val context: Context,
        private val scope: CoroutineScope
    ): RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(
                        database.categoryDao(),
                    )
                }
            }
        }

        private suspend fun populateDatabase(
            categoryDao: CategoryDao,

        ) {
            categoryDao.bulbInsert(createCategories())
        }

        private fun createCategories(): List<CategoryEntity> {
            return listOf(
                CategoryEntity(
                    nameCategory = context.getString(R.string.category_name_meat),
                    colorCategory = Color.parseColor("#FF4F4F"),
                    isPremadeCategory = true
                ),
                CategoryEntity(
                    nameCategory = context.getString(R.string.category_name_bread),
                    colorCategory = Color.parseColor("#FFB84F"),
                    isPremadeCategory = true
                ),
                CategoryEntity(
                    nameCategory = context.getString(R.string.category_name_seafood),
                    colorCategory = Color.parseColor("#4FCAFF"),
                    isPremadeCategory = true
                ),
                CategoryEntity(
                    nameCategory = context.getString(R.string.category_name_vegetables),
                    colorCategory = Color.parseColor("#3DC753"),
                    isPremadeCategory = true
                ),
                CategoryEntity(
                    nameCategory = context.getString(R.string.category_name_dairy),
                    colorCategory = Color.parseColor("#C6C85A"),
                    isPremadeCategory = true
                ),
                CategoryEntity(
                    nameCategory = context.getString(R.string.category_name_XXX),
                    colorCategory = Color.parseColor("#C9642C"),
                    isPremadeCategory = true
                ),
                CategoryEntity(
                    nameCategory = context.getString(R.string.category_name_spices),
                    colorCategory = Color.parseColor("#FC65FF"),
                    isPremadeCategory = true
                ),
                CategoryEntity(
                    nameCategory = context.getString(R.string.category_name_canned),
                    colorCategory = Color.parseColor("#979797"),
                    isPremadeCategory = true
                ),
                CategoryEntity(
                    nameCategory = context.getString(R.string.category_name_alcohol),
                    colorCategory = Color.parseColor("#C9482C"),
                    isPremadeCategory = true
                ),
                CategoryEntity(
                    nameCategory = context.getString(R.string.category_name_chemicals),
                    colorCategory = Color.parseColor("#874FFF"),
                    isPremadeCategory = true
                ),
                CategoryEntity(
                    nameCategory = context.getString(R.string.category_name_other),
                    colorCategory = Color.parseColor("#43D1B8"),
                    isPremadeCategory = true
                ),
            )
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(
                    context,
                    CoroutineScope(EmptyCoroutineContext)
                ).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "kurczaczkowe.bills"
            )
                .addCallback(DatabaseCallback(context, scope))
                .build()
        }
    }
}