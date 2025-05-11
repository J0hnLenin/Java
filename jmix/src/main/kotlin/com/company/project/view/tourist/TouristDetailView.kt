package com.company.project.view.tourist

import com.company.project.entity.Tourist
import com.company.project.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.view.EditedEntityContainer
import io.jmix.flowui.view.StandardDetailView
import io.jmix.flowui.view.ViewController
import io.jmix.flowui.view.ViewDescriptor

@Route(value = "tourists/:id", layout = MainView::class)
@ViewController(id = "Tourist.detail")
@ViewDescriptor(path = "tourist-detail-view.xml")
@EditedEntityContainer("touristDc")
class TouristDetailView : StandardDetailView<Tourist>() {
}