package br.senai.sp.jandira.triproom.repository

import android.content.Context
import br.senai.sp.jandira.triproom.dao.TripDb
import br.senai.sp.jandira.triproom.model.User

class UserRepository(context: Context) {

    private val db = TripDb.getDatabase(context)

    fun save(user: User): Long{
        return db.userDao().save(user)
    }

}