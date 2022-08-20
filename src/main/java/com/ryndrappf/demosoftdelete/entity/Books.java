package com.ryndrappf.demosoftdelete.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_books")
@SQLDelete(sql = "UPDATE tbl_books SET deleted = true WHERE id=?")
//@Where(clause = "deleted = false")
@FilterDef(name = "deletedBookFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedBookFilter", condition = "deleted = :isDeleted ")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(length = 12, nullable = false)
    private double price;

    private boolean deleted = Boolean.FALSE; //False = not deleted, TRUE = deleted


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
