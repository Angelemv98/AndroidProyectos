package com.angelemv.android.stores

interface OnClickListener {
    fun onClick(storeEntity: StoreEntity)
    fun onfavoriteStore(storeEntity: StoreEntity)
    fun onDelete(storeEntity: StoreEntity)
}