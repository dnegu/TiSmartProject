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
import com.tismart.apptismart.features.enhance_learning.presentation.event.EventRegistrationFormScreen
import com.tismart.apptismart.features.enhance_learning.presentation.event.EventRegistrationScreen
import com.tismart.apptismart.features.enhance_learning.presentation.home.EnhanceYourLearningScreen
import com.tismart.apptismart.features.enhance_learning.presentation.tismart_university.TiSmartLoversCourseDetailScreen
import com.tismart.apptismart.features.enhance_learning.presentation.tismart_university.TiSmartLoversCourseListScreen
import com.tismart.apptismart.features.enhance_learning.presentation.tismart_university.TiSmartUniversityScreen
import com.tismart.apptismart.features.explore_courses.presentation.ExploreCoursesRecommendedForYouScreen
import com.tismart.apptismart.features.explore_courses.presentation.ExploreCoursesSkillDetailScreen
import com.tismart.apptismart.features.explore_courses.presentation.ExploreCoursesSkillsListScreen
import com.tismart.apptismart.features.explore_courses.presentation.ExploreNewCoursesScreen
import com.tismart.apptismart.features.home.presentation.HomeScreen
import com.tismart.apptismart.features.home.presentation.HomeState
import com.tismart.apptismart.features.home.presentation.components.HomeChatbot
import com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution.CelebrateYourEvolutionDetailScreen
import com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution.CelebrateYourEvolutionListScreen
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.MentorApplicationFormScreen
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.ExploreMentorsScreen
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.OurMentorsDetailScreen
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.OurMentorsListScreen
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPath
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathDetailScreen
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathScreen
import com.tismart.apptismart.features.keeps_growing.presentation.home.KeepsGrowingScreen
import com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform.InnovateAndTransformScreen
import com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform.ProposalStatus
import com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform.StatusOfMyIdeaScreen
import com.tismart.apptismart.features.news.News
import com.tismart.apptismart.features.news.presentation.news_detail.NewsDetailScreen
import com.tismart.apptismart.features.news.presentation.news_detail.NewsDetailState
import com.tismart.apptismart.features.news.presentation.news_list.NewsListScreen
import com.tismart.apptismart.features.news.presentation.news_list.NewsListState
import com.tismart.apptismart.features.notifications.presentation.NotificationsScreen
import com.tismart.apptismart.features.profile.presentation.edit_picture.EditProfilePictureScreen
import com.tismart.apptismart.features.profile.presentation.home.ProfileScreen
import com.tismart.apptismart.features.profile.presentation.home.ProfileState
import com.tismart.apptismart.features.profile.presentation.my_data.ProfileMyDataScreen
import com.tismart.apptismart.features.search.presentation.SearchScreen
import com.tismart.apptismart.features.search.presentation.SearchType
import com.tismart.apptismart.features.vacancy.presentation.NewVacanciesScreen
import com.tismart.apptismart.features.vacancy.presentation.VacanciesRecommendedForYouScreen
import com.tismart.apptismart.features.vacancy.presentation.MyVacancyApplicationsScreen
import com.tismart.apptismart.features.vacancy.presentation.VacancyDashboardScreen
import com.tismart.apptismart.features.vacancy.presentation.VacancyDetailScreen
import com.tismart.apptismart.features.vacancy.presentation.VacancyListScreen
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
            ProfileMyDataScreen(
                onAction = {}
            )
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
            EditProfilePictureScreen(
                onAction = {}
            )
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
            NotificationsScreen(
                onAction = {}
            )
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
            KeepsGrowingScreen(
                onAction = {}
            )
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
            CelebrateYourEvolutionListScreen(
                onAction = {}
            )
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
            CelebrateYourEvolutionDetailScreen(
                onAction = {}
            )
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
            GrowthPathScreen(
                onAction = {}
            )
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
                growthPath = GrowthPath.SemiSenior,
                onAction = {}
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
            InnovateAndTransformScreen(
                onAction = {}
            )
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
                status = ProposalStatus.UNDER_REVIEW,
                onAction = {}
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
            ExploreMentorsScreen(
                onAction = {}
            )
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
            OurMentorsListScreen(
                onAction = {}
            )
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
            OurMentorsDetailScreen(
                onAction = {}
            )
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
            MentorApplicationFormScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun VacancyDashboardScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            VacancyDashboardScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun VacancyListScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            VacancyListScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun VacancyDetailScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            VacancyDetailScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun VacancyApplicationsScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MyVacancyApplicationsScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun NewVacanciesScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NewVacanciesScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun VacanciesRecommendedForYouScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            VacanciesRecommendedForYouScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun SearchVacanciesScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SearchScreen(
                searchType = SearchType.VACANCIES,
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun EnhanceYourLearningScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            EnhanceYourLearningScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun ExploreNewCoursesScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ExploreNewCoursesScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun ExploreCoursesSkillsListScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ExploreCoursesSkillsListScreen(
                title = "Frontend",
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun ExploreCoursesSkillDetailScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ExploreCoursesSkillDetailScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun ExploreCoursesRecommendedForYouScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ExploreCoursesRecommendedForYouScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun SearchCoursesScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SearchScreen(
                searchType = SearchType.COURSES,
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun TiSmartUniversityScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TiSmartUniversityScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun TiSmartLoversCourseListScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TiSmartLoversCourseListScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun TiSmartLoversCourseDetailScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TiSmartLoversCourseDetailScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun EventRegistrationScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            EventRegistrationScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun EventRegistrationFormScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            EventRegistrationFormScreen(
                onAction = {}
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
            EducationalAgreementScreen(
                onAction = {}
            )
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
                status = RegistrationStatus.UNDER_REVIEW,
                onAction = {}
            )
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
                onAction = {}
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
                title = "Finanzas",
                onAction = {}
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
            DiscoverBenefitsCategoryDetailScreen(
                onAction = {}
            )
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
            DiscoverMyFavoriteBenefitsScreen(
                onAction = {}
            )
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
            DiscoverNewBenefitsScreen(
                onAction = {}
            )
        }
    }
}

@Preview
@Composable
private fun SearchBenefitsScreenPreview() {
    MaterialTheme(
        typography = PoppinsTypography()
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SearchScreen(
                searchType = SearchType.BENEFITS,
                onAction = {}
            )
        }
    }
}