package cdr.aricle_1.payment

/**
 * Сервис, который используется для отправки аналитических данных при оплате <br/>
 *
 *  - [paymentSuccess] используется для отправки аналитической метрики при успешной оплате
 *  - [paymentFailure] используется для отправки аналитической метрики при возникшей ошибки
 */
internal interface AnalyticsService {

    fun paymentSuccess(orderId: String, amount: Int)

    fun paymentFailure(orderId: String, amount: Int)
}

/**
 * Cервис, который имитирует оплату
 */
internal interface PaymentGateway {
    fun payProcess(amount: Int): Boolean
}

/**
 * Менеджер оплаты. <br/>
 *
 * Метод [pay] используется для оплаты чего-либо. В случае успешной оплаты - отправится аналитическая
 * метрика об успешной оплате, иначе - аналитическая метрика об ошибке.
 */
internal class PaymentManager(
    private val paymentGateway: PaymentGateway,
    private val analytics: AnalyticsService
) {

    fun pay(orderId: String, amount: Int) {
        val isSuccess = paymentGateway.payProcess(amount)

        if (isSuccess) {
            analytics.paymentSuccess(orderId, amount)
        } else {
            analytics.paymentFailure(orderId, amount)
        }
    }
}