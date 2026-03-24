package com.msaitodev.healthsupervisor.humanmed.di

import com.msaitodev.core.common.config.AppAssetConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object QuizConfigModule {

    @Provides
    @Singleton
    fun provideAppAssetConfig(): AppAssetConfig {
        return AppAssetConfig(
            assetDataDirectory = "quiz_data",
            totalExamQuestions = 44, // 第一種衛生管理者の設問数（44問）
            passingScoreThreshold = 0.6f // 全体の60%以上で合格
        )
    }
}
