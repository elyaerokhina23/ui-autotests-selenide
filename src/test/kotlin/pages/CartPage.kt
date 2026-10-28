package pages

import com.codeborne.selenide.CollectionCondition.itemWithText
import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide

class CartPage {
    private val title = Selenide.element(".title")
    private val itemNames = Selenide.elements(".inventory_item_name")

    fun shouldBeOpened(): CartPage {
        title.shouldHave(Condition.text("Your Cart"))
        return this
    }

    fun shouldContainItem(name: String): CartPage {
        itemNames.shouldHave(itemWithText(name))
        return this
    }
}