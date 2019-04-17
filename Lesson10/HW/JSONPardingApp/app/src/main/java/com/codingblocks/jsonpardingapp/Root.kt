package com.codingblocks.jsonpardingapp

class Root (val totalCount : Int, val incompleteResult : Boolean, val items : ArrayList<User>)

class User (val login : String, val id : Int, val nodeId : String, val avatarUrl : String, val url : String, val htmlUrl : String)
