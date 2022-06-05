package com.example.database

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.database.initializeDatabase.DatabaseItem
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var db: DatabaseItem

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getContext()
        db = Room.inMemoryDatabaseBuilder(
            context, DatabaseItem::class.java).build()
        runBlocking {
            db.insertItemDao()
                .insertItem(ItemModel(0, "Test1", "Description1", "324.43", 4, "category1"))
        }
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun getItem() = runBlocking {
        val context = InstrumentationRegistry.getContext()
        db = Room.inMemoryDatabaseBuilder(
            context, DatabaseItem::class.java
        ).build()

    assertThat(db.getItemDao().getAllItems().value.toString(), equals(ItemModel(0, "Test1", "Description1", "324.43", 4, "category1")))


    }
//    @Test
//    @Throws(Exception::class)
//    fun writeUserAndReadInList() {
//        val todo: TodoEntry = TodoEntry("title", "detail")
//        todoDao.insertAll(todo)
//        val todoItem = todoDao.findByTitle(todo.title)
//        assertThat(todoItem, equalTo(todo))
//    }

}