package com.example.test.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UsersRepository @Inject constructor(private val dao: UsersDao) {

    fun getUsers() = dao.getUsers()

    fun getUser(userId: Long) = dao.getUser(userId)

    fun insert(text: CharSequence) = ioThread {
        dao.insert(UsersData(userId = 0, name = text.toString()))
    }

    fun remove(cheese: UsersData) = ioThread {
        dao.delete(cheese)
    }
}
