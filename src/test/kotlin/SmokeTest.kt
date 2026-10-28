import org.junit.jupiter.api.Test
import pages.LoginPage

class SmokeTest: BaseTest() {

    @Test
    fun loginPageOpens() {
        LoginPage().open().shouldBeOpened()
    }
}