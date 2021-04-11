package io.github.maa96.musicplayerlib.media.di.builder

import androidx.lifecycle.ViewModelProvider
import dagger.Module


/**
 * With this module all of ViewModels binds into generated Map<Class, ViewModel> and the map
 * will be injected in [ArchViewModelFactory]. In order to do this, we have to bind all
 * ViewModelBuilder modules in this module.
 *
 * And finally [ArchViewModelFactory] will be provided as [ViewModelProvider.Factory].
 *
 */

// TODO: 3/21/21 Add needed view models to this module later
@Module
class ViewModelBuilder {

}