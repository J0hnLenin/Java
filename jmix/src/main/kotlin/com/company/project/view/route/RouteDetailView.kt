package com.company.project.view.route

import com.company.project.entity.Camp
import com.company.project.entity.Route as RouteClass
import com.company.project.view.main.MainView
import com.company.project.view.tourist.TouristListView
import com.vaadin.flow.component.AbstractField
import com.vaadin.flow.router.Route
import io.jmix.core.DataManager
import io.jmix.flowui.component.valuepicker.EntityPicker
import io.jmix.flowui.model.InstanceContainer
import io.jmix.flowui.model.InstanceLoader
import io.jmix.flowui.view.*
import org.springframework.beans.factory.annotation.Autowired

@Route(value = "routes/:id", layout = MainView::class)
@ViewController(id = "Route.detail")
@ViewDescriptor(path = "route-detail-view.xml")
@EditedEntityContainer("routeDc")
class RouteDetailView : StandardDetailView<RouteClass>() {
    @ViewComponent
    private lateinit var routeDc: InstanceContainer<RouteClass>

    @ViewComponent
    private lateinit var routeDl: InstanceLoader<RouteClass>

    @Autowired
    private lateinit var dataManager: DataManager

    @Install(to = "touristsDataGrid.addAction", subject = "viewConfigurer")
    private fun touristsDataGridAddActionViewConfigurer(t: StandardListView<Any>) {
        if (t is TouristListView) {
            val queryString = "select t from Tourist t where t.camp.id = :campId"
            val parameters = mapOf("campId" to routeDc.item.camp?.id)
            t.setDataLoader(queryString, parameters)
        }
    }

    @Subscribe("campField")
    private fun onCampFieldComponentValueChange(event: AbstractField.ComponentValueChangeEvent<EntityPicker<Camp>, Camp>) {
        if (event.value != event.oldValue
            && event.oldValue != null) {
            removeAllTourists()
        }
    }

    private fun removeAllTourists() {
        routeDc.item.tourists.removeAll(routeDc.item.tourists)
        dataManager.save(routeDc.item)
        routeDl.load()
    }
}