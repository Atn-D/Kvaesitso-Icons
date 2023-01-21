package de.kvaesitso.icons.api

import de.kvaesitso.icons.model.GitHubContributor
import retrofit2.http.GET

interface GitHubContributorsAPI {

    @GET("repos/daywalk3r666/kvaesitso-icons/contributors")
    suspend fun getContributors(): List<GitHubContributor>
}
