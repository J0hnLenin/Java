package com.company.project.entity

import io.jmix.core.DeletePolicy
import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.entity.annotation.OnDeleteInverse
import io.jmix.core.metamodel.annotation.InstanceName
import io.jmix.core.metamodel.annotation.JmixEntity
import io.jmix.eclipselink.lazyloading.NotInstantiatedList
import jakarta.persistence.*
import java.util.*

@JmixEntity
@Table(name = "TOURIST", indexes = [
    Index(name = "IDX_TOURIST_CAMP", columnList = "CAMP_ID")
])
@Entity
open class Tourist {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @InstanceName
    @Column(name = "NAME")
    var name: String? = null

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DAY")
    var birthDay: Date? = null

    @OnDeleteInverse(DeletePolicy.UNLINK)
    @JoinColumn(name = "CAMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    var camp: Camp? = null

    @JoinTable(
        name = "TOURIST_ROUTE_LINK",
        joinColumns = [JoinColumn(name = "TOURIST_ID")],
        inverseJoinColumns = [JoinColumn(name = "ROUTE_ID")]
    )
    @ManyToMany
    var routes: MutableList<Route> = NotInstantiatedList()
}