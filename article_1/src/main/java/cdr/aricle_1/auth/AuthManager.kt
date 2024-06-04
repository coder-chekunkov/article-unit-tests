package cdr.aricle_1.auth

/**
 * Данные для авторизации
 *
 * @property username логин пользователя
 * @property password пароль пользователя
 */
internal data class AuthData(
    val username: String,
    val password: String
)

/**
 * Cервис, который имитирует запрос на удаленый сервис для авторизации
 */
internal interface AuthService {
    fun auth(authData: AuthData): String?
}

/**
 * Класс, который используется для авторизации. <br/>
 *
 * Метод [login] обращается к сервису, имитирующий запрос на удаленый сервис.
 * Если аутентификация прошла успешно - возвращается JWToken, иначе возвращает null.
 */
internal class AuthManager(private val authService: AuthService) {

    fun login(username: String, password: String): String? {
        return authService.auth(authData = AuthData(username, password))
    }
}