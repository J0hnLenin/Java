package com.company.project.view.tourist

import com.company.project.entity.Tourist
import com.company.project.view.main.MainView
import com.vaadin.flow.router.Route
import io.jmix.flowui.view.*


@Route(value = "tourists", layout = MainView::class)
@ViewController(id = "Tourist.list")
@ViewDescriptor(path = "tourist-list-view.xml")
@LookupComponent("touristsDataGrid")
@DialogMode(width = "64em")
class TouristListView : StandardListView<Tourist>() {
}