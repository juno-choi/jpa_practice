package com.jpa.practice.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Category extends BaseEntity{
    
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    
    //셀프 조인
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    //셀프조인의 양방향 매핑
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //다대다
    //다대다에서 옵션들을 주어서 중간 CATEGORY ITEM이라는 엔티티(테이블)을 자동생성
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM", joinColumns = @JoinColumn(name="CATEGORY_ID"), inverseJoinColumns = @JoinColumn(name="ITEM_ID"))
    private List<Item> items = new ArrayList<>();
}
