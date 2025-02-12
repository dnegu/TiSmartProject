package com.tismart.apptismart.app

import com.tismart.apptismart.features.enhance_learning.presentation.educational_agreement.RegistrationStatus
import com.tismart.apptismart.features.keeps_growing.presentation.innovate_and_transform.ProposalStatus
import com.tismart.apptismart.features.search.presentation.SearchType
import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object AuthGraph: Route

    @Serializable
    data object Login: Route

    @Serializable
    data object HomeGraph: Route

    @Serializable
    data object Home: Route

    @Serializable
    data object NewsList: Route

    @Serializable
    data object NewsDetail: Route

    @Serializable
    data object Profile: Route

    @Serializable
    data object ProfileMyData: Route

    @Serializable
    data object EditProfilePicture: Route

    @Serializable
    data object Notifications: Route

    @Serializable
    data object KeepsGrowing: Route

    @Serializable
    data object CelebrateYourEvolutionList: Route

    @Serializable
    data object CelebrateYourEvolutionDetail: Route

    @Serializable
    data object GrowthPath: Route

    @Serializable
    data object GrowthPathDetail: Route

    @Serializable
    data object InnovateAndTransform: Route

    @Serializable
    data class StatusOfMyIdea(val projectName: String, val status: ProposalStatus): Route

    @Serializable
    data object ExploreMentors: Route

    @Serializable
    data object OurMentorsList: Route

    @Serializable
    data object OurMentorsDetail: Route

    @Serializable
    data object MentorApplicationForm: Route

    @Serializable
    data class Search(val searchType: SearchType): Route

    @Serializable
    data object VacancyDashboard: Route

    @Serializable
    data class VacancyList(val id: Int): Route

    @Serializable
    data object VacancyDetail: Route

    @Serializable
    data object MyVacancyApplications: Route

    @Serializable
    data object NewVacancies: Route

    @Serializable
    data object VacanciesRecommendedForYou: Route

    @Serializable
    data object EnhanceYourLearning: Route

    @Serializable
    data object ExploreNewCourses: Route

    @Serializable
    data class ExploreCoursesSkillsList(val title: String): Route

    @Serializable
    data object ExploreCoursesSkillDetail: Route

    @Serializable
    data object ExploreCoursesRecommendedForYou: Route

    @Serializable
    data object TiSmartUniversity: Route

    @Serializable
    data object TiSmartLoversCourseList: Route

    @Serializable
    data object TiSmartLoversCourseDetail: Route

    @Serializable
    data object EventRegistration: Route

    @Serializable
    data object EventRegistrationForm: Route

    @Serializable
    data object EducationAgreement: Route

    @Serializable
    data class ApplicationProgress(val agreementName: String, val status: RegistrationStatus): Route

    @Serializable
    data object DiscoverYourBenefits: Route

    @Serializable
    data class DiscoverBenefitsCategoryList(val category: String): Route

    @Serializable
    data object DiscoverBenefitsCategoryDetail: Route

    @Serializable
    data object DiscoverMyFavoritesBenefits: Route

    @Serializable
    data object DiscoverNewBenefits: Route
}