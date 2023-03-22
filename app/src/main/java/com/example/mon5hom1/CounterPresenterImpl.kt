package com.example.mon5hom1

interface CounterPresenter {
    fun onPlusButtonClicked()
    fun onMinusButtonClicked()
}

class CounterPresenterImpl(private var view: CounterView) : CounterPresenter {

    private var count = 0

    override fun onPlusButtonClicked() {
        count++
        view.updateCount(count)
        if (count == 10) {
            view.showCongratulations()
        }
        if (count == 15) {
            view.changeTextColorToGreen()
        }
    }

    override fun onMinusButtonClicked() {
        if (count > 0) {
            count--
            view.updateCount(count)
        }
        if (count == 14) {
            view.changeTextColorToDefault()
        }
    }
}