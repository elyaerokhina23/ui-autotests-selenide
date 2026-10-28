
import org.junit.jupiter.api.Test
import pages.LoginPage

class LoginTest: BaseTest() {

    @Test
    fun successfulLogin() {
        LoginPage().open()
            .login("standard_user", "secret_sauce")
            .shouldBeOpened().shouldHaveItems(6)
    }

    @Test
    fun lockedUserCannotLogin() {
        LoginPage()
            .open()
            .loginExpectingError("locked_out_user", "secret_sauce")
            .shouldShowError("Sorry, this user has been locked out.")
    }
}