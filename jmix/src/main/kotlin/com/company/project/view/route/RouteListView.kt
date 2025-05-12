package com.company.project.view.route

import com.company.project.entity.Tourist
import com.company.project.entity.Route as RouteClass
import com.company.project.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.model.CollectionLoader
import io.jmix.flowui.model.DataLoader
import io.jmix.flowui.view.*
import java.util.UUID


@Route(value = "routes", layout = MainView::class)
@ViewController(id = "Route.list")
@ViewDescriptor(path = "route-list-view.xml")
@LookupComponent("routesDataGrid")
@DialogMode(width = "64em")

class RouteListView : StandardListView<RouteClass>() {
    @ViewComponent
    private lateinit var routesDl: CollectionLoader<RouteClass>

    @Subscribe
    private fun onBeforeShow(event: BeforeShowEvent) {

    }

    @Subscribe
    private fun onInit(event: InitEvent) {

    }

    fun setDataLoader(query: String, parameters: Map<String, UUID?>) {
        routesDl.query = query
        routesDl.parameters = parameters
        routesDl.load()
    }
}