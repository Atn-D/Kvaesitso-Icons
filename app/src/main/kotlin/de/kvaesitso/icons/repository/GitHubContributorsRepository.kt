package de.kvaesitso.icons.repository

import de.kvaesitso.icons.api.GitHubContributorsAPI
import javax.inject.Inject

val coreContributorIds = listOf(
    8080853,
    56888459,
)

class GitHubContributorsRepository @Inject constructor(
    private val api: GitHubContributorsAPI,
) {
    suspend fun getTopContributors() = api.getContributors()
        .filterNot { coreContributorIds.contains(it.id) }
        .sortedByDescending { it.contributions }
}
