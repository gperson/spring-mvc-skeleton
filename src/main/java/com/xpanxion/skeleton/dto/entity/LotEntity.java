package com.xpanxion.skeleton.dto.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lot")
@NamedQuery(name = LotEntity.GET_LOT_QUERY, query = "from LotEntity")
public class LotEntity {

    public static final String GET_LOT_QUERY = "lot.getLot";

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "lotId")
    private Set<CarEntity> cars;

    @Id
    @Column
    private int id;

    public Set<CarEntity> getCars() {
        return this.cars;
    }

    public int getId() {
        return this.id;
    }

    public void setCars(Set<CarEntity> cars) {
        this.cars = cars;
    }

    public void setId(int id) {
        this.id = id;
    }
}