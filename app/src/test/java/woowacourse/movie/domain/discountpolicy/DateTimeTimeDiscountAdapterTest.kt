package woowacourse.movie.domain.discountpolicy

import org.assertj.core.api.Assertions
import org.junit.Test
import java.time.LocalDateTime

class DateTimeTimeDiscountAdapterTest {
    @Test
    fun `무비데이, 조조, 야간이 아니면 할인이 없다`() {
        // given
        val dateTime = LocalDateTime.of(2023, 4, 1, 17, 0)
        val price = 13000
        val expected = 13000
        // when
        val actual = DateTimeTimeDiscountAdapter(dateTime).discount(price)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `조조 시간이면 2000원 할인된다`() {
        // given
        val dateTime = LocalDateTime.of(2023, 4, 1, 9, 0)
        val price = 13000
        val expected = 11000
        // when
        val actual = DateTimeTimeDiscountAdapter(dateTime).discount(price)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `야간 시간이면 2000원 할인된다`() {
        // given
        val dateTime = LocalDateTime.of(2023, 4, 1, 20, 0)
        val price = 13000
        val expected = 11000
        // when
        val actual = DateTimeTimeDiscountAdapter(dateTime).discount(price)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `무비데이면 10프로 할인된다`() {
        // given
        val dateTime = LocalDateTime.of(2023, 4, 10, 17, 0)
        val price = 13000
        val expected = 11700
        // when
        val actual = DateTimeTimeDiscountAdapter(dateTime).discount(price)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `무비데이이면서 조조시간이면 10프로 할인에 2000원 할인된다`() {
        // given
        val dateTime = LocalDateTime.of(2023, 4, 10, 10, 0)
        val price = 13000
        val expected = 9700

        // when
        val actual = DateTimeTimeDiscountAdapter(dateTime).discount(price)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `무비데이이면서 야간시간이면 10프로 할인에 2000원 할인된다`() {
        // given
        val dateTime = LocalDateTime.of(2023, 4, 10, 10, 0)
        val price = 13000
        val expected = 9700

        // when
        val actual = DateTimeTimeDiscountAdapter(dateTime).discount(price)

        // then
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}
