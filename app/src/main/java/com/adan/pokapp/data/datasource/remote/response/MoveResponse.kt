package com.adan.pokapp.data.datasource.remote.response

import com.adan.pokapp.data.datasource.remote.model.MoveModel
import com.google.gson.annotations.SerializedName

data class MoveResponse(@SerializedName("results") val result: List<MoveModel>)
