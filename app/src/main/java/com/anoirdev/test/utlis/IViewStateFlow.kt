package com.anoirdev.test.utlis

import com.anoirdev.test.utlis.sealed.Resource
import com.anoirdev.test.utlis.sealed.ViewState
import fr.grdf.app.android.olm.core.utils.IDispatcherProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.*

interface IViewStateFlow {

    /**
     * Cette méthode permet de jouer tous les appels aux UseCases en
     * émettant automatiquement "l'état de chargement". Par ailleurs
     * , elle capture toutes éventuelles erreurs qui ne seraient pas
     * prévues au niveau de la couche data et domain sans normalement
     * faire crasher l'application.
     *
     * @param dispatcher : Coroutine Dispatcher pour ensuite définir sur
     *     quel dispatcher exécuter le UseCase. En l'occurence
     *     tous les usecases sont exécutées sur le thread IO.
     * @param ioOperation : UseCase à lancer
     */
    @InternalCoroutinesApi
    @ExperimentalCoroutinesApi
    fun <T : Any> viewStateFlow(
        dispatcher: IDispatcherProvider,
        ioOperation: suspend () -> Flow<Resource<T>>,
    ): Flow<ViewState<T>> {
        return flow {
            emitAll(ioOperation().map {
                emit(ViewState.Loading(false))
                when (it) {
                    is Resource.OnSuccess -> ViewState.RenderSuccess(it.data)
                    is Resource.OnFailed -> ViewState.RenderFailure(it.failure)
                }
            })
            // le flowOn pour s'assurer que tous les appels aux useCases soit exécuté sur le thread IO
        }.flowOn(dispatcher.io)
            .onStart { emit(ViewState.Loading(true)) }
            .catch { exception ->
                emit(ViewState.Loading(false))
            }
    }
}