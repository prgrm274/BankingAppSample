package com.programmer270487.bankingappsample

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.programmer270487.bankingappsample.ui.case2.PromoList
import com.programmer270487.bankingappsample.data.local.case1.DataItem
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PromoListTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testPromoList() {
        val promoList = listOf<DataItem>()

        composeTestRule.setContent {
            PromoList(promos = promoList, onPromoClick = {})
        }

        // Now, you can use Espresso to interact with and verify the Composable
        // For example, you can verify the presence of items, scroll, and click on items.

        // Example: Verify the presence of Promo 1
        composeTestRule.onNodeWithText("BNI Kartu Kredit").assertIsDisplayed()

        // Example: Scroll to find Promo 3 and click on it
        composeTestRule.onNodeWithText("BNI Kartu Kredit").performClick()

        // You can add more Espresso actions and assertions as needed.
    }
}
