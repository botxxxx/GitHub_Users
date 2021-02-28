package com.example.test.viewmodels

import com.example.test.data.*

class RecyclerViewModel(item:RecyclerItemData){
    val name = checkNotNull(item.name)

}