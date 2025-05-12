package com.company.project.entity

import io.jmix.core.entity.annotation.JmixGeneratedValue
import io.jmix.core.metamodel.annotation.JmixEntity
import io.jmix.core.metamodel.annotation.NumberFormat
import io.jmix.eclipselink.lazyloading.NotInstantiatedList
import jakarta.persistence.*
import jakarta.validation.constraints.Positive
import java.util.*

@JmixEntity
@Table(name = "ROUTE", indexes = [
    Index(name = "IDX_ROUTE_CAMP", columnList = "CAMP_ID")
])
@Entity
open class Route {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    var id: UUID? = null

    @Column(name = "NUMBER_")
    var number: String? = null

    @Positive
    @NumberFormat(pattern = "00.00")
    @Column(name = "LENTH")
    var length: Float? = null

    @JoinTable(
        name = "TOURIST_ROUTE_LINK",
        joinColumns = [JoinColumn(name = "ROUTE_ID")],
        inverseJoinColumns = [JoinColumn(name = "TOURIST_ID")]
    )
    @ManyToMany
    var tourists: MutableList<Tourist> = NotInstantiatedList()

    @JoinColumn(name = "CAMP_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    var camp: Camp? = null

}