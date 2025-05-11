package com.company.project.view.camp

import com.company.project.entity.Camp
import com.company.project.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.view.EditedEntityContainer
import io.jmix.flowui.view.StandardDetailView
import io.jmix.flowui.view.ViewController
import io.jmix.flowui.view.ViewDescriptor

@Route(value = "camps/:id", layout = MainView::class)
@ViewController(id = "Camp.detail")
@ViewDescriptor(path = "camp-detail-view.xml")
@EditedEntityContainer("campDc")
class CampDetailView : StandardDetailView<Camp>() {
}