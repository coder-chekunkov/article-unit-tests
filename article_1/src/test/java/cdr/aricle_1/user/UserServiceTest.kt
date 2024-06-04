package cdr.aricle_1.user

import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

/**
 * Тест для [UserService]
 */
internal class UserServiceTest {

    private val userService = mockk<UserService>()

    @Test
    fun `get username using suspend fun`() = runTest {
        val id = 10101
        val expected = "Alexandr Chekunkov"
        coEvery { userService.getUsername(id) } returns expected

        val actual = userService.getUsername(id)

        assertThat(actual).isEqualTo(expected)
        coVerify { userService.getUsername(id) }
    }
}