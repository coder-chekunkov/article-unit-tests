package cdr.article_3

import io.mockk.*
import org.junit.jupiter.api.*
import kotlin.system.measureTimeMillis

private interface UserApi {
    fun fetchUser(id: Int): String
}

private class UserService(private val api: UserApi) {
    fun getUserById(id: Int): String {
        return api.fetchUser(id)
    }
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WithoutClearMocksTest {

    private val mockApi = mockk<UserApi>()
    private lateinit var userService: UserService

    @BeforeEach
    fun setup() {
        userService = UserService(mockApi)
        every { mockApi.fetchUser(any()) } returns "TestUser"
    }

    @TestFactory
    fun `100 tests without clearing mocks`() = List(1000) {
        DynamicTest.dynamicTest("Test without clearing mocks #$it") {
            val result = userService.getUserById(it)
            assert(result == "TestUser")
        }
    }

    @Test
    fun `Measure execution time without clearMocks`() {
        val time = measureTimeMillis {
            repeat(100) {
                userService.getUserById(it)
            }
        }
        println("Execution Time Without clearMocks: $time ms")
    }
}


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WithClearMocksTest {

    private val mockApi = mockk<UserApi>()
    private lateinit var userService: UserService

    @BeforeEach
    fun setup() {
        userService = UserService(mockApi)
        every { mockApi.fetchUser(any()) } returns "TestUser"
    }

    @AfterEach
    fun clear() {
        clearMocks(mockApi) // Освобождаем ресурсы
    }

    @TestFactory
    fun `100 tests with clearing mocks`() = List(1000) {
        DynamicTest.dynamicTest("Test with clearing mocks #$it") {
            val result = userService.getUserById(it)
            assert(result == "TestUser")
        }
    }

    @Test
    fun `Measure execution time with clearMocks`() {
        val time = measureTimeMillis {
            repeat(100) {
                userService.getUserById(it)
            }
        }
        println("Execution Time With clearMocks: $time ms")
    }
}