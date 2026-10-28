package pages
import com.codeborne.selenide.CollectionCondition.size
import com.codeborne.selenide.Condition.exactText
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements

class InventoryPage {
    private val inventoryItems = elements(".inventory_item")
    private val title = element(".title")
    private val addBackpackButton = element("#add-to-cart-sauce-labs-backpack")
    private val cartBadge = element(".shopping_cart_badge")
    private val cartLink = element(".shopping_cart_link")

    fun shouldBeOpened(): InventoryPage {
        title.shouldHave(text("Products"))
        return this
    }

    fun shouldHaveItems(count: Int): InventoryPage {
        inventoryItems.shouldHave(size(count))
        return this
    }

    fun addBackpackToCart(): InventoryPage {
        addBackpackButton.click()
        return this
    }

    fun shouldHaveCartCount(count: Int): InventoryPage {
        cartBadge.shouldHave(exactText(count.toString()))
        return this
    }

    fun openCart(): CartPage {
        cartLink.click()
        return CartPage()
    }
}