package com.company.project.view.route

import com.company.project.entity.Route as RouteClass
import com.company.project.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.view.*


@Route(value = "routes", layout = MainView::class)
@ViewController(id = "Route.list")
@ViewDescriptor(path = "route-list-view.xml")
@LookupComponent("routesDataGrid")
@DialogMode(width = "64em")
class RouteListView : StandardListView<RouteClass>() {
}