package com.example.nasa.core.viewmodel

import kotlinx.coroutines.CoroutineScope

expect abstract class KmpViewModel constructor() {

    protected val scope: CoroutineScope
}
