package cdr.aricle_1.payment

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verifySequence
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Тест для [PaymentManager]
 */
internal class PaymentManagerTest {

    private lateinit var paymentManager: PaymentManager
    private lateinit var paymentGateway: PaymentGateway
    private lateinit var analytics: AnalyticsService

    @BeforeEach
    fun `set up`() {
        paymentGateway = mockk()
        analytics = mockk()
        paymentManager = PaymentManager(paymentGateway, analytics)
    }

    @AfterEach
    fun `tear down`() {
        clearAllMocks()
    }

    @Test
    fun `successful payment`() {
        val orderId = "orderId"
        val amount = 100
        every { paymentGateway.payProcess(amount) } returns true
        every { analytics.paymentSuccess(orderId, amount) } just runs

        paymentManager.pay(orderId, amount)

        verifySequence {
            paymentGateway.payProcess(amount)
            analytics.paymentSuccess(orderId, amount) // метрика успеха
        }
    }

    @Test
    fun `failure payment`() {
        val orderId = "orderId"
        val amount = 100
        every { paymentGateway.payProcess(amount) } returns false
        every { analytics.paymentFailure(orderId, amount) } just runs

        paymentManager.pay(orderId, amount)

        verifySequence {
            paymentGateway.payProcess(amount)
            analytics.paymentFailure(orderId, amount) // метрика ошибки
        }
    }
}