package com.company.project.view.tourist
import com.company.project.entity.Camp
import com.company.project.entity.Tourist
import com.company.project.view.main.MainView
import com.company.project.view.route.RouteListView
import com.vaadin.flow.component.AbstractField
import com.company.project.entity.Route as RouteClass
import com.vaadin.flow.router.Route
import io.jmix.core.DataManager
import io.jmix.flowui.component.valuepicker.EntityPicker
import io.jmix.flowui.model.InstanceContainer
import io.jmix.flowui.model.InstanceLoader
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
    private lateinit var touristDl: InstanceLoader<Tourist>

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
        if (event.value != event.oldValue
            && event.oldValue != null) {
            removeAllRoutes()
        }
    }

    private fun removeAllRoutes() {
        touristDc.item.routes.removeAll(touristDc.item.routes)
        dataManager.save(touristDc.item)
        touristDl.load()
    }

}