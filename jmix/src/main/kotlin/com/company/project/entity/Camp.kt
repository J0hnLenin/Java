package com.company.project.entity

import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.metamodel.annotation.InstanceName
import io.jmix.core.metamodel.annotation.JmixEntity
import io.jmix.eclipselink.lazyloading.NotInstantiatedSet
import jakarta.persistence.*
import java.util.*

@JmixEntity
@Table(name = "CAMP")
@Entity
open class Camp {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @InstanceName
    @Column(name = "NAME")
    var name: String? = null

    @OneToMany(mappedBy = "camp")
    var tourists: MutableSet<Tourist> = NotInstantiatedSet()

    @OneToMany(mappedBy = "camp")
    var routes: MutableSet<Route> = NotInstantiatedSet()
}