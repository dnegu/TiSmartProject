package com.tismart.apptismart

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tismart.apptismart.features.auth.presentation.login.LoginScreen
import com.tismart.apptismart.features.auth.presentation.login.LoginState
import com.tismart.apptismart.core.presentation.PoppinsTypography
import com.tismart.apptismart.features.discover_benefits.presentation.DiscoverBenefitsCategoryDetailScreen
import com.tismart.apptismart.features.discover_benefits.presentation.DiscoverBenefitsCategoryListScreen
import com.tismart.apptismart.features.discover_benefits.presentation.DiscoverMyFavoriteBenefitsScreen
import com.tismart.apptismart.features.discover_benefits.presentation.DiscoverNewBenefitsScreen
import com.tismart.apptismart.features.discover_benefits.presentation.DiscoverYourBenefitsScreen
import com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement.ApplicationProgressScreen
import com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement.EducationalAgreementScreen
import com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement.RegistrationStatus
import com.tismart.apptismart.features.home.presentation.HomeScreen
import com.tismart.apptismart.features.home.presentation.HomeState
import com.tismart.apptismart.features.home.presentation.components.HomeChatBot
import com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution.CelebrateYourEvolutionDetailScreen
import com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution.CelebrateYourEvolutionListScreen
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.ApplicationFormScreen
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.ExploreMentorsScreen
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.OurMentorsDetailScreen
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.OurMentorsListScreen
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPath
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathDetailScreen
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathScreen
import com.tismart.apptismart.features.keeps_growing.presentation.home.KeepsGrowingScreen
import com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform.InnovateAndTransformScreen
import com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform.ProposalStatus
import com.tismart.apptismart.features.keeps_growing.presentation.status_of_my_idea.StatusOfMyIdeaScreen
import com.tismart.apptismart.features.news.News
import com.tismart.apptismart.features.news.presentation.news_detail.NewsDetailScreen
import com.tismart.apptismart.features.news.presentation.news_detail.NewsDetailState
import com.tismart.apptismart.features.news.presentation.news_list.NewsListScreen
import com.tismart.apptismart.features.news.presentation.news_list.NewsListState
import com.tismart.apptismart.features.notifications.presentation.NotificationsScreen
import com.tismart.apptismart.features.profile.presentation.edit_photo.ProfileEditPhotoScreen
import com.tismart.apptismart.features.profile.presentation.home.ProfileScreen
import com.tismart.apptismart.features.profile.presentation.home.ProfileState
import com.tismart.apptismart.features.profile.presentation.my_data.ProfileMyDataScreen
import com.tismart.apptismart.features.search.presentation.SearchScreen
import tismartproject.composeapp.generated.resources.Res
import tismartproject.composeapp.generated.resources.news_card

private val news = (1..10).map {
    News(
        label = if (it % 2 == 0) "IMPORTANTE" else null,
        title = "Teletrabajo del 11 al 13 de noviembre",
        description = "Gobierno dispone clases virtuales y teletrabajo del 11 al 13 de noviembre blabla bla",
        supporting = "Hace 50 min"
    )
}

@Preview
@Composable
private fun LoginScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(
                state = LoginState(),
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(
                state = HomeState(),
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun NewsListScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NewsListScreen(
                state = NewsListState(
                    news = news
                ),
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun NewsDetailScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NewsDetailScreen(
                state = NewsDetailState(
                    image = Res.drawable.news_card,
                    title = "Teletrabajo del 11 al 13 de noviembre",
                    description = "El Gobierno dispuso este viernes que los trabajadores del sector público de Lima Metropolitana, la provincia de Huaral y la provincia Constitucional del Callao realice teletrabajo los días lunes 11 martes 12 y miércoles 13 de noviembre del 2024.\n\nEllo con motivo de la realización de la Cumbre del Foro de Cooperación Económica Asia-Pacífico (APEC). Al respecto, Franco Muschi, socio del Departamento Laboral de Garrigues, comentó a Gestión sobre las opciones que tienen los empleadores y trabajadores en este contexto."
                ),
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun HomeChatBotScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeChatBot()

        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ProfileScreen(
                state = ProfileState(),
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun ProfileMyDataScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ProfileMyDataScreen()
        }
    }
}

@Preview
@Composable
private fun ProfileEditPhotoScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ProfileEditPhotoScreen()
        }
    }
}

@Preview
@Composable
private fun HomeTiSmartBuddyDialogPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HomeScreen(
                state = HomeState(
                    showTiSmartBuddyDialog = true
                ),
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun NotificationsScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NotificationsScreen()
        }
    }
}

@Preview
@Composable
private fun KeepsGrowingScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            KeepsGrowingScreen()
        }
    }
}

@Preview
@Composable
private fun CelebrateYourEvolutionListScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CelebrateYourEvolutionListScreen()
        }
    }
}

@Preview
@Composable
private fun CelebrateYourEvolutionDetailScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CelebrateYourEvolutionDetailScreen()
        }
    }
}

@Preview
@Composable
private fun GrowthPathScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GrowthPathScreen()
        }
    }
}

@Preview
@Composable
private fun GrowthPathDetailScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            GrowthPathDetailScreen(
                isAMan = true,
                growthPath = GrowthPath.SemiSenior
            )
        }
    }
}

@Preview
@Composable
private fun InnovateAndTransformScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            InnovateAndTransformScreen()
        }
    }
}

@Preview
@Composable
private fun StatusOfMyIdeaScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            StatusOfMyIdeaScreen(
                projectName = "Mi proyecto",
                status = ProposalStatus.UNDER_REVIEW
            )
        }
    }
}

@Preview
@Composable
private fun ExploreMentorsScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ExploreMentorsScreen()
        }
    }
}

@Preview
@Composable
private fun OurMentorsScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            OurMentorsListScreen()
        }
    }
}

@Preview
@Composable
private fun OurMentorsDetailScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            OurMentorsDetailScreen()
        }
    }
}

@Preview
@Composable
private fun ApplicationFormScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ApplicationFormScreen()
        }
    }
}

@Preview
@Composable
private fun DiscoverYourBenefitsScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DiscoverYourBenefitsScreen(
                onSearchBarClick = {}
            )
        }
    }
}

@Preview
@Composable
private fun DiscoverBenefitsCategoryListScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DiscoverBenefitsCategoryListScreen(
                title = "Finanzas"
            )
        }
    }
}

@Preview
@Composable
private fun DiscoverBenefitsCategoryDetailScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DiscoverBenefitsCategoryDetailScreen()
        }
    }
}

@Preview
@Composable
private fun DiscoverMyFavoriteBenefitsScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DiscoverMyFavoriteBenefitsScreen()
        }
    }
}

@Preview
@Composable
private fun DiscoverNewBenefitsScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DiscoverNewBenefitsScreen()
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SearchScreen(
                title = "Descubre tus beneficios"
            )
        }
    }
}

@Preview
@Composable
private fun EducationalAgreementScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            EducationalAgreementScreen()
        }
    }
}

@Preview
@Composable
private fun ApplicationProgressScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ApplicationProgressScreen(
                agreementName = "Interaction Design Foundation",
                status = RegistrationStatus.UNDER_REVIEW
            )
        }
    }
}
