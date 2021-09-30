package com.example.morrassignment.utils

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Validation {

    fun checkCardNumberValidation(digits:String):Boolean{

        val checksum = digits
            .map { it.code - '0'.code }
            .reversed()
            .mapIndexed { index, value ->
                if (index % 2 == 1 && value < 9) value * 2 % 9 else value
            }
            .sum()

        Log.d("adi", "getCardNumberValidation:$checksum ")
        return checksum % 10 == 0
    }

    fun checkAcceptedCards(cardNumber: String):Boolean{
        val visa = Regex("4[0-9]{12}(?:[0-9]{3})?$")
        val mastercard = Regex("5[1-5][0-9]{14}\$|^2(?:2(?:2[1-9]|[3-9][0-9])|[3-6][0-9][0-9]|7(?:[01][0-9]|20))[0-9]{12}\$")
        val amex = Regex("3[47][0-9]{13}\$")
        val discover = Regex("65[4-9][0-9]{13}|64[4-9][0-9]{13}|6011[0-9]{12}|(622(?:12[6-9]|1[3-9][0-9]|[2-8][0-9][0-9]|9[01][0-9]|92[0-5])[0-9]{10})\$")

        return cardNumber.matches(visa) || cardNumber.matches(mastercard) || cardNumber.matches(amex) || cardNumber.matches(discover)
    }

    fun checkDate(date:String):Boolean{
        val regex = Regex("((0[1-9]|1[012])/[0-9]{2})")
        return date.matches(regex)
    }

    fun checkSecurityCode(securityCode:String):Boolean{
        val regex = Regex("^[0-9]{3,4}$")
        return securityCode.matches(regex)
    }

    fun checkName(name:String):Boolean{
        val regex = Regex("^[a-zA-Z]+\$")
        return name.matches(regex)
    }
}