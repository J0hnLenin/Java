package com.company.project.view.route

import com.company.project.entity.Route as RouteClass
import com.company.project.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.view.*

@Route(value = "routes/:id", layout = MainView::class)
@ViewController(id = "Route.detail")
@ViewDescriptor(path = "route-detail-view.xml")
@EditedEntityContainer("routeDc")
class RouteDetailView : StandardDetailView<RouteClass>() {
}