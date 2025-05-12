package com.company.project.view.tourist

import com.company.project.entity.Tourist
import com.company.project.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.model.CollectionLoader
import io.jmix.flowui.view.*
import java.util.UUID


@Route(value = "tourists", layout = MainView::class)
@ViewController(id = "Tourist.list")
@ViewDescriptor(path = "tourist-list-view.xml")
@LookupComponent("touristsDataGrid")
@DialogMode(width = "64em")
class TouristListView : StandardListView<Tourist>() {

    @ViewComponent
    private lateinit var touristsDl: CollectionLoader<Tourist>

    fun setDataLoader(query: String, parameters: Map<String, UUID?>) {
        touristsDl.query = query
        touristsDl.parameters = parameters
        touristsDl.load()
    }
}