package com.vdemelo.masknumbers.utils

import android.text.Editable
import android.text.TextWatcher

/**
 * Created by Vinicius Andrade on 10/9/2021.
 */

class NumberTextWatcher(private var mask: String, private var is24h: Boolean = false) :
    TextWatcher {

    companion object {
        const val MASK_CHAR = '#'
        const val MASK_CPF = "###.###.###-##"
        const val MASK_CNPJ = "##.###.###/####-##"
        const val MASK_CREDIT_CARD = "#### #### #### ####"
        const val MASK_PHONE_NUMBER = "(##) #####-####"
    }

    private var isCursorRunning = false
    private var isDeleting = false
    private var valueOnlyDigits = ""

    override fun afterTextChanged(s: Editable?) {
        if (isCursorRunning || isDeleting) {
            return
        }
        isCursorRunning = true

        s?.let { editable ->
            valueOnlyDigits = removeMask(editable.toString())
            editable.clear()
            editable.append(applyMask(mask, valueOnlyDigits))
        }

        isCursorRunning = false
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        isDeleting = count > after
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    private fun removeMask(value: String): String {
        return Regex("\\D+").replace(value, "")
    }

    private fun applyMask(mask: String, onlyDigits: String): String {
        val maskPlaceholderCharCount = mask.count { it == MASK_CHAR }
        var maskCurrentCharIndex = 0
        var output = ""
        onlyDigits.take(maskPlaceholderCharCount.coerceAtMost(onlyDigits.length)).forEach { c ->
            for (i in maskCurrentCharIndex until mask.length) {
                if (mask[i] == MASK_CHAR) {
                    output += c
                    maskCurrentCharIndex += 1
                    break
                } else {
                    output += mask[i]
                    maskCurrentCharIndex = i + 1
                }
            }
        }
        return output
    }
}