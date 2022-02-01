package com.exequiel.challenge.beers

import android.app.Application
import com.exequiel.challenge.beers.features.detail.module.beerDetailModule
import com.exequiel.challenge.beers.features.list.module.beerListModule
import io.paperdb.Paper
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ChallengeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initPapperDb()
    }

    private fun initPapperDb() {
        Paper.init(this);
    }

    private fun initKoin(){
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@ChallengeApplication)
            modules(
                listOf(
                    beerListModule,
                    beerDetailModule
                )
            )
            koin.createRootScope()
        }
    }
}