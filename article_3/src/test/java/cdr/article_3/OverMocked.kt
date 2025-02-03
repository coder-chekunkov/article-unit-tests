package cdr.article_3

import io.mockk.*
import org.junit.jupiter.api.*
import kotlin.system.measureTimeMillis

private interface ApiService {
    fun fetchData(): String
}

private class Repository(private val apiService: ApiService) {
    fun getData(): String {
        return apiService.fetchData()
    }
}

private class ClientService(private val repository: Repository) {
    fun processUserData(): String {
        return repository.getData()
    }
}

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
private class OptimizedMockingTest {

    private val apiService = mockk<ApiService>()
    private val repository = Repository(apiService)
    private val clientService = ClientService(repository)

    @BeforeEach
    fun setup() {
        every { apiService.fetchData() } returns "OptimizedData"
    }

    @TestFactory
    fun `100 optimized tests`() = List(100) {
        DynamicTest.dynamicTest("Optimized test #$it") {
            val result = clientService.processUserData()
            assert(result == "OptimizedData")
        }
    }

    @Test
    fun `Measure optimized execution time`() {
        val time = measureTimeMillis {
            repeat(100) {
                clientService.processUserData()
            }
        }
        println("Optimized Mocking Execution Time: $time ms")
    }
}


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OverMockingTest {

    private val apiService = mockk<ApiService>()
    private val repository = mockk<Repository>()
    private val clientService = mockk<ClientService>()

    @BeforeEach
    fun setup() {
        every { apiService.fetchData() } returns "MockedData"
        every { repository.getData() } returns apiService.fetchData()
        every { clientService.processUserData() } returns repository.getData()
    }

    @TestFactory
    fun `100 over-mocked tests`() = List(100) {
        DynamicTest.dynamicTest("Over-mocked test #$it") {
            val result = clientService.processUserData()
            assert(result == "MockedData")
        }
    }

    @Test
    fun `Measure over-mocked execution time`() {
        val time = measureTimeMillis {
            repeat(100) {
                clientService.processUserData()
            }
        }
        println("Over-mocked Execution Time: $time ms")
    }
}