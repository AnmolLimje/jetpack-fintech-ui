package com.example.jetpackfintecapp.data.local

import android.content.Context
import android.content.SharedPreferences
import com.example.jetpackfintecapp.core.security.CryptoManager
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

/**
 * Best practice for Fintech: Securely store small pieces of data like 
 * session tokens or user preferences using encrypted SharedPreferences.
 */
class EncryptedPrefsManager(context: Context) {
    private val sharedPrefs: SharedPreferences = context.getSharedPreferences("secure_prefs", Context.MODE_PRIVATE)
    private val cryptoManager = CryptoManager()

    fun saveData(key: String, data: String) {
        val outputStream = ByteArrayOutputStream()
        cryptoManager.encrypt(data.toByteArray(), outputStream)
        val encryptedBase64 = android.util.Base64.encodeToString(outputStream.toByteArray(), android.util.Base64.DEFAULT)
        sharedPrefs.edit().putString(key, encryptedBase64).apply()
    }

    fun getData(key: String): String? {
        val encryptedBase64 = sharedPrefs.getString(key, null) ?: return null
        val encryptedBytes = android.util.Base64.decode(encryptedBase64, android.util.Base64.DEFAULT)
        val inputStream = ByteArrayInputStream(encryptedBytes)
        return String(cryptoManager.decrypt(inputStream))
    }
}
