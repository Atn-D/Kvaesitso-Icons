package app.lawnchair.lawnicons.api

import app.lawnchair.lawnicons.model.GitHubContributor
import retrofit2.http.GET

interface GitHubContributorsAPI {

    @GET("repos/daywalk3r666/kvaesitso-icons/contributors")
    suspend fun getContributors(): List<GitHubContributor>
}
