package pl.gungnir.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T : SpecificEvent> : ViewModel() {

    protected val mErrorEvent: MutableLiveData<Event<Failure>> = MutableLiveData()
    val errorEvent: LiveData<Event<Failure>> = mErrorEvent

    protected val mEvent: MutableLiveData<Event<T>> = MutableLiveData()
    val event: LiveData<Event<T>> = mEvent


    fun sendEvent(event: T) {
        mEvent.value = Event(event)
    }

    fun sendError(event: Failure) {
        mErrorEvent.value = Event(event)
    }
}