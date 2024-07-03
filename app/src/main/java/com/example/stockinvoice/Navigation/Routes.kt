package com.example.stockinvoice.Navigation



sealed class routes(val route: String) {
    object home : routes("home")
    object profile: routes("profile")
    object search: routes("search")
    object splash: routes("splash")
    object bottomNav: routes("bottomNav")
    object login: routes("login")
    object register: routes("register")
}