package br.senai.sp.jandira.triproom.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.model.Category

class CategoryRepository {

    companion object {
        @Composable
        fun getCategories(): List<Category> {
            return listOf<Category>(
                Category(
                    id = 1,
                    icon = painterResource(id = R.drawable.mountains),
                    name = "Mountain"
                ),
                Category(
                    id = 2,
                    icon = painterResource(id = R.drawable.ski),
                    name = "Snow"
                ),
                Category(
                    id = 3,
                    icon = painterResource(id = R.drawable.beach),
                    name = "Beach"
                ),
                Category(
                    id = 4,
                    icon = painterResource(id = R.drawable.baseline_business_center_24),
                    name = "Business"
                )
            )
        }
    }

}