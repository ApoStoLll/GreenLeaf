package com.missclick.greenleaf.interfaces

import com.missclick.greenleaf.viewstates.ProfileViewState

interface ProfileView {
    fun render(state : ProfileViewState)
}