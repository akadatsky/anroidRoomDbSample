package com.akadatsky.dbsample.db

import androidx.room.*

@Dao
interface UserDao {

    @Transaction
    suspend fun transactionSample(user: User) {
        insertAll(user)
        delete(user)
    }

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    suspend fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    suspend fun findByName(first: String, last: String): User

    @Insert
    suspend fun insertAll(vararg users: User)

    @Delete
    suspend fun delete(user: User)

    @Query("DELETE FROM user")
    suspend fun removeAll()

}