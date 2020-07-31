package com.raonsecure.jetpack.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao    // CRUD 작업을 정의 할 interface를 지정하는 annontation
public interface UserDao {

    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE uid IN(:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insertAll (User... users);

    @Delete
    void delete(User user);

    @Update
    void updateUsers(User... users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);
}
