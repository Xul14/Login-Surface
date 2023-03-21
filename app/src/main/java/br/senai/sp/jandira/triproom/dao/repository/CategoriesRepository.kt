package br.senai.sp.jandira.triproom.dao.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.triproom.R
import br.senai.sp.jandira.triproom.model.Categories

class CategoriesRepository {

    companion object {
        @Composable
        fun getCategorieslist(): List<Categories> {
            return listOf<Categories>(
                Categories(
                    id = 1,
                    image = painterResource(id = R.drawable.mountains),
                    name = "Mountain"
                ),
                Categories(
                    id = 2,
                    image = painterResource(id = R.drawable.ski),
                    name = "Snow"
                ),
                Categories(
                    id = 3,
                    image = painterResource(id = R.drawable.beach),
                    name = "Beach"
                )
            )
        }
    }

}