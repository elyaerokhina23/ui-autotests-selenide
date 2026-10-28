package pages

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element

class LoginPage {
    private val userNameInput = element("#user-name")
    private val passwordInput = element("#password")
    private val loginButton = element("#login-button")
    private val errorMessage = element("[data-test='error']")

    fun open(): LoginPage {
        Selenide.open("/")
        return this
    }

    private fun submit(user: String, password: String) {
        userNameInput.setValue(user)
        passwordInput.setValue(password)
        loginButton.click()
    }

    fun login(user: String, password: String): InventoryPage {
        submit(user, password)
        return InventoryPage()
    }

    fun loginExpectingError(user: String, password: String): LoginPage {
        submit(user, password)
        return this
    }

    fun shouldShowError(message: String): LoginPage {
        errorMessage.shouldHave(text(message))
        return this
    }

    fun shouldBeOpened(): LoginPage {
        loginButton.shouldBe(visible)
        return this
    }
}