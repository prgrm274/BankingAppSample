package com.programmer270487.bankingappsample

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.programmer270487.bankingappsample.utils.readJsonFile
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JsonFileReaderTest { // passed

    @Test
    fun testReadJsonFile() {
        val context: Context = ApplicationProvider.getApplicationContext()
        val json = readJsonFile(context, "json3.json")

        // Here, you can perform assertions to test the behavior of the function.
        // For example, you can check if the returned JSON is not empty.
        assertEquals(true, json.isNotEmpty())
    }
}
