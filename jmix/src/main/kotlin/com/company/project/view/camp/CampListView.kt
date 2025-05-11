package com.company.project.view.camp

import com.company.project.entity.Camp
import com.company.project.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.view.*


@Route(value = "camps", layout = MainView::class)
@ViewController(id = "Camp.list")
@ViewDescriptor(path = "camp-list-view.xml")
@LookupComponent("campsDataGrid")
@DialogMode(width = "64em")
class CampListView : StandardListView<Camp>() {
}