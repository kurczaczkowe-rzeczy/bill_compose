package pl.kurczaczkowe.bills.ui.screen.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ComplexEvent<T> {

    private val mErrorEvent: MutableLiveData<Event<Failure>> = MutableLiveData()
    val errorEvent: LiveData<Event<Failure>> = mErrorEvent

    private val mEvent: MutableLiveData<Event<T>> = MutableLiveData()
    val event: LiveData<Event<T>> = mEvent

    fun sendEvent(event: T) {
        mEvent.value = Event(event)
    }

    fun sendError(event: Failure) {
        mErrorEvent.value = Event(event)
    }
}