package com.example.morrassignment.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.morrassignment.R
import com.example.morrassignment.utils.Validation
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.fragment_credit_card_input.*


class CreditCardInputFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_credit_card_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardNumber = in_cc.editText?.text
        val date = in_date.editText?.text
        val securityCode = in_security_code.editText?.text
        val firstName = in_first_name.editText?.text
        val lastName = in_last_name.editText?.text
        var count1:Boolean
        var count2:Boolean
        var count3:Boolean
        var count4:Boolean
        var count5:Boolean

        btn_submit_payment.setOnClickListener {



           if(Validation().checkCardNumberValidation(cardNumber.toString()) && Validation().checkAcceptedCards(cardNumber.toString())){
               in_cc.error = null
               count1 = true
           }else{
               in_cc.error = "Invalid Card Number"
               count1 = false
           }

            if(Validation().checkDate(date.toString())){
                in_date.error = null
                count2 = true
            }
            else{
                in_date.error = "Invalid Date"
                count2 = false
            }
            if(Validation().checkSecurityCode(securityCode.toString())){
                in_security_code.error = null
                count3 = true
            }
            else{
                in_security_code.error = "Invalid Security Code"
                count3 = false
            }
            if(Validation().checkName(firstName.toString())){
                in_first_name.error = null
                count4 = true
            }
            else{
                in_first_name.error = "Invalid name"
                count4 = false
            }
            if(Validation().checkName(lastName.toString())){
                in_last_name.error = null
                count5 = true
            }
            else{
                in_last_name.error = "Invalid name"
                count5 = false
            }

            if(count1 && count2 && count3 && count4 && count5){
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Payment Successful")
                    .setPositiveButton("OK") { dialog, which ->
                    }
                    .show()
            }
        }

    }
}