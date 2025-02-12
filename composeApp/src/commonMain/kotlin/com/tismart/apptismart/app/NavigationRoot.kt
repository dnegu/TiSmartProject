package com.tismart.apptismart.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import com.tismart.apptismart.features.auth.presentation.login.LoginScreenRoot
import com.tismart.apptismart.features.discover_benefits.presentation.DiscoverBenefitsCategoryDetailScreenRoot
import com.tismart.apptismart.features.discover_benefits.presentation.DiscoverBenefitsCategoryListScreenRoot
import com.tismart.apptismart.features.discover_benefits.presentation.DiscoverMyFavoriteBenefitsScreenRoot
import com.tismart.apptismart.features.discover_benefits.presentation.DiscoverNewBenefitsScreenRoot
import com.tismart.apptismart.features.discover_benefits.presentation.DiscoverYourBenefitsScreenRoot
import com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement.ApplicationProgressScreenRoot
import com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement.EducationalAgreementScreenRoot
import com.tismart.apptismart.features.enhance_learning.presentation.event.EventRegistrationFormScreenRoot
import com.tismart.apptismart.features.enhance_learning.presentation.event.EventRegistrationScreenRoot
import com.tismart.apptismart.features.enhance_learning.presentation.home.EnhanceYourLearningScreenRoot
import com.tismart.apptismart.features.enhance_learning.presentation.tismart_university.TiSmartLoversCourseDetailScreenRoot
import com.tismart.apptismart.features.enhance_learning.presentation.tismart_university.TiSmartLoversCourseListScreenRoot
import com.tismart.apptismart.features.enhance_learning.presentation.tismart_university.TiSmartUniversityScreenRoot
import com.tismart.apptismart.features.explore_courses.presentation.ExploreCoursesRecommendedForYouScreenRoot
import com.tismart.apptismart.features.explore_courses.presentation.ExploreCoursesSkillDetailScreenRoot
import com.tismart.apptismart.features.explore_courses.presentation.ExploreCoursesSkillsListScreenRoot
import com.tismart.apptismart.features.explore_courses.presentation.ExploreNewCoursesScreenRoot
import com.tismart.apptismart.features.home.presentation.HomeScreenRoot
import com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution.CelebrateYourEvolutionDetailScreenRoot
import com.tismart.apptismart.features.keeps_growing.presentation.celebrate_your_evolution.CelebrateYourEvolutionListScreenRoot
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.ExploreMentorsScreenRoot
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.MentorApplicationFormScreenRoot
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.OurMentorsDetailScreenRoot
import com.tismart.apptismart.features.keeps_growing.presentation.explore_mentors.OurMentorsListScreenRoot
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathDetailScreenRoot
import com.tismart.apptismart.features.keeps_growing.presentation.growth_path.GrowthPathScreenRoot
import com.tismart.apptismart.features.keeps_growing.presentation.home.KeepsGrowingScreenRoot
import com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform.InnovateAndTransformScreenRoot
import com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform.StatusOfMyIdeaScreenRoot
import com.tismart.apptismart.features.news.presentation.news_detail.NewsDetailScreenRoot
import com.tismart.apptismart.features.news.presentation.news_list.NewsListScreenRoot
import com.tismart.apptismart.features.notifications.presentation.NotificationsScreenRoot
import com.tismart.apptismart.features.profile.presentation.edit_picture.EditProfilePictureScreenRoot
import com.tismart.apptismart.features.profile.presentation.home.ProfileScreenRoot
import com.tismart.apptismart.features.profile.presentation.my_data.ProfileMyDataScreenRoot
import com.tismart.apptismart.features.search.presentation.SearchScreenRoot
import com.tismart.apptismart.features.search.presentation.SearchType
import com.tismart.apptismart.features.vacancy.presentation.VacancyDashboardScreenRoot
import com.tismart.apptismart.features.vacancy.presentation.VacancyDetailScreenRoot
import com.tismart.apptismart.features.vacancy.presentation.VacancyListScreenRoot
import com.tismart.apptismart.features.vacancy.presentation.MyVacancyApplicationsScreenRoot
import com.tismart.apptismart.features.vacancy.presentation.NewVacanciesScreenRoot
import com.tismart.apptismart.features.vacancy.presentation.VacanciesRecommendedForYouScreenRoot
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) Route.HomeGraph else Route.AuthGraph
    ) {
        authGraph(navController)
        homeGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<Route.AuthGraph>(
        startDestination = Route.Login,
    ) {
        composable<Route.Login> {
            LoginScreenRoot(
                onLoginSuccess = {
                    navController.navigate(Route.HomeGraph) {
                        popUpTo(Route.AuthGraph) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.homeGraph(
    navController: NavHostController
) {
    navigation<Route.HomeGraph>(
        startDestination = Route.Home,
    ) {
        composable<Route.Home> {
            HomeScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onSeeAllNewsClick = {
                    navController.navigate(Route.NewsList)
                },
                onKeepGrowingClick = {
                    navController.navigate(Route.KeepsGrowing)
                },
                onSearchForNewVacanciesClick = {
                    navController.navigate(Route.VacancyDashboard)
                },
                onEnhanceLearningClick = {
                    navController.navigate(Route.EnhanceYourLearning)
                },
                onDiscoverMyBenefitsClick = {
                    navController.navigate(Route.DiscoverYourBenefits)
                }
            )
        }
        composable<Route.NewsList> {
            NewsListScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onNewsDetailClick = {
                    navController.navigate(Route.NewsDetail)
                }
            )
        }
        composable<Route.NewsDetail> {
            NewsDetailScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable<Route.Profile> {
            ProfileScreenRoot(
                onCloseClick = {
                    navController.navigateUp()
                },
                onMyDataClick = {
                    navController.navigate(Route.ProfileMyData)
                },
                onKeepGrowingClick = {
                    navController.navigate(Route.KeepsGrowing)
                },
                onSearchForNewVacanciesClick = {
                    navController.navigate(Route.VacancyDashboard)
                },
                onEnhanceLearningClick = {
                    navController.navigate(Route.EnhanceYourLearning)
                },
                onDiscoverMyBenefitsClick = {
                    navController.navigate(Route.DiscoverYourBenefits)
                },
                onLogoutClick = {
                    navController.navigate(Route.AuthGraph) {
                        popUpTo(Route.HomeGraph) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Route.ProfileMyData> {
            ProfileMyDataScreenRoot(
                onCloseClick = {
                    navController.popBackStack(Route.Profile, true)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onEditProfilePictureClick = {
                    navController.navigate(Route.EditProfilePicture)
                }
            )
        }
        composable<Route.EditProfilePicture> {
            EditProfilePictureScreenRoot(
                onCloseClick = {
                    navController.popBackStack(Route.Profile, true)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable<Route.Notifications> {
            NotificationsScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable<Route.KeepsGrowing> {
            KeepsGrowingScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onSeeAllColleaguesClick = {
                    navController.navigate(Route.CelebrateYourEvolutionList)
                },
                onGrowthPathClick = {
                    navController.navigate(Route.GrowthPath)
                },
                onInnovateAndTransformClick = {
                    navController.navigate(Route.InnovateAndTransform)
                },
                onExploreMentorsClick = {
                    navController.navigate(Route.ExploreMentors)
                }
            )
        }
        composable<Route.CelebrateYourEvolutionList> {
            CelebrateYourEvolutionListScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onColleagueCardClick = {
                    navController.navigate(Route.CelebrateYourEvolutionDetail)
                }
            )
        }
        composable<Route.CelebrateYourEvolutionDetail> {
            CelebrateYourEvolutionDetailScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onColleagueCardClick = {
                    navController.navigate(Route.CelebrateYourEvolutionDetail)
                }
            )
        }
        composable<Route.GrowthPath> {
            GrowthPathScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onItemClick = {
                    navController.navigate(Route.GrowthPathDetail)
                }
            )
        }
        composable<Route.GrowthPathDetail> {
            GrowthPathDetailScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable<Route.InnovateAndTransform> {
            InnovateAndTransformScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onIdeaClick = { projectName, status ->
                    navController.navigate(Route.StatusOfMyIdea(projectName, status))
                }
            )
        }
        composable<Route.StatusOfMyIdea> { backStackEntry ->
            val statusOfMyIdea: Route.StatusOfMyIdea = backStackEntry.toRoute()
            StatusOfMyIdeaScreenRoot(
                projectName = statusOfMyIdea.projectName,
                status = statusOfMyIdea.status,
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable<Route.ExploreMentors> {
            ExploreMentorsScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onSeeAllMentorsClick = {
                    navController.navigate(Route.OurMentorsList)
                },
                onMentorCardClick = {
                    navController.navigate(Route.OurMentorsDetail)
                },
                onApplyHereClick = {
                    navController.navigate(Route.MentorApplicationForm)
                }
            )
        }
        composable<Route.OurMentorsList> {
            OurMentorsListScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onMentorCardClick = {
                    navController.navigate(Route.OurMentorsDetail)
                }
            )
        }
        composable<Route.OurMentorsDetail> {
            OurMentorsDetailScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onMentorCardClick = {
                    navController.navigate(Route.OurMentorsDetail)
                }
            )
        }
        composable<Route.MentorApplicationForm> {
            MentorApplicationFormScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                proposalSent = {
                    navController.popBackStack(Route.ExploreMentors, false)
                }
            )
        }
        composable<Route.Search> { backStackEntry ->
            val search: Route.Search = backStackEntry.toRoute()
            SearchScreenRoot(
                searchType = search.searchType,
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onSearchResultClick = {
                    when (search.searchType) {
                        SearchType.VACANCIES -> {
                            navController.navigate(Route.VacancyList(id = 0))
                        }
                        SearchType.COURSES -> {
                            navController.navigate(Route.ExploreCoursesSkillDetail)
                        }
                        SearchType.BENEFITS -> {
                            navController.navigate(Route.DiscoverBenefitsCategoryDetail)
                        }
                    }
                }
            )
        }
        composable<Route.VacancyDashboard> {
            VacancyDashboardScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onSearchForVacanciesClick = {
                    navController.navigate(Route.Search(SearchType.VACANCIES))
                },
                onMyApplicationsClick = {
                    navController.navigate(Route.MyVacancyApplications)
                },
                onNewVacanciesClick = {
                    navController.navigate(Route.NewVacancies)
                },
                onSeeAllRecommendedVacanciesClick = {
                    navController.navigate(Route.VacanciesRecommendedForYou)
                },
                onRecommendedVacancyCardClick = {
                    navController.navigate(Route.VacancyDetail)
                }
            )
        }
        composable<Route.VacancyList> {
            VacancyListScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onVacancyCardClick = {
                    navController.navigate(Route.VacancyDetail)
                }
            )
        }
        composable<Route.VacancyDetail> {
            VacancyDetailScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable<Route.MyVacancyApplications> {
            MyVacancyApplicationsScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onVacancyCardClick = {
                    navController.navigate(Route.VacancyDetail)
                }
            )
        }
        composable<Route.NewVacancies> {
            NewVacanciesScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onVacancyCardClick = {
                    navController.navigate(Route.VacancyDetail)
                }
            )
        }
        composable<Route.VacanciesRecommendedForYou> {
            VacanciesRecommendedForYouScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onVacancyCardClick = {
                    navController.navigate(Route.VacancyDetail)
                }
            )
        }
        composable<Route.EnhanceYourLearning> {
            EnhanceYourLearningScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onExploreNewCoursesClick = {
                    navController.navigate(Route.ExploreNewCourses)
                },
                onTiSmartUniversityClick = {
                    navController.navigate(Route.TiSmartUniversity)
                },
                onEducationalAgreementClick = {
                    navController.navigate(Route.EducationAgreement)
                }
            )
        }
        composable<Route.ExploreNewCourses> {
            ExploreNewCoursesScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onSearchForCoursesClick = {
                    navController.navigate(Route.Search(SearchType.COURSES))
                },
                onSkillClick = {
                    navController.navigate(Route.ExploreCoursesSkillsList(it))
                },
                onSeeAllRecommendedCoursesClick = {
                    navController.navigate(Route.ExploreCoursesRecommendedForYou)
                },
                onRecommendedCourseCardClick = {
                    navController.navigate(Route.ExploreCoursesSkillDetail)
                }
            )
        }
        composable<Route.ExploreCoursesSkillsList> { backStackEntry ->
            val skillsList: Route.ExploreCoursesSkillsList = backStackEntry.toRoute()
            ExploreCoursesSkillsListScreenRoot(
                title = skillsList.title,
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onCourseCardClick = {
                    navController.navigate(Route.ExploreCoursesSkillDetail)
                }
            )
        }
        composable<Route.ExploreCoursesSkillDetail> {
            ExploreCoursesSkillDetailScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable<Route.ExploreCoursesRecommendedForYou> {
            ExploreCoursesRecommendedForYouScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onCourseCardClick = {
                    navController.navigate(Route.ExploreCoursesSkillDetail)
                }
            )
        }
        composable<Route.TiSmartUniversity> {
            TiSmartUniversityScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onEventClick = {
                    navController.navigate(Route.EventRegistration)
                },
                onSeeAllTiSmartLoversCoursesClick = {
                    navController.navigate(Route.TiSmartLoversCourseList)
                },
                onTiSmartLoversCourseCardClick = {
                    navController.navigate(Route.TiSmartLoversCourseDetail)
                }
            )
        }
        composable<Route.TiSmartLoversCourseList> {
            TiSmartLoversCourseListScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onTiSmartLoversCourseCardClick = {
                    navController.navigate(Route.TiSmartLoversCourseDetail)
                }
            )
        }
        composable<Route.TiSmartLoversCourseDetail> {
            TiSmartLoversCourseDetailScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable<Route.EventRegistration> {
            EventRegistrationScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onEnrollMeClick = {
                    navController.navigate(Route.EventRegistrationForm)
                }
            )
        }
        composable<Route.EventRegistrationForm> {
            EventRegistrationFormScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable<Route.EducationAgreement> {
            EducationalAgreementScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onApplicationClick = { agreementName, status ->
                    navController.navigate(Route.ApplicationProgress(agreementName, status))
                }
            )
        }
        composable<Route.ApplicationProgress> { backStackEntry ->
            val applicationProgress: Route.ApplicationProgress = backStackEntry.toRoute()
            ApplicationProgressScreenRoot(
                agreementName = applicationProgress.agreementName,
                status = applicationProgress.status,
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                }
            )
        }
        composable<Route.DiscoverYourBenefits> {
            DiscoverYourBenefitsScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onSearchForBenefitsClick = {
                    navController.navigate(Route.Search(SearchType.BENEFITS))
                },
                onCategoryClick = { category ->
                    navController.navigate(Route.DiscoverBenefitsCategoryList(category))
                },
                onSeeAllNewBenefitsClick = {
                    navController.navigate(Route.DiscoverNewBenefits)
                },
                onSeeAllMyFavoriteBenefitsClick = {
                    navController.navigate(Route.DiscoverMyFavoritesBenefits)
                },
                onBenefitCardClick = {
                    navController.navigate(Route.DiscoverBenefitsCategoryDetail)
                }
            )
        }
        composable<Route.DiscoverBenefitsCategoryList> { backStackEntry ->
            val categoryList: Route.DiscoverBenefitsCategoryList = backStackEntry.toRoute()
            DiscoverBenefitsCategoryListScreenRoot(
                title = categoryList.category,
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onBenefitCardClick = {
                    navController.navigate(Route.DiscoverBenefitsCategoryDetail)
                }
            )
        }
        composable<Route.DiscoverBenefitsCategoryDetail> {
            DiscoverBenefitsCategoryDetailScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onBenefitCardClick = {
                    navController.navigate(Route.DiscoverBenefitsCategoryDetail)
                }
            )
        }
        composable<Route.DiscoverMyFavoritesBenefits> {
            DiscoverMyFavoriteBenefitsScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onBenefitCardClick = {
                    navController.navigate(Route.DiscoverBenefitsCategoryDetail)
                }
            )
        }
        composable<Route.DiscoverNewBenefits> {
            DiscoverNewBenefitsScreenRoot(
                onProfileClick = {
                    navController.navigate(Route.Profile)
                },
                onNotificationsClick = {
                    navController.navigate(Route.Notifications)
                },
                onBackClick = {
                    navController.navigateUp()
                },
                onBenefitCardClick = {
                    navController.navigate(Route.DiscoverBenefitsCategoryDetail)
                }
            )
        }
    }
}

@Composable
private inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}