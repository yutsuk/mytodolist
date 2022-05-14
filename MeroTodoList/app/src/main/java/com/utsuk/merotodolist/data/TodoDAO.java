package com.utsuk.merotodolist.data;

/*
 * Utsuk Paudayal
 * C7227233
 */

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.utsuk.merotodolist.model.ETodo;

import java.util.List;

@Dao
public interface TodoDAO {
    @Insert
    void insert(ETodo todo);
    @Delete
    void deleteById(ETodo todo);
    @Query("DELETE FROM todo_table")
    void deleteAll();
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(ETodo... todos);

    @Query("SELECT * FROM todo_table ORDER BY todo_date, priority asc")
    LiveData<List<ETodo>> getAllTodos();

    @Query("SELECT * FROM todo_table WHERE id=:id")
    ETodo getTodoById(int id);

  @Query("Delete From todo_table where is_completed=1")
    void deleteCompleted();

}
