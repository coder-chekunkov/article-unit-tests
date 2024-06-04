package cdr.aricle_1.user

import kotlinx.coroutines.delay

/**
 * Сервис, который имитирует получение логина клиента от удаленного сервиса с задержкой в 2.000 миллисекунд.
 */
internal class UserService {

    suspend fun getUsername(id: Int): String {
        delay(2000) // Имитирование запроса на удаленный сервис
        return "Alexandr Chekunkov"
    }
}