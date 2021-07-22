package fi.monad.user

import fi.monad.bantamweight.database.FetchAllUsers

data class Credentials(val email: String, val password: String)

data class UserIn(val email: String, val firstName: String, val lastName: String, val password: String)

data class UserOut(
    val email: String,
    val firstName: String,
    val lastName: String,
    val roles: List<String> = emptyList(),
    val accessToken: String,
)

data class UserListItemOut(
    val email: String,
    val firstName: String,
    val lastName: String,
    val roles: List<String> = emptyList(),
)

fun List<FetchAllUsers>.toDTO(): List<UserListItemOut> = map {
    UserListItemOut(
        it.email,
        it.first_name,
        it.last_name,
        (it.roles ?: "").split(",")
    )
}

data class NewPasswordIn(val email: String, val oldPassword: String, val newPassword: String)
