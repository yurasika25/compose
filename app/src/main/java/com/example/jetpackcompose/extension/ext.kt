package com.example.jetpackcompose.extension

import androidx.navigation.NavDestination
import com.example.jetpackcompose.navigation.NavRouts
import org.koin.core.component.getScopeName

fun NavDestination.checkRout(vararg routes: NavRouts): Boolean {
    routes.toList().forEach {
        if (this.route?.contains(it.getScopeName().value.run {
                substring(this.indexOf("$").plus(1))
            }) == true) {
            return true
        }
    }
    return false
}
