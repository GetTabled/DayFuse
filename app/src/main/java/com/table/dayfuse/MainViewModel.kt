package com.table.dayfuse

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    // A list to keep track of visible permission dialogs
    val visiblePermissionDialogQueue = mutableStateListOf<String>()

    // Function to dismiss the last permission dialog from the queue
    fun dismissDialog() {
        visiblePermissionDialogQueue.removeLast()
    }

    // Function to handle the result of a permission request
    fun onPermissionResult(
        permission: String,
        isGranted: Boolean
    ) {
        // If the permission is not granted, add it to the beginning of the queue
        if(!isGranted) {
            visiblePermissionDialogQueue.add(0, permission)
        }
    }
}