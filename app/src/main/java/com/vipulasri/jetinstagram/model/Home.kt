package com.vipulasri.jetinstagram.model

data class Post(
  val id: Int,
  val image: String,
  val user: User,
  val isLiked: Boolean = false,
  val likesCount: Int,
  val commentsCount: Int,
  val timeStamp: Long
)

data class Story(
  val image: String,
  val name: String,
  val isSeen: Boolean = false
)

val names = arrayOf(
    "storee",
    "nianyc",
    "opioke",
    "ashoke",
    "dark_emarlds",
    "bedtan",
    "shrish",
    "matdo",
    "phillsohn",
    "deitch"
)
val userNames = arrayOf(
    "userName_storee",
    "userName_nianyc",
    "userName_opioke",
    "userName_ashoke",
    "userName_dark_emarlds",
    "userName_bedtan",
    "userName_shrish",
    "userName_matdo",
    "userName_phillsohn",
    "userName_deitch"
)