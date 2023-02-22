package com.vipulasri.jetinstagram.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.vipulasri.jetinstagram.model.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
object FavoriteRepository {

    private val usersList = mutableStateOf<List<User>>(emptyList())

    private fun populateUsers() {
        val _usersList = ArrayList<User>()

        _usersList.add(
            User(
                image = currentUser.image,
                name = "name",
                username = "user name"
            )
        )

        (0..9).forEach { index ->
            val user = User(
                image = "https://randomuser.me/api/portraits/men/${index + 1}.jpg",
                name = names[index],
                username = userNames[index]
            )
            _usersList.add(user)
        }

        usersList.value = _usersList
    }

    init {
        populateUsers()
    }

    fun observeStories(): MutableState<List<User>> = usersList

}