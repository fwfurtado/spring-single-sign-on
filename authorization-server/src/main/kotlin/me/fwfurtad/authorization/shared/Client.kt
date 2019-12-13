package me.fwfurtad.authorization.shared

data class Client(val clientId: String, val clientSecret: String, val scopes: Set<String>, val grantTypes: Set<String>)
