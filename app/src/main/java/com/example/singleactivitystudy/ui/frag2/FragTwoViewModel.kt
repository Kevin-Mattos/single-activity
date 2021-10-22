package com.example.singleactivitystudy.ui.frag2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragTwoViewModel @Inject constructor(): ViewModel() {

	val text: MutableLiveData<String> = MutableLiveData<String>().apply { value = "fragment 2"}
	val navigateToFragOne: MutableSharedFlow<Unit> = MutableSharedFlow<Unit>()


	fun onButtonClick() = viewModelScope.launch {
		text.value = "clicou two"
		delay(1000)
		navigateToFragOne.emit(Unit)
	}
}