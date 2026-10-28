import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pages.InventoryPage
import pages.LoginPage

class CartTest: BaseTest() {
    private lateinit var inventoryPage: InventoryPage

    @BeforeEach
    fun login() {
        inventoryPage = LoginPage()
            .open()
            .login("standard_user", "secret_sauce")
    }

    @Test
    fun addItemToCart() {
        inventoryPage
            .addBackpackToCart()
            .shouldHaveCartCount(1)
    }

    @Test
    fun backpackIsShownInCart() {
        inventoryPage.addBackpackToCart().openCart().shouldBeOpened().shouldContainItem("Sauce Labs Backpack")
    }
}