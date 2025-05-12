package com.company.project.view.tourist

import com.company.project.entity.Camp
import com.company.project.entity.Tourist
import com.company.project.view.main.MainView
import com.company.project.view.route.RouteListView
import com.vaadin.flow.component.AbstractField
import com.vaadin.flow.component.AttachEvent
import com.vaadin.flow.data.provider.DataProvider
import com.vaadin.flow.data.provider.ListDataProvider

import com.company.project.entity.Route as RouteClass
import com.vaadin.flow.router.QueryParameters
import com.vaadin.flow.router.Route
import elemental.json.JsonObject
import io.jmix.core.DataManager
import io.jmix.core.ValueLoadContext
import io.jmix.flowui.component.grid.DataGrid
import io.jmix.flowui.component.valuepicker.EntityPicker
import io.jmix.flowui.kit.component.valuepicker.CustomValueSetEvent
import io.jmix.flowui.model.CollectionContainer
import io.jmix.flowui.model.DataLoader

import io.jmix.flowui.model.CollectionLoader
import io.jmix.flowui.model.InstanceContainer
import io.jmix.flowui.view.*
import org.springframework.beans.factory.annotation.Autowired

@Route(value = "tourists/:id", layout = MainView::class)
@ViewController(id = "Tourist.detail")
@ViewDescriptor(path = "tourist-detail-view.xml")
@EditedEntityContainer("touristDc")
class TouristDetailView() : StandardDetailView<Tourist>() {
    @ViewComponent
    private lateinit var touristDc: InstanceContainer<Tourist>
    @ViewComponent
    private lateinit var routesDc: CollectionContainer<RouteClass>
    @ViewComponent
    private lateinit var routesDataGrid: DataGrid<Route>

    @Autowired
    private lateinit var dataManager: DataManager

    @Install(to = "routesDataGrid.addAction", subject = "viewConfigurer")
    private fun routesDataGridAddActionViewConfigurer(t: StandardListView<RouteClass>) {
        if (t is RouteListView) {
            val queryString = "select r from Route r where r.camp.id = :campId"
            val parameters = mapOf("campId" to touristDc.item.camp?.id)
            t.setDataLoader(queryString, parameters)
        }
    }

    @Subscribe("campField")
    private fun onCampFieldComponentValueChange(event: AbstractField.ComponentValueChangeEvent<EntityPicker<Camp>, Camp>) {
        touristDc.item.routes.removeAll(touristDc.item.routes)
        dataManager.save(touristDc.item)


    }

}