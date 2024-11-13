package com.freelance.category.entities;


import com.freelance.category.validations.CategoryUnique;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String categoryName;


    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<SubCategory> subCategoryList;

}
