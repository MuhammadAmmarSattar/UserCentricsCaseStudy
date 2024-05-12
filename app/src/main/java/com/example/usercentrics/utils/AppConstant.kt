package com.example.usercentrics.utils

object AppConstant {

    const val SETTING_ID = "gChmbFIdL"
   const val PURCHASE_ACTIVITY = "Purchase activity"
   const val BANK_DETAILS = "Bank details"
   const val CREDIT_DEBIT_CARD_NUMBER = "Credit and debit card number"
   const val SEARCH_TERMS = "Search terms"
   const val GEOGRAPHIC_LOCATION = "Geographic location"
   const val IP_ADDRESS = "IP address"

   val dataTypeCosts = hashMapOf(
        "Configuration of app settings" to 1,
        "IP address" to 2,
        "User behaviour" to 2,
        "User agent" to 3,
        "App crashes" to -2,
        "Browser information" to 3,
        "Credit and debit card number" to 4,
        "First name" to 6,
        "Geographic location" to 7,
        "Date and time of visit" to 1,
        "Advertising identifier" to 2,
        "Bank details" to 5,
        "Purchase activity" to 6,
        "Internet service provider" to 4,
        "JavaScript support" to -1
    )


}