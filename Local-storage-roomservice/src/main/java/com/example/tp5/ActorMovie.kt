package com.example.tp5

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "actor_movie",
    primaryKeys = ["id_actor","id_movie"],
    foreignKeys =
    arrayOf(
        ForeignKey(entity =
            Actor::class,
            parentColumns = arrayOf("id_actor"),
            childColumns = arrayOf("id_actor"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(entity =
            Movie::class,
            parentColumns = arrayOf("id_movie"),
            childColumns = arrayOf("id_movie"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class ActorMovie(
    val id_actor:Long,
    val id_movie:Long
)