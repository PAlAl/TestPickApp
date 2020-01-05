package com.example.test.domain.global.managers

import io.reactivex.Scheduler

interface ISchedulersManager {
    fun ui(): Scheduler
    fun computation(): Scheduler
    fun trampoline(): Scheduler
    fun newThread(): Scheduler
    fun io(): Scheduler
}