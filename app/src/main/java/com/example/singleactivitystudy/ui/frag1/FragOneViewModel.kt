package com.example.singleactivitystudy.ui.frag1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FragOneViewModel @Inject constructor(): ViewModel() {

	val text: MutableLiveData<String> = MutableLiveData<String>().apply { value = "fragment one"}
	val navigateToFragTwo: MutableSharedFlow<Unit> = MutableSharedFlow<Unit>()


	fun onButtonClick() = viewModelScope.launch {
		text.value = "clicou one"
		delay(1000)
		navigateToFragTwo.emit(Unit)
	}

}