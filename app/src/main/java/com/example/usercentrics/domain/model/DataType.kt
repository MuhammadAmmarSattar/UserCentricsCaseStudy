package com.example.usercentrics.domain.model

sealed class DataType {
    companion object {
        const val CONFIGURATION_OF_APP_SETTINGS = "Configuration of app settings"
        const val IP_ADDRESS = "IP address"
        const val USER_BEHAVIOUR = "User behaviour"
        const val USER_AGENT = "User agent"
        const val APP_CRASHES = "App crashes"
        const val BROWSER_INFORMATION = "Browser information"
        const val CREDIT_AND_DEBIT_CARD_NUMBER = "Credit and debit card number"
        const val FIRST_NAME = "First name"
        const val GEOGRAPHIC_LOCATION = "Geographic location"
        const val DATE_TIME_OF_VISIT = "Date and time of visit"
        const val ADVERTISING_IDENTIFIER = "Advertising identifier"
        const val BANK_DETAILS = "Bank details"
        const val PURCHASE_ACTIVITY = "Purchase activity"
        const val INTERNET_SERVICE_PROVIDER = "Internet service provider"
        const val JAVASCRIPT_SUPPORT = "JavaScript support"
    }
}