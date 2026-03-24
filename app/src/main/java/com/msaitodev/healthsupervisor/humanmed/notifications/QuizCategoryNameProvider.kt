package com.msaitodev.healthsupervisor.humanmed.notifications

import android.content.Context
import com.msaitodev.healthsupervisor.humanmed.R
import com.msaitodev.quiz.core.domain.repository.CategoryNameProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * クイズアプリ向けのカテゴリ名称供給実装。
 * ディレクトリ名（ID）を、Hub層の strings.xml に定義された日本語名に変換します。
 */
@Singleton
class QuizCategoryNameProvider @Inject constructor(
    @ApplicationContext private val context: Context
) : CategoryNameProvider {
    override fun getDisplayName(categoryId: String): String {
        val resId = when (categoryId) {
            "01_laws_harmful" -> R.string.cat_01_laws_harmful
            "02_health_harmful" -> R.string.cat_02_health_harmful
            "03_laws_general" -> R.string.cat_03_laws_general
            "04_health_general" -> R.string.cat_04_health_general
            "05_physiology" -> R.string.cat_05_physiology
            "unclassified" -> R.string.cat_unclassified
            else -> null
        }
        
        return if (resId != null) {
            context.getString(resId)
        } else {
            // マッピングがない場合は ID をそのまま返し、不備に気づきやすくする
            categoryId
        }
    }
}
