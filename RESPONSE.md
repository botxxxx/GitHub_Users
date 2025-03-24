# GitHub Users App - Code Explanation

## Introduction

This Android application is designed to demonstrate the retrieval and display of user data from the GitHub API. The app fetches a list of users, presents them in a `RecyclerView`, and allows users to tap on an individual user to view more detailed information. The app is built using modern Android development practices and libraries, including:

-   **MVVM Architecture:** For a clear separation of concerns between the UI, data, and business logic.
-   **Dependency Injection (Hilt):** For managing dependencies effectively and making the code more testable.
-   **Paging 3 Library (with RxJava):** For efficiently loading and displaying large lists of data in a paginated manner, improving performance and user experience.
-   **RxJava 3:** For handling asynchronous operations and data streams reactively.
-   **Navigation Component:** For managing in-app navigation between screens.
-   **Retrofit:** For making network requests to the GitHub API.
-   **Gson:** For JSON handling.
-   **View Binding:** For use view in a safe way.

## Core Features and Implementation

### 1. User List Retrieval and Display

**Goal Addressed:**

-   "Please find out how to search or retrieve users from GitHub in GitHub User API."
-   "Show users in list."
-   "Limit results to 100 users in total, or you can choose to implement pagination feature (see details in Bonus section)."
-   "In list, each row should at least show info including image from “avatar_url”, “login”, and “site_admin”."

**Implementation Details:**

-   **`UserApi` Interface:** This interface, defined using Retrofit, handles the communication with the GitHub API. It contains methods to:
    -   Fetch a list of users: `getUsers(since: Int)` for first page, and `getUsers()` for all pages.
    -   Fetch user details: `getDetail(login: String)` for single users detail.
    -    **`UserRepository`:** This class is responsible for fetching data from the network. It makes the calls to `UserApi`.
    -   It uses RxJava to use data as `Single` or `Flowable`.
    -   It has two methods, `getUsers(int since)` and `getUsers()`, to get a list of users. `getUsers(int since)` is used to fetch the first page, and `getUsers()` is used for subsequent pages.
    -   It has a method, `getDetail(String login)`, to get the details of a specific user.
    -  It has a method, `getSearchUser()` to implement paging.

-   **`UserPagingSource`:** This class extends `PagingSource` and is responsible for defining how data is loaded in pages from the GitHub API.
    -   It loads data in pages based on the `since` parameter (GitHub API's way of handling pagination).
    -   It defines how to handle the `LoadParams` and `LoadResult` objects used by the Paging library.
    -   It gets data from the `UserRepository`.

-   **`UserListViewModel`:** This ViewModel handles the logic of fetching paginated user data and exposing it to the UI.
    - It uses the `UserRepository` to get the data.
    - It use `Flowable<PagingData<UserData>>` to handle paging.
    -   It uses `PagingRx.cachedIn` to cache data.
    -   It exposes the `Flowable<PagingData<UserData>>` through a public property called `userDataFlowable`.
    - It has a function `init` to load data.
    
