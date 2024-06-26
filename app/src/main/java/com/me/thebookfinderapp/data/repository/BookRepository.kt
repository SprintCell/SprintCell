package com.me.thebookfinderapp.data.repository

import com.me.thebookfinderapp.data.api.BooksApiService
import com.me.thebookfinderapp.data.model.GoogleBooksResult
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BookRepository(private val booksApiService: BooksApiService) {

    fun findBooks(name:String): Observable<GoogleBooksResult>? =
            booksApiService.listBooks(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
}