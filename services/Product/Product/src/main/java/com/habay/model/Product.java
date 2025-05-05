package com.habay.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private double reservedQuantity;
    private double minimumStockLevel;
    private boolean trackInventory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductInventory> productInventory = new ArrayList<>();

    // method to update inventory
    public void updateInventory(int quantityChange, String movementType, String reference, String notes) {
        if (trackInventory) {
            this.availableQuantity += quantityChange;
            ProductInventory item = productInventory.builder()
                    .product(this)
                    .quantityChange(quantityChange)
                    .movementType(movementType)
                    .reference(reference)
                    .notes(notes)
                    .build();
            this.productInventories.add(item);
        }
    }

    // Check if stock is low
    public boolean isLowStock() {
        return trackInventory && availableQuantity <= minimumStock
}