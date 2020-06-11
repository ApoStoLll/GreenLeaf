package com.missclick.domain2.usecases

import com.missclick.domain2.base.Either
import com.missclick.domain2.base.Failure
import com.missclick.domain2.base.Success
import com.missclick.domain2.base.UseCase
import com.missclick.domain2.models.User

class kekUseCase : UseCase<User, Unit>(){

    override suspend fun run(params: Unit): Either<Exception, User> {
        return try{
            Success(User())
        } catch (e : java.lang.Exception){
            Failure(e)
        }
    }
}