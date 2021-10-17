package com.vdemelo.masknumbers.common

/**
 * Created by Vinicius Andrade on 10/14/2021.
 */
enum class NumberTypeEnum(val id: Int) {
    Cpf(0),
    Cnpj(1),
    CreditCard(2),
    Phone(3);

    companion object {
        private val types = values().associateBy { it.id }

        fun findById(value: Int) : NumberTypeEnum = types[value] ?: Cpf
    }
}