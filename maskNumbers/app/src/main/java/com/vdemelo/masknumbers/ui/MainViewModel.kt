package com.vdemelo.masknumbers.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vdemelo.masknumbers.common.NumberTypeEnum

/**
 * Created by Vinicius Andrade on 10/9/2021.
 */
class MainViewModel: ViewModel() {

    private var _numberType: MutableLiveData<NumberTypeEnum> = MutableLiveData(NumberTypeEnum.Cpf)
    val numberType: LiveData<NumberTypeEnum>
        get() = _numberType


    fun setNumberType(numberType: NumberTypeEnum) = _numberType.postValue(numberType)

}