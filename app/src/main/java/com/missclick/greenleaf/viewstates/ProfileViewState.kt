package com.missclick.greenleaf.viewstates

import com.missclick.domain2.models.Post
import com.missclick.domain2.models.User

sealed class ProfileViewState{
    class ProfileLoadingFirstState : ProfileViewState()
    class ProfileLoadingNextPageState : ProfileViewState()
    class ProfileLoadedState(user : User, firstPosts : Post) : ProfileViewState()
    class NoItemState(user : User) : ProfileViewState()
    class ErrorState(message : String) : ProfileViewState()

}